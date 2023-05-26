package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;

/* compiled from: InlineClassDescriptor.kt */
/* loaded from: classes5.dex */
public final class InlineClassDescriptorKt {
    public static final <T> SerialDescriptor a(String name, final KSerializer<T> primitiveSerializer) {
        Intrinsics.f(name, "name");
        Intrinsics.f(primitiveSerializer, "primitiveSerializer");
        return new InlineClassDescriptor(name, new GeneratedSerializer<T>() { // from class: kotlinx.serialization.internal.InlineClassDescriptorKt$InlinePrimitiveDescriptor$1
            @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public SerialDescriptor a() {
                throw new IllegalStateException("unsupported".toString());
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public T b(Decoder decoder) {
                Intrinsics.f(decoder, "decoder");
                throw new IllegalStateException("unsupported".toString());
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public void c(Encoder encoder, T t7) {
                Intrinsics.f(encoder, "encoder");
                throw new IllegalStateException("unsupported".toString());
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public KSerializer<?>[] d() {
                return GeneratedSerializer.DefaultImpls.a(this);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public KSerializer<?>[] e() {
                return new KSerializer[]{primitiveSerializer};
            }
        });
    }
}
