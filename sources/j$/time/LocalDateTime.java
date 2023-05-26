package j$.time;

import j$.time.chrono.ChronoLocalDateTime;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.t;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class LocalDateTime implements j$.time.temporal.k, j$.time.temporal.m, ChronoLocalDateTime<g>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final g f49961a;

    /* renamed from: b  reason: collision with root package name */
    private final k f49962b;
    public static final LocalDateTime MIN = z(g.f50061d, k.f50070e);
    public static final LocalDateTime MAX = z(g.f50062e, k.f50071f);

    private LocalDateTime(g gVar, k kVar) {
        this.f49961a = gVar;
        this.f49962b = kVar;
    }

    public static LocalDateTime A(long j8, int i8, ZoneOffset zoneOffset) {
        long s7;
        if (zoneOffset != null) {
            long j9 = i8;
            j$.time.temporal.a.NANO_OF_SECOND.n(j9);
            return new LocalDateTime(g.z(a.f(j8 + zoneOffset.s(), 86400L)), k.y((((int) a.d(s7, 86400L)) * 1000000000) + j9));
        }
        throw new NullPointerException("offset");
    }

    private LocalDateTime E(g gVar, long j8, long j9, long j10, long j11) {
        k y7;
        g C;
        if ((j8 | j9 | j10 | j11) == 0) {
            y7 = this.f49962b;
            C = gVar;
        } else {
            long j12 = 1;
            long D = this.f49962b.D();
            long j13 = ((((j8 % 24) * 3600000000000L) + ((j9 % 1440) * 60000000000L) + ((j10 % 86400) * 1000000000) + (j11 % 86400000000000L)) * j12) + D;
            long f8 = a.f(j13, 86400000000000L) + (((j8 / 24) + (j9 / 1440) + (j10 / 86400) + (j11 / 86400000000000L)) * j12);
            long d8 = a.d(j13, 86400000000000L);
            y7 = d8 == D ? this.f49962b : k.y(d8);
            C = gVar.C(f8);
        }
        return K(C, y7);
    }

    private LocalDateTime K(g gVar, k kVar) {
        return (this.f49961a == gVar && this.f49962b == kVar) ? this : new LocalDateTime(gVar, kVar);
    }

    public static LocalDateTime ofInstant(Instant instant, ZoneId zoneId) {
        if (instant != null) {
            if (zoneId != null) {
                return A(instant.s(), instant.t(), zoneId.getRules().d(instant));
            }
            throw new NullPointerException("zone");
        }
        throw new NullPointerException("instant");
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.f49985h;
        if (dateTimeFormatter != null) {
            return (LocalDateTime) dateTimeFormatter.f(charSequence, new h(0));
        }
        throw new NullPointerException("formatter");
    }

    private int q(LocalDateTime localDateTime) {
        int r7 = this.f49961a.r(localDateTime.f49961a);
        return r7 == 0 ? this.f49962b.compareTo(localDateTime.f49962b) : r7;
    }

    public static LocalDateTime r(j$.time.temporal.l lVar) {
        if (lVar instanceof LocalDateTime) {
            return (LocalDateTime) lVar;
        }
        if (lVar instanceof ZonedDateTime) {
            return ((ZonedDateTime) lVar).v();
        }
        if (lVar instanceof OffsetDateTime) {
            return ((OffsetDateTime) lVar).toLocalDateTime();
        }
        try {
            return new LocalDateTime(g.s(lVar), k.s(lVar));
        } catch (DateTimeException e8) {
            throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + lVar + " of type " + lVar.getClass().getName(), e8);
        }
    }

    public static LocalDateTime x(int i8) {
        return new LocalDateTime(g.y(i8, 12, 31), k.w());
    }

    public static LocalDateTime y(int i8, int i9, int i10, int i11, int i12, int i13) {
        return new LocalDateTime(g.y(i8, i9, i10), k.x(i11, i12, i13, 0));
    }

    public static LocalDateTime z(g gVar, k kVar) {
        if (gVar != null) {
            if (kVar != null) {
                return new LocalDateTime(gVar, kVar);
            }
            throw new NullPointerException("time");
        }
        throw new NullPointerException("date");
    }

    @Override // j$.time.temporal.k
    /* renamed from: B */
    public final LocalDateTime i(long j8, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.b) {
            switch (i.f50067a[((j$.time.temporal.b) rVar).ordinal()]) {
                case 1:
                    return E(this.f49961a, 0L, 0L, 0L, j8);
                case 2:
                    LocalDateTime C = C(j8 / 86400000000L);
                    return C.E(C.f49961a, 0L, 0L, 0L, (j8 % 86400000000L) * 1000);
                case 3:
                    LocalDateTime C2 = C(j8 / 86400000);
                    return C2.E(C2.f49961a, 0L, 0L, 0L, (j8 % 86400000) * 1000000);
                case 4:
                    return D(j8);
                case 5:
                    return E(this.f49961a, 0L, j8, 0L, 0L);
                case 6:
                    return E(this.f49961a, j8, 0L, 0L, 0L);
                case 7:
                    LocalDateTime C3 = C(j8 / 256);
                    return C3.E(C3.f49961a, (j8 % 256) * 12, 0L, 0L, 0L);
                default:
                    return K(this.f49961a.i(j8, rVar), this.f49962b);
            }
        }
        return (LocalDateTime) rVar.d(this, j8);
    }

    public final LocalDateTime C(long j8) {
        return K(this.f49961a.C(j8), this.f49962b);
    }

    public final LocalDateTime D(long j8) {
        return E(this.f49961a, 0L, 0L, j8, 0L);
    }

    public final long F(ZoneOffset zoneOffset) {
        if (zoneOffset != null) {
            return ((this.f49961a.H() * 86400) + this.f49962b.E()) - zoneOffset.s();
        }
        throw new NullPointerException("offset");
    }

    public final Instant G(ZoneOffset zoneOffset) {
        return Instant.ofEpochSecond(F(zoneOffset), this.f49962b.u());
    }

    public final g H() {
        return this.f49961a;
    }

    @Override // j$.time.temporal.k
    /* renamed from: I */
    public final LocalDateTime d(long j8, j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).isTimeBased() ? K(this.f49961a, this.f49962b.d(j8, oVar)) : K(this.f49961a.d(j8, oVar), this.f49962b) : (LocalDateTime) oVar.j(this, j8);
    }

    @Override // j$.time.temporal.k
    /* renamed from: J */
    public final LocalDateTime g(g gVar) {
        return K(gVar, this.f49962b);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final k a() {
        return this.f49962b;
    }

    public ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.s(this, zoneId, null);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final j$.time.chrono.e b() {
        this.f49961a.getClass();
        return j$.time.chrono.f.f49977a;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    public int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return q((LocalDateTime) chronoLocalDateTime);
        }
        int compareTo = this.f49961a.compareTo(chronoLocalDateTime.l());
        if (compareTo == 0) {
            int compareTo2 = this.f49962b.compareTo(chronoLocalDateTime.a());
            if (compareTo2 == 0) {
                j$.time.chrono.e b8 = b();
                j$.time.chrono.e b9 = chronoLocalDateTime.b();
                ((j$.time.chrono.a) b8).getClass();
                b9.getClass();
                return 0;
            }
            return compareTo2;
        }
        return compareTo;
    }

    @Override // j$.time.temporal.l
    public final int e(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).isTimeBased() ? this.f49962b.e(oVar) : this.f49961a.e(oVar) : j$.time.temporal.n.a(this, oVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            return this.f49961a.equals(localDateTime.f49961a) && this.f49962b.equals(localDateTime.f49962b);
        }
        return false;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter != null) {
            return dateTimeFormatter.a(this);
        }
        throw new NullPointerException("formatter");
    }

    @Override // j$.time.temporal.l
    public final t h(j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            if (((j$.time.temporal.a) oVar).isTimeBased()) {
                k kVar = this.f49962b;
                kVar.getClass();
                return j$.time.temporal.n.c(kVar, oVar);
            }
            return this.f49961a.h(oVar);
        }
        return oVar.e(this);
    }

    public int hashCode() {
        return this.f49961a.hashCode() ^ this.f49962b.hashCode();
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.k j(j$.time.temporal.k kVar) {
        return kVar.d(this.f49961a.H(), j$.time.temporal.a.EPOCH_DAY).d(this.f49962b.D(), j$.time.temporal.a.NANO_OF_DAY);
    }

    @Override // j$.time.temporal.l
    public final boolean k(j$.time.temporal.o oVar) {
        if (!(oVar instanceof j$.time.temporal.a)) {
            return oVar != null && oVar.d(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
        return aVar.isDateBased() || aVar.isTimeBased();
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final g l() {
        return this.f49961a;
    }

    @Override // j$.time.temporal.l
    public final long n(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) oVar).isTimeBased() ? this.f49962b.n(oVar) : this.f49961a.n(oVar) : oVar.i(this);
    }

    @Override // j$.time.temporal.l
    public final Object o(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.n.e()) {
            return this.f49961a;
        }
        if (qVar == j$.time.temporal.n.j() || qVar == j$.time.temporal.n.i() || qVar == j$.time.temporal.n.g()) {
            return null;
        }
        return qVar == j$.time.temporal.n.f() ? this.f49962b : qVar == j$.time.temporal.n.d() ? b() : qVar == j$.time.temporal.n.h() ? j$.time.temporal.b.NANOS : qVar.c(this);
    }

    public final int s() {
        return this.f49962b.u();
    }

    public final int t() {
        return this.f49962b.v();
    }

    public String toString() {
        return this.f49961a.toString() + 'T' + this.f49962b.toString();
    }

    public final int u() {
        return this.f49961a.w();
    }

    public final boolean v(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return q(localDateTime) > 0;
        }
        int i8 = (this.f49961a.H() > localDateTime.f49961a.H() ? 1 : (this.f49961a.H() == localDateTime.f49961a.H() ? 0 : -1));
        if (i8 <= 0) {
            return i8 == 0 && this.f49962b.D() > localDateTime.f49962b.D();
        }
        return true;
    }

    public final boolean w(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return q(localDateTime) < 0;
        }
        int i8 = (this.f49961a.H() > localDateTime.f49961a.H() ? 1 : (this.f49961a.H() == localDateTime.f49961a.H() ? 0 : -1));
        if (i8 >= 0) {
            return i8 == 0 && this.f49962b.D() < localDateTime.f49962b.D();
        }
        return true;
    }
}
