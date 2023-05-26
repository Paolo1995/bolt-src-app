package ee.mtakso.driver.utils.polling;

import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.subjects.Subject;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicPoller.kt */
/* loaded from: classes5.dex */
public final class DynamicPoller<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Callable<T> f36447a;

    /* renamed from: b  reason: collision with root package name */
    private final RepeatStrategy<T> f36448b;

    /* renamed from: c  reason: collision with root package name */
    private final RetryStrategy f36449c;

    /* renamed from: d  reason: collision with root package name */
    private final Subject<Notification<T>> f36450d;

    /* renamed from: e  reason: collision with root package name */
    private final ScheduledExecutorService f36451e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f36452f;

    /* renamed from: g  reason: collision with root package name */
    private Future<?> f36453g;

    public DynamicPoller(Callable<T> dataSource, RepeatStrategy<T> repeatStrategy, RetryStrategy retryStrategy, Subject<Notification<T>> dataSubject) {
        Intrinsics.f(dataSource, "dataSource");
        Intrinsics.f(repeatStrategy, "repeatStrategy");
        Intrinsics.f(retryStrategy, "retryStrategy");
        Intrinsics.f(dataSubject, "dataSubject");
        this.f36447a = dataSource;
        this.f36448b = repeatStrategy;
        this.f36449c = retryStrategy;
        this.f36450d = dataSubject;
        this.f36451e = Executors.newScheduledThreadPool(1);
        this.f36452f = new AtomicBoolean(false);
    }

    private final void d() {
        ScheduledFuture<?> scheduledFuture;
        if (!g()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ScheduledFuture<?> scheduledFuture2 = null;
        try {
            T call = this.f36447a.call();
            j(call);
            long a8 = this.f36448b.a(call);
            if (a8 != -1) {
                scheduledFuture = this.f36451e.schedule(new Runnable() { // from class: ee.mtakso.driver.utils.polling.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        DynamicPoller.e(DynamicPoller.this);
                    }
                }, Math.max(TimeUnit.SECONDS.toMillis(a8) - (System.currentTimeMillis() - currentTimeMillis), 0L), TimeUnit.MILLISECONDS);
            } else {
                Kalev.b("Received NO_REPEAT signal");
                n();
                scheduledFuture = null;
            }
            this.f36453g = scheduledFuture;
        } catch (Throwable th) {
            long a9 = this.f36449c.a(th);
            k(th);
            if (a9 != -1) {
                scheduledFuture2 = this.f36451e.schedule(new Runnable() { // from class: ee.mtakso.driver.utils.polling.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        DynamicPoller.f(DynamicPoller.this);
                    }
                }, a9, TimeUnit.SECONDS);
            } else {
                n();
            }
            this.f36453g = scheduledFuture2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(DynamicPoller this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(DynamicPoller this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.d();
    }

    private final void j(T t7) {
        if (g()) {
            this.f36450d.onNext(Notification.c(t7));
        }
    }

    private final void k(Throwable th) {
        if (g()) {
            this.f36450d.onNext(Notification.b(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DynamicPoller this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.d();
    }

    public final boolean g() {
        return this.f36452f.get();
    }

    public final Observable<T> h() {
        return ObservableExtKt.k(this.f36450d, new Function1<Notification<T>, T>() { // from class: ee.mtakso.driver.utils.polling.DynamicPoller$observeData$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final T invoke(Notification<T> notification) {
                return notification.e();
            }
        });
    }

    public final Observable<Throwable> i() {
        return ObservableExtKt.k(this.f36450d, new Function1<Notification<T>, Throwable>() { // from class: ee.mtakso.driver.utils.polling.DynamicPoller$observeErrors$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Throwable invoke(Notification<T> notification) {
                return notification.d();
            }
        });
    }

    public final void l() {
        if (!this.f36452f.compareAndSet(false, true)) {
            Kalev.d("Already running.");
            return;
        }
        this.f36453g = null;
        this.f36451e.execute(new Runnable() { // from class: ee.mtakso.driver.utils.polling.a
            @Override // java.lang.Runnable
            public final void run() {
                DynamicPoller.m(DynamicPoller.this);
            }
        });
    }

    public final void n() {
        this.f36452f.set(false);
        Future<?> future = this.f36453g;
        if (future != null) {
            future.cancel(false);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ DynamicPoller(java.util.concurrent.Callable r1, ee.mtakso.driver.utils.polling.RepeatStrategy r2, ee.mtakso.driver.utils.polling.RetryStrategy r3, io.reactivex.subjects.Subject r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r5 = r5 & 8
            if (r5 == 0) goto Ld
            io.reactivex.subjects.BehaviorSubject r4 = io.reactivex.subjects.BehaviorSubject.e()
            java.lang.String r5 = "create()"
            kotlin.jvm.internal.Intrinsics.e(r4, r5)
        Ld:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.utils.polling.DynamicPoller.<init>(java.util.concurrent.Callable, ee.mtakso.driver.utils.polling.RepeatStrategy, ee.mtakso.driver.utils.polling.RetryStrategy, io.reactivex.subjects.Subject, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
