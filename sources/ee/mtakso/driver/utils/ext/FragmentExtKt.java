package ee.mtakso.driver.utils.ext;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.ui.screens.login.v2.Router;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentExt.kt */
/* loaded from: classes5.dex */
public final class FragmentExtKt {
    public static final Router a(Fragment fragment) {
        Intrinsics.f(fragment, "<this>");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.d(requireActivity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.login.v2.Router");
        return (Router) requireActivity;
    }
}
