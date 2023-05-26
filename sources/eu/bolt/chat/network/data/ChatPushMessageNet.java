package eu.bolt.chat.network.data;

import eu.bolt.chat.network.data.serializer.TextMessageSerializer;
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

/* compiled from: ChatPushMessageNet.kt */
@Serializable
/* loaded from: classes5.dex */
public final class ChatPushMessageNet {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39167a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39168b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39169c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39170d;

    /* renamed from: e  reason: collision with root package name */
    private final OrderHandleNet f39171e;

    /* renamed from: f  reason: collision with root package name */
    private final long f39172f;

    /* renamed from: g  reason: collision with root package name */
    private final MessageEventBase f39173g;

    /* compiled from: ChatPushMessageNet.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ChatPushMessageNet> serializer() {
            return ChatPushMessageNet$$serializer.f39174a;
        }
    }

    public /* synthetic */ ChatPushMessageNet(int i8, String str, String str2, String str3, String str4, OrderHandleNet orderHandleNet, long j8, MessageEventBase messageEventBase, SerializationConstructorMarker serializationConstructorMarker) {
        if (115 != (i8 & 115)) {
            PluginExceptionsKt.a(i8, 115, ChatPushMessageNet$$serializer.f39174a.a());
        }
        this.f39167a = str;
        this.f39168b = str2;
        if ((i8 & 4) == 0) {
            this.f39169c = null;
        } else {
            this.f39169c = str3;
        }
        if ((i8 & 8) == 0) {
            this.f39170d = null;
        } else {
            this.f39170d = str4;
        }
        this.f39171e = orderHandleNet;
        this.f39172f = j8;
        this.f39173g = messageEventBase;
    }

    public static final void g(ChatPushMessageNet self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z7;
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        boolean z8 = false;
        output.y(serialDesc, 0, self.f39167a);
        output.y(serialDesc, 1, self.f39168b);
        if (output.z(serialDesc, 2) || self.f39169c != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            output.i(serialDesc, 2, StringSerializer.f52262a, self.f39169c);
        }
        if (output.z(serialDesc, 3) || self.f39170d != null) {
            z8 = true;
        }
        if (z8) {
            output.i(serialDesc, 3, StringSerializer.f52262a, self.f39170d);
        }
        output.B(serialDesc, 4, OrderHandleNet$$serializer.f39233a, self.f39171e);
        output.E(serialDesc, 5, self.f39172f);
        output.B(serialDesc, 6, TextMessageSerializer.f39340c, self.f39173g);
    }

    public final String a() {
        return this.f39167a;
    }

    public final String b() {
        return this.f39169c;
    }

    public final MessageEventBase c() {
        return this.f39173g;
    }

    public final OrderHandleNet d() {
        return this.f39171e;
    }

    public final String e() {
        return this.f39170d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatPushMessageNet) {
            ChatPushMessageNet chatPushMessageNet = (ChatPushMessageNet) obj;
            return Intrinsics.a(this.f39167a, chatPushMessageNet.f39167a) && Intrinsics.a(this.f39168b, chatPushMessageNet.f39168b) && Intrinsics.a(this.f39169c, chatPushMessageNet.f39169c) && Intrinsics.a(this.f39170d, chatPushMessageNet.f39170d) && Intrinsics.a(this.f39171e, chatPushMessageNet.f39171e) && this.f39172f == chatPushMessageNet.f39172f && Intrinsics.a(this.f39173g, chatPushMessageNet.f39173g);
        }
        return false;
    }

    public final String f() {
        return this.f39168b;
    }

    public int hashCode() {
        int hashCode = ((this.f39167a.hashCode() * 31) + this.f39168b.hashCode()) * 31;
        String str = this.f39169c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f39170d;
        return ((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f39171e.hashCode()) * 31) + a.a(this.f39172f)) * 31) + this.f39173g.hashCode();
    }

    public String toString() {
        return "ChatPushMessageNet(chatId=" + this.f39167a + ", title=" + this.f39168b + ", description=" + this.f39169c + ", thumbnailUrl=" + this.f39170d + ", orderHandle=" + this.f39171e + ", startDate=" + this.f39172f + ", event=" + this.f39173g + ')';
    }
}
