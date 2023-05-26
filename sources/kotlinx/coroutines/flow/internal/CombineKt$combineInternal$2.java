package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Combine.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {57, 79, 82}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f51719g;

    /* renamed from: h  reason: collision with root package name */
    Object f51720h;

    /* renamed from: i  reason: collision with root package name */
    int f51721i;

    /* renamed from: j  reason: collision with root package name */
    int f51722j;

    /* renamed from: k  reason: collision with root package name */
    int f51723k;

    /* renamed from: l  reason: collision with root package name */
    private /* synthetic */ Object f51724l;

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ Flow<T>[] f51725m;

    /* renamed from: n  reason: collision with root package name */
    final /* synthetic */ Function0<T[]> f51726n;

    /* renamed from: o  reason: collision with root package name */
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> f51727o;

    /* renamed from: p  reason: collision with root package name */
    final /* synthetic */ FlowCollector<R> f51728p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Combine.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {34}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f51729g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Flow<T>[] f51730h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ int f51731i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f51732j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Channel<IndexedValue<Object>> f51733k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Combine.kt */
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C01041<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Channel<IndexedValue<Object>> f51734f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ int f51735g;

            C01041(Channel<IndexedValue<Object>> channel, int i8) {
                this.f51734f = channel;
                this.f51735g = i8;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0055 A[RETURN] */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object b(T r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r8
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
                    int r1 = r0.f51738h
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f51738h = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    r0.<init>(r6, r8)
                L18:
                    java.lang.Object r8 = r0.f51736f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f51738h
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L38
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.ResultKt.b(r8)
                    goto L56
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    kotlin.ResultKt.b(r8)
                    goto L4d
                L38:
                    kotlin.ResultKt.b(r8)
                    kotlinx.coroutines.channels.Channel<kotlin.collections.IndexedValue<java.lang.Object>> r8 = r6.f51734f
                    kotlin.collections.IndexedValue r2 = new kotlin.collections.IndexedValue
                    int r5 = r6.f51735g
                    r2.<init>(r5, r7)
                    r0.f51738h = r4
                    java.lang.Object r7 = r8.D(r2, r0)
                    if (r7 != r1) goto L4d
                    return r1
                L4d:
                    r0.f51738h = r3
                    java.lang.Object r7 = kotlinx.coroutines.YieldKt.a(r0)
                    if (r7 != r1) goto L56
                    return r1
                L56:
                    kotlin.Unit r7 = kotlin.Unit.f50853a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1.C01041.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T>[] flowArr, int i8, AtomicInteger atomicInteger, Channel<IndexedValue<Object>> channel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.f51730h = flowArr;
            this.f51731i = i8;
            this.f51732j = atomicInteger;
            this.f51733k = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.f51730h, this.f51731i, this.f51732j, this.f51733k, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            AtomicInteger atomicInteger;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f51729g;
            try {
                if (i8 != 0) {
                    if (i8 == 1) {
                        ResultKt.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.b(obj);
                    Flow[] flowArr = this.f51730h;
                    int i9 = this.f51731i;
                    Flow flow = flowArr[i9];
                    C01041 c01041 = new C01041(this.f51733k, i9);
                    this.f51729g = 1;
                    if (flow.a(c01041, this) == d8) {
                        return d8;
                    }
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.a(this.f51733k, null, 1, null);
                }
                return Unit.f50853a;
            } finally {
                if (this.f51732j.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.a(this.f51733k, null, 1, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.f51725m = flowArr;
        this.f51726n = function0;
        this.f51727o = function3;
        this.f51728p = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.f51725m, this.f51726n, this.f51727o, this.f51728p, continuation);
        combineKt$combineInternal$2.f51724l = obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec A[LOOP:0: B:28:0x00ec->B:34:0x010f, LOOP_START, PHI: r3 r10 
      PHI: (r3v2 int) = (r3v1 int), (r3v3 int) binds: [B:25:0x00e7, B:34:0x010f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v5 kotlin.collections.IndexedValue) = (r10v4 kotlin.collections.IndexedValue), (r10v18 kotlin.collections.IndexedValue) binds: [B:25:0x00e7, B:34:0x010f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.flow.Flow<T>[]] */
    /* JADX WARN: Type inference failed for: r7v4, types: [kotlinx.coroutines.flow.Flow[], kotlinx.coroutines.flow.Flow<T>[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0134 -> B:20:0x00c7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0169 -> B:45:0x0165). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
