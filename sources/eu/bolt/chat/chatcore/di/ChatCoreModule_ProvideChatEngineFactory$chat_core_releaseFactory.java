package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.engine.ChatEngineFactory;
import eu.bolt.chat.chatcore.engine.ChatEngineTypeProvider;
import eu.bolt.chat.tools.logger.Logger;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideChatEngineFactory$chat_core_releaseFactory implements Factory<ChatEngineFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38074a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatEngineTypeProvider> f38075b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Logger> f38076c;

    public ChatCoreModule_ProvideChatEngineFactory$chat_core_releaseFactory(ChatCoreModule chatCoreModule, Provider<ChatEngineTypeProvider> provider, Provider<Logger> provider2) {
        this.f38074a = chatCoreModule;
        this.f38075b = provider;
        this.f38076c = provider2;
    }

    public static ChatCoreModule_ProvideChatEngineFactory$chat_core_releaseFactory a(ChatCoreModule chatCoreModule, Provider<ChatEngineTypeProvider> provider, Provider<Logger> provider2) {
        return new ChatCoreModule_ProvideChatEngineFactory$chat_core_releaseFactory(chatCoreModule, provider, provider2);
    }

    public static ChatEngineFactory c(ChatCoreModule chatCoreModule, ChatEngineTypeProvider chatEngineTypeProvider, Logger logger) {
        return (ChatEngineFactory) Preconditions.checkNotNullFromProvides(chatCoreModule.c(chatEngineTypeProvider, logger));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatEngineFactory get() {
        return c(this.f38074a, this.f38075b.get(), this.f38076c.get());
    }
}
