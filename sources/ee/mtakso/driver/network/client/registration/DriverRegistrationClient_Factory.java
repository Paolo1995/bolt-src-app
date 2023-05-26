package ee.mtakso.driver.network.client.registration;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverRegistrationClient_Factory implements Factory<DriverRegistrationClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverRegistrationApi> f22699a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f22700b;

    public DriverRegistrationClient_Factory(Provider<DriverRegistrationApi> provider, Provider<CompositeResponseTransformer> provider2) {
        this.f22699a = provider;
        this.f22700b = provider2;
    }

    public static DriverRegistrationClient_Factory a(Provider<DriverRegistrationApi> provider, Provider<CompositeResponseTransformer> provider2) {
        return new DriverRegistrationClient_Factory(provider, provider2);
    }

    public static DriverRegistrationClient c(Lazy<DriverRegistrationApi> lazy, CompositeResponseTransformer compositeResponseTransformer) {
        return new DriverRegistrationClient(lazy, compositeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverRegistrationClient get() {
        return c(DoubleCheck.lazy(this.f22699a), this.f22700b.get());
    }
}
