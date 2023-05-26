package ee.mtakso.driver.service.push.handler;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.push.PushNotificationManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderTerminatedPushHandler_Factory implements Factory<OrderTerminatedPushHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PushNotificationManager> f25692a;

    public OrderTerminatedPushHandler_Factory(Provider<PushNotificationManager> provider) {
        this.f25692a = provider;
    }

    public static OrderTerminatedPushHandler_Factory a(Provider<PushNotificationManager> provider) {
        return new OrderTerminatedPushHandler_Factory(provider);
    }

    public static OrderTerminatedPushHandler c(PushNotificationManager pushNotificationManager) {
        return new OrderTerminatedPushHandler(pushNotificationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderTerminatedPushHandler get() {
        return c(this.f25692a.get());
    }
}
