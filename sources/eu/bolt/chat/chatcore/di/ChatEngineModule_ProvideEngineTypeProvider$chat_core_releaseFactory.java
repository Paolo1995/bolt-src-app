package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.engine.ChatEngineTypeProvider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatEngineModule_ProvideEngineTypeProvider$chat_core_releaseFactory implements Factory<ChatEngineTypeProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatEngineModule f38098a;

    public ChatEngineModule_ProvideEngineTypeProvider$chat_core_releaseFactory(ChatEngineModule chatEngineModule) {
        this.f38098a = chatEngineModule;
    }

    public static ChatEngineModule_ProvideEngineTypeProvider$chat_core_releaseFactory a(ChatEngineModule chatEngineModule) {
        return new ChatEngineModule_ProvideEngineTypeProvider$chat_core_releaseFactory(chatEngineModule);
    }

    public static ChatEngineTypeProvider c(ChatEngineModule chatEngineModule) {
        return (ChatEngineTypeProvider) Preconditions.checkNotNullFromProvides(chatEngineModule.a());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatEngineTypeProvider get() {
        return c(this.f38098a);
    }
}
