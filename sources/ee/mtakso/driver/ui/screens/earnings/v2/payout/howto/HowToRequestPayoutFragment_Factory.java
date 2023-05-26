package ee.mtakso.driver.ui.screens.earnings.v2.payout.howto;

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
public final class HowToRequestPayoutFragment_Factory implements Factory<HowToRequestPayoutFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28725a;

    public HowToRequestPayoutFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f28725a = provider;
    }

    public static HowToRequestPayoutFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new HowToRequestPayoutFragment_Factory(provider);
    }

    public static HowToRequestPayoutFragment c(BaseUiDependencies baseUiDependencies) {
        return new HowToRequestPayoutFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HowToRequestPayoutFragment get() {
        return c(this.f28725a.get());
    }
}
