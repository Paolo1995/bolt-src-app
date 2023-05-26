package ee.mtakso.driver.onboarding.steps;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.CustomNotificationManagerHelper;
import ee.mtakso.driver.onboarding.steps.OnBoardingStep;
import ee.mtakso.driver.routing.command.IntentFragmentNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationPermissionStep.kt */
/* loaded from: classes3.dex */
public final class NotificationPermissionStep extends OnBoardingStep {

    /* renamed from: g  reason: collision with root package name */
    private final Context f23037g;

    /* renamed from: h  reason: collision with root package name */
    private final AppResolver f23038h;

    /* renamed from: i  reason: collision with root package name */
    private final CustomNotificationManagerHelper f23039i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NotificationPermissionStep(Context context, AppResolver appResolver, CustomNotificationManagerHelper customNotificationManagerHelper) {
        super(OnBoardingStep.Type.PERMISSION_NOTIFICATION, null, R.string.onboarding_permission_custom_notifications_title, R.string.onboarding_permission_custom_notifications_desc, Integer.valueOf((int) R.string.onboarding_permission_custom_notifications_steps_styled), Integer.valueOf((int) R.string.onboarding_permission_custom_notifications_steps), 2, null);
        Intrinsics.f(context, "context");
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(customNotificationManagerHelper, "customNotificationManagerHelper");
        this.f23037g = context;
        this.f23038h = appResolver;
        this.f23039i = customNotificationManagerHelper;
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public NavigationCommand<Fragment> g(int i8) {
        Intent a8 = this.f23039i.a();
        if (a8 == null) {
            return null;
        }
        return new IntentFragmentNavigationCommand(a8, Integer.valueOf(i8), null, 4, null);
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public boolean h() {
        CustomNotificationManagerHelper.Companion companion = CustomNotificationManagerHelper.f20940c;
        String packageName = this.f23037g.getPackageName();
        Intrinsics.e(packageName, "context.packageName");
        return companion.c(packageName, this.f23038h);
    }
}
