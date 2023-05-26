package j$.time.format;

import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import j$.util.AbstractC0156n;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private j$.time.temporal.l f50046a;

    /* renamed from: b  reason: collision with root package name */
    private DateTimeFormatter f50047b;

    /* renamed from: c  reason: collision with root package name */
    private int f50048c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(j$.time.temporal.l lVar, DateTimeFormatter dateTimeFormatter) {
        j$.time.temporal.a[] values;
        j$.time.chrono.e b8 = dateTimeFormatter.b();
        ZoneId e8 = dateTimeFormatter.e();
        if (b8 != null || e8 != null) {
            j$.time.chrono.e eVar = (j$.time.chrono.e) lVar.o(j$.time.temporal.n.d());
            ZoneId zoneId = (ZoneId) lVar.o(j$.time.temporal.n.j());
            j$.time.g gVar = null;
            b8 = AbstractC0156n.l(b8, eVar) ? null : b8;
            e8 = AbstractC0156n.l(e8, zoneId) ? null : e8;
            if (b8 != null || e8 != null) {
                j$.time.chrono.e eVar2 = b8 != null ? b8 : eVar;
                if (e8 != null) {
                    if (lVar.k(j$.time.temporal.a.INSTANT_SECONDS)) {
                        eVar2 = eVar2 == null ? j$.time.chrono.f.f49977a : eVar2;
                        Instant r7 = Instant.r(lVar);
                        ((j$.time.chrono.f) eVar2).getClass();
                        lVar = ZonedDateTime.r(r7, e8);
                    } else if (e8.normalized() instanceof ZoneOffset) {
                        j$.time.temporal.a aVar = j$.time.temporal.a.OFFSET_SECONDS;
                        if (lVar.k(aVar) && lVar.e(aVar) != e8.getRules().d(Instant.EPOCH).s()) {
                            throw new DateTimeException("Unable to apply override zone '" + e8 + "' because the temporal object being formatted has a different offset but does not represent an instant: " + lVar);
                        }
                    }
                }
                zoneId = e8 != null ? e8 : zoneId;
                if (b8 != null) {
                    if (lVar.k(j$.time.temporal.a.EPOCH_DAY)) {
                        ((j$.time.chrono.f) eVar2).getClass();
                        gVar = j$.time.g.s(lVar);
                    } else if (b8 != j$.time.chrono.f.f49977a || eVar != null) {
                        for (j$.time.temporal.a aVar2 : j$.time.temporal.a.values()) {
                            if (aVar2.isDateBased() && lVar.k(aVar2)) {
                                throw new DateTimeException("Unable to apply override chronology '" + b8 + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + lVar);
                            }
                        }
                    }
                }
                lVar = new t(gVar, lVar, eVar2, zoneId);
            }
        }
        this.f50046a = lVar;
        this.f50047b = dateTimeFormatter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f50048c--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w b() {
        return this.f50047b.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Locale c() {
        return this.f50047b.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j$.time.temporal.l d() {
        return this.f50046a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long e(j$.time.temporal.o oVar) {
        try {
            return Long.valueOf(this.f50046a.n(oVar));
        } catch (DateTimeException e8) {
            if (this.f50048c > 0) {
                return null;
            }
            throw e8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object f(j$.time.temporal.q qVar) {
        Object o8 = this.f50046a.o(qVar);
        if (o8 == null && this.f50048c == 0) {
            StringBuilder a8 = j$.time.b.a("Unable to extract value: ");
            a8.append(this.f50046a.getClass());
            throw new DateTimeException(a8.toString());
        }
        return o8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g() {
        this.f50048c++;
    }

    public final String toString() {
        return this.f50046a.toString();
    }
}
