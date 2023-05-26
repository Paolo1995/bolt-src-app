package ee.mtakso.driver.service.push.handler;

import android.content.Context;
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
public final class SupportPushHandler_Factory implements Factory<SupportPushHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PushNotificationManager> f25720a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Context> f25721b;

    public SupportPushHandler_Factory(Provider<PushNotificationManager> provider, Provider<Context> provider2) {
        this.f25720a = provider;
        this.f25721b = provider2;
    }

    public static SupportPushHandler_Factory a(Provider<PushNotificationManager> provider, Provider<Context> provider2) {
        return new SupportPushHandler_Factory(provider, provider2);
    }

    public static SupportPushHandler c(PushNotificationManager pushNotificationManager, Context context) {
        return new SupportPushHandler(pushNotificationManager, context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SupportPushHandler get() {
        return c(this.f25720a.get(), this.f25721b.get());
    }
}
