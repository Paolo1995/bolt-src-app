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
public final class MqttMessageModel {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39647a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39648b;

    /* compiled from: PendingRawMessageModel.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<MqttMessageModel> serializer() {
            return MqttMessageModel$$serializer.f39649a;
        }
    }

    public /* synthetic */ MqttMessageModel(int i8, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, MqttMessageModel$$serializer.f39649a.a());
        }
        this.f39647a = str;
        this.f39648b = str2;
    }

    public static final void c(MqttMessageModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.f39647a);
        output.y(serialDesc, 1, self.f39648b);
    }

    public final String a() {
        return this.f39648b;
    }

    public final String b() {
        return this.f39647a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MqttMessageModel) {
            MqttMessageModel mqttMessageModel = (MqttMessageModel) obj;
            return Intrinsics.a(this.f39647a, mqttMessageModel.f39647a) && Intrinsics.a(this.f39648b, mqttMessageModel.f39648b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39647a.hashCode() * 31) + this.f39648b.hashCode();
    }

    public String toString() {
        return "MqttMessageModel(topic=" + this.f39647a + ", payload=" + this.f39648b + ')';
    }

    public MqttMessageModel(String topic, String payload) {
        Intrinsics.f(topic, "topic");
        Intrinsics.f(payload, "payload");
        this.f39647a = topic;
        this.f39648b = payload;
    }
}
