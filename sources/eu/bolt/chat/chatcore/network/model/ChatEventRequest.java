package eu.bolt.chat.chatcore.network.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ChatEventRequest.kt */
/* loaded from: classes5.dex */
public abstract class ChatEventRequest {

    /* renamed from: b  reason: collision with root package name */
    private static final Companion f38280b = new Companion(null);
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final String f38281a;

    /* compiled from: ChatEventRequest.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatEventRequest.kt */
    /* loaded from: classes5.dex */
    public static final class Message extends ChatEventRequest {
        @SerializedName(Name.MARK)

        /* renamed from: c  reason: collision with root package name */
        private final String f38282c;
        @SerializedName("text")

        /* renamed from: d  reason: collision with root package name */
        private final String f38283d;
        @SerializedName("attachments")

        /* renamed from: e  reason: collision with root package name */
        private final List<Object> f38284e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Message(String id, String str, List<Object> list) {
            super("message", null);
            Intrinsics.f(id, "id");
            this.f38282c = id;
            this.f38283d = str;
            this.f38284e = list;
        }
    }

    /* compiled from: ChatEventRequest.kt */
    /* loaded from: classes5.dex */
    public static final class MessagesSeen extends ChatEventRequest {
        @SerializedName(Name.MARK)

        /* renamed from: c  reason: collision with root package name */
        private final String f38285c;
        @SerializedName("seen_message_ids")

        /* renamed from: d  reason: collision with root package name */
        private final List<String> f38286d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessagesSeen(String id, List<String> messageIds) {
            super("seen_message", null);
            Intrinsics.f(id, "id");
            Intrinsics.f(messageIds, "messageIds");
            this.f38285c = id;
            this.f38286d = messageIds;
        }
    }

    /* compiled from: ChatEventRequest.kt */
    /* loaded from: classes5.dex */
    public static final class QuickReplyMessage extends ChatEventRequest {
        @SerializedName(Name.MARK)

        /* renamed from: c  reason: collision with root package name */
        private final String f38287c;
        @SerializedName("text")

        /* renamed from: d  reason: collision with root package name */
        private final String f38288d;
        @SerializedName("quick_reply_id")

        /* renamed from: e  reason: collision with root package name */
        private final String f38289e;
        @SerializedName("attachments")

        /* renamed from: f  reason: collision with root package name */
        private final List<Object> f38290f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QuickReplyMessage(String id, String str, String str2, List<Object> list) {
            super("quick_reply_message", null);
            Intrinsics.f(id, "id");
            this.f38287c = id;
            this.f38288d = str;
            this.f38289e = str2;
            this.f38290f = list;
        }
    }

    /* compiled from: ChatEventRequest.kt */
    /* loaded from: classes5.dex */
    public static final class RequestReplySuggestions extends ChatEventRequest {
        @SerializedName(Name.MARK)

        /* renamed from: c  reason: collision with root package name */
        private final String f38291c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestReplySuggestions(String id) {
            super("request_quick_reply_suggestions", null);
            Intrinsics.f(id, "id");
            this.f38291c = id;
        }
    }

    private ChatEventRequest(String str) {
        this.f38281a = str;
    }

    public /* synthetic */ ChatEventRequest(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
