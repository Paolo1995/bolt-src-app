package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Primitives.kt */
/* loaded from: classes5.dex */
public final class LongSerializer implements KSerializer<Long> {

    /* renamed from: a  reason: collision with root package name */
    public static final LongSerializer f52202a = new LongSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52203b = new PrimitiveSerialDescriptor("kotlin.Long", PrimitiveKind.LONG.f52098a);

    private LongSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52203b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((Number) obj).longValue());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public Long b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Long.valueOf(decoder.l());
    }

    public void g(Encoder encoder, long j8) {
        Intrinsics.f(encoder, "encoder");
        encoder.m(j8);
    }
}
