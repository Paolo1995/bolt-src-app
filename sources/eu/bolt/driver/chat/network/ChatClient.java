package eu.bolt.driver.chat.network;

import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatClient.kt */
/* loaded from: classes5.dex */
public final class ChatClient {

    /* renamed from: a  reason: collision with root package name */
    private final ChatApi f40428a;

    @Inject
    public ChatClient(ChatApi api) {
        Intrinsics.f(api, "api");
        this.f40428a = api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActiveChats d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ActiveChats) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatHistory f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ChatHistory) tmp0.invoke(obj);
    }

    public final Single<ActiveChats> c() {
        Single<ServerResponse<ActiveChats>> b8 = this.f40428a.b();
        final ChatClient$getActiveChats$1 chatClient$getActiveChats$1 = new Function1<ServerResponse<ActiveChats>, ActiveChats>() { // from class: eu.bolt.driver.chat.network.ChatClient$getActiveChats$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveChats invoke(ServerResponse<ActiveChats> it) {
                Intrinsics.f(it, "it");
                return (ActiveChats) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = b8.x(new Function() { // from class: eu.bolt.driver.chat.network.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ActiveChats d8;
                d8 = ChatClient.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(x7, "api.getActiveChats()\n   … .map { it.exposeData() }");
        return x7;
    }

    public final Single<ChatHistory> e(String chatId) {
        Intrinsics.f(chatId, "chatId");
        Single<ServerResponse<ChatHistory>> c8 = this.f40428a.c(chatId);
        final ChatClient$getChatHistory$1 chatClient$getChatHistory$1 = new Function1<ServerResponse<ChatHistory>, ChatHistory>() { // from class: eu.bolt.driver.chat.network.ChatClient$getChatHistory$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ChatHistory invoke(ServerResponse<ChatHistory> it) {
                Intrinsics.f(it, "it");
                return (ChatHistory) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = c8.x(new Function() { // from class: eu.bolt.driver.chat.network.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ChatHistory f8;
                f8 = ChatClient.f(Function1.this, obj);
                return f8;
            }
        });
        Intrinsics.e(x7, "api.getChatHistory(chatI… .map { it.exposeData() }");
        return x7;
    }
}
