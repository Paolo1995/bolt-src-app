package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.tools.logger.Logger;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideChatLoggerFactory implements Factory<Logger> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38077a;

    public ChatCoreModule_ProvideChatLoggerFactory(ChatCoreModule chatCoreModule) {
        this.f38077a = chatCoreModule;
    }

    public static ChatCoreModule_ProvideChatLoggerFactory a(ChatCoreModule chatCoreModule) {
        return new ChatCoreModule_ProvideChatLoggerFactory(chatCoreModule);
    }

    public static Logger c(ChatCoreModule chatCoreModule) {
        return (Logger) Preconditions.checkNotNullFromProvides(chatCoreModule.d());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Logger get() {
        return c(this.f38077a);
    }
}
