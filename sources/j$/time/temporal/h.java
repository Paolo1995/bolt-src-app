package j$.time.temporal;

import j$.time.DateTimeException;
import j$.time.format.y;
import java.util.HashMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
abstract class h implements o {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f50096a;

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ h[] f50097b;

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.o
            public final boolean d(l lVar) {
                return lVar.k(a.DAY_OF_YEAR) && lVar.k(a.MONTH_OF_YEAR) && lVar.k(a.YEAR) && h.k(lVar);
            }

            @Override // j$.time.temporal.h, j$.time.temporal.o
            public final t e(l lVar) {
                if (d(lVar)) {
                    long n8 = lVar.n(h.QUARTER_OF_YEAR);
                    if (n8 != 1) {
                        return n8 == 2 ? t.i(1L, 91L) : (n8 == 3 || n8 == 4) ? t.i(1L, 92L) : g();
                    }
                    long n9 = lVar.n(a.YEAR);
                    j$.time.chrono.f.f49977a.getClass();
                    return j$.time.chrono.f.g(n9) ? t.i(1L, 91L) : t.i(1L, 90L);
                }
                throw new s("Unsupported field: DayOfQuarter");
            }

            @Override // j$.time.temporal.o
            public final t g() {
                return t.j(90L, 92L);
            }

            @Override // j$.time.temporal.h, j$.time.temporal.o
            public final l h(HashMap hashMap, l lVar, y yVar) {
                j$.time.g y7;
                long j8;
                a aVar = a.YEAR;
                Long l8 = (Long) hashMap.get(aVar);
                o oVar = h.QUARTER_OF_YEAR;
                Long l9 = (Long) hashMap.get(oVar);
                if (l8 == null || l9 == null) {
                    return null;
                }
                int k8 = aVar.k(l8.longValue());
                long longValue = ((Long) hashMap.get(h.DAY_OF_QUARTER)).longValue();
                h.o(lVar);
                if (yVar == y.LENIENT) {
                    y7 = j$.time.g.y(k8, 1, 1).D(j$.time.a.e(j$.time.a.g(l9.longValue(), 1L), 3L));
                    j8 = j$.time.a.g(longValue, 1L);
                } else {
                    y7 = j$.time.g.y(k8, ((oVar.g().a(l9.longValue(), oVar) - 1) * 3) + 1, 1);
                    if (longValue < 1 || longValue > 90) {
                        (yVar == y.STRICT ? e(y7) : g()).b(longValue, this);
                    }
                    j8 = longValue - 1;
                }
                hashMap.remove(this);
                hashMap.remove(aVar);
                hashMap.remove(oVar);
                return y7.C(j8);
            }

            @Override // j$.time.temporal.o
            public final long i(l lVar) {
                int[] iArr;
                if (d(lVar)) {
                    int e8 = lVar.e(a.DAY_OF_YEAR);
                    int e9 = lVar.e(a.MONTH_OF_YEAR);
                    long n8 = lVar.n(a.YEAR);
                    iArr = h.f50096a;
                    int i8 = (e9 - 1) / 3;
                    j$.time.chrono.f.f49977a.getClass();
                    return e8 - iArr[i8 + (j$.time.chrono.f.g(n8) ? 4 : 0)];
                }
                throw new s("Unsupported field: DayOfQuarter");
            }

