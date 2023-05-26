package eu.bolt.chat.storage.data;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: PendingRawMessageModel.kt */
@Serializable
/* loaded from: classes5.dex */
public final class PendingRawMessageModel {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39651a;

    /* renamed from: b  reason: collision with root package name */
    private final MqttMessageModel f39652b;

    /* compiled from: PendingRawMessageModel.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PendingRawMessageModel> serializer() {
            return PendingRawMessageModel$$serializer.f39653a;
        }
    }

    public /* synthetic */ PendingRawMessageModel(int i8, String str, MqttMessageModel mqttMessageModel, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, PendingRawMessageModel$$serializer.f39653a.a());
        }
        this.f39651a = str;
        this.f39652b = mqttMessageModel;
    }

    public static final void c(PendingRawMessageModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.f39651a);
        output.B(serialDesc, 1, MqttMessageModel$$serializer.f39649a, self.f39652b);
    }

    public final MqttMessageModel a() {
        return this.f39652b;
    }

    public final String b() {
        return this.f39651a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PendingRawMessageModel) {
            PendingRawMessageModel pendingRawMessageModel = (PendingRawMessageModel) obj;
            return Intrinsics.a(this.f39651a, pendingRawMessageModel.f39651a) && Intrinsics.a(this.f39652b, pendingRawMessageModel.f39652b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39651a.hashCode() * 31) + this.f39652b.hashCode();
    }

    public String toString() {
        return "PendingRawMessageModel(messageId=" + this.f39651a + ", message=" + this.f39652b + ')';
    }

    public PendingRawMessageModel(String messageId, MqttMessageModel message) {
        Intrinsics.f(messageId, "messageId");
        Intrinsics.f(message, "message");
        this.f39651a = messageId;
        this.f39652b = message;
    }
}
