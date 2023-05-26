package androidx.collection;

/* loaded from: classes.dex */
class ContainerHelpers {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f4251a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    static final long[] f4252b = new long[0];

    /* renamed from: c  reason: collision with root package name */
    static final Object[] f4253c = new Object[0];

    private ContainerHelpers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int[] iArr, int i8, int i9) {
        int i10 = i8 - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            int i13 = iArr[i12];
            if (i13 < i9) {
                i11 = i12 + 1;
            } else if (i13 > i9) {
                i10 = i12 - 1;
            } else {
                return i12;
            }
        }
        return ~i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(long[] jArr, int i8, long j8) {
        int i9 = i8 - 1;
        int i10 = 0;
        while (i10 <= i9) {
            int i11 = (i10 + i9) >>> 1;
            int i12 = (jArr[i11] > j8 ? 1 : (jArr[i11] == j8 ? 0 : -1));
            if (i12 < 0) {
                i10 = i11 + 1;
            } else if (i12 > 0) {
                i9 = i11 - 1;
            } else {
                return i11;
            }
        }
        return ~i10;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static int d(int i8) {
        for (int i9 = 4; i9 < 32; i9++) {
            int i10 = (1 << i9) - 12;
            if (i8 <= i10) {
                return i10;
            }
        }
        return i8;
    }

    public static int e(int i8) {
        return d(i8 * 4) / 4;
    }

    public static int f(int i8) {
        return d(i8 * 8) / 8;
    }
}
