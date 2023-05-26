package ee.mtakso.driver.service.chat;

import ee.mtakso.driver.network.client.contact.ChatInitialServiceMessage;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.entity.ChatMessageType;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessageMapper.kt */
/* loaded from: classes3.dex */
public final class ChatMessageMapper {
    private final ChatMessageEntity b(String str, ChatInitialServiceMessage chatInitialServiceMessage) {
        List k8;
        String b8 = chatInitialServiceMessage.b();
        ChatMessageType chatMessageType = ChatMessageType.SERVICE;
        k8 = CollectionsKt__CollectionsKt.k();
        return new ChatMessageEntity(b8, str, chatMessageType, k8, chatInitialServiceMessage.c(), null, "", "", chatInitialServiceMessage.a(), ChatMessageStatus.DeliveredToBackend.f38163b, false, 0, chatInitialServiceMessage.d(), null, 32, null);
    }

    public final List<ChatMessageEntity> a(String chatId, List<ChatInitialServiceMessage> list) {
        List<ChatMessageEntity> k8;
        int v7;
        Intrinsics.f(chatId, "chatId");
        if (list != null) {
            v7 = CollectionsKt__IterablesKt.v(list, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (ChatInitialServiceMessage chatInitialServiceMessage : list) {
                arrayList.add(b(chatId, chatInitialServiceMessage));
            }
            return arrayList;
        }
        k8 = CollectionsKt__CollectionsKt.k();
        return k8;
    }
}
