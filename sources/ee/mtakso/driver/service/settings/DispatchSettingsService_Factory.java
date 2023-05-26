package ee.mtakso.driver.service.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DispatchSettingsService_Factory implements Factory<DispatchSettingsService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f25983a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PollerSource> f25984b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DispatchSettingsManager> f25985c;

    public DispatchSettingsService_Factory(Provider<DriverStatusProvider> provider, Provider<PollerSource> provider2, Provider<DispatchSettingsManager> provider3) {
        this.f25983a = provider;
        this.f25984b = provider2;
        this.f25985c = provider3;
    }

    public static DispatchSettingsService_Factory a(Provider<DriverStatusProvider> provider, Provider<PollerSource> provider2, Provider<DispatchSettingsManager> provider3) {
        return new DispatchSettingsService_Factory(provider, provider2, provider3);
    }

    public static DispatchSettingsService c(DriverStatusProvider driverStatusProvider, PollerSource pollerSource, DispatchSettingsManager dispatchSettingsManager) {
        return new DispatchSettingsService(driverStatusProvider, pollerSource, dispatchSettingsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DispatchSettingsService get() {
        return c(this.f25983a.get(), this.f25984b.get(), this.f25985c.get());
    }
}
