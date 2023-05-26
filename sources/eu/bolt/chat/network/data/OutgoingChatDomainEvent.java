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
public final class OutgoingChatDomainEvent {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39235a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39236b;

    /* renamed from: c  reason: collision with root package name */
    private final OutgoingChatEvent f39237c;

    /* renamed from: d  reason: collision with root package name */
    private final ClientContext f39238d;

    /* compiled from: OutgoingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<OutgoingChatDomainEvent> serializer() {
            return OutgoingChatDomainEvent$$serializer.f39239a;
        }
    }

    public /* synthetic */ OutgoingChatDomainEvent(int i8, String str, String str2, OutgoingChatEvent outgoingChatEvent, ClientContext clientContext, SerializationConstructorMarker serializationConstructorMarker) {
        if (13 != (i8 & 13)) {
            PluginExceptionsKt.a(i8, 13, OutgoingChatDomainEvent$$serializer.f39239a.a());
        }
        this.f39235a = str;
        if ((i8 & 2) == 0) {
            this.f39236b = "chat";
        } else {
            this.f39236b = str2;
        }
        this.f39237c = outgoingChatEvent;
        this.f39238d = clientContext;
    }

    public static final void a(OutgoingChatDomainEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.f39235a);
        output.y(serialDesc, 1, self.f39236b);
        output.B(serialDesc, 2, OutgoingChatEvent$$serializer.f39243a, self.f39237c);
        output.B(serialDesc, 3, ClientContext$$serializer.f39184a, self.f39238d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OutgoingChatDomainEvent) {
            OutgoingChatDomainEvent outgoingChatDomainEvent = (OutgoingChatDomainEvent) obj;
            return Intrinsics.a(this.f39235a, outgoingChatDomainEvent.f39235a) && Intrinsics.a(this.f39236b, outgoingChatDomainEvent.f39236b) && Intrinsics.a(this.f39237c, outgoingChatDomainEvent.f39237c) && Intrinsics.a(this.f39238d, outgoingChatDomainEvent.f39238d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f39235a.hashCode() * 31) + this.f39236b.hashCode()) * 31) + this.f39237c.hashCode()) * 31) + this.f39238d.hashCode();
    }

    public String toString() {
        return "OutgoingChatDomainEvent(id=" + this.f39235a + ", domain=" + this.f39236b + ", chat=" + this.f39237c + ", clientContext=" + this.f39238d + ')';
    }

    public OutgoingChatDomainEvent(String id, String domain, OutgoingChatEvent chat, ClientContext clientContext) {
        Intrinsics.f(id, "id");
        Intrinsics.f(domain, "domain");
        Intrinsics.f(chat, "chat");
        Intrinsics.f(clientContext, "clientContext");
        this.f39235a = id;
        this.f39236b = domain;
        this.f39237c = chat;
        this.f39238d = clientContext;
    }

    public /* synthetic */ OutgoingChatDomainEvent(String str, String str2, OutgoingChatEvent outgoingChatEvent, ClientContext clientContext, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? "chat" : str2, outgoingChatEvent, clientContext);
    }
}
