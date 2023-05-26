package kotlin.collections;

/* compiled from: SlidingWindow.kt */
/* loaded from: classes5.dex */
public final class SlidingWindowKt {
    public static final void a(int i8, int i9) {
        boolean z7;
        String str;
        if (i8 > 0 && i9 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            if (i8 != i9) {
                str = "Both size " + i8 + " and step " + i9 + " must be greater than zero.";
            } else {
                str = "size " + i8 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }
}
