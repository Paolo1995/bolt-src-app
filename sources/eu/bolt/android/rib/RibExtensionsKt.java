package eu.bolt.android.rib;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RibExtensions.kt */
/* loaded from: classes5.dex */
public final class RibExtensionsKt {
    public static final void a(Router router, Bundle bundle) {
        Intrinsics.f(router, "<this>");
        router.h(bundle);
        router.l();
    }

    public static final <T extends Serializable> T b(Bundle bundle, String key) {
        Intrinsics.f(bundle, "<this>");
        Intrinsics.f(key, "key");
        T t7 = (T) bundle.e().getSerializable(key);
        if (!(t7 instanceof Serializable)) {
            return null;
        }
        return t7;
    }
}
