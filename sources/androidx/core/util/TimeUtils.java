package androidx.core.util;

import java.io.PrintWriter;

/* loaded from: classes.dex */
public final class TimeUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f5913a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static char[] f5914b = new char[24];

    private TimeUtils() {
    }

    private static int a(int i8, int i9, boolean z7, int i10) {
        if (i8 > 99 || (z7 && i10 >= 3)) {
            return i9 + 3;
        }
        if (i8 > 9 || (z7 && i10 >= 2)) {
            return i9 + 2;
        }
        if (z7 || i8 > 0) {
            return i9 + 1;
        }
        return 0;
    }

    public static void b(long j8, long j9, PrintWriter printWriter) {
        if (j8 == 0) {
            printWriter.print("--");
        } else {
            d(j8 - j9, printWriter, 0);
        }
    }

    public static void c(long j8, PrintWriter printWriter) {
        d(j8, printWriter, 0);
    }

    public static void d(long j8, PrintWriter printWriter, int i8) {
        synchronized (f5913a) {
            printWriter.print(new String(f5914b, 0, e(j8, i8)));
        }
    }

    private static int e(long j8, int i8) {
        char c8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z7;
        boolean z8;
        int i14;
        boolean z9;
        int i15;
        boolean z10;
        int i16;
        int i17;
        boolean z11;
        boolean z12;
        boolean z13;
        int i18;
        long j9 = j8;
        if (f5914b.length < i8) {
            f5914b = new char[i8];
        }
        char[] cArr = f5914b;
        int i19 = (j9 > 0L ? 1 : (j9 == 0L ? 0 : -1));
        if (i19 == 0) {
            int i20 = i8 - 1;
            while (i20 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i19 > 0) {
            c8 = '+';
        } else {
            c8 = '-';
            j9 = -j9;
        }
        int i21 = (int) (j9 % 1000);
        int floor = (int) Math.floor(j9 / 1000);
        if (floor > 86400) {
            i9 = floor / 86400;
            floor -= 86400 * i9;
        } else {
            i9 = 0;
        }
        if (floor > 3600) {
            i10 = floor / 3600;
            floor -= i10 * 3600;
        } else {
            i10 = 0;
        }
        if (floor > 60) {
            int i22 = floor / 60;
            i11 = floor - (i22 * 60);
            i12 = i22;
        } else {
            i11 = floor;
            i12 = 0;
        }
        if (i8 != 0) {
            int a8 = a(i9, 1, false, 0);
            if (a8 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            int a9 = a8 + a(i10, 1, z11, 2);
            if (a9 > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            int a10 = a9 + a(i12, 1, z12, 2);
            if (a10 > 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            int a11 = a10 + a(i11, 1, z13, 2);
            if (a11 > 0) {
                i18 = 3;
            } else {
                i18 = 0;
            }
            i13 = 0;
            for (int a12 = a11 + a(i21, 2, true, i18) + 1; a12 < i8; a12++) {
                cArr[i13] = ' ';
                i13++;
            }
        } else {
            i13 = 0;
        }
        cArr[i13] = c8;
        int i23 = i13 + 1;
        if (i8 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        int f8 = f(cArr, i9, 'd', i23, false, 0);
        if (f8 != i23) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7) {
            i14 = 2;
        } else {
            i14 = 0;
        }
        int f9 = f(cArr, i10, 'h', f8, z8, i14);
        if (f9 != i23) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z7) {
            i15 = 2;
        } else {
            i15 = 0;
        }
        int f10 = f(cArr, i12, 'm', f9, z9, i15);
        if (f10 != i23) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z7) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        int f11 = f(cArr, i11, 's', f10, z10, i16);
        if (z7 && f11 != i23) {
            i17 = 3;
        } else {
            i17 = 0;
        }
        int f12 = f(cArr, i21, 'm', f11, true, i17);
        cArr[f12] = 's';
        return f12 + 1;
    }

    private static int f(char[] cArr, int i8, char c8, int i9, boolean z7, int i10) {
        int i11;
        if (z7 || i8 > 0) {
            if ((z7 && i10 >= 3) || i8 > 99) {
                int i12 = i8 / 100;
                cArr[i9] = (char) (i12 + 48);
                i11 = i9 + 1;
                i8 -= i12 * 100;
            } else {
                i11 = i9;
            }
            if ((z7 && i10 >= 2) || i8 > 9 || i9 != i11) {
                int i13 = i8 / 10;
                cArr[i11] = (char) (i13 + 48);
                i11++;
                i8 -= i13 * 10;
            }
            cArr[i11] = (char) (i8 + 48);
            int i14 = i11 + 1;
            cArr[i14] = c8;
            return i14 + 1;
        }
        return i9;
    }
}
