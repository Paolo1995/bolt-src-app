package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Primitives.kt */
/* loaded from: classes5.dex */
public final class ShortSerializer implements KSerializer<Short> {

    /* renamed from: a  reason: collision with root package name */
    public static final ShortSerializer f52260a = new ShortSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52261b = new PrimitiveSerialDescriptor("kotlin.Short", PrimitiveKind.SHORT.f52099a);

    private ShortSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52261b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((Number) obj).shortValue());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public Short b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Short.valueOf(decoder.s());
    }

    public void g(Encoder encoder, short s7) {
        Intrinsics.f(encoder, "encoder");
        encoder.q(s7);
    }
}
