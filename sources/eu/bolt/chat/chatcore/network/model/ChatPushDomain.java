package eu.bolt.chat.chatcore.network.model;

import com.google.gson.annotations.SerializedName;
import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ChatPushDomain.kt */
/* loaded from: classes5.dex */
public final class ChatPushDomain {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f38324h = new Companion(null);
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f38325a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f38326b;
    @SerializedName("description")

    /* renamed from: c  reason: collision with root package name */
    private final String f38327c;
    @SerializedName("thumbnail_url")

    /* renamed from: d  reason: collision with root package name */
    private final String f38328d;
    @SerializedName("start_date")

    /* renamed from: e  reason: collision with root package name */
    private final long f38329e;
    @SerializedName("order_handle")

    /* renamed from: f  reason: collision with root package name */
    private final OrderHandleNetworkModel f38330f;
    @SerializedName("event")

    /* renamed from: g  reason: collision with root package name */
    private final Event f38331g;

    /* compiled from: ChatPushDomain.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatPushDomain.kt */
    /* loaded from: classes5.dex */
    public static abstract class Event {

        /* compiled from: ChatPushDomain.kt */
        /* loaded from: classes5.dex */
        public static final class Message extends Event {
            @SerializedName(Name.MARK)

            /* renamed from: a  reason: collision with root package name */
            private final String f38332a;
            @SerializedName("date")

            /* renamed from: b  reason: collision with root package name */
            private final long f38333b;
            @SerializedName("sender")

            /* renamed from: c  reason: collision with root package name */
            private final ChatMessageSender f38334c;
            @SerializedName("text")

            /* renamed from: d  reason: collision with root package name */
            private final String f38335d;
            @SerializedName("translation")

            /* renamed from: e  reason: collision with root package name */
            private final TranslationNetworkModel f38336e;

            public final long a() {
                return this.f38333b;
            }

            public final String b() {
                return this.f38332a;
            }

            public final ChatMessageSender c() {
                return this.f38334c;
            }

            public final String d() {
                return this.f38335d;
            }

            public final TranslationNetworkModel e() {
                return this.f38336e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Message) {
                    Message message = (Message) obj;
                    return Intrinsics.a(this.f38332a, message.f38332a) && this.f38333b == message.f38333b && Intrinsics.a(this.f38334c, message.f38334c) && Intrinsics.a(this.f38335d, message.f38335d) && Intrinsics.a(this.f38336e, message.f38336e);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = ((((this.f38332a.hashCode() * 31) + a.a(this.f38333b)) * 31) + this.f38334c.hashCode()) * 31;
                String str = this.f38335d;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                TranslationNetworkModel translationNetworkModel = this.f38336e;
                return hashCode2 + (translationNetworkModel != null ? translationNetworkModel.hashCode() : 0);
            }

            public String toString() {
                return "Message(messageId=" + this.f38332a + ", date=" + this.f38333b + ", sender=" + this.f38334c + ", text=" + this.f38335d + ", translation=" + this.f38336e + ')';
            }
        }

        private Event() {
        }
    }

    public final String a() {
        return this.f38325a;
    }

    public final String b() {
        return this.f38327c;
    }

    public final Event c() {
        return this.f38331g;
    }

    public final OrderHandleNetworkModel d() {
        return this.f38330f;
    }

    public final long e() {
        return this.f38329e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatPushDomain) {
            ChatPushDomain chatPushDomain = (ChatPushDomain) obj;
            return Intrinsics.a(this.f38325a, chatPushDomain.f38325a) && Intrinsics.a(this.f38326b, chatPushDomain.f38326b) && Intrinsics.a(this.f38327c, chatPushDomain.f38327c) && Intrinsics.a(this.f38328d, chatPushDomain.f38328d) && this.f38329e == chatPushDomain.f38329e && Intrinsics.a(this.f38330f, chatPushDomain.f38330f) && Intrinsics.a(this.f38331g, chatPushDomain.f38331g);
        }
        return false;
    }

    public final String f() {
        return this.f38328d;
    }

    public final String g() {
        return this.f38326b;
    }

    public int hashCode() {
        int hashCode = ((this.f38325a.hashCode() * 31) + this.f38326b.hashCode()) * 31;
        String str = this.f38327c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f38328d;
        return ((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + a.a(this.f38329e)) * 31) + this.f38330f.hashCode()) * 31) + this.f38331g.hashCode();
    }

    public String toString() {
        return "ChatPushDomain(chatId=" + this.f38325a + ", title=" + this.f38326b + ", description=" + this.f38327c + ", thumbnail=" + this.f38328d + ", startDate=" + this.f38329e + ", orderHandle=" + this.f38330f + ", event=" + this.f38331g + ')';
    }
}
