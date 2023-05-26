package j$.util.stream;

import j$.util.C0150h;
import j$.util.C0152j;
import j$.util.C0154l;
import j$.util.InterfaceC0274y;
import j$.util.function.BiConsumer;
import j$.util.function.InterfaceC0115a0;
import j$.util.function.InterfaceC0123e0;
import j$.util.function.InterfaceC0129h0;
import j$.util.function.LongUnaryOperator;
import j$.util.function.Supplier;

/* renamed from: j$.util.stream.n0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0219n0 extends InterfaceC0198i {
    Object A(Supplier supplier, j$.util.function.C0 c02, BiConsumer biConsumer);

    boolean B(j$.util.function.k0 k0Var);

    void F(InterfaceC0123e0 interfaceC0123e0);

    G L(j$.util.function.n0 n0Var);

    InterfaceC0219n0 P(LongUnaryOperator longUnaryOperator);

    IntStream W(j$.util.function.q0 q0Var);

    Stream X(InterfaceC0129h0 interfaceC0129h0);

    boolean a(j$.util.function.k0 k0Var);

    G asDoubleStream();

    C0152j average();

    Stream boxed();

    long count();

    InterfaceC0219n0 distinct();

    C0154l e(InterfaceC0115a0 interfaceC0115a0);

    InterfaceC0219n0 f(InterfaceC0123e0 interfaceC0123e0);

    C0154l findAny();

    C0154l findFirst();

    InterfaceC0219n0 g(InterfaceC0129h0 interfaceC0129h0);

    boolean g0(j$.util.function.k0 k0Var);

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    InterfaceC0274y iterator();

    InterfaceC0219n0 j0(j$.util.function.k0 k0Var);

    InterfaceC0219n0 limit(long j8);

    long m(long j8, InterfaceC0115a0 interfaceC0115a0);

    C0154l max();

    C0154l min();

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    InterfaceC0219n0 parallel();

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    InterfaceC0219n0 sequential();

    InterfaceC0219n0 skip(long j8);

    InterfaceC0219n0 sorted();

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    j$.util.J spliterator();

    long sum();

    C0150h summaryStatistics();

    long[] toArray();

    void z(InterfaceC0123e0 interfaceC0123e0);
}
