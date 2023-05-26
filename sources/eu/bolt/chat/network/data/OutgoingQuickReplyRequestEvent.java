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
public final class OutgoingQuickReplyRequestEvent extends OutgoingEventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final String f39259b;

    /* compiled from: OutgoingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<OutgoingQuickReplyRequestEvent> serializer() {
            return OutgoingQuickReplyRequestEvent$$serializer.f39260a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OutgoingQuickReplyRequestEvent(int i8, String str, SerializationConstructorMarker serializationConstructorMarker) {
        super(i8, serializationConstructorMarker);
        if (1 != (i8 & 1)) {
            PluginExceptionsKt.a(i8, 1, OutgoingQuickReplyRequestEvent$$serializer.f39260a.a());
        }
        this.f39259b = str;
    }

    public static final void d(OutgoingQuickReplyRequestEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        OutgoingEventBase.b(self, output, serialDesc);
        output.y(serialDesc, 0, self.c());
    }

    public String c() {
        return this.f39259b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OutgoingQuickReplyRequestEvent) && Intrinsics.a(c(), ((OutgoingQuickReplyRequestEvent) obj).c());
    }

    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return "OutgoingQuickReplyRequestEvent(id=" + c() + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingQuickReplyRequestEvent(String id) {
        super(null);
        Intrinsics.f(id, "id");
        this.f39259b = id;
    }
}
