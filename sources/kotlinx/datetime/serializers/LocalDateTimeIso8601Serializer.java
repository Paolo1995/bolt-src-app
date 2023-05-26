package kotlinx.datetime.serializers;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: LocalDateTimeSerializers.kt */
/* loaded from: classes5.dex */
public final class LocalDateTimeIso8601Serializer implements KSerializer<LocalDateTime> {

    /* renamed from: a  reason: collision with root package name */
    public static final LocalDateTimeIso8601Serializer f52048a = new LocalDateTimeIso8601Serializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52049b = SerialDescriptorsKt.a("LocalDateTime", PrimitiveKind.STRING.f52100a);

    private LocalDateTimeIso8601Serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52049b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public LocalDateTime b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return LocalDateTime.Companion.a(decoder.z());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, LocalDateTime value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        encoder.F(value.toString());
    }
}
