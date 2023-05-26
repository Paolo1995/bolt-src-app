package eu.bolt.chat.data;

import eu.bolt.chat.data.message.ChatMessage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatPushMessage.kt */
/* loaded from: classes5.dex */
public final class ChatPushMessage {

    /* renamed from: a  reason: collision with root package name */
    private final Chat f38938a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatMessage f38939b;

    public ChatPushMessage(Chat chat, ChatMessage message) {
        Intrinsics.f(chat, "chat");
        Intrinsics.f(message, "message");
        this.f38938a = chat;
        this.f38939b = message;
    }

    public final Chat a() {
        return this.f38938a;
    }

    public final ChatMessage b() {
        return this.f38939b;
    }

    public final Chat c() {
        return this.f38938a;
    }

    public final ChatMessage d() {
        return this.f38939b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatPushMessage) {
            ChatPushMessage chatPushMessage = (ChatPushMessage) obj;
            return Intrinsics.a(this.f38938a, chatPushMessage.f38938a) && Intrinsics.a(this.f38939b, chatPushMessage.f38939b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f38938a.hashCode() * 31) + this.f38939b.hashCode();
    }

    public String toString() {
        return "ChatPushMessage(chat=" + this.f38938a + ", message=" + this.f38939b + ')';
    }
}
