package eu.bolt.chat.chatcore.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.chat.chatcore.entity.connection.ChatConnectionEntity;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import j$.util.Optional;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ChatRepo.kt */
/* loaded from: classes5.dex */
public interface ChatRepo {

    /* compiled from: ChatRepo.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ChatRepo chatRepo, Function0 function0, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 1) != 0) {
                    function0 = null;
                }
                chatRepo.l(function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disconnect");
        }
    }

    Flowable<List<ChatMessageEntity>> b(String str);

    Observable<Optional<ChatEntity>> d(OrderHandleEntity orderHandleEntity);

    Flowable<Integer> e(String str);

    Flowable<List<QuickReplyEntity>> h(String str);

    void i(ChatConnectionEntity chatConnectionEntity);

    void j(ChatConnectionEntity chatConnectionEntity);

    void l(Function0<Unit> function0);

    Single<TerminationInfo> n(String str);
}
