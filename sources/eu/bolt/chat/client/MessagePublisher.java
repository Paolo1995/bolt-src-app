package eu.bolt.chat.client;

import eu.bolt.chat.data.message.QuickReplyMessage;
import eu.bolt.chat.data.message.QuickReplyRequestMessage;
import eu.bolt.chat.data.message.UserSeenMessage;
import eu.bolt.chat.data.message.UserTextMessage;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: MessagePublisher.kt */
/* loaded from: classes5.dex */
public interface MessagePublisher {
    Object a(QuickReplyMessage quickReplyMessage, Continuation<? super Boolean> continuation);

    Object b(String str, Continuation<? super Unit> continuation);

    Object c(UserTextMessage userTextMessage, Continuation<? super Boolean> continuation);

    Object d(QuickReplyRequestMessage quickReplyRequestMessage, Continuation<? super Unit> continuation);

    Object e(UserSeenMessage userSeenMessage, Continuation<? super Boolean> continuation);

    Object f(String str, Set<String> set, Continuation<? super Set<String>> continuation);
}
