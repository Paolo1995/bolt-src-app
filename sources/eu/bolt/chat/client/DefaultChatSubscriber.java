package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import eu.bolt.chat.async.JobExtensionsKt;
import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.data.QoS;
import eu.bolt.chat.network.engine.MqttClient;
import eu.bolt.chat.network.engine.SubscriptionEvent;
import eu.bolt.chat.util.CoroutineRunner;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: DefaultChatSubscriber.kt */
/* loaded from: classes5.dex */
public final class DefaultChatSubscriber implements ChatSubscriber {

    /* renamed from: k  reason: collision with root package name */
    private static final Companion f38857k = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineRunner f38858a;

    /* renamed from: b  reason: collision with root package name */
    private final MqttClient f38859b;

    /* renamed from: c  reason: collision with root package name */
    private final Logger f38860c;

    /* renamed from: d  reason: collision with root package name */
    private AtomicRef<Job> f38861d;

    /* renamed from: e  reason: collision with root package name */
    private AtomicRef<Job> f38862e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicRef<String> f38863f;

    /* renamed from: g  reason: collision with root package name */
    private AtomicRef<QoS> f38864g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableStateFlow<SubscriptionStatus> f38865h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableSharedFlow<MqttMessage> f38866i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicInt f38867j;

    /* compiled from: DefaultChatSubscriber.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DefaultChatSubscriber.kt */
    /* loaded from: classes5.dex */
    public enum SubscriptionStatus {
        SUBSCRIBING,
        SUBSCRIBED,
        FAILED
    }

    public DefaultChatSubscriber(CoroutineRunner clientRunner, MqttClient mqttClient, Logger logger) {
        Intrinsics.f(clientRunner, "clientRunner");
        Intrinsics.f(mqttClient, "mqttClient");
        Intrinsics.f(logger, "logger");
        this.f38858a = clientRunner;
        this.f38859b = mqttClient;
        this.f38860c = logger;
        this.f38861d = AtomicFU.e(null);
        this.f38862e = AtomicFU.e(null);
        this.f38863f = AtomicFU.e(null);
        this.f38864g = AtomicFU.e(null);
        this.f38865h = StateFlowKt.a(SubscriptionStatus.SUBSCRIBING);
        this.f38866i = SharedFlowKt.b(0, 0, null, 7, null);
        this.f38867j = AtomicFU.c(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(SubscriptionEvent subscriptionEvent, Continuation<? super Unit> continuation) {
        Object d8;
        Object d9;
        Object d10;
        if (subscriptionEvent instanceof SubscriptionEvent.Success) {
            g();
            Object b8 = this.f38865h.b(SubscriptionStatus.SUBSCRIBED, continuation);
            d10 = IntrinsicsKt__IntrinsicsKt.d();
            if (b8 == d10) {
                return b8;
            }
            return Unit.f50853a;
        } else if (subscriptionEvent instanceof SubscriptionEvent.Failure) {
            Object h8 = h(continuation);
            d9 = IntrinsicsKt__IntrinsicsKt.d();
            if (h8 == d9) {
                return h8;
            }
            return Unit.f50853a;
        } else if (subscriptionEvent instanceof SubscriptionEvent.NewMessage) {
            Object b9 = this.f38866i.b(((SubscriptionEvent.NewMessage) subscriptionEvent).b(), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (b9 == d8) {
                return b9;
            }
            return Unit.f50853a;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void g() {
        this.f38867j.c(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatSubscriber.h(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object i(String str, QoS qoS, Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = this.f38859b.c(str, qoS).a(new FlowCollector() { // from class: eu.bolt.chat.client.DefaultChatSubscriber$subscribeInternalFor$2
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: a */
            public final Object b(SubscriptionEvent subscriptionEvent, Continuation<? super Unit> continuation2) {
                Object f8;
                Object d9;
                f8 = DefaultChatSubscriber.this.f(subscriptionEvent, continuation2);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (f8 == d9) {
                    return f8;
                }
                return Unit.f50853a;
            }
        }, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatSubscriber
    public Object a(String str, QoS qoS, FlowCollector<? super SubscriptionStatus> flowCollector, FlowCollector<? super MqttMessage> flowCollector2, Continuation<? super Unit> continuation) {
        Object d8;
        g();
        JobExtensionsKt.a(this.f38858a.a(new DefaultChatSubscriber$subscribeFor$2(this, flowCollector, null)), this.f38861d);
        JobExtensionsKt.a(this.f38858a.a(new DefaultChatSubscriber$subscribeFor$3(this, flowCollector2, null)), this.f38862e);
        this.f38863f.c(str);
        this.f38864g.c(qoS);
        Object i8 = i(str, qoS, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (i8 == d8) {
            return i8;
        }
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatSubscriber
    public void clear() {
        this.f38863f.c(null);
        Job a8 = this.f38861d.a(null);
        if (a8 != null) {
            Job.DefaultImpls.a(a8, null, 1, null);
        }
        Job a9 = this.f38862e.a(null);
        if (a9 != null) {
            Job.DefaultImpls.a(a9, null, 1, null);
        }
    }
}
