package j$.util.stream;

import j$.util.C0150h;
import j$.util.C0152j;
import j$.util.C0154l;
import j$.util.InterfaceC0274y;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0115a0;
import j$.util.function.InterfaceC0123e0;
import j$.util.function.InterfaceC0129h0;
import j$.util.function.LongUnaryOperator;
import j$.util.function.Supplier;

/* renamed from: j$.util.stream.k0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0207k0 extends AbstractC0171c implements InterfaceC0219n0 {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ int f50604s = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0207k0(Spliterator spliterator, int i8) {
        super(spliterator, i8, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0207k0(AbstractC0171c abstractC0171c, int i8) {
        super(abstractC0171c, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static j$.util.J P1(Spliterator spliterator) {
        if (spliterator instanceof j$.util.J) {
            return (j$.util.J) spliterator;
        }
        if (E3.f50390a) {
            E3.a(AbstractC0171c.class, "using LongStream.adapt(Spliterator<Long> s)");
            throw null;
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final Object A(Supplier supplier, j$.util.function.C0 c02, BiConsumer biConsumer) {
        C0237s c0237s = new C0237s(biConsumer, 2);
        supplier.getClass();
        c02.getClass();
        return y1(new C0255w1(3, c0237s, c02, supplier, 0));
    }

    @Override // j$.util.stream.AbstractC0171c
    final F0 A1(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7, IntFunction intFunction) {
        return AbstractC0254w0.S0(abstractC0254w0, spliterator, z7);
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final boolean B(j$.util.function.k0 k0Var) {
        return ((Boolean) y1(AbstractC0254w0.p1(k0Var, EnumC0242t0.ALL))).booleanValue();
    }

    @Override // j$.util.stream.AbstractC0171c
    final void B1(Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2) {
        InterfaceC0123e0 c0187f0;
        j$.util.J P1 = P1(spliterator);
        if (interfaceC0193g2 instanceof InterfaceC0123e0) {
            c0187f0 = (InterfaceC0123e0) interfaceC0193g2;
        } else if (E3.f50390a) {
            E3.a(AbstractC0171c.class, "using LongStream.adapt(Sink<Long> s)");
            throw null;
        } else {
            interfaceC0193g2.getClass();
            c0187f0 = new C0187f0(0, interfaceC0193g2);
        }
        while (!interfaceC0193g2.g() && P1.d(c0187f0)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final int C1() {
        return 3;
    }

    public void F(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        y1(new Q(interfaceC0123e0, false));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final G L(j$.util.function.n0 n0Var) {
        n0Var.getClass();
        return new C0249v(this, U2.f50500p | U2.f50498n, n0Var, 5);
    }

    @Override // j$.util.stream.AbstractC0171c
    final Spliterator M1(AbstractC0254w0 abstractC0254w0, C0161a c0161a, boolean z7) {
        return new i3(abstractC0254w0, c0161a, z7);
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final InterfaceC0219n0 P(LongUnaryOperator longUnaryOperator) {
        longUnaryOperator.getClass();
        return new C0261y(this, U2.f50500p | U2.f50498n, longUnaryOperator, 2);
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final IntStream W(j$.util.function.q0 q0Var) {
        q0Var.getClass();
        return new C0257x(this, U2.f50500p | U2.f50498n, q0Var, 5);
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final Stream X(InterfaceC0129h0 interfaceC0129h0) {
        interfaceC0129h0.getClass();
        return new C0253w(this, U2.f50500p | U2.f50498n, interfaceC0129h0, 2);
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final boolean a(j$.util.function.k0 k0Var) {
        return ((Boolean) y1(AbstractC0254w0.p1(k0Var, EnumC0242t0.NONE))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final G asDoubleStream() {
        return new C0265z(this, U2.f50500p | U2.f50498n, 2);
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final C0152j average() {
        long[] jArr = (long[]) A(new C0166b(24), new C0166b(25), new C0166b(26));
        long j8 = jArr[0];
        return j8 > 0 ? C0152j.d(jArr[1] / j8) : C0152j.a();
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final Stream boxed() {
        return X(new X(5));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final long count() {
        return ((AbstractC0207k0) P(new C0166b(21))).sum();
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final InterfaceC0219n0 distinct() {
        return ((Y1) ((Y1) boxed()).distinct()).i0(new C0166b(22));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final C0154l e(InterfaceC0115a0 interfaceC0115a0) {
        interfaceC0115a0.getClass();
        return (C0154l) y1(new A1(3, interfaceC0115a0, 3));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final InterfaceC0219n0 f(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0261y(this, 0, interfaceC0123e0, 5);
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final C0154l findAny() {
        return (C0154l) y1(new H(false, 3, C0154l.a(), new L0(24), new C0166b(11)));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final C0154l findFirst() {
        return (C0154l) y1(new H(true, 3, C0154l.a(), new L0(24), new C0166b(11)));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final InterfaceC0219n0 g(InterfaceC0129h0 interfaceC0129h0) {
        return new C0261y(this, U2.f50500p | U2.f50498n | U2.f50504t, interfaceC0129h0, 3);
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final boolean g0(j$.util.function.k0 k0Var) {
        return ((Boolean) y1(AbstractC0254w0.p1(k0Var, EnumC0242t0.ANY))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final InterfaceC0274y iterator() {
        return Spliterators.h(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final InterfaceC0219n0 j0(j$.util.function.k0 k0Var) {
        k0Var.getClass();
        return new C0261y(this, U2.f50504t, k0Var, 4);
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final InterfaceC0219n0 limit(long j8) {
        if (j8 >= 0) {
            return AbstractC0254w0.o1(this, 0L, j8);
        }
        throw new IllegalArgumentException(Long.toString(j8));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final long m(long j8, InterfaceC0115a0 interfaceC0115a0) {
        interfaceC0115a0.getClass();
        return ((Long) y1(new M1(3, interfaceC0115a0, j8))).longValue();
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final C0154l max() {
        return e(new X(4));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final C0154l min() {
        return e(new X(3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0254w0
    public final A0 q1(long j8, IntFunction intFunction) {
        return AbstractC0254w0.i1(j8);
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final InterfaceC0219n0 skip(long j8) {
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 >= 0) {
            return i8 == 0 ? this : AbstractC0254w0.o1(this, j8, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j8));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final InterfaceC0219n0 sorted() {
        return new A2(this);
    }

    @Override // j$.util.stream.AbstractC0171c, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final j$.util.J spliterator() {
        return P1(super.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final long sum() {
        return m(0L, new X(6));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final C0150h summaryStatistics() {
        return (C0150h) A(new L0(14), new X(7), new X(8));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final long[] toArray() {
        return (long[]) AbstractC0254w0.e1((D0) z1(new C0166b(23))).b();
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final InterfaceC0198i unordered() {
        return !E1() ? this : new Z(this, U2.f50502r, 1);
    }

    public void z(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        y1(new Q(interfaceC0123e0, true));
    }
}
