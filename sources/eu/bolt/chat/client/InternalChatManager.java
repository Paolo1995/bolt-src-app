package eu.bolt.chat.client;

import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.QuickReplySuggestion;
import eu.bolt.chat.data.message.ChatMessage;
import eu.bolt.chat.data.message.ServiceMessage;
import eu.bolt.chat.data.message.UserMessage;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: ChatManager.kt */
/* loaded from: classes5.dex */
public interface InternalChatManager extends ChatManager, ChatLifeCycleManager {
    Object a(Chat chat, Continuation<? super Unit> continuation);

    Object b(Chat chat, List<? extends ChatMessage> list, Continuation<? super Unit> continuation);

    Object e(Continuation<? super Unit> continuation);

    Object g(Continuation<? super Chat> continuation);

    Object i(List<QuickReplySuggestion> list, Continuation<? super Unit> continuation);

    Object n(ServiceMessage serviceMessage, Continuation<? super Unit> continuation);

    Object p(UserMessage userMessage, Continuation<? super Unit> continuation);

    Object q(Continuation<? super Unit> continuation);
}
