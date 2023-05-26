package ee.mtakso.driver.ui.screens.dialogs.rateme;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RateMeDialog_MembersInjector implements MembersInjector<RateMeDialog> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog.driverProvider")
    public static void a(RateMeDialog rateMeDialog, DriverProvider driverProvider) {
        rateMeDialog.f28353m = driverProvider;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog.features")
    public static void b(RateMeDialog rateMeDialog, Features features) {
        rateMeDialog.f28355o = features;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog.platformManager")
    public static void c(RateMeDialog rateMeDialog, PlatformManager platformManager) {
        rateMeDialog.f28356p = platformManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog.rateMeAnalytics")
    public static void d(RateMeDialog rateMeDialog, RateMeAnalytics rateMeAnalytics) {
        rateMeDialog.f28354n = rateMeAnalytics;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog.rateMePrefsManager")
    public static void e(RateMeDialog rateMeDialog, RateMePrefsManager rateMePrefsManager) {
        rateMeDialog.f28352l = rateMePrefsManager;
    }
}
