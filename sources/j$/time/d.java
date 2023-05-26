package j$.time;

import j$.time.temporal.s;
import j$.time.temporal.t;

/* loaded from: classes2.dex */
public enum d implements j$.time.temporal.l, j$.time.temporal.m {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    

    /* renamed from: a  reason: collision with root package name */
    private static final d[] f49978a = values();

    public static d r(int i8) {
        if (i8 < 1 || i8 > 7) {
            throw new DateTimeException("Invalid value for DayOfWeek: " + i8);
        }
        return f49978a[i8 - 1];
    }

    @Override // j$.time.temporal.l
    public final int e(j$.time.temporal.o oVar) {
        return oVar == j$.time.temporal.a.DAY_OF_WEEK ? q() : j$.time.temporal.n.a(this, oVar);
    }

    @Override // j$.time.temporal.l
    public final t h(j$.time.temporal.o oVar) {
        return oVar == j$.time.temporal.a.DAY_OF_WEEK ? oVar.g() : j$.time.temporal.n.c(this, oVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.k j(j$.time.temporal.k kVar) {
        return kVar.d(q(), j$.time.temporal.a.DAY_OF_WEEK);
    }

    @Override // j$.time.temporal.l
    public final boolean k(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.DAY_OF_WEEK : oVar != null && oVar.d(this);
    }

    @Override // j$.time.temporal.l
    public final long n(j$.time.temporal.o oVar) {
        if (oVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return q();
        }
        if (oVar instanceof j$.time.temporal.a) {
            throw new s("Unsupported field: " + oVar);
        }
        return oVar.i(this);
    }

    @Override // j$.time.temporal.l
    public final Object o(j$.time.temporal.q qVar) {
        return qVar == j$.time.temporal.n.h() ? j$.time.temporal.b.DAYS : j$.time.temporal.n.b(this, qVar);
    }

    public final int q() {
        return ordinal() + 1;
    }
}
