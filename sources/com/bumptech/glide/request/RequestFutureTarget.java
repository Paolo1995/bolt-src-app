package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {

    /* renamed from: p  reason: collision with root package name */
    private static final Waiter f10671p = new Waiter();

    /* renamed from: f  reason: collision with root package name */
    private final int f10672f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10673g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f10674h;

    /* renamed from: i  reason: collision with root package name */
    private final Waiter f10675i;

    /* renamed from: j  reason: collision with root package name */
    private R f10676j;

    /* renamed from: k  reason: collision with root package name */
    private Request f10677k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10678l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10679m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10680n;

    /* renamed from: o  reason: collision with root package name */
    private GlideException f10681o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Waiter {
        Waiter() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j8) throws InterruptedException {
            obj.wait(j8);
        }
    }

    public RequestFutureTarget(int i8, int i9) {
        this(i8, i9, true, f10671p);
    }

    private synchronized R l(Long l8) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f10674h && !isDone()) {
            Util.a();
        }
        if (!this.f10678l) {
            if (!this.f10680n) {
                if (this.f10679m) {
                    return this.f10676j;
                }
                if (l8 == null) {
                    this.f10675i.b(this, 0L);
                } else if (l8.longValue() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = l8.longValue() + currentTimeMillis;
                    while (!isDone() && currentTimeMillis < longValue) {
                        this.f10675i.b(this, longValue - currentTimeMillis);
                        currentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (!Thread.interrupted()) {
                    if (!this.f10680n) {
                        if (!this.f10678l) {
                            if (this.f10679m) {
                                return this.f10676j;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.f10681o);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.f10681o);
        }
        throw new CancellationException();
    }

    @Override // com.bumptech.glide.request.target.Target
    public void a(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void b(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized Request c() {
        return this.f10677k;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z7) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.f10678l = true;
            this.f10675i.a(this);
            Request request = null;
            if (z7) {
                Request request2 = this.f10677k;
                this.f10677k = null;
                request = request2;
            }
            if (request != null) {
                request.clear();
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void d(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void e(@NonNull R r7, Transition<? super R> transition) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void g(Request request) {
        this.f10677k = request;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return l(null);
        } catch (TimeoutException e8) {
            throw new AssertionError(e8);
        }
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean h(GlideException glideException, Object obj, Target<R> target, boolean z7) {
        this.f10680n = true;
        this.f10681o = glideException;
        this.f10675i.a(this);
        return false;
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void i(Drawable drawable) {
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f10678l;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z7;
        if (!this.f10678l && !this.f10679m) {
            if (!this.f10680n) {
                z7 = false;
            }
        }
        z7 = true;
        return z7;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean j(R r7, Object obj, Target<R> target, DataSource dataSource, boolean z7) {
        this.f10679m = true;
        this.f10676j = r7;
        this.f10675i.a(this);
        return false;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void k(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.e(this.f10672f, this.f10673g);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    RequestFutureTarget(int i8, int i9, boolean z7, Waiter waiter) {
        this.f10672f = i8;
        this.f10673g = i9;
        this.f10674h = z7;
        this.f10675i = waiter;
    }

    @Override // java.util.concurrent.Future
    public R get(long j8, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return l(Long.valueOf(timeUnit.toMillis(j8)));
    }
}
