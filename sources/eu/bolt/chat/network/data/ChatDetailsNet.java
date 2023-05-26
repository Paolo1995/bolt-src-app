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

/* compiled from: ChatDetailsNet.kt */
@Serializable
/* loaded from: classes5.dex */
public final class ChatDetailsNet {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39150a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39151b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39152c;

    /* renamed from: d  reason: collision with root package name */
    private final OrderHandleNet f39153d;

    /* renamed from: e  reason: collision with root package name */
    private final long f39154e;

    /* renamed from: f  reason: collision with root package name */
    private final ChatStatusNet f39155f;

    /* compiled from: ChatDetailsNet.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ChatDetailsNet> serializer() {
            return ChatDetailsNet$$serializer.f39156a;
        }
    }

    public /* synthetic */ ChatDetailsNet(int i8, String str, String str2, String str3, OrderHandleNet orderHandleNet, long j8, ChatStatusNet chatStatusNet, SerializationConstructorMarker serializationConstructorMarker) {
        if (25 != (i8 & 25)) {
            PluginExceptionsKt.a(i8, 25, ChatDetailsNet$$serializer.f39156a.a());
        }
        this.f39150a = str;
        if ((i8 & 2) == 0) {
            this.f39151b = null;
        } else {
            this.f39151b = str2;
        }
        if ((i8 & 4) == 0) {
            this.f39152c = null;
        } else {
            this.f39152c = str3;
        }
        this.f39153d = orderHandleNet;
        this.f39154e = j8;
        if ((i8 & 32) == 0) {
            this.f39155f = ChatStatusNet.CREATED;
        } else {
            this.f39155f = chatStatusNet;
        }
    }

    public static final void f(ChatDetailsNet self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z7;
        boolean z8;
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        boolean z9 = false;
        output.y(serialDesc, 0, self.f39150a);
        if (output.z(serialDesc, 1) || self.f39151b != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            output.i(serialDesc, 1, StringSerializer.f52262a, self.f39151b);
        }
        if (output.z(serialDesc, 2) || self.f39152c != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            output.i(serialDesc, 2, StringSerializer.f52262a, self.f39152c);
        }
        output.B(serialDesc, 3, OrderHandleNet$$serializer.f39233a, self.f39153d);
        output.E(serialDesc, 4, self.f39154e);
        if (output.z(serialDesc, 5) || self.f39155f != ChatStatusNet.CREATED) {
            z9 = true;
        }
        if (z9) {
            output.B(serialDesc, 5, ChatStatusNet.Companion.serializer(), self.f39155f);
        }
    }

    public final ChatStatusNet a() {
        return this.f39155f;
    }

    public final String b() {
        return this.f39151b;
    }

    public final OrderHandleNet c() {
        return this.f39153d;
    }

    public final String d() {
        return this.f39152c;
    }

    public final String e() {
        return this.f39150a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatDetailsNet) {
            ChatDetailsNet chatDetailsNet = (ChatDetailsNet) obj;
            return Intrinsics.a(this.f39150a, chatDetailsNet.f39150a) && Intrinsics.a(this.f39151b, chatDetailsNet.f39151b) && Intrinsics.a(this.f39152c, chatDetailsNet.f39152c) && Intrinsics.a(this.f39153d, chatDetailsNet.f39153d) && this.f39154e == chatDetailsNet.f39154e && this.f39155f == chatDetailsNet.f39155f;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f39150a.hashCode() * 31;
        String str = this.f39151b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f39152c;
        return ((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f39153d.hashCode()) * 31) + a.a(this.f39154e)) * 31) + this.f39155f.hashCode();
    }

    public String toString() {
        return "ChatDetailsNet(title=" + this.f39150a + ", description=" + this.f39151b + ", thumbnailUrl=" + this.f39152c + ", orderHandle=" + this.f39153d + ", startDate=" + this.f39154e + ", chatStatus=" + this.f39155f + ')';
    }
}
