package j$.util.stream;

import j$.util.AbstractC0151i;
import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0118c;
import j$.util.function.C0122e;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0120d;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final /* synthetic */ class R2 implements Stream {

    /* renamed from: a */
    final /* synthetic */ java.util.stream.Stream f50470a;

    private /* synthetic */ R2(java.util.stream.Stream stream) {
        this.f50470a = stream;
    }

    public static /* synthetic */ Stream y(java.util.stream.Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof Stream.Wrapper ? Stream.this : new R2(stream);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ void G(Consumer consumer) {
        this.f50470a.forEachOrdered(C0122e.a(consumer));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object H(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.f50470a.collect(j$.util.function.G0.a(supplier), BiConsumer.Wrapper.convert(biConsumer), BiConsumer.Wrapper.convert(biConsumer2));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ IntStream J(ToIntFunction toIntFunction) {
        return IntStream.VivifiedWrapper.convert(this.f50470a.mapToInt(j$.util.function.I0.a(toIntFunction)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream K(Function function) {
        return y(this.f50470a.map(j$.util.function.C.a(function)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream M(Function function) {
        return y(this.f50470a.flatMap(j$.util.function.C.a(function)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Optional N(InterfaceC0120d interfaceC0120d) {
        return AbstractC0151i.a(this.f50470a.reduce(C0118c.a(interfaceC0120d)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ boolean anyMatch(Predicate predicate) {
        return this.f50470a.anyMatch(j$.util.function.E0.a(predicate));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ boolean b0(Predicate predicate) {
        return this.f50470a.allMatch(j$.util.function.E0.a(predicate));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ IntStream c(Function function) {
        return IntStream.VivifiedWrapper.convert(this.f50470a.flatMapToInt(j$.util.function.C.a(function)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ InterfaceC0219n0 c0(Function function) {
        return C0211l0.y(this.f50470a.flatMapToLong(j$.util.function.C.a(function)));
    }

    @Override // j$.util.stream.InterfaceC0198i, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f50470a.close();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ long count() {
        return this.f50470a.count();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream distinct() {
        return y(this.f50470a.distinct());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Optional findAny() {
        return AbstractC0151i.a(this.f50470a.findAny());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Optional findFirst() {
        return AbstractC0151i.a(this.f50470a.findFirst());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ void forEach(Consumer consumer) {
        this.f50470a.forEach(C0122e.a(consumer));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ boolean h0(Predicate predicate) {
        return this.f50470a.noneMatch(j$.util.function.E0.a(predicate));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ InterfaceC0219n0 i0(ToLongFunction toLongFunction) {
        return C0211l0.y(this.f50470a.mapToLong(j$.util.function.J0.a(toLongFunction)));
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ boolean isParallel() {
        return this.f50470a.isParallel();
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ Iterator iterator() {
        return this.f50470a.iterator();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ G k0(ToDoubleFunction toDoubleFunction) {
        return E.y(this.f50470a.mapToDouble(j$.util.function.H0.a(toDoubleFunction)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object l(Object obj, BiFunction biFunction, InterfaceC0120d interfaceC0120d) {
        return this.f50470a.reduce(obj, BiFunction.Wrapper.convert(biFunction), C0118c.a(interfaceC0120d));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream limit(long j8) {
        return y(this.f50470a.limit(j8));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Optional max(Comparator comparator) {
        return AbstractC0151i.a(this.f50470a.max(comparator));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Optional min(Comparator comparator) {
        return AbstractC0151i.a(this.f50470a.min(comparator));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ G n(Function function) {
        return E.y(this.f50470a.flatMapToDouble(j$.util.function.C.a(function)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object n0(Object obj, InterfaceC0120d interfaceC0120d) {
        return this.f50470a.reduce(obj, C0118c.a(interfaceC0120d));
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ InterfaceC0198i onClose(Runnable runnable) {
        return C0190g.y(this.f50470a.onClose(runnable));
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ InterfaceC0198i parallel() {
        return C0190g.y(this.f50470a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ InterfaceC0198i sequential() {
        return C0190g.y(this.f50470a.sequential());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream skip(long j8) {
        return y(this.f50470a.skip(j8));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream sorted() {
        return y(this.f50470a.sorted());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream sorted(Comparator comparator) {
        return y(this.f50470a.sorted(comparator));
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.N.e(this.f50470a.spliterator());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream t(Predicate predicate) {
        return y(this.f50470a.filter(j$.util.function.E0.a(predicate)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object[] toArray() {
        return this.f50470a.toArray();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return this.f50470a.toArray(j$.util.function.K.a(intFunction));
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ InterfaceC0198i unordered() {
        return C0190g.y(this.f50470a.unordered());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream v(Consumer consumer) {
        return y(this.f50470a.peek(C0122e.a(consumer)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object w(InterfaceC0214m interfaceC0214m) {
        return this.f50470a.collect(C0210l.a(interfaceC0214m));
    }
}
