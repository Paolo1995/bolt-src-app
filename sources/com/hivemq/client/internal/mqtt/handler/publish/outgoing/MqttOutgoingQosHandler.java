package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.logging.InternalLogger;
import com.hivemq.client.internal.logging.InternalLoggerFactory;
import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttClientConnectionConfig;
import com.hivemq.client.internal.mqtt.exceptions.MqttClientStateExceptions;
import com.hivemq.client.internal.mqtt.handler.MqttSessionAwareHandler;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectUtil;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttPubRelWithFlow;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult;
import com.hivemq.client.internal.mqtt.message.publish.MqttStatefulPublish;
import com.hivemq.client.internal.mqtt.message.publish.puback.MqttPubAck;
import com.hivemq.client.internal.mqtt.message.publish.pubcomp.MqttPubComp;
import com.hivemq.client.internal.mqtt.message.publish.pubrec.MqttPubRec;
import com.hivemq.client.internal.mqtt.message.publish.pubrel.MqttPubRel;
import com.hivemq.client.internal.mqtt.message.publish.pubrel.MqttPubRelBuilder;
import com.hivemq.client.internal.netty.ContextFuture;
import com.hivemq.client.internal.netty.DefaultContextPromise;
import com.hivemq.client.internal.util.Ranges;
import com.hivemq.client.internal.util.collections.IntIndex;
import com.hivemq.client.internal.util.collections.NodeList;
import com.hivemq.client.mqtt.MqttClientState;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.exceptions.ConnectionClosedException;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5PubAckException;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5PubRecException;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.publish.puback.Mqtt5PubAckReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubrec.Mqtt5PubRecReasonCode;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import j$.util.function.ToIntFunction;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import org.jctools.queues.SpscUnboundedArrayQueue;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public class MqttOutgoingQosHandler extends MqttSessionAwareHandler implements FlowableSubscriber<MqttPublishWithFlow>, Runnable, GenericFutureListener {

    /* renamed from: u  reason: collision with root package name */
    private static final InternalLogger f18274u = InternalLoggerFactory.a(MqttOutgoingQosHandler.class);

    /* renamed from: v  reason: collision with root package name */
    private static final IntIndex.Spec<MqttPubOrRelWithFlow> f18275v = new IntIndex.Spec<>(new ToIntFunction() { // from class: com.hivemq.client.internal.mqtt.handler.publish.outgoing.a
        @Override // j$.util.function.ToIntFunction
        public final int applyAsInt(Object obj) {
            int i8;
            i8 = ((MqttPubOrRelWithFlow) obj).f18291d;
            return i8;
        }
    });

    /* renamed from: h  reason: collision with root package name */
    private final MqttClientConfig f18276h;

    /* renamed from: o  reason: collision with root package name */
    private MqttPubOrRelWithFlow f18283o;

    /* renamed from: p  reason: collision with root package name */
    private MqttPublishWithFlow f18284p;

    /* renamed from: q  reason: collision with root package name */
    private int f18285q;

    /* renamed from: r  reason: collision with root package name */
    private MqttTopicAliasMapping f18286r;

    /* renamed from: s  reason: collision with root package name */
    private Subscription f18287s;

    /* renamed from: t  reason: collision with root package name */
    private int f18288t;

    /* renamed from: j  reason: collision with root package name */
    private final SpscUnboundedArrayQueue<MqttPublishWithFlow> f18278j = new SpscUnboundedArrayQueue<>(32);

    /* renamed from: k  reason: collision with root package name */
    private final AtomicInteger f18279k = new AtomicInteger();

    /* renamed from: l  reason: collision with root package name */
    private final NodeList<MqttPubOrRelWithFlow> f18280l = new NodeList<>();

    /* renamed from: m  reason: collision with root package name */
    private final Ranges f18281m = new Ranges(1, 0);

    /* renamed from: n  reason: collision with root package name */
    private final IntIndex<MqttPubOrRelWithFlow> f18282n = new IntIndex<>(f18275v);

    /* renamed from: i  reason: collision with root package name */
    private final MqttPublishFlowables f18277i = new MqttPublishFlowables();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MqttOutgoingQosHandler(MqttClientConfig mqttClientConfig) {
        this.f18276h = mqttClientConfig;
    }

    private void A(ChannelHandlerContext channelHandlerContext, MqttPubOrRelWithFlow mqttPubOrRelWithFlow) {
        this.f18282n.g(mqttPubOrRelWithFlow);
        if (mqttPubOrRelWithFlow instanceof MqttPublishWithFlow) {
            MqttPublishWithFlow mqttPublishWithFlow = (MqttPublishWithFlow) mqttPubOrRelWithFlow;
            F(channelHandlerContext, mqttPublishWithFlow.d().h(mqttPublishWithFlow.f18291d, true, this.f18286r), mqttPublishWithFlow);
            return;
        }
        B(channelHandlerContext, ((MqttPubRelWithFlow) mqttPubOrRelWithFlow).d());
    }

    private void B(ChannelHandlerContext channelHandlerContext, MqttPubRel mqttPubRel) {
        channelHandlerContext.write(mqttPubRel, channelHandlerContext.voidPromise());
    }

    private void C(ChannelHandlerContext channelHandlerContext, MqttPublishWithFlow mqttPublishWithFlow) {
        if (mqttPublishWithFlow.d().j() == MqttQos.AT_MOST_ONCE) {
            D(channelHandlerContext, mqttPublishWithFlow);
        } else {
            E(channelHandlerContext, mqttPublishWithFlow);
        }
    }

    private void D(ChannelHandlerContext channelHandlerContext, MqttPublishWithFlow mqttPublishWithFlow) {
        channelHandlerContext.write(mqttPublishWithFlow.d().h(-1, false, this.f18286r), new DefaultContextPromise(channelHandlerContext.channel(), mqttPublishWithFlow)).addListener((GenericFutureListener<? extends Future<? super Void>>) this);
    }

    private void E(ChannelHandlerContext channelHandlerContext, MqttPublishWithFlow mqttPublishWithFlow) {
        int a8 = this.f18281m.a();
        if (a8 < 0) {
            f18274u.error("No Packet Identifier available for QoS 1 or 2 PUBLISH. This must not happen and is a bug.");
            return;
        }
        mqttPublishWithFlow.f18291d = a8;
        this.f18282n.g(mqttPublishWithFlow);
        this.f18280l.a(mqttPublishWithFlow);
        F(channelHandlerContext, mqttPublishWithFlow.d().h(a8, false, this.f18286r), mqttPublishWithFlow);
    }

    private void F(ChannelHandlerContext channelHandlerContext, MqttStatefulPublish mqttStatefulPublish, MqttPublishWithFlow mqttPublishWithFlow) {
        this.f18284p = mqttPublishWithFlow;
        channelHandlerContext.write(mqttStatefulPublish, channelHandlerContext.voidPromise());
        this.f18284p = null;
    }

    private MqttPubRel i(MqttPublish mqttPublish, MqttPubRec mqttPubRec) {
        MqttPubRelBuilder mqttPubRelBuilder = new MqttPubRelBuilder(mqttPubRec);
        this.f18276h.d().a();
        return mqttPubRelBuilder.a();
    }

    private void j(Throwable th) {
        int i8;
        do {
            i8 = 0;
            while (true) {
                MqttPublishWithFlow mqttPublishWithFlow = (MqttPublishWithFlow) this.f18278j.poll();
                if (mqttPublishWithFlow == null) {
                    break;
                }
                mqttPublishWithFlow.c().i(new MqttPublishResult(mqttPublishWithFlow.d(), th));
                i8++;
            }
        } while (this.f18279k.addAndGet(-i8) != 0);
    }

    private void k(ChannelHandlerContext channelHandlerContext, MqttPubOrRelWithFlow mqttPubOrRelWithFlow) {
        this.f18280l.g(mqttPubOrRelWithFlow);
        int i8 = mqttPubOrRelWithFlow.f18291d;
        this.f18281m.d(i8);
        int i9 = this.f18285q;
        if (i8 > i9) {
            this.f18281m.b(i9);
        }
        if (this.f18283o != null) {
            channelHandlerContext.channel().eventLoop().execute(this);
        }
    }

    private static void l(ChannelHandlerContext channelHandlerContext, String str) {
        MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, str);
    }

    private boolean n() {
        if (this.f18276h.p() && this.f18276h.getState() != MqttClientState.DISCONNECTED) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Publisher o(Flowable flowable) throws Exception {
        return flowable;
    }

    private void r(MqttPublish mqttPublish, MqttPubAck mqttPubAck) {
        this.f18276h.d().a();
    }

    private void s(MqttPubRel mqttPubRel, MqttPubComp mqttPubComp) {
        this.f18276h.d().a();
    }

    private void t(MqttPublish mqttPublish, MqttPubRec mqttPubRec) {
        this.f18276h.d().a();
    }

    private void v(ChannelHandlerContext channelHandlerContext, MqttPubAck mqttPubAck) {
        Mqtt5PubAckException mqtt5PubAckException;
        MqttPubOrRelWithFlow j8 = this.f18282n.j(mqttPubAck.a());
        if (j8 == null) {
            l(channelHandlerContext, "PUBACK contained unknown packet identifier");
        } else if (!(j8 instanceof MqttPublishWithFlow)) {
            this.f18282n.g(j8);
            l(channelHandlerContext, "PUBACK must not be received for a PUBREL");
        } else {
            MqttPublishWithFlow mqttPublishWithFlow = (MqttPublishWithFlow) j8;
            MqttPublish d8 = mqttPublishWithFlow.d();
            if (d8.j() != MqttQos.AT_LEAST_ONCE) {
                this.f18282n.g(j8);
                l(channelHandlerContext, "PUBACK must not be received for a QoS 2 PUBLISH");
                return;
            }
            k(channelHandlerContext, mqttPublishWithFlow);
            r(d8, mqttPubAck);
            if (((Mqtt5PubAckReasonCode) mqttPubAck.h()).a()) {
                mqtt5PubAckException = new Mqtt5PubAckException(mqttPubAck, "PUBACK contained an Error Code");
            } else {
                mqtt5PubAckException = null;
            }
            mqttPublishWithFlow.c().i(new MqttPublishResult.MqttQos1Result(d8, mqtt5PubAckException, mqttPubAck));
        }
    }

    private void w(ChannelHandlerContext channelHandlerContext, MqttPubComp mqttPubComp) {
        MqttPubOrRelWithFlow j8 = this.f18282n.j(mqttPubComp.a());
        if (j8 == null) {
            l(channelHandlerContext, "PUBCOMP contained unknown packet identifier");
        } else if (!(j8 instanceof MqttPubRelWithFlow)) {
            this.f18282n.g(j8);
            if (((MqttPublishWithFlow) j8).d().j() == MqttQos.AT_LEAST_ONCE) {
                l(channelHandlerContext, "PUBCOMP must not be received for a QoS 1 PUBLISH");
            } else {
                l(channelHandlerContext, "PUBCOMP must not be received when the PUBREL has not been sent yet");
            }
        } else {
            MqttPubRelWithFlow mqttPubRelWithFlow = (MqttPubRelWithFlow) j8;
            MqttPubRel d8 = mqttPubRelWithFlow.d();
            MqttAckFlow c8 = mqttPubRelWithFlow.c();
            k(channelHandlerContext, mqttPubRelWithFlow);
            s(d8, mqttPubComp);
            if (((MqttPubRelWithFlow.MqttQos2IntermediateWithFlow) mqttPubRelWithFlow).getAsBoolean()) {
                c8.h(1L);
            }
        }
    }

    private void x(ChannelHandlerContext channelHandlerContext, MqttPubRec mqttPubRec) {
        int a8 = mqttPubRec.a();
        MqttPubOrRelWithFlow f8 = this.f18282n.f(a8);
        if (f8 == null) {
            l(channelHandlerContext, "PUBREC contained unknown packet identifier");
        } else if (!(f8 instanceof MqttPublishWithFlow)) {
            l(channelHandlerContext, "PUBREC must not be received when the PUBREL has already been sent");
        } else {
            MqttPublishWithFlow mqttPublishWithFlow = (MqttPublishWithFlow) f8;
            MqttPublish d8 = mqttPublishWithFlow.d();
            if (d8.j() != MqttQos.EXACTLY_ONCE) {
                l(channelHandlerContext, "PUBREC must not be received for a QoS 1 PUBLISH");
                return;
            }
            MqttAckFlow c8 = mqttPublishWithFlow.c();
            if (((Mqtt5PubRecReasonCode) mqttPubRec.h()).a()) {
                this.f18282n.j(a8);
                k(channelHandlerContext, mqttPublishWithFlow);
                t(d8, mqttPubRec);
                c8.i(new MqttPublishResult.MqttQos2Result(d8, new Mqtt5PubRecException(mqttPubRec, "PUBREC contained an Error Code"), mqttPubRec));
                return;
            }
            MqttPubRel i8 = i(d8, mqttPubRec);
            MqttPubRelWithFlow.MqttQos2IntermediateWithFlow mqttQos2IntermediateWithFlow = new MqttPubRelWithFlow.MqttQos2IntermediateWithFlow(i8, c8);
            y(mqttPublishWithFlow, mqttQos2IntermediateWithFlow);
            c8.i(new MqttPublishResult.MqttQos2IntermediateResult(d8, mqttPubRec, mqttQos2IntermediateWithFlow));
            B(channelHandlerContext, i8);
            channelHandlerContext.flush();
        }
    }

    private void y(MqttPublishWithFlow mqttPublishWithFlow, MqttPubRelWithFlow mqttPubRelWithFlow) {
        mqttPubRelWithFlow.f18291d = mqttPublishWithFlow.f18291d;
        this.f18282n.g(mqttPubRelWithFlow);
        this.f18280l.h(mqttPublishWithFlow, mqttPubRelWithFlow);
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttSessionAwareHandler
    public void b(Throwable th) {
        super.b(th);
        this.f18282n.e();
        this.f18283o = null;
        if (n()) {
            return;
        }
        MqttPubOrRelWithFlow d8 = this.f18280l.d();
        while (true) {
            MqttPubOrRelWithFlow mqttPubOrRelWithFlow = d8;
            if (mqttPubOrRelWithFlow != null) {
                this.f18281m.d(mqttPubOrRelWithFlow.f18291d);
                if (mqttPubOrRelWithFlow instanceof MqttPublishWithFlow) {
                    mqttPubOrRelWithFlow.c().i(new MqttPublishResult(((MqttPublishWithFlow) mqttPubOrRelWithFlow).d(), th));
                } else {
                    MqttPubRelWithFlow.MqttQos2IntermediateWithFlow mqttQos2IntermediateWithFlow = (MqttPubRelWithFlow.MqttQos2IntermediateWithFlow) mqttPubOrRelWithFlow;
                    if (mqttQos2IntermediateWithFlow.getAsBoolean()) {
                        mqttQos2IntermediateWithFlow.c().h(1L);
                    }
                }
                d8 = mqttPubOrRelWithFlow.a();
            } else {
                this.f18280l.c();
                j(th);
                return;
            }
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void c(Subscription subscription) {
        this.f18287s = subscription;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof MqttPubAck) {
            v(channelHandlerContext, (MqttPubAck) obj);
        } else if (obj instanceof MqttPubRec) {
            x(channelHandlerContext, (MqttPubRec) obj);
        } else if (obj instanceof MqttPubComp) {
            w(channelHandlerContext, (MqttPubComp) obj);
        } else {
            channelHandlerContext.fireChannelRead(obj);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
        Channel channel = channelHandlerContext.channel();
        if (channel.isWritable()) {
            channel.eventLoop().execute(this);
        }
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttSessionAwareHandler
    public void d(MqttClientConnectionConfig mqttClientConnectionConfig, EventLoop eventLoop) {
        int i8 = this.f18285q;
        int min = Math.min(mqttClientConnectionConfig.g(), 65525);
        this.f18285q = min;
        this.f18281m.b(min);
        if (i8 == 0) {
            this.f18277i.y(new Function() { // from class: com.hivemq.client.internal.mqtt.handler.publish.outgoing.b
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher o8;
                    o8 = MqttOutgoingQosHandler.o((Flowable) obj);
                    return o8;
                }
            }, true, 64, Math.min(min, Flowable.b())).Y(this);
            this.f18287s.f(min);
        } else {
            int i9 = (min - i8) - this.f18288t;
            if (i9 > 0) {
                this.f18288t = 0;
                this.f18287s.f(i9);
            } else {
                this.f18288t = -i9;
            }
        }
        this.f18286r = mqttClientConnectionConfig.i();
        this.f18282n.e();
        MqttPubOrRelWithFlow d8 = this.f18280l.d();
        this.f18283o = d8;
        if (d8 != null || this.f18279k.get() > 0) {
            eventLoop.execute(this);
        }
        super.d(mqttClientConnectionConfig, eventLoop);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        MqttPublishWithFlow mqttPublishWithFlow;
        if (!(th instanceof IOException) && (mqttPublishWithFlow = this.f18284p) != null) {
            this.f18282n.j(mqttPublishWithFlow.f18291d);
            this.f18284p.c().i(new MqttPublishResult(this.f18284p.d(), th));
            k(channelHandlerContext, this.f18284p);
            this.f18284p = null;
            return;
        }
        channelHandlerContext.fireExceptionCaught(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttPublishFlowables m() {
        return this.f18277i;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        f18274u.error("MqttPublishFlowables is global and must never complete. This must not happen and is a bug.");
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        f18274u.error("MqttPublishFlowables is global and must never error. This must not happen and is a bug.", th);
    }

    @Override // org.reactivestreams.Subscriber
    /* renamed from: q */
    public void onNext(MqttPublishWithFlow mqttPublishWithFlow) {
        this.f18278j.offer(mqttPublishWithFlow);
        if (this.f18279k.getAndIncrement() == 0) {
            mqttPublishWithFlow.c().d().execute(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f18026g) {
            if (!n()) {
                j(MqttClientStateExceptions.b());
                return;
            }
            return;
        }
        ChannelHandlerContext channelHandlerContext = this.f18020f;
        if (channelHandlerContext == null) {
            return;
        }
        Channel channel = channelHandlerContext.channel();
        int m8 = this.f18285q - this.f18282n.m();
        MqttPubOrRelWithFlow mqttPubOrRelWithFlow = this.f18283o;
        int i8 = 0;
        int i9 = 0;
        while (mqttPubOrRelWithFlow != null && i9 < m8 && channel.isWritable()) {
            A(channelHandlerContext, mqttPubOrRelWithFlow);
            i9++;
            mqttPubOrRelWithFlow = mqttPubOrRelWithFlow.a();
            this.f18283o = mqttPubOrRelWithFlow;
        }
        while (i9 < m8 && channel.isWritable()) {
            MqttPublishWithFlow mqttPublishWithFlow = (MqttPublishWithFlow) this.f18278j.poll();
            if (mqttPublishWithFlow == null) {
                break;
            }
            C(channelHandlerContext, mqttPublishWithFlow);
            i9++;
            i8++;
        }
        if (i9 > 0) {
            boolean isWritable = channel.isWritable();
            channelHandlerContext.flush();
            if (i8 > 0 && this.f18279k.addAndGet(-i8) > 0 && isWritable) {
                channel.eventLoop().execute(this);
            }
        }
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    /* renamed from: u */
    public void operationComplete(ContextFuture<? extends MqttPublishWithFlow> contextFuture) {
        MqttPublishWithFlow context = contextFuture.getContext();
        MqttPublish d8 = context.d();
        MqttAckFlow c8 = context.c();
        Throwable cause = contextFuture.cause();
        if (!(cause instanceof IOException)) {
            c8.i(new MqttPublishResult(d8, cause));
            return;
        }
        c8.i(new MqttPublishResult(d8, new ConnectionClosedException(cause)));
        contextFuture.channel().pipeline().fireExceptionCaught(cause);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(long j8) {
        int i8 = this.f18288t;
        if (i8 == 0) {
            this.f18287s.f(j8);
            return;
        }
        long j9 = i8;
        if (j8 > j9) {
            this.f18288t = 0;
            this.f18287s.f(j8 - j9);
            return;
        }
        this.f18288t = (int) (i8 - j8);
    }
}
