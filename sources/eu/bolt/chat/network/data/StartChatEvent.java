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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: IncomingChatEvent.kt */
@Serializable
/* loaded from: classes5.dex */
public final class StartChatEvent extends EventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final String f39299b;

    /* renamed from: c  reason: collision with root package name */
    private final long f39300c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39301d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39302e;

    /* renamed from: f  reason: collision with root package name */
    private final String f39303f;

    /* renamed from: g  reason: collision with root package name */
    private final OrderHandleNet f39304g;

    /* renamed from: h  reason: collision with root package name */
    private final ChatMessageSender f39305h;

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<StartChatEvent> serializer() {
            return StartChatEvent$$serializer.f39306a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StartChatEvent(int i8, String str, long j8, String str2, String str3, String str4, OrderHandleNet orderHandleNet, ChatMessageSender chatMessageSender, SerializationConstructorMarker serializationConstructorMarker) {
        super(i8, serializationConstructorMarker);
        if (47 != (i8 & 47)) {
            PluginExceptionsKt.a(i8, 47, StartChatEvent$$serializer.f39306a.a());
        }
        this.f39299b = str;
        this.f39300c = j8;
        this.f39301d = str2;
        this.f39302e = str3;
        if ((i8 & 16) == 0) {
            this.f39303f = null;
        } else {
            this.f39303f = str4;
        }
        this.f39304g = orderHandleNet;
        if ((i8 & 64) == 0) {
            this.f39305h = null;
        } else {
            this.f39305h = chatMessageSender;
        }
    }

    public static final void j(StartChatEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z7;
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        EventBase.d(self, output, serialDesc);
        boolean z8 = false;
        output.y(serialDesc, 0, self.f());
        output.E(serialDesc, 1, self.b());
        output.y(serialDesc, 2, self.f39301d);
        output.y(serialDesc, 3, self.f39302e);
        if (output.z(serialDesc, 4) || self.f39303f != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            output.i(serialDesc, 4, StringSerializer.f52262a, self.f39303f);
        }
        output.B(serialDesc, 5, OrderHandleNet$$serializer.f39233a, self.f39304g);
        if (output.z(serialDesc, 6) || self.c() != null) {
            z8 = true;
        }
        if (z8) {
            output.i(serialDesc, 6, ChatMessageSender$$serializer.f39165a, self.c());
        }
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public long b() {
        return this.f39300c;
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public ChatMessageSender c() {
        return this.f39305h;
    }

    public final String e() {
        return this.f39302e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StartChatEvent) {
            StartChatEvent startChatEvent = (StartChatEvent) obj;
            return Intrinsics.a(f(), startChatEvent.f()) && b() == startChatEvent.b() && Intrinsics.a(this.f39301d, startChatEvent.f39301d) && Intrinsics.a(this.f39302e, startChatEvent.f39302e) && Intrinsics.a(this.f39303f, startChatEvent.f39303f) && Intrinsics.a(this.f39304g, startChatEvent.f39304g) && Intrinsics.a(c(), startChatEvent.c());
        }
        return false;
    }

    public String f() {
        return this.f39299b;
    }

    public final OrderHandleNet g() {
        return this.f39304g;
    }

    public final String h() {
        return this.f39303f;
    }

    public int hashCode() {
        int hashCode = ((((((f().hashCode() * 31) + a.a(b())) * 31) + this.f39301d.hashCode()) * 31) + this.f39302e.hashCode()) * 31;
        String str = this.f39303f;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f39304g.hashCode()) * 31) + (c() != null ? c().hashCode() : 0);
    }

    public final String i() {
        return this.f39301d;
    }

    public String toString() {
        return "StartChatEvent(id=" + f() + ", date=" + b() + ", title=" + this.f39301d + ", description=" + this.f39302e + ", thumbnailURL=" + this.f39303f + ", orderHandle=" + this.f39304g + ", sender=" + c() + ')';
    }
}
