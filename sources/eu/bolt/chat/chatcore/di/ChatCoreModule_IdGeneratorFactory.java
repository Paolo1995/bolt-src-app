package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.tools.uniqueid.IdGenerator;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_IdGeneratorFactory implements Factory<IdGenerator> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38073a;

    public ChatCoreModule_IdGeneratorFactory(ChatCoreModule chatCoreModule) {
        this.f38073a = chatCoreModule;
    }

    public static ChatCoreModule_IdGeneratorFactory a(ChatCoreModule chatCoreModule) {
        return new ChatCoreModule_IdGeneratorFactory(chatCoreModule);
    }

    public static IdGenerator c(ChatCoreModule chatCoreModule) {
        return (IdGenerator) Preconditions.checkNotNullFromProvides(chatCoreModule.b());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IdGenerator get() {
        return c(this.f38073a);
    }
}
