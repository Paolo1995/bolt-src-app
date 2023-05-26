package ee.mtakso.driver.ui.notification;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NotificationCleanerService_Factory implements Factory<NotificationCleanerService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f26971a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UiNotificationManager> f26972b;

    public NotificationCleanerService_Factory(Provider<PollerSource> provider, Provider<UiNotificationManager> provider2) {
        this.f26971a = provider;
        this.f26972b = provider2;
    }

    public static NotificationCleanerService_Factory a(Provider<PollerSource> provider, Provider<UiNotificationManager> provider2) {
        return new NotificationCleanerService_Factory(provider, provider2);
    }

    public static NotificationCleanerService c(PollerSource pollerSource, UiNotificationManager uiNotificationManager) {
        return new NotificationCleanerService(pollerSource, uiNotificationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NotificationCleanerService get() {
        return c(this.f26971a.get(), this.f26972b.get());
    }
}
