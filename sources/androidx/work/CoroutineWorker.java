package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: CoroutineWorker.kt */
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {

    /* renamed from: k  reason: collision with root package name */
    private final CompletableJob f8257k;

    /* renamed from: l  reason: collision with root package name */
    private final SettableFuture<ListenableWorker.Result> f8258l;

    /* renamed from: m  reason: collision with root package name */
    private final CoroutineDispatcher f8259m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context appContext, WorkerParameters params) {
        super(appContext, params);
        CompletableJob b8;
        Intrinsics.f(appContext, "appContext");
        Intrinsics.f(params, "params");
        b8 = JobKt__JobKt.b(null, 1, null);
        this.f8257k = b8;
        SettableFuture<ListenableWorker.Result> t7 = SettableFuture.t();
        Intrinsics.e(t7, "create()");
        this.f8258l = t7;
        t7.f(new Runnable() { // from class: androidx.work.CoroutineWorker.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CoroutineWorker.this.v().isCancelled()) {
                    Job.DefaultImpls.a(CoroutineWorker.this.w(), null, 1, null);
                }
            }
        }, h().c());
        this.f8259m = Dispatchers.a();
    }

    static /* synthetic */ Object u(CoroutineWorker coroutineWorker, Continuation continuation) {
        throw new IllegalStateException("Not implemented");
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ForegroundInfo> d() {
        CompletableJob b8;
        b8 = JobKt__JobKt.b(null, 1, null);
        CoroutineScope a8 = CoroutineScopeKt.a(s().s0(b8));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(b8, null, 2, null);
        BuildersKt__Builders_commonKt.d(a8, null, null, new CoroutineWorker$getForegroundInfoAsync$1(jobListenableFuture, this, null), 3, null);
        return jobListenableFuture;
    }

    @Override // androidx.work.ListenableWorker
    public final void m() {
        super.m();
        this.f8258l.cancel(false);
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ListenableWorker.Result> p() {
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(s().s0(this.f8257k)), null, null, new CoroutineWorker$startWork$1(this, null), 3, null);
        return this.f8258l;
    }

    public abstract Object r(Continuation<? super ListenableWorker.Result> continuation);

    public CoroutineDispatcher s() {
        return this.f8259m;
    }

    public Object t(Continuation<? super ForegroundInfo> continuation) {
        return u(this, continuation);
    }

    public final SettableFuture<ListenableWorker.Result> v() {
        return this.f8258l;
    }

    public final CompletableJob w() {
        return this.f8257k;
    }
}
