package eu.bolt.chat.client;

import eu.bolt.chat.data.ChatPushMessage;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ChatPushHandler.kt */
/* loaded from: classes5.dex */
public interface ChatPushReceiver {
    Flow<ChatPushMessage> a();
}
