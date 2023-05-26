package j$.time;

import j$.time.temporal.s;
import j$.time.temporal.t;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class g implements j$.time.temporal.k, j$.time.temporal.m, j$.time.chrono.b, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final g f50061d = y(-999999999, 1, 1);

    /* renamed from: e  reason: collision with root package name */
    public static final g f50062e = y(999999999, 12, 31);

    /* renamed from: a  reason: collision with root package name */
    private final int f50063a;

    /* renamed from: b  reason: collision with root package name */
    private final short f50064b;

    /* renamed from: c  reason: collision with root package name */
    private final short f50065c;

    private g(int i8, int i9, int i10) {
        this.f50063a = i8;
        this.f50064b = (short) i9;
        this.f50065c = (short) i10;
    }

    public static g A(int i8, int i9) {
        long j8 = i8;
        j$.time.temporal.a.YEAR.n(j8);
        j$.time.temporal.a.DAY_OF_YEAR.n(i9);
        j$.time.chrono.f.f49977a.getClass();
        boolean g8 = j$.time.chrono.f.g(j8);
        if (i9 == 366 && !g8) {
            throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + i8 + "' is not a leap year");
        }
        m s7 = m.s(((i9 - 1) / 31) + 1);
        if (i9 > (s7.r(g8) + s7.q(g8)) - 1) {
            s7 = s7.t();
        }
        return new g(i8, s7.ordinal() + 1, (i9 - s7.q(g8)) + 1);
    }

    private static g G(int i8, int i9, int i10) {
        int i11;
        if (i9 != 2) {
            if (i9 == 4 || i9 == 6 || i9 == 9 || i9 == 11) {
                i11 = 30;
            }
            return new g(i8, i9, i10);
        }
        j$.time.chrono.f.f49977a.getClass();
        i11 = j$.time.chrono.f.g((long) i8) ? 29 : 28;
        i10 = Math.min(i10, i11);
        return new g(i8, i9, i10);
    }

    public static g s(j$.time.temporal.l lVar) {
        if (lVar != null) {
            g gVar = (g) lVar.o(j$.time.temporal.n.e());
            if (gVar != null) {
                return gVar;
            }
            throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + lVar + " of type " + lVar.getClass().getName());
        }
        throw new NullPointerException("temporal");
    }

    private int t(j$.time.temporal.o oVar) {
        switch (f.f49982a[((j$.time.temporal.a) oVar).ordinal()]) {
            case 1:
                return this.f50065c;
            case 2:
                return v();
            case 3:
                return ((this.f50065c - 1) / 7) + 1;
            case 4:
                int i8 = this.f50063a;
                return i8 >= 1 ? i8 : 1 - i8;
            case 5:
                return u().q();
            case 6:
                return ((this.f50065c - 1) % 7) + 1;
            case 7:
                return ((v() - 1) % 7) + 1;
            case 8:
                throw new s("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((v() - 1) / 7) + 1;
            case 10:
                return this.f50064b;
            case 11:
                throw new s("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.f50063a;
            case 13:
                return this.f50063a >= 1 ? 1 : 0;
            default:
                throw new s("Unsupported field: " + oVar);
        }
    }

    public static g y(int i8, int i9, int i10) {
        long j8 = i8;
        j$.time.temporal.a.YEAR.n(j8);
        j$.time.temporal.a.MONTH_OF_YEAR.n(i9);
        j$.time.temporal.a.DAY_OF_MONTH.n(i10);
        if (i10 > 28) {
            int i11 = 31;
            if (i9 == 2) {
                j$.time.chrono.f.f49977a.getClass();
                i11 = j$.time.chrono.f.g(j8) ? 29 : 28;
            } else if (i9 == 4 || i9 == 6 || i9 == 9 || i9 == 11) {
                i11 = 30;
            }
            if (i10 > i11) {
                if (i10 == 29) {
                    throw new DateTimeException("Invalid date 'February 29' as '" + i8 + "' is not a leap year");
                }
                StringBuilder a8 = b.a("Invalid date '");
                a8.append(m.s(i9).name());
                a8.append(" ");
                a8.append(i10);
                a8.append("'");
                throw new DateTimeException(a8.toString());
            }
        }
        return new g(i8, i9, i10);
    }

    public static g z(long j8) {
        long j9;
        long j10 = (j8 + 719528) - 60;
        if (j10 < 0) {
            long j11 = ((j10 + 1) / 146097) - 1;
            j9 = j11 * 400;
            j10 += (-j11) * 146097;
        } else {
            j9 = 0;
        }
        long j12 = ((j10 * 400) + 591) / 146097;
        long j13 = j10 - ((j12 / 400) + (((j12 / 4) + (j12 * 365)) - (j12 / 100)));
        if (j13 < 0) {
            j12--;
            j13 = j10 - ((j12 / 400) + (((j12 / 4) + (365 * j12)) - (j12 / 100)));
        }
        int i8 = (int) j13;
        int i9 = ((i8 * 5) + 2) / 153;
        return new g(j$.time.temporal.a.YEAR.k(j12 + j9 + (i9 / 10)), ((i9 + 2) % 12) + 1, (i8 - (((i9 * 306) + 5) / 10)) + 1);
    }

    @Override // j$.time.temporal.k
    /* renamed from: B */
    public final g i(long j8, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.b) {
            switch (f.f49983b[((j$.time.temporal.b) rVar).ordinal()]) {
                case 1:
                    return C(j8);
                case 2:
                    return E(j8);
                case 3:
                    return D(j8);
                case 4:
                    return F(j8);
                case 5:
                    return F(a.e(j8, 10L));
                case 6:
                    return F(a.e(j8, 100L));
                case 7:
                    return F(a.e(j8, 1000L));
                case 8:
                    j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                    return d(a.c(n(aVar), j8), aVar);
                default:
                    throw new s("Unsupported unit: " + rVar);
            }
        }
        return (g) rVar.d(this, j8);
    }

    public final g C(long j8) {
        return j8 == 0 ? this : z(a.c(H(), j8));
    }

    public final g D(long j8) {
        if (j8 == 0) {
            return this;
        }
        long j9 = (this.f50063a * 12) + (this.f50064b - 1) + j8;
        return G(j$.time.temporal.a.YEAR.k(a.f(j9, 12L)), ((int) a.d(j9, 12L)) + 1, this.f50065c);
    }

    public final g E(long j8) {
        return C(a.e(j8, 7L));
    }

    public final g F(long j8) {
        return j8 == 0 ? this : G(j$.time.temporal.a.YEAR.k(this.f50063a + j8), this.f50064b, this.f50065c);
    }

    public final long H() {
        long j8;
        long j9 = this.f50063a;
        long j10 = this.f50064b;
        long j11 = (365 * j9) + 0;
        if (j9 >= 0) {
            j8 = ((j9 + 399) / 400) + (((3 + j9) / 4) - ((99 + j9) / 100)) + j11;
        } else {
            j8 = j11 - ((j9 / (-400)) + ((j9 / (-4)) - (j9 / (-100))));
        }
        long j12 = (((367 * j10) - 362) / 12) + j8 + (this.f50065c - 1);
        if (j10 > 2) {
            j12--;
            if (!x()) {
                j12--;
            }
        }
        return j12 - 719528;
    }

    @Override // j$.time.temporal.k
    /* renamed from: I */
    public final g d(long j8, j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
            aVar.n(j8);
            switch (f.f49982a[aVar.ordinal()]) {
                case 1:
                    int i8 = (int) j8;
                    return this.f50065c == i8 ? this : y(this.f50063a, this.f50064b, i8);
                case 2:
                    return K((int) j8);
                case 3:
                    return E(j8 - n(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
                case 4:
                    if (this.f50063a < 1) {
                        j8 = 1 - j8;
                    }
                    return L((int) j8);
                case 5:
                    return C(j8 - u().q());
                case 6:
                    return C(j8 - n(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 7:
                    return C(j8 - n(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 8:
                    return z(j8);
                case 9:
                    return E(j8 - n(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
                case 10:
                    int i9 = (int) j8;
                    if (this.f50064b == i9) {
                        return this;
                    }
                    j$.time.temporal.a.MONTH_OF_YEAR.n(i9);
                    return G(this.f50063a, i9, this.f50065c);
                case 11:
                    return D(j8 - (((this.f50063a * 12) + this.f50064b) - 1));
                case 12:
                    return L((int) j8);
                case 13:
                    return n(j$.time.temporal.a.ERA) == j8 ? this : L(1 - this.f50063a);
                default:
                    throw new s("Unsupported field: " + oVar);
            }
        }
        return (g) oVar.j(this, j8);
    }

    @Override // j$.time.temporal.k
    /* renamed from: J */
    public final g g(j$.time.temporal.m mVar) {
        return mVar instanceof g ? (g) mVar : (g) mVar.j(this);
    }

    public final g K(int i8) {
        return v() == i8 ? this : A(this.f50063a, i8);
    }

    public final g L(int i8) {
        if (this.f50063a == i8) {
            return this;
        }
        j$.time.temporal.a.YEAR.n(i8);
        return G(i8, this.f50064b, this.f50065c);
    }

    @Override // j$.time.temporal.l
    public final int e(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? t(oVar) : j$.time.temporal.n.a(this, oVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && r((g) obj) == 0;
    }

    @Override // j$.time.temporal.l
    public final t h(j$.time.temporal.o oVar) {
        int i8;
        if (oVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
            if (!aVar.isDateBased()) {
                throw new s("Unsupported field: " + oVar);
            }
            int i9 = f.f49982a[aVar.ordinal()];
            if (i9 == 1) {
                short s7 = this.f50064b;
                i8 = s7 != 2 ? (s7 == 4 || s7 == 6 || s7 == 9 || s7 == 11) ? 30 : 31 : x() ? 29 : 28;
            } else if (i9 != 2) {
                if (i9 == 3) {
                    return t.i(1L, (m.s(this.f50064b) != m.FEBRUARY || x()) ? 5L : 4L);
                } else if (i9 != 4) {
                    return oVar.g();
                } else {
                    return t.i(1L, this.f50063a <= 0 ? 1000000000L : 999999999L);
                }
            } else {
                i8 = x() ? 366 : 365;
            }
            return t.i(1L, i8);
        }
        return oVar.e(this);
    }

    public final int hashCode() {
        int i8 = this.f50063a;
        return (((i8 << 11) + (this.f50064b << 6)) + this.f50065c) ^ (i8 & (-2048));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.k j(j$.time.temporal.k kVar) {
        return kVar.d(H(), j$.time.temporal.a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.l
    public final boolean k(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar.isDateBased() : oVar != null && oVar.d(this);
    }

    @Override // j$.time.temporal.l
    public final long n(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.EPOCH_DAY ? H() : oVar == j$.time.temporal.a.PROLEPTIC_MONTH ? ((this.f50063a * 12) + this.f50064b) - 1 : t(oVar) : oVar.i(this);
    }

    @Override // j$.time.temporal.l
    public final Object o(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.n.e()) {
            return this;
        }
        if (qVar == j$.time.temporal.n.j() || qVar == j$.time.temporal.n.i() || qVar == j$.time.temporal.n.g() || qVar == j$.time.temporal.n.f()) {
            return null;
        }
        return qVar == j$.time.temporal.n.d() ? j$.time.chrono.f.f49977a : qVar == j$.time.temporal.n.h() ? j$.time.temporal.b.DAYS : qVar.c(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: q */
    public final int compareTo(j$.time.chrono.b bVar) {
        if (bVar instanceof g) {
            return r((g) bVar);
        }
        int compare = Long.compare(H(), ((g) bVar).H());
        if (compare == 0) {
            j$.time.chrono.f.f49977a.getClass();
            return 0;
        }
        return compare;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int r(g gVar) {
        int i8 = this.f50063a - gVar.f50063a;
        if (i8 == 0) {
            int i9 = this.f50064b - gVar.f50064b;
            return i9 == 0 ? this.f50065c - gVar.f50065c : i9;
        }
        return i8;
    }

    public final String toString() {
        int i8;
        int i9 = this.f50063a;
        short s7 = this.f50064b;
        short s8 = this.f50065c;
        int abs = Math.abs(i9);
        StringBuilder sb = new StringBuilder(10);
        if (abs < 1000) {
            if (i9 < 0) {
                sb.append(i9 - 10000);
                i8 = 1;
            } else {
                sb.append(i9 + 10000);
                i8 = 0;
            }
            sb.deleteCharAt(i8);
        } else {
            if (i9 > 9999) {
                sb.append('+');
            }
            sb.append(i9);
        }
        sb.append(s7 < 10 ? "-0" : "-");
        sb.append((int) s7);
        sb.append(s8 >= 10 ? "-" : "-0");
        sb.append((int) s8);
        return sb.toString();
    }

    public final d u() {
        return d.r(((int) a.d(H() + 3, 7L)) + 1);
    }

    public final int v() {
        return (m.s(this.f50064b).q(x()) + this.f50065c) - 1;
    }

    public final int w() {
        return this.f50063a;
    }

    public final boolean x() {
        j$.time.chrono.f.f49977a.getClass();
        return j$.time.chrono.f.g(this.f50063a);
    }
}
