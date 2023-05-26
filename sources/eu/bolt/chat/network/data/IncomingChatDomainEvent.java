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
public final class IncomingChatDomainEvent extends BrokerEvent {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39203a;

    /* renamed from: b  reason: collision with root package name */
    private final IncomingChatEvent f39204b;

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<IncomingChatDomainEvent> serializer() {
            return IncomingChatDomainEvent$$serializer.f39205a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IncomingChatDomainEvent(int i8, String str, IncomingChatEvent incomingChatEvent, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, IncomingChatDomainEvent$$serializer.f39205a.a());
        }
        this.f39203a = str;
        this.f39204b = incomingChatEvent;
    }

    public static final void c(IncomingChatDomainEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.b());
        output.B(serialDesc, 1, IncomingChatEvent$$serializer.f39209a, self.f39204b);
    }

    public final IncomingChatEvent a() {
        return this.f39204b;
    }

    public String b() {
        return this.f39203a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IncomingChatDomainEvent) {
            IncomingChatDomainEvent incomingChatDomainEvent = (IncomingChatDomainEvent) obj;
            return Intrinsics.a(b(), incomingChatDomainEvent.b()) && Intrinsics.a(this.f39204b, incomingChatDomainEvent.f39204b);
        }
        return false;
    }

    public int hashCode() {
        return (b().hashCode() * 31) + this.f39204b.hashCode();
    }

    public String toString() {
        return "IncomingChatDomainEvent(id=" + b() + ", chat=" + this.f39204b + ')';
    }
}
