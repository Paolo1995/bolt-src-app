package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public class LottieTask<T> {

    /* renamed from: e  reason: collision with root package name */
    public static Executor f8960e = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    private final Set<LottieListener<T>> f8961a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<LottieListener<Throwable>> f8962b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f8963c;

    /* renamed from: d  reason: collision with root package name */
    private volatile LottieResult<T> f8964d;

    /* loaded from: classes.dex */
    private class LottieFutureTask extends FutureTask<LottieResult<T>> {
        LottieFutureTask(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (!isCancelled()) {
                try {
                    LottieTask.this.k(get());
                } catch (InterruptedException | ExecutionException e8) {
                    LottieTask.this.k(new LottieResult(e8));
                }
            }
        }
    }

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        LottieResult<T> lottieResult = this.f8964d;
        if (lottieResult == null) {
            return;
        }
        if (lottieResult.b() != null) {
            h(lottieResult.b());
        } else {
            f(lottieResult.a());
        }
    }

    private synchronized void f(Throwable th) {
        ArrayList<LottieListener> arrayList = new ArrayList(this.f8962b);
        if (arrayList.isEmpty()) {
            Logger.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (LottieListener lottieListener : arrayList) {
            lottieListener.onResult(th);
        }
    }

    private void g() {
        this.f8963c.post(new Runnable() { // from class: com.airbnb.lottie.z
            @Override // java.lang.Runnable
            public final void run() {
                LottieTask.this.e();
            }
        });
    }

    private synchronized void h(T t7) {
        for (LottieListener lottieListener : new ArrayList(this.f8961a)) {
            lottieListener.onResult(t7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(LottieResult<T> lottieResult) {
        if (this.f8964d == null) {
            this.f8964d = lottieResult;
            g();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> c(LottieListener<Throwable> lottieListener) {
        LottieResult<T> lottieResult = this.f8964d;
        if (lottieResult != null && lottieResult.a() != null) {
            lottieListener.onResult(lottieResult.a());
        }
        this.f8962b.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> d(LottieListener<T> lottieListener) {
        LottieResult<T> lottieResult = this.f8964d;
        if (lottieResult != null && lottieResult.b() != null) {
            lottieListener.onResult(lottieResult.b());
        }
        this.f8961a.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> i(LottieListener<Throwable> lottieListener) {
        this.f8962b.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> j(LottieListener<T> lottieListener) {
        this.f8961a.remove(lottieListener);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LottieTask(Callable<LottieResult<T>> callable, boolean z7) {
        this.f8961a = new LinkedHashSet(1);
        this.f8962b = new LinkedHashSet(1);
        this.f8963c = new Handler(Looper.getMainLooper());
        this.f8964d = null;
        if (z7) {
            try {
                k(callable.call());
                return;
            } catch (Throwable th) {
                k(new LottieResult<>(th));
                return;
            }
        }
        f8960e.execute(new LottieFutureTask(callable));
    }
}
