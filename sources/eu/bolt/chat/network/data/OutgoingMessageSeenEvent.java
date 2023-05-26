package eu.bolt.chat.network.data;

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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: OutgoingChatEvent.kt */
@Serializable
/* loaded from: classes5.dex */
public final class OutgoingMessageSeenEvent extends OutgoingEventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final String f39251b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f39252c;

    /* compiled from: OutgoingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<OutgoingMessageSeenEvent> serializer() {
            return OutgoingMessageSeenEvent$$serializer.f39253a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OutgoingMessageSeenEvent(int i8, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
        super(i8, serializationConstructorMarker);
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, OutgoingMessageSeenEvent$$serializer.f39253a.a());
        }
        this.f39251b = str;
        this.f39252c = list;
    }

    public static final void d(OutgoingMessageSeenEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        OutgoingEventBase.b(self, output, serialDesc);
        output.y(serialDesc, 0, self.c());
        output.B(serialDesc, 1, new ArrayListSerializer(StringSerializer.f52262a), self.f39252c);
    }

    public String c() {
        return this.f39251b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OutgoingMessageSeenEvent) {
            OutgoingMessageSeenEvent outgoingMessageSeenEvent = (OutgoingMessageSeenEvent) obj;
            return Intrinsics.a(c(), outgoingMessageSeenEvent.c()) && Intrinsics.a(this.f39252c, outgoingMessageSeenEvent.f39252c);
        }
        return false;
    }

    public int hashCode() {
        return (c().hashCode() * 31) + this.f39252c.hashCode();
    }

    public String toString() {
        return "OutgoingMessageSeenEvent(id=" + c() + ", seenMessageIds=" + this.f39252c + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingMessageSeenEvent(String id, List<String> seenMessageIds) {
        super(null);
        Intrinsics.f(id, "id");
        Intrinsics.f(seenMessageIds, "seenMessageIds");
        this.f39251b = id;
        this.f39252c = seenMessageIds;
    }
}
