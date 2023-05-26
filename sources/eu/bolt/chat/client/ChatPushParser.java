package eu.bolt.chat.client;

import eu.bolt.chat.data.ChatPushMessage;

/* compiled from: ChatPushParser.kt */
/* loaded from: classes5.dex */
public interface ChatPushParser {
    ChatPushMessage a(ChatPushPayload chatPushPayload);

    boolean b(ChatPushPayload chatPushPayload);
}
