package io.reactivex.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
final class HandlerScheduler extends Scheduler {

    /* renamed from: c  reason: collision with root package name */
    private final Handler f47594c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f47595d;

    /* loaded from: classes5.dex */
    private static final class HandlerWorker extends Scheduler.Worker {

        /* renamed from: f  reason: collision with root package name */
        private final Handler f47596f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f47597g;

        /* renamed from: h  reason: collision with root package name */
        private volatile boolean f47598h;

        HandlerWorker(Handler handler, boolean z7) {
            this.f47596f = handler;
            this.f47597g = z7;
        }

        @Override // io.reactivex.Scheduler.Worker
        @SuppressLint({"NewApi"})
        public Disposable c(Runnable runnable, long j8, TimeUnit timeUnit) {
            if (runnable != null) {
                if (timeUnit != null) {
                    if (this.f47598h) {
                        return Disposables.a();
                    }
                    ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.f47596f, RxJavaPlugins.u(runnable));
                    Message obtain = Message.obtain(this.f47596f, scheduledRunnable);
                    obtain.obj = this;
                    if (this.f47597g) {
                        obtain.setAsynchronous(true);
                    }
                    this.f47596f.sendMessageDelayed(obtain, timeUnit.toMillis(j8));
                    if (this.f47598h) {
                        this.f47596f.removeCallbacks(scheduledRunnable);
                        return Disposables.a();
                    }
                    return scheduledRunnable;
                }
                throw new NullPointerException("unit == null");
            }
            throw new NullPointerException("run == null");
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f47598h = true;
            this.f47596f.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47598h;
        }
    }

    /* loaded from: classes5.dex */
    private static final class ScheduledRunnable implements Runnable, Disposable {

        /* renamed from: f  reason: collision with root package name */
        private final Handler f47599f;

        /* renamed from: g  reason: collision with root package name */
        private final Runnable f47600g;

        /* renamed from: h  reason: collision with root package name */
        private volatile boolean f47601h;

        ScheduledRunnable(Handler handler, Runnable runnable) {
            this.f47599f = handler;
            this.f47600g = runnable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f47599f.removeCallbacks(this);
            this.f47601h = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47601h;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f47600g.run();
            } catch (Throwable th) {
                RxJavaPlugins.s(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerScheduler(Handler handler, boolean z7) {
        this.f47594c = handler;
        this.f47595d = z7;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new HandlerWorker(this.f47594c, this.f47595d);
    }

    @Override // io.reactivex.Scheduler
    @SuppressLint({"NewApi"})
    public Disposable e(Runnable runnable, long j8, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit != null) {
                ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.f47594c, RxJavaPlugins.u(runnable));
                Message obtain = Message.obtain(this.f47594c, scheduledRunnable);
                if (this.f47595d) {
                    obtain.setAsynchronous(true);
                }
                this.f47594c.sendMessageDelayed(obtain, timeUnit.toMillis(j8));
                return scheduledRunnable;
            }
            throw new NullPointerException("unit == null");
        }
        throw new NullPointerException("run == null");
    }
}
