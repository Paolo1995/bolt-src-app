package eu.bolt.chat.client;

import eu.bolt.chat.storage.ActiveChatIdStorage;
import eu.bolt.chat.storage.PendingRawMessageStorage;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatClientDisposer.kt */
/* loaded from: classes5.dex */
public final class ChatClientDisposerKt {
    public static final ChatClientDisposer a(PendingRawMessageStorage pendingRawMessageStorage, ActiveChatIdStorage activeChatIdStorage, CoroutineContext context) {
        Intrinsics.f(pendingRawMessageStorage, "pendingRawMessageStorage");
        Intrinsics.f(activeChatIdStorage, "activeChatIdStorage");
        Intrinsics.f(context, "context");
        return new DefaultChatClientDisposer(pendingRawMessageStorage, activeChatIdStorage, context);
    }
}
