package kotlin.text;

import kotlin.ranges.IntRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharJVM.kt */
/* loaded from: classes5.dex */
public class CharsKt__CharJVMKt {
    public static int a(int i8) {
        if (new IntRange(2, 36).o(i8)) {
            return i8;
        }
        throw new IllegalArgumentException("radix " + i8 + " was not in valid range " + new IntRange(2, 36));
    }

    public static final int b(char c8, int i8) {
        return Character.digit((int) c8, i8);
    }

    public static boolean c(char c8) {
        if (!Character.isWhitespace(c8) && !Character.isSpaceChar(c8)) {
            return false;
        }
        return true;
    }
}
