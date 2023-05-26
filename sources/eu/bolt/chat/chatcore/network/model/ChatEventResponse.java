package eu.bolt.chat.chatcore.network.model;

import com.google.gson.annotations.SerializedName;
import i0.a;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ChatEventResponse.kt */
/* loaded from: classes5.dex */
public abstract class ChatEventResponse {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f38292a = new Companion(null);

    /* compiled from: ChatEventResponse.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatEventResponse.kt */
    /* loaded from: classes5.dex */
    public static final class MessagesSeenConfirmation extends ChatEventResponse {
        @SerializedName("date")

        /* renamed from: b  reason: collision with root package name */
        private final long f38293b;
        @SerializedName("sender")

        /* renamed from: c  reason: collision with root package name */
        private final ChatMessageSender f38294c;
        @SerializedName("seen_message_ids")

        /* renamed from: d  reason: collision with root package name */
        private final List<String> f38295d;

        public long a() {
            return this.f38293b;
        }

        public final List<String> b() {
            return this.f38295d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MessagesSeenConfirmation) {
                MessagesSeenConfirmation messagesSeenConfirmation = (MessagesSeenConfirmation) obj;
                return a() == messagesSeenConfirmation.a() && Intrinsics.a(this.f38294c, messagesSeenConfirmation.f38294c) && Intrinsics.a(this.f38295d, messagesSeenConfirmation.f38295d);
            }
            return false;
        }

        public int hashCode() {
            return (((a.a(a()) * 31) + this.f38294c.hashCode()) * 31) + this.f38295d.hashCode();
        }

