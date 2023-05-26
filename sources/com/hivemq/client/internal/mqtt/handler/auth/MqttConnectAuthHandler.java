package com.hivemq.client.internal.mqtt.handler.auth;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.handler.auth.AbstractMqttAuthHandler;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectEvent;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectUtil;
import com.hivemq.client.internal.mqtt.message.auth.MqttAuth;
import com.hivemq.client.internal.mqtt.message.auth.MqttEnhancedAuthBuilder;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAck;
import com.hivemq.client.internal.netty.DefaultChannelOutboundHandler;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.exceptions.ConnectionFailedException;
import com.hivemq.client.mqtt.lifecycle.MqttDisconnectSource;
import com.hivemq.client.mqtt.mqtt5.auth.Mqtt5EnhancedAuthMechanism;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5AuthException;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5ConnAckException;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5EnhancedAuth;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import java.net.SocketAddress;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class MqttConnectAuthHandler extends AbstractMqttAuthHandler implements DefaultChannelOutboundHandler {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MqttConnectAuthHandler(MqttClientConfig mqttClientConfig, MqttConnect mqttConnect) {
        super(mqttClientConfig, (Mqtt5EnhancedAuthMechanism) Checks.l(mqttConnect.h(), "Auth mechanism"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(MqttDisconnectEvent mqttDisconnectEvent) {
        this.f18033i.e(this.f18032h, mqttDisconnectEvent.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(MqttConnAck mqttConnAck) {
        this.f18033i.g(this.f18032h, mqttConnAck);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableFuture S(MqttConnAck mqttConnAck) {
        return this.f18033i.h(this.f18032h, mqttConnAck);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(MqttConnAck mqttConnAck, ChannelHandlerContext channelHandlerContext) {
        this.f18034j = AbstractMqttAuthHandler.MqttAuthState.NONE;
        channelHandlerContext.pipeline().replace(this, "auth", new MqttReAuthHandler(this));
        channelHandlerContext.fireChannelRead(mqttConnAck);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(MqttConnAck mqttConnAck, ChannelHandlerContext channelHandlerContext, Throwable th) {
        MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.NOT_AUTHORIZED, new Mqtt5ConnAckException(mqttConnAck, "Server CONNACK with reason code SUCCESS not accepted."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableFuture V(MqttConnect mqttConnect, MqttEnhancedAuthBuilder mqttEnhancedAuthBuilder) {
        return this.f18033i.d(this.f18032h, mqttConnect, mqttEnhancedAuthBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(MqttConnect mqttConnect, MqttEnhancedAuthBuilder mqttEnhancedAuthBuilder, ChannelPromise channelPromise, ChannelHandlerContext channelHandlerContext) {
        this.f18034j = AbstractMqttAuthHandler.MqttAuthState.WAIT_FOR_SERVER;
        channelHandlerContext.writeAndFlush(mqttConnect.f(this.f18032h.m(), mqttEnhancedAuthBuilder.a()), channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(ChannelHandlerContext channelHandlerContext, Throwable th) {
        MqttDisconnectUtil.b(channelHandlerContext.channel(), new ConnectionFailedException(th));
    }

    private void Y(ChannelHandlerContext channelHandlerContext, MqttConnAck mqttConnAck) {
        b();
        if (mqttConnAck.h().a()) {
            Z(channelHandlerContext, mqttConnAck);
        } else if (b0(channelHandlerContext, mqttConnAck)) {
            a0(channelHandlerContext, mqttConnAck);
        }
    }

    private void Z(ChannelHandlerContext channelHandlerContext, final MqttConnAck mqttConnAck) {
        s(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.auth.p
            @Override // java.lang.Runnable
            public final void run() {
                MqttConnectAuthHandler.this.R(mqttConnAck);
            }
        });
        this.f18034j = AbstractMqttAuthHandler.MqttAuthState.NONE;
        Channel channel = channelHandlerContext.channel();
        MqttDisconnectUtil.f(channel, new Mqtt5ConnAckException(mqttConnAck, "CONNECT failed as CONNACK contained an Error Code: " + mqttConnAck.h() + "."), MqttDisconnectSource.SERVER);
    }

    private void a0(ChannelHandlerContext channelHandlerContext, final MqttConnAck mqttConnAck) {
        if (this.f18034j != AbstractMqttAuthHandler.MqttAuthState.WAIT_FOR_SERVER) {
            MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5ConnAckException(mqttConnAck, "Must not receive CONNACK with reason code SUCCESS if client side AUTH is pending."));
            return;
        }
        this.f18034j = AbstractMqttAuthHandler.MqttAuthState.IN_PROGRESS_DONE;
        u(new Supplier() { // from class: com.hivemq.client.internal.mqtt.handler.auth.j
            @Override // j$.util.function.Supplier
            public final Object get() {
                CompletableFuture S;
                S = MqttConnectAuthHandler.this.S(mqttConnAck);
                return S;
            }
        }, new Consumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.k
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                MqttConnectAuthHandler.this.T(mqttConnAck, (ChannelHandlerContext) obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        }, new BiConsumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.l
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MqttConnectAuthHandler.U(MqttConnAck.this, (ChannelHandlerContext) obj, (Throwable) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        });
    }

    private boolean b0(ChannelHandlerContext channelHandlerContext, MqttConnAck mqttConnAck) {
        Mqtt5EnhancedAuth k8 = mqttConnAck.k();
        if (k8 == null) {
            MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5ConnAckException(mqttConnAck, "Auth method in CONNACK must be present."));
            return false;
        } else if (!k8.getMethod().equals(v())) {
            MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5ConnAckException(mqttConnAck, "Auth method in CONNACK must be the same as in the CONNECT."));
            return false;
        } else {
            return true;
        }
    }

    private void c0(final MqttConnect mqttConnect, final ChannelPromise channelPromise) {
        final MqttEnhancedAuthBuilder mqttEnhancedAuthBuilder = new MqttEnhancedAuthBuilder(v());
        this.f18034j = AbstractMqttAuthHandler.MqttAuthState.IN_PROGRESS_INIT;
        t(new Supplier() { // from class: com.hivemq.client.internal.mqtt.handler.auth.m
            @Override // j$.util.function.Supplier
            public final Object get() {
                CompletableFuture V;
                V = MqttConnectAuthHandler.this.V(mqttConnect, mqttEnhancedAuthBuilder);
                return V;
            }
        }, new Consumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.n
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                MqttConnectAuthHandler.this.W(mqttConnect, mqttEnhancedAuthBuilder, channelPromise, (ChannelHandlerContext) obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        }, new BiConsumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.o
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MqttConnectAuthHandler.X((ChannelHandlerContext) obj, (Throwable) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        });
    }

    @Override // com.hivemq.client.internal.mqtt.handler.auth.AbstractMqttAuthHandler
    void F(ChannelHandlerContext channelHandlerContext, MqttAuth mqttAuth) {
        MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5AuthException(mqttAuth, "Must not receive AUTH with reason code SUCCESS during connect auth."));
    }

    @Override // com.hivemq.client.internal.mqtt.handler.auth.AbstractMqttAuthHandler
    void G(ChannelHandlerContext channelHandlerContext, MqttAuth mqttAuth) {
        MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5AuthException(mqttAuth, "Must not receive AUTH with reason code REAUTHENTICATE during connect auth."));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler, com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler
    public void a(ChannelHandlerContext channelHandlerContext, final MqttDisconnectEvent mqttDisconnectEvent) {
        super.a(channelHandlerContext, mqttDisconnectEvent);
        AbstractMqttAuthHandler.MqttAuthState mqttAuthState = this.f18034j;
        AbstractMqttAuthHandler.MqttAuthState mqttAuthState2 = AbstractMqttAuthHandler.MqttAuthState.NONE;
        if (mqttAuthState != mqttAuthState2) {
            s(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.auth.i
                @Override // java.lang.Runnable
                public final void run() {
                    MqttConnectAuthHandler.this.Q(mqttDisconnectEvent);
                }
            });
            this.f18034j = mqttAuthState2;
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof MqttConnAck) {
            Y(channelHandlerContext, (MqttConnAck) obj);
        } else if (obj instanceof MqttAuth) {
            D(channelHandlerContext, (MqttAuth) obj);
        } else {
            channelHandlerContext.fireChannelRead(obj);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public /* synthetic */ void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        m0.a.a(this, channelHandlerContext, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public /* synthetic */ void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        m0.a.b(this, channelHandlerContext, socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public /* synthetic */ void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        m0.a.c(this, channelHandlerContext, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public /* synthetic */ void flush(ChannelHandlerContext channelHandlerContext) {
        m0.a.d(this, channelHandlerContext);
    }

    @Override // com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler
    protected String g() {
        return "Timeout while waiting for AUTH or CONNACK.";
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public /* synthetic */ void read(ChannelHandlerContext channelHandlerContext) {
        m0.a.e(this, channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        if (obj instanceof MqttConnect) {
            c0((MqttConnect) obj, channelPromise);
        } else {
            channelHandlerContext.write(obj, channelPromise);
        }
    }
}
