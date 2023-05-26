package p7;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes5.dex */
public final /* synthetic */ class g {
    public static /* synthetic */ String a(long j8, int i8) {
        int i9 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i9 == 0) {
            return "0";
        }
        if (i9 > 0) {
            return Long.toString(j8, i8);
        }
        i8 = (i8 < 2 || i8 > 36) ? 10 : 10;
        int i10 = 64;
        char[] cArr = new char[64];
        int i11 = i8 - 1;
        if ((i8 & i11) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i8);
            do {
                i10--;
                cArr[i10] = Character.forDigit(((int) j8) & i11, i8);
                j8 >>>= numberOfTrailingZeros;
            } while (j8 != 0);
        } else {
            long a8 = (i8 & 1) == 0 ? (j8 >>> 1) / (i8 >>> 1) : kotlin.text.c.a(j8, i8);
            long j9 = i8;
            i10 = 63;
            cArr[63] = Character.forDigit((int) (j8 - (a8 * j9)), i8);
            while (a8 > 0) {
                i10--;
                cArr[i10] = Character.forDigit((int) (a8 % j9), i8);
                a8 /= j9;
            }
        }
        return new String(cArr, i10, 64 - i10);
    }
}
