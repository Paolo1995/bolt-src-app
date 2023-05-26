package eu.bolt.chat.chatcore.network.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ChatRequest.kt */
/* loaded from: classes5.dex */
public final class ChatRequest {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f38337a;
    @SerializedName("event")

    /* renamed from: b  reason: collision with root package name */
    private final ChatEventRequest f38338b;

    public ChatRequest(String chatId, ChatEventRequest event) {
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(event, "event");
        this.f38337a = chatId;
        this.f38338b = event;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatRequest) {
            ChatRequest chatRequest = (ChatRequest) obj;
            return Intrinsics.a(this.f38337a, chatRequest.f38337a) && Intrinsics.a(this.f38338b, chatRequest.f38338b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f38337a.hashCode() * 31) + this.f38338b.hashCode();
    }

    public String toString() {
        return "ChatRequest(chatId=" + this.f38337a + ", event=" + this.f38338b + ')';
    }
}
