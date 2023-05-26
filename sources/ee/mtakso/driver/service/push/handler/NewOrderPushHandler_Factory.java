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
public final class NewOrderPushHandler_Factory implements Factory<NewOrderPushHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BackgroundManager> f25688a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PushNotificationManager> f25689b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderProvider> f25690c;

    public NewOrderPushHandler_Factory(Provider<BackgroundManager> provider, Provider<PushNotificationManager> provider2, Provider<OrderProvider> provider3) {
        this.f25688a = provider;
        this.f25689b = provider2;
        this.f25690c = provider3;
    }

    public static NewOrderPushHandler_Factory a(Provider<BackgroundManager> provider, Provider<PushNotificationManager> provider2, Provider<OrderProvider> provider3) {
        return new NewOrderPushHandler_Factory(provider, provider2, provider3);
    }

    public static NewOrderPushHandler c(BackgroundManager backgroundManager, PushNotificationManager pushNotificationManager, OrderProvider orderProvider) {
        return new NewOrderPushHandler(backgroundManager, pushNotificationManager, orderProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NewOrderPushHandler get() {
        return c(this.f25688a.get(), this.f25689b.get(), this.f25690c.get());
    }
}
