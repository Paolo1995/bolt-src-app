package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Primitives.kt */
/* loaded from: classes5.dex */
public final class ByteSerializer implements KSerializer<Byte> {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteSerializer f52137a = new ByteSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52138b = new PrimitiveSerialDescriptor("kotlin.Byte", PrimitiveKind.BYTE.f52093a);

    private ByteSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52138b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((Number) obj).byteValue());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public Byte b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Byte.valueOf(decoder.H());
    }

    public void g(Encoder encoder, byte b8) {
        Intrinsics.f(encoder, "encoder");
        encoder.h(b8);
    }
}
