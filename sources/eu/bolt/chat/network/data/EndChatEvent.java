package eu.bolt.chat.network.data;

import i0.a;
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
public final class EndChatEvent extends EventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final String f39194b;

    /* renamed from: c  reason: collision with root package name */
    private final long f39195c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39196d;

    /* renamed from: e  reason: collision with root package name */
    private final ChatStatusNet f39197e;

    /* renamed from: f  reason: collision with root package name */
    private final ChatMessageSender f39198f;

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<EndChatEvent> serializer() {
            return EndChatEvent$$serializer.f39199a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EndChatEvent(int i8, String str, long j8, String str2, ChatStatusNet chatStatusNet, ChatMessageSender chatMessageSender, SerializationConstructorMarker serializationConstructorMarker) {
        super(i8, serializationConstructorMarker);
        if (7 != (i8 & 7)) {
            PluginExceptionsKt.a(i8, 7, EndChatEvent$$serializer.f39199a.a());
        }
        this.f39194b = str;
        this.f39195c = j8;
        this.f39196d = str2;
        if ((i8 & 8) == 0) {
            this.f39197e = ChatStatusNet.FINISHED;
        } else {
            this.f39197e = chatStatusNet;
        }
        if ((i8 & 16) == 0) {
            this.f39198f = null;
        } else {
            this.f39198f = chatMessageSender;
        }
    }

    public static final void h(EndChatEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z7;
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        EventBase.d(self, output, serialDesc);
        boolean z8 = false;
        output.y(serialDesc, 0, self.e());
        output.E(serialDesc, 1, self.b());
        output.y(serialDesc, 2, self.f39196d);
        if (output.z(serialDesc, 3) || self.f39197e != ChatStatusNet.FINISHED) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            output.B(serialDesc, 3, ChatStatusNet.Companion.serializer(), self.f39197e);
        }
        if (output.z(serialDesc, 4) || self.c() != null) {
            z8 = true;
        }
        if (z8) {
            output.i(serialDesc, 4, ChatMessageSender$$serializer.f39165a, self.c());
        }
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public long b() {
        return this.f39195c;
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public ChatMessageSender c() {
        return this.f39198f;
    }

    public String e() {
        return this.f39194b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EndChatEvent) {
            EndChatEvent endChatEvent = (EndChatEvent) obj;
            return Intrinsics.a(e(), endChatEvent.e()) && b() == endChatEvent.b() && Intrinsics.a(this.f39196d, endChatEvent.f39196d) && this.f39197e == endChatEvent.f39197e && Intrinsics.a(c(), endChatEvent.c());
        }
        return false;
    }

    public final String f() {
        return this.f39196d;
    }

    public final ChatStatusNet g() {
        return this.f39197e;
    }

    public int hashCode() {
        return (((((((e().hashCode() * 31) + a.a(b())) * 31) + this.f39196d.hashCode()) * 31) + this.f39197e.hashCode()) * 31) + (c() == null ? 0 : c().hashCode());
    }

    public String toString() {
        return "EndChatEvent(id=" + e() + ", date=" + b() + ", message=" + this.f39196d + ", status=" + this.f39197e + ", sender=" + c() + ')';
    }
}
