package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: NullableSerializer.kt */
/* loaded from: classes5.dex */
public final class NullableSerializer<T> implements KSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final KSerializer<T> f52217a;

    /* renamed from: b  reason: collision with root package name */
    private final SerialDescriptor f52218b;

    public NullableSerializer(KSerializer<T> serializer) {
        Intrinsics.f(serializer, "serializer");
        this.f52217a = serializer;
        this.f52218b = new SerialDescriptorForNullable(serializer.a());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return this.f52218b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        if (decoder.D()) {
            return (T) decoder.G(this.f52217a);
        }
        return (T) decoder.j();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void c(Encoder encoder, T t7) {
        Intrinsics.f(encoder, "encoder");
        if (t7 != null) {
            encoder.v();
            encoder.e(this.f52217a, t7);
            return;
        }
        encoder.o();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Intrinsics.a(Reflection.b(NullableSerializer.class), Reflection.b(obj.getClass())) && Intrinsics.a(this.f52217a, ((NullableSerializer) obj).f52217a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f52217a.hashCode();
    }
}