        public String toString() {
            return "MessagesSeenConfirmation(date=" + a() + ", sender=" + this.f38294c + ", seenMessagesIds=" + this.f38295d + ')';
        }
    }

    /* compiled from: ChatEventResponse.kt */
    /* loaded from: classes5.dex */
    public static final class NewMessage extends ChatEventResponse {
        @SerializedName("date")

        /* renamed from: b  reason: collision with root package name */
        private final long f38296b;
        @SerializedName("sender")

        /* renamed from: c  reason: collision with root package name */
        private final ChatMessageSender f38297c;
        @SerializedName(Name.MARK)

        /* renamed from: d  reason: collision with root package name */
        private final String f38298d;
        @SerializedName("text")

        /* renamed from: e  reason: collision with root package name */
        private final String f38299e;
        @SerializedName("translated_text")

        /* renamed from: f  reason: collision with root package name */
        private final String f38300f;
        @SerializedName("attachments")

        /* renamed from: g  reason: collision with root package name */
        private final List<Object> f38301g;
        @SerializedName("translation")

        /* renamed from: h  reason: collision with root package name */
        private final TranslationNetworkModel f38302h;

        public long a() {
            return this.f38296b;
        }

        public final String b() {
            return this.f38298d;
        }

        public final ChatMessageSender c() {
            return this.f38297c;
        }

        public final String d() {
            return this.f38299e;
        }

        public final TranslationNetworkModel e() {
            return this.f38302h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NewMessage) {
                NewMessage newMessage = (NewMessage) obj;
                return a() == newMessage.a() && Intrinsics.a(this.f38297c, newMessage.f38297c) && Intrinsics.a(this.f38298d, newMessage.f38298d) && Intrinsics.a(this.f38299e, newMessage.f38299e) && Intrinsics.a(this.f38300f, newMessage.f38300f) && Intrinsics.a(this.f38301g, newMessage.f38301g) && Intrinsics.a(this.f38302h, newMessage.f38302h);
            }
            return false;
        }

        public int hashCode() {
            int a8 = ((((a.a(a()) * 31) + this.f38297c.hashCode()) * 31) + this.f38298d.hashCode()) * 31;
            String str = this.f38299e;
            int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f38300f;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            List<Object> list = this.f38301g;
            int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            TranslationNetworkModel translationNetworkModel = this.f38302h;
            return hashCode3 + (translationNetworkModel != null ? translationNetworkModel.hashCode() : 0);
        }

        public String toString() {
            return "NewMessage(date=" + a() + ", sender=" + this.f38297c + ", id=" + this.f38298d + ", text=" + this.f38299e + ", translatedText=" + this.f38300f + ", attachments=" + this.f38301g + ", translation=" + this.f38302h + ')';
        }
    }

    /* compiled from: ChatEventResponse.kt */
    /* loaded from: classes5.dex */
    public static final class QuickReplies extends ChatEventResponse {
        @SerializedName("date")

        /* renamed from: b  reason: collision with root package name */
        private final long f38303b;
        @SerializedName("sender")

        /* renamed from: c  reason: collision with root package name */
        private final ChatMessageSender f38304c;
        @SerializedName("suggestions")

        /* renamed from: d  reason: collision with root package name */
        private final List<QuickReplySuggestion> f38305d;

        /* compiled from: ChatEventResponse.kt */
        /* loaded from: classes5.dex */
        public static final class QuickReplySuggestion {
            @SerializedName("text")

            /* renamed from: a  reason: collision with root package name */
            private final String f38306a;
            @SerializedName(Name.MARK)

            /* renamed from: b  reason: collision with root package name */
            private final String f38307b;

            public final String a() {
                return this.f38307b;
            }

            public final String b() {
                return this.f38306a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof QuickReplySuggestion) {
                    QuickReplySuggestion quickReplySuggestion = (QuickReplySuggestion) obj;
                    return Intrinsics.a(this.f38306a, quickReplySuggestion.f38306a) && Intrinsics.a(this.f38307b, quickReplySuggestion.f38307b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f38306a.hashCode() * 31) + this.f38307b.hashCode();
            }

            public String toString() {
                return "QuickReplySuggestion(text=" + this.f38306a + ", id=" + this.f38307b + ')';
            }
        }

        public long a() {
            return this.f38303b;
        }

        public final List<QuickReplySuggestion> b() {
            return this.f38305d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof QuickReplies) {
                QuickReplies quickReplies = (QuickReplies) obj;
                return a() == quickReplies.a() && Intrinsics.a(this.f38304c, quickReplies.f38304c) && Intrinsics.a(this.f38305d, quickReplies.f38305d);
            }
            return false;
        }

        public int hashCode() {
            return (((a.a(a()) * 31) + this.f38304c.hashCode()) * 31) + this.f38305d.hashCode();
        }

        public String toString() {
            return "QuickReplies(date=" + a() + ", sender=" + this.f38304c + ", suggestions=" + this.f38305d + ')';
        }
    }

    /* compiled from: ChatEventResponse.kt */
    /* loaded from: classes5.dex */
    public static final class ServiceMessageEvent extends ChatEventResponse {
        @SerializedName("date")

        /* renamed from: b  reason: collision with root package name */
        private final long f38308b;
        @SerializedName(Name.MARK)

        /* renamed from: c  reason: collision with root package name */
        private final String f38309c;
        @SerializedName("text_html")

        /* renamed from: d  reason: collision with root package name */
        private final String f38310d;
        @SerializedName("silent")

        /* renamed from: e  reason: collision with root package name */
        private final boolean f38311e;

        public long a() {
            return this.f38308b;
        }

        public final String b() {
            return this.f38309c;
        }

        public final String c() {
            return this.f38310d;
        }

        public final boolean d() {
            return this.f38311e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ServiceMessageEvent) {
                ServiceMessageEvent serviceMessageEvent = (ServiceMessageEvent) obj;
                return a() == serviceMessageEvent.a() && Intrinsics.a(this.f38309c, serviceMessageEvent.f38309c) && Intrinsics.a(this.f38310d, serviceMessageEvent.f38310d) && this.f38311e == serviceMessageEvent.f38311e;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a8 = ((((a.a(a()) * 31) + this.f38309c.hashCode()) * 31) + this.f38310d.hashCode()) * 31;
            boolean z7 = this.f38311e;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return a8 + i8;
        }

        public String toString() {
            return "ServiceMessageEvent(date=" + a() + ", id=" + this.f38309c + ", text=" + this.f38310d + ", isSilent=" + this.f38311e + ')';
        }
    }

    /* compiled from: ChatEventResponse.kt */
    /* loaded from: classes5.dex */
    public static final class StartEvent extends ChatEventResponse {
        @SerializedName("date")

        /* renamed from: b  reason: collision with root package name */
        private final long f38312b;
        @SerializedName(Name.MARK)

        /* renamed from: c  reason: collision with root package name */
        private final String f38313c;
        @SerializedName("title")

        /* renamed from: d  reason: collision with root package name */
        private final String f38314d;
        @SerializedName("description")

        /* renamed from: e  reason: collision with root package name */
        private final String f38315e;
        @SerializedName("thumbnail_url")

        /* renamed from: f  reason: collision with root package name */
        private final String f38316f;
        @SerializedName("order_handle")

        /* renamed from: g  reason: collision with root package name */
        private final OrderHandleNetworkModel f38317g;

        public long a() {
            return this.f38312b;
        }

        public final String b() {
            return this.f38315e;
        }

        public final OrderHandleNetworkModel c() {
            return this.f38317g;
        }

        public final String d() {
            return this.f38316f;
        }

        public final String e() {
            return this.f38314d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StartEvent) {
                StartEvent startEvent = (StartEvent) obj;
                return a() == startEvent.a() && Intrinsics.a(this.f38313c, startEvent.f38313c) && Intrinsics.a(this.f38314d, startEvent.f38314d) && Intrinsics.a(this.f38315e, startEvent.f38315e) && Intrinsics.a(this.f38316f, startEvent.f38316f) && Intrinsics.a(this.f38317g, startEvent.f38317g);
            }
            return false;
        }

        public int hashCode() {
            int a8 = ((((a.a(a()) * 31) + this.f38313c.hashCode()) * 31) + this.f38314d.hashCode()) * 31;
            String str = this.f38315e;
            int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f38316f;
            return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f38317g.hashCode();
        }

        public String toString() {
            return "StartEvent(date=" + a() + ", id=" + this.f38313c + ", title=" + this.f38314d + ", description=" + this.f38315e + ", thumbnail=" + this.f38316f + ", orderHandle=" + this.f38317g + ')';
        }
    }

    /* compiled from: ChatEventResponse.kt */
    /* loaded from: classes5.dex */
    public static final class TerminalEvent extends ChatEventResponse {
        @SerializedName("date")

        /* renamed from: b  reason: collision with root package name */
        private final long f38318b;
        @SerializedName(Name.MARK)

        /* renamed from: c  reason: collision with root package name */
        private final String f38319c;
        @SerializedName("message")

        /* renamed from: d  reason: collision with root package name */
        private final String f38320d;
        @SerializedName("status")

        /* renamed from: e  reason: collision with root package name */
        private final String f38321e;

        public long a() {
            return this.f38318b;
        }

        public final String b() {
            return this.f38319c;
        }

        public final String c() {
            return this.f38320d;
        }

        public final String d() {
            return this.f38321e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TerminalEvent) {
                TerminalEvent terminalEvent = (TerminalEvent) obj;
                return a() == terminalEvent.a() && Intrinsics.a(this.f38319c, terminalEvent.f38319c) && Intrinsics.a(this.f38320d, terminalEvent.f38320d) && Intrinsics.a(this.f38321e, terminalEvent.f38321e);
            }
            return false;
        }

        public int hashCode() {
            return (((((a.a(a()) * 31) + this.f38319c.hashCode()) * 31) + this.f38320d.hashCode()) * 31) + this.f38321e.hashCode();
        }

        public String toString() {
            return "TerminalEvent(date=" + a() + ", id=" + this.f38319c + ", message=" + this.f38320d + ", status=" + this.f38321e + ')';
        }
    }

    private ChatEventResponse() {
    }
}
