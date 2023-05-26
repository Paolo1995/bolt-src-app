package ee.mtakso.driver.ui.screens.earnings.v2.payout.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class PayoutDetailsProgressPageFragment_Factory implements Factory<PayoutDetailsProgressPageFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28681a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PayoutDetailsMapper> f28682b;

    public PayoutDetailsProgressPageFragment_Factory(Provider<BaseUiDependencies> provider, Provider<PayoutDetailsMapper> provider2) {
        this.f28681a = provider;
        this.f28682b = provider2;
    }

    public static PayoutDetailsProgressPageFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<PayoutDetailsMapper> provider2) {
        return new PayoutDetailsProgressPageFragment_Factory(provider, provider2);
    }

    public static PayoutDetailsProgressPageFragment c(BaseUiDependencies baseUiDependencies, PayoutDetailsMapper payoutDetailsMapper) {
        return new PayoutDetailsProgressPageFragment(baseUiDependencies, payoutDetailsMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutDetailsProgressPageFragment get() {
        return c(this.f28681a.get(), this.f28682b.get());
    }
}
