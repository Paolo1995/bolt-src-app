package ee.mtakso.driver.service.analytics.controller;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.AnalyticsManager;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MixpanelController_Factory implements Factory<MixpanelController> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f23447a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Context> f23448b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AnalyticsManager> f23449c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<TimedAnalyticsManager> f23450d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<LanguageManager> f23451e;

    public MixpanelController_Factory(Provider<DriverProvider> provider, Provider<Context> provider2, Provider<AnalyticsManager> provider3, Provider<TimedAnalyticsManager> provider4, Provider<LanguageManager> provider5) {
        this.f23447a = provider;
        this.f23448b = provider2;
        this.f23449c = provider3;
        this.f23450d = provider4;
        this.f23451e = provider5;
    }

    public static MixpanelController_Factory a(Provider<DriverProvider> provider, Provider<Context> provider2, Provider<AnalyticsManager> provider3, Provider<TimedAnalyticsManager> provider4, Provider<LanguageManager> provider5) {
        return new MixpanelController_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static MixpanelController c(DriverProvider driverProvider, Context context, AnalyticsManager analyticsManager, TimedAnalyticsManager timedAnalyticsManager, LanguageManager languageManager) {
        return new MixpanelController(driverProvider, context, analyticsManager, timedAnalyticsManager, languageManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MixpanelController get() {
        return c(this.f23447a.get(), this.f23448b.get(), this.f23449c.get(), this.f23450d.get(), this.f23451e.get());
    }
}
