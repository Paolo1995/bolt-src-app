package j$.time.format;

import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x implements j$.time.temporal.l {

    /* renamed from: b  reason: collision with root package name */
    ZoneId f50053b;

    /* renamed from: c  reason: collision with root package name */
    j$.time.chrono.e f50054c;

    /* renamed from: d  reason: collision with root package name */
    private y f50055d;

    /* renamed from: e  reason: collision with root package name */
    private j$.time.chrono.b f50056e;

    /* renamed from: f  reason: collision with root package name */
    private j$.time.k f50057f;

    /* renamed from: a  reason: collision with root package name */
    final HashMap f50052a = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    j$.time.o f50058g = j$.time.o.f50082d;

    private void j(j$.time.temporal.l lVar) {
        Iterator it = this.f50052a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            j$.time.temporal.o oVar = (j$.time.temporal.o) entry.getKey();
            if (lVar.k(oVar)) {
                try {
                    long n8 = lVar.n(oVar);
                    long longValue = ((Long) entry.getValue()).longValue();
                    if (n8 != longValue) {
                        throw new DateTimeException("Conflict found: Field " + oVar + " " + n8 + " differs from " + oVar + " " + longValue + " derived from " + lVar);
                    }
                    it.remove();
                } catch (RuntimeException unused) {
                }
            }
        }
    }

    private void r() {
        if (this.f50052a.containsKey(j$.time.temporal.a.INSTANT_SECONDS)) {
            ZoneId zoneId = this.f50053b;
            if (zoneId == null) {
                Long l8 = (Long) this.f50052a.get(j$.time.temporal.a.OFFSET_SECONDS);
                if (l8 == null) {
                    return;
                }
                zoneId = ZoneOffset.u(l8.intValue());
            }
            s(zoneId);
        }
    }

    private void s(ZoneId zoneId) {
        HashMap hashMap = this.f50052a;
        j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
        Instant u7 = Instant.u(((Long) hashMap.remove(aVar)).longValue());
        ((j$.time.chrono.f) this.f50054c).getClass();
        ZonedDateTime r7 = ZonedDateTime.r(u7, zoneId);
        w(r7.u());
        x(aVar, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(r7.a().E()));
    }

    private void t(long j8, long j9, long j10, long j11) {
        j$.time.k x7;
        j$.time.o oVar;
        if (this.f50055d == y.LENIENT) {
            long c8 = j$.time.a.c(j$.time.a.c(j$.time.a.c(j$.time.a.e(j8, 3600000000000L), j$.time.a.e(j9, 60000000000L)), j$.time.a.e(j10, 1000000000L)), j11);
            x7 = j$.time.k.y(j$.time.a.d(c8, 86400000000000L));
            oVar = j$.time.o.c((int) j$.time.a.f(c8, 86400000000000L));
        } else {
            int k8 = j$.time.temporal.a.MINUTE_OF_HOUR.k(j9);
            int k9 = j$.time.temporal.a.NANO_OF_SECOND.k(j11);
            if (this.f50055d == y.SMART && j8 == 24 && k8 == 0 && j10 == 0 && k9 == 0) {
                x7 = j$.time.k.f50072g;
                oVar = j$.time.o.c(1);
            } else {
                x7 = j$.time.k.x(j$.time.temporal.a.HOUR_OF_DAY.k(j8), k8, j$.time.temporal.a.SECOND_OF_MINUTE.k(j10), k9);
                oVar = j$.time.o.f50082d;
            }
        }
        v(x7, oVar);
    }

    private void u() {
        j$.time.temporal.a aVar;
        Long valueOf;
        HashMap hashMap = this.f50052a;
        j$.time.temporal.a aVar2 = j$.time.temporal.a.CLOCK_HOUR_OF_DAY;
        if (hashMap.containsKey(aVar2)) {
            long longValue = ((Long) this.f50052a.remove(aVar2)).longValue();
            y yVar = this.f50055d;
            if (yVar == y.STRICT || (yVar == y.SMART && longValue != 0)) {
                aVar2.n(longValue);
            }
            j$.time.temporal.a aVar3 = j$.time.temporal.a.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            x(aVar2, aVar3, Long.valueOf(longValue));
        }
        HashMap hashMap2 = this.f50052a;
        j$.time.temporal.a aVar4 = j$.time.temporal.a.CLOCK_HOUR_OF_AMPM;
        if (hashMap2.containsKey(aVar4)) {
            long longValue2 = ((Long) this.f50052a.remove(aVar4)).longValue();
            y yVar2 = this.f50055d;
            if (yVar2 == y.STRICT || (yVar2 == y.SMART && longValue2 != 0)) {
                aVar4.n(longValue2);
            }
            x(aVar4, j$.time.temporal.a.HOUR_OF_AMPM, Long.valueOf(longValue2 != 12 ? longValue2 : 0L));
        }
        HashMap hashMap3 = this.f50052a;
        j$.time.temporal.a aVar5 = j$.time.temporal.a.AMPM_OF_DAY;
        if (hashMap3.containsKey(aVar5)) {
            HashMap hashMap4 = this.f50052a;
            j$.time.temporal.a aVar6 = j$.time.temporal.a.HOUR_OF_AMPM;
            if (hashMap4.containsKey(aVar6)) {
                long longValue3 = ((Long) this.f50052a.remove(aVar5)).longValue();
                long longValue4 = ((Long) this.f50052a.remove(aVar6)).longValue();
                if (this.f50055d == y.LENIENT) {
                    aVar = j$.time.temporal.a.HOUR_OF_DAY;
                    valueOf = Long.valueOf(j$.time.a.c(j$.time.a.e(longValue3, 12L), longValue4));
                } else {
                    aVar5.n(longValue3);
                    aVar6.n(longValue3);
                    aVar = j$.time.temporal.a.HOUR_OF_DAY;
                    valueOf = Long.valueOf((longValue3 * 12) + longValue4);
                }
                x(aVar5, aVar, valueOf);
            }
        }
        HashMap hashMap5 = this.f50052a;
        j$.time.temporal.a aVar7 = j$.time.temporal.a.NANO_OF_DAY;
        if (hashMap5.containsKey(aVar7)) {
            long longValue5 = ((Long) this.f50052a.remove(aVar7)).longValue();
            if (this.f50055d != y.LENIENT) {
                aVar7.n(longValue5);
            }
            x(aVar7, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(longValue5 / 3600000000000L));
            x(aVar7, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((longValue5 / 60000000000L) % 60));
            x(aVar7, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf((longValue5 / 1000000000) % 60));
            x(aVar7, j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(longValue5 % 1000000000));
        }
        HashMap hashMap6 = this.f50052a;
        j$.time.temporal.a aVar8 = j$.time.temporal.a.MICRO_OF_DAY;
        if (hashMap6.containsKey(aVar8)) {
            long longValue6 = ((Long) this.f50052a.remove(aVar8)).longValue();
            if (this.f50055d != y.LENIENT) {
                aVar8.n(longValue6);
            }
            x(aVar8, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(longValue6 / 1000000));
            x(aVar8, j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(longValue6 % 1000000));
        }
        HashMap hashMap7 = this.f50052a;
        j$.time.temporal.a aVar9 = j$.time.temporal.a.MILLI_OF_DAY;
        if (hashMap7.containsKey(aVar9)) {
            long longValue7 = ((Long) this.f50052a.remove(aVar9)).longValue();
            if (this.f50055d != y.LENIENT) {
                aVar9.n(longValue7);
            }
            x(aVar9, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(longValue7 / 1000));
            x(aVar9, j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(longValue7 % 1000));
        }
        HashMap hashMap8 = this.f50052a;
        j$.time.temporal.a aVar10 = j$.time.temporal.a.SECOND_OF_DAY;
        if (hashMap8.containsKey(aVar10)) {
            long longValue8 = ((Long) this.f50052a.remove(aVar10)).longValue();
            if (this.f50055d != y.LENIENT) {
                aVar10.n(longValue8);
            }
            x(aVar10, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(longValue8 / 3600));
            x(aVar10, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((longValue8 / 60) % 60));
            x(aVar10, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf(longValue8 % 60));
        }
        HashMap hashMap9 = this.f50052a;
        j$.time.temporal.a aVar11 = j$.time.temporal.a.MINUTE_OF_DAY;
        if (hashMap9.containsKey(aVar11)) {
            long longValue9 = ((Long) this.f50052a.remove(aVar11)).longValue();
            if (this.f50055d != y.LENIENT) {
                aVar11.n(longValue9);
            }
            x(aVar11, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(longValue9 / 60));
            x(aVar11, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf(longValue9 % 60));
        }
        HashMap hashMap10 = this.f50052a;
        j$.time.temporal.a aVar12 = j$.time.temporal.a.NANO_OF_SECOND;
        if (hashMap10.containsKey(aVar12)) {
            long longValue10 = ((Long) this.f50052a.get(aVar12)).longValue();
            y yVar3 = this.f50055d;
            y yVar4 = y.LENIENT;
            if (yVar3 != yVar4) {
                aVar12.n(longValue10);
            }
            HashMap hashMap11 = this.f50052a;
            j$.time.temporal.a aVar13 = j$.time.temporal.a.MICRO_OF_SECOND;
            if (hashMap11.containsKey(aVar13)) {
                long longValue11 = ((Long) this.f50052a.remove(aVar13)).longValue();
                if (this.f50055d != yVar4) {
                    aVar13.n(longValue11);
                }
                longValue10 = (longValue10 % 1000) + (longValue11 * 1000);
                x(aVar13, aVar12, Long.valueOf(longValue10));
            }
            HashMap hashMap12 = this.f50052a;
            j$.time.temporal.a aVar14 = j$.time.temporal.a.MILLI_OF_SECOND;
            if (hashMap12.containsKey(aVar14)) {
                long longValue12 = ((Long) this.f50052a.remove(aVar14)).longValue();
                if (this.f50055d != yVar4) {
                    aVar14.n(longValue12);
                }
                x(aVar14, aVar12, Long.valueOf((longValue10 % 1000000) + (longValue12 * 1000000)));
            }
        }
        HashMap hashMap13 = this.f50052a;
        j$.time.temporal.a aVar15 = j$.time.temporal.a.HOUR_OF_DAY;
        if (hashMap13.containsKey(aVar15)) {
            HashMap hashMap14 = this.f50052a;
            j$.time.temporal.a aVar16 = j$.time.temporal.a.MINUTE_OF_HOUR;
            if (hashMap14.containsKey(aVar16)) {
                HashMap hashMap15 = this.f50052a;
                j$.time.temporal.a aVar17 = j$.time.temporal.a.SECOND_OF_MINUTE;
                if (hashMap15.containsKey(aVar17) && this.f50052a.containsKey(aVar12)) {
                    t(((Long) this.f50052a.remove(aVar15)).longValue(), ((Long) this.f50052a.remove(aVar16)).longValue(), ((Long) this.f50052a.remove(aVar17)).longValue(), ((Long) this.f50052a.remove(aVar12)).longValue());
                }
            }
        }
    }

    private void v(j$.time.k kVar, j$.time.o oVar) {
        j$.time.k kVar2 = this.f50057f;
        if (kVar2 == null) {
            this.f50057f = kVar;
        } else if (!kVar2.equals(kVar)) {
            StringBuilder a8 = j$.time.b.a("Conflict found: Fields resolved to different times: ");
            a8.append(this.f50057f);
            a8.append(" ");
            a8.append(kVar);
            throw new DateTimeException(a8.toString());
        } else {
            j$.time.o oVar2 = this.f50058g;
            oVar2.getClass();
            j$.time.o oVar3 = j$.time.o.f50082d;
            if (!(oVar2 == oVar3)) {
                if (!(oVar == oVar3) && !this.f50058g.equals(oVar)) {
                    StringBuilder a9 = j$.time.b.a("Conflict found: Fields resolved to different excess periods: ");
                    a9.append(this.f50058g);
                    a9.append(" ");
                    a9.append(oVar);
                    throw new DateTimeException(a9.toString());
                }
            }
        }
        this.f50058g = oVar;
    }

    private void w(j$.time.chrono.b bVar) {
        j$.time.chrono.b bVar2 = this.f50056e;
        if (bVar2 != null) {
            if (bVar == null || ((j$.time.g) bVar2).equals(bVar)) {
                return;
            }
            StringBuilder a8 = j$.time.b.a("Conflict found: Fields resolved to two different dates: ");
            a8.append(this.f50056e);
            a8.append(" ");
            a8.append(bVar);
            throw new DateTimeException(a8.toString());
        } else if (bVar != null) {
            if (((j$.time.chrono.a) this.f50054c).equals(j$.time.chrono.f.f49977a)) {
                this.f50056e = bVar;
                return;
            }
            StringBuilder a9 = j$.time.b.a("ChronoLocalDate must use the effective parsed chronology: ");
            a9.append(this.f50054c);
            throw new DateTimeException(a9.toString());
        }
    }

    private void x(j$.time.temporal.a aVar, j$.time.temporal.a aVar2, Long l8) {
        Long l9 = (Long) this.f50052a.put(aVar2, l8);
        if (l9 == null || l9.longValue() == l8.longValue()) {
            return;
        }
        throw new DateTimeException("Conflict found: " + aVar2 + " " + l9 + " differs from " + aVar2 + " " + l8 + " while resolving  " + aVar);
    }

    @Override // j$.time.temporal.l
    public final /* synthetic */ int e(j$.time.temporal.o oVar) {
        return j$.time.temporal.n.a(this, oVar);
    }

    @Override // j$.time.temporal.l
    public final /* synthetic */ j$.time.temporal.t h(j$.time.temporal.o oVar) {
        return j$.time.temporal.n.c(this, oVar);
    }

    @Override // j$.time.temporal.l
    public final boolean k(j$.time.temporal.o oVar) {
        j$.time.chrono.b bVar;
        j$.time.k kVar;
        return this.f50052a.containsKey(oVar) || ((bVar = this.f50056e) != null && ((j$.time.g) bVar).k(oVar)) || (((kVar = this.f50057f) != null && kVar.k(oVar)) || !(oVar == null || (oVar instanceof j$.time.temporal.a) || !oVar.d(this)));
    }

    @Override // j$.time.temporal.l
    public final long n(j$.time.temporal.o oVar) {
        if (oVar != null) {
            Long l8 = (Long) this.f50052a.get(oVar);
            if (l8 != null) {
                return l8.longValue();
            }
            j$.time.chrono.b bVar = this.f50056e;
            if (bVar == null || !((j$.time.g) bVar).k(oVar)) {
                j$.time.k kVar = this.f50057f;
                if (kVar == null || !kVar.k(oVar)) {
                    if (oVar instanceof j$.time.temporal.a) {
                        throw new j$.time.temporal.s("Unsupported field: " + oVar);
                    }
                    return oVar.i(this);
                }
                return this.f50057f.n(oVar);
            }
            return ((j$.time.g) this.f50056e).n(oVar);
        }
        throw new NullPointerException("field");
    }

    @Override // j$.time.temporal.l
    public final Object o(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.n.j()) {
            return this.f50053b;
        }
        if (qVar == j$.time.temporal.n.d()) {
            return this.f50054c;
        }
        if (qVar == j$.time.temporal.n.e()) {
            j$.time.chrono.b bVar = this.f50056e;
            if (bVar != null) {
                return j$.time.g.s(bVar);
            }
            return null;
        } else if (qVar == j$.time.temporal.n.f()) {
            return this.f50057f;
        } else {
            if (qVar == j$.time.temporal.n.i() || qVar == j$.time.temporal.n.g()) {
                return qVar.c(this);
            }
            if (qVar == j$.time.temporal.n.h()) {
                return null;
            }
            return qVar.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x022f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q(j$.time.format.y r19, java.util.Set r20) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.x.q(j$.time.format.y, java.util.Set):void");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(this.f50052a);
        sb.append(',');
        sb.append(this.f50054c);
        if (this.f50053b != null) {
            sb.append(',');
            sb.append(this.f50053b);
        }
        if (this.f50056e != null || this.f50057f != null) {
            sb.append(" resolved to ");
            j$.time.chrono.b bVar = this.f50056e;
            if (bVar != null) {
                sb.append(bVar);
                if (this.f50057f != null) {
                    sb.append('T');
                }
            }
            sb.append(this.f50057f);
        }
        return sb.toString();
    }
}
