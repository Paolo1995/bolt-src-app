package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.engine.ChatEngineDependencies;
import eu.bolt.chat.chatcore.engine.ChatEngineFactory;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideInternalChatRepo$chat_core_releaseFactory implements Factory<InternalChatRepo> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38085a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatEngineFactory> f38086b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ChatEngineDependencies> f38087c;

    public ChatCoreModule_ProvideInternalChatRepo$chat_core_releaseFactory(ChatCoreModule chatCoreModule, Provider<ChatEngineFactory> provider, Provider<ChatEngineDependencies> provider2) {
        this.f38085a = chatCoreModule;
        this.f38086b = provider;
        this.f38087c = provider2;
    }

    public static ChatCoreModule_ProvideInternalChatRepo$chat_core_releaseFactory a(ChatCoreModule chatCoreModule, Provider<ChatEngineFactory> provider, Provider<ChatEngineDependencies> provider2) {
        return new ChatCoreModule_ProvideInternalChatRepo$chat_core_releaseFactory(chatCoreModule, provider, provider2);
    }

    public static InternalChatRepo c(ChatCoreModule chatCoreModule, ChatEngineFactory chatEngineFactory, ChatEngineDependencies chatEngineDependencies) {
        return (InternalChatRepo) Preconditions.checkNotNullFromProvides(chatCoreModule.i(chatEngineFactory, chatEngineDependencies));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InternalChatRepo get() {
        return c(this.f38085a, this.f38086b.get(), this.f38087c.get());
    }
}
