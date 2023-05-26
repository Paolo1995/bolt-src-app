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
public final class DefaultPushHandler_Factory implements Factory<DefaultPushHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PushNotificationManager> f25678a;

    public DefaultPushHandler_Factory(Provider<PushNotificationManager> provider) {
        this.f25678a = provider;
    }

    public static DefaultPushHandler_Factory a(Provider<PushNotificationManager> provider) {
        return new DefaultPushHandler_Factory(provider);
    }

    public static DefaultPushHandler c(PushNotificationManager pushNotificationManager) {
        return new DefaultPushHandler(pushNotificationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DefaultPushHandler get() {
        return c(this.f25678a.get());
    }
}
