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
public final class ActivityLifecycleStrategy_Factory implements Factory<ActivityLifecycleStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LogStorage> f21123a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f21124b;

    public ActivityLifecycleStrategy_Factory(Provider<LogStorage> provider, Provider<DriverProvider> provider2) {
        this.f21123a = provider;
        this.f21124b = provider2;
    }

    public static ActivityLifecycleStrategy_Factory a(Provider<LogStorage> provider, Provider<DriverProvider> provider2) {
        return new ActivityLifecycleStrategy_Factory(provider, provider2);
    }

    public static ActivityLifecycleStrategy c(LogStorage logStorage, DriverProvider driverProvider) {
        return new ActivityLifecycleStrategy(logStorage, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ActivityLifecycleStrategy get() {
        return c(this.f21123a.get(), this.f21124b.get());
    }
}
