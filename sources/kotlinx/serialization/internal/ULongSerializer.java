package kotlinx.serialization.internal;

import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ValueClasses.kt */
/* loaded from: classes5.dex */
public final class ULongSerializer implements KSerializer<ULong> {

    /* renamed from: a  reason: collision with root package name */
    public static final ULongSerializer f52291a = new ULongSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52292b = InlineClassDescriptorKt.a("kotlin.ULong", BuiltinSerializersKt.F(LongCompanionObject.f51009a));

    private ULongSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52292b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object b(Decoder decoder) {
        return ULong.a(f(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((ULong) obj).j());
    }

    public long f(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return ULong.c(decoder.q(a()).l());
    }

    public void g(Encoder encoder, long j8) {
        Intrinsics.f(encoder, "encoder");
        encoder.l(a()).m(j8);
    }
}
