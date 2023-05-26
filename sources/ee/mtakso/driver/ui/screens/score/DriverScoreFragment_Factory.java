package ee.mtakso.driver.ui.screens.score;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class DriverScoreFragment_Factory implements Factory<DriverScoreFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f32913a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f32914b;

    public DriverScoreFragment_Factory(Provider<BaseUiDependencies> provider, Provider<CompositeUrlLauncher> provider2) {
        this.f32913a = provider;
        this.f32914b = provider2;
    }

    public static DriverScoreFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<CompositeUrlLauncher> provider2) {
        return new DriverScoreFragment_Factory(provider, provider2);
    }

    public static DriverScoreFragment c(BaseUiDependencies baseUiDependencies, CompositeUrlLauncher compositeUrlLauncher) {
        return new DriverScoreFragment(baseUiDependencies, compositeUrlLauncher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverScoreFragment get() {
        return c(this.f32913a.get(), this.f32914b.get());
    }
}
