package androidx.fragment.app;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: View.kt */
/* loaded from: classes.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View findFragment) {
        Intrinsics.f(findFragment, "$this$findFragment");
        F f8 = (F) FragmentManager.findFragment(findFragment);
        Intrinsics.e(f8, "FragmentManager.findFragment(this)");
        return f8;
    }
}
