package ee.mtakso.driver.log.strategy;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.storage.LogStorage;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderStateStrategy_Factory implements Factory<OrderStateStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f21161a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LogStorage> f21162b;

    public OrderStateStrategy_Factory(Provider<DriverProvider> provider, Provider<LogStorage> provider2) {
        this.f21161a = provider;
        this.f21162b = provider2;
    }

    public static OrderStateStrategy_Factory a(Provider<DriverProvider> provider, Provider<LogStorage> provider2) {
        return new OrderStateStrategy_Factory(provider, provider2);
    }

    public static OrderStateStrategy c(DriverProvider driverProvider, LogStorage logStorage) {
        return new OrderStateStrategy(driverProvider, logStorage);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderStateStrategy get() {
        return c(this.f21161a.get(), this.f21162b.get());
    }
}
