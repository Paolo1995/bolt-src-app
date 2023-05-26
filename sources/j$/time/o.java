package j$.time;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class o implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final o f50082d = new o(0);

    /* renamed from: a  reason: collision with root package name */
    private final int f50083a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f50084b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final int f50085c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        Collections.unmodifiableList(Arrays.asList(j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS));
    }

    private o(int i8) {
        this.f50085c = i8;
    }

    public static o c(int i8) {
        return (i8 | 0) == 0 ? f50082d : new o(i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final j$.time.temporal.k a(j$.time.temporal.k r7) {
        /*
            r6 = this;
            j$.time.temporal.p r0 = j$.time.temporal.n.d()
            r1 = r7
            j$.time.g r1 = (j$.time.g) r1
            java.lang.Object r0 = r1.o(r0)
            j$.time.chrono.e r0 = (j$.time.chrono.e) r0
            if (r0 == 0) goto L20
            j$.time.chrono.f r2 = j$.time.chrono.f.f49977a
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L18
            goto L20
        L18:
            j$.time.DateTimeException r7 = new j$.time.DateTimeException
            java.lang.String r0 = "Chronology mismatch, expected: ISO, actual: ISO"
            r7.<init>(r0)
            throw r7
        L20:
            int r0 = r6.f50084b
            if (r0 != 0) goto L2c
            int r0 = r6.f50083a
            if (r0 == 0) goto L3c
            long r2 = (long) r0
            j$.time.temporal.b r7 = j$.time.temporal.b.YEARS
            goto L38
        L2c:
            long r2 = r6.d()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L3c
            j$.time.temporal.b r7 = j$.time.temporal.b.MONTHS
        L38:
            j$.time.g r7 = r1.i(r2, r7)
        L3c:
            int r0 = r6.f50085c
            if (r0 == 0) goto L49
            long r0 = (long) r0
            j$.time.temporal.b r2 = j$.time.temporal.b.DAYS
            j$.time.g r7 = (j$.time.g) r7
            j$.time.g r7 = r7.i(r0, r2)
        L49:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.o.a(j$.time.temporal.k):j$.time.temporal.k");
    }

    public final int b() {
        return this.f50085c;
    }

    public final long d() {
        return (this.f50083a * 12) + this.f50084b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return this.f50083a == oVar.f50083a && this.f50084b == oVar.f50084b && this.f50085c == oVar.f50085c;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f50085c, 16) + Integer.rotateLeft(this.f50084b, 8) + this.f50083a;
    }

    public final String toString() {
        if (this == f50082d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        int i8 = this.f50083a;
        if (i8 != 0) {
            sb.append(i8);
            sb.append('Y');
        }
        int i9 = this.f50084b;
        if (i9 != 0) {
            sb.append(i9);
            sb.append('M');
        }
        int i10 = this.f50085c;
        if (i10 != 0) {
            sb.append(i10);
            sb.append('D');
        }
        return sb.toString();
    }
}
