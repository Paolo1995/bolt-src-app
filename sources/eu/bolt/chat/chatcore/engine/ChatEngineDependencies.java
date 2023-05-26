package eu.bolt.chat.chatcore.engine;

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
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatEngineDependencies.kt */
/* loaded from: classes5.dex */
public final class ChatEngineDependencies {

    /* renamed from: a  reason: collision with root package name */
    private final ChatLocalMessagesRepo f38101a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatLocalRepo f38102b;

    /* renamed from: c  reason: collision with root package name */
    private final ChatLocalTerminalInfoRepo f38103c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatNetworkRepo f38104d;

    /* renamed from: e  reason: collision with root package name */
    private final ChatConnectionController f38105e;

    /* renamed from: f  reason: collision with root package name */
    private final LocalRepoCleaner f38106f;

    /* renamed from: g  reason: collision with root package name */
    private final IdGenerator f38107g;

    /* renamed from: h  reason: collision with root package name */
    private final ChatPushDelegate f38108h;

    /* renamed from: i  reason: collision with root package name */
    private final RxSchedulers f38109i;

    /* renamed from: j  reason: collision with root package name */
    private final QuickRepliesDelegate f38110j;

    /* renamed from: k  reason: collision with root package name */
    private final ChatLocalHistoryRepo f38111k;

    /* renamed from: l  reason: collision with root package name */
    private final ChatExternalTerminationMessageProvider f38112l;

    /* renamed from: m  reason: collision with root package name */
    private final SecurityProviderInstaller f38113m;

    @Inject
    public ChatEngineDependencies(ChatLocalMessagesRepo chatMessagesLocalRepo, ChatLocalRepo chatLocalRepo, ChatLocalTerminalInfoRepo chatLocalTerminalInfoRepo, ChatNetworkRepo chatNetworkRepo, ChatConnectionController connectionController, LocalRepoCleaner localRepoCleaner, IdGenerator idGenerator, ChatPushDelegate pushDelegate, RxSchedulers rxSchedulers, QuickRepliesDelegate quickRepliesDelegate, ChatLocalHistoryRepo chatLocalHistoryRepo, ChatExternalTerminationMessageProvider terminationMessageProvider, SecurityProviderInstaller securityProviderInstaller) {
        Intrinsics.f(chatMessagesLocalRepo, "chatMessagesLocalRepo");
        Intrinsics.f(chatLocalRepo, "chatLocalRepo");
        Intrinsics.f(chatLocalTerminalInfoRepo, "chatLocalTerminalInfoRepo");
        Intrinsics.f(chatNetworkRepo, "chatNetworkRepo");
        Intrinsics.f(connectionController, "connectionController");
        Intrinsics.f(localRepoCleaner, "localRepoCleaner");
        Intrinsics.f(idGenerator, "idGenerator");
        Intrinsics.f(pushDelegate, "pushDelegate");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(quickRepliesDelegate, "quickRepliesDelegate");
        Intrinsics.f(chatLocalHistoryRepo, "chatLocalHistoryRepo");
        Intrinsics.f(terminationMessageProvider, "terminationMessageProvider");
        Intrinsics.f(securityProviderInstaller, "securityProviderInstaller");
        this.f38101a = chatMessagesLocalRepo;
        this.f38102b = chatLocalRepo;
        this.f38103c = chatLocalTerminalInfoRepo;
        this.f38104d = chatNetworkRepo;
        this.f38105e = connectionController;
        this.f38106f = localRepoCleaner;
        this.f38107g = idGenerator;
        this.f38108h = pushDelegate;
        this.f38109i = rxSchedulers;
        this.f38110j = quickRepliesDelegate;
        this.f38111k = chatLocalHistoryRepo;
        this.f38112l = terminationMessageProvider;
        this.f38113m = securityProviderInstaller;
    }

    public final ChatLocalHistoryRepo a() {
        return this.f38111k;
    }

    public final ChatLocalRepo b() {
        return this.f38102b;
    }

    public final ChatLocalTerminalInfoRepo c() {
        return this.f38103c;
    }

    public final ChatLocalMessagesRepo d() {
        return this.f38101a;
    }

    public final ChatNetworkRepo e() {
        return this.f38104d;
    }

    public final ChatConnectionController f() {
        return this.f38105e;
    }

    public final IdGenerator g() {
        return this.f38107g;
    }

    public final LocalRepoCleaner h() {
        return this.f38106f;
    }

    public final ChatPushDelegate i() {
        return this.f38108h;
    }

    public final QuickRepliesDelegate j() {
        return this.f38110j;
    }

    public final RxSchedulers k() {
        return this.f38109i;
    }

    public final SecurityProviderInstaller l() {
        return this.f38113m;
    }

    public final ChatExternalTerminationMessageProvider m() {
        return this.f38112l;
    }
}
