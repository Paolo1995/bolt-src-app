package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements g {
    @Override // j$.time.format.g
    public final boolean d(u uVar, StringBuilder sb) {
        Long e8 = uVar.e(j$.time.temporal.a.INSTANT_SECONDS);
        j$.time.temporal.l d8 = uVar.d();
        j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
        Long valueOf = d8.k(aVar) ? Long.valueOf(uVar.d().n(aVar)) : null;
        int i8 = 0;
        if (e8 == null) {
            return false;
        }
        long longValue = e8.longValue();
        int k8 = aVar.k(valueOf != null ? valueOf.longValue() : 0L);
        if (longValue >= -62167219200L) {
            long j8 = (longValue - 315569520000L) + 62167219200L;
            long f8 = j$.time.a.f(j8, 315569520000L) + 1;
            LocalDateTime A = LocalDateTime.A(j$.time.a.d(j8, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
            if (f8 > 0) {
                sb.append('+');
                sb.append(f8);
            }
            sb.append(A);
            if (A.t() == 0) {
                sb.append(":00");
            }
        } else {
            long j9 = longValue + 62167219200L;
            long j10 = j9 / 315569520000L;
            long j11 = j9 % 315569520000L;
            LocalDateTime A2 = LocalDateTime.A(j11 - 62167219200L, 0, ZoneOffset.UTC);
            int length = sb.length();
            sb.append(A2);
            if (A2.t() == 0) {
                sb.append(":00");
            }
            if (j10 < 0) {
                if (A2.u() == -10000) {
                    sb.replace(length, length + 2, Long.toString(j10 - 1));
                } else if (j11 == 0) {
                    sb.insert(length, j10);
                } else {
                    sb.insert(length + 1, Math.abs(j10));
                }
            }
        }
        if (k8 > 0) {
            sb.append('.');
            int i9 = 100000000;
            while (true) {
                if (k8 <= 0 && i8 % 3 == 0 && i8 >= -2) {
                    break;
                }
                int i10 = k8 / i9;
                sb.append((char) (i10 + 48));
                k8 -= i10 * i9;
                i9 /= 10;
                i8++;
            }
        }
        sb.append('Z');
        return true;
    }

    @Override // j$.time.format.g
    public final int e(s sVar, CharSequence charSequence, int i8) {
        int i9;
        int i10;
        r rVar = new r();
        rVar.a(DateTimeFormatter.ISO_LOCAL_DATE);
        rVar.e('T');
        j$.time.temporal.a aVar = j$.time.temporal.a.HOUR_OF_DAY;
        rVar.k(aVar, 2);
        rVar.e(':');
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MINUTE_OF_HOUR;
        rVar.k(aVar2, 2);
        rVar.e(':');
        j$.time.temporal.a aVar3 = j$.time.temporal.a.SECOND_OF_MINUTE;
        rVar.k(aVar3, 2);
        j$.time.temporal.a aVar4 = j$.time.temporal.a.NANO_OF_SECOND;
        rVar.b(aVar4);
        rVar.e('Z');
        f h8 = rVar.s().h();
        s c8 = sVar.c();
        int e8 = h8.e(c8, charSequence, i8);
        if (e8 < 0) {
            return e8;
        }
        long longValue = c8.i(j$.time.temporal.a.YEAR).longValue();
        int intValue = c8.i(j$.time.temporal.a.MONTH_OF_YEAR).intValue();
        int intValue2 = c8.i(j$.time.temporal.a.DAY_OF_MONTH).intValue();
        int intValue3 = c8.i(aVar).intValue();
        int intValue4 = c8.i(aVar2).intValue();
        Long i11 = c8.i(aVar3);
        Long i12 = c8.i(aVar4);
        int i13 = 0;
        int intValue5 = i11 != null ? i11.intValue() : 0;
        int intValue6 = i12 != null ? i12.intValue() : 0;
        if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
            i10 = intValue5;
            i13 = 1;
            i9 = 0;
        } else if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
            sVar.o();
            i9 = intValue3;
            i10 = 59;
        } else {
            i9 = intValue3;
            i10 = intValue5;
        }
        try {
            return sVar.n(aVar4, intValue6, i8, sVar.n(j$.time.temporal.a.INSTANT_SECONDS, j$.time.a.e(longValue / 10000, 315569520000L) + LocalDateTime.y(((int) longValue) % 10000, intValue, intValue2, i9, intValue4, i10).C(i13).F(ZoneOffset.UTC), i8, e8));
        } catch (RuntimeException unused) {
            return ~i8;
        }
    }

    public final String toString() {
        return "Instant()";
    }
}
