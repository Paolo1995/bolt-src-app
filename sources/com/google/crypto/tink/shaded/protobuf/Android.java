package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
final class Android {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f14972a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f14973b;

    static {
        boolean z7;
        if (a("org.robolectric.Robolectric") != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        f14973b = z7;
    }

    Android() {
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> b() {
        return f14972a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        if (f14972a != null && !f14973b) {
            return true;
        }
        return false;
    }
}
