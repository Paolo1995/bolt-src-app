package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvailableContactOptions.kt */
/* loaded from: classes3.dex */
public final class ChatData {
    @SerializedName("chat_id")

    /* renamed from: a  reason: collision with root package name */
    private final String f21763a;
    @SerializedName("chat_details")

    /* renamed from: b  reason: collision with root package name */
    private final ChatDetailsData f21764b;
    @SerializedName("initial_service_messages")

    /* renamed from: c  reason: collision with root package name */
    private final List<ChatInitialServiceMessage> f21765c;

    public final String a() {
        return this.f21763a;
    }

    public final ChatDetailsData b() {
        return this.f21764b;
    }

    public final List<ChatInitialServiceMessage> c() {
        return this.f21765c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatData) {
            ChatData chatData = (ChatData) obj;
            return Intrinsics.a(this.f21763a, chatData.f21763a) && Intrinsics.a(this.f21764b, chatData.f21764b) && Intrinsics.a(this.f21765c, chatData.f21765c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f21763a.hashCode() * 31) + this.f21764b.hashCode()) * 31;
        List<ChatInitialServiceMessage> list = this.f21765c;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        String str = this.f21763a;
        ChatDetailsData chatDetailsData = this.f21764b;
        List<ChatInitialServiceMessage> list = this.f21765c;
        return "ChatData(chatId=" + str + ", details=" + chatDetailsData + ", initialServiceMessages=" + list + ")";
    }
}
