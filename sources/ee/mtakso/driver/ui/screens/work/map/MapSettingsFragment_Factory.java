package ee.mtakso.driver.ui.screens.work.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes5.dex */
public final class MapSettingsFragment_Factory implements Factory<MapSettingsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f34161a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RoutingManager> f34162b;

    public MapSettingsFragment_Factory(Provider<BaseUiDependencies> provider, Provider<RoutingManager> provider2) {
        this.f34161a = provider;
        this.f34162b = provider2;
    }

    public static MapSettingsFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<RoutingManager> provider2) {
        return new MapSettingsFragment_Factory(provider, provider2);
    }

    public static MapSettingsFragment c(BaseUiDependencies baseUiDependencies, RoutingManager routingManager) {
        return new MapSettingsFragment(baseUiDependencies, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MapSettingsFragment get() {
        return c(this.f34161a.get(), this.f34162b.get());
    }
}
