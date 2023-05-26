package ee.mtakso.driver.log.strategy.memory;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.applog.ApplogUploader;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderStateStrategy_Factory implements Factory<OrderStateStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ApplogUploader> f21177a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f21178b;

    public OrderStateStrategy_Factory(Provider<ApplogUploader> provider, Provider<DriverProvider> provider2) {
        this.f21177a = provider;
        this.f21178b = provider2;
    }

    public static OrderStateStrategy_Factory a(Provider<ApplogUploader> provider, Provider<DriverProvider> provider2) {
        return new OrderStateStrategy_Factory(provider, provider2);
    }

    public static OrderStateStrategy c(ApplogUploader applogUploader, DriverProvider driverProvider) {
        return new OrderStateStrategy(applogUploader, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderStateStrategy get() {
        return c(this.f21177a.get(), this.f21178b.get());
    }
}
