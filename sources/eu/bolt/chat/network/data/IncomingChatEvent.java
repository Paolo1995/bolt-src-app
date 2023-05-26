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
public final class IncomingChatEvent {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39207a;

    /* renamed from: b  reason: collision with root package name */
    private final EventBase f39208b;

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<IncomingChatEvent> serializer() {
            return IncomingChatEvent$$serializer.f39209a;
        }
    }

    public /* synthetic */ IncomingChatEvent(int i8, String str, EventBase eventBase, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, IncomingChatEvent$$serializer.f39209a.a());
        }
        this.f39207a = str;
        this.f39208b = eventBase;
    }

    public static final void c(IncomingChatEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.f39207a);
        output.B(serialDesc, 1, EventBase.Companion.serializer(), self.f39208b);
    }

    public final EventBase a() {
        return this.f39208b;
    }

    public final String b() {
        return this.f39207a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IncomingChatEvent) {
            IncomingChatEvent incomingChatEvent = (IncomingChatEvent) obj;
            return Intrinsics.a(this.f39207a, incomingChatEvent.f39207a) && Intrinsics.a(this.f39208b, incomingChatEvent.f39208b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39207a.hashCode() * 31) + this.f39208b.hashCode();
    }

    public String toString() {
        return "IncomingChatEvent(id=" + this.f39207a + ", event=" + this.f39208b + ')';
    }
}
