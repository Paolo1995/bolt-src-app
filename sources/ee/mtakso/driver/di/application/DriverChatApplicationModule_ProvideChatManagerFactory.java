package ee.mtakso.driver.di.application;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.chat.DriverChatUserInfoProvider;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.interactor.CreateChatInteractor;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.driver.chat.service.ChatManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverChatApplicationModule_ProvideChatManagerFactory implements Factory<ChatManager> {

    /* renamed from: a  reason: collision with root package name */
    private final DriverChatApplicationModule f20278a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverChatUserInfoProvider> f20279b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ChatRepo> f20280c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatConnectionProvider> f20281d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<CreateChatInteractor> f20282e;

    public DriverChatApplicationModule_ProvideChatManagerFactory(DriverChatApplicationModule driverChatApplicationModule, Provider<DriverChatUserInfoProvider> provider, Provider<ChatRepo> provider2, Provider<ChatConnectionProvider> provider3, Provider<CreateChatInteractor> provider4) {
        this.f20278a = driverChatApplicationModule;
        this.f20279b = provider;
        this.f20280c = provider2;
        this.f20281d = provider3;
        this.f20282e = provider4;
    }

    public static DriverChatApplicationModule_ProvideChatManagerFactory a(DriverChatApplicationModule driverChatApplicationModule, Provider<DriverChatUserInfoProvider> provider, Provider<ChatRepo> provider2, Provider<ChatConnectionProvider> provider3, Provider<CreateChatInteractor> provider4) {
        return new DriverChatApplicationModule_ProvideChatManagerFactory(driverChatApplicationModule, provider, provider2, provider3, provider4);
    }

    public static ChatManager c(DriverChatApplicationModule driverChatApplicationModule, DriverChatUserInfoProvider driverChatUserInfoProvider, ChatRepo chatRepo, ChatConnectionProvider chatConnectionProvider, CreateChatInteractor createChatInteractor) {
        return (ChatManager) Preconditions.checkNotNullFromProvides(driverChatApplicationModule.b(driverChatUserInfoProvider, chatRepo, chatConnectionProvider, createChatInteractor));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatManager get() {
        return c(this.f20278a, this.f20279b.get(), this.f20280c.get(), this.f20281d.get(), this.f20282e.get());
    }
}
