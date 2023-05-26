package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Primitives.kt */
/* loaded from: classes5.dex */
public final class BooleanSerializer implements KSerializer<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final BooleanSerializer f52132a = new BooleanSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52133b = new PrimitiveSerialDescriptor("kotlin.Boolean", PrimitiveKind.BOOLEAN.f52092a);

    private BooleanSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52133b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((Boolean) obj).booleanValue());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public Boolean b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Boolean.valueOf(decoder.w());
    }

    public void g(Encoder encoder, boolean z7) {
        Intrinsics.f(encoder, "encoder");
        encoder.r(z7);
    }
}
