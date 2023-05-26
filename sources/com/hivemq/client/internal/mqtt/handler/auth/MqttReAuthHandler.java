package com.hivemq.client.internal.mqtt.handler.auth;

import com.hivemq.client.internal.mqtt.handler.auth.AbstractMqttAuthHandler;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectEvent;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectUtil;
import com.hivemq.client.internal.mqtt.message.auth.MqttAuth;
import com.hivemq.client.internal.mqtt.message.auth.MqttAuthBuilder;
import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnect;
import com.hivemq.client.internal.rx.CompletableFlow;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5AuthException;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5AuthReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import java.util.concurrent.CompletableFuture;

/* loaded from: classes3.dex */
public class MqttReAuthHandler extends AbstractMqttAuthHandler {

    /* renamed from: l  reason: collision with root package name */
    private CompletableFlow f18045l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttReAuthHandler(MqttConnectAuthHandler mqttConnectAuthHandler) {
        super(mqttConnectAuthHandler.f18032h, mqttConnectAuthHandler.f18033i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(MqttDisconnectEvent mqttDisconnectEvent) {
        this.f18033i.b(this.f18032h, mqttDisconnectEvent.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableFuture R(MqttAuth mqttAuth) {
        return this.f18033i.i(this.f18032h, mqttAuth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(ChannelHandlerContext channelHandlerContext) {
        this.f18034j = AbstractMqttAuthHandler.MqttAuthState.NONE;
        CompletableFlow completableFlow = this.f18045l;
        if (completableFlow != null) {
            if (!completableFlow.a()) {
                this.f18045l.b();
            } else {
                AbstractMqttAuthHandler.f18031k.warn("Reauth was successful but the Completable has been cancelled.");
            }
            this.f18045l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(MqttAuth mqttAuth, ChannelHandlerContext channelHandlerContext, Throwable th) {
        MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.NOT_AUTHORIZED, new Mqtt5AuthException(mqttAuth, "Server AUTH with reason code SUCCESS not accepted."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(MqttDisconnect mqttDisconnect) {
        this.f18033i.f(this.f18032h, mqttDisconnect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(MqttAuth mqttAuth, ChannelHandlerContext channelHandlerContext, Throwable th) {
        MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.NOT_AUTHORIZED, new Mqtt5AuthException(mqttAuth, "Server AUTH with reason code REAUTHENTICATE not accepted."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableFuture W(MqttAuth mqttAuth, MqttAuthBuilder mqttAuthBuilder) {
        return this.f18033i.a(this.f18032h, mqttAuth, mqttAuthBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(MqttAuthBuilder mqttAuthBuilder, ChannelHandlerContext channelHandlerContext) {
        this.f18034j = AbstractMqttAuthHandler.MqttAuthState.WAIT_FOR_SERVER;
        channelHandlerContext.writeAndFlush(mqttAuthBuilder.a()).addListener((GenericFutureListener<? extends Future<? super Void>>) this);
    }

    private void Y(ChannelHandlerContext channelHandlerContext, final MqttDisconnect mqttDisconnect) {
        b();
        AbstractMqttAuthHandler.MqttAuthState mqttAuthState = this.f18034j;
        AbstractMqttAuthHandler.MqttAuthState mqttAuthState2 = AbstractMqttAuthHandler.MqttAuthState.NONE;
        if (mqttAuthState != mqttAuthState2) {
            s(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.auth.t
                @Override // java.lang.Runnable
                public final void run() {
                    MqttReAuthHandler.this.U(mqttDisconnect);
                }
            });
            this.f18034j = mqttAuthState2;
        }
        channelHandlerContext.fireChannelRead(mqttDisconnect);
    }

    @Override // com.hivemq.client.internal.mqtt.handler.auth.AbstractMqttAuthHandler
    void F(ChannelHandlerContext channelHandlerContext, final MqttAuth mqttAuth) {
        if (this.f18034j != AbstractMqttAuthHandler.MqttAuthState.WAIT_FOR_SERVER) {
            MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5AuthException(mqttAuth, "Must not receive AUTH with reason code SUCCESS if client side AUTH is pending."));
            return;
        }
        this.f18034j = AbstractMqttAuthHandler.MqttAuthState.IN_PROGRESS_DONE;
        u(new Supplier() { // from class: com.hivemq.client.internal.mqtt.handler.auth.u
            @Override // j$.util.function.Supplier
            public final Object get() {
                CompletableFuture R;
                R = MqttReAuthHandler.this.R(mqttAuth);
                return R;
            }
        }, new Consumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.v
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                MqttReAuthHandler.this.S((ChannelHandlerContext) obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        }, new BiConsumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.w
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MqttReAuthHandler.T(MqttAuth.this, (ChannelHandlerContext) obj, (Throwable) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        });
    }

    @Override // com.hivemq.client.internal.mqtt.handler.auth.AbstractMqttAuthHandler
    void G(ChannelHandlerContext channelHandlerContext, final MqttAuth mqttAuth) {
        if (!this.f18032h.d().b()) {
            MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5AuthException(mqttAuth, "Must not receive AUTH with reason code REAUTHENTICATE."));
        } else if (this.f18034j != AbstractMqttAuthHandler.MqttAuthState.NONE) {
            MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5AuthException(mqttAuth, "Must not receive AUTH with reason code REAUTHENTICATE if reauth is still pending."));
        } else {
            final MqttAuthBuilder mqttAuthBuilder = new MqttAuthBuilder(Mqtt5AuthReasonCode.CONTINUE_AUTHENTICATION, v());
            this.f18034j = AbstractMqttAuthHandler.MqttAuthState.IN_PROGRESS_INIT;
            u(new Supplier() { // from class: com.hivemq.client.internal.mqtt.handler.auth.q
                @Override // j$.util.function.Supplier
                public final Object get() {
                    CompletableFuture W;
                    W = MqttReAuthHandler.this.W(mqttAuth, mqttAuthBuilder);
                    return W;
                }
            }, new Consumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.r
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    MqttReAuthHandler.this.X(mqttAuthBuilder, (ChannelHandlerContext) obj);
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.$default$andThen(this, consumer);
                }
            }, new BiConsumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.s
                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    MqttReAuthHandler.V(MqttAuth.this, (ChannelHandlerContext) obj, (Throwable) obj2);
                }

                @Override // j$.util.function.BiConsumer
                public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer.CC.$default$andThen(this, biConsumer);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler, com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler
    public void a(ChannelHandlerContext channelHandlerContext, final MqttDisconnectEvent mqttDisconnectEvent) {
        super.a(channelHandlerContext, mqttDisconnectEvent);
        AbstractMqttAuthHandler.MqttAuthState mqttAuthState = this.f18034j;
        AbstractMqttAuthHandler.MqttAuthState mqttAuthState2 = AbstractMqttAuthHandler.MqttAuthState.NONE;
        if (mqttAuthState != mqttAuthState2) {
            s(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.auth.x
                @Override // java.lang.Runnable
                public final void run() {
                    MqttReAuthHandler.this.Q(mqttDisconnectEvent);
                }
            });
            this.f18034j = mqttAuthState2;
        }
        CompletableFlow completableFlow = this.f18045l;
        if (completableFlow != null) {
            completableFlow.c(mqttDisconnectEvent.a());
            this.f18045l = null;
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof MqttAuth) {
            D(channelHandlerContext, (MqttAuth) obj);
        } else if (obj instanceof MqttDisconnect) {
            Y(channelHandlerContext, (MqttDisconnect) obj);
        } else {
            channelHandlerContext.fireChannelRead(obj);
        }
    }

    @Override // com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler
    protected String g() {
        return "Timeout while waiting for AUTH or DISCONNECT.";
    }
}
