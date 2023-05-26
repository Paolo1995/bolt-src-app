package eu.bolt.chat.chatcore.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatHistoryEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageSeenConfirmationEntity;
import eu.bolt.chat.chatcore.entity.ChatRequestReplySuggestionsEntity;
import eu.bolt.chat.chatcore.entity.connection.ChatConnectionEntity;
import eu.bolt.chat.chatcore.network.repo.ChatEvent;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ChatNetworkRepo.kt */
/* loaded from: classes5.dex */
public interface ChatNetworkRepo {
    Completable a(ChatRequestReplySuggestionsEntity chatRequestReplySuggestionsEntity);

    Single<List<ChatEntity>> b();

    Single<ChatHistoryEntity> c(String str);

    Completable d(ChatConnectionEntity chatConnectionEntity, Function0<Unit> function0);

    Completable disconnect();

    Completable e(ChatMessageSeenConfirmationEntity chatMessageSeenConfirmationEntity);

    Completable f(ChatMessageEntity chatMessageEntity);

    Flowable<ChatEvent> g();
}
