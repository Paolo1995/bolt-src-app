package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.network.external.ChatExternalNetworkRepo;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ChatExternalNetworkRepoFactory implements Factory<ChatExternalNetworkRepo> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38072a;

    public ChatCoreModule_ChatExternalNetworkRepoFactory(ChatCoreModule chatCoreModule) {
        this.f38072a = chatCoreModule;
    }

    public static ChatExternalNetworkRepo a(ChatCoreModule chatCoreModule) {
        return (ChatExternalNetworkRepo) Preconditions.checkNotNullFromProvides(chatCoreModule.a());
    }

    public static ChatCoreModule_ChatExternalNetworkRepoFactory b(ChatCoreModule chatCoreModule) {
        return new ChatCoreModule_ChatExternalNetworkRepoFactory(chatCoreModule);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public ChatExternalNetworkRepo get() {
        return a(this.f38072a);
    }
}
