package io.netty.util.internal;

/* loaded from: classes5.dex */
final class NativeLibraryUtil {
    private NativeLibraryUtil() {
    }

    public static void loadLibrary(String str, boolean z7) {
        if (z7) {
            System.load(str);
        } else {
            System.loadLibrary(str);
        }
    }
}
