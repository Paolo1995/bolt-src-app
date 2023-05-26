package ee.mtakso.driver.uicore.utils;

import android.os.Build;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialogFragmentExt.kt */
/* loaded from: classes5.dex */
public final class FragmentUtils {
    private static final boolean a(FragmentActivity fragmentActivity) {
        if (!fragmentActivity.isFinishing() && fragmentActivity.getLifecycle().b().a(Lifecycle.State.CREATED)) {
            return false;
        }
        return true;
    }

    public static final void b(DialogFragment dialogFragment, Fragment fragment, String fragmentTag) {
        Intrinsics.f(dialogFragment, "<this>");
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(fragmentTag, "fragmentTag");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null || a(activity)) {
            return;
        }
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.e(childFragmentManager, "fragment.childFragmentManager");
        d(dialogFragment, childFragmentManager, fragmentTag);
    }

    public static final void c(DialogFragment dialogFragment, FragmentActivity activity, String fragmentTag) {
        Intrinsics.f(dialogFragment, "<this>");
        Intrinsics.f(activity, "activity");
        Intrinsics.f(fragmentTag, "fragmentTag");
        if (a(activity)) {
            return;
        }
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.e(supportFragmentManager, "activity.supportFragmentManager");
        d(dialogFragment, supportFragmentManager, fragmentTag);
    }

    private static final void d(DialogFragment dialogFragment, FragmentManager fragmentManager, String str) {
        if (!fragmentManager.isStateSaved() && !fragmentManager.isDestroyed()) {
            try {
                if (Build.VERSION.SDK_INT == 26) {
                    dialogFragment.showNow(fragmentManager, str);
                } else {
                    dialogFragment.show(fragmentManager, str);
                }
            } catch (IllegalStateException unused) {
            }
        }
    }
}
