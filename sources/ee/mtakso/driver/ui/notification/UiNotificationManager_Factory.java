package ee.mtakso.driver.ui.notification;

import android.app.NotificationManager;
import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.routing.IntentProvider;
import ee.mtakso.driver.service.voip.effects.VoipEffectsFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class UiNotificationManager_Factory implements Factory<UiNotificationManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f26983a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<IntentProvider> f26984b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<NotificationManager> f26985c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<VoipEffectsFactory> f26986d;

    public UiNotificationManager_Factory(Provider<Context> provider, Provider<IntentProvider> provider2, Provider<NotificationManager> provider3, Provider<VoipEffectsFactory> provider4) {
        this.f26983a = provider;
        this.f26984b = provider2;
        this.f26985c = provider3;
        this.f26986d = provider4;
    }

    public static UiNotificationManager_Factory a(Provider<Context> provider, Provider<IntentProvider> provider2, Provider<NotificationManager> provider3, Provider<VoipEffectsFactory> provider4) {
        return new UiNotificationManager_Factory(provider, provider2, provider3, provider4);
    }

    public static UiNotificationManager c(Context context, IntentProvider intentProvider, NotificationManager notificationManager, VoipEffectsFactory voipEffectsFactory) {
        return new UiNotificationManager(context, intentProvider, notificationManager, voipEffectsFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public UiNotificationManager get() {
        return c(this.f26983a.get(), this.f26984b.get(), this.f26985c.get(), this.f26986d.get());
    }
}
