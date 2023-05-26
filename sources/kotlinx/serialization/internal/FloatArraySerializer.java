package kotlinx.serialization.internal;

import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class FloatArraySerializer extends PrimitiveArraySerializer<Float, float[], FloatArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final FloatArraySerializer f52181c = new FloatArraySerializer();

    private FloatArraySerializer() {
        super(BuiltinSerializersKt.D(FloatCompanionObject.f51005a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: A */
    public int j(float[] fArr) {
        Intrinsics.f(fArr, "<this>");
        return fArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    /* renamed from: B */
    public float[] w() {
        return new float[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: C */
    public void m(CompositeDecoder decoder, int i8, FloatArrayBuilder builder, boolean z7) {
        Intrinsics.f(decoder, "decoder");
        Intrinsics.f(builder, "builder");
        builder.e(decoder.u(a(), i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: D */
    public FloatArrayBuilder p(float[] fArr) {
        Intrinsics.f(fArr, "<this>");
        return new FloatArrayBuilder(fArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    /* renamed from: E */
    public void z(CompositeEncoder encoder, float[] content, int i8) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(content, "content");
        for (int i9 = 0; i9 < i8; i9++) {
            encoder.s(a(), i9, content[i9]);
        }
    }
}
