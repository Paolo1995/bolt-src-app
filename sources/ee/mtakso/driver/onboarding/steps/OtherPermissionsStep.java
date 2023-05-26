package ee.mtakso.driver.onboarding.steps;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.OtherPermissionHelper;
import ee.mtakso.driver.onboarding.steps.OnBoardingStep;
import ee.mtakso.driver.routing.command.IntentFragmentNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OtherPermissionsStep.kt */
/* loaded from: classes3.dex */
public final class OtherPermissionsStep extends OnBoardingStep {

    /* renamed from: g  reason: collision with root package name */
    private final Context f23059g;

    /* renamed from: h  reason: collision with root package name */
    private final AppResolver f23060h;

    /* renamed from: i  reason: collision with root package name */
    private final OtherPermissionHelper f23061i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OtherPermissionsStep(Context context, AppResolver appResolver, OtherPermissionHelper otherPermissionHelper) {
        super(OnBoardingStep.Type.PERMISSION_OTHER, null, R.string.onboarding_permission_other_permissions_title, R.string.onboarding_permission_other_permissions_desc, null, null, 50, null);
        Intrinsics.f(context, "context");
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(otherPermissionHelper, "otherPermissionHelper");
        this.f23059g = context;
        this.f23060h = appResolver;
        this.f23061i = otherPermissionHelper;
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public NavigationCommand<Fragment> g(int i8) {
        Intent a8 = this.f23061i.a();
        if (a8 == null) {
            return null;
        }
        return new IntentFragmentNavigationCommand(a8, Integer.valueOf(i8), null, 4, null);
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public boolean h() {
        OtherPermissionHelper.Companion companion = OtherPermissionHelper.f20957c;
        String packageName = this.f23059g.getPackageName();
        Intrinsics.e(packageName, "context.packageName");
        return companion.c(packageName, this.f23060h);
    }
}
