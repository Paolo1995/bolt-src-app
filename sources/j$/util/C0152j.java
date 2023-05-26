package j$.util;

import java.util.NoSuchElementException;

/* renamed from: j$.util.j  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0152j {

    /* renamed from: c  reason: collision with root package name */
    private static final C0152j f50351c = new C0152j();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f50352a;

    /* renamed from: b  reason: collision with root package name */
    private final double f50353b;

    private C0152j() {
        this.f50352a = false;
        this.f50353b = Double.NaN;
    }

    private C0152j(double d8) {
        this.f50352a = true;
        this.f50353b = d8;
    }

    public static C0152j a() {
        return f50351c;
    }

    public static C0152j d(double d8) {
        return new C0152j(d8);
    }

    public final double b() {
        if (this.f50352a) {
            return this.f50353b;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean c() {
        return this.f50352a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0152j) {
            C0152j c0152j = (C0152j) obj;
            boolean z7 = this.f50352a;
            if (z7 && c0152j.f50352a) {
                if (Double.compare(this.f50353b, c0152j.f50353b) == 0) {
                    return true;
                }
            } else if (z7 == c0152j.f50352a) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        if (this.f50352a) {
            long doubleToLongBits = Double.doubleToLongBits(this.f50353b);
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        }
        return 0;
    }

    public final String toString() {
        return this.f50352a ? String.format("OptionalDouble[%s]", Double.valueOf(this.f50353b)) : "OptionalDouble.empty";
    }
}
