package eu.bolt.chat.chatcore.hivemq;

import android.annotation.SuppressLint;
import com.google.gson.Gson;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.Mqtt3RxClient;
import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAck;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishResult;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscribeBuilder$Publishes$Start;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.suback.Mqtt3SubAck;
import com.hivemq.client.rx.FlowableWithSingle;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.entity.ChatConnectionState;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageSeenConfirmationEntity;
import eu.bolt.chat.chatcore.entity.ChatRequestReplySuggestionsEntity;
import eu.bolt.chat.chatcore.entity.connection.ChatConnectionEntity;
import eu.bolt.chat.chatcore.hivemq.client.MqttClientProvider;
import eu.bolt.chat.chatcore.mqtt.MqttController;
import eu.bolt.chat.chatcore.network.error.ClientNotConnectedException;
import eu.bolt.chat.chatcore.network.model.MqttEventRequest;
import eu.bolt.chat.chatcore.network.model.MqttEventResponse;
import eu.bolt.chat.chatcore.network.repo.ChatEvent;
import eu.bolt.chat.chatcore.network.repo.MqttChatEventMapper;
import eu.bolt.chat.chatcore.user.MqttInfoProvider;
import eu.bolt.chat.tools.logger.Logger;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.reactivestreams.Publisher;

