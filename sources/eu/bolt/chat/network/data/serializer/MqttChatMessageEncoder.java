package eu.bolt.chat.network.data.serializer;

import eu.bolt.chat.data.message.QuickReplyMessage;
import eu.bolt.chat.data.message.QuickReplyRequestMessage;
import eu.bolt.chat.data.message.UserSeenMessage;
import eu.bolt.chat.data.message.UserTextMessage;

/* compiled from: MqttChatMessageEncoder.kt */
/* loaded from: classes5.dex */
public interface MqttChatMessageEncoder {
    String a(QuickReplyMessage quickReplyMessage);

    String b(UserSeenMessage userSeenMessage);

    String c(UserTextMessage userTextMessage);

    String d(QuickReplyRequestMessage quickReplyRequestMessage);
}
