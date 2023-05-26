package j$.time.format;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k implements g {

    /* renamed from: c  reason: collision with root package name */
    static final String[] f50012c = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};

    /* renamed from: d  reason: collision with root package name */
    static final k f50013d = new k("+HH:MM:ss", "Z");

    /* renamed from: e  reason: collision with root package name */
    static final k f50014e = new k("+HH:MM:ss", "0");

    /* renamed from: a  reason: collision with root package name */
    private final String f50015a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50016b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(String str, String str2) {
        int i8 = 0;
        while (true) {
            String[] strArr = f50012c;
            if (i8 >= 9) {
                throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
            } else if (strArr[i8].equals(str)) {
                this.f50016b = i8;
                this.f50015a = str2;
                return;
            } else {
                i8++;
            }
        }
    }

    private boolean a(int[] iArr, int i8, CharSequence charSequence, boolean z7) {
        int i9 = this.f50016b;
        if ((i9 + 3) / 2 < i8) {
            return false;
        }
        int i10 = iArr[0];
        if (i9 % 2 == 0 && i8 > 1) {
            int i11 = i10 + 1;
            if (i11 > charSequence.length() || charSequence.charAt(i10) != ':') {
                return z7;
            }
            i10 = i11;
        }
        if (i10 + 2 > charSequence.length()) {
            return z7;
        }
        int i12 = i10 + 1;
        char charAt = charSequence.charAt(i10);
        int i13 = i12 + 1;
        char charAt2 = charSequence.charAt(i12);
        if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
            int i14 = (charAt2 - '0') + ((charAt - '0') * 10);
            if (i14 >= 0 && i14 <= 59) {
                iArr[i8] = i14;
                iArr[0] = i13;
                return false;
            }
        }
        return z7;
    }

    @Override // j$.time.format.g
    public final boolean d(u uVar, StringBuilder sb) {
        Long e8 = uVar.e(j$.time.temporal.a.OFFSET_SECONDS);
        if (e8 == null) {
            return false;
        }
        long longValue = e8.longValue();
        int i8 = (int) longValue;
        if (longValue == i8) {
            if (i8 != 0) {
                int abs = Math.abs((i8 / 3600) % 100);
                int abs2 = Math.abs((i8 / 60) % 60);
                int abs3 = Math.abs(i8 % 60);
                int length = sb.length();
                sb.append(i8 < 0 ? "-" : "+");
                sb.append((char) ((abs / 10) + 48));
                sb.append((char) ((abs % 10) + 48));
                int i9 = this.f50016b;
                if (i9 >= 3 || (i9 >= 1 && abs2 > 0)) {
                    sb.append(i9 % 2 == 0 ? ":" : "");
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int i10 = this.f50016b;
                    if (i10 >= 7 || (i10 >= 5 && abs3 > 0)) {
                        sb.append(i10 % 2 != 0 ? "" : ":");
                        sb.append((char) ((abs3 / 10) + 48));
                        sb.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb.setLength(length);
                }
                return true;
            }
            sb.append(this.f50015a);
            return true;
        }
        throw new ArithmeticException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r16.r(r17, r18, r15.f50015a, 0, r9) != false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // j$.time.format.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int e(j$.time.format.s r16, java.lang.CharSequence r17, int r18) {
        /*
            r15 = this;
            r0 = r15
            r7 = r17
            r8 = r18
            int r1 = r17.length()
            java.lang.String r2 = r0.f50015a
            int r9 = r2.length()
            r10 = 0
            if (r9 != 0) goto L1c
            if (r8 != r1) goto L31
            j$.time.temporal.a r1 = j$.time.temporal.a.OFFSET_SECONDS
            r2 = r1
            r6 = r8
            r3 = r10
            goto L92
        L1c:
            if (r8 != r1) goto L20
            int r1 = ~r8
            return r1
        L20:
            java.lang.String r4 = r0.f50015a
            r5 = 0
            r1 = r16
            r2 = r17
            r3 = r18
            r6 = r9
            boolean r1 = r1.r(r2, r3, r4, r5, r6)
            if (r1 == 0) goto L31
            goto L8b
        L31:
            char r1 = r17.charAt(r18)
            r2 = 43
            r3 = 45
            if (r1 == r2) goto L3d
            if (r1 != r3) goto L89
        L3d:
            r2 = 1
            if (r1 != r3) goto L42
            r1 = -1
            goto L43
        L42:
            r1 = 1
        L43:
            r3 = 4
            int[] r3 = new int[r3]
            int r4 = r8 + 1
            r5 = 0
            r3[r5] = r4
            boolean r4 = r15.a(r3, r2, r7, r2)
            r6 = 2
            r12 = 3
            if (r4 != 0) goto L69
            int r4 = r0.f50016b
            if (r4 < r12) goto L59
            r4 = 1
            goto L5a
        L59:
            r4 = 0
        L5a:
            boolean r4 = r15.a(r3, r6, r7, r4)
            if (r4 != 0) goto L69
            boolean r4 = r15.a(r3, r12, r7, r5)
            if (r4 == 0) goto L67
            goto L69
        L67:
            r4 = 0
            goto L6a
        L69:
            r4 = 1
        L6a:
            if (r4 != 0) goto L89
            long r9 = (long) r1
            r1 = r3[r2]
            long r1 = (long) r1
            r13 = 3600(0xe10, double:1.7786E-320)
            long r1 = r1 * r13
            r4 = r3[r6]
            long r6 = (long) r4
            r13 = 60
            long r6 = r6 * r13
            long r6 = r6 + r1
            r1 = r3[r12]
            long r1 = (long) r1
            long r6 = r6 + r1
            long r6 = r6 * r9
            j$.time.temporal.a r1 = j$.time.temporal.a.OFFSET_SECONDS
            r2 = r3[r5]
            r3 = r6
            r6 = r2
            goto L91
        L89:
            if (r9 != 0) goto L9b
        L8b:
            j$.time.temporal.a r1 = j$.time.temporal.a.OFFSET_SECONDS
            int r2 = r8 + r9
            r6 = r2
            r3 = r10
        L91:
            r2 = r1
        L92:
            r1 = r16
            r5 = r18
            int r1 = r1.n(r2, r3, r5, r6)
            return r1
        L9b:
            int r1 = ~r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.k.e(j$.time.format.s, java.lang.CharSequence, int):int");
    }

    public final String toString() {
        String replace = this.f50015a.replace("'", "''");
        StringBuilder a8 = j$.time.b.a("Offset(");
        a8.append(f50012c[this.f50016b]);
        a8.append(",'");
        a8.append(replace);
        a8.append("')");
        return a8.toString();
    }
}
