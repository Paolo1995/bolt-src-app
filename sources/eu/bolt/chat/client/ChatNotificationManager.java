package eu.bolt.chat.client;

import eu.bolt.chat.async.ObservableFlow;
import eu.bolt.chat.data.ChatPushMessage;

/* compiled from: ChatNotificationManager.kt */
/* loaded from: classes5.dex */
public interface ChatNotificationManager {
    ObservableFlow<String> a();

    ObservableFlow<ChatPushMessage> d();
}
