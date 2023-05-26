package eu.bolt.chat.network.data;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: TranslationInfoNet.kt */
@Serializable
/* loaded from: classes5.dex */
public final class TranslationInfoNet {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39308a;

    /* renamed from: b  reason: collision with root package name */
    private final AttributionInfoNet f39309b;

    /* compiled from: TranslationInfoNet.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TranslationInfoNet> serializer() {
            return TranslationInfoNet$$serializer.f39310a;
        }
    }

    public /* synthetic */ TranslationInfoNet(int i8, String str, AttributionInfoNet attributionInfoNet, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, TranslationInfoNet$$serializer.f39310a.a());
        }
        this.f39308a = str;
        this.f39309b = attributionInfoNet;
    }

    public static final void c(TranslationInfoNet self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.f39308a);
        output.B(serialDesc, 1, AttributionInfoNet$$serializer.f39143a, self.f39309b);
    }

    public final AttributionInfoNet a() {
        return this.f39309b;
    }

    public final String b() {
        return this.f39308a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TranslationInfoNet) {
            TranslationInfoNet translationInfoNet = (TranslationInfoNet) obj;
            return Intrinsics.a(this.f39308a, translationInfoNet.f39308a) && Intrinsics.a(this.f39309b, translationInfoNet.f39309b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39308a.hashCode() * 31) + this.f39309b.hashCode();
    }

    public String toString() {
        return "TranslationInfoNet(text=" + this.f39308a + ", attribution=" + this.f39309b + ')';
    }
}
