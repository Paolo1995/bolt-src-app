package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {

    /* renamed from: f  reason: collision with root package name */
    Subscription f49785f;

    /* renamed from: g  reason: collision with root package name */
    long f49786g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicReference<Subscription> f49787h = new AtomicReference<>();

    /* renamed from: i  reason: collision with root package name */
    final AtomicLong f49788i = new AtomicLong();

    /* renamed from: j  reason: collision with root package name */
    final AtomicLong f49789j = new AtomicLong();

    /* renamed from: k  reason: collision with root package name */
    final boolean f49790k;

    /* renamed from: l  reason: collision with root package name */
    volatile boolean f49791l;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f49792m;

    public SubscriptionArbiter(boolean z7) {
        this.f49790k = z7;
    }

    final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        b();
    }

    final void b() {
        int i8 = 1;
        Subscription subscription = null;
        long j8 = 0;
        do {
            Subscription subscription2 = this.f49787h.get();
            if (subscription2 != null) {
                subscription2 = this.f49787h.getAndSet(null);
            }
            long j9 = this.f49788i.get();
            if (j9 != 0) {
                j9 = this.f49788i.getAndSet(0L);
            }
            long j10 = this.f49789j.get();
            if (j10 != 0) {
                j10 = this.f49789j.getAndSet(0L);
            }
            Subscription subscription3 = this.f49785f;
            if (this.f49791l) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.f49785f = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j11 = this.f49786g;
                if (j11 != Long.MAX_VALUE) {
                    j11 = BackpressureHelper.b(j11, j9);
                    if (j11 != Long.MAX_VALUE) {
                        j11 -= j10;
                        if (j11 < 0) {
                            SubscriptionHelper.h(j11);
                            j11 = 0;
                        }
                    }
                    this.f49786g = j11;
                }
                if (subscription2 != null) {
                    if (subscription3 != null && this.f49790k) {
                        subscription3.cancel();
                    }
                    this.f49785f = subscription2;
                    if (j11 != 0) {
                        j8 = BackpressureHelper.b(j8, j11);
                        subscription = subscription2;
                    }
                } else if (subscription3 != null && j9 != 0) {
                    j8 = BackpressureHelper.b(j8, j9);
                    subscription = subscription3;
                }
            }
            i8 = addAndGet(-i8);
        } while (i8 != 0);
        if (j8 != 0) {
            subscription.f(j8);
        }
    }

    public void cancel() {
        if (!this.f49791l) {
            this.f49791l = true;
            a();
        }
    }

    public final boolean d() {
        return this.f49792m;
    }

    @Override // org.reactivestreams.Subscription
    public final void f(long j8) {
        if (!SubscriptionHelper.m(j8) || this.f49792m) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j9 = this.f49786g;
            if (j9 != Long.MAX_VALUE) {
                long b8 = BackpressureHelper.b(j9, j8);
                this.f49786g = b8;
                if (b8 == Long.MAX_VALUE) {
                    this.f49792m = true;
                }
            }
            Subscription subscription = this.f49785f;
            if (decrementAndGet() != 0) {
                b();
            }
            if (subscription != null) {
                subscription.f(j8);
                return;
            }
            return;
        }
        BackpressureHelper.a(this.f49788i, j8);
        a();
    }

    public final void g(long j8) {
        if (this.f49792m) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j9 = this.f49786g;
            if (j9 != Long.MAX_VALUE) {
                long j10 = j9 - j8;
                if (j10 < 0) {
                    SubscriptionHelper.h(j10);
                    j10 = 0;
                }
                this.f49786g = j10;
            }
            if (decrementAndGet() == 0) {
                return;
            }
            b();
            return;
        }
        BackpressureHelper.a(this.f49789j, j8);
        a();
    }

    public final void i(Subscription subscription) {
        if (this.f49791l) {
            subscription.cancel();
            return;
        }
        ObjectHelper.e(subscription, "s is null");
        if (get() == 0 && compareAndSet(0, 1)) {
            Subscription subscription2 = this.f49785f;
            if (subscription2 != null && this.f49790k) {
                subscription2.cancel();
            }
            this.f49785f = subscription;
            long j8 = this.f49786g;
            if (decrementAndGet() != 0) {
                b();
            }
            if (j8 != 0) {
                subscription.f(j8);
                return;
            }
            return;
        }
        Subscription andSet = this.f49787h.getAndSet(subscription);
        if (andSet != null && this.f49790k) {
            andSet.cancel();
        }
        a();
    }
}
