package eu.bolt.chat.data.mapper;

import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ChatHistory;
import eu.bolt.chat.data.EndChatInfo;
import eu.bolt.chat.data.message.ChatMessage;
import eu.bolt.chat.data.util.MessageDirectionDetector;
import eu.bolt.chat.network.data.ChatHistoryNet;
import eu.bolt.chat.network.data.EndChatEvent;
import eu.bolt.chat.network.data.MessageEventBase;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatHistoryMapper.kt */
/* loaded from: classes5.dex */
public final class ChatHistoryMapperKt {
    public static final ChatHistory a(ChatHistoryNet chatHistoryNet, String chatId, MessageDirectionDetector directionDetector) {
        EndChatInfo endChatInfo;
        Intrinsics.f(chatHistoryNet, "<this>");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(directionDetector, "directionDetector");
        Chat b8 = ChatMapperKt.b(chatHistoryNet.a(), chatId, chatHistoryNet.b());
        List<MessageEventBase> c8 = chatHistoryNet.c();
        ArrayList arrayList = new ArrayList();
        for (MessageEventBase messageEventBase : c8) {
            ChatMessage c9 = MessageMapperKt.c(messageEventBase, chatId, directionDetector);
            if (c9 != null) {
                arrayList.add(c9);
            }
        }
        EndChatEvent b9 = chatHistoryNet.b();
        if (b9 != null) {
            endChatInfo = ChatMapperKt.e(b9);
        } else {
            endChatInfo = null;
        }
        return new ChatHistory(b8, arrayList, endChatInfo);
    }
}
