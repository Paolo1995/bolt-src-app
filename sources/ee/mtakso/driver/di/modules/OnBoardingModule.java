package ee.mtakso.driver.di.modules;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ee.mtakso.driver.onboarding.steps.AutoStartPermissionStep;
import ee.mtakso.driver.onboarding.steps.BatteryExclusionPermissionStep;
import ee.mtakso.driver.onboarding.steps.NotificationPermissionStep;
import ee.mtakso.driver.onboarding.steps.NotificationSoundStep;
import ee.mtakso.driver.onboarding.steps.OnBoardingStep;
import ee.mtakso.driver.onboarding.steps.OtherPermissionsStep;
import ee.mtakso.driver.onboarding.steps.OverlayPermissionStep;
import ee.mtakso.driver.onboarding.steps.RecordAudioPermissionStep;

/* compiled from: OnBoardingModule.kt */
@Module
/* loaded from: classes3.dex */
public interface OnBoardingModule {
    @Binds
    @IntoMap
    OnBoardingStep a(NotificationPermissionStep notificationPermissionStep);

    @Binds
    @IntoMap
    OnBoardingStep b(RecordAudioPermissionStep recordAudioPermissionStep);

    @Binds
    @IntoMap
    OnBoardingStep c(BatteryExclusionPermissionStep batteryExclusionPermissionStep);

    @Binds
    @IntoMap
    OnBoardingStep d(AutoStartPermissionStep autoStartPermissionStep);

    @Binds
    @IntoMap
    OnBoardingStep e(NotificationSoundStep notificationSoundStep);

    @Binds
    @IntoMap
    OnBoardingStep f(OverlayPermissionStep overlayPermissionStep);

    @Binds
    @IntoMap
    OnBoardingStep g(OtherPermissionsStep otherPermissionsStep);
}
