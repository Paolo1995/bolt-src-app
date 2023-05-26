package j$.util.stream;

import j$.util.AbstractC0151i;
import j$.util.C0113f;
import j$.util.C0152j;
import j$.util.C0157o;
import j$.util.InterfaceC0159q;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.C0126g;
import j$.util.function.C0134k;
import j$.util.function.C0137n;
import j$.util.function.C0140q;
import j$.util.function.C0142t;
import j$.util.function.C0145w;
import j$.util.function.C0148z;
import j$.util.function.InterfaceC0128h;
import j$.util.function.InterfaceC0135l;
import j$.util.function.InterfaceC0138o;
import j$.util.function.InterfaceC0143u;
import j$.util.function.InterfaceC0146x;
import j$.util.function.Supplier;
import j$.util.stream.IntStream;
import java.util.Iterator;
import java.util.stream.DoubleStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class E implements G {

    /* renamed from: a */
    final /* synthetic */ DoubleStream f50384a;

    private /* synthetic */ E(DoubleStream doubleStream) {
        this.f50384a = doubleStream;
    }

    public static /* synthetic */ G y(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof F ? ((F) doubleStream).f50391a : new E(doubleStream);
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ IntStream D(InterfaceC0143u interfaceC0143u) {
        return IntStream.VivifiedWrapper.convert(this.f50384a.mapToInt(C0142t.a(interfaceC0143u)));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ void I(InterfaceC0135l interfaceC0135l) {
        this.f50384a.forEach(C0134k.a(interfaceC0135l));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ C0152j Q(InterfaceC0128h interfaceC0128h) {
        return AbstractC0151i.b(this.f50384a.reduce(C0126g.a(interfaceC0128h)));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ double T(double d8, InterfaceC0128h interfaceC0128h) {
        return this.f50384a.reduce(d8, C0126g.a(interfaceC0128h));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ boolean U(j$.util.function.r rVar) {
        return this.f50384a.noneMatch(C0140q.a(rVar));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ boolean Y(j$.util.function.r rVar) {
        return this.f50384a.allMatch(C0140q.a(rVar));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ C0152j average() {
        return AbstractC0151i.b(this.f50384a.average());
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ G b(InterfaceC0135l interfaceC0135l) {
        return y(this.f50384a.peek(C0134k.a(interfaceC0135l)));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ Stream boxed() {
        return R2.y(this.f50384a.boxed());
    }

    @Override // j$.util.stream.InterfaceC0198i, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f50384a.close();
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ long count() {
        return this.f50384a.count();
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ G distinct() {
        return y(this.f50384a.distinct());
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ C0152j findAny() {
        return AbstractC0151i.b(this.f50384a.findAny());
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ C0152j findFirst() {
        return AbstractC0151i.b(this.f50384a.findFirst());
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ G h(j$.util.function.r rVar) {
        return y(this.f50384a.filter(C0140q.a(rVar)));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ G i(InterfaceC0138o interfaceC0138o) {
        return y(this.f50384a.flatMap(C0137n.a(interfaceC0138o)));
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ boolean isParallel() {
        return this.f50384a.isParallel();
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ InterfaceC0159q iterator() {
        return C0157o.d(this.f50384a.iterator());
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ Iterator iterator() {
        return this.f50384a.iterator();
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ InterfaceC0219n0 j(InterfaceC0146x interfaceC0146x) {
        return C0211l0.y(this.f50384a.mapToLong(C0145w.a(interfaceC0146x)));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ void l0(InterfaceC0135l interfaceC0135l) {
        this.f50384a.forEachOrdered(C0134k.a(interfaceC0135l));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ G limit(long j8) {
        return y(this.f50384a.limit(j8));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ C0152j max() {
        return AbstractC0151i.b(this.f50384a.max());
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ C0152j min() {
        return AbstractC0151i.b(this.f50384a.min());
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ Object o(Supplier supplier, j$.util.function.w0 w0Var, BiConsumer biConsumer) {
        return this.f50384a.collect(j$.util.function.G0.a(supplier), j$.util.function.v0.a(w0Var), BiConsumer.Wrapper.convert(biConsumer));
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ InterfaceC0198i onClose(Runnable runnable) {
        return C0190g.y(this.f50384a.onClose(runnable));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ G p(j$.util.function.A a8) {
        return y(this.f50384a.map(C0148z.a(a8)));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ G parallel() {
        return y(this.f50384a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ InterfaceC0198i parallel() {
        return C0190g.y(this.f50384a.parallel());
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ Stream q(InterfaceC0138o interfaceC0138o) {
        return R2.y(this.f50384a.mapToObj(C0137n.a(interfaceC0138o)));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ G sequential() {
        return y(this.f50384a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ InterfaceC0198i sequential() {
        return C0190g.y(this.f50384a.sequential());
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ G skip(long j8) {
        return y(this.f50384a.skip(j8));
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ G sorted() {
        return y(this.f50384a.sorted());
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ j$.util.D spliterator() {
        return j$.util.B.e(this.f50384a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.N.e(this.f50384a.spliterator());
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ double sum() {
        return this.f50384a.sum();
    }

    @Override // j$.util.stream.G
    public final C0113f summaryStatistics() {
        this.f50384a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ double[] toArray() {
        return this.f50384a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ InterfaceC0198i unordered() {
        return C0190g.y(this.f50384a.unordered());
    }

    @Override // j$.util.stream.G
    public final /* synthetic */ boolean x(j$.util.function.r rVar) {
        return this.f50384a.anyMatch(C0140q.a(rVar));
    }
}
