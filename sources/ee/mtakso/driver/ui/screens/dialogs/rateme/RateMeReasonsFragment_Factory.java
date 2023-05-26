package ee.mtakso.driver.ui.screens.dialogs.rateme;

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
public final class RateMeReasonsFragment_Factory implements Factory<RateMeReasonsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28392a;

    public RateMeReasonsFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f28392a = provider;
    }

    public static RateMeReasonsFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new RateMeReasonsFragment_Factory(provider);
    }

    public static RateMeReasonsFragment c(BaseUiDependencies baseUiDependencies) {
        return new RateMeReasonsFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RateMeReasonsFragment get() {
        return c(this.f28392a.get());
    }
}
