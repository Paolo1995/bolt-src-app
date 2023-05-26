package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayBuilder;

/* compiled from: CollectionSerializers.kt */
/* loaded from: classes5.dex */
public abstract class PrimitiveArraySerializer<Element, Array, Builder extends PrimitiveArrayBuilder<Array>> extends CollectionLikeSerializer<Element, Array, Builder> {

    /* renamed from: b  reason: collision with root package name */
    private final SerialDescriptor f52248b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveArraySerializer(KSerializer<Element> primitiveSerializer) {
        super(primitiveSerializer, null);
        Intrinsics.f(primitiveSerializer, "primitiveSerializer");
        this.f52248b = new PrimitiveArrayDescriptor(primitiveSerializer.a());
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return this.f52248b;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer, kotlinx.serialization.DeserializationStrategy
    public final Array b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return k(decoder, null);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Array array) {
        Intrinsics.f(encoder, "encoder");
        int j8 = j(array);
        SerialDescriptor serialDescriptor = this.f52248b;
        CompositeEncoder j9 = encoder.j(serialDescriptor, j8);
        z(j9, array, j8);
        j9.c(serialDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Iterator<Element> i(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: t */
    public final Builder f() {
        return (Builder) p(w());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: u */
    public final int g(Builder builder) {
        Intrinsics.f(builder, "<this>");
        return builder.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: v */
    public final void h(Builder builder, int i8) {
        Intrinsics.f(builder, "<this>");
        builder.b(i8);
    }

    protected abstract Array w();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    /* renamed from: x */
    public final void s(Builder builder, int i8, Element element) {
        Intrinsics.f(builder, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: y */
    public final Array q(Builder builder) {
        Intrinsics.f(builder, "<this>");
        return (Array) builder.a();
    }

    protected abstract void z(CompositeEncoder compositeEncoder, Array array, int i8);
}
