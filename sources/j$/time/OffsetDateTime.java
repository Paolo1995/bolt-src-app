package j$.time;

import j$.time.chrono.ChronoLocalDateTime;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.s;
import j$.time.temporal.t;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class OffsetDateTime implements j$.time.temporal.k, j$.time.temporal.m, Comparable<OffsetDateTime>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final LocalDateTime f49963a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset f49964b;

    static {
        LocalDateTime localDateTime = LocalDateTime.MIN;
        ZoneOffset zoneOffset = ZoneOffset.f49969g;
        localDateTime.getClass();
        r(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.MAX;
        ZoneOffset zoneOffset2 = ZoneOffset.f49968f;
        localDateTime2.getClass();
        r(localDateTime2, zoneOffset2);
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        if (localDateTime == null) {
            throw new NullPointerException("dateTime");
        }
        this.f49963a = localDateTime;
        if (zoneOffset == null) {
            throw new NullPointerException("offset");
        }
        this.f49964b = zoneOffset;
    }

    public static OffsetDateTime parse(CharSequence charSequence) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.f49986i;
        if (dateTimeFormatter != null) {
            return (OffsetDateTime) dateTimeFormatter.f(charSequence, new h(1));
        }
        throw new NullPointerException("formatter");
    }

    public static OffsetDateTime q(j$.time.temporal.l lVar) {
        if (lVar instanceof OffsetDateTime) {
            return (OffsetDateTime) lVar;
        }
        try {
            ZoneOffset r7 = ZoneOffset.r(lVar);
            g gVar = (g) lVar.o(j$.time.temporal.n.e());
            k kVar = (k) lVar.o(j$.time.temporal.n.f());
            return (gVar == null || kVar == null) ? s(Instant.r(lVar), r7) : new OffsetDateTime(LocalDateTime.z(gVar, kVar), r7);
        } catch (DateTimeException e8) {
            throw new DateTimeException("Unable to obtain OffsetDateTime from TemporalAccessor: " + lVar + " of type " + lVar.getClass().getName(), e8);
        }
    }

    public static OffsetDateTime r(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    public static OffsetDateTime s(Instant instant, ZoneId zoneId) {
        if (instant != null) {
            if (zoneId != null) {
                ZoneOffset d8 = zoneId.getRules().d(instant);
                return new OffsetDateTime(LocalDateTime.A(instant.s(), instant.t(), d8), d8);
            }
            throw new NullPointerException("zone");
        }
        throw new NullPointerException("instant");
    }

    private OffsetDateTime t(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.f49963a == localDateTime && this.f49964b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
    }

    @Override // java.lang.Comparable
    public final int compareTo(OffsetDateTime offsetDateTime) {
        int compare;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if (this.f49964b.equals(offsetDateTime2.f49964b)) {
            compare = toLocalDateTime().compareTo((ChronoLocalDateTime<?>) offsetDateTime2.toLocalDateTime());
        } else {
            compare = Long.compare(this.f49963a.F(this.f49964b), offsetDateTime2.f49963a.F(offsetDateTime2.f49964b));
            if (compare == 0) {
                compare = this.f49963a.a().u() - offsetDateTime2.f49963a.a().u();
            }
        }
        return compare == 0 ? toLocalDateTime().compareTo((ChronoLocalDateTime<?>) offsetDateTime2.toLocalDateTime()) : compare;
    }

    @Override // j$.time.temporal.k
    public final j$.time.temporal.k d(long j8, j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) oVar;
            int i8 = n.f50081a[aVar.ordinal()];
            return i8 != 1 ? i8 != 2 ? t(this.f49963a.d(j8, oVar), this.f49964b) : t(this.f49963a, ZoneOffset.u(aVar.k(j8))) : s(Instant.ofEpochSecond(j8, this.f49963a.s()), this.f49964b);
        }
        return (OffsetDateTime) oVar.j(this, j8);
    }

    @Override // j$.time.temporal.l
    public final int e(j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            int i8 = n.f50081a[((j$.time.temporal.a) oVar).ordinal()];
            if (i8 != 1) {
                return i8 != 2 ? this.f49963a.e(oVar) : this.f49964b.s();
            }
            throw new s("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        }
        return j$.time.temporal.n.a(this, oVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            return this.f49963a.equals(offsetDateTime.f49963a) && this.f49964b.equals(offsetDateTime.f49964b);
        }
        return false;
    }

    @Override // j$.time.temporal.k
    public final j$.time.temporal.k g(g gVar) {
        return t(this.f49963a.g(gVar), this.f49964b);
    }

    @Override // j$.time.temporal.l
    public final t h(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? (oVar == j$.time.temporal.a.INSTANT_SECONDS || oVar == j$.time.temporal.a.OFFSET_SECONDS) ? oVar.g() : this.f49963a.h(oVar) : oVar.e(this);
    }

    public final int hashCode() {
        return this.f49963a.hashCode() ^ this.f49964b.hashCode();
    }

    @Override // j$.time.temporal.k
    public final j$.time.temporal.k i(long j8, j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.b ? t(this.f49963a.i(j8, rVar), this.f49964b) : (OffsetDateTime) rVar.d(this, j8);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.k j(j$.time.temporal.k kVar) {
        return kVar.d(this.f49963a.H().H(), j$.time.temporal.a.EPOCH_DAY).d(this.f49963a.a().D(), j$.time.temporal.a.NANO_OF_DAY).d(this.f49964b.s(), j$.time.temporal.a.OFFSET_SECONDS);
    }

    @Override // j$.time.temporal.l
    public final boolean k(j$.time.temporal.o oVar) {
        return (oVar instanceof j$.time.temporal.a) || (oVar != null && oVar.d(this));
    }

    @Override // j$.time.temporal.l
    public final long n(j$.time.temporal.o oVar) {
        if (oVar instanceof j$.time.temporal.a) {
            int i8 = n.f50081a[((j$.time.temporal.a) oVar).ordinal()];
            return i8 != 1 ? i8 != 2 ? this.f49963a.n(oVar) : this.f49964b.s() : this.f49963a.F(this.f49964b);
        }
        return oVar.i(this);
    }

    @Override // j$.time.temporal.l
    public final Object o(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.n.g() || qVar == j$.time.temporal.n.i()) {
            return this.f49964b;
        }
        if (qVar == j$.time.temporal.n.j()) {
            return null;
        }
        return qVar == j$.time.temporal.n.e() ? this.f49963a.H() : qVar == j$.time.temporal.n.f() ? this.f49963a.a() : qVar == j$.time.temporal.n.d() ? j$.time.chrono.f.f49977a : qVar == j$.time.temporal.n.h() ? j$.time.temporal.b.NANOS : qVar.c(this);
    }

    public Instant toInstant() {
        return this.f49963a.G(this.f49964b);
    }

    public LocalDateTime toLocalDateTime() {
        return this.f49963a;
    }

    public final String toString() {
        return this.f49963a.toString() + this.f49964b.toString();
    }
}
