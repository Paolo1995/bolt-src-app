package eu.bolt.chat.chatcore.network.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: MqttEventResponse.kt */
/* loaded from: classes5.dex */
public abstract class MqttEventResponse {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f38348a = new Companion(null);

    /* compiled from: MqttEventResponse.kt */
    /* loaded from: classes5.dex */
    public static final class Chat extends MqttEventResponse {
        @SerializedName(Name.MARK)

        /* renamed from: b  reason: collision with root package name */
        private final String f38349b;
        @SerializedName("chat")

        /* renamed from: c  reason: collision with root package name */
        private final ChatResponse f38350c;

        public final ChatResponse a() {
            return this.f38350c;
        }

        public String b() {
            return this.f38349b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Chat) {
                Chat chat = (Chat) obj;
                return Intrinsics.a(b(), chat.b()) && Intrinsics.a(this.f38350c, chat.f38350c);
            }
            return false;
        }

        public int hashCode() {
            return (b().hashCode() * 31) + this.f38350c.hashCode();
        }

        public String toString() {
            return "Chat(id=" + b() + ", chatResponse=" + this.f38350c + ')';
        }
    }

    /* compiled from: MqttEventResponse.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private MqttEventResponse() {
    }
}
