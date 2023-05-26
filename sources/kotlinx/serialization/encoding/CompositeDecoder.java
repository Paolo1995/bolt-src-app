package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: Decoding.kt */
/* loaded from: classes5.dex */
public interface CompositeDecoder {

    /* compiled from: Decoding.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static int a(CompositeDecoder compositeDecoder, SerialDescriptor descriptor) {
            Intrinsics.f(descriptor, "descriptor");
            return -1;
        }

        public static boolean b(CompositeDecoder compositeDecoder) {
            return false;
        }

        public static /* synthetic */ Object c(CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor, int i8, DeserializationStrategy deserializationStrategy, Object obj, int i9, Object obj2) {
            if (obj2 == null) {
                if ((i9 & 8) != 0) {
                    obj = null;
                }
                return compositeDecoder.y(serialDescriptor, i8, deserializationStrategy, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
        }
    }

    char A(SerialDescriptor serialDescriptor, int i8);

    byte B(SerialDescriptor serialDescriptor, int i8);

    boolean C(SerialDescriptor serialDescriptor, int i8);

    short E(SerialDescriptor serialDescriptor, int i8);

    double F(SerialDescriptor serialDescriptor, int i8);

    SerializersModule a();

    void c(SerialDescriptor serialDescriptor);

    long f(SerialDescriptor serialDescriptor, int i8);

    int i(SerialDescriptor serialDescriptor, int i8);

    int k(SerialDescriptor serialDescriptor);

    String m(SerialDescriptor serialDescriptor, int i8);

    <T> T n(SerialDescriptor serialDescriptor, int i8, DeserializationStrategy<T> deserializationStrategy, T t7);

    int o(SerialDescriptor serialDescriptor);

    boolean p();

    Decoder r(SerialDescriptor serialDescriptor, int i8);

    float u(SerialDescriptor serialDescriptor, int i8);

    <T> T y(SerialDescriptor serialDescriptor, int i8, DeserializationStrategy<T> deserializationStrategy, T t7);
}
