package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsDetailsResponse.kt */
/* loaded from: classes3.dex */
public final class ChatContactDetails extends ContactOptionsDetails {
    @SerializedName("chat_id")

    /* renamed from: a  reason: collision with root package name */
    private final String f21760a;
    @SerializedName("chat_details")

    /* renamed from: b  reason: collision with root package name */
    private final ChatDetailsData f21761b;
    @SerializedName("initial_service_messages")

    /* renamed from: c  reason: collision with root package name */
    private final List<ChatInitialServiceMessage> f21762c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatContactDetails(String chatId, ChatDetailsData details, List<ChatInitialServiceMessage> list) {
        super(null);
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(details, "details");
        this.f21760a = chatId;
        this.f21761b = details;
        this.f21762c = list;
    }

    public final String a() {
        return this.f21760a;
    }

    public final ChatDetailsData b() {
        return this.f21761b;
    }

    public final List<ChatInitialServiceMessage> c() {
        return this.f21762c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatContactDetails) {
            ChatContactDetails chatContactDetails = (ChatContactDetails) obj;
            return Intrinsics.a(this.f21760a, chatContactDetails.f21760a) && Intrinsics.a(this.f21761b, chatContactDetails.f21761b) && Intrinsics.a(this.f21762c, chatContactDetails.f21762c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f21760a.hashCode() * 31) + this.f21761b.hashCode()) * 31;
        List<ChatInitialServiceMessage> list = this.f21762c;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        String str = this.f21760a;
        ChatDetailsData chatDetailsData = this.f21761b;
        List<ChatInitialServiceMessage> list = this.f21762c;
        return "ChatContactDetails(chatId=" + str + ", details=" + chatDetailsData + ", initialServiceMessages=" + list + ")";
    }
}
