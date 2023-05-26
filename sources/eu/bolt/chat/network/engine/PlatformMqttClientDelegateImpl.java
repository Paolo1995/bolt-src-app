package eu.bolt.chat.network.engine;

import co.touchlab.kermit.Logger;
import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.exception.MqttException;
import eu.bolt.chat.network.exception.PublishingException;
import eu.bolt.chat.network.exception.SubscriptionException;
import eu.bolt.chat.util.CoroutineRunner;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: PlatformMqttClientDelegateImpl.kt */
/* loaded from: classes5.dex */
public final class PlatformMqttClientDelegateImpl implements InternalPlatformMqttClientDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineRunner f39476a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f39477b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<Integer, MqttMessage> f39478c;

    /* renamed from: d  reason: collision with root package name */
    private final Mutex f39479d;

    /* renamed from: e  reason: collision with root package name */
    private final MutableSharedFlow<ConnectionEvent> f39480e;

    /* renamed from: f  reason: collision with root package name */
    private final MutableSharedFlow<SubscriptionEvent> f39481f;

    /* renamed from: g  reason: collision with root package name */
    private final MutableSharedFlow<IdentifiablePublishingEvent> f39482g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedFlow<ConnectionEvent> f39483h;

    /* renamed from: i  reason: collision with root package name */
    private final SharedFlow<SubscriptionEvent> f39484i;

    /* renamed from: j  reason: collision with root package name */
    private final SharedFlow<IdentifiablePublishingEvent> f39485j;

    public PlatformMqttClientDelegateImpl(CoroutineRunner clientRunner, Logger logger) {
        Intrinsics.f(clientRunner, "clientRunner");
        Intrinsics.f(logger, "logger");
        this.f39476a = clientRunner;
        this.f39477b = logger;
        this.f39478c = new HashMap<>();
        this.f39479d = MutexKt.b(false, 1, null);
        MutableSharedFlow<ConnectionEvent> b8 = SharedFlowKt.b(0, 0, null, 7, null);
        this.f39480e = b8;
        MutableSharedFlow<SubscriptionEvent> b9 = SharedFlowKt.b(0, 0, null, 7, null);
        this.f39481f = b9;
        MutableSharedFlow<IdentifiablePublishingEvent> b10 = SharedFlowKt.b(0, 0, null, 7, null);
        this.f39482g = b10;
        this.f39483h = FlowKt.b(b8);
        this.f39484i = FlowKt.b(b9);
        this.f39485j = FlowKt.b(b10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(int r6, kotlin.coroutines.Continuation<? super eu.bolt.chat.network.data.MqttMessage> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$removePublishingMessage$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$removePublishingMessage$1 r0 = (eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$removePublishingMessage$1) r0
            int r1 = r0.f39525k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39525k = r1
            goto L18
        L13:
            eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$removePublishingMessage$1 r0 = new eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$removePublishingMessage$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f39523i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39525k
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            int r6 = r0.f39522h
            java.lang.Object r1 = r0.f39521g
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.f39520f
            eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl r0 = (eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl) r0
            kotlin.ResultKt.b(r7)
            goto L52
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.f39479d
            r0.f39520f = r5
            r0.f39521g = r7
            r0.f39522h = r6
            r0.f39525k = r4
            java.lang.Object r0 = r7.a(r3, r0)
            if (r0 != r1) goto L50
            return r1
        L50:
            r0 = r5
            r1 = r7
        L52:
            java.util.HashMap<java.lang.Integer, eu.bolt.chat.network.data.MqttMessage> r7 = r0.f39478c     // Catch: java.lang.Throwable -> L62
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.b(r6)     // Catch: java.lang.Throwable -> L62
            java.lang.Object r6 = r7.remove(r6)     // Catch: java.lang.Throwable -> L62
            eu.bolt.chat.network.data.MqttMessage r6 = (eu.bolt.chat.network.data.MqttMessage) r6     // Catch: java.lang.Throwable -> L62
            r1.b(r3)
            return r6
        L62:
            r6 = move-exception
            r1.b(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl.r(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClientDelegate
    public void a(int i8, PublishingException error) {
        Intrinsics.f(error, "error");
        this.f39476a.a(new PlatformMqttClientDelegateImpl$onPublishError$1(this, error, i8, null));
    }

    @Override // eu.bolt.chat.network.engine.InternalPlatformMqttClientDelegate
    public SharedFlow<SubscriptionEvent> b() {
        return this.f39484i;
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClientDelegate
    public void c(MqttException error) {
        Intrinsics.f(error, "error");
        this.f39476a.a(new PlatformMqttClientDelegateImpl$onDisconnected$1(this, error, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    @Override // eu.bolt.chat.network.engine.InternalPlatformMqttClientDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(int r6, eu.bolt.chat.network.data.MqttMessage r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$addPublishingMessage$1
            if (r0 == 0) goto L13
            r0 = r8
            eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$addPublishingMessage$1 r0 = (eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$addPublishingMessage$1) r0
            int r1 = r0.f39492l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39492l = r1
            goto L18
        L13:
            eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$addPublishingMessage$1 r0 = new eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$addPublishingMessage$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f39490j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39492l
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 != r4) goto L3a
            int r6 = r0.f39489i
            java.lang.Object r7 = r0.f39488h
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r1 = r0.f39487g
            eu.bolt.chat.network.data.MqttMessage r1 = (eu.bolt.chat.network.data.MqttMessage) r1
            java.lang.Object r0 = r0.f39486f
            eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl r0 = (eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl) r0
            kotlin.ResultKt.b(r8)
            r8 = r7
            r7 = r1
            goto L59
        L3a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L42:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.sync.Mutex r8 = r5.f39479d
            r0.f39486f = r5
            r0.f39487g = r7
            r0.f39488h = r8
            r0.f39489i = r6
            r0.f39492l = r4
            java.lang.Object r0 = r8.a(r3, r0)
            if (r0 != r1) goto L58
            return r1
        L58:
            r0 = r5
        L59:
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.b(r6)     // Catch: java.lang.Throwable -> L6a
            java.util.HashMap<java.lang.Integer, eu.bolt.chat.network.data.MqttMessage> r0 = r0.f39478c     // Catch: java.lang.Throwable -> L6a
            r0.put(r6, r7)     // Catch: java.lang.Throwable -> L6a
            kotlin.Unit r6 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L6a
            r8.b(r3)
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L6a:
            r6 = move-exception
            r8.b(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl.d(int, eu.bolt.chat.network.data.MqttMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClientDelegate
    public void e(String topic) {
        Intrinsics.f(topic, "topic");
        this.f39476a.a(new PlatformMqttClientDelegateImpl$onTopicSubscribed$1(this, topic, null));
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClientDelegate
    public void f() {
        this.f39476a.a(new PlatformMqttClientDelegateImpl$onConnected$1(this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @Override // eu.bolt.chat.network.engine.InternalPlatformMqttClientDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object g(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$cleanPublishingMessages$1
            if (r0 == 0) goto L13
            r0 = r6
            eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$cleanPublishingMessages$1 r0 = (eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$cleanPublishingMessages$1) r0
            int r1 = r0.f39497j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39497j = r1
            goto L18
        L13:
            eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$cleanPublishingMessages$1 r0 = new eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$cleanPublishingMessages$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f39495h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39497j
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r1 = r0.f39494g
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.f39493f
            eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl r0 = (eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl) r0
            kotlin.ResultKt.b(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.sync.Mutex r6 = r5.f39479d
            r0.f39493f = r5
            r0.f39494g = r6
            r0.f39497j = r4
            java.lang.Object r0 = r6.a(r3, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
            r1 = r6
        L4e:
            java.util.HashMap<java.lang.Integer, eu.bolt.chat.network.data.MqttMessage> r6 = r0.f39478c     // Catch: java.lang.Throwable -> L5b
            r6.clear()     // Catch: java.lang.Throwable -> L5b
            kotlin.Unit r6 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L5b
            r1.b(r3)
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L5b:
            r6 = move-exception
            r1.b(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClientDelegate
    public void h(int i8) {
        this.f39476a.a(new PlatformMqttClientDelegateImpl$onMessagePublished$1(this, i8, null));
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClientDelegate
    public void i(MqttMessage message) {
        Intrinsics.f(message, "message");
        this.f39476a.a(new PlatformMqttClientDelegateImpl$onNewMessage$1(this, message, null));
    }

    @Override // eu.bolt.chat.network.engine.InternalPlatformMqttClientDelegate
    public SharedFlow<ConnectionEvent> j() {
        return this.f39483h;
    }

    @Override // eu.bolt.chat.network.engine.InternalPlatformMqttClientDelegate
    public SharedFlow<IdentifiablePublishingEvent> k() {
        return this.f39485j;
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClientDelegate
    public void l(String topic, SubscriptionException error) {
        Intrinsics.f(topic, "topic");
        Intrinsics.f(error, "error");
        this.f39476a.a(new PlatformMqttClientDelegateImpl$onSubscribeError$1(this, error, topic, null));
    }
}
