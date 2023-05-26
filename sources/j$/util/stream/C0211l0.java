package j$.util.stream;

import j$.util.AbstractC0151i;
import j$.util.C0150h;
import j$.util.C0152j;
import j$.util.C0154l;
import j$.util.C0272w;
import j$.util.InterfaceC0274y;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.C0121d0;
import j$.util.function.C0127g0;
import j$.util.function.C0133j0;
import j$.util.function.InterfaceC0115a0;
import j$.util.function.InterfaceC0123e0;
import j$.util.function.InterfaceC0129h0;
import j$.util.function.LongUnaryOperator;
import j$.util.function.Supplier;
import j$.util.stream.IntStream;
import java.util.Iterator;
import java.util.stream.LongStream;

/* renamed from: j$.util.stream.l0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0211l0 implements InterfaceC0219n0 {

    /* renamed from: a */
    final /* synthetic */ LongStream f50611a;

    private /* synthetic */ C0211l0(LongStream longStream) {
        this.f50611a = longStream;
    }

    public static /* synthetic */ InterfaceC0219n0 y(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof C0215m0 ? ((C0215m0) longStream).f50616a : new C0211l0(longStream);
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ Object A(Supplier supplier, j$.util.function.C0 c02, BiConsumer biConsumer) {
        return this.f50611a.collect(j$.util.function.G0.a(supplier), j$.util.function.B0.a(c02), BiConsumer.Wrapper.convert(biConsumer));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ boolean B(j$.util.function.k0 k0Var) {
        return this.f50611a.allMatch(C0133j0.a(k0Var));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ void F(InterfaceC0123e0 interfaceC0123e0) {
        this.f50611a.forEach(C0121d0.a(interfaceC0123e0));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ G L(j$.util.function.n0 n0Var) {
        return E.y(this.f50611a.mapToDouble(j$.util.function.m0.a(n0Var)));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ InterfaceC0219n0 P(LongUnaryOperator longUnaryOperator) {
        return y(this.f50611a.map(j$.util.function.t0.a(longUnaryOperator)));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ IntStream W(j$.util.function.q0 q0Var) {
        return IntStream.VivifiedWrapper.convert(this.f50611a.mapToInt(j$.util.function.p0.a(q0Var)));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ Stream X(InterfaceC0129h0 interfaceC0129h0) {
        return R2.y(this.f50611a.mapToObj(C0127g0.a(interfaceC0129h0)));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ boolean a(j$.util.function.k0 k0Var) {
        return this.f50611a.noneMatch(C0133j0.a(k0Var));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ G asDoubleStream() {
        return E.y(this.f50611a.asDoubleStream());
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ C0152j average() {
        return AbstractC0151i.b(this.f50611a.average());
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ Stream boxed() {
        return R2.y(this.f50611a.boxed());
    }

    @Override // j$.util.stream.InterfaceC0198i, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f50611a.close();
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ long count() {
        return this.f50611a.count();
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ InterfaceC0219n0 distinct() {
        return y(this.f50611a.distinct());
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ C0154l e(InterfaceC0115a0 interfaceC0115a0) {
        return AbstractC0151i.d(this.f50611a.reduce(j$.util.function.Z.a(interfaceC0115a0)));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ InterfaceC0219n0 f(InterfaceC0123e0 interfaceC0123e0) {
        return y(this.f50611a.peek(C0121d0.a(interfaceC0123e0)));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ C0154l findAny() {
        return AbstractC0151i.d(this.f50611a.findAny());
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ C0154l findFirst() {
        return AbstractC0151i.d(this.f50611a.findFirst());
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ InterfaceC0219n0 g(InterfaceC0129h0 interfaceC0129h0) {
        return y(this.f50611a.flatMap(C0127g0.a(interfaceC0129h0)));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ boolean g0(j$.util.function.k0 k0Var) {
        return this.f50611a.anyMatch(C0133j0.a(k0Var));
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ boolean isParallel() {
        return this.f50611a.isParallel();
    }

    @Override // j$.util.stream.InterfaceC0219n0, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ InterfaceC0274y iterator() {
        return C0272w.d(this.f50611a.iterator());
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ Iterator iterator() {
        return this.f50611a.iterator();
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ InterfaceC0219n0 j0(j$.util.function.k0 k0Var) {
        return y(this.f50611a.filter(C0133j0.a(k0Var)));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ InterfaceC0219n0 limit(long j8) {
        return y(this.f50611a.limit(j8));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ long m(long j8, InterfaceC0115a0 interfaceC0115a0) {
        return this.f50611a.reduce(j8, j$.util.function.Z.a(interfaceC0115a0));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ C0154l max() {
        return AbstractC0151i.d(this.f50611a.max());
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ C0154l min() {
        return AbstractC0151i.d(this.f50611a.min());
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ InterfaceC0198i onClose(Runnable runnable) {
        return C0190g.y(this.f50611a.onClose(runnable));
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ InterfaceC0198i parallel() {
        return C0190g.y(this.f50611a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0219n0, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ InterfaceC0219n0 parallel() {
        return y(this.f50611a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ InterfaceC0198i sequential() {
        return C0190g.y(this.f50611a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0219n0, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ InterfaceC0219n0 sequential() {
        return y(this.f50611a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ InterfaceC0219n0 skip(long j8) {
        return y(this.f50611a.skip(j8));
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ InterfaceC0219n0 sorted() {
        return y(this.f50611a.sorted());
    }

    @Override // j$.util.stream.InterfaceC0219n0, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ j$.util.J spliterator() {
        return j$.util.H.e(this.f50611a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.N.e(this.f50611a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ long sum() {
        return this.f50611a.sum();
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final C0150h summaryStatistics() {
        this.f50611a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ long[] toArray() {
        return this.f50611a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ InterfaceC0198i unordered() {
        return C0190g.y(this.f50611a.unordered());
    }

    @Override // j$.util.stream.InterfaceC0219n0
    public final /* synthetic */ void z(InterfaceC0123e0 interfaceC0123e0) {
        this.f50611a.forEachOrdered(C0121d0.a(interfaceC0123e0));
    }
}
