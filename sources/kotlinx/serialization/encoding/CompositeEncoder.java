package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: Encoding.kt */
/* loaded from: classes5.dex */
public interface CompositeEncoder {

    /* compiled from: Encoding.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static boolean a(CompositeEncoder compositeEncoder, SerialDescriptor descriptor, int i8) {
            Intrinsics.f(descriptor, "descriptor");
            return true;
        }
    }

    <T> void B(SerialDescriptor serialDescriptor, int i8, SerializationStrategy<? super T> serializationStrategy, T t7);

    void C(SerialDescriptor serialDescriptor, int i8, short s7);

    void D(SerialDescriptor serialDescriptor, int i8, double d8);

    void E(SerialDescriptor serialDescriptor, int i8, long j8);

    void c(SerialDescriptor serialDescriptor);

    Encoder f(SerialDescriptor serialDescriptor, int i8);

    <T> void i(SerialDescriptor serialDescriptor, int i8, SerializationStrategy<? super T> serializationStrategy, T t7);

    void n(SerialDescriptor serialDescriptor, int i8, char c8);

    void p(SerialDescriptor serialDescriptor, int i8, byte b8);

    void s(SerialDescriptor serialDescriptor, int i8, float f8);

    void w(SerialDescriptor serialDescriptor, int i8, int i9);

    void x(SerialDescriptor serialDescriptor, int i8, boolean z7);

    void y(SerialDescriptor serialDescriptor, int i8, String str);

    boolean z(SerialDescriptor serialDescriptor, int i8);
}
