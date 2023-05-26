package androidx.work;

import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: ListenableFuture.kt */
/* loaded from: classes.dex */
public final class JobListenableFuture<R> implements ListenableFuture<R> {

    /* renamed from: f  reason: collision with root package name */
    private final Job f8280f;

    /* renamed from: g  reason: collision with root package name */
    private final SettableFuture<R> f8281g;

    public JobListenableFuture(Job job, SettableFuture<R> underlying) {
        Intrinsics.f(job, "job");
        Intrinsics.f(underlying, "underlying");
        this.f8280f = job;
        this.f8281g = underlying;
        job.X(new Function1<Throwable, Unit>(this) { // from class: androidx.work.JobListenableFuture.1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ JobListenableFuture<R> f8282f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f8282f = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th == null) {
                    if (!((JobListenableFuture) this.f8282f).f8281g.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else if (th instanceof CancellationException) {
                    ((JobListenableFuture) this.f8282f).f8281g.cancel(true);
                } else {
                    SettableFuture settableFuture = ((JobListenableFuture) this.f8282f).f8281g;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    settableFuture.q(th);
                }
            }
        });
    }

    public final void b(R r7) {
        this.f8281g.p(r7);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z7) {
        return this.f8281g.cancel(z7);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void f(Runnable runnable, Executor executor) {
        this.f8281g.f(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public R get() {
        return this.f8281g.get();
    }

    @Override // java.util.concurrent.Future
    public R get(long j8, TimeUnit timeUnit) {
        return this.f8281g.get(j8, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f8281g.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f8281g.isDone();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ JobListenableFuture(kotlinx.coroutines.Job r1, androidx.work.impl.utils.futures.SettableFuture r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto Ld
            androidx.work.impl.utils.futures.SettableFuture r2 = androidx.work.impl.utils.futures.SettableFuture.t()
            java.lang.String r3 = "create()"
            kotlin.jvm.internal.Intrinsics.e(r2, r3)
        Ld:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.JobListenableFuture.<init>(kotlinx.coroutines.Job, androidx.work.impl.utils.futures.SettableFuture, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
