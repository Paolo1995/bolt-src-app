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
public final class OutgoingChatMessageEvent extends OutgoingEventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final String f39245b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39246c;

    /* compiled from: OutgoingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<OutgoingChatMessageEvent> serializer() {
            return OutgoingChatMessageEvent$$serializer.f39247a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OutgoingChatMessageEvent(int i8, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        super(i8, serializationConstructorMarker);
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, OutgoingChatMessageEvent$$serializer.f39247a.a());
        }
        this.f39245b = str;
        this.f39246c = str2;
    }

    public static final void d(OutgoingChatMessageEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        OutgoingEventBase.b(self, output, serialDesc);
        output.y(serialDesc, 0, self.c());
        output.y(serialDesc, 1, self.f39246c);
    }

    public String c() {
        return this.f39245b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OutgoingChatMessageEvent) {
            OutgoingChatMessageEvent outgoingChatMessageEvent = (OutgoingChatMessageEvent) obj;
            return Intrinsics.a(c(), outgoingChatMessageEvent.c()) && Intrinsics.a(this.f39246c, outgoingChatMessageEvent.f39246c);
        }
        return false;
    }

    public int hashCode() {
        return (c().hashCode() * 31) + this.f39246c.hashCode();
    }

    public String toString() {
        return "OutgoingChatMessageEvent(id=" + c() + ", text=" + this.f39246c + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingChatMessageEvent(String id, String text) {
        super(null);
        Intrinsics.f(id, "id");
        Intrinsics.f(text, "text");
        this.f39245b = id;
        this.f39246c = text;
    }
}
