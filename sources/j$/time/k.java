package j$.time;

import j$.time.temporal.s;
import j$.time.temporal.t;
import java.io.Serializable;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes2.dex */
public final class k implements j$.time.temporal.k, j$.time.temporal.m, Comparable, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final k f50070e;

    /* renamed from: f  reason: collision with root package name */
    public static final k f50071f;

    /* renamed from: g  reason: collision with root package name */
    public static final k f50072g;

    /* renamed from: h  reason: collision with root package name */
    private static final k[] f50073h = new k[24];

    /* renamed from: a  reason: collision with root package name */
    private final byte f50074a;

    /* renamed from: b  reason: collision with root package name */
    private final byte f50075b;

    /* renamed from: c  reason: collision with root package name */
    private final byte f50076c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50077d;

    static {
        int i8 = 0;
        while (true) {
            k[] kVarArr = f50073h;
            if (i8 >= kVarArr.length) {
                k kVar = kVarArr[0];
                f50072g = kVar;
                k kVar2 = kVarArr[12];
                f50070e = kVar;
                f50071f = new k(23, 59, 59, 999999999);
                return;
            }
            kVarArr[i8] = new k(i8, 0, 0, 0);
            i8++;
        }
    }

    private k(int i8, int i9, int i10, int i11) {
        this.f50074a = (byte) i8;
        this.f50075b = (byte) i9;
        this.f50076c = (byte) i10;
        this.f50077d = i11;
    }

    private static k r(int i8, int i9, int i10, int i11) {
        return ((i9 | i10) | i11) == 0 ? f50073h[i8] : new k(i8, i9, i10, i11);
    }

    public static k s(j$.time.temporal.l lVar) {
        if (lVar != null) {
            k kVar = (k) lVar.o(j$.time.temporal.n.f());
            if (kVar != null) {
                return kVar;
            }
            throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + lVar + " of type " + lVar.getClass().getName());
        }
        throw new NullPointerException("temporal");
    }

    private int t(j$.time.temporal.o oVar) {
        switch (j.f50068a[((j$.time.temporal.a) oVar).ordinal()]) {
            case 1:
                return this.f50077d;
            case 2:
                throw new s("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.f50077d / 1000;
            case 4:
                throw new s("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.f50077d / 1000000;
            case 6:
                return (int) (D() / 1000000);
            case 7:
                return this.f50076c;
            case 8:
                return E();
            case 9:
                return this.f50075b;
            case 10:
                return (this.f50074a * 60) + this.f50075b;
            case 11:
                return this.f50074a % 12;
            case 12:
                int i8 = this.f50074a % 12;
                if (i8 % 12 == 0) {
                    return 12;
                }
                return i8;
            case 13:
                return this.f50074a;
            case 14:
                byte b8 = this.f50074a;
                if (b8 == 0) {
                    return 24;
                }
                return b8;
            case 15:
                return this.f50074a / 12;
            default:
                throw new s("Unsupported field: " + oVar);
        }
    }

    public static k w() {
        j$.time.temporal.a.HOUR_OF_DAY.n(0);
        return f50073h[0];
    }

    public static k x(int i8, int i9, int i10, int i11) {
        j$.time.temporal.a.HOUR_OF_DAY.n(i8);
        j$.time.temporal.a.MINUTE_OF_HOUR.n(i9);
        j$.time.temporal.a.SECOND_OF_MINUTE.n(i10);
        j$.time.temporal.a.NANO_OF_SECOND.n(i11);
        return r(i8, i9, i10, i11);
    }

    public static k y(long j8) {
        j$.time.temporal.a.NANO_OF_DAY.n(j8);
        int i8 = (int) (j8 / 3600000000000L);
        long j9 = j8 - (i8 * 3600000000000L);
        int i9 = (int) (j9 / 60000000000L);
        long j10 = j9 - (i9 * 60000000000L);
        int i10 = (int) (j10 / 1000000000);
        return r(i8, i9, i10, (int) (j10 - (i10 * 1000000000)));
    }

    public final k A(long j8) {
        if (j8 == 0) {
            return this;
        }
        int i8 = (this.f50074a * 60) + this.f50075b;
        int i9 = ((((int) (j8 % 1440)) + i8) + 1440) % 1440;
        return i8 == i9 ? this : r(i9 / 60, i9 % 60, this.f50076c, this.f50077d);
    }

    public final k B(long j8) {
        if (j8 == 0) {
            return this;
        }
        long D = D();
        long j9 = (((j8 % 86400000000000L) + D) + 86400000000000L) % 86400000000000L;
        return D == j9 ? this : r((int) (j9 / 3600000000000L), (int) ((j9 / 60000000000L) % 60), (int) ((j9 / 1000000000) % 60), (int) (j9 % 1000000000));
    }

    public final k C(long j8) {
        if (j8 == 0) {
            return this;
        }
        int i8 = (this.f50075b * 60) + (this.f50074a * 3600) + this.f50076c;
        int i9 = ((((int) (j8 % 86400)) + i8) + 86400) % 86400;
        return i8 == i9 ? this : r(i9 / 3600, (i9 / 60) % 60, i9 % 60, this.f50077d);
    }

    public final long D() {
        return (this.f50076c * 1000000000) + (this.f50075b * 60000000000L) + (this.f50074a * 3600000000000L) + this.f50077d;
    }

    public final int E() {
        return (this.f50075b * 60) + (this.f50074a * 3600) + this.f50076c;
    }

    @Override // j$.time.temporal.k
    /* renamed from: F */
    public final k d(long j8, j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
            aVar.n(j8);
            switch (j.f50068a[aVar.ordinal()]) {
                case 1:
                    return G((int) j8);
                case 2:
                    return y(j8);
                case 3:
                    return G(((int) j8) * 1000);
                case 4:
                    return y(j8 * 1000);
                case 5:
                    return G(((int) j8) * 1000000);
                case 6:
                    return y(j8 * 1000000);
                case 7:
                    int i8 = (int) j8;
                    if (this.f50076c == i8) {
                        return this;
                    }
                    j$.time.temporal.a.SECOND_OF_MINUTE.n(i8);
                    return r(this.f50074a, this.f50075b, i8, this.f50077d);
                case 8:
                    return C(j8 - E());
                case 9:
                    int i9 = (int) j8;
                    if (this.f50075b == i9) {
                        return this;
                    }
                    j$.time.temporal.a.MINUTE_OF_HOUR.n(i9);
                    return r(this.f50074a, i9, this.f50076c, this.f50077d);
                case 10:
                    return A(j8 - ((this.f50074a * 60) + this.f50075b));
                case 11:
                    return z(j8 - (this.f50074a % 12));
                case 12:
                    if (j8 == 12) {
                        j8 = 0;
                    }
                    return z(j8 - (this.f50074a % 12));
                case 13:
                    int i10 = (int) j8;
                    if (this.f50074a == i10) {
                        return this;
                    }
                    j$.time.temporal.a.HOUR_OF_DAY.n(i10);
                    return r(i10, this.f50075b, this.f50076c, this.f50077d);
                case 14:
                    if (j8 == 24) {
                        j8 = 0;
                    }
                    int i11 = (int) j8;
                    if (this.f50074a == i11) {
                        return this;
                    }
                    j$.time.temporal.a.HOUR_OF_DAY.n(i11);
                    return r(i11, this.f50075b, this.f50076c, this.f50077d);
                case 15:
                    return z((j8 - (this.f50074a / 12)) * 12);
                default:
                    throw new s("Unsupported field: " + oVar);
            }
        }
        return (k) oVar.j(this, j8);
    }

    public final k G(int i8) {
        if (this.f50077d == i8) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.n(i8);
        return r(this.f50074a, this.f50075b, this.f50076c, i8);
    }

    @Override // j$.time.temporal.l
    public final int e(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? t(oVar) : j$.time.temporal.n.a(this, oVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            return this.f50074a == kVar.f50074a && this.f50075b == kVar.f50075b && this.f50076c == kVar.f50076c && this.f50077d == kVar.f50077d;
        }
        return false;
    }

    @Override // j$.time.temporal.k
    public final j$.time.temporal.k g(g gVar) {
        boolean z7 = gVar instanceof k;
        j$.time.temporal.k kVar = gVar;
        if (!z7) {
            kVar = gVar.j(this);
        }
        return (k) kVar;
    }

    @Override // j$.time.temporal.l
    public final t h(j$.time.temporal.o oVar) {
        return j$.time.temporal.n.c(this, oVar);
    }

    public final int hashCode() {
        long D = D();
        return (int) (D ^ (D >>> 32));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // j$.time.temporal.k
    public final j$.time.temporal.k i(long j8, j$.time.temporal.r rVar) {
        long j9;
        long j10;
        if (rVar instanceof j$.time.temporal.b) {
            switch (j.f50069b[((j$.time.temporal.b) rVar).ordinal()]) {
                case 1:
                    return B(j8);
                case 2:
                    j9 = j8 % 86400000000L;
                    j10 = 1000;
                    j8 = j9 * j10;
                    return B(j8);
                case 3:
                    j9 = j8 % 86400000;
                    j10 = 1000000;
                    j8 = j9 * j10;
                    return B(j8);
                case 4:
                    return C(j8);
                case 5:
                    return A(j8);
                case 6:
                    break;
                case 7:
                    j8 = (j8 % 2) * 12;
                    break;
                default:
                    throw new s("Unsupported unit: " + rVar);
            }
            return z(j8);
        }
        return (k) rVar.d(this, j8);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.k j(j$.time.temporal.k kVar) {
        return kVar.d(D(), j$.time.temporal.a.NANO_OF_DAY);
    }

    @Override // j$.time.temporal.l
    public final boolean k(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar.isTimeBased() : oVar != null && oVar.d(this);
    }

    @Override // j$.time.temporal.l
    public final long n(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.NANO_OF_DAY ? D() : oVar == j$.time.temporal.a.MICRO_OF_DAY ? D() / 1000 : t(oVar) : oVar.i(this);
    }

    @Override // j$.time.temporal.l
    public final Object o(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.n.d() || qVar == j$.time.temporal.n.j() || qVar == j$.time.temporal.n.i() || qVar == j$.time.temporal.n.g()) {
            return null;
        }
        if (qVar == j$.time.temporal.n.f()) {
            return this;
        }
        if (qVar == j$.time.temporal.n.e()) {
            return null;
        }
        return qVar == j$.time.temporal.n.h() ? j$.time.temporal.b.NANOS : qVar.c(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: q */
    public final int compareTo(k kVar) {
        int compare = Integer.compare(this.f50074a, kVar.f50074a);
        if (compare == 0) {
            int compare2 = Integer.compare(this.f50075b, kVar.f50075b);
            if (compare2 == 0) {
                int compare3 = Integer.compare(this.f50076c, kVar.f50076c);
                return compare3 == 0 ? Integer.compare(this.f50077d, kVar.f50077d) : compare3;
            }
            return compare2;
        }
        return compare;
    }

    public final String toString() {
        int i8;
        StringBuilder sb = new StringBuilder(18);
        byte b8 = this.f50074a;
        byte b9 = this.f50075b;
        byte b10 = this.f50076c;
        int i9 = this.f50077d;
        sb.append(b8 < 10 ? "0" : "");
        sb.append((int) b8);
        sb.append(b9 < 10 ? ":0" : ":");
        sb.append((int) b9);
        if (b10 > 0 || i9 > 0) {
            sb.append(b10 >= 10 ? ":" : ":0");
            sb.append((int) b10);
            if (i9 > 0) {
                sb.append('.');
                int i10 = 1000000;
                if (i9 % 1000000 == 0) {
                    i8 = (i9 / 1000000) + 1000;
                } else {
                    if (i9 % 1000 == 0) {
                        i9 /= 1000;
                    } else {
                        i10 = Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
                    }
                    i8 = i9 + i10;
                }
                sb.append(Integer.toString(i8).substring(1));
            }
        }
        return sb.toString();
    }

    public final int u() {
        return this.f50077d;
    }

    public final int v() {
        return this.f50076c;
    }

    public final k z(long j8) {
        return j8 == 0 ? this : r(((((int) (j8 % 24)) + this.f50074a) + 24) % 24, this.f50075b, this.f50076c, this.f50077d);
    }
}
