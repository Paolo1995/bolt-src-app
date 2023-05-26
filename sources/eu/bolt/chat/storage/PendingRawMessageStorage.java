package eu.bolt.chat.storage;

import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: PendingRawMessageStorage.kt */
/* loaded from: classes5.dex */
public interface PendingRawMessageStorage {
    Object a(String str, Continuation<? super Unit> continuation);

    Object b(Set<String> set, String str, Continuation<? super Unit> continuation);

    Object c(String str, Continuation<? super List<PendingRawMessage>> continuation);

    Object d(Set<String> set, Continuation<? super Unit> continuation);

    Object e(PendingRawMessage pendingRawMessage, String str, Continuation<? super Unit> continuation);
}
