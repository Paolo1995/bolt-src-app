package eu.bolt.chat.client;

import eu.bolt.chat.storage.ActiveChatIdStorage;
import eu.bolt.chat.storage.PendingRawMessageStorage;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatClientDisposer.kt */
/* loaded from: classes5.dex */
final class DefaultChatClientDisposer implements ChatClientDisposer {

    /* renamed from: a  reason: collision with root package name */
    private final PendingRawMessageStorage f38832a;

    /* renamed from: b  reason: collision with root package name */
    private final ActiveChatIdStorage f38833b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineContext f38834c;

    public DefaultChatClientDisposer(PendingRawMessageStorage pendingRawMessageStorage, ActiveChatIdStorage activeChatIdStorage, CoroutineContext context) {
        Intrinsics.f(pendingRawMessageStorage, "pendingRawMessageStorage");
        Intrinsics.f(activeChatIdStorage, "activeChatIdStorage");
        Intrinsics.f(context, "context");
        this.f38832a = pendingRawMessageStorage;
        this.f38833b = activeChatIdStorage;
        this.f38834c = context;
    }
}
