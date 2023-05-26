package com.hivemq.client.internal.mqtt.handler.auth;

import com.hivemq.client.internal.logging.InternalLogger;
import com.hivemq.client.internal.logging.InternalLoggerFactory;
import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectUtil;
import com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler;
import com.hivemq.client.internal.mqtt.message.auth.MqttAuth;
import com.hivemq.client.internal.mqtt.message.auth.MqttAuthBuilder;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.mqtt5.auth.Mqtt5EnhancedAuthMechanism;
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
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class AbstractMqttAuthHandler extends MqttTimeoutInboundHandler implements MqttAuthHandler {

    /* renamed from: k  reason: collision with root package name */
    static final InternalLogger f18031k = InternalLoggerFactory.a(AbstractMqttAuthHandler.class);

    /* renamed from: h  reason: collision with root package name */
    final MqttClientConfig f18032h;

    /* renamed from: i  reason: collision with root package name */
    final Mqtt5EnhancedAuthMechanism f18033i;

    /* renamed from: j  reason: collision with root package name */
    MqttAuthState f18034j = MqttAuthState.NONE;

    /* renamed from: com.hivemq.client.internal.mqtt.handler.auth.AbstractMqttAuthHandler$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18035a;

        static {
            int[] iArr = new int[Mqtt5AuthReasonCode.values().length];
            f18035a = iArr;
            try {
                iArr[Mqtt5AuthReasonCode.CONTINUE_AUTHENTICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18035a[Mqtt5AuthReasonCode.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18035a[Mqtt5AuthReasonCode.REAUTHENTICATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum MqttAuthState {
        NONE,
        WAIT_FOR_SERVER,
        IN_PROGRESS_INIT,
        IN_PROGRESS_RESPONSE,
        IN_PROGRESS_DONE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractMqttAuthHandler(MqttClientConfig mqttClientConfig, Mqtt5EnhancedAuthMechanism mqtt5EnhancedAuthMechanism) {
        this.f18032h = mqttClientConfig;
        this.f18033i = mqtt5EnhancedAuthMechanism;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableFuture A(MqttAuth mqttAuth, MqttAuthBuilder mqttAuthBuilder) {
        return this.f18033i.j(this.f18032h, mqttAuth, mqttAuthBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(MqttAuthBuilder mqttAuthBuilder, ChannelHandlerContext channelHandlerContext) {
        this.f18034j = MqttAuthState.WAIT_FOR_SERVER;
        channelHandlerContext.writeAndFlush(mqttAuthBuilder.a()).addListener((GenericFutureListener<? extends Future<? super Void>>) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(MqttAuth mqttAuth, ChannelHandlerContext channelHandlerContext, Throwable th) {
        MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.NOT_AUTHORIZED, new Mqtt5AuthException(mqttAuth, "Server auth not accepted."));
    }

    private void E(ChannelHandlerContext channelHandlerContext, final MqttAuth mqttAuth) {
        if (this.f18034j != MqttAuthState.WAIT_FOR_SERVER) {
            MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5AuthException(mqttAuth, "Must not receive AUTH with reason code CONTINUE_AUTHENTICATION if client side AUTH is pending."));
            return;
        }
        final MqttAuthBuilder mqttAuthBuilder = new MqttAuthBuilder(Mqtt5AuthReasonCode.CONTINUE_AUTHENTICATION, v());
        this.f18034j = MqttAuthState.IN_PROGRESS_RESPONSE;
        u(new Supplier() { // from class: com.hivemq.client.internal.mqtt.handler.auth.b
            @Override // j$.util.function.Supplier
            public final Object get() {
                CompletableFuture A;
                A = AbstractMqttAuthHandler.this.A(mqttAuth, mqttAuthBuilder);
                return A;
            }
        }, new Consumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.c
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                AbstractMqttAuthHandler.this.B(mqttAuthBuilder, (ChannelHandlerContext) obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        }, new BiConsumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.d
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                AbstractMqttAuthHandler.C(MqttAuth.this, (ChannelHandlerContext) obj, (Throwable) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        });
    }

    private boolean H(ChannelHandlerContext channelHandlerContext, MqttAuth mqttAuth) {
        if (!mqttAuth.getMethod().equals(v())) {
            MqttDisconnectUtil.d(channelHandlerContext.channel(), Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, new Mqtt5AuthException(mqttAuth, "Auth method in AUTH must be the same as in the CONNECT."));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(final BiConsumer biConsumer, final Consumer consumer, Void r42, final Throwable th) {
        this.f18032h.c(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.auth.h
            @Override // java.lang.Runnable
            public final void run() {
                AbstractMqttAuthHandler.this.y(th, biConsumer, consumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(final BiConsumer biConsumer, final Consumer consumer, final Boolean bool, final Throwable th) {
        this.f18032h.c(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.auth.g
            @Override // java.lang.Runnable
            public final void run() {
                AbstractMqttAuthHandler.this.z(th, biConsumer, bool, consumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Throwable th, BiConsumer biConsumer, Consumer consumer) {
        ChannelHandlerContext channelHandlerContext = this.f18020f;
        if (channelHandlerContext == null) {
            return;
        }
        if (th != null) {
            f18031k.error("Auth cancelled. Unexpected exception thrown by auth mechanism.", th);
            biConsumer.accept(this.f18020f, th);
            return;
        }
        consumer.accept(channelHandlerContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(Throwable th, BiConsumer biConsumer, Boolean bool, Consumer consumer) {
        if (this.f18020f == null) {
            return;
        }
        if (th != null) {
            f18031k.error("Auth cancelled. Unexpected exception thrown by auth mechanism.", th);
            biConsumer.accept(this.f18020f, th);
        } else if (bool == null) {
            f18031k.error("Auth cancelled. Unexpected null result returned by auth mechanism.");
            biConsumer.accept(this.f18020f, new NullPointerException("Result returned by auth mechanism must not be null."));
        } else if (!bool.booleanValue()) {
            biConsumer.accept(this.f18020f, null);
        } else {
            consumer.accept(this.f18020f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void D(ChannelHandlerContext channelHandlerContext, MqttAuth mqttAuth) {
        b();
        if (H(channelHandlerContext, mqttAuth)) {
            int i8 = AnonymousClass1.f18035a[mqttAuth.h().ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        G(channelHandlerContext, mqttAuth);
                        return;
                    }
                    return;
                }
                F(channelHandlerContext, mqttAuth);
                return;
            }
            E(channelHandlerContext, mqttAuth);
        }
    }

    abstract void F(ChannelHandlerContext channelHandlerContext, MqttAuth mqttAuth);

    abstract void G(ChannelHandlerContext channelHandlerContext, MqttAuth mqttAuth);

    @Override // com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler
    protected final long d() {
        return TimeUnit.SECONDS.toMillis(this.f18033i.c());
    }

    @Override // com.hivemq.client.internal.mqtt.handler.util.MqttTimeoutInboundHandler
    protected final Mqtt5DisconnectReasonCode f() {
        return Mqtt5DisconnectReasonCode.NOT_AUTHORIZED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            f18031k.error("Auth cancelled. Unexpected exception thrown by auth mechanism.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Supplier<CompletableFuture<Void>> supplier, final Consumer<ChannelHandlerContext> consumer, final BiConsumer<ChannelHandlerContext, Throwable> biConsumer) {
        if (this.f18020f == null) {
            return;
        }
        try {
            supplier.get().whenComplete((java.util.function.BiConsumer<? super Void, ? super Throwable>) BiConsumer.Wrapper.convert(new BiConsumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.f
                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    AbstractMqttAuthHandler.this.w(biConsumer, consumer, (Void) obj, (Throwable) obj2);
                }

                @Override // j$.util.function.BiConsumer
                public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer2) {
                    return BiConsumer.CC.$default$andThen(this, biConsumer2);
                }
            }));
        } catch (Throwable th) {
            f18031k.error("Auth cancelled. Unexpected exception thrown by auth mechanism.", th);
            biConsumer.accept(this.f18020f, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(Supplier<CompletableFuture<Boolean>> supplier, final Consumer<ChannelHandlerContext> consumer, final BiConsumer<ChannelHandlerContext, Throwable> biConsumer) {
        if (this.f18020f == null) {
            return;
        }
        try {
            supplier.get().whenComplete((java.util.function.BiConsumer<? super Boolean, ? super Throwable>) BiConsumer.Wrapper.convert(new BiConsumer() { // from class: com.hivemq.client.internal.mqtt.handler.auth.e
                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    AbstractMqttAuthHandler.this.x(biConsumer, consumer, (Boolean) obj, (Throwable) obj2);
                }

                @Override // j$.util.function.BiConsumer
                public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer2) {
                    return BiConsumer.CC.$default$andThen(this, biConsumer2);
                }
            }));
        } catch (Throwable th) {
            f18031k.error("Auth cancelled. Unexpected exception thrown by auth mechanism.", th);
            biConsumer.accept(this.f18020f, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttUtf8StringImpl v() {
        return (MqttUtf8StringImpl) Checks.g(this.f18033i.getMethod(), MqttUtf8StringImpl.class, "Auth method");
    }
}
