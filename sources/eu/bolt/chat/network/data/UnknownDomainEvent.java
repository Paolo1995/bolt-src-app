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
public final class UnknownDomainEvent extends BrokerEvent {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39312a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39313b;

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UnknownDomainEvent> serializer() {
            return UnknownDomainEvent$$serializer.f39314a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnknownDomainEvent(int i8, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, UnknownDomainEvent$$serializer.f39314a.a());
        }
        this.f39312a = str;
        this.f39313b = str2;
    }

    public static final void b(UnknownDomainEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.a());
        output.y(serialDesc, 1, self.f39313b);
    }

    public String a() {
        return this.f39312a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnknownDomainEvent) {
            UnknownDomainEvent unknownDomainEvent = (UnknownDomainEvent) obj;
            return Intrinsics.a(a(), unknownDomainEvent.a()) && Intrinsics.a(this.f39313b, unknownDomainEvent.f39313b);
        }
        return false;
    }

    public int hashCode() {
        return (a().hashCode() * 31) + this.f39313b.hashCode();
    }

    public String toString() {
        return "UnknownDomainEvent(id=" + a() + ", domain=" + this.f39313b + ')';
    }
}
