package ee.mtakso.driver.ui.screens.earnings.v2.payout.history;

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
public final class PayoutHistoryFragment_Factory implements Factory<PayoutHistoryFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28710a;

    public PayoutHistoryFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f28710a = provider;
    }

    public static PayoutHistoryFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new PayoutHistoryFragment_Factory(provider);
    }

    public static PayoutHistoryFragment c(BaseUiDependencies baseUiDependencies) {
        return new PayoutHistoryFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutHistoryFragment get() {
        return c(this.f28710a.get());
    }
}
