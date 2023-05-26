package kotlinx.serialization.internal;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ValueClasses.kt */
/* loaded from: classes5.dex */
public final class UByteSerializer implements KSerializer<UByte> {

    /* renamed from: a  reason: collision with root package name */
    public static final UByteSerializer f52281a = new UByteSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52282b = InlineClassDescriptorKt.a("kotlin.UByte", BuiltinSerializersKt.A(ByteCompanionObject.f50986a));

    private UByteSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52282b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object b(Decoder decoder) {
        return UByte.a(f(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void c(Encoder encoder, Object obj) {
        g(encoder, ((UByte) obj).j());
    }

    public byte f(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return UByte.c(decoder.q(a()).H());
    }

    public void g(Encoder encoder, byte b8) {
        Intrinsics.f(encoder, "encoder");
        encoder.l(a()).h(b8);
    }
}
