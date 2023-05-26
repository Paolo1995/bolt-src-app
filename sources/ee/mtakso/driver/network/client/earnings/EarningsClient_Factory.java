package ee.mtakso.driver.network.client.earnings;

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
public final class EarningsClient_Factory implements Factory<EarningsClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsApi> f22102a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f22103b;

    public EarningsClient_Factory(Provider<EarningsApi> provider, Provider<CompositeResponseTransformer> provider2) {
        this.f22102a = provider;
        this.f22103b = provider2;
    }

    public static EarningsClient_Factory a(Provider<EarningsApi> provider, Provider<CompositeResponseTransformer> provider2) {
        return new EarningsClient_Factory(provider, provider2);
    }

    public static EarningsClient c(Lazy<EarningsApi> lazy, CompositeResponseTransformer compositeResponseTransformer) {
        return new EarningsClient(lazy, compositeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsClient get() {
        return c(DoubleCheck.lazy(this.f22102a), this.f22103b.get());
    }
}
