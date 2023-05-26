package eu.bolt.chat.chatcore.engine;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.connection.ChatConnectionController;
import eu.bolt.chat.chatcore.network.external.ChatExternalTerminationMessageProvider;
import eu.bolt.chat.chatcore.network.security.SecurityProviderInstaller;
import eu.bolt.chat.chatcore.push.ChatPushDelegate;
import eu.bolt.chat.chatcore.repo.ChatLocalHistoryRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalTerminalInfoRepo;
import eu.bolt.chat.chatcore.repo.ChatNetworkRepo;
import eu.bolt.chat.chatcore.repo.LocalRepoCleaner;
import eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegate;
import eu.bolt.chat.tools.deps.RxSchedulers;
import eu.bolt.chat.tools.uniqueid.IdGenerator;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatEngineDependencies_Factory implements Factory<ChatEngineDependencies> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatLocalMessagesRepo> f38114a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatLocalRepo> f38115b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ChatLocalTerminalInfoRepo> f38116c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatNetworkRepo> f38117d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ChatConnectionController> f38118e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<LocalRepoCleaner> f38119f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<IdGenerator> f38120g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<ChatPushDelegate> f38121h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<RxSchedulers> f38122i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<QuickRepliesDelegate> f38123j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<ChatLocalHistoryRepo> f38124k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<ChatExternalTerminationMessageProvider> f38125l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<SecurityProviderInstaller> f38126m;

    public ChatEngineDependencies_Factory(Provider<ChatLocalMessagesRepo> provider, Provider<ChatLocalRepo> provider2, Provider<ChatLocalTerminalInfoRepo> provider3, Provider<ChatNetworkRepo> provider4, Provider<ChatConnectionController> provider5, Provider<LocalRepoCleaner> provider6, Provider<IdGenerator> provider7, Provider<ChatPushDelegate> provider8, Provider<RxSchedulers> provider9, Provider<QuickRepliesDelegate> provider10, Provider<ChatLocalHistoryRepo> provider11, Provider<ChatExternalTerminationMessageProvider> provider12, Provider<SecurityProviderInstaller> provider13) {
        this.f38114a = provider;
        this.f38115b = provider2;
        this.f38116c = provider3;
        this.f38117d = provider4;
        this.f38118e = provider5;
        this.f38119f = provider6;
        this.f38120g = provider7;
        this.f38121h = provider8;
        this.f38122i = provider9;
        this.f38123j = provider10;
        this.f38124k = provider11;
        this.f38125l = provider12;
        this.f38126m = provider13;
    }

    public static ChatEngineDependencies_Factory a(Provider<ChatLocalMessagesRepo> provider, Provider<ChatLocalRepo> provider2, Provider<ChatLocalTerminalInfoRepo> provider3, Provider<ChatNetworkRepo> provider4, Provider<ChatConnectionController> provider5, Provider<LocalRepoCleaner> provider6, Provider<IdGenerator> provider7, Provider<ChatPushDelegate> provider8, Provider<RxSchedulers> provider9, Provider<QuickRepliesDelegate> provider10, Provider<ChatLocalHistoryRepo> provider11, Provider<ChatExternalTerminationMessageProvider> provider12, Provider<SecurityProviderInstaller> provider13) {
        return new ChatEngineDependencies_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static ChatEngineDependencies c(ChatLocalMessagesRepo chatLocalMessagesRepo, ChatLocalRepo chatLocalRepo, ChatLocalTerminalInfoRepo chatLocalTerminalInfoRepo, ChatNetworkRepo chatNetworkRepo, ChatConnectionController chatConnectionController, LocalRepoCleaner localRepoCleaner, IdGenerator idGenerator, ChatPushDelegate chatPushDelegate, RxSchedulers rxSchedulers, QuickRepliesDelegate quickRepliesDelegate, ChatLocalHistoryRepo chatLocalHistoryRepo, ChatExternalTerminationMessageProvider chatExternalTerminationMessageProvider, SecurityProviderInstaller securityProviderInstaller) {
        return new ChatEngineDependencies(chatLocalMessagesRepo, chatLocalRepo, chatLocalTerminalInfoRepo, chatNetworkRepo, chatConnectionController, localRepoCleaner, idGenerator, chatPushDelegate, rxSchedulers, quickRepliesDelegate, chatLocalHistoryRepo, chatExternalTerminationMessageProvider, securityProviderInstaller);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatEngineDependencies get() {
        return c(this.f38114a.get(), this.f38115b.get(), this.f38116c.get(), this.f38117d.get(), this.f38118e.get(), this.f38119f.get(), this.f38120g.get(), this.f38121h.get(), this.f38122i.get(), this.f38123j.get(), this.f38124k.get(), this.f38125l.get(), this.f38126m.get());
    }
}
