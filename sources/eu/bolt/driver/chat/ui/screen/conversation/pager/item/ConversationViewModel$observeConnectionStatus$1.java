package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.entity.ChatConnectionState;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
/* loaded from: classes5.dex */
public final class ConversationViewModel$observeConnectionStatus$1 extends Lambda implements Function1<Unit, ObservableSource<? extends ReconnectionState>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ConversationViewModel f40685f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$observeConnectionStatus$1(ConversationViewModel conversationViewModel) {
        super(1);
        this.f40685f = conversationViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReconnectionState g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ReconnectionState) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: d */
    public final ObservableSource<? extends ReconnectionState> invoke(Unit it) {
        ChatConnectionProvider chatConnectionProvider;
        Intrinsics.f(it, "it");
        chatConnectionProvider = this.f40685f.f40677j;
        Observable<ChatConnectionState> d8 = chatConnectionProvider.d();
        final AnonymousClass1 anonymousClass1 = new Function1<ChatConnectionState, Boolean>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel$observeConnectionStatus$1.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ChatConnectionState it2) {
                boolean z7;
                Intrinsics.f(it2, "it");
                if (it2 == ChatConnectionState.CONNECTED) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<ChatConnectionState> filter = d8.filter(new Predicate() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.a0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean e8;
                e8 = ConversationViewModel$observeConnectionStatus$1.e(Function1.this, obj);
                return e8;
            }
        });
        final AnonymousClass2 anonymousClass2 = new Function1<ChatConnectionState, ReconnectionState>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel$observeConnectionStatus$1.2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ReconnectionState invoke(ChatConnectionState it2) {
                Intrinsics.f(it2, "it");
                return ReconnectionState.CONNECTED;
            }
        };
        return filter.map(new Function() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.b0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ReconnectionState g8;
                g8 = ConversationViewModel$observeConnectionStatus$1.g(Function1.this, obj);
                return g8;
            }
        }).startWith((Observable<R>) ReconnectionState.RECONNECTION_FAILED);
    }
}
