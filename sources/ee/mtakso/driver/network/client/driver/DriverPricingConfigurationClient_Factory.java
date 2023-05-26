package ee.mtakso.driver.network.client.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverPricingConfigurationClient_Factory implements Factory<DriverPricingConfigurationClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverPricingConfigurationApi> f21955a;

    public DriverPricingConfigurationClient_Factory(Provider<DriverPricingConfigurationApi> provider) {
        this.f21955a = provider;
    }

    public static DriverPricingConfigurationClient_Factory a(Provider<DriverPricingConfigurationApi> provider) {
        return new DriverPricingConfigurationClient_Factory(provider);
    }

    public static DriverPricingConfigurationClient c(DriverPricingConfigurationApi driverPricingConfigurationApi) {
        return new DriverPricingConfigurationClient(driverPricingConfigurationApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverPricingConfigurationClient get() {
        return c(this.f21955a.get());
    }
}
