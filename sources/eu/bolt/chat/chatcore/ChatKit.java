package eu.bolt.chat.chatcore;

import eu.bolt.chat.chatcore.engine.ChatEngineTypeProvider;
import eu.bolt.chat.chatcore.engine.DefaultChatEngineTypeProvider;
import eu.bolt.chat.chatcore.foreground.ForegroundStateDispatcher;
import eu.bolt.chat.chatcore.foreground.ForegroundStateProvider;
import eu.bolt.chat.chatcore.network.connection.NetworkConnectionInfoProvider;
import eu.bolt.chat.chatcore.network.external.ChatExternalNetworkRepo;
import eu.bolt.chat.chatcore.network.external.ChatExternalTerminationMessageProvider;
import eu.bolt.chat.chatcore.push.ChatPushDelegate;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.chat.tools.deps.RxSchedulers;
import eu.bolt.chat.tools.logger.Logger;
import eu.bolt.chat.tools.uniqueid.IdGenerator;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatKit.kt */
/* loaded from: classes5.dex */
public final class ChatKit {

    /* renamed from: a  reason: collision with root package name */
    public static final ChatKit f37877a = new ChatKit();

    /* renamed from: b  reason: collision with root package name */
    private static Logger f37878b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f37879c;

    /* renamed from: d  reason: collision with root package name */
    private static Dependencies f37880d;

    /* renamed from: e  reason: collision with root package name */
    private static ChatEngineTypeProvider f37881e;

    /* renamed from: f  reason: collision with root package name */
    private static ForegroundStateDispatcher f37882f;

    /* compiled from: ChatKit.kt */
    /* loaded from: classes5.dex */
    public static final class Dependencies {

        /* renamed from: a  reason: collision with root package name */
        private final NetworkConnectionInfoProvider f37883a;

        /* renamed from: b  reason: collision with root package name */
        private final IdGenerator f37884b;

        /* renamed from: c  reason: collision with root package name */
        private final RxSchedulers f37885c;

        /* renamed from: d  reason: collision with root package name */
        private final UserInfoProvider f37886d;

        /* renamed from: e  reason: collision with root package name */
        private final ChatPushDelegate f37887e;

        /* renamed from: f  reason: collision with root package name */
        private final ChatExternalNetworkRepo f37888f;

        /* renamed from: g  reason: collision with root package name */
        private final ForegroundStateProvider f37889g;

        /* renamed from: h  reason: collision with root package name */
        private final ChatExternalTerminationMessageProvider f37890h;

        @Inject
        public Dependencies(NetworkConnectionInfoProvider networkConnectionInfoProvider, IdGenerator idGenerator, RxSchedulers deps, UserInfoProvider userInfoProvider, ChatPushDelegate pushDelegate, ChatExternalNetworkRepo chatExternalNetworkRepo, ForegroundStateProvider foregroundStateProvider, ChatExternalTerminationMessageProvider chatTerminationMessageProvider) {
            Intrinsics.f(networkConnectionInfoProvider, "networkConnectionInfoProvider");
            Intrinsics.f(idGenerator, "idGenerator");
            Intrinsics.f(deps, "deps");
            Intrinsics.f(userInfoProvider, "userInfoProvider");
            Intrinsics.f(pushDelegate, "pushDelegate");
            Intrinsics.f(chatExternalNetworkRepo, "chatExternalNetworkRepo");
            Intrinsics.f(foregroundStateProvider, "foregroundStateProvider");
            Intrinsics.f(chatTerminationMessageProvider, "chatTerminationMessageProvider");
            this.f37883a = networkConnectionInfoProvider;
            this.f37884b = idGenerator;
            this.f37885c = deps;
            this.f37886d = userInfoProvider;
            this.f37887e = pushDelegate;
            this.f37888f = chatExternalNetworkRepo;
            this.f37889g = foregroundStateProvider;
            this.f37890h = chatTerminationMessageProvider;
        }

        public final ChatExternalNetworkRepo a() {
            return this.f37888f;
        }

        public final ChatExternalTerminationMessageProvider b() {
            return this.f37890h;
        }

        public final RxSchedulers c() {
            return this.f37885c;
        }

        public final ForegroundStateProvider d() {
            return this.f37889g;
        }

        public final IdGenerator e() {
            return this.f37884b;
        }

        public final NetworkConnectionInfoProvider f() {
            return this.f37883a;
        }

