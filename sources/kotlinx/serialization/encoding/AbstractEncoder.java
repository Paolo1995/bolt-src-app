package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.NoOpEncoder;

/* compiled from: AbstractEncoder.kt */
/* loaded from: classes5.dex */
public abstract class AbstractEncoder implements Encoder, CompositeEncoder {
    @Override // kotlinx.serialization.encoding.Encoder
    public void A(int i8) {
        I(Integer.valueOf(i8));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public <T> void B(SerialDescriptor descriptor, int i8, SerializationStrategy<? super T> serializer, T t7) {
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(serializer, "serializer");
        if (G(descriptor, i8)) {
            e(serializer, t7);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void C(SerialDescriptor descriptor, int i8, short s7) {
        Intrinsics.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            q(s7);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void D(SerialDescriptor descriptor, int i8, double d8) {
        Intrinsics.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            g(d8);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void E(SerialDescriptor descriptor, int i8, long j8) {
        Intrinsics.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            m(j8);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void F(String value) {
        Intrinsics.f(value, "value");
        I(value);
    }

    public boolean G(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return true;
    }

    public <T> void H(SerializationStrategy<? super T> serializationStrategy, T t7) {
        Encoder.DefaultImpls.c(this, serializationStrategy, t7);
    }

    public void I(Object value) {
        Intrinsics.f(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.b(value.getClass()) + " is not supported by " + Reflection.b(getClass()) + " encoder");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder b(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public <T> void e(SerializationStrategy<? super T> serializationStrategy, T t7) {
        Encoder.DefaultImpls.d(this, serializationStrategy, t7);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder f(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            return l(descriptor.h(i8));
        }
        return NoOpEncoder.f52215a;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void g(double d8) {
        I(Double.valueOf(d8));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void h(byte b8) {
        I(Byte.valueOf(b8));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public <T> void i(SerialDescriptor descriptor, int i8, SerializationStrategy<? super T> serializer, T t7) {
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(serializer, "serializer");
        if (G(descriptor, i8)) {
            H(serializer, t7);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder j(SerialDescriptor serialDescriptor, int i8) {
        return Encoder.DefaultImpls.a(this, serialDescriptor, i8);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void k(SerialDescriptor enumDescriptor, int i8) {
        Intrinsics.f(enumDescriptor, "enumDescriptor");
        I(Integer.valueOf(i8));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder l(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void m(long j8) {
        I(Long.valueOf(j8));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void n(SerialDescriptor descriptor, int i8, char c8) {
        Intrinsics.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            u(c8);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void o() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void p(SerialDescriptor descriptor, int i8, byte b8) {
        Intrinsics.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            h(b8);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void q(short s7) {
        I(Short.valueOf(s7));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void r(boolean z7) {
        I(Boolean.valueOf(z7));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void s(SerialDescriptor descriptor, int i8, float f8) {
        Intrinsics.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            t(f8);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void t(float f8) {
        I(Float.valueOf(f8));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void u(char c8) {
        I(Character.valueOf(c8));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void v() {
        Encoder.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void w(SerialDescriptor descriptor, int i8, int i9) {
        Intrinsics.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            A(i9);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void x(SerialDescriptor descriptor, int i8, boolean z7) {
        Intrinsics.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            r(z7);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void y(SerialDescriptor descriptor, int i8, String value) {
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(value, "value");
        if (G(descriptor, i8)) {
            F(value);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public boolean z(SerialDescriptor serialDescriptor, int i8) {
        return CompositeEncoder.DefaultImpls.a(this, serialDescriptor, i8);
    }
}
