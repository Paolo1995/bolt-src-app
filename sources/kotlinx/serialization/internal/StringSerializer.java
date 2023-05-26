package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Primitives.kt */
/* loaded from: classes5.dex */
public final class StringSerializer implements KSerializer<String> {

    /* renamed from: a  reason: collision with root package name */
    public static final StringSerializer f52262a = new StringSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52263b = new PrimitiveSerialDescriptor("kotlin.String", PrimitiveKind.STRING.f52100a);

    private StringSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52263b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public String b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return decoder.z();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, String value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        encoder.F(value);
    }
}
