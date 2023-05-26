package eu.bolt.chat.network.engine;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.async.JobExtensionsKt;
import eu.bolt.chat.network.data.QoS;
import eu.bolt.chat.network.engine.ConnectionEvent;
import eu.bolt.chat.network.exception.ConnectionAckException;
import eu.bolt.chat.network.exception.DisconnectException;
import eu.bolt.chat.network.exception.MqttException;
import eu.bolt.chat.util.AppStateObserver;
import eu.bolt.chat.util.CoroutineRunner;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: MqttClientImpl.kt */
/* loaded from: classes5.dex */
public final class MqttClientImpl implements MqttClient {

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f39413j = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineRunner f39414a;

    /* renamed from: b  reason: collision with root package name */
    private final PlatformMqttClient f39415b;

    /* renamed from: c  reason: collision with root package name */
    private final InternalPlatformMqttClientDelegate f39416c;

    /* renamed from: d  reason: collision with root package name */
    private final AppStateObserver f39417d;

    /* renamed from: e  reason: collision with root package name */
    private final Logger f39418e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicRef<Job> f39419f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicRef<Job> f39420g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicInt f39421h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableSharedFlow<ConnectionEvent> f39422i;

    /* compiled from: MqttClientImpl.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MqttClientImpl(CoroutineRunner clientRunner, PlatformMqttClient platformClient, InternalPlatformMqttClientDelegate clientDelegate, AppStateObserver stateObserver, Logger logger) {
        Intrinsics.f(clientRunner, "clientRunner");
        Intrinsics.f(platformClient, "platformClient");
        Intrinsics.f(clientDelegate, "clientDelegate");
        Intrinsics.f(stateObserver, "stateObserver");
        Intrinsics.f(logger, "logger");
        this.f39414a = clientRunner;
        this.f39415b = platformClient;
        this.f39416c = clientDelegate;
        this.f39417d = stateObserver;
        this.f39418e = logger;
        this.f39419f = AtomicFU.e(null);
        this.f39420g = AtomicFU.e(null);
        this.f39421h = AtomicFU.c(0);
        this.f39422i = SharedFlowKt.b(0, 0, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(eu.bolt.chat.network.exception.MqttException r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof eu.bolt.chat.network.engine.MqttClientImpl$disconnectIrrecoverably$1
            if (r0 == 0) goto L13
            r0 = r11
            eu.bolt.chat.network.engine.MqttClientImpl$disconnectIrrecoverably$1 r0 = (eu.bolt.chat.network.engine.MqttClientImpl$disconnectIrrecoverably$1) r0
            int r1 = r0.f39449j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39449j = r1
            goto L18
        L13:
            eu.bolt.chat.network.engine.MqttClientImpl$disconnectIrrecoverably$1 r0 = new eu.bolt.chat.network.engine.MqttClientImpl$disconnectIrrecoverably$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.f39447h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39449j
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L48
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r10 = r0.f39445f
            eu.bolt.chat.network.engine.MqttClientImpl r10 = (eu.bolt.chat.network.engine.MqttClientImpl) r10
            kotlin.ResultKt.b(r11)
            goto Lb0
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3a:
            java.lang.Object r10 = r0.f39446g
            eu.bolt.chat.network.exception.MqttException r10 = (eu.bolt.chat.network.exception.MqttException) r10
            java.lang.Object r2 = r0.f39445f
            eu.bolt.chat.network.engine.MqttClientImpl r2 = (eu.bolt.chat.network.engine.MqttClientImpl) r2
            kotlin.ResultKt.b(r11)
            r11 = r10
            r10 = r2
            goto L9c
        L48:
            kotlin.ResultKt.b(r11)
            co.touchlab.kermit.Logger r11 = r9.f39418e
            co.touchlab.kermit.LoggerConfig r2 = r11.c()
            co.touchlab.kermit.Severity r2 = r2.a()
            co.touchlab.kermit.Severity r6 = co.touchlab.kermit.Severity.Warn
            int r2 = r2.compareTo(r6)
            if (r2 > 0) goto L7e
            java.lang.String r2 = r11.d()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Disconnected from a broker. Cause: '"
            r7.append(r8)
            java.lang.String r8 = r10.getMessage()
            r7.append(r8)
            r8 = 39
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r11.f(r6, r2, r5, r7)
        L7e:
            kotlinx.atomicfu.AtomicRef<kotlinx.coroutines.Job> r11 = r9.f39420g
            java.lang.Object r11 = r11.a(r5)
            kotlinx.coroutines.Job r11 = (kotlinx.coroutines.Job) r11
            if (r11 == 0) goto L8b
            kotlinx.coroutines.Job.DefaultImpls.a(r11, r5, r4, r5)
        L8b:
            eu.bolt.chat.network.engine.InternalPlatformMqttClientDelegate r11 = r9.f39416c
            r0.f39445f = r9
            r0.f39446g = r10
            r0.f39449j = r4
            java.lang.Object r11 = r11.g(r0)
            if (r11 != r1) goto L9a
            return r1
        L9a:
            r11 = r10
            r10 = r9
        L9c:
            kotlinx.coroutines.flow.MutableSharedFlow<eu.bolt.chat.network.engine.ConnectionEvent> r2 = r10.f39422i
            eu.bolt.chat.network.engine.ConnectionEvent$Failure r6 = new eu.bolt.chat.network.engine.ConnectionEvent$Failure
            r6.<init>(r11)
            r0.f39445f = r10
            r0.f39446g = r5
            r0.f39449j = r3
            java.lang.Object r11 = r2.b(r6, r0)
            if (r11 != r1) goto Lb0
            return r1
        Lb0:
            kotlinx.atomicfu.AtomicRef<kotlinx.coroutines.Job> r10 = r10.f39419f
            java.lang.Object r10 = r10.a(r5)
            kotlinx.coroutines.Job r10 = (kotlinx.coroutines.Job) r10
            if (r10 == 0) goto Lbd
            kotlinx.coroutines.Job.DefaultImpls.a(r10, r5, r4, r5)
        Lbd:
            kotlin.Unit r10 = kotlin.Unit.f50853a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.engine.MqttClientImpl.k(eu.bolt.chat.network.exception.MqttException, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof eu.bolt.chat.network.engine.MqttClientImpl$disconnectRegularly$1
            if (r0 == 0) goto L13
            r0 = r8
            eu.bolt.chat.network.engine.MqttClientImpl$disconnectRegularly$1 r0 = (eu.bolt.chat.network.engine.MqttClientImpl$disconnectRegularly$1) r0
            int r1 = r0.f39453i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39453i = r1
            goto L18
        L13:
            eu.bolt.chat.network.engine.MqttClientImpl$disconnectRegularly$1 r0 = new eu.bolt.chat.network.engine.MqttClientImpl$disconnectRegularly$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f39451g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39453i
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.f39450f
            eu.bolt.chat.network.engine.MqttClientImpl r0 = (eu.bolt.chat.network.engine.MqttClientImpl) r0
            kotlin.ResultKt.b(r8)
            goto L64
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L36:
            kotlin.ResultKt.b(r8)
            co.touchlab.kermit.Logger r8 = r7.f39418e
            co.touchlab.kermit.LoggerConfig r2 = r8.c()
            co.touchlab.kermit.Severity r2 = r2.a()
            co.touchlab.kermit.Severity r5 = co.touchlab.kermit.Severity.Info
            int r2 = r2.compareTo(r5)
            if (r2 > 0) goto L54
            java.lang.String r2 = r8.d()
            java.lang.String r6 = "Disconnected from a broker normally"
            r8.f(r5, r2, r4, r6)
        L54:
            kotlinx.coroutines.flow.MutableSharedFlow<eu.bolt.chat.network.engine.ConnectionEvent> r8 = r7.f39422i
            eu.bolt.chat.network.engine.ConnectionEvent$Disconnected r2 = eu.bolt.chat.network.engine.ConnectionEvent.Disconnected.f39408a
            r0.f39450f = r7
            r0.f39453i = r3
            java.lang.Object r8 = r8.b(r2, r0)
            if (r8 != r1) goto L63
            return r1
        L63:
            r0 = r7
        L64:
            kotlinx.atomicfu.AtomicRef<kotlinx.coroutines.Job> r8 = r0.f39419f
            java.lang.Object r8 = r8.a(r4)
            kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
            if (r8 == 0) goto L71
            kotlinx.coroutines.Job.DefaultImpls.a(r8, r4, r3, r4)
        L71:
            kotlin.Unit r8 = kotlin.Unit.f50853a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.engine.MqttClientImpl.l(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(Continuation<? super Unit> continuation) {
        Object d8;
        r();
        Object b8 = this.f39422i.b(ConnectionEvent.Connected.f39407a, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (b8 == d8) {
            return b8;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(MqttException mqttException, Continuation<? super Unit> continuation) {
        Object d8;
        Object d9;
        Object d10;
        if (mqttException instanceof DisconnectException) {
            Object l8 = l(continuation);
            d10 = IntrinsicsKt__IntrinsicsKt.d();
            if (l8 == d10) {
                return l8;
            }
            return Unit.f50853a;
        } else if (o(mqttException)) {
            Object k8 = k(mqttException, continuation);
            d9 = IntrinsicsKt__IntrinsicsKt.d();
            if (k8 == d9) {
                return k8;
            }
            return Unit.f50853a;
        } else {
            Object q8 = q(mqttException, continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (q8 == d8) {
                return q8;
            }
            return Unit.f50853a;
        }
    }

    private final boolean o(MqttException mqttException) {
        if ((mqttException instanceof ConnectionAckException) && ((ConnectionAckException) mqttException).a().c()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(int r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof eu.bolt.chat.network.engine.MqttClientImpl$reconnect$1
            if (r0 == 0) goto L13
            r0 = r14
            eu.bolt.chat.network.engine.MqttClientImpl$reconnect$1 r0 = (eu.bolt.chat.network.engine.MqttClientImpl$reconnect$1) r0
            int r1 = r0.f39467i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39467i = r1
            goto L18
        L13:
            eu.bolt.chat.network.engine.MqttClientImpl$reconnect$1 r0 = new eu.bolt.chat.network.engine.MqttClientImpl$reconnect$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.f39465g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39467i
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r13 = r0.f39464f
            eu.bolt.chat.network.engine.MqttClientImpl r13 = (eu.bolt.chat.network.engine.MqttClientImpl) r13
            kotlin.ResultKt.b(r14)
            goto La2
        L31:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L39:
            java.lang.Object r13 = r0.f39464f
            eu.bolt.chat.network.engine.MqttClientImpl r13 = (eu.bolt.chat.network.engine.MqttClientImpl) r13
            kotlin.ResultKt.b(r14)
            goto L95
        L41:
            kotlin.ResultKt.b(r14)
            r6 = 1000(0x3e8, double:4.94E-321)
            r14 = 1073741824(0x40000000, float:2.0)
            double r8 = (double) r14
            double r10 = (double) r13
            double r8 = java.lang.Math.pow(r8, r10)
            float r14 = (float) r8
            long r8 = (long) r14
            long r8 = r8 * r6
            co.touchlab.kermit.Logger r14 = r12.f39418e
            co.touchlab.kermit.LoggerConfig r2 = r14.c()
            co.touchlab.kermit.Severity r2 = r2.a()
            co.touchlab.kermit.Severity r6 = co.touchlab.kermit.Severity.Info
            int r2 = r2.compareTo(r6)
            if (r2 > 0) goto L89
            java.lang.String r2 = r14.d()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "Reconnecting to a broker. Attempt #"
            r7.append(r10)
            r7.append(r13)
            java.lang.String r13 = ", delay = "
            r7.append(r13)
            r7.append(r8)
            java.lang.String r13 = "ms"
            r7.append(r13)
            java.lang.String r13 = r7.toString()
            r14.f(r6, r2, r3, r13)
        L89:
            r0.f39464f = r12
            r0.f39467i = r5
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.a(r8, r0)
            if (r13 != r1) goto L94
            return r1
        L94:
            r13 = r12
        L95:
            eu.bolt.chat.util.AppStateObserver r14 = r13.f39417d
            r0.f39464f = r13
            r0.f39467i = r4
            java.lang.Object r14 = r14.c(r0)
            if (r14 != r1) goto La2
            return r1
        La2:
            co.touchlab.kermit.Logger r14 = r13.f39418e
            co.touchlab.kermit.LoggerConfig r0 = r14.c()
            co.touchlab.kermit.Severity r0 = r0.a()
            co.touchlab.kermit.Severity r1 = co.touchlab.kermit.Severity.Info
            int r0 = r0.compareTo(r1)
            if (r0 > 0) goto Lbd
            java.lang.String r0 = r14.d()
            java.lang.String r2 = "Restoring the connection to a broker"
            r14.f(r1, r0, r3, r2)
        Lbd:
            eu.bolt.chat.network.engine.PlatformMqttClient r13 = r13.f39415b
            r13.a()
            kotlin.Unit r13 = kotlin.Unit.f50853a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.engine.MqttClientImpl.p(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q(eu.bolt.chat.network.exception.MqttException r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof eu.bolt.chat.network.engine.MqttClientImpl$reconnectOrDisconnectIrrecoverably$1
            if (r0 == 0) goto L13
            r0 = r11
            eu.bolt.chat.network.engine.MqttClientImpl$reconnectOrDisconnectIrrecoverably$1 r0 = (eu.bolt.chat.network.engine.MqttClientImpl$reconnectOrDisconnectIrrecoverably$1) r0
            int r1 = r0.f39472j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39472j = r1
            goto L18
        L13:
            eu.bolt.chat.network.engine.MqttClientImpl$reconnectOrDisconnectIrrecoverably$1 r0 = new eu.bolt.chat.network.engine.MqttClientImpl$reconnectOrDisconnectIrrecoverably$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.f39470h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39472j
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L40
            if (r2 == r5) goto L36
            if (r2 != r4) goto L2e
            kotlin.ResultKt.b(r11)
            goto Lae
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            int r10 = r0.f39469g
            java.lang.Object r0 = r0.f39468f
            eu.bolt.chat.network.engine.MqttClientImpl r0 = (eu.bolt.chat.network.engine.MqttClientImpl) r0
            kotlin.ResultKt.b(r11)
            goto L92
        L40:
            kotlin.ResultKt.b(r11)
            kotlinx.atomicfu.AtomicInt r11 = r9.f39421h
            int r11 = r11.b()
            r2 = 3
            if (r11 > r2) goto La5
            co.touchlab.kermit.Logger r2 = r9.f39418e
            co.touchlab.kermit.LoggerConfig r4 = r2.c()
            co.touchlab.kermit.Severity r4 = r4.a()
            co.touchlab.kermit.Severity r6 = co.touchlab.kermit.Severity.Info
            int r4 = r4.compareTo(r6)
            if (r4 > 0) goto L7f
            java.lang.String r4 = r2.d()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Disconnected from a broker. Cause: '"
            r7.append(r8)
            java.lang.String r10 = r10.getMessage()
            r7.append(r10)
            java.lang.String r10 = "'. Reconnecting…"
            r7.append(r10)
            java.lang.String r10 = r7.toString()
            r2.f(r6, r4, r3, r10)
        L7f:
            kotlinx.coroutines.flow.MutableSharedFlow<eu.bolt.chat.network.engine.ConnectionEvent> r10 = r9.f39422i
            eu.bolt.chat.network.engine.ConnectionEvent$Reconnecting r2 = eu.bolt.chat.network.engine.ConnectionEvent.Reconnecting.f39410a
            r0.f39468f = r9
            r0.f39469g = r11
            r0.f39472j = r5
            java.lang.Object r10 = r10.b(r2, r0)
            if (r10 != r1) goto L90
            return r1
        L90:
            r0 = r9
            r10 = r11
        L92:
            eu.bolt.chat.util.CoroutineRunner r11 = r0.f39414a
            eu.bolt.chat.network.engine.MqttClientImpl$reconnectOrDisconnectIrrecoverably$3 r1 = new eu.bolt.chat.network.engine.MqttClientImpl$reconnectOrDisconnectIrrecoverably$3
            r1.<init>(r0, r10, r3)
            kotlinx.coroutines.Job r10 = r11.a(r1)
            kotlinx.atomicfu.AtomicRef<kotlinx.coroutines.Job> r11 = r0.f39420g
            eu.bolt.chat.async.JobExtensionsKt.a(r10, r11)
            kotlin.Unit r10 = kotlin.Unit.f50853a
            return r10
        La5:
            r0.f39472j = r4
            java.lang.Object r10 = r9.k(r10, r0)
            if (r10 != r1) goto Lae
            return r1
        Lae:
            kotlin.Unit r10 = kotlin.Unit.f50853a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.engine.MqttClientImpl.q(eu.bolt.chat.network.exception.MqttException, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void r() {
        this.f39421h.c(0);
    }

    @Override // eu.bolt.chat.network.engine.MqttClient
    public Flow<ConnectionEvent> a() {
        Logger logger = this.f39418e;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Info;
        if (a8.compareTo(severity) <= 0) {
            logger.f(severity, logger.d(), null, "Initial attempt to connect to a broker");
        }
        r();
        JobExtensionsKt.a(this.f39414a.a(new MqttClientImpl$connect$2(this, null)), this.f39419f);
        this.f39415b.a();
        return FlowKt.b(this.f39422i);
    }

    @Override // eu.bolt.chat.network.engine.MqttClient
    public Flow<SubscriptionEvent> c(final String topic, QoS qos) {
        Intrinsics.f(topic, "topic");
        Intrinsics.f(qos, "qos");
        Logger logger = this.f39418e;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Info;
        if (a8.compareTo(severity) <= 0) {
            String d8 = logger.d();
            logger.f(severity, d8, null, "Subscribe to '" + topic + '\'');
        }
        this.f39415b.c(topic, qos);
        final SharedFlow<SubscriptionEvent> b8 = this.f39416c.b();
        return new Flow<SubscriptionEvent>() { // from class: eu.bolt.chat.network.engine.MqttClientImpl$subscribe$$inlined$filter$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.network.engine.MqttClientImpl$subscribe$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f39437f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ String f39438g;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.network.engine.MqttClientImpl$subscribe$$inlined$filter$1$2", f = "MqttClientImpl.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.chat.network.engine.MqttClientImpl$subscribe$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f39439f;

                    /* renamed from: g  reason: collision with root package name */
                    int f39440g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f39439f = obj;
                        this.f39440g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, String str) {
                    this.f39437f = flowCollector;
                    this.f39438g = str;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof eu.bolt.chat.network.engine.MqttClientImpl$subscribe$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        eu.bolt.chat.network.engine.MqttClientImpl$subscribe$$inlined$filter$1$2$1 r0 = (eu.bolt.chat.network.engine.MqttClientImpl$subscribe$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f39440g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f39440g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.network.engine.MqttClientImpl$subscribe$$inlined$filter$1$2$1 r0 = new eu.bolt.chat.network.engine.MqttClientImpl$subscribe$$inlined$filter$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f39439f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f39440g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r7)
                        goto L4e
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.f39437f
                        r2 = r6
                        eu.bolt.chat.network.engine.SubscriptionEvent r2 = (eu.bolt.chat.network.engine.SubscriptionEvent) r2
                        java.lang.String r2 = r2.a()
                        java.lang.String r4 = r5.f39438g
                        boolean r2 = kotlin.jvm.internal.Intrinsics.a(r2, r4)
                        if (r2 == 0) goto L4e
                        r0.f39440g = r3
                        java.lang.Object r6 = r7.b(r6, r0)
                        if (r6 != r1) goto L4e
                        return r1
                    L4e:
                        kotlin.Unit r6 = kotlin.Unit.f50853a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.engine.MqttClientImpl$subscribe$$inlined$filter$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super SubscriptionEvent> flowCollector, Continuation continuation) {
                Object d9;
                Object a9 = Flow.this.a(new AnonymousClass2(flowCollector, topic), continuation);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (a9 == d9) {
                    return a9;
                }
                return Unit.f50853a;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // eu.bolt.chat.network.engine.MqttClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(eu.bolt.chat.network.data.MqttMessage r11, eu.bolt.chat.network.data.QoS r12, kotlin.coroutines.Continuation<? super eu.bolt.chat.network.engine.PublishingEvent> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof eu.bolt.chat.network.engine.MqttClientImpl$publish$1
            if (r0 == 0) goto L13
            r0 = r13
            eu.bolt.chat.network.engine.MqttClientImpl$publish$1 r0 = (eu.bolt.chat.network.engine.MqttClientImpl$publish$1) r0
            int r1 = r0.f39460l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39460l = r1
            goto L18
        L13:
            eu.bolt.chat.network.engine.MqttClientImpl$publish$1 r0 = new eu.bolt.chat.network.engine.MqttClientImpl$publish$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f39458j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39460l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r11 = r0.f39454f
            eu.bolt.chat.network.data.MqttMessage r11 = (eu.bolt.chat.network.data.MqttMessage) r11
            kotlin.ResultKt.b(r13)
            goto Lbb
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            int r11 = r0.f39457i
            java.lang.Object r12 = r0.f39456h
            eu.bolt.chat.network.data.QoS r12 = (eu.bolt.chat.network.data.QoS) r12
            java.lang.Object r2 = r0.f39455g
            eu.bolt.chat.network.data.MqttMessage r2 = (eu.bolt.chat.network.data.MqttMessage) r2
            java.lang.Object r4 = r0.f39454f
            eu.bolt.chat.network.engine.MqttClientImpl r4 = (eu.bolt.chat.network.engine.MqttClientImpl) r4
            kotlin.ResultKt.b(r13)
            r13 = r11
            r11 = r2
            goto L6a
        L4d:
            kotlin.ResultKt.b(r13)
            eu.bolt.chat.network.engine.PlatformMqttClient r13 = r10.f39415b
            int r13 = r13.d(r11, r12)
            eu.bolt.chat.network.engine.InternalPlatformMqttClientDelegate r2 = r10.f39416c
            r0.f39454f = r10
            r0.f39455g = r11
            r0.f39456h = r12
            r0.f39457i = r13
            r0.f39460l = r4
            java.lang.Object r2 = r2.d(r13, r11, r0)
            if (r2 != r1) goto L69
            return r1
        L69:
            r4 = r10
        L6a:
            co.touchlab.kermit.Logger r2 = r4.f39418e
            co.touchlab.kermit.LoggerConfig r5 = r2.c()
            co.touchlab.kermit.Severity r5 = r5.a()
            co.touchlab.kermit.Severity r6 = co.touchlab.kermit.Severity.Info
            int r5 = r5.compareTo(r6)
            r7 = 0
            if (r5 > 0) goto La5
            java.lang.String r5 = r2.d()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Publish a message "
            r8.append(r9)
            r8.append(r11)
            java.lang.String r9 = ", id = "
            r8.append(r9)
            r8.append(r13)
            java.lang.String r9 = ", qos = "
            r8.append(r9)
            r8.append(r12)
            java.lang.String r12 = r8.toString()
            r2.f(r6, r5, r7, r12)
        La5:
            r5 = 3000(0xbb8, double:1.482E-320)
            eu.bolt.chat.network.engine.MqttClientImpl$publish$3 r12 = new eu.bolt.chat.network.engine.MqttClientImpl$publish$3
            r12.<init>(r4, r13, r7)
            r0.f39454f = r11
            r0.f39455g = r7
            r0.f39456h = r7
            r0.f39460l = r3
            java.lang.Object r13 = kotlinx.coroutines.TimeoutKt.c(r5, r12, r0)
            if (r13 != r1) goto Lbb
            return r1
        Lbb:
            eu.bolt.chat.network.engine.PublishingEvent r13 = (eu.bolt.chat.network.engine.PublishingEvent) r13
            if (r13 != 0) goto Lcb
            eu.bolt.chat.network.engine.PublishingEvent$Failure r13 = new eu.bolt.chat.network.engine.PublishingEvent$Failure
            eu.bolt.chat.network.exception.PublishingException r12 = new eu.bolt.chat.network.exception.PublishingException
            java.lang.String r0 = "Publishing timeout"
            r12.<init>(r0)
            r13.<init>(r11, r12)
        Lcb:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.engine.MqttClientImpl.d(eu.bolt.chat.network.data.MqttMessage, eu.bolt.chat.network.data.QoS, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // eu.bolt.chat.network.engine.MqttClient
    public void disconnect() {
        Logger logger = this.f39418e;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Info;
        if (a8.compareTo(severity) <= 0) {
            logger.f(severity, logger.d(), null, "Disconnect from an active broker.");
        }
        Job a9 = this.f39420g.a(null);
        if (a9 != null) {
            Job.DefaultImpls.a(a9, null, 1, null);
        }
        this.f39415b.disconnect();
        this.f39415b.b();
    }
}
