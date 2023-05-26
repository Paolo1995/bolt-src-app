package io.ktor.util;

/* compiled from: PlatformUtilsJvm.kt */
/* loaded from: classes5.dex */
public final class PlatformUtils {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f47050b = false;

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f47052d;

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f47053e;

    /* renamed from: a  reason: collision with root package name */
    public static final PlatformUtils f47049a = new PlatformUtils();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f47051c = true;

    static {
        String property = System.getProperty("io.ktor.development");
        boolean z7 = false;
        if (property != null && Boolean.parseBoolean(property)) {
            z7 = true;
        }
        f47052d = z7;
        f47053e = true;
    }

    private PlatformUtils() {
    }

    public final boolean a() {
        return f47050b;
    }

    public final boolean b() {
        return f47052d;
    }
}
