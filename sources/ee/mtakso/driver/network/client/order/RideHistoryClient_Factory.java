package ee.mtakso.driver.network.client.order;

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
public final class RideHistoryClient_Factory implements Factory<RideHistoryClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RideHistoryApi> f22551a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f22552b;

    public RideHistoryClient_Factory(Provider<RideHistoryApi> provider, Provider<CompositeResponseTransformer> provider2) {
        this.f22551a = provider;
        this.f22552b = provider2;
    }

    public static RideHistoryClient_Factory a(Provider<RideHistoryApi> provider, Provider<CompositeResponseTransformer> provider2) {
        return new RideHistoryClient_Factory(provider, provider2);
    }

    public static RideHistoryClient c(Lazy<RideHistoryApi> lazy, CompositeResponseTransformer compositeResponseTransformer) {
        return new RideHistoryClient(lazy, compositeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RideHistoryClient get() {
        return c(DoubleCheck.lazy(this.f22551a), this.f22552b.get());
    }
}
