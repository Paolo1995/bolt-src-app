package kotlinx.datetime.serializers;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.FixedOffsetTimeZone;
import kotlinx.datetime.TimeZone;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: TimeZoneSerializers.kt */
/* loaded from: classes5.dex */
public final class FixedOffsetTimeZoneSerializer implements KSerializer<FixedOffsetTimeZone> {

    /* renamed from: a  reason: collision with root package name */
    public static final FixedOffsetTimeZoneSerializer f52044a = new FixedOffsetTimeZoneSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52045b = SerialDescriptorsKt.a("FixedOffsetTimeZone", PrimitiveKind.STRING.f52100a);

    private FixedOffsetTimeZoneSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52045b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public FixedOffsetTimeZone b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        TimeZone b8 = TimeZone.Companion.b(decoder.z());
        if (b8 instanceof FixedOffsetTimeZone) {
            return (FixedOffsetTimeZone) b8;
        }
        throw new SerializationException("Timezone identifier '" + b8 + "' does not correspond to a fixed-offset timezone");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, FixedOffsetTimeZone value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        encoder.F(value.a());
    }
}
