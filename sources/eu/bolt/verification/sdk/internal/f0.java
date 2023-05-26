package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import retrofit2.Retrofit;

/* loaded from: classes5.dex */
public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    private final Retrofit.Builder f42885a;

    /* renamed from: b  reason: collision with root package name */
    private final String f42886b;

    public f0(String boltServerUrl, Retrofit.Builder retrofit) {
        Intrinsics.f(boltServerUrl, "boltServerUrl");
        Intrinsics.f(retrofit, "retrofit");
        this.f42885a = retrofit;
        this.f42886b = d(boltServerUrl);
    }

    private final <T> T b(Class<T> cls, String str) {
        return (T) this.f42885a.baseUrl(str).validateEagerly(true).build().create(cls);
    }

    static /* synthetic */ String c(f0 f0Var, String str, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = f0Var.f42886b;
        }
        return f0Var.e(str, str2);
    }

    private final String d(String str) {
        boolean v7;
        v7 = StringsKt__StringsJVMKt.v(str, "/", false, 2, null);
        if (v7) {
            return str;
        }
        return str + "/";
    }

    private final String e(String str, String str2) {
        boolean L;
        if (str.length() > 0) {
            L = StringsKt__StringsJVMKt.L(str, "/", false, 2, null);
            String d8 = d(str);
            if (L) {
                d8 = d8.substring(1);
                Intrinsics.e(d8, "this as java.lang.String).substring(startIndex)");
            }
            return str2 + d8;
        }
        return str2;
    }

    public final <T> T a(Class<T> apiClass) {
        Intrinsics.f(apiClass, "apiClass");
        g0 g0Var = (g0) apiClass.getAnnotation(g0.class);
        if (g0Var != null) {
            return (T) b(apiClass, c(this, g0Var.name(), null, 2, null));
        }
        String c8 = Reflection.b(g0.class).c();
        throw new IllegalStateException(("Service should be marker with " + c8).toString());
    }
}
