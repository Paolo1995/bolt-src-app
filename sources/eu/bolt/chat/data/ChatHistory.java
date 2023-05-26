package eu.bolt.chat.data;

import eu.bolt.chat.data.message.ChatMessage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatHistory.kt */
/* loaded from: classes5.dex */
public final class ChatHistory {

    /* renamed from: a  reason: collision with root package name */
    private final Chat f38932a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ChatMessage> f38933b;

    /* renamed from: c  reason: collision with root package name */
    private final EndChatInfo f38934c;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatHistory(Chat chat, List<? extends ChatMessage> messages, EndChatInfo endChatInfo) {
        Intrinsics.f(chat, "chat");
        Intrinsics.f(messages, "messages");
        this.f38932a = chat;
        this.f38933b = messages;
        this.f38934c = endChatInfo;
    }

    public final Chat a() {
        return this.f38932a;
    }

    public final EndChatInfo b() {
        return this.f38934c;
    }

    public final List<ChatMessage> c() {
        return this.f38933b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatHistory) {
            ChatHistory chatHistory = (ChatHistory) obj;
            return Intrinsics.a(this.f38932a, chatHistory.f38932a) && Intrinsics.a(this.f38933b, chatHistory.f38933b) && Intrinsics.a(this.f38934c, chatHistory.f38934c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f38932a.hashCode() * 31) + this.f38933b.hashCode()) * 31;
        EndChatInfo endChatInfo = this.f38934c;
        return hashCode + (endChatInfo == null ? 0 : endChatInfo.hashCode());
    }

    public String toString() {
        return "ChatHistory(chat=" + this.f38932a + ", messages=" + this.f38933b + ", endChatInfo=" + this.f38934c + ')';
    }
}
