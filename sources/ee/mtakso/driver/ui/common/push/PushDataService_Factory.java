package ee.mtakso.driver.ui.common.push;

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
public final class PushDataService_Factory implements Factory<PushDataService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PushNotificationManager> f26396a;

    public PushDataService_Factory(Provider<PushNotificationManager> provider) {
        this.f26396a = provider;
    }

    public static PushDataService_Factory a(Provider<PushNotificationManager> provider) {
        return new PushDataService_Factory(provider);
    }

    public static PushDataService c(PushNotificationManager pushNotificationManager) {
        return new PushDataService(pushNotificationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PushDataService get() {
        return c(this.f26396a.get());
    }
}
