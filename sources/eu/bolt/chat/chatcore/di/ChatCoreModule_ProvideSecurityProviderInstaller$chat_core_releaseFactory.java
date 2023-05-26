package eu.bolt.chat.chatcore.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.network.security.SecurityProviderInstaller;
import eu.bolt.chat.tools.logger.Logger;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatCoreModule_ProvideSecurityProviderInstaller$chat_core_releaseFactory implements Factory<SecurityProviderInstaller> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatCoreModule f38093a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Context> f38094b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Logger> f38095c;

    public ChatCoreModule_ProvideSecurityProviderInstaller$chat_core_releaseFactory(ChatCoreModule chatCoreModule, Provider<Context> provider, Provider<Logger> provider2) {
        this.f38093a = chatCoreModule;
        this.f38094b = provider;
        this.f38095c = provider2;
    }

    public static ChatCoreModule_ProvideSecurityProviderInstaller$chat_core_releaseFactory a(ChatCoreModule chatCoreModule, Provider<Context> provider, Provider<Logger> provider2) {
        return new ChatCoreModule_ProvideSecurityProviderInstaller$chat_core_releaseFactory(chatCoreModule, provider, provider2);
    }

    public static SecurityProviderInstaller c(ChatCoreModule chatCoreModule, Context context, Logger logger) {
        return (SecurityProviderInstaller) Preconditions.checkNotNullFromProvides(chatCoreModule.n(context, logger));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SecurityProviderInstaller get() {
        return c(this.f38093a, this.f38094b.get(), this.f38095c.get());
    }
}
