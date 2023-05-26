package eu.bolt.chat.chatcore.repo.quickreply;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.repo.ChatNetworkRepo;
import eu.bolt.chat.tools.deps.RxSchedulers;
import eu.bolt.chat.tools.logger.Logger;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class QuickRepliesDelegateImpl_Factory implements Factory<QuickRepliesDelegateImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatConnectionProvider> f38510a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatNetworkRepo> f38511b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RxSchedulers> f38512c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Logger> f38513d;

    public QuickRepliesDelegateImpl_Factory(Provider<ChatConnectionProvider> provider, Provider<ChatNetworkRepo> provider2, Provider<RxSchedulers> provider3, Provider<Logger> provider4) {
        this.f38510a = provider;
        this.f38511b = provider2;
        this.f38512c = provider3;
        this.f38513d = provider4;
    }

    public static QuickRepliesDelegateImpl_Factory a(Provider<ChatConnectionProvider> provider, Provider<ChatNetworkRepo> provider2, Provider<RxSchedulers> provider3, Provider<Logger> provider4) {
        return new QuickRepliesDelegateImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static QuickRepliesDelegateImpl c(ChatConnectionProvider chatConnectionProvider, ChatNetworkRepo chatNetworkRepo, RxSchedulers rxSchedulers, Logger logger) {
        return new QuickRepliesDelegateImpl(chatConnectionProvider, chatNetworkRepo, rxSchedulers, logger);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public QuickRepliesDelegateImpl get() {
        return c(this.f38510a.get(), this.f38511b.get(), this.f38512c.get(), this.f38513d.get());
    }
}
