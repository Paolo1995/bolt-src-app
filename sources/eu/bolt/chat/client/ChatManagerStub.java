package eu.bolt.chat.client;

import eu.bolt.chat.async.ObservableStateFlow;
import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ChatStatus;
import eu.bolt.chat.data.EndChatInfo;
import eu.bolt.chat.data.QuickReplySuggestion;
import eu.bolt.chat.data.message.ChatMessage;
import eu.bolt.chat.data.message.MessageEvent;
import eu.bolt.chat.data.message.ServiceMessage;
import eu.bolt.chat.data.message.UserMessage;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ChatManagerStub.kt */
/* loaded from: classes5.dex */
public final class ChatManagerStub implements InternalChatManager {

    /* renamed from: a  reason: collision with root package name */
    private final String f38640a;

    /* renamed from: b  reason: collision with root package name */
    private final EndChatInfo f38641b;

    public ChatManagerStub(String chatId, EndChatInfo endChatInfo) {
        Intrinsics.f(chatId, "chatId");
        this.f38640a = chatId;
        this.f38641b = endChatInfo;
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object a(Chat chat, Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object b(Chat chat, List<? extends ChatMessage> list, Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatManager
    public void c(List<String> messageIds) {
        Intrinsics.f(messageIds, "messageIds");
    }

    @Override // eu.bolt.chat.client.ChatLifeCycleManager
    public Object d(MessageEvent.LifeCycle.Finish finish, Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object e(Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatManager
    public ObservableStateFlow<Integer> f() {
        return new ObservableStateFlow<>(StateFlowKt.a(0));
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object g(Continuation<? super Chat> continuation) {
        return null;
    }

    @Override // eu.bolt.chat.client.ChatLifeCycleManager
    public Object h(MessageEvent.LifeCycle.Start start, Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object i(List<QuickReplySuggestion> list, Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatManager
    public ObservableStateFlow<List<ChatMessage>> j() {
        List k8;
        k8 = CollectionsKt__CollectionsKt.k();
        return new ObservableStateFlow<>(StateFlowKt.a(k8));
    }

    @Override // eu.bolt.chat.client.ChatManager
    public void k(String id) {
        Intrinsics.f(id, "id");
    }

    @Override // eu.bolt.chat.client.ChatLifeCycleManager
    public Object l(List<String> list, Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatManager
    public ObservableStateFlow<List<QuickReplySuggestion>> m() {
        List k8;
        k8 = CollectionsKt__CollectionsKt.k();
        return new ObservableStateFlow<>(StateFlowKt.a(k8));
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object n(ServiceMessage serviceMessage, Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatManager
    public void o(String text) {
        Intrinsics.f(text, "text");
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object p(UserMessage userMessage, Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object q(Continuation<? super Unit> continuation) {
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatManager
    public ObservableStateFlow<ChatStatus> r() {
        ChatStatus chatStatus;
        EndChatInfo endChatInfo = this.f38641b;
        if (endChatInfo == null || (chatStatus = endChatInfo.d()) == null) {
            chatStatus = ChatStatus.PENDING;
        }
        return new ObservableStateFlow<>(StateFlowKt.a(chatStatus));
    }

    public String toString() {
        return "ChatManagerStub { chatId = " + this.f38640a + ", endChatInfo = " + this.f38641b + " }";
    }

    public /* synthetic */ ChatManagerStub(String str, EndChatInfo endChatInfo, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? null : endChatInfo);
    }
}
