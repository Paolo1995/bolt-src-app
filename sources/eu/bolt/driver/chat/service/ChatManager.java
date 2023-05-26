package eu.bolt.driver.chat.service;

import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.entity.ChatConnectionState;
import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.chat.chatcore.entity.connection.ChatConnectionEntity;
import eu.bolt.chat.chatcore.interactor.CreateChatInteractor;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.driver.chat.ActiveOrdersSource;
import eu.bolt.driver.chat.DynamicChatConfig;
import eu.bolt.driver.chat.DynamicChatConfigProvider;
import eu.bolt.driver.chat.StaticChatConfig;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatManager.kt */
/* loaded from: classes5.dex */
public final class ChatManager {

    /* renamed from: a  reason: collision with root package name */
    private final StaticChatConfig f40454a;

    /* renamed from: b  reason: collision with root package name */
    private final DynamicChatConfigProvider f40455b;

    /* renamed from: c  reason: collision with root package name */
    private final ChatRepo f40456c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatConnectionProvider f40457d;

    /* renamed from: e  reason: collision with root package name */
    private final CreateChatInteractor f40458e;

    @Inject
    public ChatManager(StaticChatConfig appConfig, DynamicChatConfigProvider configProvider, ChatRepo repo, ChatConnectionProvider connectionProvider, CreateChatInteractor createChatInteractor) {
        Intrinsics.f(appConfig, "appConfig");
        Intrinsics.f(configProvider, "configProvider");
        Intrinsics.f(repo, "repo");
        Intrinsics.f(connectionProvider, "connectionProvider");
        Intrinsics.f(createChatInteractor, "createChatInteractor");
        this.f40454a = appConfig;
        this.f40455b = configProvider;
        this.f40456c = repo;
        this.f40457d = connectionProvider;
        this.f40458e = createChatInteractor;
    }

    private final ChatConnectionEntity d() {
        DynamicChatConfig a8 = this.f40455b.a();
        String b8 = this.f40454a.b();
        String str = e("device_type", "android") + e("version", this.f40454a.a()) + e("device_id", this.f40454a.d()) + e("device_name", this.f40454a.c()) + e("language", a8.c()) + e("driver_id", a8.b()) + e("session_id", a8.e()) + e("country", a8.a()) + e("mqtt_client_id", a8.d());
        Intrinsics.e(str, "toString()");
        return new ChatConnectionEntity(b8, 443, "mqtt", str, true);
    }

    private final String e(String str, String str2) {
        return str + "=" + str2 + "&";
    }

    private final ChatConnectionState i() {
        return this.f40457d.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public final void f() {
        ChatConnectionState i8 = i();
        if (i8.e()) {
            Kalev.l("Unexpected mqtt connection state: " + i8);
            return;
        }
        ChatConnectionEntity d8 = d();
        Kalev.b("Establishing mqtt connection with config " + d8);
        this.f40456c.i(d());
    }

    public final Completable g(NewConversationParams params) {
        Intrinsics.f(params, "params");
        CreateChatInteractor createChatInteractor = this.f40458e;
        String a8 = params.a();
        long e8 = params.e();
        return createChatInteractor.b(new CreateChatInteractor.ChatArgs(a8, null, params.f(), params.b(), e8, params.d(), params.c()));
    }

    public final void h() {
        ChatConnectionState i8 = i();
        if (i8 != ChatConnectionState.DISCONNECTED) {
            Kalev.b("Terminating mqtt connection...");
            ChatRepo.DefaultImpls.a(this.f40456c, null, 1, null);
            return;
        }
        Kalev.l("Unexpected mqtt connection state: " + i8);
    }

    public final Observable<List<ConversationPreviewData>> j(ActiveOrdersSource ordersSource) {
        Intrinsics.f(ordersSource, "ordersSource");
        Observable<List<ChatEntity>> l8 = l(ordersSource);
        final ChatManager$observeActiveConversationPreviews$1 chatManager$observeActiveConversationPreviews$1 = new ChatManager$observeActiveConversationPreviews$1(this);
        Observable switchMap = l8.switchMap(new Function() { // from class: eu.bolt.driver.chat.service.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource k8;
                k8 = ChatManager.k(Function1.this, obj);
                return k8;
            }
        });
        Intrinsics.e(switchMap, "fun observeActiveConvers…bined\n            }\n    }");
        return switchMap;
    }

    public final Observable<List<ChatEntity>> l(ActiveOrdersSource ordersSource) {
        Intrinsics.f(ordersSource, "ordersSource");
        Observable<List<OrderHandleEntity>> distinctUntilChanged = ordersSource.a().distinctUntilChanged();
        final ChatManager$observeActiveConversations$1 chatManager$observeActiveConversations$1 = new ChatManager$observeActiveConversations$1(this);
        Observable switchMap = distinctUntilChanged.switchMap(new Function() { // from class: eu.bolt.driver.chat.service.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m8;
                m8 = ChatManager.m(Function1.this, obj);
                return m8;
            }
        });
        Intrinsics.e(switchMap, "fun observeActiveConvers…        }\n        }\n    }");
        return switchMap;
    }

    public final Observable<ChatConnectionState> n() {
        return this.f40457d.d();
    }

    public final void o() {
        ChatConnectionEntity d8 = d();
        Kalev.b("Checking active chats with config " + d8);
        this.f40456c.j(d8);
    }
}
