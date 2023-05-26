package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Primitives.kt */
/* loaded from: classes5.dex */
public final class CharSerializer implements KSerializer<Character> {

    /* renamed from: a  reason: collision with root package name */
    public static final CharSerializer f52144a = new CharSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52145b = new PrimitiveSerialDescriptor("kotlin.Char", PrimitiveKind.CHAR.f52094a);

    private CharSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52145b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((Character) obj).charValue());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public Character b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Character.valueOf(decoder.x());
    }

    public void g(Encoder encoder, char c8) {
        Intrinsics.f(encoder, "encoder");
        encoder.u(c8);
    }
}
