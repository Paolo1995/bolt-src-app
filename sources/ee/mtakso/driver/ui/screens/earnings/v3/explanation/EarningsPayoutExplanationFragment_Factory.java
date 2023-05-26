package ee.mtakso.driver.ui.screens.earnings.v3.explanation;

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
public final class EarningsPayoutExplanationFragment_Factory implements Factory<EarningsPayoutExplanationFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f29077a;

    public EarningsPayoutExplanationFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f29077a = provider;
    }

    public static EarningsPayoutExplanationFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new EarningsPayoutExplanationFragment_Factory(provider);
    }

    public static EarningsPayoutExplanationFragment c(BaseUiDependencies baseUiDependencies) {
        return new EarningsPayoutExplanationFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsPayoutExplanationFragment get() {
        return c(this.f29077a.get());
    }
}
