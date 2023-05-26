package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: AbstractPolymorphicSerializer.kt */
/* loaded from: classes5.dex */
public abstract class AbstractPolymorphicSerializer<T> implements KSerializer<T> {
    /* JADX INFO: Access modifiers changed from: private */
    public final T g(CompositeDecoder compositeDecoder) {
        return (T) CompositeDecoder.DefaultImpls.c(compositeDecoder, a(), 1, PolymorphicSerializerKt.a(this, compositeDecoder, compositeDecoder.m(a(), 0)), null, 8, null);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final T b(Decoder decoder) {
        T t7;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (b8.p()) {
            t7 = (T) g(b8);
        } else {
            t7 = null;
            while (true) {
                int o8 = b8.o(a());
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 != 1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid index in polymorphic deserialization of ");
                            String str = (String) ref$ObjectRef.f51016f;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb.append(str);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(o8);
                            throw new SerializationException(sb.toString());
                        }
                        T t8 = ref$ObjectRef.f51016f;
                        if (t8 != null) {
                            ref$ObjectRef.f51016f = t8;
                            t7 = (T) CompositeDecoder.DefaultImpls.c(b8, a(), o8, PolymorphicSerializerKt.a(this, b8, (String) t8), null, 8, null);
                        } else {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                        }
                    } else {
                        ref$ObjectRef.f51016f = (T) b8.m(a(), o8);
                    }
                } else if (t7 != null) {
                    Intrinsics.d(t7, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
                } else {
                    throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) ref$ObjectRef.f51016f)).toString());
                }
            }
        }
        b8.c(a8);
        return t7;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, T value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerializationStrategy<? super T> b8 = PolymorphicSerializerKt.b(this, encoder, value);
        SerialDescriptor a8 = a();
        CompositeEncoder b9 = encoder.b(a8);
        b9.y(a(), 0, b8.a().i());
        SerialDescriptor a9 = a();
        Intrinsics.d(b8, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        b9.B(a9, 1, b8, value);
        b9.c(a8);
    }

    public DeserializationStrategy<? extends T> h(CompositeDecoder decoder, String str) {
        Intrinsics.f(decoder, "decoder");
        return decoder.a().d(j(), str);
    }

    public SerializationStrategy<T> i(Encoder encoder, T value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        return encoder.a().e(j(), value);
    }

    public abstract KClass<T> j();
}
