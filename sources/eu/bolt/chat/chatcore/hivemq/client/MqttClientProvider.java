package eu.bolt.chat.chatcore.hivemq.client;

import android.annotation.SuppressLint;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedContext;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedListener;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedListener;
import com.hivemq.client.mqtt.lifecycle.MqttClientReconnector;
import com.hivemq.client.mqtt.lifecycle.MqttDisconnectSource;
import com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder;
import com.hivemq.client.mqtt.mqtt3.Mqtt3RxClient;
import com.hivemq.client.mqtt.mqtt3.exceptions.Mqtt3ConnAckException;
import com.hivemq.client.mqtt.mqtt3.lifecycle.Mqtt3ClientReconnector;
import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuth;
import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAckReturnCode;
import eu.bolt.chat.chatcore.ChatKit;
import eu.bolt.chat.chatcore.connection.ChatConnectionController;
import eu.bolt.chat.chatcore.entity.ChatConnectionState;
import eu.bolt.chat.chatcore.entity.connection.ChatConnectionEntity;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.chat.tools.logger.Logger;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import j$.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: MqttClientProvider.kt */
/* loaded from: classes5.dex */
public final class MqttClientProvider {

    /* renamed from: d  reason: collision with root package name */
    private static final Companion f38228d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final ChatConnectionController f38229a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f38230b;

    /* renamed from: c  reason: collision with root package name */
    private Mqtt3SimpleAuth f38231c;

