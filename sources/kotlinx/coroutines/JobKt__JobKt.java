package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.Sequence;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Job.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class JobKt__JobKt {
    public static final CompletableJob a(Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob b(Job job, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            job = null;
        }
        return JobKt.a(job);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.g(Job.f51296d);
        if (job != null) {
            job.e(cancellationException);
        }
    }

    public static final void d(Job job, String str, Throwable th) {
        job.e(ExceptionsKt.a(str, th));
    }

    public static /* synthetic */ void e(CoroutineContext coroutineContext, CancellationException cancellationException, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.c(coroutineContext, cancellationException);
    }

    public static final void f(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Sequence<Job> y7;
        Job job = (Job) coroutineContext.g(Job.f51296d);
        if (job != null && (y7 = job.y()) != null) {
            for (Job job2 : y7) {
                job2.e(cancellationException);
            }
        }
    }

    public static final DisposableHandle g(Job job, DisposableHandle disposableHandle) {
        return job.X(new DisposeOnCompletion(disposableHandle));
    }

    public static final void h(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.g(Job.f51296d);
        if (job != null) {
            JobKt.j(job);
        }
    }

    public static final void i(Job job) {
        if (job.isActive()) {
            return;
        }
        throw job.I();
    }

    public static final Job j(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.g(Job.f51296d);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final boolean k(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.g(Job.f51296d);
        if (job != null && job.isActive()) {
            return true;
        }
        return false;
    }
}
