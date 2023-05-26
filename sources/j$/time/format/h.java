package j$.time.format;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    private final j$.time.temporal.o f50002a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50003b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50004c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f50005d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(j$.time.temporal.a aVar) {
        if (aVar == null) {
            throw new NullPointerException("field");
        }
        if (!aVar.g().f()) {
            throw new IllegalArgumentException("Field must have a fixed set of values: " + aVar);
        }
        this.f50002a = aVar;
        this.f50003b = 0;
        this.f50004c = 9;
        this.f50005d = true;
    }

    @Override // j$.time.format.g
    public final boolean d(u uVar, StringBuilder sb) {
        Long e8 = uVar.e(this.f50002a);
        if (e8 == null) {
            return false;
        }
        w b8 = uVar.b();
        long longValue = e8.longValue();
        j$.time.temporal.t g8 = this.f50002a.g();
        g8.b(longValue, this.f50002a);
        BigDecimal valueOf = BigDecimal.valueOf(g8.e());
        BigDecimal divide = BigDecimal.valueOf(longValue).subtract(valueOf).divide(BigDecimal.valueOf(g8.d()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
        BigDecimal stripTrailingZeros = divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
        if (stripTrailingZeros.scale() != 0) {
            String substring = stripTrailingZeros.setScale(Math.min(Math.max(stripTrailingZeros.scale(), this.f50003b), this.f50004c), RoundingMode.FLOOR).toPlainString().substring(2);
            b8.getClass();
            if (this.f50005d) {
                sb.append('.');
            }
            sb.append(substring);
            return true;
        } else if (this.f50003b > 0) {
            if (this.f50005d) {
                b8.getClass();
                sb.append('.');
            }
            for (int i8 = 0; i8 < this.f50003b; i8++) {
                b8.getClass();
                sb.append('0');
            }
            return true;
        } else {
            return true;
        }
    }

    @Override // j$.time.format.g
    public final int e(s sVar, CharSequence charSequence, int i8) {
        int i9;
        int i10 = sVar.k() ? this.f50003b : 0;
        int i11 = sVar.k() ? this.f50004c : 9;
        int length = charSequence.length();
        if (i8 == length) {
            return i10 > 0 ? ~i8 : i8;
        }
        if (this.f50005d) {
            char charAt = charSequence.charAt(i8);
            sVar.f().getClass();
            if (charAt != '.') {
                return i10 > 0 ? ~i8 : i8;
            }
            i8++;
        }
        int i12 = i8;
        int i13 = i10 + i12;
        if (i13 > length) {
            return ~i12;
        }
        int min = Math.min(i11 + i12, length);
        int i14 = i12;
        int i15 = 0;
        while (true) {
            if (i14 >= min) {
                i9 = i14;
                break;
            }
            int i16 = i14 + 1;
            int a8 = sVar.f().a(charSequence.charAt(i14));
            if (a8 >= 0) {
                i15 = (i15 * 10) + a8;
                i14 = i16;
            } else if (i16 < i13) {
                return ~i12;
            } else {
                i9 = i16 - 1;
            }
        }
        BigDecimal movePointLeft = new BigDecimal(i15).movePointLeft(i9 - i12);
        j$.time.temporal.t g8 = this.f50002a.g();
        BigDecimal valueOf = BigDecimal.valueOf(g8.e());
        return sVar.n(this.f50002a, movePointLeft.multiply(BigDecimal.valueOf(g8.d()).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact(), i12, i9);
    }

    public final String toString() {
        String str = this.f50005d ? ",DecimalPoint" : "";
        StringBuilder a8 = j$.time.b.a("Fraction(");
        a8.append(this.f50002a);
        a8.append(",");
        a8.append(this.f50003b);
        a8.append(",");
        a8.append(this.f50004c);
        a8.append(str);
        a8.append(")");
        return a8.toString();
    }
}
