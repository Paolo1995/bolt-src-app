package ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason;

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
public final class ChoosePriceReviewDialog_Factory implements Factory<ChoosePriceReviewDialog> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f31105a;

    public ChoosePriceReviewDialog_Factory(Provider<BaseUiDependencies> provider) {
        this.f31105a = provider;
    }

    public static ChoosePriceReviewDialog_Factory a(Provider<BaseUiDependencies> provider) {
        return new ChoosePriceReviewDialog_Factory(provider);
    }

    public static ChoosePriceReviewDialog c(BaseUiDependencies baseUiDependencies) {
        return new ChoosePriceReviewDialog(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChoosePriceReviewDialog get() {
        return c(this.f31105a.get());
    }
}
