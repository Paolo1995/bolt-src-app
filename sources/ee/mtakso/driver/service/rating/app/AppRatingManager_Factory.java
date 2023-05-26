package ee.mtakso.driver.service.rating.app;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.order.v2.OrderHistoryManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AppRatingManager_Factory implements Factory<AppRatingManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RateMePrefsManager> f25804a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CampaignClient> f25805b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f25806c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<GeoLocationManager> f25807d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f25808e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<OrderHistoryManager> f25809f;

    public AppRatingManager_Factory(Provider<RateMePrefsManager> provider, Provider<CampaignClient> provider2, Provider<DriverDestinationsManager> provider3, Provider<GeoLocationManager> provider4, Provider<DriverStatusProvider> provider5, Provider<OrderHistoryManager> provider6) {
        this.f25804a = provider;
        this.f25805b = provider2;
        this.f25806c = provider3;
        this.f25807d = provider4;
        this.f25808e = provider5;
        this.f25809f = provider6;
    }

    public static AppRatingManager_Factory a(Provider<RateMePrefsManager> provider, Provider<CampaignClient> provider2, Provider<DriverDestinationsManager> provider3, Provider<GeoLocationManager> provider4, Provider<DriverStatusProvider> provider5, Provider<OrderHistoryManager> provider6) {
        return new AppRatingManager_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AppRatingManager c(RateMePrefsManager rateMePrefsManager, CampaignClient campaignClient, DriverDestinationsManager driverDestinationsManager, GeoLocationManager geoLocationManager, DriverStatusProvider driverStatusProvider, OrderHistoryManager orderHistoryManager) {
        return new AppRatingManager(rateMePrefsManager, campaignClient, driverDestinationsManager, geoLocationManager, driverStatusProvider, orderHistoryManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AppRatingManager get() {
        return c(this.f25804a.get(), this.f25805b.get(), this.f25806c.get(), this.f25807d.get(), this.f25808e.get(), this.f25809f.get());
    }
}
