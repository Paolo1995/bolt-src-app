package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: Encoding.kt */
/* loaded from: classes5.dex */
public interface Encoder {

    /* compiled from: Encoding.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static CompositeEncoder a(Encoder encoder, SerialDescriptor descriptor, int i8) {
            Intrinsics.f(descriptor, "descriptor");
            return encoder.b(descriptor);
        }

        public static void b(Encoder encoder) {
        }

        public static <T> void c(Encoder encoder, SerializationStrategy<? super T> serializer, T t7) {
            Intrinsics.f(serializer, "serializer");
            if (serializer.a().b()) {
                encoder.e(serializer, t7);
            } else if (t7 == null) {
                encoder.o();
            } else {
                encoder.v();
                encoder.e(serializer, t7);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T> void d(Encoder encoder, SerializationStrategy<? super T> serializer, T t7) {
            Intrinsics.f(serializer, "serializer");
            serializer.c(encoder, t7);
        }
    }

    void A(int i8);

    void F(String str);

    SerializersModule a();

    CompositeEncoder b(SerialDescriptor serialDescriptor);

    <T> void e(SerializationStrategy<? super T> serializationStrategy, T t7);

    void g(double d8);

    void h(byte b8);

    CompositeEncoder j(SerialDescriptor serialDescriptor, int i8);

    void k(SerialDescriptor serialDescriptor, int i8);

    Encoder l(SerialDescriptor serialDescriptor);

    void m(long j8);

    void o();

    void q(short s7);

    void r(boolean z7);

    void t(float f8);

    void u(char c8);

    void v();
}
