package ee.mtakso.driver.service.push.handler;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.rating.app.AppRatingManager;
import ee.mtakso.driver.utils.BackgroundManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RateAppPushHandler_Factory implements Factory<RateAppPushHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PushNotificationManager> f25697a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppRatingManager> f25698b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<BackgroundManager> f25699c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f25700d;

    public RateAppPushHandler_Factory(Provider<PushNotificationManager> provider, Provider<AppRatingManager> provider2, Provider<BackgroundManager> provider3, Provider<DriverStatusProvider> provider4) {
        this.f25697a = provider;
        this.f25698b = provider2;
        this.f25699c = provider3;
        this.f25700d = provider4;
    }

    public static RateAppPushHandler_Factory a(Provider<PushNotificationManager> provider, Provider<AppRatingManager> provider2, Provider<BackgroundManager> provider3, Provider<DriverStatusProvider> provider4) {
        return new RateAppPushHandler_Factory(provider, provider2, provider3, provider4);
    }

    public static RateAppPushHandler c(PushNotificationManager pushNotificationManager, AppRatingManager appRatingManager, BackgroundManager backgroundManager, DriverStatusProvider driverStatusProvider) {
        return new RateAppPushHandler(pushNotificationManager, appRatingManager, backgroundManager, driverStatusProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RateAppPushHandler get() {
        return c(this.f25697a.get(), this.f25698b.get(), this.f25699c.get(), this.f25700d.get());
    }
}
