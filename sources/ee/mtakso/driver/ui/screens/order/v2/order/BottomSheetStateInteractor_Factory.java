package ee.mtakso.driver.ui.screens.order.v2.order;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BottomSheetStateInteractor_Factory implements Factory<BottomSheetStateInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f32188a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<GeoLocationManager> f32189b;

    public BottomSheetStateInteractor_Factory(Provider<OrderProvider> provider, Provider<GeoLocationManager> provider2) {
        this.f32188a = provider;
        this.f32189b = provider2;
    }

    public static BottomSheetStateInteractor_Factory a(Provider<OrderProvider> provider, Provider<GeoLocationManager> provider2) {
        return new BottomSheetStateInteractor_Factory(provider, provider2);
    }

    public static BottomSheetStateInteractor c(OrderProvider orderProvider, GeoLocationManager geoLocationManager) {
        return new BottomSheetStateInteractor(orderProvider, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BottomSheetStateInteractor get() {
        return c(this.f32188a.get(), this.f32189b.get());
    }
}
