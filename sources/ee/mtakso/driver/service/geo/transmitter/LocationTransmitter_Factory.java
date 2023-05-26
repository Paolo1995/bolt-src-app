package ee.mtakso.driver.service.geo.transmitter;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.service.geo.storage.LocationStorage;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LocationTransmitter_Factory implements Factory<LocationTransmitter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LocationStorage> f24482a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Features> f24483b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverClient> f24484c;

    public LocationTransmitter_Factory(Provider<LocationStorage> provider, Provider<Features> provider2, Provider<DriverClient> provider3) {
        this.f24482a = provider;
        this.f24483b = provider2;
        this.f24484c = provider3;
    }

    public static LocationTransmitter_Factory a(Provider<LocationStorage> provider, Provider<Features> provider2, Provider<DriverClient> provider3) {
        return new LocationTransmitter_Factory(provider, provider2, provider3);
    }

    public static LocationTransmitter c(LocationStorage locationStorage, Features features, DriverClient driverClient) {
        return new LocationTransmitter(locationStorage, features, driverClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocationTransmitter get() {
        return c(this.f24482a.get(), this.f24483b.get(), this.f24484c.get());
    }
}
