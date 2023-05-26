package eu.bolt.chat.network.data;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: IncomingChatEvent.kt */
@Serializable
/* loaded from: classes5.dex */
public final class ChatMessageSender {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39163a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39164b;

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ChatMessageSender> serializer() {
            return ChatMessageSender$$serializer.f39165a;
        }
    }

    public /* synthetic */ ChatMessageSender(int i8, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, ChatMessageSender$$serializer.f39165a.a());
        }
        this.f39163a = str;
        this.f39164b = str2;
    }

    public static final void c(ChatMessageSender self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.f39163a);
        output.y(serialDesc, 1, self.f39164b);
    }

    public final String a() {
        return this.f39163a;
    }

    public final String b() {
        return this.f39164b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatMessageSender) {
            ChatMessageSender chatMessageSender = (ChatMessageSender) obj;
            return Intrinsics.a(this.f39163a, chatMessageSender.f39163a) && Intrinsics.a(this.f39164b, chatMessageSender.f39164b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39163a.hashCode() * 31) + this.f39164b.hashCode();
    }

    public String toString() {
        return "ChatMessageSender(id=" + this.f39163a + ", name=" + this.f39164b + ')';
    }
}
