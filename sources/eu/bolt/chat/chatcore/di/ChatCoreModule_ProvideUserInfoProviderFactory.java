package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.user.UserInfoProvider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideUserInfoProviderFactory implements Factory<UserInfoProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38097a;

    public ChatCoreModule_ProvideUserInfoProviderFactory(ChatCoreModule chatCoreModule) {
        this.f38097a = chatCoreModule;
    }

    public static ChatCoreModule_ProvideUserInfoProviderFactory a(ChatCoreModule chatCoreModule) {
        return new ChatCoreModule_ProvideUserInfoProviderFactory(chatCoreModule);
    }

    public static UserInfoProvider c(ChatCoreModule chatCoreModule) {
        return (UserInfoProvider) Preconditions.checkNotNullFromProvides(chatCoreModule.p());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public UserInfoProvider get() {
        return c(this.f38097a);
    }
}
