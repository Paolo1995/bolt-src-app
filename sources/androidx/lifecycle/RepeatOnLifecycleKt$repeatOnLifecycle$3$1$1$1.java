package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: RepeatOnLifecycle.kt */
/* loaded from: classes.dex */
final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements LifecycleEventObserver {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Lifecycle.Event f6731f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<Job> f6732g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ CoroutineScope f6733h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Lifecycle.Event f6734i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ CancellableContinuation<Unit> f6735j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Mutex f6736k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> f6737l;

    /* compiled from: RepeatOnLifecycle.kt */
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {171, 110}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        Object f6738g;

        /* renamed from: h  reason: collision with root package name */
        Object f6739h;

        /* renamed from: i  reason: collision with root package name */
        int f6740i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Mutex f6741j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> f6742k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Mutex mutex, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.f6741j = mutex;
            this.f6742k = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.f6741j, this.f6742k, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            Mutex mutex;
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2;
            Mutex mutex2;
            Throwable th;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f6740i;
            try {
                if (i8 != 0) {
                    if (i8 != 1) {
                        if (i8 == 2) {
                            mutex2 = (Mutex) this.f6738g;
                            try {
                                ResultKt.b(obj);
                                Unit unit = Unit.f50853a;
                                mutex2.b(null);
                                return Unit.f50853a;
                            } catch (Throwable th2) {
                                th = th2;
                                mutex2.b(null);
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function2 = (Function2) this.f6739h;
                    ResultKt.b(obj);
                    mutex = (Mutex) this.f6738g;
                } else {
                    ResultKt.b(obj);
                    mutex = this.f6741j;
                    function2 = this.f6742k;
                    this.f6738g = mutex;
                    this.f6739h = function2;
                    this.f6740i = 1;
                    if (mutex.a(null, this) == d8) {
                        return d8;
                    }
                }
                RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(function2, null);
                this.f6738g = mutex;
                this.f6739h = null;
                this.f6740i = 2;
                if (CoroutineScopeKt.e(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == d8) {
                    return d8;
                }
                mutex2 = mutex;
                Unit unit2 = Unit.f50853a;
                mutex2.b(null);
                return Unit.f50853a;
            } catch (Throwable th3) {
                mutex2 = mutex;
                th = th3;
                mutex2.b(null);
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r9v5, types: [T, kotlinx.coroutines.Job] */
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ?? d8;
        Intrinsics.f(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.f(event, "event");
        if (event == this.f6731f) {
            Ref$ObjectRef<Job> ref$ObjectRef = this.f6732g;
            d8 = BuildersKt__Builders_commonKt.d(this.f6733h, null, null, new AnonymousClass1(this.f6736k, this.f6737l, null), 3, null);
            ref$ObjectRef.f51016f = d8;
            return;
        }
        if (event == this.f6734i) {
            Job job = this.f6732g.f51016f;
            if (job != null) {
                Job.DefaultImpls.a(job, null, 1, null);
            }
            this.f6732g.f51016f = null;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            CancellableContinuation<Unit> cancellableContinuation = this.f6735j;
            Result.Companion companion = Result.f50818g;
            cancellableContinuation.resumeWith(Result.b(Unit.f50853a));
        }
    }
}
