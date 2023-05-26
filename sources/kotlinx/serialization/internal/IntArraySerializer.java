package kotlinx.serialization.internal;

import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class IntArraySerializer extends PrimitiveArraySerializer<Integer, int[], IntArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final IntArraySerializer f52190c = new IntArraySerializer();

    private IntArraySerializer() {
        super(BuiltinSerializersKt.E(IntCompanionObject.f51008a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: A */
    public int j(int[] iArr) {
        Intrinsics.f(iArr, "<this>");
        return iArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    /* renamed from: B */
    public int[] w() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: C */
    public void m(CompositeDecoder decoder, int i8, IntArrayBuilder builder, boolean z7) {
        Intrinsics.f(decoder, "decoder");
        Intrinsics.f(builder, "builder");
        builder.e(decoder.i(a(), i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: D */
    public IntArrayBuilder p(int[] iArr) {
        Intrinsics.f(iArr, "<this>");
        return new IntArrayBuilder(iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    /* renamed from: E */
    public void z(CompositeEncoder encoder, int[] content, int i8) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(content, "content");
        for (int i9 = 0; i9 < i8; i9++) {
            encoder.w(a(), i9, content[i9]);
        }
    }
}
