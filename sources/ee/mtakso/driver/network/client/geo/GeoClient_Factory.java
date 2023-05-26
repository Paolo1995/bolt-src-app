package ee.mtakso.driver.network.client.geo;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GeoClient_Factory implements Factory<GeoClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoApi> f22256a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f22257b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f22258c;

    public GeoClient_Factory(Provider<GeoApi> provider, Provider<DriverProvider> provider2, Provider<CompositeResponseTransformer> provider3) {
        this.f22256a = provider;
        this.f22257b = provider2;
        this.f22258c = provider3;
    }

    public static GeoClient_Factory a(Provider<GeoApi> provider, Provider<DriverProvider> provider2, Provider<CompositeResponseTransformer> provider3) {
        return new GeoClient_Factory(provider, provider2, provider3);
    }

    public static GeoClient c(Lazy<GeoApi> lazy, DriverProvider driverProvider, CompositeResponseTransformer compositeResponseTransformer) {
        return new GeoClient(lazy, driverProvider, compositeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GeoClient get() {
        return c(DoubleCheck.lazy(this.f22256a), this.f22257b.get(), this.f22258c.get());
    }
}
