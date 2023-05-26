package ee.mtakso.driver.ui.screens.work.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes5.dex */
public final class MapExplanationFragment_Factory implements Factory<MapExplanationFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f34127a;

    public MapExplanationFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f34127a = provider;
    }

    public static MapExplanationFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new MapExplanationFragment_Factory(provider);
    }

    public static MapExplanationFragment c(BaseUiDependencies baseUiDependencies) {
        return new MapExplanationFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MapExplanationFragment get() {
        return c(this.f34127a.get());
    }
}
