package io.reactivex.schedulers;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class Timed<T> {

    /* renamed from: a  reason: collision with root package name */
    final T f49895a;

    /* renamed from: b  reason: collision with root package name */
    final long f49896b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f49897c;

    public Timed(T t7, long j8, TimeUnit timeUnit) {
        this.f49895a = t7;
        this.f49896b = j8;
        this.f49897c = (TimeUnit) ObjectHelper.e(timeUnit, "unit is null");
    }

    public long a() {
        return this.f49896b;
    }

    public T b() {
        return this.f49895a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (!ObjectHelper.c(this.f49895a, timed.f49895a) || this.f49896b != timed.f49896b || !ObjectHelper.c(this.f49897c, timed.f49897c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i8;
        T t7 = this.f49895a;
        if (t7 != null) {
            i8 = t7.hashCode();
        } else {
            i8 = 0;
        }
        long j8 = this.f49896b;
        return (((i8 * 31) + ((int) (j8 ^ (j8 >>> 31)))) * 31) + this.f49897c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f49896b + ", unit=" + this.f49897c + ", value=" + this.f49895a + "]";
    }
}
