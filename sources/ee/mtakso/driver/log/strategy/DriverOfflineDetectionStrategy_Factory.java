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
public final class DriverOfflineDetectionStrategy_Factory implements Factory<DriverOfflineDetectionStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LogStorage> f21149a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f21150b;

    public DriverOfflineDetectionStrategy_Factory(Provider<LogStorage> provider, Provider<DriverProvider> provider2) {
        this.f21149a = provider;
        this.f21150b = provider2;
    }

    public static DriverOfflineDetectionStrategy_Factory a(Provider<LogStorage> provider, Provider<DriverProvider> provider2) {
        return new DriverOfflineDetectionStrategy_Factory(provider, provider2);
    }

    public static DriverOfflineDetectionStrategy c(LogStorage logStorage, DriverProvider driverProvider) {
        return new DriverOfflineDetectionStrategy(logStorage, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverOfflineDetectionStrategy get() {
        return c(this.f21149a.get(), this.f21150b.get());
    }
}
