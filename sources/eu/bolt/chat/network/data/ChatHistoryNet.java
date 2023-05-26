package eu.bolt.chat.network.data;

import eu.bolt.chat.network.data.serializer.TextMessageSerializer;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ChatHistoryNet.kt */
@Serializable
/* loaded from: classes5.dex */
public final class ChatHistoryNet {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final ChatDetailsNet f39158a;

    /* renamed from: b  reason: collision with root package name */
    private final List<MessageEventBase> f39159b;

    /* renamed from: c  reason: collision with root package name */
    private final EndChatEvent f39160c;

    /* compiled from: ChatHistoryNet.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ChatHistoryNet> serializer() {
            return ChatHistoryNet$$serializer.f39161a;
        }
    }

    public /* synthetic */ ChatHistoryNet(int i8, ChatDetailsNet chatDetailsNet, List list, EndChatEvent endChatEvent, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, ChatHistoryNet$$serializer.f39161a.a());
        }
        this.f39158a = chatDetailsNet;
        this.f39159b = list;
        if ((i8 & 4) == 0) {
            this.f39160c = null;
        } else {
            this.f39160c = endChatEvent;
        }
    }

    public static final void d(ChatHistoryNet self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        boolean z7 = false;
        output.B(serialDesc, 0, ChatDetailsNet$$serializer.f39156a, self.f39158a);
        output.B(serialDesc, 1, new ArrayListSerializer(TextMessageSerializer.f39340c), self.f39159b);
        if (output.z(serialDesc, 2) || self.f39160c != null) {
            z7 = true;
        }
        if (z7) {
            output.i(serialDesc, 2, EndChatEvent$$serializer.f39199a, self.f39160c);
        }
    }

    public final ChatDetailsNet a() {
        return this.f39158a;
    }

    public final EndChatEvent b() {
        return this.f39160c;
    }

    public final List<MessageEventBase> c() {
        return this.f39159b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatHistoryNet) {
            ChatHistoryNet chatHistoryNet = (ChatHistoryNet) obj;
            return Intrinsics.a(this.f39158a, chatHistoryNet.f39158a) && Intrinsics.a(this.f39159b, chatHistoryNet.f39159b) && Intrinsics.a(this.f39160c, chatHistoryNet.f39160c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f39158a.hashCode() * 31) + this.f39159b.hashCode()) * 31;
        EndChatEvent endChatEvent = this.f39160c;
        return hashCode + (endChatEvent == null ? 0 : endChatEvent.hashCode());
    }

    public String toString() {
        return "ChatHistoryNet(chatDetails=" + this.f39158a + ", messages=" + this.f39159b + ", endChatEvent=" + this.f39160c + ')';
    }
}
