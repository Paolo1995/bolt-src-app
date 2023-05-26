package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.engine.ChatEngineFactory;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.chatcore.push.PushHandlerDependencies;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideChatPushHandler$chat_core_releaseFactory implements Factory<ChatPushHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38080a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatEngineFactory> f38081b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PushHandlerDependencies> f38082c;

    public ChatCoreModule_ProvideChatPushHandler$chat_core_releaseFactory(ChatCoreModule chatCoreModule, Provider<ChatEngineFactory> provider, Provider<PushHandlerDependencies> provider2) {
        this.f38080a = chatCoreModule;
        this.f38081b = provider;
        this.f38082c = provider2;
    }

    public static ChatCoreModule_ProvideChatPushHandler$chat_core_releaseFactory a(ChatCoreModule chatCoreModule, Provider<ChatEngineFactory> provider, Provider<PushHandlerDependencies> provider2) {
        return new ChatCoreModule_ProvideChatPushHandler$chat_core_releaseFactory(chatCoreModule, provider, provider2);
    }

    public static ChatPushHandler c(ChatCoreModule chatCoreModule, ChatEngineFactory chatEngineFactory, PushHandlerDependencies pushHandlerDependencies) {
        return (ChatPushHandler) Preconditions.checkNotNullFromProvides(chatCoreModule.f(chatEngineFactory, pushHandlerDependencies));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatPushHandler get() {
        return c(this.f38080a, this.f38081b.get(), this.f38082c.get());
    }
}
