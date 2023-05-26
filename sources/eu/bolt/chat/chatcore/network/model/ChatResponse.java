package eu.bolt.chat.chatcore.network.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ChatResponse.kt */
/* loaded from: classes5.dex */
public final class ChatResponse {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f38339a;
    @SerializedName("event")

    /* renamed from: b  reason: collision with root package name */
    private final ChatEventResponse f38340b;

    public final String a() {
        return this.f38339a;
    }

    public final ChatEventResponse b() {
        return this.f38340b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatResponse) {
            ChatResponse chatResponse = (ChatResponse) obj;
            return Intrinsics.a(this.f38339a, chatResponse.f38339a) && Intrinsics.a(this.f38340b, chatResponse.f38340b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f38339a.hashCode() * 31) + this.f38340b.hashCode();
    }

    public String toString() {
        return "ChatResponse(chatId=" + this.f38339a + ", event=" + this.f38340b + ')';
    }
}
