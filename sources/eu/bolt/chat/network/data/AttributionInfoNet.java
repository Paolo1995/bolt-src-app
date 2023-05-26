package eu.bolt.chat.network.data;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AttributionInfoNet.kt */
@Serializable
/* loaded from: classes5.dex */
public final class AttributionInfoNet {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39141a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39142b;

    /* compiled from: AttributionInfoNet.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AttributionInfoNet> serializer() {
            return AttributionInfoNet$$serializer.f39143a;
        }
    }

    public AttributionInfoNet() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ AttributionInfoNet(int i8, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 0) != 0) {
            PluginExceptionsKt.a(i8, 0, AttributionInfoNet$$serializer.f39143a.a());
        }
        if ((i8 & 1) == 0) {
            this.f39141a = null;
        } else {
            this.f39141a = str;
        }
        if ((i8 & 2) == 0) {
            this.f39142b = null;
        } else {
            this.f39142b = str2;
        }
    }

    public static final void c(AttributionInfoNet self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z7;
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        boolean z8 = false;
        if (output.z(serialDesc, 0) || self.f39141a != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            output.i(serialDesc, 0, StringSerializer.f52262a, self.f39141a);
        }
        if (output.z(serialDesc, 1) || self.f39142b != null) {
            z8 = true;
        }
        if (z8) {
            output.i(serialDesc, 1, StringSerializer.f52262a, self.f39142b);
        }
    }

    public final String a() {
        return this.f39142b;
    }

    public final String b() {
        return this.f39141a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AttributionInfoNet) {
            AttributionInfoNet attributionInfoNet = (AttributionInfoNet) obj;
            return Intrinsics.a(this.f39141a, attributionInfoNet.f39141a) && Intrinsics.a(this.f39142b, attributionInfoNet.f39142b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f39141a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f39142b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AttributionInfoNet(providerName=" + this.f39141a + ", providerLogoUrl=" + this.f39142b + ')';
    }

    public AttributionInfoNet(String str, String str2) {
        this.f39141a = str;
        this.f39142b = str2;
    }

    public /* synthetic */ AttributionInfoNet(String str, String str2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2);
    }
}
