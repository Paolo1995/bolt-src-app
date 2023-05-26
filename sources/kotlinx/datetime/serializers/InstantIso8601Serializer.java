package kotlinx.datetime.serializers;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: InstantSerializers.kt */
/* loaded from: classes5.dex */
public final class InstantIso8601Serializer implements KSerializer<Instant> {

    /* renamed from: a  reason: collision with root package name */
    public static final InstantIso8601Serializer f52046a = new InstantIso8601Serializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52047b = SerialDescriptorsKt.a("Instant", PrimitiveKind.STRING.f52100a);

    private InstantIso8601Serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52047b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public Instant b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Instant.Companion.d(decoder.z());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, Instant value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        encoder.F(value.toString());
    }
}
