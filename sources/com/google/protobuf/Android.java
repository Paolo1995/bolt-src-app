package com.google.protobuf;

/* loaded from: classes3.dex */
final class Android {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f17155a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f17156b = a("libcore.io.Memory");

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f17157c;

    static {
        boolean z7;
        if (!f17155a && a("org.robolectric.Robolectric") != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        f17157c = z7;
    }

    private Android() {
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
        return f17156b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        if (!f17155a && (f17156b == null || f17157c)) {
            return false;
        }
        return true;
    }
}
