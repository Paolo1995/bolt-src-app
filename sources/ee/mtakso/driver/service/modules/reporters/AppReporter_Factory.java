package ee.mtakso.driver.service.modules.reporters;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AppReporter_Factory implements Factory<AppReporter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f25224a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppStateAnalytics> f25225b;

    public AppReporter_Factory(Provider<TrueTimeProvider> provider, Provider<AppStateAnalytics> provider2) {
        this.f25224a = provider;
        this.f25225b = provider2;
    }

    public static AppReporter_Factory a(Provider<TrueTimeProvider> provider, Provider<AppStateAnalytics> provider2) {
        return new AppReporter_Factory(provider, provider2);
    }

    public static AppReporter c(TrueTimeProvider trueTimeProvider, AppStateAnalytics appStateAnalytics) {
        return new AppReporter(trueTimeProvider, appStateAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AppReporter get() {
        return c(this.f25224a.get(), this.f25225b.get());
    }
}
