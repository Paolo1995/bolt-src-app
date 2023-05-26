package eu.bolt.chat.network.engine;

import com.hivemq.client.mqtt.MqttClientState;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.Mqtt3RxClient;
import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuth;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3Connect;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishResult;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3Subscribe;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscribeBuilder$Start;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.suback.Mqtt3SubAck;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.suback.Mqtt3SubAckReturnCode;
import com.hivemq.client.rx.FlowableWithSingle;
import eu.bolt.chat.data.ChatCredentials;
import eu.bolt.chat.network.CredentialsProvider;
import eu.bolt.chat.network.data.MqttConnection;
import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.data.QoS;
import eu.bolt.chat.network.engine.AndroidMqttClient;
import eu.bolt.chat.network.exception.DisconnectException;
import eu.bolt.chat.network.exception.SubscriptionException;
import eu.bolt.chat.network.mapper.ExceptionMapper;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import j$.util.Optional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import s0.a;

/* compiled from: AndroidMqttClient.kt */
/* loaded from: classes5.dex */
public final class AndroidMqttClient implements PlatformMqttClient {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f39374i = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Mqtt3RxClient f39375a;

    /* renamed from: b  reason: collision with root package name */
    private final CredentialsProvider f39376b;

    /* renamed from: c  reason: collision with root package name */
    private final ExceptionMapper f39377c;

    /* renamed from: d  reason: collision with root package name */
    private final MqttConnection f39378d;

    /* renamed from: e  reason: collision with root package name */
    private final PlatformMqttClientDelegate f39379e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f39380f;

    /* renamed from: g  reason: collision with root package name */
    private final CompositeDisposable f39381g;

    /* renamed from: h  reason: collision with root package name */
    private final HashMap<String, Disposable> f39382h;

