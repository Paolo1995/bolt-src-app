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
public final class ServiceMessageEvent extends MessageEventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final MessageStatusNet f39291b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39292c;

    /* renamed from: d  reason: collision with root package name */
    private final long f39293d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39294e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f39295f;

    /* renamed from: g  reason: collision with root package name */
    private final ChatMessageSender f39296g;

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ServiceMessageEvent> serializer() {
            return ServiceMessageEvent$$serializer.f39297a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServiceMessageEvent(int i8, MessageStatusNet messageStatusNet, String str, long j8, String str2, boolean z7, ChatMessageSender chatMessageSender, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (30 != (i8 & 30)) {
            PluginExceptionsKt.a(i8, 30, ServiceMessageEvent$$serializer.f39297a.a());
        }
        this.f39291b = (i8 & 1) == 0 ? MessageStatusNet.DELIVERED_TO_BACKEND : messageStatusNet;
        this.f39292c = str;
        this.f39293d = j8;
        this.f39294e = str2;
        this.f39295f = z7;
        if ((i8 & 32) == 0) {
            this.f39296g = null;
        } else {
            this.f39296g = chatMessageSender;
        }
    }

    public static final void i(ServiceMessageEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        output.y(serialDesc, 3, self.f39294e);
        output.x(serialDesc, 4, self.f39295f);
        if (output.z(serialDesc, 5) || self.c() != null) {
            z8 = true;
        }
        if (z8) {
            output.i(serialDesc, 5, ChatMessageSender$$serializer.f39165a, self.c());
        }
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public long b() {
        return this.f39293d;
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public ChatMessageSender c() {
        return this.f39296g;
    }

    public String e() {
        return this.f39292c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServiceMessageEvent) {
            ServiceMessageEvent serviceMessageEvent = (ServiceMessageEvent) obj;
            return f() == serviceMessageEvent.f() && Intrinsics.a(e(), serviceMessageEvent.e()) && b() == serviceMessageEvent.b() && Intrinsics.a(this.f39294e, serviceMessageEvent.f39294e) && this.f39295f == serviceMessageEvent.f39295f && Intrinsics.a(c(), serviceMessageEvent.c());
        }
        return false;
    }

    public MessageStatusNet f() {
        return this.f39291b;
    }

    public final String g() {
        return this.f39294e;
    }

    public final boolean h() {
        return this.f39295f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((f().hashCode() * 31) + e().hashCode()) * 31) + a.a(b())) * 31) + this.f39294e.hashCode()) * 31;
        boolean z7 = this.f39295f;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return ((hashCode + i8) * 31) + (c() == null ? 0 : c().hashCode());
    }

    public String toString() {
        return "ServiceMessageEvent(status=" + f() + ", id=" + e() + ", date=" + b() + ", textHtml=" + this.f39294e + ", isSilent=" + this.f39295f + ", sender=" + c() + ')';
    }
}