/* compiled from: HiveMqttController.kt */
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public final class HiveMqttController implements MqttController {

    /* renamed from: i  reason: collision with root package name */
    private static final Companion f38204i = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final MqttClientProvider f38205a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f38206b;

    /* renamed from: c  reason: collision with root package name */
    private final Gson f38207c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatConnectionProvider f38208d;

    /* renamed from: e  reason: collision with root package name */
    private final MqttInfoProvider f38209e;

    /* renamed from: f  reason: collision with root package name */
    private final MqttChatEventMapper f38210f;

    /* renamed from: g  reason: collision with root package name */
    private final Charset f38211g;

    /* renamed from: h  reason: collision with root package name */
    private Mqtt3RxClient f38212h;

    /* compiled from: HiveMqttController.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public HiveMqttController(MqttClientProvider clientProvider, Logger logger, Gson gson, ChatConnectionProvider connectionProvider, MqttInfoProvider mqttInfoProvider, MqttChatEventMapper chatEventMapper) {
        Intrinsics.f(clientProvider, "clientProvider");
        Intrinsics.f(logger, "logger");
        Intrinsics.f(gson, "gson");
        Intrinsics.f(connectionProvider, "connectionProvider");
        Intrinsics.f(mqttInfoProvider, "mqttInfoProvider");
        Intrinsics.f(chatEventMapper, "chatEventMapper");
        this.f38205a = clientProvider;
        this.f38206b = logger;
        this.f38207c = gson;
        this.f38208d = connectionProvider;
        this.f38209e = mqttInfoProvider;
        this.f38210f = chatEventMapper;
        this.f38211g = Charsets.f51135b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flowable A(HiveMqttController this$0, Throwable it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.f38206b.c(it);
        return Flowable.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MqttEventResponse B(Mqtt3Publish publish, HiveMqttController this$0) {
        Intrinsics.f(publish, "$publish");
        Intrinsics.f(this$0, "this$0");
        byte[] a8 = publish.a();
        Intrinsics.e(a8, "publish.payloadAsBytes");
        String str = new String(a8, Charsets.f51135b);
        Logger logger = this$0.f38206b;
        logger.g("got mqtt message " + str);
        return (MqttEventResponse) this$0.f38207c.fromJson(str, (Class<Object>) MqttEventResponse.class);
    }

    @SuppressLint({"NewApi"})
    private final Completable C(MqttEventRequest mqttEventRequest) {
        if (this.f38208d.c().f()) {
            Completable t7 = Completable.t(new ClientNotConnectedException());
            Intrinsics.e(t7, "error(ClientNotConnectedException())");
            return t7;
        }
        Flowable<Mqtt3Publish> y7 = y(mqttEventRequest);
        Flowable<Mqtt3PublishResult> v7 = v();
        Mqtt3RxClient mqtt3RxClient = this.f38212h;
        if (mqtt3RxClient != null) {
            Flowable c02 = Flowable.K(mqtt3RxClient.f(y7), v7).c0(1L);
            final HiveMqttController$sendEvent$1 hiveMqttController$sendEvent$1 = new Function1<Mqtt3PublishResult, CompletableSource>() { // from class: eu.bolt.chat.chatcore.hivemq.HiveMqttController$sendEvent$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final CompletableSource invoke(Mqtt3PublishResult it) {
                    Intrinsics.f(it, "it");
                    if (it.getError().isPresent()) {
                        return Completable.t(it.getError().get());
                    }
                    return Completable.g();
                }
            };
            Completable z7 = c02.z(new Function() { // from class: eu.bolt.chat.chatcore.hivemq.d
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    CompletableSource D;
                    D = HiveMqttController.D(Function1.this, obj);
                    return D;
                }
            });
            Intrinsics.e(z7, "merge(requireNotNull(cli…          }\n            }");
            return z7;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher F(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatEvent H(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ChatEvent) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Flowable<Mqtt3PublishResult> v() {
        Observable<ChatConnectionState> d8 = this.f38208d.d();
        final HiveMqttController$connectionSingleElementFlowable$1 hiveMqttController$connectionSingleElementFlowable$1 = new Function1<ChatConnectionState, Boolean>() { // from class: eu.bolt.chat.chatcore.hivemq.HiveMqttController$connectionSingleElementFlowable$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ChatConnectionState it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it == ChatConnectionState.DISCONNECTED) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<ChatConnectionState> take = d8.filter(new Predicate() { // from class: eu.bolt.chat.chatcore.hivemq.i
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean w7;
                w7 = HiveMqttController.w(Function1.this, obj);
                return w7;
            }
        }).take(1L);
        final HiveMqttController$connectionSingleElementFlowable$2 hiveMqttController$connectionSingleElementFlowable$2 = new Function1<ChatConnectionState, ObservableSource<? extends Mqtt3PublishResult>>() { // from class: eu.bolt.chat.chatcore.hivemq.HiveMqttController$connectionSingleElementFlowable$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends Mqtt3PublishResult> invoke(ChatConnectionState it) {
                Intrinsics.f(it, "it");
                return Observable.error(new ClientNotConnectedException());
            }
        };
        Flowable<Mqtt3PublishResult> flowable = take.flatMap(new Function() { // from class: eu.bolt.chat.chatcore.hivemq.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource x7;
                x7 = HiveMqttController.x(Function1.this, obj);
                return x7;
            }
        }).toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.e(flowable, "connectionProvider.obser…kpressureStrategy.LATEST)");
        return flowable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    private final Flowable<Mqtt3Publish> y(MqttEventRequest mqttEventRequest) {
        String json = this.f38207c.toJson(mqttEventRequest);
        Intrinsics.e(json, "gson.toJson(chatSendMessageRequest)");
        byte[] bytes = json.getBytes(this.f38211g);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        Flowable<Mqtt3Publish> I = Flowable.I(t0.a.a().c(this.f38209e.j()).a(MqttQos.AT_LEAST_ONCE).b(bytes).build());
        Intrinsics.e(I, "just(\n            Mqtt3P…       .build()\n        )");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flowable<MqttEventResponse> z(final Mqtt3Publish mqtt3Publish) {
        Flowable<MqttEventResponse> S = Flowable.G(new Callable() { // from class: eu.bolt.chat.chatcore.hivemq.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                MqttEventResponse B;
                B = HiveMqttController.B(Mqtt3Publish.this, this);
                return B;
            }
        }).S(new Function() { // from class: eu.bolt.chat.chatcore.hivemq.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Flowable A;
                A = HiveMqttController.A(HiveMqttController.this, (Throwable) obj);
                return A;
            }
        });
        Intrinsics.e(S, "fromCallable {\n         …owable.empty()\n        })");
        return S;
    }

    @Override // eu.bolt.chat.chatcore.mqtt.MqttController
    public Completable a(ChatRequestReplySuggestionsEntity replySuggestionsRequest) {
        Intrinsics.f(replySuggestionsRequest, "replySuggestionsRequest");
        return C(this.f38210f.a(replySuggestionsRequest));
    }

    @Override // eu.bolt.chat.chatcore.mqtt.MqttController
    public Completable d(ChatConnectionEntity chatConnectionEntity, Function0<Unit> onClientInit) {
        Intrinsics.f(chatConnectionEntity, "chatConnectionEntity");
        Intrinsics.f(onClientInit, "onClientInit");
        this.f38212h = this.f38205a.p(chatConnectionEntity);
        onClientInit.invoke();
        Mqtt3RxClient mqtt3RxClient = this.f38212h;
        if (mqtt3RxClient != null) {
            final Function1<Mqtt3ConnAck, Unit> function1 = new Function1<Mqtt3ConnAck, Unit>() { // from class: eu.bolt.chat.chatcore.hivemq.HiveMqttController$connect$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(Mqtt3ConnAck mqtt3ConnAck) {
                    Logger logger;
                    logger = HiveMqttController.this.f38206b;
                    logger.b("on Connect  " + mqtt3ConnAck.a().name());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Mqtt3ConnAck mqtt3ConnAck) {
                    b(mqtt3ConnAck);
                    return Unit.f50853a;
                }
            };
            Single o8 = ((Single) mqtt3RxClient.a().d(false).c(10).b()).o(new Consumer() { // from class: eu.bolt.chat.chatcore.hivemq.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    HiveMqttController.t(Function1.this, obj);
                }
            });
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: eu.bolt.chat.chatcore.hivemq.HiveMqttController$connect$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Logger logger;
                    logger = HiveMqttController.this.f38206b;
                    Intrinsics.e(it, "it");
                    logger.c(it);
                }
            };
            Completable v7 = o8.l(new Consumer() { // from class: eu.bolt.chat.chatcore.hivemq.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    HiveMqttController.u(Function1.this, obj);
                }
            }).v();
            Intrinsics.e(v7, "override fun connect(cha…   .ignoreElement()\n    }");
            return v7;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // eu.bolt.chat.chatcore.mqtt.MqttController
    public Completable disconnect() {
        Completable completable;
        Mqtt3RxClient mqtt3RxClient = this.f38212h;
        if (mqtt3RxClient != null) {
            completable = mqtt3RxClient.disconnect();
        } else {
            completable = null;
        }
        if (completable == null) {
            Completable g8 = Completable.g();
            Intrinsics.e(g8, "complete()");
            return g8;
        }
        return completable;
    }

    @Override // eu.bolt.chat.chatcore.mqtt.MqttController
    public Completable e(ChatMessageSeenConfirmationEntity messagesConfirmation) {
        Intrinsics.f(messagesConfirmation, "messagesConfirmation");
        return C(this.f38210f.d(messagesConfirmation));
    }

    @Override // eu.bolt.chat.chatcore.mqtt.MqttController
    public Completable f(ChatMessageEntity message) {
        Intrinsics.f(message, "message");
        return C(this.f38210f.e(message));
    }

    @Override // eu.bolt.chat.chatcore.mqtt.MqttController
    public Flowable<ChatEvent> g() {
        Mqtt3RxClient mqtt3RxClient = this.f38212h;
        if (mqtt3RxClient != null) {
            final Function1<Mqtt3SubAck, Unit> function1 = new Function1<Mqtt3SubAck, Unit>() { // from class: eu.bolt.chat.chatcore.hivemq.HiveMqttController$subscribeNewChatEvents$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(Mqtt3SubAck mqtt3SubAck) {
                    Logger logger;
                    MqttInfoProvider mqttInfoProvider;
                    logger = HiveMqttController.this.f38206b;
                    mqttInfoProvider = HiveMqttController.this.f38209e;
                    logger.b(mqttInfoProvider.s());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Mqtt3SubAck mqtt3SubAck) {
                    b(mqtt3SubAck);
                    return Unit.f50853a;
                }
            };
            FlowableWithSingle i02 = ((FlowableWithSingle) ((Mqtt3SubscribeBuilder$Publishes$Start.Complete) ((Mqtt3SubscribeBuilder$Publishes$Start.Complete) mqtt3RxClient.b().b(this.f38209e.s())).a(MqttQos.AT_LEAST_ONCE)).c()).i0(new Consumer() { // from class: eu.bolt.chat.chatcore.hivemq.e
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    HiveMqttController.E(Function1.this, obj);
                }
            });
            final HiveMqttController$subscribeNewChatEvents$2 hiveMqttController$subscribeNewChatEvents$2 = new HiveMqttController$subscribeNewChatEvents$2(this);
            Flowable<R> j8 = i02.j(new Function() { // from class: eu.bolt.chat.chatcore.hivemq.f
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher F;
                    F = HiveMqttController.F(Function1.this, obj);
                    return F;
                }
            });
            final HiveMqttController$subscribeNewChatEvents$3 hiveMqttController$subscribeNewChatEvents$3 = new HiveMqttController$subscribeNewChatEvents$3(this.f38210f);
            Flowable u7 = j8.u(new Predicate() { // from class: eu.bolt.chat.chatcore.hivemq.g
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean G;
                    G = HiveMqttController.G(Function1.this, obj);
                    return G;
                }
            });
            final HiveMqttController$subscribeNewChatEvents$4 hiveMqttController$subscribeNewChatEvents$4 = new HiveMqttController$subscribeNewChatEvents$4(this.f38210f);
            Flowable<ChatEvent> J = u7.J(new Function() { // from class: eu.bolt.chat.chatcore.hivemq.h
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ChatEvent H;
                    H = HiveMqttController.H(Function1.this, obj);
                    return H;
                }
            });
            Intrinsics.e(J, "override fun subscribeNe…apper::toChatEvent)\n    }");
            return J;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
