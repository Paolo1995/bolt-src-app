package eu.bolt.chat.chatcore.repo.quickreply;

import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.entity.ChatConnectionState;
import eu.bolt.chat.chatcore.entity.ChatRequestReplySuggestionsEntity;
import eu.bolt.chat.chatcore.repo.ChatNetworkRepo;
import eu.bolt.chat.extensions.ChatRxExtensionsKt;
import eu.bolt.chat.tools.deps.RxSchedulers;
import eu.bolt.chat.tools.logger.Logger;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickRepliesDelegateImpl.kt */
@Singleton
/* loaded from: classes5.dex */
public final class QuickRepliesDelegateImpl implements QuickRepliesDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final ChatConnectionProvider f38502a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatNetworkRepo f38503b;

    /* renamed from: c  reason: collision with root package name */
    private final RxSchedulers f38504c;

    /* renamed from: d  reason: collision with root package name */
    private final Logger f38505d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Disposable> f38506e;

    @Inject
    public QuickRepliesDelegateImpl(ChatConnectionProvider chatConnectionProvider, ChatNetworkRepo chatNetworkRepo, RxSchedulers deps, Logger logger) {
        Intrinsics.f(chatConnectionProvider, "chatConnectionProvider");
        Intrinsics.f(chatNetworkRepo, "chatNetworkRepo");
        Intrinsics.f(deps, "deps");
        Intrinsics.f(logger, "logger");
        this.f38502a = chatConnectionProvider;
        this.f38503b = chatNetworkRepo;
        this.f38504c = deps;
        this.f38505d = logger;
        this.f38506e = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    @Override // eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegate
    public synchronized void a(final ChatRequestReplySuggestionsEntity entity) {
        Intrinsics.f(entity, "entity");
        Disposable disposable = this.f38506e.get(entity.a());
        boolean z7 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z7 = true;
        }
        if (z7) {
            return;
        }
        Logger logger = this.f38505d;
        logger.b("requesting quick replies for chat " + entity.a());
        Map<String, Disposable> map = this.f38506e;
        String a8 = entity.a();
        Observable<ChatConnectionState> d8 = this.f38502a.d();
        final QuickRepliesDelegateImpl$requestReplySuggestions$1 quickRepliesDelegateImpl$requestReplySuggestions$1 = new Function1<ChatConnectionState, Boolean>() { // from class: eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegateImpl$requestReplySuggestions$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ChatConnectionState it) {
                boolean z8;
                Intrinsics.f(it, "it");
                if (it == ChatConnectionState.CONNECTED) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                return Boolean.valueOf(z8);
            }
        };
        Observable<ChatConnectionState> take = d8.filter(new Predicate() { // from class: eu.bolt.chat.chatcore.repo.quickreply.a
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean g8;
                g8 = QuickRepliesDelegateImpl.g(Function1.this, obj);
                return g8;
            }
        }).take(1L);
        final Function1<ChatConnectionState, CompletableSource> function1 = new Function1<ChatConnectionState, CompletableSource>() { // from class: eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegateImpl$requestReplySuggestions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(ChatConnectionState it) {
                ChatNetworkRepo chatNetworkRepo;
                Intrinsics.f(it, "it");
                chatNetworkRepo = QuickRepliesDelegateImpl.this.f38503b;
                return chatNetworkRepo.a(entity);
            }
        };
        Completable I = take.switchMapCompletable(new Function() { // from class: eu.bolt.chat.chatcore.repo.quickreply.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource h8;
                h8 = QuickRepliesDelegateImpl.h(Function1.this, obj);
                return h8;
            }
        }).I(this.f38504c.b());
        Intrinsics.e(I, "@Synchronized\n    overri…         .observe()\n    }");
        map.put(a8, ChatRxExtensionsKt.x(I, null, null, null, 7, null));
    }

    @Override // eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegate
    public synchronized void b(String chatId) {
        Intrinsics.f(chatId, "chatId");
        Logger logger = this.f38505d;
        logger.b("Clearing quick replies request for chat " + chatId);
        Disposable remove = this.f38506e.remove(chatId);
        if (remove != null) {
            remove.dispose();
        }
    }

    @Override // eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegate
    public synchronized void c() {
        this.f38505d.b("Clearing all quick reply requests");
        Iterator<Map.Entry<String, Disposable>> it = this.f38506e.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().dispose();
            it.remove();
        }
    }
}
