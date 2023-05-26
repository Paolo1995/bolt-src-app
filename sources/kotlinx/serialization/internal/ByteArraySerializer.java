package kotlinx.serialization.internal;

import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class ByteArraySerializer extends PrimitiveArraySerializer<Byte, byte[], ByteArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final ByteArraySerializer f52136c = new ByteArraySerializer();

    private ByteArraySerializer() {
        super(BuiltinSerializersKt.A(ByteCompanionObject.f50986a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: A */
    public int j(byte[] bArr) {
        Intrinsics.f(bArr, "<this>");
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    /* renamed from: B */
    public byte[] w() {
        return new byte[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: C */
    public void m(CompositeDecoder decoder, int i8, ByteArrayBuilder builder, boolean z7) {
        Intrinsics.f(decoder, "decoder");
        Intrinsics.f(builder, "builder");
        builder.e(decoder.B(a(), i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: D */
    public ByteArrayBuilder p(byte[] bArr) {
        Intrinsics.f(bArr, "<this>");
        return new ByteArrayBuilder(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    /* renamed from: E */
    public void z(CompositeEncoder encoder, byte[] content, int i8) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(content, "content");
        for (int i9 = 0; i9 < i8; i9++) {
            encoder.p(a(), i9, content[i9]);
        }
    }
}
