package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Bundle.kt */
/* loaded from: classes.dex */
final class BundleApi21ImplKt {

    /* renamed from: a  reason: collision with root package name */
    public static final BundleApi21ImplKt f5796a = new BundleApi21ImplKt();

    private BundleApi21ImplKt() {
    }

    public static final void a(Bundle bundle, String key, Size size) {
        Intrinsics.f(bundle, "bundle");
        Intrinsics.f(key, "key");
        bundle.putSize(key, size);
    }

    public static final void b(Bundle bundle, String key, SizeF sizeF) {
        Intrinsics.f(bundle, "bundle");
        Intrinsics.f(key, "key");
        bundle.putSizeF(key, sizeF);
    }
}
