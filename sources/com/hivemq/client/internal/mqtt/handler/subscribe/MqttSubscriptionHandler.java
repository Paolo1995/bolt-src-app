package com.hivemq.client.internal.mqtt.handler.subscribe;

import com.hivemq.client.internal.logging.InternalLogger;
import com.hivemq.client.internal.logging.InternalLoggerFactory;
import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttClientConnectionConfig;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.handler.MqttSessionAwareHandler;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectUtil;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlows;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttSubscribedPublishFlow;
import com.hivemq.client.internal.mqtt.message.MqttCommonReasonCode;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttStatefulSubscribe;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscribe;
import com.hivemq.client.internal.mqtt.message.subscribe.suback.MqttSubAck;
import com.hivemq.client.internal.mqtt.message.unsubscribe.MqttStatefulUnsubscribe;
import com.hivemq.client.internal.mqtt.message.unsubscribe.unsuback.MqttUnsubAck;
import com.hivemq.client.internal.mqtt.message.unsubscribe.unsuback.mqtt3.Mqtt3UnsubAckView;
import com.hivemq.client.internal.util.Ranges;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.internal.util.collections.IntIndex;
import com.hivemq.client.internal.util.collections.NodeList;
import com.hivemq.client.mqtt.MqttClientState;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5SubAckException;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.suback.Mqtt5SubAckReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.unsubscribe.unsuback.Mqtt5UnsubAckReasonCode;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.ToIntFunction;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class MqttSubscriptionHandler extends MqttSessionAwareHandler implements Runnable {

    /* renamed from: q  reason: collision with root package name */
    private static final InternalLogger f18333q = InternalLoggerFactory.a(MqttSubscriptionHandler.class);

    /* renamed from: r  reason: collision with root package name */
    private static final IntIndex.Spec<MqttSubOrUnsubWithFlow> f18334r = new IntIndex.Spec<>(new ToIntFunction() { // from class: com.hivemq.client.internal.mqtt.handler.subscribe.b
        @Override // j$.util.function.ToIntFunction
        public final int applyAsInt(Object obj) {
            int i8;
            i8 = ((MqttSubOrUnsubWithFlow) obj).f18329c;
            return i8;
        }
    }, 4);

    /* renamed from: h  reason: collision with root package name */
    private final MqttClientConfig f18335h;

    /* renamed from: i  reason: collision with root package name */
    private final MqttIncomingPublishFlows f18336i;

    /* renamed from: n  reason: collision with root package name */
    private MqttSubOrUnsubWithFlow f18341n;

    /* renamed from: o  reason: collision with root package name */
    private MqttSubOrUnsubWithFlow f18342o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f18343p;

    /* renamed from: j  reason: collision with root package name */
    private final NodeList<MqttSubOrUnsubWithFlow> f18337j = new NodeList<>();

    /* renamed from: l  reason: collision with root package name */
    private int f18339l = 1;

    /* renamed from: m  reason: collision with root package name */
    private final IntIndex<MqttSubOrUnsubWithFlow> f18340m = new IntIndex<>(f18334r);

    /* renamed from: k  reason: collision with root package name */
    private final Ranges f18338k = new Ranges(65526, Settings.DEFAULT_INITIAL_WINDOW_SIZE);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MqttSubscriptionHandler(MqttClientConfig mqttClientConfig, MqttIncomingPublishFlows mqttIncomingPublishFlows) {
        this.f18335h = mqttClientConfig;
        this.f18336i = mqttIncomingPublishFlows;
    }

    private void j(MqttSubOrUnsubWithFlow mqttSubOrUnsubWithFlow) {
        this.f18337j.g(mqttSubOrUnsubWithFlow);
        this.f18338k.d(mqttSubOrUnsubWithFlow.f18329c);
        run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Integer num, List list) {
        this.f18337j.b(new MqttSubscribeWithFlow(new MqttSubscribe(com.hivemq.client.internal.util.collections.b.x(list), MqttUserPropertiesImpl.f17992c), num.intValue(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(MqttSubscriptionFlow mqttSubscriptionFlow, MqttSubscribe mqttSubscribe) {
        MqttSubscribedPublishFlow mqttSubscribedPublishFlow;
        if (mqttSubscriptionFlow.init()) {
            int i8 = this.f18339l;
            this.f18339l = i8 + 1;
            MqttIncomingPublishFlows mqttIncomingPublishFlows = this.f18336i;
            if (mqttSubscriptionFlow instanceof MqttSubscribedPublishFlow) {
                mqttSubscribedPublishFlow = (MqttSubscribedPublishFlow) mqttSubscriptionFlow;
            } else {
                mqttSubscribedPublishFlow = null;
            }
            mqttIncomingPublishFlows.h(mqttSubscribe, i8, mqttSubscribedPublishFlow);
            n(new MqttSubscribeWithFlow(mqttSubscribe, i8, mqttSubscriptionFlow));
        }
    }

    private void n(MqttSubOrUnsubWithFlow mqttSubOrUnsubWithFlow) {
        this.f18337j.a(mqttSubOrUnsubWithFlow);
        if (this.f18341n == null) {
            this.f18341n = mqttSubOrUnsubWithFlow;
            run();
        }
    }

    private void o(ChannelHandlerContext channelHandlerContext, MqttSubAck mqttSubAck) {
        boolean z7;
        String str;
        MqttSubOrUnsubWithFlow j8 = this.f18340m.j(mqttSubAck.a());
        if (j8 == null) {
            MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "Unknown packet identifier for SUBACK");
        } else if (!(j8 instanceof MqttSubscribeWithFlow)) {
            MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "SUBACK received for an UNSUBSCRIBE");
        } else {
            MqttSubscribeWithFlow mqttSubscribeWithFlow = (MqttSubscribeWithFlow) j8;
            MqttSubscriptionFlow<MqttSubAck> c8 = mqttSubscribeWithFlow.c();
            ImmutableList<Mqtt5SubAckReasonCode> h8 = mqttSubAck.h();
            if (mqttSubscribeWithFlow.f18330d.g().size() != h8.size()) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean c9 = MqttCommonReasonCode.c(mqttSubAck.h());
            this.f18336i.g(mqttSubscribeWithFlow.f18330d, mqttSubscribeWithFlow.f18331e, h8);
            if (c8 != null) {
                if (!z7 && !c9) {
                    if (!c8.isCancelled()) {
                        c8.onSuccess(mqttSubAck);
                    } else {
                        f18333q.warn("Subscribe was successful but the SubAck flow has been cancelled");
                    }
                } else {
                    if (z7) {
                        str = "Count of Reason Codes in SUBACK does not match count of subscriptions in SUBSCRIBE";
                    } else {
                        str = "SUBACK contains only Error Codes";
                    }
                    if (!c8.isCancelled()) {
                        c8.onError(new Mqtt5SubAckException(mqttSubAck, str));
                    } else {
                        InternalLogger internalLogger = f18333q;
                        internalLogger.warn(str + " but the SubAck flow has been cancelled");
                    }
                }
            }
            j(mqttSubscribeWithFlow);
        }
    }

    private void p(ChannelHandlerContext channelHandlerContext, MqttUnsubAck mqttUnsubAck) {
        boolean z7;
        MqttSubOrUnsubWithFlow j8 = this.f18340m.j(mqttUnsubAck.a());
        if (j8 == null) {
            MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "Unknown packet identifier for UNSUBACK");
        } else if (!(j8 instanceof MqttUnsubscribeWithFlow)) {
            MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "UNSUBACK received for a SUBSCRIBE");
        } else {
            MqttUnsubscribeWithFlow mqttUnsubscribeWithFlow = (MqttUnsubscribeWithFlow) j8;
            mqttUnsubscribeWithFlow.d();
            ImmutableList<Mqtt5UnsubAckReasonCode> h8 = mqttUnsubAck.h();
            if (mqttUnsubscribeWithFlow.f18346d.g().size() != h8.size()) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean c8 = MqttCommonReasonCode.c(mqttUnsubAck.h());
            if (h8 != Mqtt3UnsubAckView.f18620a && (z7 || c8)) {
                throw null;
            }
            this.f18336i.i(mqttUnsubscribeWithFlow.f18346d, h8);
            throw null;
        }
    }

    private void r(ChannelHandlerContext channelHandlerContext, MqttSubscribeWithFlow mqttSubscribeWithFlow) {
        int i8;
        if (this.f18343p) {
            i8 = mqttSubscribeWithFlow.f18331e;
        } else {
            i8 = -1;
        }
        MqttStatefulSubscribe f8 = mqttSubscribeWithFlow.f18330d.f(mqttSubscribeWithFlow.f18329c, i8);
        this.f18342o = mqttSubscribeWithFlow;
        channelHandlerContext.write(f8, channelHandlerContext.voidPromise());
        this.f18342o = null;
    }

    private void s(ChannelHandlerContext channelHandlerContext, MqttUnsubscribeWithFlow mqttUnsubscribeWithFlow) {
        MqttStatefulUnsubscribe f8 = mqttUnsubscribeWithFlow.f18346d.f(mqttUnsubscribeWithFlow.f18329c);
        this.f18342o = mqttUnsubscribeWithFlow;
        channelHandlerContext.write(f8, channelHandlerContext.voidPromise());
        this.f18342o = null;
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttSessionAwareHandler
    public void b(Throwable th) {
        int i8;
        super.b(th);
        this.f18340m.e();
        this.f18341n = null;
        MqttSubOrUnsubWithFlow d8 = this.f18337j.d();
        while (true) {
            MqttSubOrUnsubWithFlow mqttSubOrUnsubWithFlow = d8;
            if (mqttSubOrUnsubWithFlow == null || (i8 = mqttSubOrUnsubWithFlow.f18329c) == 0) {
                break;
            }
            this.f18338k.d(i8);
            mqttSubOrUnsubWithFlow.f18329c = 0;
            d8 = mqttSubOrUnsubWithFlow.a();
        }
        if (this.f18335h.q() && this.f18335h.getState() != MqttClientState.DISCONNECTED) {
            return;
        }
        this.f18336i.d(th);
        MqttSubOrUnsubWithFlow d9 = this.f18337j.d();
        while (true) {
            MqttSubOrUnsubWithFlow mqttSubOrUnsubWithFlow2 = d9;
            if (mqttSubOrUnsubWithFlow2 != null) {
                MqttSubscriptionFlow<?> c8 = mqttSubOrUnsubWithFlow2.c();
                if (c8 != null) {
                    c8.onError(th);
                }
                d9 = mqttSubOrUnsubWithFlow2.a();
            } else {
                this.f18337j.c();
                this.f18339l = 1;
                return;
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof MqttSubAck) {
            o(channelHandlerContext, (MqttSubAck) obj);
        } else if (obj instanceof MqttUnsubAck) {
            p(channelHandlerContext, (MqttUnsubAck) obj);
        } else {
            channelHandlerContext.fireChannelRead(obj);
        }
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttSessionAwareHandler
    public void d(MqttClientConnectionConfig mqttClientConnectionConfig, EventLoop eventLoop) {
        this.f18343p = mqttClientConnectionConfig.a();
        if (!this.f18026g) {
            Map.EL.forEach(this.f18336i.f(), new BiConsumer() { // from class: com.hivemq.client.internal.mqtt.handler.subscribe.c
                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    MqttSubscriptionHandler.this.k((Integer) obj, (List) obj2);
                }

                @Override // j$.util.function.BiConsumer
                public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer.CC.$default$andThen(this, biConsumer);
                }
            });
        }
        this.f18340m.e();
        MqttSubOrUnsubWithFlow d8 = this.f18337j.d();
        this.f18341n = d8;
        if (d8 != null) {
            eventLoop.execute(this);
        }
        super.d(mqttClientConnectionConfig, eventLoop);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        MqttSubOrUnsubWithFlow mqttSubOrUnsubWithFlow;
        if (!(th instanceof IOException) && (mqttSubOrUnsubWithFlow = this.f18342o) != null) {
            this.f18337j.g(mqttSubOrUnsubWithFlow);
            this.f18338k.d(this.f18342o.f18329c);
            this.f18340m.j(this.f18342o.f18329c);
            MqttSubscriptionFlow<?> c8 = this.f18342o.c();
            if (c8 != null) {
                c8.onError(th);
            }
            MqttSubOrUnsubWithFlow mqttSubOrUnsubWithFlow2 = this.f18342o;
            if (mqttSubOrUnsubWithFlow2 instanceof MqttSubscribeWithFlow) {
                MqttSubscribeWithFlow mqttSubscribeWithFlow = (MqttSubscribeWithFlow) mqttSubOrUnsubWithFlow2;
                this.f18336i.g(mqttSubscribeWithFlow.f18330d, mqttSubscribeWithFlow.f18331e, com.hivemq.client.internal.util.collections.b.A(Mqtt5SubAckReasonCode.UNSPECIFIED_ERROR));
            }
            this.f18342o = null;
            return;
        }
        channelHandlerContext.fireExceptionCaught(th);
    }

    public void q(final MqttSubscribe mqttSubscribe, final MqttSubscriptionFlow<MqttSubAck> mqttSubscriptionFlow) {
        mqttSubscriptionFlow.d().execute(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.subscribe.a
            @Override // java.lang.Runnable
            public final void run() {
                MqttSubscriptionHandler.this.m(mqttSubscriptionFlow, mqttSubscribe);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubOrUnsubWithFlow] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubOrUnsubWithFlow] */
    @Override // java.lang.Runnable
    public void run() {
        ChannelHandlerContext channelHandlerContext = this.f18020f;
        if (channelHandlerContext == null) {
            return;
        }
        int i8 = 0;
        MqttUnsubscribeWithFlow mqttUnsubscribeWithFlow = this.f18341n;
        while (mqttUnsubscribeWithFlow != null && this.f18340m.m() < 10) {
            if (mqttUnsubscribeWithFlow.f18329c == 0) {
                int a8 = this.f18338k.a();
                if (a8 == -1) {
                    f18333q.error("No Packet Identifier available for (UN)SUBSCRIBE. This must not happen and is a bug.");
                    return;
                }
                mqttUnsubscribeWithFlow.f18329c = a8;
            }
            this.f18340m.g(mqttUnsubscribeWithFlow);
            if (this.f18341n instanceof MqttSubscribeWithFlow) {
                r(channelHandlerContext, (MqttSubscribeWithFlow) mqttUnsubscribeWithFlow);
            } else {
                s(channelHandlerContext, mqttUnsubscribeWithFlow);
            }
            i8++;
            MqttSubOrUnsubWithFlow a9 = mqttUnsubscribeWithFlow.a();
            this.f18341n = a9;
            mqttUnsubscribeWithFlow = a9;
        }
        if (i8 > 0) {
            channelHandlerContext.flush();
        }
    }
}
