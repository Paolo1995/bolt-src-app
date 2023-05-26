package eu.bolt.chat.client;

import eu.bolt.chat.data.ChatPushMessage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: ChatNotificationManager.kt */
/* loaded from: classes5.dex */
public interface InternalNotificationManager extends ChatNotificationManager {
    Object b(String str, Continuation<? super Unit> continuation);

    Object c(ChatPushMessage chatPushMessage, Continuation<? super Unit> continuation);
}