    /* compiled from: MqttClientProvider.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public MqttClientProvider(ChatConnectionController chatConnectionController, Logger chatLogger) {
        Intrinsics.f(chatConnectionController, "chatConnectionController");
        Intrinsics.f(chatLogger, "chatLogger");
        this.f38229a = chatConnectionController;
        this.f38230b = chatLogger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean C(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Mqtt3ClientReconnector n(Mqtt3ClientReconnector mqtt3ClientReconnector, Mqtt3SimpleAuth mqtt3SimpleAuth) {
        Object b8 = mqtt3ClientReconnector.a().a(mqtt3SimpleAuth).b();
        Intrinsics.e(b8, "connectWith()\n          …          .applyConnect()");
        return (Mqtt3ClientReconnector) b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Mqtt3SimpleAuth o() {
        UserInfoProvider j8 = ChatKit.f37877a.j();
        byte[] bytes = j8.h().getBytes(Charsets.f51135b);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        Mqtt3SimpleAuth build = r0.a.a().a(j8.p()).b(bytes).build();
        Intrinsics.e(build, "builder()\n            .u…y())\n            .build()");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MqttClientProvider this$0, MqttClientConnectedContext it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        Logger logger = this$0.f38230b;
        logger.b("[Mqtt3Client] Connected " + it.a());
        this$0.f38229a.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MqttClientProvider this$0, MqttClientDisconnectedContext context) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(context, "context");
        Logger logger = this$0.f38230b;
        logger.b("[Mqtt3Client] Disconnected MQTT source= " + context.getSource() + ", cause= " + context.b() + ", config= " + context.a());
        Throwable b8 = context.b();
        Intrinsics.e(b8, "context.cause");
        if ((b8 instanceof Mqtt3ConnAckException) && ((Mqtt3ConnAckException) b8).a().a() == Mqtt3ConnAckReturnCode.NOT_AUTHORIZED) {
            this$0.f38230b.a(b8, "[Mqtt3Client] Disconnected because of connection authorization failure");
            this$0.y(context);
        } else if (context.getSource() == MqttDisconnectSource.USER) {
            this$0.f38230b.b("[Mqtt3Client] Disconnected by user");
            this$0.y(context);
        } else if (context.getSource() == MqttDisconnectSource.SERVER) {
            this$0.v(context);
        } else if (context.getSource() == MqttDisconnectSource.CLIENT) {
            this$0.v(context);
        }
    }

    private final Observable<Boolean> s() {
        return ChatKit.f37877a.e().a();
    }

    private final Observable<Boolean> t() {
        return ChatKit.f37877a.h().a();
    }

    private final MqttClientReconnector u(final MqttClientDisconnectedContext mqttClientDisconnectedContext, final Function2<? super Boolean, ? super Throwable, Unit> function2) {
        MqttClientReconnector c8 = mqttClientDisconnectedContext.c();
        CompletableFuture<Boolean> x7 = x(mqttClientDisconnectedContext);
        final Function2<Boolean, Throwable, Unit> function22 = new Function2<Boolean, Throwable, Unit>() { // from class: eu.bolt.chat.chatcore.hivemq.client.MqttClientProvider$reconnect$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public final void b(Boolean result, Throwable th) {
                Mqtt3SimpleAuth o8;
                Mqtt3SimpleAuth mqtt3SimpleAuth;
                ChatConnectionController chatConnectionController;
                Function2<Boolean, Throwable, Unit> function23 = function2;
                Intrinsics.e(result, "result");
                function23.s(result, th);
                if (!result.booleanValue()) {
                    chatConnectionController = this.f38229a;
                    chatConnectionController.a();
                }
                o8 = this.o();
                if (result.booleanValue()) {
                    mqtt3SimpleAuth = this.f38231c;
                    if (!Intrinsics.a(o8, mqtt3SimpleAuth)) {
                        this.f38231c = o8;
                        MqttClientProvider mqttClientProvider = this;
                        MqttClientReconnector c9 = mqttClientDisconnectedContext.c();
                        Intrinsics.d(c9, "null cannot be cast to non-null type com.hivemq.client.mqtt.mqtt3.lifecycle.Mqtt3ClientReconnector");
                        mqttClientProvider.n((Mqtt3ClientReconnector) c9, o8);
                        return;
                    }
                }
                mqttClientDisconnectedContext.c().b(result.booleanValue());
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(Boolean bool, Throwable th) {
                b(bool, th);
                return Unit.f50853a;
            }
        };
        MqttClientReconnector d8 = c8.d(x7, new BiConsumer() { // from class: eu.bolt.chat.chatcore.hivemq.client.c
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MqttClientProvider.w(Function2.this, obj, obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        });
        Intrinsics.e(d8, "@SuppressWarnings(\"NewAp…)\n            }\n        }");
        return d8;
    }

    private final void v(final MqttClientDisconnectedContext mqttClientDisconnectedContext) {
        u(mqttClientDisconnectedContext, new Function2<Boolean, Throwable, Unit>() { // from class: eu.bolt.chat.chatcore.hivemq.client.MqttClientProvider$reconnect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void b(boolean z7, Throwable th) {
                Logger logger;
                logger = MqttClientProvider.this.f38230b;
                logger.b("[Mqtt3Client] Trying to reconnect after " + mqttClientDisconnectedContext.getSource().name() + " disconnection result = " + z7 + " throwable= " + th);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(Boolean bool, Throwable th) {
                b(bool.booleanValue(), th);
                return Unit.f50853a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.s(obj, obj2);
    }

    private final CompletableFuture<Boolean> x(MqttClientDisconnectedContext mqttClientDisconnectedContext) {
        Logger logger = this.f38230b;
        logger.f("[reconnectFuture] context.reconnector.attempts " + mqttClientDisconnectedContext.c().c());
        CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();
        if (mqttClientDisconnectedContext.c().c() > 3) {
            completableFuture.complete(Boolean.FALSE);
        } else if (mqttClientDisconnectedContext.c().c() <= 3) {
            this.f38229a.b(ChatConnectionState.RECONNECTING);
            z();
            try {
                TimeUnit.SECONDS.sleep(mqttClientDisconnectedContext.c().c());
                completableFuture.complete(Boolean.TRUE);
            } catch (InterruptedException e8) {
                this.f38230b.a(e8, "Fail to wait for reconnect");
                completableFuture.complete(Boolean.FALSE);
            }
        } else {
            completableFuture.complete(Boolean.FALSE);
        }
        return completableFuture;
    }

    private final void y(MqttClientDisconnectedContext mqttClientDisconnectedContext) {
        this.f38229a.e();
        mqttClientDisconnectedContext.c().b(false);
    }

    private final void z() {
        this.f38230b.f("[waitForConnectionSync]");
        Observable<Boolean> t7 = t();
        final Function1<Notification<Boolean>, Unit> function1 = new Function1<Notification<Boolean>, Unit>() { // from class: eu.bolt.chat.chatcore.hivemq.client.MqttClientProvider$waitForConnectionSync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Notification<Boolean> notification) {
                Logger logger;
                logger = MqttClientProvider.this.f38230b;
                logger.f("Triggered isNetworkConnected: " + notification);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notification<Boolean> notification) {
                b(notification);
                return Unit.f50853a;
            }
        };
        Observable<Boolean> doOnEach = t7.doOnEach(new Consumer() { // from class: eu.bolt.chat.chatcore.hivemq.client.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MqttClientProvider.A(Function1.this, obj);
            }
        });
        Observable<Boolean> s7 = s();
        final Function1<Notification<Boolean>, Unit> function12 = new Function1<Notification<Boolean>, Unit>() { // from class: eu.bolt.chat.chatcore.hivemq.client.MqttClientProvider$waitForConnectionSync$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Notification<Boolean> notification) {
                Logger logger;
                logger = MqttClientProvider.this.f38230b;
                logger.f("Triggered isAppInForeground: " + notification);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notification<Boolean> notification) {
                b(notification);
                return Unit.f50853a;
            }
        };
        Observable<Boolean> doOnEach2 = s7.doOnEach(new Consumer() { // from class: eu.bolt.chat.chatcore.hivemq.client.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MqttClientProvider.B(Function1.this, obj);
            }
        });
        final Function2<Boolean, Boolean, Boolean> function2 = new Function2<Boolean, Boolean, Boolean>() { // from class: eu.bolt.chat.chatcore.hivemq.client.MqttClientProvider$waitForConnectionSync$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Boolean s(Boolean isNetworkConnected, Boolean isAppInForeground) {
                Logger logger;
                boolean z7;
                Intrinsics.f(isNetworkConnected, "isNetworkConnected");
                Intrinsics.f(isAppInForeground, "isAppInForeground");
                logger = MqttClientProvider.this.f38230b;
                logger.f("[waitForConnectionSync] isNetworkConnected " + isNetworkConnected.booleanValue() + " isAppInForeground " + isAppInForeground.booleanValue());
                if (isNetworkConnected.booleanValue() && isAppInForeground.booleanValue()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable observeOn = Observable.combineLatest(doOnEach, doOnEach2, new BiFunction() { // from class: eu.bolt.chat.chatcore.hivemq.client.f
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean C;
                C = MqttClientProvider.C(Function2.this, obj, obj2);
                return C;
            }
        }).observeOn(Schedulers.e());
        final MqttClientProvider$waitForConnectionSync$4 mqttClientProvider$waitForConnectionSync$4 = new Function1<Boolean, Boolean>() { // from class: eu.bolt.chat.chatcore.hivemq.client.MqttClientProvider$waitForConnectionSync$4
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Boolean it) {
                Intrinsics.f(it, "it");
                return it;
            }
        };
        observeOn.filter(new Predicate() { // from class: eu.bolt.chat.chatcore.hivemq.client.g
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean D;
                D = MqttClientProvider.D(Function1.this, obj);
                return D;
            }
        }).blockingFirst();
    }

    @SuppressLint({"CheckResult"})
    public final Mqtt3RxClient p(ChatConnectionEntity chatConnectionEntity) {
        Intrinsics.f(chatConnectionEntity, "chatConnectionEntity");
        UserInfoProvider j8 = ChatKit.f37877a.j();
        Mqtt3SimpleAuth o8 = o();
        this.f38231c = o8;
        Mqtt3ClientBuilder h8 = q0.a.a().f(j8.f()).c(chatConnectionEntity.b()).h(chatConnectionEntity.c());
        if (chatConnectionEntity.e()) {
            h8.g(p0.b.a().build());
        }
        Mqtt3RxClient j9 = h8.d(p0.c.a().a(chatConnectionEntity.a()).b(chatConnectionEntity.d()).build()).a(o8).b(new MqttClientConnectedListener() { // from class: eu.bolt.chat.chatcore.hivemq.client.a
            @Override // com.hivemq.client.mqtt.lifecycle.MqttClientConnectedListener
            public final void a(MqttClientConnectedContext mqttClientConnectedContext) {
                MqttClientProvider.q(MqttClientProvider.this, mqttClientConnectedContext);
            }
        }).i(new MqttClientDisconnectedListener() { // from class: eu.bolt.chat.chatcore.hivemq.client.b
            @Override // com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedListener
            public final void a(MqttClientDisconnectedContext mqttClientDisconnectedContext) {
                MqttClientProvider.r(MqttClientProvider.this, mqttClientDisconnectedContext);
            }
        }).j();
        Intrinsics.e(j9, "builder()\n            .i… }\n            .buildRx()");
        return j9;
    }
}
