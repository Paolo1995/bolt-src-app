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

/* compiled from: ActiveChatNet.kt */
@Serializable
/* loaded from: classes5.dex */
public final class ActiveChatNet {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39133a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39134b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39135c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39136d;

    /* renamed from: e  reason: collision with root package name */
    private final OrderHandleNet f39137e;

    /* renamed from: f  reason: collision with root package name */
    private final long f39138f;

    /* compiled from: ActiveChatNet.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ActiveChatNet> serializer() {
            return ActiveChatNet$$serializer.f39139a;
        }
    }

    public /* synthetic */ ActiveChatNet(int i8, String str, String str2, String str3, String str4, OrderHandleNet orderHandleNet, long j8, SerializationConstructorMarker serializationConstructorMarker) {
        if (51 != (i8 & 51)) {
            PluginExceptionsKt.a(i8, 51, ActiveChatNet$$serializer.f39139a.a());
        }
        this.f39133a = str;
        this.f39134b = str2;
        if ((i8 & 4) == 0) {
            this.f39135c = null;
        } else {
            this.f39135c = str3;
        }
        if ((i8 & 8) == 0) {
            this.f39136d = null;
        } else {
            this.f39136d = str4;
        }
        this.f39137e = orderHandleNet;
        this.f39138f = j8;
    }

    public static final void f(ActiveChatNet self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z7;
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        boolean z8 = false;
        output.y(serialDesc, 0, self.f39133a);
        output.y(serialDesc, 1, self.f39134b);
        if (output.z(serialDesc, 2) || self.f39135c != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            output.i(serialDesc, 2, StringSerializer.f52262a, self.f39135c);
        }
        if (output.z(serialDesc, 3) || self.f39136d != null) {
            z8 = true;
        }
        if (z8) {
            output.i(serialDesc, 3, StringSerializer.f52262a, self.f39136d);
        }
        output.B(serialDesc, 4, OrderHandleNet$$serializer.f39233a, self.f39137e);
        output.E(serialDesc, 5, self.f39138f);
    }

    public final String a() {
        return this.f39133a;
    }

    public final String b() {
        return this.f39135c;
    }

    public final OrderHandleNet c() {
        return this.f39137e;
    }

    public final String d() {
        return this.f39136d;
    }

    public final String e() {
        return this.f39134b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActiveChatNet) {
            ActiveChatNet activeChatNet = (ActiveChatNet) obj;
            return Intrinsics.a(this.f39133a, activeChatNet.f39133a) && Intrinsics.a(this.f39134b, activeChatNet.f39134b) && Intrinsics.a(this.f39135c, activeChatNet.f39135c) && Intrinsics.a(this.f39136d, activeChatNet.f39136d) && Intrinsics.a(this.f39137e, activeChatNet.f39137e) && this.f39138f == activeChatNet.f39138f;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f39133a.hashCode() * 31) + this.f39134b.hashCode()) * 31;
        String str = this.f39135c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f39136d;
        return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f39137e.hashCode()) * 31) + a.a(this.f39138f);
    }

    public String toString() {
        return "ActiveChatNet(chatId=" + this.f39133a + ", title=" + this.f39134b + ", description=" + this.f39135c + ", thumbnailUrl=" + this.f39136d + ", orderHandle=" + this.f39137e + ", startDate=" + this.f39138f + ')';
    }
}
