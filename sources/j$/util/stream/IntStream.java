package j$.util.stream;

import j$.util.AbstractC0151i;
import j$.util.C0149g;
import j$.util.C0152j;
import j$.util.C0153k;
import j$.util.C0160s;
import j$.util.C0269t;
import j$.util.InterfaceC0270u;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.IntFunction;
import j$.util.function.Supplier;
import j$.util.stream.Stream;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/* loaded from: classes2.dex */
public interface IntStream extends InterfaceC0198i {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntStream {

        /* renamed from: a */
        final /* synthetic */ java.util.stream.IntStream f50425a;

        private /* synthetic */ VivifiedWrapper(java.util.stream.IntStream intStream) {
            this.f50425a = intStream;
        }

        public static /* synthetic */ IntStream convert(java.util.stream.IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof Wrapper ? IntStream.this : new VivifiedWrapper(intStream);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ Object C(Supplier supplier, j$.util.function.z0 z0Var, BiConsumer biConsumer) {
            return this.f50425a.collect(j$.util.function.G0.a(supplier), j$.util.function.y0.a(z0Var), BiConsumer.Wrapper.convert(biConsumer));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ boolean E(j$.util.function.N n8) {
            return this.f50425a.anyMatch(j$.util.function.M.a(n8));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ void R(j$.util.function.J j8) {
            this.f50425a.forEachOrdered(j$.util.function.I.a(j8));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ Stream S(IntFunction intFunction) {
            return R2.y(this.f50425a.mapToObj(j$.util.function.K.a(intFunction)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream V(IntFunction intFunction) {
            return convert(this.f50425a.flatMap(j$.util.function.K.a(intFunction)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ void Z(j$.util.function.J j8) {
            this.f50425a.forEach(j$.util.function.I.a(j8));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ G a0(j$.util.function.Q q8) {
            return E.y(this.f50425a.mapToDouble(j$.util.function.P.a(q8)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ G asDoubleStream() {
            return E.y(this.f50425a.asDoubleStream());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ InterfaceC0219n0 asLongStream() {
            return C0211l0.y(this.f50425a.asLongStream());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ C0152j average() {
            return AbstractC0151i.b(this.f50425a.average());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ Stream boxed() {
            return R2.y(this.f50425a.boxed());
        }

        @Override // j$.util.stream.InterfaceC0198i, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            this.f50425a.close();
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ long count() {
            return this.f50425a.count();
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ InterfaceC0219n0 d(j$.util.function.U u7) {
            return C0211l0.y(this.f50425a.mapToLong(j$.util.function.T.a(u7)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream d0(j$.util.function.N n8) {
            return convert(this.f50425a.filter(j$.util.function.M.a(n8)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream distinct() {
            return convert(this.f50425a.distinct());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ C0153k e0(j$.util.function.F f8) {
            return AbstractC0151i.c(this.f50425a.reduce(j$.util.function.E.a(f8)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream f0(j$.util.function.J j8) {
            return convert(this.f50425a.peek(j$.util.function.I.a(j8)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ C0153k findAny() {
            return AbstractC0151i.c(this.f50425a.findAny());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ C0153k findFirst() {
            return AbstractC0151i.c(this.f50425a.findFirst());
        }

        @Override // j$.util.stream.InterfaceC0198i
        public final /* synthetic */ boolean isParallel() {
            return this.f50425a.isParallel();
        }

        @Override // j$.util.stream.IntStream, j$.util.stream.InterfaceC0198i, j$.util.stream.G
        public final /* synthetic */ InterfaceC0270u iterator() {
            return C0160s.d(this.f50425a.iterator());
        }

        @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
        public final /* synthetic */ Iterator iterator() {
            return this.f50425a.iterator();
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream k(j$.util.function.X x7) {
            return convert(this.f50425a.map(j$.util.function.W.a(x7)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream limit(long j8) {
            return convert(this.f50425a.limit(j8));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ C0153k max() {
            return AbstractC0151i.c(this.f50425a.max());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ C0153k min() {
            return AbstractC0151i.c(this.f50425a.min());
        }

        @Override // j$.util.stream.InterfaceC0198i
        public final /* synthetic */ InterfaceC0198i onClose(Runnable runnable) {
            return C0190g.y(this.f50425a.onClose(runnable));
        }

        @Override // j$.util.stream.IntStream, j$.util.stream.InterfaceC0198i, j$.util.stream.G
        public final /* synthetic */ IntStream parallel() {
            return convert(this.f50425a.parallel());
        }

        @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
        public final /* synthetic */ InterfaceC0198i parallel() {
            return C0190g.y(this.f50425a.parallel());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ int r(int i8, j$.util.function.F f8) {
            return this.f50425a.reduce(i8, j$.util.function.E.a(f8));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ boolean s(j$.util.function.N n8) {
            return this.f50425a.allMatch(j$.util.function.M.a(n8));
        }

        @Override // j$.util.stream.IntStream, j$.util.stream.InterfaceC0198i, j$.util.stream.G
        public final /* synthetic */ IntStream sequential() {
            return convert(this.f50425a.sequential());
        }

        @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
        public final /* synthetic */ InterfaceC0198i sequential() {
            return C0190g.y(this.f50425a.sequential());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream skip(long j8) {
            return convert(this.f50425a.skip(j8));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream sorted() {
            return convert(this.f50425a.sorted());
        }

        @Override // j$.util.stream.IntStream, j$.util.stream.InterfaceC0198i, j$.util.stream.G
        public final /* synthetic */ j$.util.G spliterator() {
            return j$.util.E.e(this.f50425a.spliterator());
        }

        @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
        public final /* synthetic */ Spliterator spliterator() {
            return j$.util.N.e(this.f50425a.spliterator());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ int sum() {
            return this.f50425a.sum();
        }

        @Override // j$.util.stream.IntStream
        public final C0149g summaryStatistics() {
            this.f50425a.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ int[] toArray() {
            return this.f50425a.toArray();
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ boolean u(j$.util.function.N n8) {
            return this.f50425a.noneMatch(j$.util.function.M.a(n8));
        }

        @Override // j$.util.stream.InterfaceC0198i
        public final /* synthetic */ InterfaceC0198i unordered() {
            return C0190g.y(this.f50425a.unordered());
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.stream.IntStream {
        private /* synthetic */ Wrapper() {
            IntStream.this = r1;
        }

        public static /* synthetic */ java.util.stream.IntStream convert(IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof VivifiedWrapper ? ((VivifiedWrapper) intStream).f50425a : new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
            return IntStream.this.s(j$.util.function.L.b(intPredicate));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ boolean anyMatch(IntPredicate intPredicate) {
            return IntStream.this.E(j$.util.function.L.b(intPredicate));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ DoubleStream asDoubleStream() {
            return F.y(IntStream.this.asDoubleStream());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ LongStream asLongStream() {
            return C0215m0.y(IntStream.this.asLongStream());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalDouble average() {
            return AbstractC0151i.f(IntStream.this.average());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.Stream boxed() {
            return Stream.Wrapper.convert(IntStream.this.boxed());
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            IntStream.this.close();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ Object collect(java.util.function.Supplier supplier, ObjIntConsumer objIntConsumer, java.util.function.BiConsumer biConsumer) {
            return IntStream.this.C(j$.util.function.F0.a(supplier), j$.util.function.x0.a(objIntConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ long count() {
            return IntStream.this.count();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream distinct() {
            return convert(IntStream.this.distinct());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream filter(IntPredicate intPredicate) {
            return convert(IntStream.this.d0(j$.util.function.L.b(intPredicate)));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalInt findAny() {
            return AbstractC0151i.g(IntStream.this.findAny());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalInt findFirst() {
            return AbstractC0151i.g(IntStream.this.findFirst());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream flatMap(java.util.function.IntFunction intFunction) {
            return convert(IntStream.this.V(IntFunction.VivifiedWrapper.convert(intFunction)));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ void forEach(IntConsumer intConsumer) {
            IntStream.this.Z(j$.util.function.H.a(intConsumer));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            IntStream.this.R(j$.util.function.H.a(intConsumer));
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ boolean isParallel() {
            return IntStream.this.isParallel();
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public final /* synthetic */ Iterator<Integer> iterator() {
            return IntStream.this.iterator();
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: iterator */
        public final /* synthetic */ Iterator<Integer> iterator2() {
            return C0269t.d(IntStream.this.iterator());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream limit(long j8) {
            return convert(IntStream.this.limit(j8));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream map(IntUnaryOperator intUnaryOperator) {
            return convert(IntStream.this.k(j$.util.function.V.d(intUnaryOperator)));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
            return F.y(IntStream.this.a0(j$.util.function.O.b(intToDoubleFunction)));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ LongStream mapToLong(IntToLongFunction intToLongFunction) {
            return C0215m0.y(IntStream.this.d(j$.util.function.S.a(intToLongFunction)));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.Stream mapToObj(java.util.function.IntFunction intFunction) {
            return Stream.Wrapper.convert(IntStream.this.S(IntFunction.VivifiedWrapper.convert(intFunction)));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalInt max() {
            return AbstractC0151i.g(IntStream.this.max());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalInt min() {
            return AbstractC0151i.g(IntStream.this.min());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ boolean noneMatch(IntPredicate intPredicate) {
            return IntStream.this.u(j$.util.function.L.b(intPredicate));
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.IntStream onClose(Runnable runnable) {
            return C0194h.y(IntStream.this.onClose(runnable));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.IntStream parallel() {
            return C0194h.y(IntStream.this.parallel());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: parallel */
        public final /* synthetic */ java.util.stream.IntStream parallel2() {
            return convert(IntStream.this.parallel());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream peek(IntConsumer intConsumer) {
            return convert(IntStream.this.f0(j$.util.function.H.a(intConsumer)));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ int reduce(int i8, IntBinaryOperator intBinaryOperator) {
            return IntStream.this.r(i8, j$.util.function.D.a(intBinaryOperator));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
            return AbstractC0151i.g(IntStream.this.e0(j$.util.function.D.a(intBinaryOperator)));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.IntStream sequential() {
            return C0194h.y(IntStream.this.sequential());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: sequential */
        public final /* synthetic */ java.util.stream.IntStream sequential2() {
            return convert(IntStream.this.sequential());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream skip(long j8) {
            return convert(IntStream.this.skip(j8));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream sorted() {
            return convert(IntStream.this.sorted());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.Spliterator<Integer> spliterator() {
            return j$.util.F.a(IntStream.this.spliterator());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: spliterator */
        public final /* synthetic */ java.util.Spliterator<Integer> spliterator2() {
            return Spliterator.Wrapper.convert(IntStream.this.spliterator());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ int sum() {
            return IntStream.this.sum();
        }

        @Override // java.util.stream.IntStream
        public final IntSummaryStatistics summaryStatistics() {
            IntStream.this.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.IntSummaryStatistics");
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ int[] toArray() {
            return IntStream.this.toArray();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.IntStream unordered() {
            return C0194h.y(IntStream.this.unordered());
        }
    }

    Object C(Supplier supplier, j$.util.function.z0 z0Var, BiConsumer biConsumer);

    boolean E(j$.util.function.N n8);

    void R(j$.util.function.J j8);

    Stream S(IntFunction intFunction);

    IntStream V(IntFunction intFunction);

    void Z(j$.util.function.J j8);

    G a0(j$.util.function.Q q8);

    G asDoubleStream();

    InterfaceC0219n0 asLongStream();

    C0152j average();

    Stream boxed();

    long count();

    InterfaceC0219n0 d(j$.util.function.U u7);

    IntStream d0(j$.util.function.N n8);

    IntStream distinct();

    C0153k e0(j$.util.function.F f8);

    IntStream f0(j$.util.function.J j8);

    C0153k findAny();

    C0153k findFirst();

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    InterfaceC0270u iterator();

    IntStream k(j$.util.function.X x7);

    IntStream limit(long j8);

    C0153k max();

    C0153k min();

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    IntStream parallel();

    int r(int i8, j$.util.function.F f8);

    boolean s(j$.util.function.N n8);

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    IntStream sequential();

    IntStream skip(long j8);

    IntStream sorted();

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    j$.util.G spliterator();

    int sum();

    C0149g summaryStatistics();

    int[] toArray();

    boolean u(j$.util.function.N n8);
}
