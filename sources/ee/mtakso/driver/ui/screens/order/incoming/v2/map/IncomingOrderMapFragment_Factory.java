package ee.mtakso.driver.ui.screens.order.incoming.v2.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import eu.bolt.android.maps.core.MapProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class IncomingOrderMapFragment_Factory implements Factory<IncomingOrderMapFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f31464a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MapProvider> f31465b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MarkerParamsFactory> f31466c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverFeatures> f31467d;

    public IncomingOrderMapFragment_Factory(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<MarkerParamsFactory> provider3, Provider<DriverFeatures> provider4) {
        this.f31464a = provider;
        this.f31465b = provider2;
        this.f31466c = provider3;
        this.f31467d = provider4;
    }

    public static IncomingOrderMapFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<MapProvider> provider2, Provider<MarkerParamsFactory> provider3, Provider<DriverFeatures> provider4) {
        return new IncomingOrderMapFragment_Factory(provider, provider2, provider3, provider4);
    }

    public static IncomingOrderMapFragment c(BaseUiDependencies baseUiDependencies, MapProvider mapProvider, MarkerParamsFactory markerParamsFactory, DriverFeatures driverFeatures) {
        return new IncomingOrderMapFragment(baseUiDependencies, mapProvider, markerParamsFactory, driverFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncomingOrderMapFragment get() {
        return c(this.f31464a.get(), this.f31465b.get(), this.f31466c.get(), this.f31467d.get());
    }
}
