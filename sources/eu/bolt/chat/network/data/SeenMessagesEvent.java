package eu.bolt.chat.network.data;

import i0.a;
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

/* compiled from: IncomingChatEvent.kt */
@Serializable
/* loaded from: classes5.dex */
public final class SeenMessagesEvent extends EventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final String f39278b;

    /* renamed from: c  reason: collision with root package name */
    private final long f39279c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f39280d;

    /* renamed from: e  reason: collision with root package name */
    private final ChatMessageSender f39281e;

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SeenMessagesEvent> serializer() {
            return SeenMessagesEvent$$serializer.f39282a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SeenMessagesEvent(int i8, String str, long j8, List list, ChatMessageSender chatMessageSender, SerializationConstructorMarker serializationConstructorMarker) {
        super(i8, serializationConstructorMarker);
        if (7 != (i8 & 7)) {
            PluginExceptionsKt.a(i8, 7, SeenMessagesEvent$$serializer.f39282a.a());
        }
        this.f39278b = str;
        this.f39279c = j8;
        this.f39280d = list;
        if ((i8 & 8) == 0) {
            this.f39281e = null;
        } else {
            this.f39281e = chatMessageSender;
        }
    }

    public static final void g(SeenMessagesEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        EventBase.d(self, output, serialDesc);
        boolean z7 = false;
        output.y(serialDesc, 0, self.e());
        output.E(serialDesc, 1, self.b());
        output.B(serialDesc, 2, new ArrayListSerializer(StringSerializer.f52262a), self.f39280d);
        if (output.z(serialDesc, 3) || self.c() != null) {
            z7 = true;
        }
        if (z7) {
            output.i(serialDesc, 3, ChatMessageSender$$serializer.f39165a, self.c());
        }
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public long b() {
        return this.f39279c;
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public ChatMessageSender c() {
        return this.f39281e;
    }

    public String e() {
        return this.f39278b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SeenMessagesEvent) {
            SeenMessagesEvent seenMessagesEvent = (SeenMessagesEvent) obj;
            return Intrinsics.a(e(), seenMessagesEvent.e()) && b() == seenMessagesEvent.b() && Intrinsics.a(this.f39280d, seenMessagesEvent.f39280d) && Intrinsics.a(c(), seenMessagesEvent.c());
        }
        return false;
    }

    public final List<String> f() {
        return this.f39280d;
    }

    public int hashCode() {
        return (((((e().hashCode() * 31) + a.a(b())) * 31) + this.f39280d.hashCode()) * 31) + (c() == null ? 0 : c().hashCode());
    }

    public String toString() {
        return "SeenMessagesEvent(id=" + e() + ", date=" + b() + ", seenMessageIds=" + this.f39280d + ", sender=" + c() + ')';
    }
}
