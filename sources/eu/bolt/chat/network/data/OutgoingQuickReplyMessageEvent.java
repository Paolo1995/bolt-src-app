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
public final class OutgoingQuickReplyMessageEvent extends OutgoingEventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final String f39255b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39256c;

    /* compiled from: OutgoingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<OutgoingQuickReplyMessageEvent> serializer() {
            return OutgoingQuickReplyMessageEvent$$serializer.f39257a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OutgoingQuickReplyMessageEvent(int i8, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        super(i8, serializationConstructorMarker);
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, OutgoingQuickReplyMessageEvent$$serializer.f39257a.a());
        }
        this.f39255b = str;
        this.f39256c = str2;
    }

    public static final void d(OutgoingQuickReplyMessageEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        OutgoingEventBase.b(self, output, serialDesc);
        output.y(serialDesc, 0, self.c());
        output.y(serialDesc, 1, self.f39256c);
    }

    public String c() {
        return this.f39255b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OutgoingQuickReplyMessageEvent) {
            OutgoingQuickReplyMessageEvent outgoingQuickReplyMessageEvent = (OutgoingQuickReplyMessageEvent) obj;
            return Intrinsics.a(c(), outgoingQuickReplyMessageEvent.c()) && Intrinsics.a(this.f39256c, outgoingQuickReplyMessageEvent.f39256c);
        }
        return false;
    }

    public int hashCode() {
        return (c().hashCode() * 31) + this.f39256c.hashCode();
    }

    public String toString() {
        return "OutgoingQuickReplyMessageEvent(id=" + c() + ", quickReplyId=" + this.f39256c + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingQuickReplyMessageEvent(String id, String quickReplyId) {
        super(null);
        Intrinsics.f(id, "id");
        Intrinsics.f(quickReplyId, "quickReplyId");
        this.f39255b = id;
        this.f39256c = quickReplyId;
    }
}
