package com.hivemq.client.internal.mqtt.handler.disconnect;

import com.hivemq.client.internal.logging.InternalLogger;
import com.hivemq.client.internal.logging.InternalLoggerFactory;
import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttClientConnectionConfig;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.exceptions.MqttClientStateExceptions;
import com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler;
import com.hivemq.client.internal.mqtt.handler.MqttSession;
import com.hivemq.client.internal.mqtt.handler.connect.MqttConnAckSingle;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectEvent;
import com.hivemq.client.internal.mqtt.message.auth.MqttSimpleAuth;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnectRestrictions;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAck;
import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnect;
import com.hivemq.client.internal.rx.CompletableFlow;
import com.hivemq.client.mqtt.MqttVersion;
import com.hivemq.client.mqtt.exceptions.ConnectionClosedException;
import com.hivemq.client.mqtt.lifecycle.MqttDisconnectSource;
import com.hivemq.client.mqtt.mqtt5.auth.Mqtt5EnhancedAuthMechanism;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5ConnAckException;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5DisconnectException;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.DuplexChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class MqttDisconnectHandler extends MqttConnectionAwareHandler {

    /* renamed from: j  reason: collision with root package name */
    private static final InternalLogger f18144j = InternalLoggerFactory.a(MqttDisconnectHandler.class);

    /* renamed from: k  reason: collision with root package name */
    private static final Object f18145k = new Object();

    /* renamed from: g  reason: collision with root package name */
    private final MqttClientConfig f18146g;

    /* renamed from: h  reason: collision with root package name */
    private final MqttSession f18147h;

    /* renamed from: i  reason: collision with root package name */
    private Object f18148i = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DisconnectingState implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final Channel f18149f;

        /* renamed from: g  reason: collision with root package name */
        private final MqttDisconnectEvent.ByUser f18150g;

        /* renamed from: h  reason: collision with root package name */
        private final ScheduledFuture<?> f18151h;

        DisconnectingState(Channel channel, MqttDisconnectEvent.ByUser byUser) {
            this.f18149f = channel;
            this.f18150g = byUser;
            this.f18151h = channel.eventLoop().schedule((Runnable) this, 10L, TimeUnit.SECONDS);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18149f.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MqttDisconnectHandler(MqttClientConfig mqttClientConfig, MqttSession mqttSession) {
        this.f18146g = mqttClientConfig;
        this.f18147h = mqttSession;
    }

    private void m(Channel channel, MqttDisconnectEvent mqttDisconnectEvent) {
        MqttClientConnectionConfig n8 = this.f18146g.n();
        if (n8 != null) {
            this.f18147h.d(mqttDisconnectEvent.a(), n8, channel.eventLoop());
            w(mqttDisconnectEvent, n8, channel.eventLoop());
            this.f18146g.u(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(Channel channel, MqttDisconnectEvent.ByUser byUser, MqttDisconnectEvent mqttDisconnectEvent, Future future) throws Exception {
        if (future.isSuccess()) {
            this.f18148i = new DisconnectingState(channel, byUser);
            return;
        }
        m(channel, mqttDisconnectEvent);
        byUser.d().c(new ConnectionClosedException(future.cause()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(Channel channel, MqttDisconnectEvent mqttDisconnectEvent, Future future) throws Exception {
        m(channel, mqttDisconnectEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(final Channel channel, final MqttDisconnectEvent.ByUser byUser, final MqttDisconnectEvent mqttDisconnectEvent, Future future) throws Exception {
        if (future.isSuccess()) {
            ((DuplexChannel) channel).shutdownOutput().addListener(new GenericFutureListener() { // from class: com.hivemq.client.internal.mqtt.handler.disconnect.f
                @Override // io.netty.util.concurrent.GenericFutureListener
                public final void operationComplete(Future future2) {
                    MqttDisconnectHandler.this.o(channel, byUser, mqttDisconnectEvent, future2);
                }
            });
            return;
        }
        m(channel, mqttDisconnectEvent);
        byUser.d().c(new ConnectionClosedException(future.cause()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(final Channel channel, final MqttDisconnectEvent mqttDisconnectEvent, Future future) throws Exception {
        channel.close().addListener(new GenericFutureListener() { // from class: com.hivemq.client.internal.mqtt.handler.disconnect.g
            @Override // io.netty.util.concurrent.GenericFutureListener
            public final void operationComplete(Future future2) {
                MqttDisconnectHandler.this.p(channel, mqttDisconnectEvent, future2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(Channel channel, MqttDisconnectEvent mqttDisconnectEvent, Future future) throws Exception {
        m(channel, mqttDisconnectEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(Channel channel, MqttDisconnectEvent mqttDisconnectEvent, Future future) throws Exception {
        m(channel, mqttDisconnectEvent);
    }

    private void u(ChannelHandlerContext channelHandlerContext, MqttConnAck mqttConnAck) {
        if (this.f18148i == null) {
            this.f18148i = f18145k;
            MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5ConnAckException(mqttConnAck, "Must not receive second CONNACK."));
        }
    }

    private void v(ChannelHandlerContext channelHandlerContext, MqttDisconnect mqttDisconnect) {
        if (this.f18148i == null) {
            this.f18148i = f18145k;
            MqttDisconnectUtil.f(channelHandlerContext.channel(), new Mqtt5DisconnectException(mqttDisconnect, "Server sent DISCONNECT."), MqttDisconnectSource.SERVER);
        }
    }

    private void w(MqttDisconnectEvent mqttDisconnectEvent, MqttClientConnectionConfig mqttClientConnectionConfig, EventLoop eventLoop) {
        boolean z7;
        MqttClientConfig.ConnectDefaults f8 = this.f18146g.f();
        Mqtt5EnhancedAuthMechanism e8 = mqttClientConnectionConfig.e();
        int c8 = mqttClientConnectionConfig.c();
        if (mqttClientConnectionConfig.k() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        long k8 = mqttClientConnectionConfig.k();
        MqttConnectRestrictions mqttConnectRestrictions = new MqttConnectRestrictions(mqttClientConnectionConfig.f(), mqttClientConnectionConfig.g(), mqttClientConnectionConfig.d(), mqttClientConnectionConfig.h(), mqttClientConnectionConfig.l(), mqttClientConnectionConfig.j(), mqttClientConnectionConfig.n(), mqttClientConnectionConfig.o());
        MqttSimpleAuth b8 = f8.b();
        if (e8 == null) {
            e8 = f8.a();
        }
        f8.c();
        MqttConnAckSingle.j0(this.f18146g, mqttDisconnectEvent.c(), mqttDisconnectEvent.a(), new MqttConnect(c8, z7, k8, mqttConnectRestrictions, b8, e8, null, MqttUserPropertiesImpl.f17992c), eventLoop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void n(MqttDisconnect mqttDisconnect, CompletableFlow completableFlow) {
        ChannelHandlerContext channelHandlerContext = this.f18020f;
        if (channelHandlerContext != null && this.f18148i == null) {
            this.f18148i = f18145k;
            MqttDisconnectUtil.e(channelHandlerContext.channel(), new MqttDisconnectEvent.ByUser(mqttDisconnect, completableFlow));
            return;
        }
        completableFlow.c(MqttClientStateExceptions.b());
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler
    protected void a(ChannelHandlerContext channelHandlerContext, final MqttDisconnectEvent mqttDisconnectEvent) {
        MqttClientConnectionConfig n8;
        this.f18148i = f18145k;
        final Channel channel = channelHandlerContext.channel();
        if (mqttDisconnectEvent.c() == MqttDisconnectSource.SERVER) {
            m(channel, mqttDisconnectEvent);
            channel.close();
            return;
        }
        MqttDisconnect b8 = mqttDisconnectEvent.b();
        if (b8 != null) {
            long l8 = b8.l();
            if (l8 != -1 && (n8 = this.f18146g.n()) != null) {
                if (l8 > 0 && n8.m()) {
                    f18144j.warn("Session expiry interval must not be set in DISCONNECT if it was set to 0 in CONNECT");
                    b8 = b8.j().e(0L).a();
                } else {
                    n8.p(l8);
                }
            }
            if (mqttDisconnectEvent instanceof MqttDisconnectEvent.ByUser) {
                final MqttDisconnectEvent.ByUser byUser = (MqttDisconnectEvent.ByUser) mqttDisconnectEvent;
                channelHandlerContext.writeAndFlush(b8).addListener(new GenericFutureListener() { // from class: com.hivemq.client.internal.mqtt.handler.disconnect.b
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public final void operationComplete(Future future) {
                        MqttDisconnectHandler.this.q(channel, byUser, mqttDisconnectEvent, future);
                    }
                });
                return;
            } else if (this.f18146g.l() == MqttVersion.MQTT_5_0) {
                channelHandlerContext.writeAndFlush(b8).addListener(new GenericFutureListener() { // from class: com.hivemq.client.internal.mqtt.handler.disconnect.c
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public final void operationComplete(Future future) {
                        MqttDisconnectHandler.this.r(channel, mqttDisconnectEvent, future);
                    }
                });
                return;
            } else {
                channel.close().addListener(new GenericFutureListener() { // from class: com.hivemq.client.internal.mqtt.handler.disconnect.d
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public final void operationComplete(Future future) {
                        MqttDisconnectHandler.this.s(channel, mqttDisconnectEvent, future);
                    }
                });
                return;
            }
        }
        channel.close().addListener(new GenericFutureListener() { // from class: com.hivemq.client.internal.mqtt.handler.disconnect.e
            @Override // io.netty.util.concurrent.GenericFutureListener
            public final void operationComplete(Future future) {
                MqttDisconnectHandler.this.t(channel, mqttDisconnectEvent, future);
            }
        });
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelInactive();
        Object obj = this.f18148i;
        if (obj == null) {
            this.f18148i = f18145k;
            MqttDisconnectUtil.f(channelHandlerContext.channel(), new ConnectionClosedException("Server closed connection without DISCONNECT."), MqttDisconnectSource.SERVER);
        } else if (obj instanceof DisconnectingState) {
            DisconnectingState disconnectingState = (DisconnectingState) obj;
            this.f18148i = f18145k;
            disconnectingState.f18151h.cancel(false);
            m(disconnectingState.f18149f, disconnectingState.f18150g);
            disconnectingState.f18150g.d().b();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof MqttDisconnect) {
            v(channelHandlerContext, (MqttDisconnect) obj);
        } else if (obj instanceof MqttConnAck) {
            u(channelHandlerContext, (MqttConnAck) obj);
        } else {
            channelHandlerContext.fireChannelRead(obj);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        if (this.f18148i == null) {
            this.f18148i = f18145k;
            MqttDisconnectUtil.f(channelHandlerContext.channel(), new ConnectionClosedException(th), MqttDisconnectSource.CLIENT);
        } else if (!(th instanceof IOException)) {
            f18144j.warn("Exception while disconnecting: {}", th);
        }
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler, io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        return false;
    }

    public void l(final MqttDisconnect mqttDisconnect, final CompletableFlow completableFlow) {
        if (!this.f18146g.c(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.disconnect.a
            @Override // java.lang.Runnable
            public final void run() {
                MqttDisconnectHandler.this.n(mqttDisconnect, completableFlow);
            }
        })) {
            completableFlow.c(MqttClientStateExceptions.b());
        }
    }
}
