package j$.time.format;

import j$.time.DateTimeException;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j implements g {

    /* renamed from: f  reason: collision with root package name */
    static final long[] f50006f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS};

    /* renamed from: a  reason: collision with root package name */
    final j$.time.temporal.o f50007a;

    /* renamed from: b  reason: collision with root package name */
    final int f50008b;

    /* renamed from: c  reason: collision with root package name */
    final int f50009c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50010d;

    /* renamed from: e  reason: collision with root package name */
    final int f50011e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(j$.time.temporal.o oVar, int i8, int i9, int i10) {
        this.f50007a = oVar;
        this.f50008b = i8;
        this.f50009c = i9;
        this.f50010d = i10;
        this.f50011e = 0;
    }

    protected j(j$.time.temporal.o oVar, int i8, int i9, int i10, int i11) {
        this.f50007a = oVar;
        this.f50008b = i8;
        this.f50009c = i9;
        this.f50010d = i10;
        this.f50011e = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j b() {
        return this.f50011e == -1 ? this : new j(this.f50007a, this.f50008b, this.f50009c, this.f50010d, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j c(int i8) {
        return new j(this.f50007a, this.f50008b, this.f50009c, this.f50010d, this.f50011e + i8);
    }

    @Override // j$.time.format.g
    public final boolean d(u uVar, StringBuilder sb) {
        int i8;
        Long e8 = uVar.e(this.f50007a);
        if (e8 == null) {
            return false;
        }
        long longValue = e8.longValue();
        w b8 = uVar.b();
        String l8 = longValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(longValue));
        if (l8.length() > this.f50009c) {
            StringBuilder a8 = j$.time.b.a("Field ");
            a8.append(this.f50007a);
            a8.append(" cannot be printed as the value ");
            a8.append(longValue);
            a8.append(" exceeds the maximum print width of ");
            a8.append(this.f50009c);
            throw new DateTimeException(a8.toString());
        }
        b8.getClass();
        int i9 = (longValue > 0L ? 1 : (longValue == 0L ? 0 : -1));
        int[] iArr = d.f49998a;
        int a9 = z.a(this.f50010d);
        if (i9 >= 0) {
            int i10 = iArr[a9];
            if (i10 == 1 ? !((i8 = this.f50008b) >= 19 || longValue < f50006f[i8]) : i10 == 2) {
                sb.append('+');
            }
        } else {
            int i11 = iArr[a9];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                sb.append('-');
            } else if (i11 == 4) {
                StringBuilder a10 = j$.time.b.a("Field ");
                a10.append(this.f50007a);
                a10.append(" cannot be printed as the value ");
                a10.append(longValue);
                a10.append(" cannot be negative according to the SignStyle");
                throw new DateTimeException(a10.toString());
            }
        }
        for (int i12 = 0; i12 < this.f50008b - l8.length(); i12++) {
            sb.append('0');
        }
        sb.append(l8);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x0187, code lost:
        if (r2 <= r3) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00e2  */
    @Override // j$.time.format.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int e(j$.time.format.s r20, java.lang.CharSequence r21, int r22) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.j.e(j$.time.format.s, java.lang.CharSequence, int):int");
    }

    public final String toString() {
        StringBuilder a8;
        int i8 = this.f50008b;
        if (i8 == 1 && this.f50009c == 19 && this.f50010d == 1) {
            a8 = j$.time.b.a("Value(");
            a8.append(this.f50007a);
        } else if (i8 == this.f50009c && this.f50010d == 4) {
            a8 = j$.time.b.a("Value(");
            a8.append(this.f50007a);
            a8.append(",");
            a8.append(this.f50008b);
        } else {
            a8 = j$.time.b.a("Value(");
            a8.append(this.f50007a);
            a8.append(",");
            a8.append(this.f50008b);
            a8.append(",");
            a8.append(this.f50009c);
            a8.append(",");
            a8.append(z.b(this.f50010d));
        }
        a8.append(")");
        return a8.toString();
    }
}
