package ee.mtakso.driver.service.push.handler;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.rating.app.AppRatingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TipsPushHandler_Factory implements Factory<TipsPushHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PushNotificationManager> f25724a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppRatingManager> f25725b;

    public TipsPushHandler_Factory(Provider<PushNotificationManager> provider, Provider<AppRatingManager> provider2) {
        this.f25724a = provider;
        this.f25725b = provider2;
    }

    public static TipsPushHandler_Factory a(Provider<PushNotificationManager> provider, Provider<AppRatingManager> provider2) {
        return new TipsPushHandler_Factory(provider, provider2);
    }

    public static TipsPushHandler c(PushNotificationManager pushNotificationManager, AppRatingManager appRatingManager) {
        return new TipsPushHandler(pushNotificationManager, appRatingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TipsPushHandler get() {
        return c(this.f25724a.get(), this.f25725b.get());
    }
}
