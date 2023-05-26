package j$.util.stream;

import j$.util.C0113f;
import j$.util.C0152j;
import j$.util.InterfaceC0159q;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0128h;
import j$.util.function.InterfaceC0135l;
import j$.util.function.InterfaceC0138o;
import j$.util.function.InterfaceC0143u;
import j$.util.function.InterfaceC0146x;
import j$.util.function.Supplier;

/* loaded from: classes2.dex */
abstract class D extends AbstractC0171c implements G {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ int f50378s = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(Spliterator spliterator, int i8) {
        super(spliterator, i8, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(AbstractC0171c abstractC0171c, int i8) {
        super(abstractC0171c, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static j$.util.D P1(Spliterator spliterator) {
        if (spliterator instanceof j$.util.D) {
            return (j$.util.D) spliterator;
        }
        if (E3.f50390a) {
            E3.a(AbstractC0171c.class, "using DoubleStream.adapt(Spliterator<Double> s)");
            throw null;
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    @Override // j$.util.stream.AbstractC0171c
    final F0 A1(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7, IntFunction intFunction) {
        return AbstractC0254w0.Q0(abstractC0254w0, spliterator, z7);
    }

    @Override // j$.util.stream.AbstractC0171c
    final void B1(Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2) {
        InterfaceC0135l c0241t;
        j$.util.D P1 = P1(spliterator);
        if (interfaceC0193g2 instanceof InterfaceC0135l) {
            c0241t = (InterfaceC0135l) interfaceC0193g2;
        } else if (E3.f50390a) {
            E3.a(AbstractC0171c.class, "using DoubleStream.adapt(Sink<Double> s)");
            throw null;
        } else {
            interfaceC0193g2.getClass();
            c0241t = new C0241t(0, interfaceC0193g2);
        }
        while (!interfaceC0193g2.g() && P1.n(c0241t)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final int C1() {
        return 4;
    }

    @Override // j$.util.stream.G
    public final IntStream D(InterfaceC0143u interfaceC0143u) {
        interfaceC0143u.getClass();
        return new C0257x(this, U2.f50500p | U2.f50498n, interfaceC0143u, 0);
    }

    public void I(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        y1(new O(interfaceC0135l, false));
    }

    @Override // j$.util.stream.AbstractC0171c
    final Spliterator M1(AbstractC0254w0 abstractC0254w0, C0161a c0161a, boolean z7) {
        return new C0185e3(abstractC0254w0, c0161a, z7);
    }

    @Override // j$.util.stream.G
    public final C0152j Q(InterfaceC0128h interfaceC0128h) {
        interfaceC0128h.getClass();
        return (C0152j) y1(new A1(4, interfaceC0128h, 0));
    }

    @Override // j$.util.stream.G
    public final double T(double d8, InterfaceC0128h interfaceC0128h) {
        interfaceC0128h.getClass();
        return ((Double) y1(new C0263y1(4, interfaceC0128h, d8))).doubleValue();
    }

    @Override // j$.util.stream.G
    public final boolean U(j$.util.function.r rVar) {
        return ((Boolean) y1(AbstractC0254w0.l1(rVar, EnumC0242t0.NONE))).booleanValue();
    }

    @Override // j$.util.stream.G
    public final boolean Y(j$.util.function.r rVar) {
        return ((Boolean) y1(AbstractC0254w0.l1(rVar, EnumC0242t0.ALL))).booleanValue();
    }

    @Override // j$.util.stream.G
    public final C0152j average() {
        double[] dArr = (double[]) o(new C0166b(5), new C0166b(6), new C0166b(7));
        if (dArr[2] > 0.0d) {
            int i8 = AbstractC0218n.f50620a;
            double d8 = dArr[0] + dArr[1];
            double d9 = dArr[dArr.length - 1];
            if (Double.isNaN(d8) && Double.isInfinite(d9)) {
                d8 = d9;
            }
            return C0152j.d(d8 / dArr[2]);
        }
        return C0152j.a();
    }

    @Override // j$.util.stream.G
    public final G b(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0249v(this, 0, interfaceC0135l, 3);
    }

    @Override // j$.util.stream.G
    public final Stream boxed() {
        return q(new L0(20));
    }

    @Override // j$.util.stream.G
    public final long count() {
        return ((AbstractC0207k0) j(new C0166b(4))).sum();
    }

    @Override // j$.util.stream.G
    public final G distinct() {
        return ((Y1) ((Y1) boxed()).distinct()).k0(new C0166b(8));
    }

    @Override // j$.util.stream.G
    public final C0152j findAny() {
        return (C0152j) y1(new H(false, 4, C0152j.a(), new L0(23), new C0166b(10)));
    }

    @Override // j$.util.stream.G
    public final C0152j findFirst() {
        return (C0152j) y1(new H(true, 4, C0152j.a(), new L0(23), new C0166b(10)));
    }

    @Override // j$.util.stream.G
    public final G h(j$.util.function.r rVar) {
        rVar.getClass();
        return new C0249v(this, U2.f50504t, rVar, 2);
    }

    @Override // j$.util.stream.G
    public final G i(InterfaceC0138o interfaceC0138o) {
        return new C0249v(this, U2.f50500p | U2.f50498n | U2.f50504t, interfaceC0138o, 1);
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final InterfaceC0159q iterator() {
        return Spliterators.f(spliterator());
    }

    @Override // j$.util.stream.G
    public final InterfaceC0219n0 j(InterfaceC0146x interfaceC0146x) {
        interfaceC0146x.getClass();
        return new C0261y(this, U2.f50500p | U2.f50498n, interfaceC0146x, 0);
    }

    public void l0(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        y1(new O(interfaceC0135l, true));
    }

    @Override // j$.util.stream.G
    public final G limit(long j8) {
        if (j8 >= 0) {
            return AbstractC0254w0.k1(this, 0L, j8);
        }
        throw new IllegalArgumentException(Long.toString(j8));
    }

    @Override // j$.util.stream.G
    public final C0152j max() {
        return Q(new L0(19));
    }

    @Override // j$.util.stream.G
    public final C0152j min() {
        return Q(new L0(18));
    }

    @Override // j$.util.stream.G
    public final Object o(Supplier supplier, j$.util.function.w0 w0Var, BiConsumer biConsumer) {
        C0237s c0237s = new C0237s(biConsumer, 0);
        supplier.getClass();
        w0Var.getClass();
        return y1(new C0255w1(4, c0237s, w0Var, supplier, 1));
    }

    @Override // j$.util.stream.G
    public final G p(j$.util.function.A a8) {
        a8.getClass();
        return new C0249v(this, U2.f50500p | U2.f50498n, a8, 0);
    }

    @Override // j$.util.stream.G
    public final Stream q(InterfaceC0138o interfaceC0138o) {
        interfaceC0138o.getClass();
        return new C0253w(this, U2.f50500p | U2.f50498n, interfaceC0138o, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0254w0
    public final A0 q1(long j8, IntFunction intFunction) {
        return AbstractC0254w0.W0(j8);
    }

    @Override // j$.util.stream.G
    public final G skip(long j8) {
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 >= 0) {
            return i8 == 0 ? this : AbstractC0254w0.k1(this, j8, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j8));
    }

    @Override // j$.util.stream.G
    public final G sorted() {
        return new C0264y2(this);
    }

    @Override // j$.util.stream.AbstractC0171c, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final j$.util.D spliterator() {
        return P1(super.spliterator());
    }

    @Override // j$.util.stream.G
    public final double sum() {
        double[] dArr = (double[]) o(new C0166b(9), new C0166b(2), new C0166b(3));
        int i8 = AbstractC0218n.f50620a;
        double d8 = dArr[0] + dArr[1];
        double d9 = dArr[dArr.length - 1];
        return (Double.isNaN(d8) && Double.isInfinite(d9)) ? d9 : d8;
    }

    @Override // j$.util.stream.G
    public final C0113f summaryStatistics() {
        return (C0113f) o(new L0(12), new L0(21), new L0(22));
    }

    @Override // j$.util.stream.G
    public final double[] toArray() {
        return (double[]) AbstractC0254w0.c1((B0) z1(new C0166b(1))).b();
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final InterfaceC0198i unordered() {
        return !E1() ? this : new C0265z(this, U2.f50502r, 0);
    }

    @Override // j$.util.stream.G
    public final boolean x(j$.util.function.r rVar) {
        return ((Boolean) y1(AbstractC0254w0.l1(rVar, EnumC0242t0.ANY))).booleanValue();
    }
}
