package j$.time;

import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.temporal.s;
import j$.time.temporal.t;
import j$.time.zone.ZoneRules;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public final class ZonedDateTime implements j$.time.temporal.k, ChronoZonedDateTime<g>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final LocalDateTime f49972a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset f49973b;

    /* renamed from: c  reason: collision with root package name */
    private final ZoneId f49974c;

    private ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.f49972a = localDateTime;
        this.f49973b = zoneOffset;
        this.f49974c = zoneId;
    }

    private static ZonedDateTime q(long j8, int i8, ZoneId zoneId) {
        ZoneOffset d8 = zoneId.getRules().d(Instant.ofEpochSecond(j8, i8));
        return new ZonedDateTime(LocalDateTime.A(j8, i8, d8), zoneId, d8);
    }

    public static ZonedDateTime r(Instant instant, ZoneId zoneId) {
        if (instant != null) {
            if (zoneId != null) {
                return q(instant.s(), instant.t(), zoneId);
            }
            throw new NullPointerException("zone");
        }
        throw new NullPointerException("instant");
    }

    public static ZonedDateTime s(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        if (localDateTime != null) {
            if (zoneId != null) {
                if (zoneId instanceof ZoneOffset) {
                    return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
                }
                ZoneRules rules = zoneId.getRules();
                List g8 = rules.g(localDateTime);
                if (g8.size() == 1) {
                    zoneOffset = (ZoneOffset) g8.get(0);
                } else if (g8.size() == 0) {
                    j$.time.zone.a f8 = rules.f(localDateTime);
                    localDateTime = localDateTime.D(f8.g().e());
                    zoneOffset = f8.h();
                } else if ((zoneOffset == null || !g8.contains(zoneOffset)) && (zoneOffset = (ZoneOffset) g8.get(0)) == null) {
                    throw new NullPointerException("offset");
                }
                return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
            }
            throw new NullPointerException("zone");
        }
        throw new NullPointerException("localDateTime");
    }

    private ZonedDateTime t(ZoneOffset zoneOffset) {
        return (zoneOffset.equals(this.f49973b) || !this.f49974c.getRules().g(this.f49972a).contains(zoneOffset)) ? this : new ZonedDateTime(this.f49972a, this.f49974c, zoneOffset);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final k a() {
        return this.f49972a.a();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final j$.time.chrono.e b() {
        u().getClass();
        return j$.time.chrono.f.f49977a;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset c() {
        return this.f49973b;
    }

    @Override // j$.time.temporal.k
    public final j$.time.temporal.k d(long j8, j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
            int i8 = r.f50089a[aVar.ordinal()];
            return i8 != 1 ? i8 != 2 ? s(this.f49972a.d(j8, oVar), this.f49974c, this.f49973b) : t(ZoneOffset.u(aVar.k(j8))) : q(j8, this.f49972a.s(), this.f49974c);
        }
        return (ZonedDateTime) oVar.j(this, j8);
    }

    @Override // j$.time.temporal.l
    public final int e(j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            int i8 = r.f50089a[((j$.time.temporal.a) oVar).ordinal()];
            if (i8 != 1) {
                return i8 != 2 ? this.f49972a.e(oVar) : this.f49973b.s();
            }
            throw new s("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        }
        return j$.time.chrono.c.a(this, oVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            return this.f49972a.equals(zonedDateTime.f49972a) && this.f49973b.equals(zonedDateTime.f49973b) && this.f49974c.equals(zonedDateTime.f49974c);
        }
        return false;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final LocalDateTime f() {
        return this.f49972a;
    }

    @Override // j$.time.temporal.k
    public final j$.time.temporal.k g(g gVar) {
        return s(LocalDateTime.z(gVar, this.f49972a.a()), this.f49974c, this.f49973b);
    }

    @Override // j$.time.temporal.l
    public final t h(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? (oVar == j$.time.temporal.a.INSTANT_SECONDS || oVar == j$.time.temporal.a.OFFSET_SECONDS) ? oVar.g() : this.f49972a.h(oVar) : oVar.e(this);
    }

    public final int hashCode() {
        return (this.f49972a.hashCode() ^ this.f49973b.hashCode()) ^ Integer.rotateLeft(this.f49974c.hashCode(), 3);
    }

    @Override // j$.time.temporal.k
    public final j$.time.temporal.k i(long j8, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.b) {
            if (rVar.isDateBased()) {
                return s(this.f49972a.i(j8, rVar), this.f49974c, this.f49973b);
            }
            LocalDateTime i8 = this.f49972a.i(j8, rVar);
            ZoneOffset zoneOffset = this.f49973b;
            ZoneId zoneId = this.f49974c;
            if (i8 != null) {
                if (zoneOffset != null) {
                    if (zoneId != null) {
                        return zoneId.getRules().g(i8).contains(zoneOffset) ? new ZonedDateTime(i8, zoneId, zoneOffset) : q(i8.F(zoneOffset), i8.s(), zoneId);
                    }
                    throw new NullPointerException("zone");
                }
                throw new NullPointerException("offset");
            }
            throw new NullPointerException("localDateTime");
        }
        return (ZonedDateTime) rVar.d(this, j8);
    }

    @Override // java.lang.Comparable
    /* renamed from: j */
    public final int compareTo(ChronoZonedDateTime chronoZonedDateTime) {
        int compare = Long.compare(p(), chronoZonedDateTime.p());
        if (compare == 0) {
            int u7 = a().u() - chronoZonedDateTime.a().u();
            if (u7 == 0) {
                int compareTo = this.f49972a.compareTo((ChronoLocalDateTime) chronoZonedDateTime.f());
                if (compareTo == 0) {
                    int compareTo2 = this.f49974c.getId().compareTo(chronoZonedDateTime.m().getId());
                    if (compareTo2 == 0) {
                        j$.time.chrono.e b8 = b();
                        j$.time.chrono.e b9 = chronoZonedDateTime.b();
                        ((j$.time.chrono.a) b8).getClass();
                        b9.getClass();
                        return 0;
                    }
                    return compareTo2;
                }
                return compareTo;
            }
            return u7;
        }
        return compare;
    }

    @Override // j$.time.temporal.l
    public final boolean k(j$.time.temporal.o oVar) {
        return (oVar instanceof j$.time.temporal.a) || (oVar != null && oVar.d(this));
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId m() {
        return this.f49974c;
    }

    @Override // j$.time.temporal.l
    public final long n(j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            int i8 = r.f50089a[((j$.time.temporal.a) oVar).ordinal()];
            return i8 != 1 ? i8 != 2 ? this.f49972a.n(oVar) : this.f49973b.s() : p();
        }
        return oVar.i(this);
    }

    @Override // j$.time.temporal.l
    public final Object o(j$.time.temporal.q qVar) {
        return qVar == j$.time.temporal.n.e() ? u() : (qVar == j$.time.temporal.n.i() || qVar == j$.time.temporal.n.j()) ? this.f49974c : qVar == j$.time.temporal.n.g() ? this.f49973b : qVar == j$.time.temporal.n.f() ? a() : qVar == j$.time.temporal.n.d() ? b() : qVar == j$.time.temporal.n.h() ? j$.time.temporal.b.NANOS : qVar.c(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final long p() {
        return ((u().H() * 86400) + a().E()) - this.f49973b.s();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final Instant toInstant() {
        return Instant.ofEpochSecond(p(), a().u());
    }

    public final String toString() {
        String str = this.f49972a.toString() + this.f49973b.toString();
        if (this.f49973b != this.f49974c) {
            return str + '[' + this.f49974c.toString() + ']';
        }
        return str;
    }

    public final g u() {
        return this.f49972a.H();
    }

    public final LocalDateTime v() {
        return this.f49972a;
    }
}