            @Override // j$.time.temporal.o
            public final k j(k kVar, long j8) {
                long i8 = i(kVar);
                g().b(j8, this);
                a aVar = a.DAY_OF_YEAR;
                return kVar.d((j8 - i8) + kVar.n(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.o
            public final boolean d(l lVar) {
                return lVar.k(a.MONTH_OF_YEAR) && h.k(lVar);
            }

            @Override // j$.time.temporal.o
            public final t g() {
                return t.i(1L, 4L);
            }

            @Override // j$.time.temporal.o
            public final long i(l lVar) {
                if (d(lVar)) {
                    return (lVar.n(a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new s("Unsupported field: QuarterOfYear");
            }

            @Override // j$.time.temporal.o
            public final k j(k kVar, long j8) {
                long i8 = i(kVar);
                g().b(j8, this);
                a aVar = a.MONTH_OF_YEAR;
                return kVar.d(((j8 - i8) * 3) + kVar.n(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.o
            public final boolean d(l lVar) {
                return lVar.k(a.EPOCH_DAY) && h.k(lVar);
            }

            @Override // j$.time.temporal.h, j$.time.temporal.o
            public final t e(l lVar) {
                if (d(lVar)) {
                    return h.q(j$.time.g.s(lVar));
                }
                throw new s("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.o
            public final t g() {
                return t.j(52L, 53L);
            }

            @Override // j$.time.temporal.h, j$.time.temporal.o
            public final l h(HashMap hashMap, l lVar, y yVar) {
                j$.time.g d8;
                long j8;
                j$.time.g E;
                long j9;
                o oVar = h.WEEK_BASED_YEAR;
                Long l8 = (Long) hashMap.get(oVar);
                a aVar = a.DAY_OF_WEEK;
                Long l9 = (Long) hashMap.get(aVar);
                if (l8 == null || l9 == null) {
                    return null;
                }
                int a8 = oVar.g().a(l8.longValue(), oVar);
                long longValue = ((Long) hashMap.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                h.o(lVar);
                j$.time.g y7 = j$.time.g.y(a8, 1, 4);
                if (yVar == y.LENIENT) {
                    long longValue2 = l9.longValue();
                    if (longValue2 > 7) {
                        j9 = longValue2 - 1;
                        E = y7.E(j9 / 7);
                    } else {
                        j8 = 1;
                        if (longValue2 < 1) {
                            E = y7.E(j$.time.a.g(longValue2, 7L) / 7);
                            j9 = longValue2 + 6;
                        }
                        d8 = y7.E(j$.time.a.g(longValue, j8)).d(longValue2, aVar);
                    }
                    y7 = E;
                    j8 = 1;
                    longValue2 = (j9 % 7) + 1;
                    d8 = y7.E(j$.time.a.g(longValue, j8)).d(longValue2, aVar);
                } else {
                    int k8 = aVar.k(l9.longValue());
                    if (longValue < 1 || longValue > 52) {
                        (yVar == y.STRICT ? h.q(y7) : g()).b(longValue, this);
                    }
                    d8 = y7.E(longValue - 1).d(k8, aVar);
                }
                hashMap.remove(this);
                hashMap.remove(oVar);
                hashMap.remove(aVar);
                return d8;
            }

            @Override // j$.time.temporal.o
            public final long i(l lVar) {
                if (d(lVar)) {
                    return h.r(j$.time.g.s(lVar));
                }
                throw new s("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.o
            public final k j(k kVar, long j8) {
                g().b(j8, this);
                return kVar.i(j$.time.a.g(j8, i(kVar)), b.WEEKS);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.o
            public final boolean d(l lVar) {
                return lVar.k(a.EPOCH_DAY) && h.k(lVar);
            }

            @Override // j$.time.temporal.o
            public final t g() {
                return a.YEAR.g();
            }

            @Override // j$.time.temporal.o
            public final long i(l lVar) {
                int u7;
                if (d(lVar)) {
                    u7 = h.u(j$.time.g.s(lVar));
                    return u7;
                }
                throw new s("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.o
            public final k j(k kVar, long j8) {
                int v7;
                if (d(kVar)) {
                    int a8 = g().a(j8, h.WEEK_BASED_YEAR);
                    j$.time.g s7 = j$.time.g.s(kVar);
                    a aVar = a.DAY_OF_WEEK;
                    int e8 = s7.e(aVar);
                    int r7 = h.r(s7);
                    if (r7 == 53) {
                        v7 = h.v(a8);
                        if (v7 == 52) {
                            r7 = 52;
                        }
                    }
                    j$.time.g y7 = j$.time.g.y(a8, 1, 4);
                    return kVar.g(y7.C(((r7 - 1) * 7) + (e8 - y7.e(aVar))));
                }
                throw new s("Unsupported field: WeekBasedYear");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        f50097b = new h[]{hVar, hVar2, hVar3, hVar4};
        f50096a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, int i8) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(l lVar) {
        if (lVar != null) {
            Object obj = (j$.time.chrono.e) lVar.o(n.f50104b);
            if (obj == null) {
                obj = j$.time.chrono.f.f49977a;
            }
            return ((j$.time.chrono.a) obj).equals(j$.time.chrono.f.f49977a);
        }
        throw new NullPointerException("temporal");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void o(l lVar) {
        if (lVar == null) {
            throw new NullPointerException("temporal");
        }
        Object obj = (j$.time.chrono.e) lVar.o(n.f50104b);
        if (obj == null) {
            obj = j$.time.chrono.f.f49977a;
        }
        if (!((j$.time.chrono.a) obj).equals(j$.time.chrono.f.f49977a)) {
            throw new DateTimeException("Resolve requires IsoChronology");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t q(j$.time.g gVar) {
        return t.i(1L, v(u(gVar)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
        if ((r0 == -3 || (r0 == -2 && r5.x())) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int r(j$.time.g r5) {
        /*
            j$.time.d r0 = r5.u()
            int r0 = r0.ordinal()
            int r1 = r5.v()
            r2 = 1
            int r1 = r1 - r2
            int r0 = 3 - r0
            int r0 = r0 + r1
            int r3 = r0 / 7
            int r3 = r3 * 7
            int r0 = r0 - r3
            r3 = -3
            int r0 = r0 + r3
            if (r0 >= r3) goto L1c
            int r0 = r0 + 7
        L1c:
            if (r1 >= r0) goto L3f
            r0 = 180(0xb4, float:2.52E-43)
            j$.time.g r5 = r5.K(r0)
            r0 = -1
            j$.time.g r5 = r5.F(r0)
            int r5 = u(r5)
            int r5 = v(r5)
            long r0 = (long) r5
            r2 = 1
            j$.time.temporal.t r5 = j$.time.temporal.t.i(r2, r0)
            long r0 = r5.d()
            int r5 = (int) r0
            goto L5b
        L3f:
            int r1 = r1 - r0
            int r1 = r1 / 7
            int r1 = r1 + r2
            r4 = 53
            if (r1 != r4) goto L59
            if (r0 == r3) goto L55
            r3 = -2
            if (r0 != r3) goto L53
            boolean r5 = r5.x()
            if (r5 == 0) goto L53
            goto L55
        L53:
            r5 = 0
            goto L56
        L55:
            r5 = 1
        L56:
            if (r5 != 0) goto L59
            goto L5a
        L59:
            r2 = r1
        L5a:
            r5 = r2
        L5b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.temporal.h.r(j$.time.g):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int u(j$.time.g gVar) {
        int w7 = gVar.w();
        int v7 = gVar.v();
        if (v7 <= 3) {
            return v7 - gVar.u().ordinal() < -2 ? w7 - 1 : w7;
        } else if (v7 >= 363) {
            return ((v7 - 363) - (gVar.x() ? 1 : 0)) - gVar.u().ordinal() >= 0 ? w7 + 1 : w7;
        } else {
            return w7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int v(int i8) {
        j$.time.g y7 = j$.time.g.y(i8, 1, 1);
        if (y7.u() != j$.time.d.THURSDAY) {
            return (y7.u() == j$.time.d.WEDNESDAY && y7.x()) ? 53 : 52;
        }
        return 53;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f50097b.clone();
    }

    public t e(l lVar) {
        return g();
    }

    public /* synthetic */ l h(HashMap hashMap, l lVar, y yVar) {
        return null;
    }

    @Override // j$.time.temporal.o
    public final boolean isDateBased() {
        return true;
    }

    @Override // j$.time.temporal.o
    public final boolean isTimeBased() {
        return false;
    }
}
