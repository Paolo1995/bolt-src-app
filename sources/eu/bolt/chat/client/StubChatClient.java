package eu.bolt.chat.client;

import eu.bolt.chat.async.ObservableStateFlow;
import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ClientStatus;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: StubChatClient.kt */
/* loaded from: classes5.dex */
public final class StubChatClient implements ChatClient {
    @Override // eu.bolt.chat.client.ChatClient
    public ObservableStateFlow<List<Chat>> b() {
        List k8;
        k8 = CollectionsKt__CollectionsKt.k();
        return new ObservableStateFlow<>(StateFlowKt.a(k8));
    }

    @Override // eu.bolt.chat.client.ChatClient
    public ChatManager c(String chatId) {
        Intrinsics.f(chatId, "chatId");
        return new ChatManagerStub(chatId, null, 2, null);
    }

    @Override // eu.bolt.chat.client.ChatClient
    public ObservableStateFlow<ClientStatus> d() {
        return new ObservableStateFlow<>(StateFlowKt.a(getStatus()));
    }

    @Override // eu.bolt.chat.client.ChatClient
    public ClientStatus getStatus() {
        return ClientStatus.DISCONNECTED;
    }

    public String toString() {
        return "StubChatClient { status = " + getStatus() + " }";
    }
}
