package ee.mtakso.driver.ui.screens.earnings.v2;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import eu.bolt.driver.core.theme.AppThemeManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsActivity_MembersInjector implements MembersInjector<EarningsActivity> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity.appThemeManager")
    public static void a(EarningsActivity earningsActivity, AppThemeManager appThemeManager) {
        earningsActivity.f28495p = appThemeManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity.driverFeatures")
    public static void b(EarningsActivity earningsActivity, DriverFeatures driverFeatures) {
        earningsActivity.f28496q = driverFeatures;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity.driverProvider")
    public static void c(EarningsActivity earningsActivity, DriverProvider driverProvider) {
        earningsActivity.f28494o = driverProvider;
    }
}
