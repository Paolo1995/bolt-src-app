package ee.mtakso.driver.ui.screens.home.v3.delegate;

import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingActivity;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBoardingDelegate.kt */
/* loaded from: classes3.dex */
public final class OnBoardingDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final OnBoardingManager f29881a;

    @Inject
    public OnBoardingDelegate(OnBoardingManager onBoardingManager) {
        Intrinsics.f(onBoardingManager, "onBoardingManager");
        this.f29881a = onBoardingManager;
    }

    public final boolean a(FragmentActivity activity) {
        Intrinsics.f(activity, "activity");
        if (this.f29881a.c()) {
            activity.startActivity(PermissionOnboardingActivity.f32475r.a(activity));
            return true;
        }
        return false;
    }
}
