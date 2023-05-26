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
public final class PayoutClient_Factory implements Factory<PayoutClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PayoutApi> f22139a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f22140b;

    public PayoutClient_Factory(Provider<PayoutApi> provider, Provider<CompositeResponseTransformer> provider2) {
        this.f22139a = provider;
        this.f22140b = provider2;
    }

    public static PayoutClient_Factory a(Provider<PayoutApi> provider, Provider<CompositeResponseTransformer> provider2) {
        return new PayoutClient_Factory(provider, provider2);
    }

    public static PayoutClient c(Lazy<PayoutApi> lazy, CompositeResponseTransformer compositeResponseTransformer) {
        return new PayoutClient(lazy, compositeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutClient get() {
        return c(DoubleCheck.lazy(this.f22139a), this.f22140b.get());
    }
}
