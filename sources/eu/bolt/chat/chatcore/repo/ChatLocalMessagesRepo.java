package eu.bolt.chat.chatcore.repo;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.List;

/* compiled from: ChatLocalMessagesRepo.kt */
/* loaded from: classes5.dex */
public interface ChatLocalMessagesRepo {
    Flowable<List<ChatMessageEntity>> b(String str);

    Flowable<Integer> e(String str);

    Completable f(List<String> list);

    Completable g(ChatMessageEntity chatMessageEntity);

    Flowable<ChatMessageEntity> h();

    Single<List<ChatMessageEntity>> i(String str);

    Completable j(List<String> list);

    Completable k(ChatMessageEntity chatMessageEntity);

    Completable l(String str, ChatMessageStatus chatMessageStatus);

    Flowable<List<ChatMessageEntity>> m();

    void n(List<ChatMessageEntity> list);

    Single<List<ChatMessageEntity>> o();
}
