package kotlinx.datetime.serializers;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.UtcOffset;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: TimeZoneSerializers.kt */
/* loaded from: classes5.dex */
public final class UtcOffsetSerializer implements KSerializer<UtcOffset> {

    /* renamed from: a  reason: collision with root package name */
    public static final UtcOffsetSerializer f52052a = new UtcOffsetSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52053b = SerialDescriptorsKt.a("UtcOffset", PrimitiveKind.STRING.f52100a);

    private UtcOffsetSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52053b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public UtcOffset b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return UtcOffset.Companion.a(decoder.z());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, UtcOffset value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        encoder.F(value.toString());
    }
}
