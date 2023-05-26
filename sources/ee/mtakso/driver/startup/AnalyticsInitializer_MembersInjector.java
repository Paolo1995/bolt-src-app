package ee.mtakso.driver.startup;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.service.analytics.controller.MixpanelController;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AnalyticsInitializer_MembersInjector implements MembersInjector<AnalyticsInitializer> {
    @InjectedFieldSignature("ee.mtakso.driver.startup.AnalyticsInitializer.appsflyerManager")
    public static void a(AnalyticsInitializer analyticsInitializer, AppsflyerManager appsflyerManager) {
        analyticsInitializer.f26218b = appsflyerManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.startup.AnalyticsInitializer.mixpanelController")
    public static void b(AnalyticsInitializer analyticsInitializer, MixpanelController mixpanelController) {
        analyticsInitializer.f26217a = mixpanelController;
    }
}
