package eu.bolt.chat.client;

import eu.bolt.chat.data.message.MessageEvent;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: ChatManager.kt */
/* loaded from: classes5.dex */
public interface ChatLifeCycleManager {
    Object d(MessageEvent.LifeCycle.Finish finish, Continuation<? super Unit> continuation);

    Object h(MessageEvent.LifeCycle.Start start, Continuation<? super Unit> continuation);

    Object l(List<String> list, Continuation<? super Unit> continuation);
}
