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
public final class UnknownMessageEvent extends MessageEventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final MessageStatusNet f39316b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39317c;

    /* renamed from: d  reason: collision with root package name */
    private final long f39318d;

    /* renamed from: e  reason: collision with root package name */
    private final ChatMessageSender f39319e;

    /* renamed from: f  reason: collision with root package name */
    private final String f39320f;

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UnknownMessageEvent> serializer() {
            return UnknownMessageEvent$$serializer.f39321a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnknownMessageEvent(int i8, MessageStatusNet messageStatusNet, String str, long j8, ChatMessageSender chatMessageSender, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (22 != (i8 & 22)) {
            PluginExceptionsKt.a(i8, 22, UnknownMessageEvent$$serializer.f39321a.a());
        }
        this.f39316b = (i8 & 1) == 0 ? MessageStatusNet.DELIVERED_TO_BACKEND : messageStatusNet;
        this.f39317c = str;
        this.f39318d = j8;
        if ((i8 & 8) == 0) {
            this.f39319e = null;
        } else {
            this.f39319e = chatMessageSender;
        }
        this.f39320f = str2;
    }

    public static final void g(UnknownMessageEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z7;
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        boolean z8 = false;
        if (output.z(serialDesc, 0) || self.f() != MessageStatusNet.DELIVERED_TO_BACKEND) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            output.B(serialDesc, 0, MessageStatusNet.Companion.serializer(), self.f());
        }
        output.y(serialDesc, 1, self.e());
        output.E(serialDesc, 2, self.b());
        if (output.z(serialDesc, 3) || self.c() != null) {
            z8 = true;
        }
        if (z8) {
            output.i(serialDesc, 3, ChatMessageSender$$serializer.f39165a, self.c());
        }
        output.y(serialDesc, 4, self.f39320f);
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public long b() {
        return this.f39318d;
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public ChatMessageSender c() {
        return this.f39319e;
    }

    public String e() {
        return this.f39317c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnknownMessageEvent) {
            UnknownMessageEvent unknownMessageEvent = (UnknownMessageEvent) obj;
            return f() == unknownMessageEvent.f() && Intrinsics.a(e(), unknownMessageEvent.e()) && b() == unknownMessageEvent.b() && Intrinsics.a(c(), unknownMessageEvent.c()) && Intrinsics.a(this.f39320f, unknownMessageEvent.f39320f);
        }
        return false;
    }

    public MessageStatusNet f() {
        return this.f39316b;
    }

    public int hashCode() {
        return (((((((f().hashCode() * 31) + e().hashCode()) * 31) + a.a(b())) * 31) + (c() == null ? 0 : c().hashCode())) * 31) + this.f39320f.hashCode();
    }

    public String toString() {
        return "UnknownMessageEvent(status=" + f() + ", id=" + e() + ", date=" + b() + ", sender=" + c() + ", type=" + this.f39320f + ')';
    }
}
