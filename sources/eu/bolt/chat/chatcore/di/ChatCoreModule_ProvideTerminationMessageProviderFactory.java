package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.network.external.ChatExternalTerminationMessageProvider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideTerminationMessageProviderFactory implements Factory<ChatExternalTerminationMessageProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38096a;

    public ChatCoreModule_ProvideTerminationMessageProviderFactory(ChatCoreModule chatCoreModule) {
        this.f38096a = chatCoreModule;
    }

    public static ChatCoreModule_ProvideTerminationMessageProviderFactory a(ChatCoreModule chatCoreModule) {
        return new ChatCoreModule_ProvideTerminationMessageProviderFactory(chatCoreModule);
    }

    public static ChatExternalTerminationMessageProvider c(ChatCoreModule chatCoreModule) {
        return (ChatExternalTerminationMessageProvider) Preconditions.checkNotNullFromProvides(chatCoreModule.o());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatExternalTerminationMessageProvider get() {
        return c(this.f38096a);
    }
}
