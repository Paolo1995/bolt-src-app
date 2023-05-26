package ee.mtakso.driver.ui.screens.blocking;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.support.SupportClient;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.push.PushNotificationManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverAppDisabledViewModel_Factory implements Factory<DriverAppDisabledViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoLocationManager> f27081a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PushNotificationManager> f27082b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SupportClient> f27083c;

    public DriverAppDisabledViewModel_Factory(Provider<GeoLocationManager> provider, Provider<PushNotificationManager> provider2, Provider<SupportClient> provider3) {
        this.f27081a = provider;
        this.f27082b = provider2;
        this.f27083c = provider3;
    }

    public static DriverAppDisabledViewModel_Factory a(Provider<GeoLocationManager> provider, Provider<PushNotificationManager> provider2, Provider<SupportClient> provider3) {
        return new DriverAppDisabledViewModel_Factory(provider, provider2, provider3);
    }

    public static DriverAppDisabledViewModel c(GeoLocationManager geoLocationManager, PushNotificationManager pushNotificationManager, SupportClient supportClient) {
        return new DriverAppDisabledViewModel(geoLocationManager, pushNotificationManager, supportClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverAppDisabledViewModel get() {
        return c(this.f27081a.get(), this.f27082b.get(), this.f27083c.get());
    }
}
