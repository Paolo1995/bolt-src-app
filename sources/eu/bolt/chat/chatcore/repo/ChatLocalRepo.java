package eu.bolt.chat.chatcore.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import j$.util.Optional;
import java.util.List;

/* compiled from: ChatLocalRepo.kt */
/* loaded from: classes5.dex */
public interface ChatLocalRepo {
    Maybe<List<ChatEntity>> b();

    Completable c(ChatEntity chatEntity);

    Observable<Optional<ChatEntity>> d(OrderHandleEntity orderHandleEntity);

    Single<ChatEntity> e(String str);

    Completable f(List<ChatEntity> list);

    Maybe<ChatEntity> g();

    void h(ChatEntity chatEntity);
}
