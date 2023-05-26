package kotlinx.serialization.internal;

import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class UByteArraySerializer extends PrimitiveArraySerializer<UByte, UByteArray, UByteArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final UByteArraySerializer f52280c = new UByteArraySerializer();

    private UByteArraySerializer() {
        super(BuiltinSerializersKt.u(UByte.f50832g));
    }

    protected int A(byte[] collectionSize) {
        Intrinsics.f(collectionSize, "$this$collectionSize");
        return UByteArray.r(collectionSize);
    }

    protected byte[] B() {
        return UByteArray.d(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: C */
    public void m(CompositeDecoder decoder, int i8, UByteArrayBuilder builder, boolean z7) {
        Intrinsics.f(decoder, "decoder");
        Intrinsics.f(builder, "builder");
        builder.e(UByte.c(decoder.r(a(), i8).H()));
    }

    protected UByteArrayBuilder D(byte[] toBuilder) {
        Intrinsics.f(toBuilder, "$this$toBuilder");
        return new UByteArrayBuilder(toBuilder, null);
    }

    protected void E(CompositeEncoder encoder, byte[] content, int i8) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(content, "content");
        for (int i9 = 0; i9 < i8; i9++) {
            encoder.f(a(), i9).h(UByteArray.o(content, i9));
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ int j(Object obj) {
        return A(((UByteArray) obj).y());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ Object p(Object obj) {
        return D(((UByteArray) obj).y());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ UByteArray w() {
        return UByteArray.b(B());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ void z(CompositeEncoder compositeEncoder, UByteArray uByteArray, int i8) {
        E(compositeEncoder, uByteArray.y(), i8);
    }
}
