package kotlinx.serialization.internal;

import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class ULongArraySerializer extends PrimitiveArraySerializer<ULong, ULongArray, ULongArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final ULongArraySerializer f52290c = new ULongArraySerializer();

    private ULongArraySerializer() {
        super(BuiltinSerializersKt.w(ULong.f50842g));
    }

    protected int A(long[] collectionSize) {
        Intrinsics.f(collectionSize, "$this$collectionSize");
        return ULongArray.r(collectionSize);
    }

    protected long[] B() {
        return ULongArray.d(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: C */
    public void m(CompositeDecoder decoder, int i8, ULongArrayBuilder builder, boolean z7) {
        Intrinsics.f(decoder, "decoder");
        Intrinsics.f(builder, "builder");
        builder.e(ULong.c(decoder.r(a(), i8).l()));
    }

    protected ULongArrayBuilder D(long[] toBuilder) {
        Intrinsics.f(toBuilder, "$this$toBuilder");
        return new ULongArrayBuilder(toBuilder, null);
    }

    protected void E(CompositeEncoder encoder, long[] content, int i8) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(content, "content");
        for (int i9 = 0; i9 < i8; i9++) {
            encoder.f(a(), i9).m(ULongArray.o(content, i9));
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ int j(Object obj) {
        return A(((ULongArray) obj).y());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ Object p(Object obj) {
        return D(((ULongArray) obj).y());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ ULongArray w() {
        return ULongArray.b(B());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ void z(CompositeEncoder compositeEncoder, ULongArray uLongArray, int i8) {
        E(compositeEncoder, uLongArray.y(), i8);
    }
}
