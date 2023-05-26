package ee.mtakso.driver.ui.screens.destination;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class DestinationFragment_Factory implements Factory<DestinationFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28167a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<GeoLocationManager> f28168b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DestinationMapper> f28169c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<FragmentFactory> f28170d;

    public DestinationFragment_Factory(Provider<BaseUiDependencies> provider, Provider<GeoLocationManager> provider2, Provider<DestinationMapper> provider3, Provider<FragmentFactory> provider4) {
        this.f28167a = provider;
        this.f28168b = provider2;
        this.f28169c = provider3;
        this.f28170d = provider4;
    }

    public static DestinationFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<GeoLocationManager> provider2, Provider<DestinationMapper> provider3, Provider<FragmentFactory> provider4) {
        return new DestinationFragment_Factory(provider, provider2, provider3, provider4);
    }

    public static DestinationFragment c(BaseUiDependencies baseUiDependencies, GeoLocationManager geoLocationManager, DestinationMapper destinationMapper, FragmentFactory fragmentFactory) {
        return new DestinationFragment(baseUiDependencies, geoLocationManager, destinationMapper, fragmentFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DestinationFragment get() {
        return c(this.f28167a.get(), this.f28168b.get(), this.f28169c.get(), this.f28170d.get());
    }
}
