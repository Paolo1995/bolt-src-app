package eu.bolt.chat.network.data;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OutgoingChatEvent.kt */
@Serializable
/* loaded from: classes5.dex */
public final class OutgoingChatEvent {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39241a;

    /* renamed from: b  reason: collision with root package name */
    private final OutgoingEventBase f39242b;

    /* compiled from: OutgoingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<OutgoingChatEvent> serializer() {
            return OutgoingChatEvent$$serializer.f39243a;
        }
    }

    public /* synthetic */ OutgoingChatEvent(int i8, String str, OutgoingEventBase outgoingEventBase, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, OutgoingChatEvent$$serializer.f39243a.a());
        }
        this.f39241a = str;
        this.f39242b = outgoingEventBase;
    }

    public static final void a(OutgoingChatEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.f39241a);
        output.B(serialDesc, 1, OutgoingEventBase.Companion.serializer(), self.f39242b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OutgoingChatEvent) {
            OutgoingChatEvent outgoingChatEvent = (OutgoingChatEvent) obj;
            return Intrinsics.a(this.f39241a, outgoingChatEvent.f39241a) && Intrinsics.a(this.f39242b, outgoingChatEvent.f39242b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39241a.hashCode() * 31) + this.f39242b.hashCode();
    }

    public String toString() {
        return "OutgoingChatEvent(id=" + this.f39241a + ", event=" + this.f39242b + ')';
    }

    public OutgoingChatEvent(String id, OutgoingEventBase event) {
        Intrinsics.f(id, "id");
        Intrinsics.f(event, "event");
        this.f39241a = id;
        this.f39242b = event;
    }
}
