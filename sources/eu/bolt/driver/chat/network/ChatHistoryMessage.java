package eu.bolt.driver.chat.network;

import com.google.gson.annotations.SerializedName;
import eu.bolt.chat.chatcore.network.model.ChatMessageSender;
import eu.bolt.chat.chatcore.network.model.TranslationNetworkModel;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ChatHistoryMessage.kt */
/* loaded from: classes5.dex */
public final class ChatHistoryMessage {
    @SerializedName("date")

    /* renamed from: a  reason: collision with root package name */
    private final long f40439a;
    @SerializedName(Name.MARK)

    /* renamed from: b  reason: collision with root package name */
    private final String f40440b;
    @SerializedName("type")

    /* renamed from: c  reason: collision with root package name */
    private final MessageType f40441c;
    @SerializedName("seen")

    /* renamed from: d  reason: collision with root package name */
    private final boolean f40442d;
    @SerializedName("sender")

    /* renamed from: e  reason: collision with root package name */
    private final ChatMessageSender f40443e;
    @SerializedName(alternate = {"text_html"}, value = "text")

    /* renamed from: f  reason: collision with root package name */
    private final String f40444f;
    @SerializedName("status")

    /* renamed from: g  reason: collision with root package name */
    private final String f40445g;
    @SerializedName("silent")

    /* renamed from: h  reason: collision with root package name */
    private final boolean f40446h;
    @SerializedName("translation")

    /* renamed from: i  reason: collision with root package name */
    private final TranslationNetworkModel f40447i;

    public final long a() {
        return this.f40439a;
    }

    public final String b() {
        return this.f40440b;
    }

    public final ChatMessageSender c() {
        return this.f40443e;
    }

    public final String d() {
        return this.f40445g;
    }

    public final String e() {
        return this.f40444f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatHistoryMessage) {
            ChatHistoryMessage chatHistoryMessage = (ChatHistoryMessage) obj;
            return this.f40439a == chatHistoryMessage.f40439a && Intrinsics.a(this.f40440b, chatHistoryMessage.f40440b) && this.f40441c == chatHistoryMessage.f40441c && this.f40442d == chatHistoryMessage.f40442d && Intrinsics.a(this.f40443e, chatHistoryMessage.f40443e) && Intrinsics.a(this.f40444f, chatHistoryMessage.f40444f) && Intrinsics.a(this.f40445g, chatHistoryMessage.f40445g) && this.f40446h == chatHistoryMessage.f40446h && Intrinsics.a(this.f40447i, chatHistoryMessage.f40447i);
        }
        return false;
    }

    public final TranslationNetworkModel f() {
        return this.f40447i;
    }

    public final MessageType g() {
        return this.f40441c;
    }

    public final boolean h() {
        return this.f40446h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = ((((i0.a.a(this.f40439a) * 31) + this.f40440b.hashCode()) * 31) + this.f40441c.hashCode()) * 31;
        boolean z7 = this.f40442d;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (a8 + i8) * 31;
        ChatMessageSender chatMessageSender = this.f40443e;
        int hashCode = (i9 + (chatMessageSender == null ? 0 : chatMessageSender.hashCode())) * 31;
        String str = this.f40444f;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f40445g.hashCode()) * 31;
        boolean z8 = this.f40446h;
        int i10 = (hashCode2 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
        TranslationNetworkModel translationNetworkModel = this.f40447i;
        return i10 + (translationNetworkModel != null ? translationNetworkModel.hashCode() : 0);
    }

    public String toString() {
        long j8 = this.f40439a;
        String str = this.f40440b;
        MessageType messageType = this.f40441c;
        boolean z7 = this.f40442d;
        ChatMessageSender chatMessageSender = this.f40443e;
        String str2 = this.f40444f;
        String str3 = this.f40445g;
        boolean z8 = this.f40446h;
        TranslationNetworkModel translationNetworkModel = this.f40447i;
        return "ChatHistoryMessage(date=" + j8 + ", id=" + str + ", type=" + messageType + ", seen=" + z7 + ", sender=" + chatMessageSender + ", text=" + str2 + ", status=" + str3 + ", isSilent=" + z8 + ", translation=" + translationNetworkModel + ")";
    }
}
