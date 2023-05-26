package kotlinx.serialization.internal;

import kotlin.UInt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ValueClasses.kt */
/* loaded from: classes5.dex */
public final class UIntSerializer implements KSerializer<UInt> {

    /* renamed from: a  reason: collision with root package name */
    public static final UIntSerializer f52286a = new UIntSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52287b = InlineClassDescriptorKt.a("kotlin.UInt", BuiltinSerializersKt.E(IntCompanionObject.f51008a));

    private UIntSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52287b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object b(Decoder decoder) {
        return UInt.a(f(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((UInt) obj).j());
    }

    public int f(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return UInt.c(decoder.q(a()).h());
    }

    public void g(Encoder encoder, int i8) {
        Intrinsics.f(encoder, "encoder");
        encoder.l(a()).A(i8);
    }
}
