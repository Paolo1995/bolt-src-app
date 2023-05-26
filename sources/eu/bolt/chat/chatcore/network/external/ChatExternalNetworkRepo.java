package eu.bolt.chat.chatcore.network.external;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatHistoryEntity;
import io.reactivex.Single;
import java.util.List;

/* compiled from: ChatExternalNetworkRepo.kt */
/* loaded from: classes5.dex */
public interface ChatExternalNetworkRepo {
    Single<List<ChatEntity>> b();

    Single<ChatHistoryEntity> c(String str);
}
