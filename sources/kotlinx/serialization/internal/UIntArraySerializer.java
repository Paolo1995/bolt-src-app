package kotlinx.serialization.internal;

import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class UIntArraySerializer extends PrimitiveArraySerializer<UInt, UIntArray, UIntArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final UIntArraySerializer f52285c = new UIntArraySerializer();

    private UIntArraySerializer() {
        super(BuiltinSerializersKt.v(UInt.f50837g));
    }

    protected int A(int[] collectionSize) {
        Intrinsics.f(collectionSize, "$this$collectionSize");
        return UIntArray.r(collectionSize);
    }

    protected int[] B() {
        return UIntArray.d(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: C */
    public void m(CompositeDecoder decoder, int i8, UIntArrayBuilder builder, boolean z7) {
        Intrinsics.f(decoder, "decoder");
        Intrinsics.f(builder, "builder");
        builder.e(UInt.c(decoder.r(a(), i8).h()));
    }

    protected UIntArrayBuilder D(int[] toBuilder) {
        Intrinsics.f(toBuilder, "$this$toBuilder");
        return new UIntArrayBuilder(toBuilder, null);
    }

    protected void E(CompositeEncoder encoder, int[] content, int i8) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(content, "content");
        for (int i9 = 0; i9 < i8; i9++) {
            encoder.f(a(), i9).A(UIntArray.o(content, i9));
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ int j(Object obj) {
        return A(((UIntArray) obj).y());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ Object p(Object obj) {
        return D(((UIntArray) obj).y());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ UIntArray w() {
        return UIntArray.b(B());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ void z(CompositeEncoder compositeEncoder, UIntArray uIntArray, int i8) {
        E(compositeEncoder, uIntArray.y(), i8);
    }
}
