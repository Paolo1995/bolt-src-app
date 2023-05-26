package kotlinx.coroutines.flow;

import com.google.android.gms.common.api.Api;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;

/* compiled from: Merge.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: a */
    private static final int f51549a = SystemPropsKt.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Api.BaseClientBuilder.API_PRIORITY_OTHER);

    public static final <T, R> Flow<R> a(final Flow<? extends T> flow, final Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.w(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f51552f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ Function2 f51553g;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", l = {223, 223}, m = "emit")
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f51554f;

                    /* renamed from: g  reason: collision with root package name */
                    int f51555g;

                    /* renamed from: h  reason: collision with root package name */
                    Object f51556h;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f51554f = obj;
                        this.f51555g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
                    this.f51552f = flowCollector;
                    this.f51553g = function2;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x005c A[RETURN] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f51555g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f51555g = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f51554f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f51555g
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.ResultKt.b(r8)
                        goto L5d
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        java.lang.Object r7 = r0.f51556h
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        kotlin.ResultKt.b(r8)
                        goto L51
                    L3c:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f51552f
                        kotlin.jvm.functions.Function2 r2 = r6.f51553g
                        r0.f51556h = r8
                        r0.f51555g = r4
                        java.lang.Object r7 = r2.s(r7, r0)
                        if (r7 != r1) goto L4e
                        return r1
                    L4e:
                        r5 = r8
                        r8 = r7
                        r7 = r5
                    L51:
                        r2 = 0
                        r0.f51556h = r2
                        r0.f51555g = r3
                        java.lang.Object r7 = r7.b(r8, r0)
                        if (r7 != r1) goto L5d
                        return r1
                    L5d:
                        kotlin.Unit r7 = kotlin.Unit.f50853a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector, function2), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        });
    }

    public static final <T, R> Flow<R> b(final Flow<? extends T> flow, int i8, final Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.x(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f51560f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ Function2 f51561g;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", l = {223, 223}, m = "emit")
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f51562f;

                    /* renamed from: g  reason: collision with root package name */
                    int f51563g;

                    /* renamed from: h  reason: collision with root package name */
                    Object f51564h;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f51562f = obj;
                        this.f51563g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
                    this.f51560f = flowCollector;
                    this.f51561g = function2;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x005c A[RETURN] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f51563g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f51563g = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f51562f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f51563g
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.ResultKt.b(r8)
                        goto L5d
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        java.lang.Object r7 = r0.f51564h
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        kotlin.ResultKt.b(r8)
                        goto L51
                    L3c:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f51560f
                        kotlin.jvm.functions.Function2 r2 = r6.f51561g
                        r0.f51564h = r8
                        r0.f51563g = r4
                        java.lang.Object r7 = r2.s(r7, r0)
                        if (r7 != r1) goto L4e
                        return r1
                    L4e:
                        r5 = r8
                        r8 = r7
                        r7 = r5
                    L51:
                        r2 = 0
                        r0.f51564h = r2
                        r0.f51563g = r3
                        java.lang.Object r7 = r7.b(r8, r0)
                        if (r7 != r1) goto L5d
                        return r1
                    L5d:
                        kotlin.Unit r7 = kotlin.Unit.f50853a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector, function2), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        }, i8);
    }

    public static /* synthetic */ Flow c(Flow flow, int i8, Function2 function2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = f51549a;
        }
        return FlowKt.u(flow, i8, function2);
    }

    public static final <T> Flow<T> d(final Flow<? extends Flow<? extends T>> flow) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
                Object d8;
                Object a8 = Flow.this.a(new FlowKt__MergeKt$flattenConcat$1$1(flowCollector), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        };
    }

    public static final <T> Flow<T> e(Flow<? extends Flow<? extends T>> flow, int i8) {
        boolean z7;
        if (i8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 == 1) {
                return FlowKt.w(flow);
            }
            return new ChannelFlowMerge(flow, i8, null, 0, null, 28, null);
        }
        throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i8).toString());
    }

    public static final <T, R> Flow<R> f(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt.I(flow, new FlowKt__MergeKt$mapLatest$1(function2, null));
    }

    public static final <T> Flow<T> g(Iterable<? extends Flow<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    public static final <T> Flow<T> h(Flow<? extends T>... flowArr) {
        Iterable u7;
        u7 = ArraysKt___ArraysKt.u(flowArr);
        return FlowKt.C(u7);
    }

    public static final <T, R> Flow<R> i(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new ChannelFlowTransformLatest(function3, flow, null, 0, null, 28, null);
    }
}
