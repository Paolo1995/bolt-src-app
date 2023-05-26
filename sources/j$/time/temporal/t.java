package j$.time.temporal;

import j$.time.DateTimeException;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class t implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final long f50111a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50112b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50113c;

    /* renamed from: d  reason: collision with root package name */
    private final long f50114d;

    private t(long j8, long j9, long j10, long j11) {
        this.f50111a = j8;
        this.f50112b = j9;
        this.f50113c = j10;
        this.f50114d = j11;
    }

    private String c(long j8, o oVar) {
        if (oVar == null) {
            return "Invalid value (valid values " + this + "): " + j8;
        }
        return "Invalid value for " + oVar + " (valid values " + this + "): " + j8;
    }

    public static t i(long j8, long j9) {
        if (j8 <= j9) {
            return new t(j8, j8, j9, j9);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static t j(long j8, long j9) {
        if (j8 <= j9) {
            if (1 <= j9) {
                return new t(1L, 1L, j8, j9);
            }
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
    }

    public final int a(long j8, o oVar) {
        if (g() && h(j8)) {
            return (int) j8;
        }
        throw new DateTimeException(c(j8, oVar));
    }

    public final void b(long j8, o oVar) {
        if (!h(j8)) {
            throw new DateTimeException(c(j8, oVar));
        }
    }

    public final long d() {
        return this.f50114d;
    }

    public final long e() {
        return this.f50111a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            return this.f50111a == tVar.f50111a && this.f50112b == tVar.f50112b && this.f50113c == tVar.f50113c && this.f50114d == tVar.f50114d;
        }
        return false;
    }

    public final boolean f() {
        return this.f50111a == this.f50112b && this.f50113c == this.f50114d;
    }

    public final boolean g() {
        return this.f50111a >= -2147483648L && this.f50114d <= 2147483647L;
    }

    public final boolean h(long j8) {
        return j8 >= this.f50111a && j8 <= this.f50114d;
    }

    public final int hashCode() {
        long j8 = this.f50111a;
        long j9 = this.f50112b;
        long j10 = j8 + (j9 << 16) + (j9 >> 48);
        long j11 = this.f50113c;
        long j12 = j10 + (j11 << 32) + (j11 >> 32);
        long j13 = this.f50114d;
        long j14 = j12 + (j13 << 48) + (j13 >> 16);
        return (int) (j14 ^ (j14 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f50111a);
        if (this.f50111a != this.f50112b) {
            sb.append('/');
            sb.append(this.f50112b);
        }
        sb.append(" - ");
        sb.append(this.f50113c);
        if (this.f50113c != this.f50114d) {
            sb.append('/');
            sb.append(this.f50114d);
        }
        return sb.toString();
    }
}
