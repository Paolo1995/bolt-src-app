package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.user.MqttInfoProvider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideMqttInfoProviderFactory implements Factory<MqttInfoProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38088a;

    public ChatCoreModule_ProvideMqttInfoProviderFactory(ChatCoreModule chatCoreModule) {
        this.f38088a = chatCoreModule;
    }

    public static ChatCoreModule_ProvideMqttInfoProviderFactory a(ChatCoreModule chatCoreModule) {
        return new ChatCoreModule_ProvideMqttInfoProviderFactory(chatCoreModule);
    }

    public static MqttInfoProvider c(ChatCoreModule chatCoreModule) {
        return (MqttInfoProvider) Preconditions.checkNotNullFromProvides(chatCoreModule.j());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttInfoProvider get() {
        return c(this.f38088a);
    }
}
