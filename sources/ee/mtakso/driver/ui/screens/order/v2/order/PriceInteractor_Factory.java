package ee.mtakso.driver.ui.screens.order.v2.order;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.service.geo.transmitter.LocationTransmitter;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PriceInteractor_Factory implements Factory<PriceInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LocationTransmitter> f32317a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderClient> f32318b;

    public PriceInteractor_Factory(Provider<LocationTransmitter> provider, Provider<OrderClient> provider2) {
        this.f32317a = provider;
        this.f32318b = provider2;
    }

    public static PriceInteractor_Factory a(Provider<LocationTransmitter> provider, Provider<OrderClient> provider2) {
        return new PriceInteractor_Factory(provider, provider2);
    }

    public static PriceInteractor c(LocationTransmitter locationTransmitter, OrderClient orderClient) {
        return new PriceInteractor(locationTransmitter, orderClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PriceInteractor get() {
        return c(this.f32317a.get(), this.f32318b.get());
    }
}
