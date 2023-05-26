package kotlinx.serialization.internal;

import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class UShortArraySerializer extends PrimitiveArraySerializer<UShort, UShortArray, UShortArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final UShortArraySerializer f52295c = new UShortArraySerializer();

    private UShortArraySerializer() {
        super(BuiltinSerializersKt.x(UShort.f50848g));
    }

    protected int A(short[] collectionSize) {
        Intrinsics.f(collectionSize, "$this$collectionSize");
        return UShortArray.r(collectionSize);
    }

    protected short[] B() {
        return UShortArray.d(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: C */
    public void m(CompositeDecoder decoder, int i8, UShortArrayBuilder builder, boolean z7) {
        Intrinsics.f(decoder, "decoder");
        Intrinsics.f(builder, "builder");
        builder.e(UShort.c(decoder.r(a(), i8).s()));
    }

    protected UShortArrayBuilder D(short[] toBuilder) {
        Intrinsics.f(toBuilder, "$this$toBuilder");
        return new UShortArrayBuilder(toBuilder, null);
    }

    protected void E(CompositeEncoder encoder, short[] content, int i8) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(content, "content");
        for (int i9 = 0; i9 < i8; i9++) {
            encoder.f(a(), i9).q(UShortArray.o(content, i9));
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ int j(Object obj) {
        return A(((UShortArray) obj).y());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ Object p(Object obj) {
        return D(((UShortArray) obj).y());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ UShortArray w() {
        return UShortArray.b(B());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ void z(CompositeEncoder compositeEncoder, UShortArray uShortArray, int i8) {
        E(compositeEncoder, uShortArray.y(), i8);
    }
}