        public final ChatPushDelegate g() {
            return this.f37887e;
        }

        public final UserInfoProvider h() {
            return this.f37886d;
        }
    }

    private ChatKit() {
    }

    public static /* synthetic */ void l(ChatKit chatKit, Logger logger, Dependencies dependencies, ChatEngineTypeProvider chatEngineTypeProvider, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            chatEngineTypeProvider = new DefaultChatEngineTypeProvider();
        }
        chatKit.k(logger, dependencies, chatEngineTypeProvider);
    }

    public final ChatEngineTypeProvider a() {
        ChatEngineTypeProvider chatEngineTypeProvider = f37881e;
        if (chatEngineTypeProvider != null) {
            return chatEngineTypeProvider;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final ChatExternalNetworkRepo b() {
        ChatExternalNetworkRepo chatExternalNetworkRepo;
        Dependencies dependencies = f37880d;
        if (dependencies != null) {
            chatExternalNetworkRepo = dependencies.a();
        } else {
            chatExternalNetworkRepo = null;
        }
        if (chatExternalNetworkRepo != null) {
            return chatExternalNetworkRepo;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final ChatExternalTerminationMessageProvider c() {
        ChatExternalTerminationMessageProvider chatExternalTerminationMessageProvider;
        Dependencies dependencies = f37880d;
        if (dependencies != null) {
            chatExternalTerminationMessageProvider = dependencies.b();
        } else {
            chatExternalTerminationMessageProvider = null;
        }
        if (chatExternalTerminationMessageProvider != null) {
            return chatExternalTerminationMessageProvider;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final RxSchedulers d() {
        RxSchedulers rxSchedulers;
        Dependencies dependencies = f37880d;
        if (dependencies != null) {
            rxSchedulers = dependencies.c();
        } else {
            rxSchedulers = null;
        }
        if (rxSchedulers != null) {
            return rxSchedulers;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final ForegroundStateProvider e() {
        ForegroundStateProvider foregroundStateProvider;
        Dependencies dependencies = f37880d;
        if (dependencies != null) {
            foregroundStateProvider = dependencies.d();
        } else {
            foregroundStateProvider = null;
        }
        if (foregroundStateProvider != null) {
            return foregroundStateProvider;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final IdGenerator f() {
        IdGenerator idGenerator;
        Dependencies dependencies = f37880d;
        if (dependencies != null) {
            idGenerator = dependencies.e();
        } else {
            idGenerator = null;
        }
        if (idGenerator != null) {
            return idGenerator;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final Logger g() {
        Logger logger = f37878b;
        if (logger != null) {
            return logger;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final NetworkConnectionInfoProvider h() {
        NetworkConnectionInfoProvider networkConnectionInfoProvider;
        Dependencies dependencies = f37880d;
        if (dependencies != null) {
            networkConnectionInfoProvider = dependencies.f();
        } else {
            networkConnectionInfoProvider = null;
        }
        if (networkConnectionInfoProvider != null) {
            return networkConnectionInfoProvider;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final ChatPushDelegate i() {
        ChatPushDelegate chatPushDelegate;
        Dependencies dependencies = f37880d;
        if (dependencies != null) {
            chatPushDelegate = dependencies.g();
        } else {
            chatPushDelegate = null;
        }
        if (chatPushDelegate != null) {
            return chatPushDelegate;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final UserInfoProvider j() {
        UserInfoProvider userInfoProvider;
        Dependencies dependencies = f37880d;
        if (dependencies != null) {
            userInfoProvider = dependencies.h();
        } else {
            userInfoProvider = null;
        }
        if (userInfoProvider != null) {
            return userInfoProvider;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void k(Logger logger, Dependencies deps, ChatEngineTypeProvider chatEngineTypeProvider) {
        Intrinsics.f(logger, "logger");
        Intrinsics.f(deps, "deps");
        Intrinsics.f(chatEngineTypeProvider, "chatEngineTypeProvider");
        if (!f37879c) {
            f37879c = true;
            f37878b = logger;
            f37880d = deps;
            f37881e = chatEngineTypeProvider;
            ForegroundStateDispatcher foregroundStateDispatcher = new ForegroundStateDispatcher(deps.c(), deps.d(), eu.bolt.chat.ChatKit.f37850a.a());
            foregroundStateDispatcher.c();
            f37882f = foregroundStateDispatcher;
            return;
        }
        throw new IllegalStateException("ChatKit has been initialized".toString());
    }
}
