package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
/* compiled from: Merge.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {27}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f51697g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f51698h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChannelFlowTransformLatest<T, R> f51699i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ FlowCollector<R> f51700j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Merge.kt */
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Ref$ObjectRef<Job> f51701f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ CoroutineScope f51702g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ChannelFlowTransformLatest<T, R> f51703h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ FlowCollector<R> f51704i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Merge.kt */
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", l = {34}, m = "invokeSuspend")
        /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2  reason: invalid class name */
        /* loaded from: classes5.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: g  reason: collision with root package name */
            int f51705g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ ChannelFlowTransformLatest<T, R> f51706h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ FlowCollector<R> f51707i;

            /* renamed from: j  reason: collision with root package name */
            final /* synthetic */ T f51708j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, T t7, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.f51706h = channelFlowTransformLatest;
                this.f51707i = flowCollector;
                this.f51708j = t7;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.f51706h, this.f51707i, this.f51708j, continuation);
            }

            public final Object h(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object d8;
                Function3 function3;
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                int i8 = this.f51705g;
                if (i8 != 0) {
                    if (i8 == 1) {
                        ResultKt.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.b(obj);
                    function3 = ((ChannelFlowTransformLatest) this.f51706h).f51696j;
                    Object obj2 = this.f51707i;
                    T t7 = this.f51708j;
                    this.f51705g = 1;
                    if (function3.l(obj2, t7, this) == d8) {
                        return d8;
                    }
                }
                return Unit.f50853a;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return h(coroutineScope, continuation);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref$ObjectRef<Job> ref$ObjectRef, CoroutineScope coroutineScope, ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector) {
            this.f51701f = ref$ObjectRef;
            this.f51702g = coroutineScope;
            this.f51703h = channelFlowTransformLatest;
            this.f51704i = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object b(T r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                if (r0 == 0) goto L13
                r0 = r9
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r0
                int r1 = r0.f51714k
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f51714k = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.f51712i
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                int r2 = r0.f51714k
                r3 = 1
                if (r2 == 0) goto L3b
                if (r2 != r3) goto L33
                java.lang.Object r8 = r0.f51711h
                kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
                java.lang.Object r8 = r0.f51710g
                java.lang.Object r0 = r0.f51709f
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1) r0
                kotlin.ResultKt.b(r9)
                goto L5e
            L33:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L3b:
                kotlin.ResultKt.b(r9)
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Job> r9 = r7.f51701f
                T r9 = r9.f51016f
                kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
                if (r9 == 0) goto L5d
                kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
                r2.<init>()
                r9.e(r2)
                r0.f51709f = r7
                r0.f51710g = r8
                r0.f51711h = r9
                r0.f51714k = r3
                java.lang.Object r9 = r9.v0(r0)
                if (r9 != r1) goto L5d
                return r1
            L5d:
                r0 = r7
            L5e:
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Job> r9 = r0.f51701f
                kotlinx.coroutines.CoroutineScope r1 = r0.f51702g
                r2 = 0
                kotlinx.coroutines.CoroutineStart r3 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 r4 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest<T, R> r5 = r0.f51703h
                kotlinx.coroutines.flow.FlowCollector<R> r0 = r0.f51704i
                r6 = 0
                r4.<init>(r5, r0, r8, r6)
                r5 = 1
                kotlinx.coroutines.Job r8 = kotlinx.coroutines.BuildersKt.d(r1, r2, r3, r4, r5, r6)
                r9.f51016f = r8
                kotlin.Unit r8 = kotlin.Unit.f50853a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, Continuation<? super ChannelFlowTransformLatest$flowCollect$3> continuation) {
        super(2, continuation);
        this.f51699i = channelFlowTransformLatest;
        this.f51700j = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.f51699i, this.f51700j, continuation);
        channelFlowTransformLatest$flowCollect$3.f51698h = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    public final Object h(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f51697g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ChannelFlowTransformLatest<T, R> channelFlowTransformLatest = this.f51699i;
            Flow<S> flow = channelFlowTransformLatest.f51692i;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$ObjectRef, (CoroutineScope) this.f51698h, channelFlowTransformLatest, this.f51700j);
            this.f51697g = 1;
            if (flow.a(anonymousClass1, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return h(coroutineScope, continuation);
    }
}
