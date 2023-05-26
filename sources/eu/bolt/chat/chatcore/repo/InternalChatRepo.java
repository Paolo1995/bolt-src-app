package eu.bolt.chat.chatcore.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatRequestReplySuggestionsEntity;
import io.reactivex.Completable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: InternalChatRepo.kt */
/* loaded from: classes5.dex */
public interface InternalChatRepo extends ChatRepo {

    /* compiled from: InternalChatRepo.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(InternalChatRepo internalChatRepo, ChatEntity chatEntity, List list, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    list = CollectionsKt__CollectionsKt.k();
                }
                internalChatRepo.k(chatEntity, list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createOrUpdateChat");
        }
    }

    void a(ChatRequestReplySuggestionsEntity chatRequestReplySuggestionsEntity);

    Completable c(ChatEntity chatEntity);

    void f(List<ChatMessageEntity> list);

    Completable g(ChatMessageEntity chatMessageEntity);

    void k(ChatEntity chatEntity, List<ChatMessageEntity> list);

    void m(ChatMessageEntity chatMessageEntity);
}
