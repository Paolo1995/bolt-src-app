package ee.mtakso.driver.onboarding.steps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.routing.command.IntentFragmentNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;

/* compiled from: OverlayPermissionStep.kt */
/* loaded from: classes3.dex */
public final class OverlayPermissionStep extends OnBoardingStep {

    /* renamed from: g  reason: collision with root package name */
    private final Context f23062g;

    /* JADX WARN: Illegal instructions before constructor call */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public OverlayPermissionStep(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            ee.mtakso.driver.onboarding.steps.OnBoardingStep$Type r2 = ee.mtakso.driver.onboarding.steps.OnBoardingStep.Type.PERMISSION_OVERLAY
            java.lang.String r0 = "activity"
            java.lang.Object r0 = r9.getSystemService(r0)
            java.lang.String r1 = "null cannot be cast to non-null type android.app.ActivityManager"
            kotlin.jvm.internal.Intrinsics.d(r0, r1)
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0
            boolean r0 = r0.isLowRamDevice()
            if (r0 == 0) goto L1d
            ee.mtakso.driver.onboarding.steps.OnBoardingStep$Severity r0 = ee.mtakso.driver.onboarding.steps.OnBoardingStep.Severity.OPTIONAL
            goto L1f
        L1d:
            ee.mtakso.driver.onboarding.steps.OnBoardingStep$Severity r0 = ee.mtakso.driver.onboarding.steps.OnBoardingStep.Severity.MANDATORY
        L1f:
            r3 = r0
            r4 = 2131953510(0x7f130766, float:1.9543493E38)
            r5 = 2131953507(0x7f130763, float:1.9543487E38)
            r0 = 2131953509(0x7f130765, float:1.954349E38)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            r0 = 2131953508(0x7f130764, float:1.9543489E38)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.f23062g = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.onboarding.steps.OverlayPermissionStep.<init>(android.content.Context):void");
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public NavigationCommand<Fragment> g(int i8) {
        if (Build.VERSION.SDK_INT >= 23) {
            String packageName = this.f23062g.getPackageName();
            return new IntentFragmentNavigationCommand(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + packageName)), Integer.valueOf(i8), null, 4, null);
        }
        return null;
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public boolean h() {
        boolean canDrawOverlays;
        if (Build.VERSION.SDK_INT >= 23) {
            canDrawOverlays = Settings.canDrawOverlays(this.f23062g);
            if (!canDrawOverlays) {
                return true;
            }
        }
        return false;
    }
}
