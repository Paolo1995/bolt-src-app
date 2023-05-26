package io.ktor.utils.io.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* compiled from: CancellableReusableContinuation.kt */
/* loaded from: classes5.dex */
public final class CancellableReusableContinuation<T> implements Continuation<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f47420f = AtomicReferenceFieldUpdater.newUpdater(CancellableReusableContinuation.class, Object.class, "state");

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f47421g = AtomicReferenceFieldUpdater.newUpdater(CancellableReusableContinuation.class, Object.class, "jobCancellationHandler");
    private volatile /* synthetic */ Object state = null;
    private volatile /* synthetic */ Object jobCancellationHandler = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CancellableReusableContinuation.kt */
    /* loaded from: classes5.dex */
    public final class JobRelation implements Function1<Throwable, Unit> {

        /* renamed from: f  reason: collision with root package name */
        private final Job f47422f;

        /* renamed from: g  reason: collision with root package name */
        private DisposableHandle f47423g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ CancellableReusableContinuation<T> f47424h;

        public JobRelation(CancellableReusableContinuation cancellableReusableContinuation, Job job) {
            Intrinsics.f(job, "job");
            this.f47424h = cancellableReusableContinuation;
            this.f47422f = job;
            DisposableHandle d8 = Job.DefaultImpls.d(job, true, false, this, 2, null);
            if (job.isActive()) {
                this.f47423g = d8;
            }
        }

        public final void b() {
            DisposableHandle disposableHandle = this.f47423g;
            if (disposableHandle != null) {
                this.f47423g = null;
                disposableHandle.dispose();
            }
        }

        public final Job c() {
            return this.f47422f;
        }

        public void d(Throwable th) {
            this.f47424h.g(this);
            b();
            if (th != null) {
                this.f47424h.j(this.f47422f, th);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            d(th);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(CancellableReusableContinuation<T>.JobRelation jobRelation) {
        a.a(f47421g, this, jobRelation, null);
    }

    private final void h(CoroutineContext coroutineContext) {
        Job job;
        Object obj;
        JobRelation jobRelation;
        Job job2 = (Job) coroutineContext.g(Job.f51296d);
        JobRelation jobRelation2 = (JobRelation) this.jobCancellationHandler;
        if (jobRelation2 != null) {
            job = jobRelation2.c();
        } else {
            job = null;
        }
        if (job == job2) {
            return;
        }
        if (job2 == null) {
            JobRelation jobRelation3 = (JobRelation) f47421g.getAndSet(this, null);
            if (jobRelation3 != null) {
                jobRelation3.b();
                return;
            }
            return;
        }
        JobRelation jobRelation4 = new JobRelation(this, job2);
        do {
            obj = this.jobCancellationHandler;
            jobRelation = (JobRelation) obj;
            if (jobRelation != null && jobRelation.c() == job2) {
                jobRelation4.b();
                return;
            }
        } while (!a.a(f47421g, this, obj, jobRelation4));
        if (jobRelation != null) {
            jobRelation.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Job job, Throwable th) {
        Object obj;
        do {
            obj = this.state;
            if (!(obj instanceof Continuation) || ((Continuation) obj).getContext().g(Job.f51296d) != job) {
                return;
            }
        } while (!a.a(f47420f, this, obj, null));
        if (obj != null) {
            Result.Companion companion = Result.f50818g;
            ((Continuation) obj).resumeWith(Result.b(ResultKt.a(th)));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<T of io.ktor.utils.io.internal.CancellableReusableContinuation>");
    }

    public final void d(T value) {
        Intrinsics.f(value, "value");
        resumeWith(Result.b(value));
        JobRelation jobRelation = (JobRelation) f47421g.getAndSet(this, null);
        if (jobRelation != null) {
            jobRelation.b();
        }
    }

    public final void e(Throwable cause) {
        Intrinsics.f(cause, "cause");
        Result.Companion companion = Result.f50818g;
        resumeWith(Result.b(ResultKt.a(cause)));
        JobRelation jobRelation = (JobRelation) f47421g.getAndSet(this, null);
        if (jobRelation != null) {
            jobRelation.b();
        }
    }

    public final Object f(Continuation<? super T> actual) {
        Object d8;
        Intrinsics.f(actual, "actual");
        while (true) {
            Object obj = this.state;
            if (obj == null) {
                if (a.a(f47420f, this, null, actual)) {
                    h(actual.getContext());
                    d8 = IntrinsicsKt__IntrinsicsKt.d();
                    return d8;
                }
            } else if (a.a(f47420f, this, obj, null)) {
                if (!(obj instanceof Throwable)) {
                    return obj;
                }
                throw ((Throwable) obj);
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        Continuation continuation;
        CoroutineContext context;
        Object obj = this.state;
        if (obj instanceof Continuation) {
            continuation = (Continuation) obj;
        } else {
            continuation = null;
        }
        if (continuation == null || (context = continuation.getContext()) == null) {
            return EmptyCoroutineContext.f50912f;
        }
        return context;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        Object obj2;
        Object obj3;
        do {
            obj2 = this.state;
            if (obj2 == null) {
                obj3 = Result.e(obj);
                if (obj3 == null) {
                    ResultKt.b(obj);
                    obj3 = obj;
                }
            } else if (obj2 instanceof Continuation) {
                obj3 = null;
            } else {
                return;
            }
        } while (!a.a(f47420f, this, obj2, obj3));
        if (obj2 instanceof Continuation) {
            ((Continuation) obj2).resumeWith(obj);
        }
    }
}
