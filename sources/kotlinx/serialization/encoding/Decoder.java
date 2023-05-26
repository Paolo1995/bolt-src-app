package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: Decoding.kt */
/* loaded from: classes5.dex */
public interface Decoder {

    /* compiled from: Decoding.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static <T> T a(Decoder decoder, DeserializationStrategy<T> deserializer) {
            Intrinsics.f(deserializer, "deserializer");
            return deserializer.b(decoder);
        }
    }

    boolean D();

    <T> T G(DeserializationStrategy<T> deserializationStrategy);

    byte H();

    CompositeDecoder b(SerialDescriptor serialDescriptor);

    int e(SerialDescriptor serialDescriptor);

    int h();

    Void j();

    long l();

    Decoder q(SerialDescriptor serialDescriptor);

    short s();

    float t();

    double v();

    boolean w();

    char x();

    String z();
}
