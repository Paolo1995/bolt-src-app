package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.logging.InternalLogger;
import com.hivemq.client.internal.logging.InternalLoggerFactory;
import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttClientConnectionConfig;
import com.hivemq.client.internal.mqtt.handler.MqttSessionAwareHandler;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectUtil;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.publish.MqttStatefulPublish;
import com.hivemq.client.internal.mqtt.message.publish.puback.MqttPubAck;
import com.hivemq.client.internal.mqtt.message.publish.puback.MqttPubAckBuilder;
import com.hivemq.client.internal.mqtt.message.publish.pubcomp.MqttPubComp;
import com.hivemq.client.internal.mqtt.message.publish.pubcomp.MqttPubCompBuilder;
import com.hivemq.client.internal.mqtt.message.publish.pubrec.MqttPubRec;
import com.hivemq.client.internal.mqtt.message.publish.pubrec.MqttPubRecBuilder;
import com.hivemq.client.internal.mqtt.message.publish.pubrel.MqttPubRel;
import com.hivemq.client.internal.util.collections.IntIndex;
import com.hivemq.client.mqtt.MqttVersion;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubcomp.Mqtt5PubCompReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubrec.Mqtt5PubRecReasonCode;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import j$.util.function.ToIntFunction;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class MqttIncomingQosHandler extends MqttSessionAwareHandler {

    /* renamed from: m  reason: collision with root package name */
    private static final InternalLogger f18218m = InternalLoggerFactory.a(MqttIncomingQosHandler.class);

    /* renamed from: n  reason: collision with root package name */
    private static final IntIndex.Spec<Object> f18219n = new IntIndex.Spec<>(new ToIntFunction() { // from class: com.hivemq.client.internal.mqtt.handler.publish.incoming.b
        @Override // j$.util.function.ToIntFunction
        public final int applyAsInt(Object obj) {
            int n8;
            n8 = MqttIncomingQosHandler.n(obj);
            return n8;
        }
    });

    /* renamed from: h  reason: collision with root package name */
    private final MqttClientConfig f18220h;

    /* renamed from: i  reason: collision with root package name */
    final MqttIncomingPublishService f18221i;

    /* renamed from: j  reason: collision with root package name */
    private final IntIndex<Object> f18222j = new IntIndex<>(f18219n);

    /* renamed from: k  reason: collision with root package name */
    private int f18223k;

    /* renamed from: l  reason: collision with root package name */
    private long f18224l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingQosHandler$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18225a;

        static {
            int[] iArr = new int[MqttQos.values().length];
            f18225a = iArr;
            try {
                iArr[MqttQos.AT_MOST_ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18225a[MqttQos.AT_LEAST_ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18225a[MqttQos.EXACTLY_ONCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MqttIncomingQosHandler(MqttClientConfig mqttClientConfig, MqttIncomingPublishFlows mqttIncomingPublishFlows) {
        this.f18220h = mqttClientConfig;
        this.f18221i = new MqttIncomingPublishService(this, mqttIncomingPublishFlows);
    }

    private boolean i(Object obj, MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows) {
        if (obj != mqttStatefulPublishWithFlows) {
            if (obj == null) {
                this.f18222j.j(mqttStatefulPublishWithFlows.f18228d.a());
            } else {
                this.f18222j.g(obj);
            }
            return false;
        } else if (mqttStatefulPublishWithFlows.f18230f != this.f18224l) {
            return false;
        } else {
            return true;
        }
    }

    private MqttPubAck j(MqttPubAckBuilder mqttPubAckBuilder) {
        this.f18220h.d().a();
        return mqttPubAckBuilder.a();
    }

    private MqttPubComp k(MqttPubCompBuilder mqttPubCompBuilder) {
        this.f18220h.d().a();
        return mqttPubCompBuilder.a();
    }

    private MqttPubRec l(MqttPubRecBuilder mqttPubRecBuilder) {
        this.f18220h.d().a();
        return mqttPubRecBuilder.a();
    }

    private boolean m(ChannelHandlerContext channelHandlerContext, MqttStatefulPublish mqttStatefulPublish) {
        if (mqttStatefulPublish.g()) {
            return true;
        }
        f18218m.error("DUP flag must be set for a resent PUBLISH ({})", mqttStatefulPublish);
        Channel channel = channelHandlerContext.channel();
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode = Mqtt5DisconnectReasonCode.PROTOCOL_ERROR;
        MqttDisconnectUtil.c(channel, mqtt5DisconnectReasonCode, "DUP flag must be set for a resent QoS " + ((MqttPublish) mqttStatefulPublish.c()).j().c() + " PUBLISH");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int n(Object obj) {
        if (obj instanceof MqttStatefulPublishWithFlows) {
            return ((MqttStatefulPublishWithFlows) obj).f18228d.a();
        }
        return ((MqttPubRec) obj).a();
    }

    private boolean o(ChannelHandlerContext channelHandlerContext, MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows) {
        if (this.f18221i.e(mqttStatefulPublishWithFlows, this.f18223k)) {
            return true;
        }
        f18218m.error("Received more QoS 1 and/or 2 PUBLISH messages ({}) than allowed by receive maximum ({})", mqttStatefulPublishWithFlows.f18228d, Integer.valueOf(this.f18223k));
        MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.RECEIVE_MAXIMUM_EXCEEDED, "Received more QoS 1 and/or 2 PUBLISH messages than allowed by receive maximum");
        return false;
    }

    private void p(ChannelHandlerContext channelHandlerContext, MqttPubRel mqttPubRel) {
        Object j8 = this.f18222j.j(mqttPubRel.a());
        if (j8 instanceof MqttPubRec) {
            v(channelHandlerContext, k(new MqttPubCompBuilder(mqttPubRel)));
        } else if (j8 == null) {
            v(channelHandlerContext, k(new MqttPubCompBuilder(mqttPubRel).b(Mqtt5PubCompReasonCode.PACKET_IDENTIFIER_NOT_FOUND)));
        } else {
            MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows = (MqttStatefulPublishWithFlows) j8;
            this.f18222j.g(j8);
            if (((MqttPublish) mqttStatefulPublishWithFlows.f18228d.c()).j() == MqttQos.EXACTLY_ONCE) {
                f18218m.error("PUBREL ({}) must not carry the same packet identifier as an unacknowledged QoS 2 PUBLISH ({})", mqttPubRel, mqttStatefulPublishWithFlows.f18228d);
                MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "PUBREL must not carry the same packet identifier as an unacknowledged QoS 2 PUBLISH");
                return;
            }
            f18218m.error("PUBREL ({}) must not carry the same packet identifier as a QoS 1 PUBLISH ({})", mqttPubRel, mqttStatefulPublishWithFlows.f18228d);
            MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "PUBREL must not carry the same packet identifier as a QoS 1 PUBLISH");
        }
    }

    private void q(ChannelHandlerContext channelHandlerContext, MqttStatefulPublish mqttStatefulPublish) {
        int i8 = AnonymousClass1.f18225a[((MqttPublish) mqttStatefulPublish.c()).j().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    t(channelHandlerContext, mqttStatefulPublish);
                    return;
                }
                return;
            }
            s(channelHandlerContext, mqttStatefulPublish);
            return;
        }
        r(mqttStatefulPublish);
    }

    private void r(MqttStatefulPublish mqttStatefulPublish) {
        this.f18221i.d(new MqttStatefulPublishWithFlows(mqttStatefulPublish), this.f18223k);
    }

    private void s(ChannelHandlerContext channelHandlerContext, MqttStatefulPublish mqttStatefulPublish) {
        MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows = new MqttStatefulPublishWithFlows(mqttStatefulPublish);
        mqttStatefulPublishWithFlows.f18230f = this.f18224l;
        Object i8 = this.f18222j.i(mqttStatefulPublishWithFlows);
        if (i8 == null) {
            if (!o(channelHandlerContext, mqttStatefulPublishWithFlows)) {
                this.f18222j.j(mqttStatefulPublish.a());
            }
        } else if (i8 instanceof MqttStatefulPublishWithFlows) {
            MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows2 = (MqttStatefulPublishWithFlows) i8;
            if (((MqttPublish) mqttStatefulPublishWithFlows2.f18228d.c()).j() == MqttQos.AT_LEAST_ONCE) {
                if (mqttStatefulPublishWithFlows2.f18230f == this.f18224l) {
                    if (this.f18220h.l() == MqttVersion.MQTT_5_0) {
                        f18218m.error("QoS 1 PUBLISH ({}) must not be resent ({}) during the same connection", mqttStatefulPublishWithFlows2.f18228d, mqttStatefulPublish);
                        MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "QoS 1 PUBLISH must not be resent during the same connection");
                        return;
                    }
                    m(channelHandlerContext, mqttStatefulPublish);
                    return;
                }
                this.f18222j.g(mqttStatefulPublishWithFlows);
                if (!o(channelHandlerContext, mqttStatefulPublishWithFlows)) {
                    this.f18222j.g(i8);
                    return;
                }
                return;
            }
            f18218m.error("QoS 1 PUBLISH ({}) must not carry the same packet identifier as a QoS 2 PUBLISH ({})", mqttStatefulPublish, mqttStatefulPublishWithFlows2.f18228d);
            MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "QoS 1 PUBLISH must not carry the same packet identifier as a QoS 2 PUBLISH");
        } else {
            f18218m.error("QoS 1 PUBLISH ({}) must not carry the same packet identifier as a QoS 2 PUBLISH ({})", mqttStatefulPublish, i8);
            MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "QoS 1 PUBLISH must not carry the same packet identifier as a QoS 2 PUBLISH");
        }
    }

    private void t(ChannelHandlerContext channelHandlerContext, MqttStatefulPublish mqttStatefulPublish) {
        MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows = new MqttStatefulPublishWithFlows(mqttStatefulPublish);
        mqttStatefulPublishWithFlows.f18230f = this.f18224l;
        Object i8 = this.f18222j.i(mqttStatefulPublishWithFlows);
        if (i8 == null) {
            if (!o(channelHandlerContext, mqttStatefulPublishWithFlows)) {
                this.f18222j.j(mqttStatefulPublish.a());
            }
        } else if (i8 instanceof MqttStatefulPublishWithFlows) {
            MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows2 = (MqttStatefulPublishWithFlows) i8;
            if (((MqttPublish) mqttStatefulPublishWithFlows2.f18228d.c()).j() == MqttQos.EXACTLY_ONCE) {
                long j8 = mqttStatefulPublishWithFlows2.f18230f;
                long j9 = this.f18224l;
                if (j8 == j9) {
                    if (this.f18220h.l() == MqttVersion.MQTT_5_0) {
                        f18218m.error("QoS 2 PUBLISH ({}) must not be resent ({}) during the same connection", mqttStatefulPublishWithFlows2.f18228d, mqttStatefulPublish);
                        MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "QoS 2 PUBLISH must not be resent during the same connection");
                        return;
                    }
                    m(channelHandlerContext, mqttStatefulPublish);
                    return;
                }
                mqttStatefulPublishWithFlows2.f18230f = j9;
                m(channelHandlerContext, mqttStatefulPublish);
            } else if (mqttStatefulPublishWithFlows2.f18230f == this.f18224l) {
                f18218m.error("QoS 2 PUBLISH ({}) must not carry the same packet identifier as a QoS 1 PUBLISH ({})", mqttStatefulPublish, mqttStatefulPublishWithFlows2.f18228d);
                MqttDisconnectUtil.c(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "QoS 2 PUBLISH must not carry the same packet identifier as a QoS 1 PUBLISH");
            } else {
                this.f18222j.g(mqttStatefulPublishWithFlows);
                if (!o(channelHandlerContext, mqttStatefulPublishWithFlows)) {
                    this.f18222j.g(i8);
                }
            }
        } else if (m(channelHandlerContext, mqttStatefulPublish)) {
            w(channelHandlerContext, (MqttPubRec) i8);
        }
    }

    private void u(ChannelHandlerContext channelHandlerContext, MqttPubAck mqttPubAck) {
        channelHandlerContext.writeAndFlush(mqttPubAck, channelHandlerContext.voidPromise());
    }

    private void v(ChannelHandlerContext channelHandlerContext, MqttPubComp mqttPubComp) {
        channelHandlerContext.writeAndFlush(mqttPubComp, channelHandlerContext.voidPromise());
    }

    private void w(ChannelHandlerContext channelHandlerContext, MqttPubRec mqttPubRec) {
        channelHandlerContext.writeAndFlush(mqttPubRec, channelHandlerContext.voidPromise());
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttSessionAwareHandler
    public void b(Throwable th) {
        super.b(th);
        this.f18222j.e();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof MqttStatefulPublish) {
            q(channelHandlerContext, (MqttStatefulPublish) obj);
        } else if (obj instanceof MqttPubRel) {
            p(channelHandlerContext, (MqttPubRel) obj);
        } else {
            channelHandlerContext.fireChannelRead(obj);
        }
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttSessionAwareHandler
    public void d(MqttClientConnectionConfig mqttClientConnectionConfig, EventLoop eventLoop) {
        this.f18223k = mqttClientConnectionConfig.f();
        this.f18224l++;
        super.d(mqttClientConnectionConfig, eventLoop);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows) {
        ChannelHandlerContext channelHandlerContext;
        Object j8;
        ChannelHandlerContext channelHandlerContext2;
        int i8 = AnonymousClass1.f18225a[((MqttPublish) mqttStatefulPublishWithFlows.f18228d.c()).j().ordinal()];
        if (i8 != 2) {
            if (i8 == 3) {
                MqttPubRec l8 = l(new MqttPubRecBuilder(mqttStatefulPublishWithFlows.f18228d));
                if (!((Mqtt5PubRecReasonCode) l8.h()).a()) {
                    j8 = this.f18222j.g(l8);
                } else {
                    j8 = this.f18222j.j(l8.a());
                }
                if (i(j8, mqttStatefulPublishWithFlows) && (channelHandlerContext2 = this.f18020f) != null) {
                    w(channelHandlerContext2, l8);
                    return;
                }
                return;
            }
            return;
        }
        MqttPubAck j9 = j(new MqttPubAckBuilder(mqttStatefulPublishWithFlows.f18228d));
        if (i(this.f18222j.j(j9.a()), mqttStatefulPublishWithFlows) && (channelHandlerContext = this.f18020f) != null) {
            u(channelHandlerContext, j9);
        }
    }
}
