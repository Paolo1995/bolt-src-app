package eu.bolt.driver.core.util;

import eu.bolt.driver.core.time.SystemUptimeSource;

/* compiled from: RateLimiter.kt */
/* loaded from: classes5.dex */
public final class RateLimiter {

    /* renamed from: a  reason: collision with root package name */
    private final double f41315a;

    /* renamed from: b  reason: collision with root package name */
    private final SystemUptimeSource f41316b = new SystemUptimeSource();

    /* renamed from: c  reason: collision with root package name */
    private volatile long f41317c;

    public RateLimiter(double d8) {
        this.f41315a = d8;
    }

    private final void a(int i8) {
        this.f41317c = this.f41316b.a() + c(i8);
    }

    private final boolean b() {
        if (this.f41316b.a() > this.f41317c) {
            return true;
        }
        return false;
    }

    private final long c(int i8) {
        return (long) (1000 * (i8 / this.f41315a));
    }

    public static /* synthetic */ boolean e(RateLimiter rateLimiter, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = 1;
        }
        return rateLimiter.d(i8);
    }

    public final synchronized boolean d(int i8) {
        if (b()) {
            a(i8);
            return true;
        }
        return false;
    }
}
