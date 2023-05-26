package eu.bolt.driver.chat.ui.notification;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.chat.service.analytics.ChatAnalytics;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatNotificationManager_Factory implements Factory<ChatNotificationManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatAnalytics> f40576a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatNotificationDrawer> f40577b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PermissionManager> f40578c;

    public ChatNotificationManager_Factory(Provider<ChatAnalytics> provider, Provider<ChatNotificationDrawer> provider2, Provider<PermissionManager> provider3) {
        this.f40576a = provider;
        this.f40577b = provider2;
        this.f40578c = provider3;
    }

    public static ChatNotificationManager_Factory a(Provider<ChatAnalytics> provider, Provider<ChatNotificationDrawer> provider2, Provider<PermissionManager> provider3) {
        return new ChatNotificationManager_Factory(provider, provider2, provider3);
    }

    public static ChatNotificationManager c(ChatAnalytics chatAnalytics, ChatNotificationDrawer chatNotificationDrawer, PermissionManager permissionManager) {
        return new ChatNotificationManager(chatAnalytics, chatNotificationDrawer, permissionManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatNotificationManager get() {
        return c(this.f40576a.get(), this.f40577b.get(), this.f40578c.get());
    }
}
