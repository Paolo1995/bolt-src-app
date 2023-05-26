package eu.bolt.chat.chatcore.network.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: MqttEventRequest.kt */
/* loaded from: classes5.dex */
public abstract class MqttEventRequest {

    /* renamed from: b  reason: collision with root package name */
    private static final Companion f38343b = new Companion(null);
    @SerializedName("domain")

    /* renamed from: a  reason: collision with root package name */
    private final String f38344a;

    /* compiled from: MqttEventRequest.kt */
    /* loaded from: classes5.dex */
    public static final class Chat extends MqttEventRequest {
        @SerializedName(Name.MARK)

        /* renamed from: c  reason: collision with root package name */
        private final String f38345c;
        @SerializedName("client_context")

        /* renamed from: d  reason: collision with root package name */
        private final ClientContext f38346d;
        @SerializedName("chat")

        /* renamed from: e  reason: collision with root package name */
        private final ChatRequest f38347e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Chat(String id, ClientContext clientContext, ChatRequest chatEvent) {
            super("chat", null);
            Intrinsics.f(id, "id");
            Intrinsics.f(clientContext, "clientContext");
            Intrinsics.f(chatEvent, "chatEvent");
            this.f38345c = id;
            this.f38346d = clientContext;
            this.f38347e = chatEvent;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Chat) {
                Chat chat = (Chat) obj;
                return Intrinsics.a(this.f38345c, chat.f38345c) && Intrinsics.a(this.f38346d, chat.f38346d) && Intrinsics.a(this.f38347e, chat.f38347e);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f38345c.hashCode() * 31) + this.f38346d.hashCode()) * 31) + this.f38347e.hashCode();
        }

        public String toString() {
            return "Chat(id=" + this.f38345c + ", clientContext=" + this.f38346d + ", chatEvent=" + this.f38347e + ')';
        }
    }

    /* compiled from: MqttEventRequest.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private MqttEventRequest(String str) {
        this.f38344a = str;
    }

    public /* synthetic */ MqttEventRequest(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
