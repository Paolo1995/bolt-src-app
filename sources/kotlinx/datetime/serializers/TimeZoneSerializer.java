package kotlinx.datetime.serializers;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.TimeZone;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: TimeZoneSerializers.kt */
/* loaded from: classes5.dex */
public final class TimeZoneSerializer implements KSerializer<TimeZone> {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZoneSerializer f52050a = new TimeZoneSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52051b = SerialDescriptorsKt.a("TimeZone", PrimitiveKind.STRING.f52100a);

    private TimeZoneSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52051b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public TimeZone b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return TimeZone.Companion.b(decoder.z());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, TimeZone value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        encoder.F(value.a());
    }
}
