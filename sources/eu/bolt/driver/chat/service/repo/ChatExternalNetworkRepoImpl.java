package eu.bolt.driver.chat.service.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatHistoryEntity;
import eu.bolt.chat.chatcore.network.external.ChatExternalNetworkRepo;
import eu.bolt.driver.chat.network.ActiveChats;
import eu.bolt.driver.chat.network.ChatClient;
import eu.bolt.driver.chat.network.ChatHistory;
import eu.bolt.driver.chat.service.repo.ChatExternalNetworkRepoImpl;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatExternalNetworkRepoImpl.kt */
/* loaded from: classes5.dex */
public final class ChatExternalNetworkRepoImpl implements ChatExternalNetworkRepo {

    /* renamed from: a  reason: collision with root package name */
    private final ChatClient f40498a;

    /* renamed from: b  reason: collision with root package name */
    private final ActiveChatsMapper f40499b;

    /* renamed from: c  reason: collision with root package name */
    private final ChatHistoryMapper f40500c;

    /* renamed from: d  reason: collision with root package name */
    private final MessageTranslationRatingMapper f40501d;

    @Inject
    public ChatExternalNetworkRepoImpl(ChatClient apiClient, ActiveChatsMapper activeChatsMapper, ChatHistoryMapper chatHistoryMapper, MessageTranslationRatingMapper translationRatingMapper) {
        Intrinsics.f(apiClient, "apiClient");
        Intrinsics.f(activeChatsMapper, "activeChatsMapper");
        Intrinsics.f(chatHistoryMapper, "chatHistoryMapper");
        Intrinsics.f(translationRatingMapper, "translationRatingMapper");
        this.f40498a = apiClient;
        this.f40499b = activeChatsMapper;
        this.f40500c = chatHistoryMapper;
        this.f40501d = translationRatingMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatHistoryEntity h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ChatHistoryEntity) tmp0.invoke(obj);
    }

    @Override // eu.bolt.chat.chatcore.network.external.ChatExternalNetworkRepo
    public Single<List<ChatEntity>> b() {
        Single<ActiveChats> c8 = this.f40498a.c();
        final Function1<ActiveChats, List<? extends ChatEntity>> function1 = new Function1<ActiveChats, List<? extends ChatEntity>>() { // from class: eu.bolt.driver.chat.service.repo.ChatExternalNetworkRepoImpl$getActiveChats$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ChatEntity> invoke(ActiveChats it) {
                ActiveChatsMapper activeChatsMapper;
                Intrinsics.f(it, "it");
                activeChatsMapper = ChatExternalNetworkRepoImpl.this.f40499b;
                return activeChatsMapper.a(it);
            }
        };
        Single x7 = c8.x(new Function() { // from class: v6.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List g8;
                g8 = ChatExternalNetworkRepoImpl.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(x7, "override fun getActiveCh…apActiveChats(it) }\n    }");
        return x7;
    }

    @Override // eu.bolt.chat.chatcore.network.external.ChatExternalNetworkRepo
    public Single<ChatHistoryEntity> c(final String chatId) {
        Intrinsics.f(chatId, "chatId");
        Single<ChatHistory> e8 = this.f40498a.e(chatId);
        final Function1<ChatHistory, ChatHistoryEntity> function1 = new Function1<ChatHistory, ChatHistoryEntity>() { // from class: eu.bolt.driver.chat.service.repo.ChatExternalNetworkRepoImpl$getChatHistory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ChatHistoryEntity invoke(ChatHistory it) {
                ChatHistoryMapper chatHistoryMapper;
                Intrinsics.f(it, "it");
                chatHistoryMapper = ChatExternalNetworkRepoImpl.this.f40500c;
                return chatHistoryMapper.b(chatId, it);
            }
        };
        Single x7 = e8.x(new Function() { // from class: v6.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ChatHistoryEntity h8;
                h8 = ChatExternalNetworkRepoImpl.h(Function1.this, obj);
                return h8;
            }
        });
        Intrinsics.e(x7, "override fun getChatHist…story(chatId, it) }\n    }");
        return x7;
    }
}
