package eu.bolt.chat.network.engine;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MqttClientImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.MqttClientImpl$publish$3", f = "MqttClientImpl.kt", l = {88}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class MqttClientImpl$publish$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PublishingEvent>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f39461g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ MqttClientImpl f39462h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ int f39463i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MqttClientImpl$publish$3(MqttClientImpl mqttClientImpl, int i8, Continuation<? super MqttClientImpl$publish$3> continuation) {
        super(2, continuation);
        this.f39462h = mqttClientImpl;
        this.f39463i = i8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MqttClientImpl$publish$3(this.f39462h, this.f39463i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super PublishingEvent> continuation) {
        return ((MqttClientImpl$publish$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        InternalPlatformMqttClientDelegate internalPlatformMqttClientDelegate;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f39461g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            internalPlatformMqttClientDelegate = this.f39462h.f39416c;
            final SharedFlow<IdentifiablePublishingEvent> k8 = internalPlatformMqttClientDelegate.k();
            final int i9 = this.f39463i;
            final Flow<IdentifiablePublishingEvent> flow = new Flow<IdentifiablePublishingEvent>() { // from class: eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$filter$1

                /* compiled from: Emitters.kt */
                /* renamed from: eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {

                    /* renamed from: f  reason: collision with root package name */
                    final /* synthetic */ FlowCollector f39425f;

                    /* renamed from: g  reason: collision with root package name */
                    final /* synthetic */ int f39426g;

                    /* compiled from: Emitters.kt */
                    @DebugMetadata(c = "eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$filter$1$2", f = "MqttClientImpl.kt", l = {223}, m = "emit")
                    /* renamed from: eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
                    /* loaded from: classes5.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: f  reason: collision with root package name */
                        /* synthetic */ Object f39427f;

                        /* renamed from: g  reason: collision with root package name */
                        int f39428g;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f39427f = obj;
                            this.f39428g |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.b(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, int i8) {
                        this.f39425f = flowCollector;
                        this.f39426g = i8;
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
                            boolean r0 = r7 instanceof eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r7
                            eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$filter$1$2$1 r0 = (eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f39428g
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f39428g = r1
                            goto L18
                        L13:
                            eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$filter$1$2$1 r0 = new eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$filter$1$2$1
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.f39427f
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                            int r2 = r0.f39428g
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.b(r7)
                            goto L4f
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            kotlin.ResultKt.b(r7)
                            kotlinx.coroutines.flow.FlowCollector r7 = r5.f39425f
                            r2 = r6
                            eu.bolt.chat.network.engine.IdentifiablePublishingEvent r2 = (eu.bolt.chat.network.engine.IdentifiablePublishingEvent) r2
                            int r2 = r2.b()
                            int r4 = r5.f39426g
                            if (r2 != r4) goto L43
                            r2 = 1
                            goto L44
                        L43:
                            r2 = 0
                        L44:
                            if (r2 == 0) goto L4f
                            r0.f39428g = r3
                            java.lang.Object r6 = r7.b(r6, r0)
                            if (r6 != r1) goto L4f
                            return r1
                        L4f:
                            kotlin.Unit r6 = kotlin.Unit.f50853a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$filter$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object a(FlowCollector<? super IdentifiablePublishingEvent> flowCollector, Continuation continuation) {
                    Object d9;
                    Object a8 = Flow.this.a(new AnonymousClass2(flowCollector, i9), continuation);
                    d9 = IntrinsicsKt__IntrinsicsKt.d();
                    if (a8 == d9) {
                        return a8;
                    }
                    return Unit.f50853a;
                }
            };
            Flow<PublishingEvent> flow2 = new Flow<PublishingEvent>() { // from class: eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$map$1

                /* compiled from: Emitters.kt */
                /* renamed from: eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {

                    /* renamed from: f  reason: collision with root package name */
                    final /* synthetic */ FlowCollector f39431f;

                    /* compiled from: Emitters.kt */
                    @DebugMetadata(c = "eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$map$1$2", f = "MqttClientImpl.kt", l = {223}, m = "emit")
                    /* renamed from: eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$map$1$2$1  reason: invalid class name */
                    /* loaded from: classes5.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: f  reason: collision with root package name */
                        /* synthetic */ Object f39432f;

                        /* renamed from: g  reason: collision with root package name */
                        int f39433g;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f39432f = obj;
                            this.f39433g |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.b(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.f39431f = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$map$1$2$1 r0 = (eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f39433g
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f39433g = r1
                            goto L18
                        L13:
                            eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$map$1$2$1 r0 = new eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.f39432f
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                            int r2 = r0.f39433g
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.b(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.b(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.f39431f
                            eu.bolt.chat.network.engine.IdentifiablePublishingEvent r5 = (eu.bolt.chat.network.engine.IdentifiablePublishingEvent) r5
                            eu.bolt.chat.network.engine.PublishingEvent r5 = r5.a()
                            r0.f39433g = r3
                            java.lang.Object r5 = r6.b(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            kotlin.Unit r5 = kotlin.Unit.f50853a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.engine.MqttClientImpl$publish$3$invokeSuspend$$inlined$map$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object a(FlowCollector<? super PublishingEvent> flowCollector, Continuation continuation) {
                    Object d9;
                    Object a8 = Flow.this.a(new AnonymousClass2(flowCollector), continuation);
                    d9 = IntrinsicsKt__IntrinsicsKt.d();
                    if (a8 == d9) {
                        return a8;
                    }
                    return Unit.f50853a;
                }
            };
            this.f39461g = 1;
            obj = FlowKt.p(flow2, this);
            if (obj == d8) {
                return d8;
            }
        }
        return obj;
    }
}
