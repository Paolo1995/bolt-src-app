package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {

    /* renamed from: k  reason: collision with root package name */
    SettableFuture<ListenableWorker.Result> f8328k;

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public final ListenableFuture<ListenableWorker.Result> p() {
        this.f8328k = SettableFuture.t();
        c().execute(new Runnable() { // from class: androidx.work.Worker.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Worker.this.f8328k.p(Worker.this.r());
                } catch (Throwable th) {
                    Worker.this.f8328k.q(th);
                }
            }
        });
        return this.f8328k;
    }

    @NonNull
    public abstract ListenableWorker.Result r();
}
