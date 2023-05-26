package ee.mtakso.driver.service.push;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.utils.BackgroundManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PushNotificationManager_Factory implements Factory<PushNotificationManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f25622a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BackgroundManager> f25623b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UiNotificationManager> f25624c;

    public PushNotificationManager_Factory(Provider<Context> provider, Provider<BackgroundManager> provider2, Provider<UiNotificationManager> provider3) {
        this.f25622a = provider;
        this.f25623b = provider2;
        this.f25624c = provider3;
    }

    public static PushNotificationManager_Factory a(Provider<Context> provider, Provider<BackgroundManager> provider2, Provider<UiNotificationManager> provider3) {
        return new PushNotificationManager_Factory(provider, provider2, provider3);
    }

    public static PushNotificationManager c(Context context, BackgroundManager backgroundManager, UiNotificationManager uiNotificationManager) {
        return new PushNotificationManager(context, backgroundManager, uiNotificationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PushNotificationManager get() {
        return c(this.f25622a.get(), this.f25623b.get(), this.f25624c.get());
    }
}
