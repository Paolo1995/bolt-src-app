package ee.mtakso.driver.service.push.handler;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.push.PushNotificationManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ScheduledOrderPushHandler_Factory implements Factory<ScheduledOrderPushHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PushNotificationManager> f25715a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f25716b;

    public ScheduledOrderPushHandler_Factory(Provider<PushNotificationManager> provider, Provider<DriverStatusProvider> provider2) {
        this.f25715a = provider;
        this.f25716b = provider2;
    }

    public static ScheduledOrderPushHandler_Factory a(Provider<PushNotificationManager> provider, Provider<DriverStatusProvider> provider2) {
        return new ScheduledOrderPushHandler_Factory(provider, provider2);
    }

    public static ScheduledOrderPushHandler c(PushNotificationManager pushNotificationManager, DriverStatusProvider driverStatusProvider) {
        return new ScheduledOrderPushHandler(pushNotificationManager, driverStatusProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrderPushHandler get() {
        return c(this.f25715a.get(), this.f25716b.get());
    }
}
