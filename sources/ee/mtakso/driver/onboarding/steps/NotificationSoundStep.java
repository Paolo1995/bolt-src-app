package ee.mtakso.driver.onboarding.steps;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.NotificationSoundPermissionHelper;
import ee.mtakso.driver.onboarding.steps.OnBoardingStep;
import ee.mtakso.driver.routing.command.IntentFragmentNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationSoundStep.kt */
/* loaded from: classes3.dex */
public final class NotificationSoundStep extends OnBoardingStep {

    /* renamed from: g  reason: collision with root package name */
    private final NotificationSoundPermissionHelper f23040g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NotificationSoundStep(NotificationSoundPermissionHelper notificationSoundPermissionHelper) {
        super(OnBoardingStep.Type.PERMISSION_NOTIFICATION_SOUND, null, R.string.onboarding_permission_notification_sound_title, R.string.onboarding_permission_notification_sound_desc, Integer.valueOf((int) R.string.onboarding_permission_notification_sound_steps_styled), Integer.valueOf((int) R.string.onboarding_permission_notification_sound_steps), 2, null);
        Intrinsics.f(notificationSoundPermissionHelper, "notificationSoundPermissionHelper");
        this.f23040g = notificationSoundPermissionHelper;
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public NavigationCommand<Fragment> g(int i8) {
        Intent b8 = this.f23040g.b();
        if (b8 == null) {
            return null;
        }
        return new IntentFragmentNavigationCommand(b8, Integer.valueOf(i8), null, 4, null);
    }

    @Override // ee.mtakso.driver.onboarding.steps.OnBoardingStep
    public boolean h() {
        return this.f23040g.d();
    }
}
