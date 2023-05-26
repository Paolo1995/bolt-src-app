package eu.bolt.chat.network.data;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: QuickReplySuggestionNet.kt */
@Serializable
/* loaded from: classes5.dex */
public final class QuickReplySuggestionNet {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39268a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39269b;

    /* compiled from: QuickReplySuggestionNet.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<QuickReplySuggestionNet> serializer() {
            return QuickReplySuggestionNet$$serializer.f39270a;
        }
    }

    public /* synthetic */ QuickReplySuggestionNet(int i8, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, QuickReplySuggestionNet$$serializer.f39270a.a());
        }
        this.f39268a = str;
        this.f39269b = str2;
    }

    public static final void c(QuickReplySuggestionNet self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.f39268a);
        output.y(serialDesc, 1, self.f39269b);
    }

    public final String a() {
        return this.f39268a;
    }

    public final String b() {
        return this.f39269b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuickReplySuggestionNet) {
            QuickReplySuggestionNet quickReplySuggestionNet = (QuickReplySuggestionNet) obj;
            return Intrinsics.a(this.f39268a, quickReplySuggestionNet.f39268a) && Intrinsics.a(this.f39269b, quickReplySuggestionNet.f39269b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39268a.hashCode() * 31) + this.f39269b.hashCode();
    }

    public String toString() {
        return "QuickReplySuggestionNet(id=" + this.f39268a + ", text=" + this.f39269b + ')';
    }
}
