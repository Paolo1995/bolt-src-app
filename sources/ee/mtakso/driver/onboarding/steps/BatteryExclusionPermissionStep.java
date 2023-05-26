package ee.mtakso.driver.onboarding.steps;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.onboarding.steps.OnBoardingStep;
import ee.mtakso.driver.routing.command.IntentFragmentNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BatteryExclusionPermissionStep.kt */
/* loaded from: classes3.dex */
public final class BatteryExclusionPermissionStep extends OnBoardingStep {

    /* renamed from: g  reason: collision with root package name */
    private final Context f23035g;

    /* renamed from: h  reason: collision with root package name */
    private final PowerManager f23036h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public BatteryExclusionPermissionStep(Context context, PowerManager powerManager) {
        super(OnBoardingStep.Type.PERMISSION_BATTERY_EXCLUSION, null, R.string.onboarding_permission_battery_title, R.string.onboarding_permission_battery_desc, Integer.valueOf((int) R.string.onboarding_permission_battery_steps_styled), Integer.valueOf((int) R.string.onboarding_permission_battery_steps), 2, null);
        Intrinsics.f(context, "context");
        Intrinsics.f(powerManager, "powerManager");
        this.f23035g = context;
        this.f23036h = powerManager;
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public NavigationCommand<Fragment> g(int i8) {
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        return new IntentFragmentNavigationCommand(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"), Integer.valueOf(i8), null, 4, null);
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public boolean h() {
        boolean isIgnoringBatteryOptimizations;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        isIgnoringBatteryOptimizations = this.f23036h.isIgnoringBatteryOptimizations(this.f23035g.getPackageName());
        if (isIgnoringBatteryOptimizations || new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS").resolveActivity(this.f23035g.getPackageManager()) == null) {
            return false;
        }
        return true;
    }
}
