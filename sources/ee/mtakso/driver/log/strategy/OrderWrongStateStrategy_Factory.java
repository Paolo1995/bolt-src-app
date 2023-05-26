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
public final class OrderWrongStateStrategy_Factory implements Factory<OrderWrongStateStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LogStorage> f21165a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f21166b;

    public OrderWrongStateStrategy_Factory(Provider<LogStorage> provider, Provider<DriverProvider> provider2) {
        this.f21165a = provider;
        this.f21166b = provider2;
    }

    public static OrderWrongStateStrategy_Factory a(Provider<LogStorage> provider, Provider<DriverProvider> provider2) {
        return new OrderWrongStateStrategy_Factory(provider, provider2);
    }

    public static OrderWrongStateStrategy c(LogStorage logStorage, DriverProvider driverProvider) {
        return new OrderWrongStateStrategy(logStorage, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderWrongStateStrategy get() {
        return c(this.f21165a.get(), this.f21166b.get());
    }
}
