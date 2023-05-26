package ee.mtakso.driver.log.strategy;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.log.storage.LogStorage;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LocationStrategy_Factory implements Factory<LocationStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LogStorage> f21157a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Features> f21158b;

    public LocationStrategy_Factory(Provider<LogStorage> provider, Provider<Features> provider2) {
        this.f21157a = provider;
        this.f21158b = provider2;
    }

    public static LocationStrategy_Factory a(Provider<LogStorage> provider, Provider<Features> provider2) {
        return new LocationStrategy_Factory(provider, provider2);
    }

    public static LocationStrategy c(LogStorage logStorage, Features features) {
        return new LocationStrategy(logStorage, features);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocationStrategy get() {
        return c(this.f21157a.get(), this.f21158b.get());
    }
}
