package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Charsets.kt */
/* loaded from: classes5.dex */
public final class Charsets {

    /* renamed from: a  reason: collision with root package name */
    public static final Charsets f51134a = new Charsets();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f51135b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f51136c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f51137d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f51138e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f51139f;

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f51140g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile Charset f51141h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile Charset f51142i;

    static {
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.e(forName, "forName(\"UTF-8\")");
        f51135b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        Intrinsics.e(forName2, "forName(\"UTF-16\")");
        f51136c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        Intrinsics.e(forName3, "forName(\"UTF-16BE\")");
        f51137d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        Intrinsics.e(forName4, "forName(\"UTF-16LE\")");
        f51138e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        Intrinsics.e(forName5, "forName(\"US-ASCII\")");
        f51139f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        Intrinsics.e(forName6, "forName(\"ISO-8859-1\")");
        f51140g = forName6;
    }

    private Charsets() {
    }

    public final Charset a() {
        Charset charset = f51142i;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32BE");
            Intrinsics.e(forName, "forName(\"UTF-32BE\")");
            f51142i = forName;
            return forName;
        }
        return charset;
    }

    public final Charset b() {
        Charset charset = f51141h;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32LE");
            Intrinsics.e(forName, "forName(\"UTF-32LE\")");
            f51141h = forName;
            return forName;
        }
        return charset;
    }
}
