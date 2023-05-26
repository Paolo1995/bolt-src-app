package ee.mtakso.driver.ui.screens.campaigns.v2.optin;

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
public final class OptInChoiceActivationInfoFragment_Factory implements Factory<OptInChoiceActivationInfoFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27633a;

    public OptInChoiceActivationInfoFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f27633a = provider;
    }

    public static OptInChoiceActivationInfoFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new OptInChoiceActivationInfoFragment_Factory(provider);
    }

    public static OptInChoiceActivationInfoFragment c(BaseUiDependencies baseUiDependencies) {
        return new OptInChoiceActivationInfoFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OptInChoiceActivationInfoFragment get() {
        return c(this.f27633a.get());
    }
}
