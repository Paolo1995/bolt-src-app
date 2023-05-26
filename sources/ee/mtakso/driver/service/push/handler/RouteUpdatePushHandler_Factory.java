package ee.mtakso.driver.service.push.handler;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.utils.BackgroundManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RouteUpdatePushHandler_Factory implements Factory<RouteUpdatePushHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BackgroundManager> f25710a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PushNotificationManager> f25711b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderProvider> f25712c;

    public RouteUpdatePushHandler_Factory(Provider<BackgroundManager> provider, Provider<PushNotificationManager> provider2, Provider<OrderProvider> provider3) {
        this.f25710a = provider;
        this.f25711b = provider2;
        this.f25712c = provider3;
    }

    public static RouteUpdatePushHandler_Factory a(Provider<BackgroundManager> provider, Provider<PushNotificationManager> provider2, Provider<OrderProvider> provider3) {
        return new RouteUpdatePushHandler_Factory(provider, provider2, provider3);
    }

    public static RouteUpdatePushHandler c(BackgroundManager backgroundManager, PushNotificationManager pushNotificationManager, OrderProvider orderProvider) {
        return new RouteUpdatePushHandler(backgroundManager, pushNotificationManager, orderProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RouteUpdatePushHandler get() {
        return c(this.f25710a.get(), this.f25711b.get(), this.f25712c.get());
    }
}
