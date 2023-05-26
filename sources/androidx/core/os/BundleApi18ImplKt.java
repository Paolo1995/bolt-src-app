package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Bundle.kt */
/* loaded from: classes.dex */
final class BundleApi18ImplKt {

    /* renamed from: a  reason: collision with root package name */
    public static final BundleApi18ImplKt f5795a = new BundleApi18ImplKt();

    private BundleApi18ImplKt() {
    }

    public static final void a(Bundle bundle, String key, IBinder iBinder) {
        Intrinsics.f(bundle, "bundle");
        Intrinsics.f(key, "key");
        bundle.putBinder(key, iBinder);
    }
}
