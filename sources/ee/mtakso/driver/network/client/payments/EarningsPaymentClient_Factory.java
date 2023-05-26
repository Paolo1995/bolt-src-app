package ee.mtakso.driver.network.client.payments;

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
public final class EarningsPaymentClient_Factory implements Factory<EarningsPaymentClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsPaymentApi> f22652a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f22653b;

    public EarningsPaymentClient_Factory(Provider<EarningsPaymentApi> provider, Provider<CompositeResponseTransformer> provider2) {
        this.f22652a = provider;
        this.f22653b = provider2;
    }

    public static EarningsPaymentClient_Factory a(Provider<EarningsPaymentApi> provider, Provider<CompositeResponseTransformer> provider2) {
        return new EarningsPaymentClient_Factory(provider, provider2);
    }

    public static EarningsPaymentClient c(Lazy<EarningsPaymentApi> lazy, CompositeResponseTransformer compositeResponseTransformer) {
        return new EarningsPaymentClient(lazy, compositeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsPaymentClient get() {
        return c(DoubleCheck.lazy(this.f22652a), this.f22653b.get());
    }
}
