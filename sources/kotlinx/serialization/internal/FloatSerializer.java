package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Primitives.kt */
/* loaded from: classes5.dex */
public final class FloatSerializer implements KSerializer<Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final FloatSerializer f52182a = new FloatSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52183b = new PrimitiveSerialDescriptor("kotlin.Float", PrimitiveKind.FLOAT.f52096a);

    private FloatSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52183b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((Number) obj).floatValue());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public Float b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Float.valueOf(decoder.t());
    }

    public void g(Encoder encoder, float f8) {
        Intrinsics.f(encoder, "encoder");
        encoder.t(f8);
    }
}
