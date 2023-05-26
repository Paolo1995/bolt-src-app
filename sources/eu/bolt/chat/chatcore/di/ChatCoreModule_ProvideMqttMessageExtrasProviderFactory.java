package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.user.MqttMessageExtrasProvider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideMqttMessageExtrasProviderFactory implements Factory<MqttMessageExtrasProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38089a;

    public ChatCoreModule_ProvideMqttMessageExtrasProviderFactory(ChatCoreModule chatCoreModule) {
        this.f38089a = chatCoreModule;
    }

    public static ChatCoreModule_ProvideMqttMessageExtrasProviderFactory a(ChatCoreModule chatCoreModule) {
        return new ChatCoreModule_ProvideMqttMessageExtrasProviderFactory(chatCoreModule);
    }

    public static MqttMessageExtrasProvider c(ChatCoreModule chatCoreModule) {
        return (MqttMessageExtrasProvider) Preconditions.checkNotNullFromProvides(chatCoreModule.k());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttMessageExtrasProvider get() {
        return c(this.f38089a);
    }
}
