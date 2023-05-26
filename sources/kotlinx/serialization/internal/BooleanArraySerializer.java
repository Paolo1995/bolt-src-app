package kotlinx.serialization.internal;

import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class BooleanArraySerializer extends PrimitiveArraySerializer<Boolean, boolean[], BooleanArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final BooleanArraySerializer f52131c = new BooleanArraySerializer();

    private BooleanArraySerializer() {
        super(BuiltinSerializersKt.z(BooleanCompanionObject.f50985a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: A */
    public int j(boolean[] zArr) {
        Intrinsics.f(zArr, "<this>");
        return zArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    /* renamed from: B */
    public boolean[] w() {
        return new boolean[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: C */
    public void m(CompositeDecoder decoder, int i8, BooleanArrayBuilder builder, boolean z7) {
        Intrinsics.f(decoder, "decoder");
        Intrinsics.f(builder, "builder");
        builder.e(decoder.C(a(), i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: D */
    public BooleanArrayBuilder p(boolean[] zArr) {
        Intrinsics.f(zArr, "<this>");
        return new BooleanArrayBuilder(zArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    /* renamed from: E */
    public void z(CompositeEncoder encoder, boolean[] content, int i8) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(content, "content");
        for (int i9 = 0; i9 < i8; i9++) {
            encoder.x(a(), i9, content[i9]);
        }
    }
}
