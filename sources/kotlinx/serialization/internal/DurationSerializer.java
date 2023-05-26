package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: BuiltInSerializers.kt */
/* loaded from: classes5.dex */
public final class DurationSerializer implements KSerializer<Duration> {

    /* renamed from: a  reason: collision with root package name */
    public static final DurationSerializer f52161a = new DurationSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52162b = new PrimitiveSerialDescriptor("kotlin.time.Duration", PrimitiveKind.STRING.f52100a);

    private DurationSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52162b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object b(Decoder decoder) {
        return Duration.h(f(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((Duration) obj).M());
    }

    public long f(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Duration.f51176g.c(decoder.z());
    }

    public void g(Encoder encoder, long j8) {
        Intrinsics.f(encoder, "encoder");
        encoder.F(Duration.I(j8));
    }
}
