package androidx.savedstate;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewTreeSavedStateRegistryOwner.kt */
/* loaded from: classes.dex */
public final class ViewTreeSavedStateRegistryOwner {
    public static final void a(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.f(view, "<this>");
        view.setTag(R$id.f7696a, savedStateRegistryOwner);
    }
}
