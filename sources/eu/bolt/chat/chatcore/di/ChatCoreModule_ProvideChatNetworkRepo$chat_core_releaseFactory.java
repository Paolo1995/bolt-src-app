package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.network.repo.ChatNetworkRepoImpl;
import eu.bolt.chat.chatcore.repo.ChatNetworkRepo;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideChatNetworkRepo$chat_core_releaseFactory implements Factory<ChatNetworkRepo> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38078a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatNetworkRepoImpl> f38079b;

    public ChatCoreModule_ProvideChatNetworkRepo$chat_core_releaseFactory(ChatCoreModule chatCoreModule, Provider<ChatNetworkRepoImpl> provider) {
        this.f38078a = chatCoreModule;
        this.f38079b = provider;
    }

    public static ChatCoreModule_ProvideChatNetworkRepo$chat_core_releaseFactory a(ChatCoreModule chatCoreModule, Provider<ChatNetworkRepoImpl> provider) {
        return new ChatCoreModule_ProvideChatNetworkRepo$chat_core_releaseFactory(chatCoreModule, provider);
    }

    public static ChatNetworkRepo c(ChatCoreModule chatCoreModule, ChatNetworkRepoImpl chatNetworkRepoImpl) {
        return (ChatNetworkRepo) Preconditions.checkNotNullFromProvides(chatCoreModule.e(chatNetworkRepoImpl));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatNetworkRepo get() {
        return c(this.f38078a, this.f38079b.get());
    }
}
