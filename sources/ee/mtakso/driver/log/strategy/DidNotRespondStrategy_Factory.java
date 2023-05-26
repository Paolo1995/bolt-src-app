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
public final class DidNotRespondStrategy_Factory implements Factory<DidNotRespondStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LogStorage> f21145a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f21146b;

    public DidNotRespondStrategy_Factory(Provider<LogStorage> provider, Provider<DriverProvider> provider2) {
        this.f21145a = provider;
        this.f21146b = provider2;
    }

    public static DidNotRespondStrategy_Factory a(Provider<LogStorage> provider, Provider<DriverProvider> provider2) {
        return new DidNotRespondStrategy_Factory(provider, provider2);
    }

    public static DidNotRespondStrategy c(LogStorage logStorage, DriverProvider driverProvider) {
        return new DidNotRespondStrategy(logStorage, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DidNotRespondStrategy get() {
        return c(this.f21145a.get(), this.f21146b.get());
    }
}
