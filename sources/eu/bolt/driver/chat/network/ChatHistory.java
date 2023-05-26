package eu.bolt.driver.chat.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatHistory.kt */
/* loaded from: classes5.dex */
public final class ChatHistory {
    @SerializedName("chat_details")

    /* renamed from: a  reason: collision with root package name */
    private final ChatDetails f40436a;
    @SerializedName("messages")

    /* renamed from: b  reason: collision with root package name */
    private final List<ChatHistoryMessage> f40437b;
    @SerializedName("terminate_chat_event")

    /* renamed from: c  reason: collision with root package name */
    private final TerminateChatEvent f40438c;

    public final ChatDetails a() {
        return this.f40436a;
    }

    public final List<ChatHistoryMessage> b() {
        return this.f40437b;
    }

    public final TerminateChatEvent c() {
        return this.f40438c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatHistory) {
            ChatHistory chatHistory = (ChatHistory) obj;
            return Intrinsics.a(this.f40436a, chatHistory.f40436a) && Intrinsics.a(this.f40437b, chatHistory.f40437b) && Intrinsics.a(this.f40438c, chatHistory.f40438c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f40436a.hashCode() * 31;
        List<ChatHistoryMessage> list = this.f40437b;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        TerminateChatEvent terminateChatEvent = this.f40438c;
        return hashCode2 + (terminateChatEvent != null ? terminateChatEvent.hashCode() : 0);
    }

    public String toString() {
        ChatDetails chatDetails = this.f40436a;
        List<ChatHistoryMessage> list = this.f40437b;
        TerminateChatEvent terminateChatEvent = this.f40438c;
        return "ChatHistory(chatDetails=" + chatDetails + ", messages=" + list + ", terminateChatEvent=" + terminateChatEvent + ")";
    }
}
