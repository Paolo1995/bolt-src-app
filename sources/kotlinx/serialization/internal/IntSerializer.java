package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Primitives.kt */
/* loaded from: classes5.dex */
public final class IntSerializer implements KSerializer<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final IntSerializer f52191a = new IntSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52192b = new PrimitiveSerialDescriptor("kotlin.Int", PrimitiveKind.INT.f52097a);

    private IntSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52192b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((Number) obj).intValue());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public Integer b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Integer.valueOf(decoder.h());
    }

    public void g(Encoder encoder, int i8) {
        Intrinsics.f(encoder, "encoder");
        encoder.A(i8);
    }
}
