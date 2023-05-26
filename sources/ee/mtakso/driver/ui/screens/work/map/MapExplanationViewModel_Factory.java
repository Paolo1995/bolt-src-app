package ee.mtakso.driver.ui.screens.work.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.interactor.map.GetMapExplanationInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MapExplanationViewModel_Factory implements Factory<MapExplanationViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GetMapExplanationInteractor> f34135a;

    public MapExplanationViewModel_Factory(Provider<GetMapExplanationInteractor> provider) {
        this.f34135a = provider;
    }

    public static MapExplanationViewModel_Factory a(Provider<GetMapExplanationInteractor> provider) {
        return new MapExplanationViewModel_Factory(provider);
    }

    public static MapExplanationViewModel c(GetMapExplanationInteractor getMapExplanationInteractor) {
        return new MapExplanationViewModel(getMapExplanationInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MapExplanationViewModel get() {
        return c(this.f34135a.get());
    }
}
