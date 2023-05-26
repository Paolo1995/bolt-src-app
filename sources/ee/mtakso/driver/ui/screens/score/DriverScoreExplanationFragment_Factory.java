package ee.mtakso.driver.ui.screens.score;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import eu.bolt.driver.core.theme.ThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class DriverScoreExplanationFragment_Factory implements Factory<DriverScoreExplanationFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f32890a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ThemeManager> f32891b;

    public DriverScoreExplanationFragment_Factory(Provider<BaseUiDependencies> provider, Provider<ThemeManager> provider2) {
        this.f32890a = provider;
        this.f32891b = provider2;
    }

    public static DriverScoreExplanationFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<ThemeManager> provider2) {
        return new DriverScoreExplanationFragment_Factory(provider, provider2);
    }

    public static DriverScoreExplanationFragment c(BaseUiDependencies baseUiDependencies, ThemeManager themeManager) {
        return new DriverScoreExplanationFragment(baseUiDependencies, themeManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverScoreExplanationFragment get() {
        return c(this.f32890a.get(), this.f32891b.get());
    }
}
