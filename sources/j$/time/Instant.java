package j$.time;

import j$.time.format.DateTimeFormatter;
import j$.time.temporal.s;
import j$.time.temporal.t;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class Instant implements j$.time.temporal.k, j$.time.temporal.m, Comparable<Instant>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final long f49959a;

    /* renamed from: b  reason: collision with root package name */
    private final int f49960b;
    public static final Instant EPOCH = new Instant(0, 0);
    public static final Instant MIN = ofEpochSecond(-31557014167219200L, 0);
    public static final Instant MAX = ofEpochSecond(31556889864403199L, 999999999);

    private Instant(long j8, int i8) {
        this.f49959a = j8;
        this.f49960b = i8;
    }

    public static Instant ofEpochMilli(long j8) {
        return q(a.f(j8, 1000L), ((int) a.d(j8, 1000L)) * 1000000);
    }

    public static Instant ofEpochSecond(long j8, long j9) {
        return q(a.c(j8, a.f(j9, 1000000000L)), (int) a.d(j9, 1000000000L));
    }

    private static Instant q(long j8, int i8) {
        if ((i8 | j8) == 0) {
            return EPOCH;
        }
        if (j8 < -31557014167219200L || j8 > 31556889864403199L) {
            throw new DateTimeException("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j8, i8);
    }

    public static Instant r(j$.time.temporal.l lVar) {
        if (lVar instanceof Instant) {
            return (Instant) lVar;
        }
        if (lVar != null) {
            try {
                return ofEpochSecond(lVar.n(j$.time.temporal.a.INSTANT_SECONDS), lVar.e(j$.time.temporal.a.NANO_OF_SECOND));
            } catch (DateTimeException e8) {
                throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + lVar + " of type " + lVar.getClass().getName(), e8);
            }
        }
        throw new NullPointerException("temporal");
    }

    public static Instant u(long j8) {
        return q(j8, 0);
    }

    private Instant v(long j8, long j9) {
        if ((j8 | j9) == 0) {
            return this;
        }
        return ofEpochSecond(a.c(a.c(this.f49959a, j8), j9 / 1000000000), this.f49960b + (j9 % 1000000000));
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.s(this, zoneOffset);
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant instant) {
        int compare = Long.compare(this.f49959a, instant.f49959a);
        return compare != 0 ? compare : this.f49960b - instant.f49960b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
        if (r4 != r2.f49960b) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r4 != r2.f49960b) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
        r0 = r2.f49959a;
     */
    @Override // j$.time.temporal.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final j$.time.temporal.k d(long r3, j$.time.temporal.o r5) {
        /*
            r2 = this;
            boolean r0 = r5 instanceof j$.time.temporal.a
            if (r0 == 0) goto L68
            r0 = r5
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            r0.n(r3)
            int[] r1 = j$.time.e.f49980a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L57
            r1 = 2
            if (r0 == r1) goto L4d
            r1 = 3
            if (r0 == r1) goto L42
            r1 = 4
            if (r0 != r1) goto L2b
            long r0 = r2.f49959a
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 == 0) goto L66
            int r5 = r2.f49960b
            j$.time.Instant r3 = q(r3, r5)
            goto L6e
        L2b:
            j$.time.temporal.s r3 = new j$.time.temporal.s
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Unsupported field: "
            r4.append(r0)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L42:
            int r4 = (int) r3
            r3 = 1000000(0xf4240, float:1.401298E-39)
            int r4 = r4 * r3
            int r3 = r2.f49960b
            if (r4 == r3) goto L66
            goto L54
        L4d:
            int r4 = (int) r3
            int r4 = r4 * 1000
            int r3 = r2.f49960b
            if (r4 == r3) goto L66
        L54:
            long r0 = r2.f49959a
            goto L61
        L57:
            int r5 = r2.f49960b
            long r0 = (long) r5
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 == 0) goto L66
            long r0 = r2.f49959a
            int r4 = (int) r3
        L61:
            j$.time.Instant r3 = q(r0, r4)
            goto L6e
        L66:
            r3 = r2
            goto L6e
        L68:
            j$.time.temporal.k r3 = r5.j(r2, r3)
            j$.time.Instant r3 = (j$.time.Instant) r3
        L6e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.Instant.d(long, j$.time.temporal.o):j$.time.temporal.k");
    }

    @Override // j$.time.temporal.l
    public final int e(j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            int i8 = e.f49980a[((j$.time.temporal.a) oVar).ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4) {
                            j$.time.temporal.a.INSTANT_SECONDS.k(this.f49959a);
                        }
                        throw new s("Unsupported field: " + oVar);
                    }
                    return this.f49960b / 1000000;
                }
                return this.f49960b / 1000;
            }
            return this.f49960b;
        }
        return j$.time.temporal.n.c(this, oVar).a(oVar.i(this), oVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            return this.f49959a == instant.f49959a && this.f49960b == instant.f49960b;
        }
        return false;
    }

    @Override // j$.time.temporal.k
    public final j$.time.temporal.k g(g gVar) {
        return (Instant) gVar.j(this);
    }

    @Override // j$.time.temporal.l
    public final t h(j$.time.temporal.o oVar) {
        return j$.time.temporal.n.c(this, oVar);
    }

    public int hashCode() {
        long j8 = this.f49959a;
        return (this.f49960b * 51) + ((int) (j8 ^ (j8 >>> 32)));
    }

    @Override // j$.time.temporal.k
    public final j$.time.temporal.k i(long j8, j$.time.temporal.r rVar) {
        long j9;
        if (rVar instanceof j$.time.temporal.b) {
            switch (e.f49981b[((j$.time.temporal.b) rVar).ordinal()]) {
                case 1:
                    return v(0L, j8);
                case 2:
                    return v(j8 / 1000000, (j8 % 1000000) * 1000);
                case 3:
                    return v(j8 / 1000, (j8 % 1000) * 1000000);
                case 4:
                    return w(j8);
                case 5:
                    j9 = 60;
                    j8 = a.e(j8, j9);
                    return w(j8);
                case 6:
                    j9 = 3600;
                    j8 = a.e(j8, j9);
                    return w(j8);
                case 7:
                    j9 = 43200;
                    j8 = a.e(j8, j9);
                    return w(j8);
                case 8:
                    j9 = 86400;
                    j8 = a.e(j8, j9);
                    return w(j8);
                default:
                    throw new s("Unsupported unit: " + rVar);
            }
        }
        return (Instant) rVar.d(this, j8);
    }

    public boolean isAfter(Instant instant) {
        return compareTo(instant) > 0;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.k j(j$.time.temporal.k kVar) {
        return kVar.d(this.f49959a, j$.time.temporal.a.INSTANT_SECONDS).d(this.f49960b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    @Override // j$.time.temporal.l
    public final boolean k(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.INSTANT_SECONDS || oVar == j$.time.temporal.a.NANO_OF_SECOND || oVar == j$.time.temporal.a.MICRO_OF_SECOND || oVar == j$.time.temporal.a.MILLI_OF_SECOND : oVar != null && oVar.d(this);
    }

    @Override // j$.time.temporal.l
    public final long n(j$.time.temporal.o oVar) {
        int i8;
        if (oVar instanceof j$.time.temporal.a) {
            int i9 = e.f49980a[((j$.time.temporal.a) oVar).ordinal()];
            if (i9 == 1) {
                i8 = this.f49960b;
            } else if (i9 == 2) {
                i8 = this.f49960b / 1000;
            } else if (i9 != 3) {
                if (i9 == 4) {
                    return this.f49959a;
                }
                throw new s("Unsupported field: " + oVar);
            } else {
                i8 = this.f49960b / 1000000;
            }
            return i8;
        }
        return oVar.i(this);
    }

    @Override // j$.time.temporal.l
    public final Object o(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.n.h()) {
            return j$.time.temporal.b.NANOS;
        }
        if (qVar == j$.time.temporal.n.d() || qVar == j$.time.temporal.n.j() || qVar == j$.time.temporal.n.i() || qVar == j$.time.temporal.n.g() || qVar == j$.time.temporal.n.e() || qVar == j$.time.temporal.n.f()) {
            return null;
        }
        return qVar.c(this);
    }

    public final long s() {
        return this.f49959a;
    }

    public final int t() {
        return this.f49960b;
    }

    public long toEpochMilli() {
        long e8;
        int i8;
        long j8 = this.f49959a;
        if (j8 >= 0 || this.f49960b <= 0) {
            e8 = a.e(j8, 1000L);
            i8 = this.f49960b / 1000000;
        } else {
            e8 = a.e(j8 + 1, 1000L);
            i8 = (this.f49960b / 1000000) - 1000;
        }
        return a.c(e8, i8);
    }

    public String toString() {
        return DateTimeFormatter.f49987j.a(this);
    }

    public final Instant w(long j8) {
        return v(j8, 0L);
    }
}
