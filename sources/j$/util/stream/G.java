package j$.util.stream;

import j$.util.C0113f;
import j$.util.C0152j;
import j$.util.InterfaceC0159q;
import j$.util.function.BiConsumer;
import j$.util.function.InterfaceC0128h;
import j$.util.function.InterfaceC0135l;
import j$.util.function.InterfaceC0138o;
import j$.util.function.InterfaceC0143u;
import j$.util.function.InterfaceC0146x;
import j$.util.function.Supplier;

/* loaded from: classes2.dex */
public interface G extends InterfaceC0198i {
    IntStream D(InterfaceC0143u interfaceC0143u);

    void I(InterfaceC0135l interfaceC0135l);

    C0152j Q(InterfaceC0128h interfaceC0128h);

    double T(double d8, InterfaceC0128h interfaceC0128h);

    boolean U(j$.util.function.r rVar);

    boolean Y(j$.util.function.r rVar);

    C0152j average();

    G b(InterfaceC0135l interfaceC0135l);

    Stream boxed();

    long count();

    G distinct();

    C0152j findAny();

    C0152j findFirst();

    G h(j$.util.function.r rVar);

    G i(InterfaceC0138o interfaceC0138o);

    @Override // 
    InterfaceC0159q iterator();

    InterfaceC0219n0 j(InterfaceC0146x interfaceC0146x);

    void l0(InterfaceC0135l interfaceC0135l);

    G limit(long j8);

    C0152j max();

    C0152j min();

    Object o(Supplier supplier, j$.util.function.w0 w0Var, BiConsumer biConsumer);

    G p(j$.util.function.A a8);

    @Override // 
    G parallel();

    Stream q(InterfaceC0138o interfaceC0138o);

    @Override // 
    G sequential();

    G skip(long j8);

    G sorted();

    @Override // 
    j$.util.D spliterator();

    double sum();

    C0113f summaryStatistics();

    double[] toArray();

    boolean x(j$.util.function.r rVar);
}
