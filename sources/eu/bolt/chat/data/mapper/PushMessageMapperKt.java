package eu.bolt.chat.data.mapper;

import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ChatPushMessage;
import eu.bolt.chat.data.ChatStatus;
import eu.bolt.chat.data.message.ChatMessage;
import eu.bolt.chat.data.util.MessageDirectionDetector;
import eu.bolt.chat.network.data.ChatPushMessageNet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushMessageMapper.kt */
/* loaded from: classes5.dex */
public final class PushMessageMapperKt {
    private static final Chat a(ChatPushMessageNet chatPushMessageNet) {
        return new Chat(chatPushMessageNet.a(), chatPushMessageNet.f(), chatPushMessageNet.b(), chatPushMessageNet.e(), OrderHandleMapperKt.a(chatPushMessageNet.d()), ChatStatus.STARTED);
    }

    public static final ChatPushMessage b(ChatPushMessageNet chatPushMessageNet, MessageDirectionDetector directionDetector) {
        Intrinsics.f(chatPushMessageNet, "<this>");
        Intrinsics.f(directionDetector, "directionDetector");
        Chat a8 = a(chatPushMessageNet);
        ChatMessage c8 = MessageMapperKt.c(chatPushMessageNet.c(), chatPushMessageNet.a(), directionDetector);
        if (c8 != null) {
            return new ChatPushMessage(a8, c8);
        }
        return null;
    }
}
