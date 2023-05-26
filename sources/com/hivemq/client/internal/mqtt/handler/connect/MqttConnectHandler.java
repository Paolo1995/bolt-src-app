package com.hivemq.client.internal.mqtt.handler.connect;

import com.hivemq.client.internal.logging.InternalLogger;
import com.hivemq.client.internal.logging.InternalLoggerFactory;
import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttClientConnectionConfig;
import com.hivemq.client.internal.mqtt.MqttClientTransportConfigImpl;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoder;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttEncoder;
import com.hivemq.client.internal.mqtt.datatypes.MqttClientIdentifierImpl;
import com.hivemq.client.internal.mqtt.handler.MqttSession;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectEvent;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectUtil;
import com.hivemq.client.internal.mqtt.handler.ping.MqttPingHandler;
import com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler;
import com.hivemq.client.internal.mqtt.lifecycle.MqttClientConnectedContextImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessage;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnectRestrictions;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAck;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAckRestrictions;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.MqttClientState;
import com.hivemq.client.mqtt.MqttVersion;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedContext;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedListener;
import com.hivemq.client.mqtt.lifecycle.MqttDisconnectSource;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5ConnAckException;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class MqttConnectHandler extends MqttTimeoutInboundHandler {

    /* renamed from: o  reason: collision with root package name */
    private static final InternalLogger f18107o = InternalLoggerFactory.a(MqttConnectHandler.class);

    /* renamed from: h  reason: collision with root package name */
    private final MqttConnect f18108h;

    /* renamed from: i  reason: collision with root package name */
    private final MqttConnAckFlow f18109i;

    /* renamed from: j  reason: collision with root package name */
    private final MqttClientConfig f18110j;

    /* renamed from: k  reason: collision with root package name */
    private final MqttSession f18111k;

    /* renamed from: l  reason: collision with root package name */
    private final MqttDecoder f18112l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f18113m = false;

    /* renamed from: n  reason: collision with root package name */
    private long f18114n;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MqttConnectHandler(MqttConnect mqttConnect, MqttConnAckFlow mqttConnAckFlow, MqttClientConfig mqttClientConfig, MqttSession mqttSession, MqttDecoder mqttDecoder) {
        this.f18108h = mqttConnect;
        this.f18109i = mqttConnAckFlow;
        this.f18110j = mqttClientConfig;
        this.f18111k = mqttSession;
        this.f18112l = mqttDecoder;
    }

    private MqttClientConnectionConfig l(MqttConnAck mqttConnAck, Channel channel) {
        boolean z7;
        boolean z8;
        int l8 = mqttConnAck.l();
        if (l8 == -1) {
            l8 = this.f18108h.g();
        }
        int i8 = l8;
        long m8 = mqttConnAck.m();
        if (m8 == -1) {
            m8 = this.f18108h.l();
        }
        long j8 = m8;
        MqttConnectRestrictions k8 = this.f18108h.k();
        MqttConnAckRestrictions n8 = mqttConnAck.n();
        MqttClientTransportConfigImpl i9 = this.f18110j.i();
        boolean m9 = this.f18108h.m();
        if (this.f18108h.l() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.f18108h.i() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.f18108h.j();
        MqttClientConnectionConfig mqttClientConnectionConfig = new MqttClientConnectionConfig(i9, i8, m9, z7, j8, z8, false, this.f18108h.h(), k8.b(), k8.a(), k8.f(), k8.g(), k8.h(), Math.min(k8.c(), n8.d()), Math.min(k8.d(), n8.b()), Math.min(k8.e(), n8.e()), n8.c(), n8.f(), n8.h(), n8.g(), n8.a(), channel);
        this.f18110j.u(mqttClientConnectionConfig);
        return mqttClientConnectionConfig;
    }

    private void m(MqttConnAck mqttConnAck, Channel channel) {
        if (mqttConnAck.h().a()) {
            MqttDisconnectUtil.f(channel, new Mqtt5ConnAckException(mqttConnAck, "CONNECT failed as CONNACK contained an Error Code: " + mqttConnAck.h() + "."), MqttDisconnectSource.SERVER);
        } else if (o(mqttConnAck, channel)) {
            MqttClientConnectionConfig l8 = l(mqttConnAck, channel);
            channel.pipeline().remove(this);
            ((MqttEncoder) channel.pipeline().get("encoder")).a(l8);
            this.f18111k.g(mqttConnAck, l8, channel.pipeline(), channel.eventLoop());
            int c8 = l8.c();
            if (c8 > 0) {
                channel.pipeline().addAfter("decoder", "ping", new MqttPingHandler(c8, this.f18114n, System.nanoTime()));
            }
            this.f18110j.o().set(MqttClientState.CONNECTED);
            ImmutableList<MqttClientConnectedListener> g8 = this.f18110j.g();
            if (!g8.isEmpty()) {
                MqttClientConnectedContext c9 = MqttClientConnectedContextImpl.c(this.f18110j, this.f18108h, mqttConnAck);
                ImmutableList.ImmutableListIterator<MqttClientConnectedListener> it = g8.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(c9);
                    } catch (Throwable th) {
                        f18107o.error("Unexpected exception thrown by connected listener.", th);
                    }
                }
            }
            this.f18109i.d(mqttConnAck);
        }
    }

    private void n(Object obj, Channel channel) {
        if (obj instanceof MqttMessage) {
            Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode = Mqtt5DisconnectReasonCode.PROTOCOL_ERROR;
            MqttDisconnectUtil.c(channel, mqtt5DisconnectReasonCode, ((MqttMessage) obj).getType() + " message must not be received before CONNACK");
            return;
        }
        MqttDisconnectUtil.a(channel, "No data must be received before CONNECT is sent");
    }

    private boolean o(MqttConnAck mqttConnAck, Channel channel) {
        MqttClientIdentifierImpl m8 = this.f18110j.m();
        MqttClientIdentifierImpl j8 = mqttConnAck.j();
        if (m8 == MqttClientIdentifierImpl.f17982j) {
            if (this.f18110j.l() == MqttVersion.MQTT_5_0 && j8 == null) {
                MqttDisconnectUtil.d(channel, Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5ConnAckException(mqttConnAck, "Server did not assign a Client Identifier"));
                return false;
            }
        } else if (j8 != null) {
            f18107o.warn("Server overwrote the Client Identifier {} with {}", m8, j8);
        }
        if (j8 != null) {
            this.f18110j.t(j8);
            return true;
        }
        return true;
    }

    private void p(ChannelHandlerContext channelHandlerContext) {
        Object obj;
        if (!this.f18113m) {
            this.f18113m = true;
            this.f18114n = System.nanoTime();
            if (this.f18108h.h() == null) {
                obj = this.f18108h.f(this.f18110j.m(), null);
            } else {
                obj = this.f18108h;
            }
            channelHandlerContext.writeAndFlush(obj).addListener((GenericFutureListener<? extends Future<? super Void>>) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler, com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler
    public void a(ChannelHandlerContext channelHandlerContext, MqttDisconnectEvent mqttDisconnectEvent) {
        super.a(channelHandlerContext, mqttDisconnectEvent);
        MqttConnAckSingle.i0(this.f18110j, mqttDisconnectEvent.c(), mqttDisconnectEvent.a(), this.f18108h, this.f18109i, channelHandlerContext.channel().eventLoop());
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        p(channelHandlerContext);
        channelHandlerContext.fireChannelActive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        b();
        if (obj instanceof MqttConnAck) {
            m((MqttConnAck) obj, channelHandlerContext.channel());
        } else {
            n(obj, channelHandlerContext.channel());
        }
    }

    @Override // com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler
    protected long d() {
        return this.f18110j.i().a();
    }

    @Override // com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler
    protected Mqtt5DisconnectReasonCode f() {
        return Mqtt5DisconnectReasonCode.PROTOCOL_ERROR;
    }

    @Override // com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler
    protected String g() {
        return "Timeout while waiting for CONNACK";
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        super.handlerAdded(channelHandlerContext);
        if (channelHandlerContext.channel().isActive()) {
            p(channelHandlerContext);
        }
    }

    @Override // com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler
    protected void j(ChannelHandlerContext channelHandlerContext) {
        if (this.f18108h.h() == null) {
            k(channelHandlerContext.channel());
        }
        channelHandlerContext.pipeline().addAfter("encoder", "decoder", this.f18112l);
    }
}
