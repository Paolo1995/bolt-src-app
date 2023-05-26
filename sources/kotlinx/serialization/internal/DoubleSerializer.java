package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Primitives.kt */
/* loaded from: classes5.dex */
public final class DoubleSerializer implements KSerializer<Double> {

    /* renamed from: a  reason: collision with root package name */
    public static final DoubleSerializer f52159a = new DoubleSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52160b = new PrimitiveSerialDescriptor("kotlin.Double", PrimitiveKind.DOUBLE.f52095a);

    private DoubleSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52160b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((Number) obj).doubleValue());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public Double b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Double.valueOf(decoder.v());
    }

    public void g(Encoder encoder, double d8) {
        Intrinsics.f(encoder, "encoder");
        encoder.g(d8);
    }
}
