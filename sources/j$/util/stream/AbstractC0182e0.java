package j$.util.stream;

import j$.util.C0149g;
import j$.util.C0152j;
import j$.util.C0153k;
import j$.util.InterfaceC0270u;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.IntFunction;
import j$.util.function.Supplier;

/* renamed from: j$.util.stream.e0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0182e0 extends AbstractC0171c implements IntStream {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ int f50570s = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0182e0(Spliterator spliterator, int i8) {
        super(spliterator, i8, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0182e0(AbstractC0171c abstractC0171c, int i8) {
        super(abstractC0171c, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static j$.util.G P1(Spliterator spliterator) {
        if (spliterator instanceof j$.util.G) {
            return (j$.util.G) spliterator;
        }
        if (E3.f50390a) {
            E3.a(AbstractC0171c.class, "using IntStream.adapt(Spliterator<Integer> s)");
            throw null;
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    @Override // j$.util.stream.AbstractC0171c
    final F0 A1(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7, IntFunction intFunction) {
        return AbstractC0254w0.R0(abstractC0254w0, spliterator, z7);
    }

    @Override // j$.util.stream.AbstractC0171c
    final void B1(Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2) {
        j$.util.function.J w7;
        j$.util.G P1 = P1(spliterator);
        if (interfaceC0193g2 instanceof j$.util.function.J) {
            w7 = (j$.util.function.J) interfaceC0193g2;
        } else if (E3.f50390a) {
            E3.a(AbstractC0171c.class, "using IntStream.adapt(Sink<Integer> s)");
            throw null;
        } else {
            interfaceC0193g2.getClass();
            w7 = new W(0, interfaceC0193g2);
        }
        while (!interfaceC0193g2.g() && P1.i(w7)) {
        }
    }

    @Override // j$.util.stream.IntStream
    public final Object C(Supplier supplier, j$.util.function.z0 z0Var, BiConsumer biConsumer) {
        C0237s c0237s = new C0237s(biConsumer, 1);
        supplier.getClass();
        z0Var.getClass();
        return y1(new C0255w1(2, c0237s, z0Var, supplier, 4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final int C1() {
        return 2;
    }

    @Override // j$.util.stream.IntStream
    public final boolean E(j$.util.function.N n8) {
        return ((Boolean) y1(AbstractC0254w0.n1(n8, EnumC0242t0.ANY))).booleanValue();
    }

    @Override // j$.util.stream.AbstractC0171c
    final Spliterator M1(AbstractC0254w0 abstractC0254w0, C0161a c0161a, boolean z7) {
        return new g3(abstractC0254w0, c0161a, z7);
    }

    public void R(j$.util.function.J j8) {
        j8.getClass();
        y1(new P(j8, true));
    }

    @Override // j$.util.stream.IntStream
    public final Stream S(IntFunction intFunction) {
        intFunction.getClass();
        return new C0253w(this, U2.f50500p | U2.f50498n, intFunction, 1);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream V(IntFunction intFunction) {
        return new C0257x(this, U2.f50500p | U2.f50498n | U2.f50504t, intFunction, 3);
    }

    public void Z(j$.util.function.J j8) {
        j8.getClass();
        y1(new P(j8, false));
    }

    @Override // j$.util.stream.IntStream
    public final G a0(j$.util.function.Q q8) {
        q8.getClass();
        return new C0249v(this, U2.f50500p | U2.f50498n, q8, 4);
    }

    @Override // j$.util.stream.IntStream
    public final G asDoubleStream() {
        return new C0265z(this, U2.f50500p | U2.f50498n, 1);
    }

    @Override // j$.util.stream.IntStream
    public final InterfaceC0219n0 asLongStream() {
        return new Z(this, U2.f50500p | U2.f50498n, 0);
    }

    @Override // j$.util.stream.IntStream
    public final C0152j average() {
        long[] jArr = (long[]) C(new C0166b(17), new C0166b(18), new C0166b(19));
        long j8 = jArr[0];
        return j8 > 0 ? C0152j.d(jArr[1] / j8) : C0152j.a();
    }

    @Override // j$.util.stream.IntStream
    public final Stream boxed() {
        return S(new X(1));
    }

    @Override // j$.util.stream.IntStream
    public final long count() {
        return ((AbstractC0207k0) d(new C0166b(16))).sum();
    }

    @Override // j$.util.stream.IntStream
    public final InterfaceC0219n0 d(j$.util.function.U u7) {
        u7.getClass();
        return new C0261y(this, U2.f50500p | U2.f50498n, u7, 1);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream d0(j$.util.function.N n8) {
        n8.getClass();
        return new C0257x(this, U2.f50504t, n8, 4);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream distinct() {
        return ((Y1) ((Y1) boxed()).distinct()).J(new C0166b(15));
    }

    @Override // j$.util.stream.IntStream
    public final C0153k e0(j$.util.function.F f8) {
        f8.getClass();
        return (C0153k) y1(new A1(2, f8, 2));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream f0(j$.util.function.J j8) {
        j8.getClass();
        return new C0257x(this, 0, j8, 1);
    }

    @Override // j$.util.stream.IntStream
    public final C0153k findAny() {
        return (C0153k) y1(new H(false, 2, C0153k.a(), new L0(26), new C0166b(13)));
    }

    @Override // j$.util.stream.IntStream
    public final C0153k findFirst() {
        return (C0153k) y1(new H(true, 2, C0153k.a(), new L0(26), new C0166b(13)));
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final InterfaceC0270u iterator() {
        return Spliterators.g(spliterator());
    }

    @Override // j$.util.stream.IntStream
    public final IntStream k(j$.util.function.X x7) {
        x7.getClass();
        return new C0257x(this, U2.f50500p | U2.f50498n, x7, 2);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream limit(long j8) {
        if (j8 >= 0) {
            return AbstractC0254w0.m1(this, 0L, j8);
        }
        throw new IllegalArgumentException(Long.toString(j8));
    }

    @Override // j$.util.stream.IntStream
    public final C0153k max() {
        return e0(new X(2));
    }

    @Override // j$.util.stream.IntStream
    public final C0153k min() {
        return e0(new L0(27));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0254w0
    public final A0 q1(long j8, IntFunction intFunction) {
        return AbstractC0254w0.g1(j8);
    }

    @Override // j$.util.stream.IntStream
    public final int r(int i8, j$.util.function.F f8) {
        f8.getClass();
        return ((Integer) y1(new I1(2, f8, i8))).intValue();
    }

    @Override // j$.util.stream.IntStream
    public final boolean s(j$.util.function.N n8) {
        return ((Boolean) y1(AbstractC0254w0.n1(n8, EnumC0242t0.ALL))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final IntStream skip(long j8) {
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 >= 0) {
            return i8 == 0 ? this : AbstractC0254w0.m1(this, j8, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j8));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream sorted() {
        return new C0268z2(this);
    }

    @Override // j$.util.stream.AbstractC0171c, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final j$.util.G spliterator() {
        return P1(super.spliterator());
    }

    @Override // j$.util.stream.IntStream
    public final int sum() {
        return r(0, new L0(28));
    }

    @Override // j$.util.stream.IntStream
    public final C0149g summaryStatistics() {
        return (C0149g) C(new L0(13), new L0(29), new X(0));
    }

    @Override // j$.util.stream.IntStream
    public final int[] toArray() {
        return (int[]) AbstractC0254w0.d1((C0) z1(new C0166b(20))).b();
    }

    @Override // j$.util.stream.IntStream
    public final boolean u(j$.util.function.N n8) {
        return ((Boolean) y1(AbstractC0254w0.n1(n8, EnumC0242t0.NONE))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final InterfaceC0198i unordered() {
        return !E1() ? this : new C0162a0(this, U2.f50502r);
    }
}
