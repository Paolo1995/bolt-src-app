package j$.time;

import j$.time.temporal.s;
import j$.time.temporal.t;

/* loaded from: classes2.dex */
public enum m implements j$.time.temporal.l, j$.time.temporal.m {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    

    /* renamed from: a  reason: collision with root package name */
    private static final m[] f50079a = values();

    public static m s(int i8) {
        if (i8 < 1 || i8 > 12) {
            throw new DateTimeException("Invalid value for MonthOfYear: " + i8);
        }
        return f50079a[i8 - 1];
    }

    @Override // j$.time.temporal.l
    public final int e(j$.time.temporal.o oVar) {
        return oVar == j$.time.temporal.a.MONTH_OF_YEAR ? ordinal() + 1 : j$.time.temporal.n.a(this, oVar);
    }

    @Override // j$.time.temporal.l
    public final t h(j$.time.temporal.o oVar) {
        return oVar == j$.time.temporal.a.MONTH_OF_YEAR ? oVar.g() : j$.time.temporal.n.c(this, oVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.k j(j$.time.temporal.k kVar) {
        if (kVar != null) {
            Object obj = (j$.time.chrono.e) kVar.o(j$.time.temporal.n.d());
            if (obj == null) {
                obj = j$.time.chrono.f.f49977a;
            }
            if (((j$.time.chrono.a) obj).equals(j$.time.chrono.f.f49977a)) {
                return kVar.d(ordinal() + 1, j$.time.temporal.a.MONTH_OF_YEAR);
            }
            throw new DateTimeException("Adjustment only supported on ISO date-time");
        }
        throw new NullPointerException("temporal");
    }

    @Override // j$.time.temporal.l
    public final boolean k(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.MONTH_OF_YEAR : oVar != null && oVar.d(this);
    }

    @Override // j$.time.temporal.l
    public final long n(j$.time.temporal.o oVar) {
        if (oVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return ordinal() + 1;
        }
        if (oVar instanceof j$.time.temporal.a) {
            throw new s("Unsupported field: " + oVar);
        }
        return oVar.i(this);
    }

    @Override // j$.time.temporal.l
    public final Object o(j$.time.temporal.q qVar) {
        return qVar == j$.time.temporal.n.d() ? j$.time.chrono.f.f49977a : qVar == j$.time.temporal.n.h() ? j$.time.temporal.b.MONTHS : j$.time.temporal.n.b(this, qVar);
    }

    public final int q(boolean z7) {
        switch (l.f50078a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z7 ? 1 : 0) + 91;
            case 3:
                return (z7 ? 1 : 0) + 152;
            case 4:
                return (z7 ? 1 : 0) + 244;
            case 5:
                return (z7 ? 1 : 0) + 305;
            case 6:
                return 1;
            case 7:
                return (z7 ? 1 : 0) + 60;
            case 8:
                return (z7 ? 1 : 0) + 121;
            case 9:
                return (z7 ? 1 : 0) + 182;
            case 10:
                return (z7 ? 1 : 0) + 213;
            case 11:
                return (z7 ? 1 : 0) + 274;
            default:
                return (z7 ? 1 : 0) + 335;
        }
    }

    public final int r(boolean z7) {
        int i8 = l.f50078a[ordinal()];
        return i8 != 1 ? (i8 == 2 || i8 == 3 || i8 == 4 || i8 == 5) ? 30 : 31 : z7 ? 29 : 28;
    }

    public final m t() {
        return f50079a[((((int) 1) + 12) + ordinal()) % 12];
    }
}
