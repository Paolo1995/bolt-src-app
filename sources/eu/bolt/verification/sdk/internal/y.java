package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import retrofit2.Retrofit;

/* loaded from: classes5.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private final Retrofit.Builder f45713a;

    /* renamed from: b  reason: collision with root package name */
    private final String f45714b;

    public y(String boltServerUrl, Retrofit.Builder retrofit) {
        Intrinsics.f(boltServerUrl, "boltServerUrl");
        Intrinsics.f(retrofit, "retrofit");
        this.f45713a = retrofit;
        this.f45714b = a(boltServerUrl);
    }

    private final String a(String str) {
        boolean v7;
        v7 = StringsKt__StringsJVMKt.v(str, "/", false, 2, null);
        if (v7) {
            return str;
        }
        return str + "/";
    }
}
