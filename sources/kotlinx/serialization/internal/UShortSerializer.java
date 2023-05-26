package kotlinx.serialization.internal;

import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ValueClasses.kt */
/* loaded from: classes5.dex */
public final class UShortSerializer implements KSerializer<UShort> {

    /* renamed from: a  reason: collision with root package name */
    public static final UShortSerializer f52296a = new UShortSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52297b = InlineClassDescriptorKt.a("kotlin.UShort", BuiltinSerializersKt.G(ShortCompanionObject.f51019a));

    private UShortSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52297b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object b(Decoder decoder) {
        return UShort.a(f(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((UShort) obj).j());
    }

    public short f(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return UShort.c(decoder.q(a()).s());
    }

    public void g(Encoder encoder, short s7) {
        Intrinsics.f(encoder, "encoder");
        encoder.l(a()).q(s7);
    }
}
