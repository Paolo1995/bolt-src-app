package eu.bolt.chat.chatcore.connection;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.chat.chatcore.ChatKit;
import eu.bolt.chat.chatcore.entity.ChatConnectionState;
import eu.bolt.chat.tools.logger.Logger;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatConnectionControllerImpl.kt */
@Singleton
/* loaded from: classes5.dex */
public final class ChatConnectionControllerImpl implements ChatConnectionProvider, ChatConnectionController {

    /* renamed from: a  reason: collision with root package name */
    private final Logger f38066a = ChatKit.f37877a.g();

    /* renamed from: b  reason: collision with root package name */
    private final PublishRelay<Unit> f38067b;

    /* renamed from: c  reason: collision with root package name */
    private final BehaviorRelay<ChatConnectionState> f38068c;

    @Inject
    public ChatConnectionControllerImpl() {
        PublishRelay<Unit> e8 = PublishRelay.e();
        Intrinsics.e(e8, "create<Unit>()");
        this.f38067b = e8;
        BehaviorRelay<ChatConnectionState> f8 = BehaviorRelay.f(ChatConnectionState.DISCONNECTED);
        Intrinsics.e(f8, "createDefault(ChatConnectionState.DISCONNECTED)");
        this.f38068c = f8;
    }

    @Override // eu.bolt.chat.chatcore.connection.ChatConnectionController
    public void a() {
        this.f38067b.accept(Unit.f50853a);
        this.f38066a.b("reconnect failed");
        b(ChatConnectionState.DISCONNECTED);
    }

    @Override // eu.bolt.chat.chatcore.connection.ChatConnectionController
    public void b(ChatConnectionState chatConnectionState) {
        Intrinsics.f(chatConnectionState, "chatConnectionState");
        synchronized (this.f38068c) {
            Logger logger = this.f38066a;
            logger.b("connection state " + chatConnectionState.c());
            this.f38068c.accept(chatConnectionState);
            Unit unit = Unit.f50853a;
        }
    }

    @Override // eu.bolt.chat.chatcore.connection.ChatConnectionProvider
    public ChatConnectionState c() {
        ChatConnectionState chatConnectionState;
        synchronized (this.f38068c) {
            ChatConnectionState g8 = this.f38068c.g();
            if (g8 != null) {
                chatConnectionState = g8;
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        Intrinsics.e(chatConnectionState, "synchronized(connectionS…ateRelay.value)\n        }");
        return chatConnectionState;
    }

    @Override // eu.bolt.chat.chatcore.connection.ChatConnectionProvider
    public Observable<ChatConnectionState> d() {
        Observable<ChatConnectionState> distinctUntilChanged = this.f38068c.distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "connectionStateRelay.distinctUntilChanged()");
        return distinctUntilChanged;
    }

    @Override // eu.bolt.chat.chatcore.connection.ChatConnectionController
    public synchronized void e() {
        b(ChatConnectionState.DISCONNECTED);
    }

    @Override // eu.bolt.chat.chatcore.connection.ChatConnectionProvider
    public Observable<Unit> f() {
        return this.f38067b;
    }

    @Override // eu.bolt.chat.chatcore.connection.ChatConnectionController
    public synchronized void g() {
        b(ChatConnectionState.CONNECTED);
    }
}
