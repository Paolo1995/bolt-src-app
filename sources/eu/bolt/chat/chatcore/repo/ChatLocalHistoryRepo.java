package eu.bolt.chat.chatcore.repo;

import eu.bolt.chat.chatcore.entity.ChatHistoryEntity;
import io.reactivex.Completable;

/* compiled from: ChatLocalHistoryRepo.kt */
/* loaded from: classes5.dex */
public interface ChatLocalHistoryRepo {
    Completable a(ChatHistoryEntity chatHistoryEntity);
}
