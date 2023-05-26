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
public final class DriverWrongStateStrategy_Factory implements Factory<DriverWrongStateStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LogStorage> f21153a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f21154b;

    public DriverWrongStateStrategy_Factory(Provider<LogStorage> provider, Provider<DriverProvider> provider2) {
        this.f21153a = provider;
        this.f21154b = provider2;
    }

    public static DriverWrongStateStrategy_Factory a(Provider<LogStorage> provider, Provider<DriverProvider> provider2) {
        return new DriverWrongStateStrategy_Factory(provider, provider2);
    }

    public static DriverWrongStateStrategy c(LogStorage logStorage, DriverProvider driverProvider) {
        return new DriverWrongStateStrategy(logStorage, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverWrongStateStrategy get() {
        return c(this.f21153a.get(), this.f21154b.get());
    }
}
