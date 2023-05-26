package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/* compiled from: Tagged.kt */
/* loaded from: classes5.dex */
public abstract class TaggedDecoder<Tag> implements Decoder, CompositeDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Tag> f52264a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f52265b;

    private final <E> E a0(Tag tag, Function0<? extends E> function0) {
        Z(tag);
        E invoke = function0.invoke();
        if (!this.f52265b) {
            Y();
        }
        this.f52265b = false;
        return invoke;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char A(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return L(X(descriptor, i8));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte B(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return K(X(descriptor, i8));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean C(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return J(X(descriptor, i8));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean D() {
        Tag W = W();
        if (W == null) {
            return false;
        }
        return S(W);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short E(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return T(X(descriptor, i8));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double F(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return M(X(descriptor, i8));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public <T> T G(DeserializationStrategy<T> deserializationStrategy) {
        return (T) Decoder.DefaultImpls.a(this, deserializationStrategy);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte H() {
        return K(Y());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T I(DeserializationStrategy<T> deserializer, T t7) {
        Intrinsics.f(deserializer, "deserializer");
        return (T) G(deserializer);
    }

    protected boolean J(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) V).booleanValue();
    }

    protected byte K(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) V).byteValue();
    }

    protected char L(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) V).charValue();
    }

    protected double M(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) V).doubleValue();
    }

    protected int N(Tag tag, SerialDescriptor enumDescriptor) {
        Intrinsics.f(enumDescriptor, "enumDescriptor");
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) V).intValue();
    }

    protected float O(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) V).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Decoder P(Tag tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.f(inlineDescriptor, "inlineDescriptor");
        Z(tag);
        return this;
    }

    protected int Q(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) V).intValue();
    }

    protected long R(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) V).longValue();
    }

    protected boolean S(Tag tag) {
        return true;
    }

    protected short T(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) V).shortValue();
    }

    protected String U(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.String");
        return (String) V;
    }

    protected Object V(Tag tag) {
        throw new SerializationException(Reflection.b(getClass()) + " can't retrieve untyped values");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Tag W() {
        Object i02;
        i02 = CollectionsKt___CollectionsKt.i0(this.f52264a);
        return (Tag) i02;
    }

    protected abstract Tag X(SerialDescriptor serialDescriptor, int i8);

    protected final Tag Y() {
        int m8;
        ArrayList<Tag> arrayList = this.f52264a;
        m8 = CollectionsKt__CollectionsKt.m(arrayList);
        Tag remove = arrayList.remove(m8);
        this.f52265b = true;
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Z(Tag tag) {
        this.f52264a.add(tag);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule a() {
        return SerializersModuleBuildersKt.a();
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
    public final int e(SerialDescriptor enumDescriptor) {
        Intrinsics.f(enumDescriptor, "enumDescriptor");
        return N(Y(), enumDescriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long f(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return R(X(descriptor, i8));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int h() {
        return Q(Y());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int i(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return Q(X(descriptor, i8));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Void j() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int k(SerialDescriptor serialDescriptor) {
        return CompositeDecoder.DefaultImpls.a(this, serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long l() {
        return R(Y());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String m(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return U(X(descriptor, i8));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T n(SerialDescriptor descriptor, int i8, final DeserializationStrategy<T> deserializer, final T t7) {
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(deserializer, "deserializer");
        return (T) a0(X(descriptor, i8), (Function0<T>) new Function0<T>(this) { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeNullableSerializableElement$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ TaggedDecoder<Tag> f52266f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f52266f = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                if (this.f52266f.D()) {
                    return (T) this.f52266f.I(deserializer, t7);
                }
                return (T) this.f52266f.j();
            }
        });
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean p() {
        return CompositeDecoder.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Decoder q(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        return P(Y(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Decoder r(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return P(X(descriptor, i8), descriptor.h(i8));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short s() {
        return T(Y());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float t() {
        return O(Y());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float u(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return O(X(descriptor, i8));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double v() {
        return M(Y());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean w() {
        return J(Y());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char x() {
        return L(Y());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T y(SerialDescriptor descriptor, int i8, final DeserializationStrategy<T> deserializer, final T t7) {
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(deserializer, "deserializer");
        return (T) a0(X(descriptor, i8), (Function0<T>) new Function0<T>(this) { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeSerializableElement$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ TaggedDecoder<Tag> f52269f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f52269f = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return (T) this.f52269f.I(deserializer, t7);
            }
        });
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String z() {
        return U(Y());
    }
}
