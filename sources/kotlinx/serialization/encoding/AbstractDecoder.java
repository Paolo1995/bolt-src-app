package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* compiled from: AbstractDecoder.kt */
/* loaded from: classes5.dex */
public abstract class AbstractDecoder implements Decoder, CompositeDecoder {
    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char A(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return x();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte B(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return H();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean C(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return w();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean D() {
        return true;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short E(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return s();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double F(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return v();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public <T> T G(DeserializationStrategy<T> deserializationStrategy) {
        return (T) Decoder.DefaultImpls.a(this, deserializationStrategy);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public byte H() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) J).byteValue();
    }

    public <T> T I(DeserializationStrategy<T> deserializer, T t7) {
        Intrinsics.f(deserializer, "deserializer");
        return (T) G(deserializer);
    }

    public Object J() {
        throw new SerializationException(Reflection.b(getClass()) + " can't retrieve untyped values");
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int e(SerialDescriptor enumDescriptor) {
        Intrinsics.f(enumDescriptor, "enumDescriptor");
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) J).intValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long f(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return l();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int h() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) J).intValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int i(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return h();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Void j() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int k(SerialDescriptor serialDescriptor) {
        return CompositeDecoder.DefaultImpls.a(this, serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public long l() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) J).longValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String m(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return z();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T n(SerialDescriptor descriptor, int i8, DeserializationStrategy<T> deserializer, T t7) {
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(deserializer, "deserializer");
        if (!deserializer.a().b() && !D()) {
            return (T) j();
        }
        return (T) I(deserializer, t7);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean p() {
        return CompositeDecoder.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder q(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Decoder r(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return q(descriptor.h(i8));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public short s() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) J).shortValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public float t() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) J).floatValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float u(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return t();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public double v() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) J).doubleValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean w() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) J).booleanValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public char x() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) J).charValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public <T> T y(SerialDescriptor descriptor, int i8, DeserializationStrategy<T> deserializer, T t7) {
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(deserializer, "deserializer");
        return (T) I(deserializer, t7);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public String z() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.String");
        return (String) J;
    }
}
