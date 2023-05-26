package ee.mtakso.driver.onboarding.steps;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.AutoStartPermissionHelper;
import ee.mtakso.driver.onboarding.steps.OnBoardingStep;
import ee.mtakso.driver.routing.command.IntentFragmentNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoStartPermissionStep.kt */
/* loaded from: classes3.dex */
public final class AutoStartPermissionStep extends OnBoardingStep {

    /* renamed from: g  reason: collision with root package name */
    private final AppResolver f23033g;

    /* renamed from: h  reason: collision with root package name */
    private final AutoStartPermissionHelper f23034h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public AutoStartPermissionStep(AppResolver appResolver, AutoStartPermissionHelper autoStartPermissionHelper) {
        super(OnBoardingStep.Type.PERMISSION_AUTO_START, null, R.string.onboarding_permission_auto_start_title, R.string.onboarding_permission_auto_start_desc, Integer.valueOf((int) R.string.onboarding_permission_auto_start_steps_styled), Integer.valueOf((int) R.string.onboarding_permission_auto_start_steps), 2, null);
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(autoStartPermissionHelper, "autoStartPermissionHelper");
        this.f23033g = appResolver;
        this.f23034h = autoStartPermissionHelper;
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public NavigationCommand<Fragment> g(int i8) {
        Intent a8 = this.f23034h.a();
        if (a8 == null) {
            return null;
        }
        return new IntentFragmentNavigationCommand(a8, Integer.valueOf(i8), null, 4, null);
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public boolean h() {
        return AutoStartPermissionHelper.f20912b.c(this.f23033g);
    }
}
