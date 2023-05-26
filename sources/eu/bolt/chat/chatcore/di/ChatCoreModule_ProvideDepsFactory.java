package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.tools.deps.RxSchedulers;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideDepsFactory implements Factory<RxSchedulers> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38083a;

    public ChatCoreModule_ProvideDepsFactory(ChatCoreModule chatCoreModule) {
        this.f38083a = chatCoreModule;
    }

    public static ChatCoreModule_ProvideDepsFactory a(ChatCoreModule chatCoreModule) {
        return new ChatCoreModule_ProvideDepsFactory(chatCoreModule);
    }

    public static RxSchedulers c(ChatCoreModule chatCoreModule) {
        return (RxSchedulers) Preconditions.checkNotNullFromProvides(chatCoreModule.g());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RxSchedulers get() {
        return c(this.f38083a);
    }
}
