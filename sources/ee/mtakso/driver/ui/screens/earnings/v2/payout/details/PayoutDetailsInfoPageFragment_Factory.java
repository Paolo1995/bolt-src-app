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
public final class PayoutDetailsInfoPageFragment_Factory implements Factory<PayoutDetailsInfoPageFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28671a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PayoutDetailsMapper> f28672b;

    public PayoutDetailsInfoPageFragment_Factory(Provider<BaseUiDependencies> provider, Provider<PayoutDetailsMapper> provider2) {
        this.f28671a = provider;
        this.f28672b = provider2;
    }

    public static PayoutDetailsInfoPageFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<PayoutDetailsMapper> provider2) {
        return new PayoutDetailsInfoPageFragment_Factory(provider, provider2);
    }

    public static PayoutDetailsInfoPageFragment c(BaseUiDependencies baseUiDependencies, PayoutDetailsMapper payoutDetailsMapper) {
        return new PayoutDetailsInfoPageFragment(baseUiDependencies, payoutDetailsMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutDetailsInfoPageFragment get() {
        return c(this.f28671a.get(), this.f28672b.get());
    }
}
