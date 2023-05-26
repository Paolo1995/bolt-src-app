package j$.time.format;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class z {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f50060a = {1, 2, 3, 4, 5};

    public static /* synthetic */ int a(int i8) {
        if (i8 != 0) {
            return i8 - 1;
        }
        throw null;
    }

    public static /* synthetic */ String b(int i8) {
        return i8 == 1 ? "NORMAL" : i8 == 2 ? "ALWAYS" : i8 == 3 ? "NEVER" : i8 == 4 ? "NOT_NEGATIVE" : i8 == 5 ? "EXCEEDS_PAD" : "null";
    }

    public static /* synthetic */ int[] c(int i8) {
        int[] iArr = new int[i8];
        System.arraycopy(f50060a, 0, iArr, 0, i8);
        return iArr;
    }
}