    /* compiled from: AndroidMqttClient.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AndroidMqttClient.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39383a;

        static {
            int[] iArr = new int[MqttClientState.values().length];
            try {
                iArr[MqttClientState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MqttClientState.DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MqttClientState.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MqttClientState.CONNECTING_RECONNECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MqttClientState.DISCONNECTED_RECONNECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f39383a = iArr;
        }
    }

    public AndroidMqttClient(Mqtt3RxClient client, CredentialsProvider credentialsProvider, ExceptionMapper exceptionMapper, MqttConnection connectionConfig, PlatformMqttClientDelegate delegate) {
        Intrinsics.f(client, "client");
        Intrinsics.f(credentialsProvider, "credentialsProvider");
        Intrinsics.f(exceptionMapper, "exceptionMapper");
        Intrinsics.f(connectionConfig, "connectionConfig");
        Intrinsics.f(delegate, "delegate");
        this.f39375a = client;
        this.f39376b = credentialsProvider;
        this.f39377c = exceptionMapper;
        this.f39378d = connectionConfig;
        this.f39379e = delegate;
        this.f39380f = new AtomicInteger(0);
        this.f39381g = new CompositeDisposable();
        this.f39382h = new HashMap<>(1);
    }

    private final Mqtt3Connect l(MqttConnection mqttConnection, ChatCredentials chatCredentials) {
        Mqtt3Connect build = a.a().a(m(chatCredentials)).d(mqttConnection.a()).c(mqttConnection.e() & 65535).build();
        Intrinsics.e(build, "builder()\n            .s…t())\n            .build()");
        return build;
    }

    private final Mqtt3SimpleAuth m(ChatCredentials chatCredentials) {
        ChatCredentials.Basic basic;
        byte[] t7;
        String str = null;
        if (chatCredentials instanceof ChatCredentials.Basic) {
            basic = (ChatCredentials.Basic) chatCredentials;
        } else {
            basic = null;
        }
        if (basic != null) {
            str = basic.c();
        }
        if (str == null) {
            str = "";
        }
        t7 = StringsKt__StringsJVMKt.t(chatCredentials.a().c());
        Mqtt3SimpleAuth build = r0.a.a().a(str).b(t7).build();
        Intrinsics.e(build, "builder()\n            .u…ord)\n            .build()");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClient
    public void a() {
        int i8 = WhenMappings.f39383a[this.f39375a.getState().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                this.f39375a.c(l(this.f39378d, this.f39376b.a())).I(Functions.g(), Functions.g()).dispose();
                return;
            }
            return;
        }
        this.f39379e.f();
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClient
    public void b() {
        Collection<Disposable> values = this.f39382h.values();
        Intrinsics.e(values, "subscriptions.values");
        for (Disposable disposable : values) {
            disposable.dispose();
        }
        this.f39382h.clear();
        this.f39381g.d();
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClient
    public void c(final String topic, QoS qos) {
        MqttQos d8;
        Intrinsics.f(topic, "topic");
        Intrinsics.f(qos, "qos");
        d8 = AndroidMqttClientKt.d(qos);
        Mqtt3Subscribe build = ((Mqtt3SubscribeBuilder$Start.Complete) ((Mqtt3SubscribeBuilder$Start.Complete) u0.a.a().b(topic)).a(d8)).build();
        Intrinsics.e(build, "builder()\n            .t…m())\n            .build()");
        FlowableWithSingle<Mqtt3Publish, Mqtt3SubAck> e8 = this.f39375a.e(build);
        final Function1<Mqtt3SubAck, Unit> function1 = new Function1<Mqtt3SubAck, Unit>() { // from class: eu.bolt.chat.network.engine.AndroidMqttClient$subscribe$subscription$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Mqtt3SubAck mqtt3SubAck) {
                PlatformMqttClientDelegate platformMqttClientDelegate;
                PlatformMqttClientDelegate platformMqttClientDelegate2;
                List<Mqtt3SubAckReturnCode> a8 = mqtt3SubAck.a();
                Intrinsics.e(a8, "ack.returnCodes");
                boolean z7 = false;
                if (!(a8 instanceof Collection) || !a8.isEmpty()) {
                    Iterator<T> it = a8.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((Mqtt3SubAckReturnCode) it.next()).c()) {
                            z7 = true;
                            break;
                        }
                    }
                }
                if (!z7) {
                    platformMqttClientDelegate = AndroidMqttClient.this.f39379e;
                    platformMqttClientDelegate.e(topic);
                    return;
                }
                SubscriptionException subscriptionException = new SubscriptionException("SUBACK return codes = " + mqtt3SubAck.a());
                platformMqttClientDelegate2 = AndroidMqttClient.this.f39379e;
                platformMqttClientDelegate2.l(topic, subscriptionException);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Mqtt3SubAck mqtt3SubAck) {
                b(mqtt3SubAck);
                return Unit.f50853a;
            }
        };
        FlowableWithSingle<Mqtt3Publish, Mqtt3SubAck> i02 = e8.i0(new Consumer() { // from class: n6.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AndroidMqttClient.p(Function1.this, obj);
            }
        });
        final Function1<Mqtt3Publish, Unit> function12 = new Function1<Mqtt3Publish, Unit>() { // from class: eu.bolt.chat.network.engine.AndroidMqttClient$subscribe$subscription$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Mqtt3Publish message) {
                PlatformMqttClientDelegate platformMqttClientDelegate;
                MqttMessage f8;
                platformMqttClientDelegate = AndroidMqttClient.this.f39379e;
                Intrinsics.e(message, "message");
                f8 = AndroidMqttClientKt.f(message);
                platformMqttClientDelegate.i(f8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Mqtt3Publish mqtt3Publish) {
                b(mqtt3Publish);
                return Unit.f50853a;
            }
        };
        Consumer<? super T> consumer = new Consumer() { // from class: n6.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AndroidMqttClient.q(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: eu.bolt.chat.network.engine.AndroidMqttClient$subscribe$subscription$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                PlatformMqttClientDelegate platformMqttClientDelegate;
                ExceptionMapper exceptionMapper;
                platformMqttClientDelegate = AndroidMqttClient.this.f39379e;
                String str = topic;
                exceptionMapper = AndroidMqttClient.this.f39377c;
                Intrinsics.e(error, "error");
                platformMqttClientDelegate.l(str, exceptionMapper.g(error));
            }
        };
        Disposable put = this.f39382h.put(topic, i02.V(consumer, new Consumer() { // from class: n6.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AndroidMqttClient.r(Function1.this, obj);
            }
        }));
        if (put != null) {
            put.dispose();
        }
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClient
    public int d(MqttMessage message, QoS qos) {
        MqttQos d8;
        Mqtt3Publish e8;
        Intrinsics.f(message, "message");
        Intrinsics.f(qos, "qos");
        d8 = AndroidMqttClientKt.d(qos);
        e8 = AndroidMqttClientKt.e(message, d8);
        final int incrementAndGet = this.f39380f.incrementAndGet();
        Flowable<Mqtt3PublishResult> f8 = this.f39375a.f(Flowable.I(e8));
        final Function1<Mqtt3PublishResult, Unit> function1 = new Function1<Mqtt3PublishResult, Unit>() { // from class: eu.bolt.chat.network.engine.AndroidMqttClient$publish$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Mqtt3PublishResult mqtt3PublishResult) {
                PlatformMqttClientDelegate platformMqttClientDelegate;
                PlatformMqttClientDelegate platformMqttClientDelegate2;
                ExceptionMapper exceptionMapper;
                Optional<Throwable> error = mqtt3PublishResult.getError();
                Intrinsics.e(error, "result.error");
                if (error.isPresent()) {
                    platformMqttClientDelegate2 = AndroidMqttClient.this.f39379e;
                    int i8 = incrementAndGet;
                    exceptionMapper = AndroidMqttClient.this.f39377c;
                    Throwable th = error.get();
                    Intrinsics.e(th, "error.get()");
                    platformMqttClientDelegate2.a(i8, exceptionMapper.f(th));
                    return;
                }
                platformMqttClientDelegate = AndroidMqttClient.this.f39379e;
                platformMqttClientDelegate.h(incrementAndGet);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Mqtt3PublishResult mqtt3PublishResult) {
                b(mqtt3PublishResult);
                return Unit.f50853a;
            }
        };
        Consumer<? super Mqtt3PublishResult> consumer = new Consumer() { // from class: n6.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AndroidMqttClient.n(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: eu.bolt.chat.network.engine.AndroidMqttClient$publish$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                PlatformMqttClientDelegate platformMqttClientDelegate;
                ExceptionMapper exceptionMapper;
                platformMqttClientDelegate = AndroidMqttClient.this.f39379e;
                int i8 = incrementAndGet;
                exceptionMapper = AndroidMqttClient.this.f39377c;
                Intrinsics.e(error, "error");
                platformMqttClientDelegate.a(i8, exceptionMapper.f(error));
            }
        };
        this.f39381g.b(f8.V(consumer, new Consumer() { // from class: n6.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AndroidMqttClient.o(Function1.this, obj);
            }
        }));
        return incrementAndGet;
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClient
    public void disconnect() {
        if (this.f39375a.getState() == MqttClientState.DISCONNECTED) {
            this.f39379e.c(new DisconnectException("Client sent DISCONNECT"));
        } else {
            this.f39375a.disconnect().G(Functions.f47618c, Functions.g()).dispose();
        }
    }
}
