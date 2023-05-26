package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifecycleOwner.kt */
/* loaded from: classes.dex */
public final class LifecycleOwnerKt {
    public static final LifecycleCoroutineScope a(LifecycleOwner lifecycleOwner) {
        Intrinsics.f(lifecycleOwner, "<this>");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.e(lifecycle, "lifecycle");
        return LifecycleKt.a(lifecycle);
    }
}
