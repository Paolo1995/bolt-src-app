package ee.mtakso.driver.service.chat;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.ChatSettingsManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ChatConfigManager_Factory implements Factory<ChatConfigManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatSettingsManager> f23995a;

    public ChatConfigManager_Factory(Provider<ChatSettingsManager> provider) {
        this.f23995a = provider;
    }

    public static ChatConfigManager_Factory a(Provider<ChatSettingsManager> provider) {
        return new ChatConfigManager_Factory(provider);
    }

    public static ChatConfigManager c(ChatSettingsManager chatSettingsManager) {
        return new ChatConfigManager(chatSettingsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatConfigManager get() {
        return c(this.f23995a.get());
    }
}
