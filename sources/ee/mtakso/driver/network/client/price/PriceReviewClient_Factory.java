package ee.mtakso.driver.network.client.price;

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
public final class PriceReviewClient_Factory implements Factory<PriceReviewClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PriceReviewApi> f22658a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f22659b;

    public PriceReviewClient_Factory(Provider<PriceReviewApi> provider, Provider<CompositeResponseTransformer> provider2) {
        this.f22658a = provider;
        this.f22659b = provider2;
    }

    public static PriceReviewClient_Factory a(Provider<PriceReviewApi> provider, Provider<CompositeResponseTransformer> provider2) {
        return new PriceReviewClient_Factory(provider, provider2);
    }

    public static PriceReviewClient c(Lazy<PriceReviewApi> lazy, CompositeResponseTransformer compositeResponseTransformer) {
        return new PriceReviewClient(lazy, compositeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PriceReviewClient get() {
        return c(DoubleCheck.lazy(this.f22658a), this.f22659b.get());
    }
}
