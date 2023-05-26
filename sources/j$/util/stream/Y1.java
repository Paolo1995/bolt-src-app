package j$.util.stream;

import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0114a;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0120d;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
abstract class Y1 extends AbstractC0171c implements Stream {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ int f50532s = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y1(Spliterator spliterator, int i8, boolean z7) {
        super(spliterator, i8, z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y1(AbstractC0171c abstractC0171c, int i8) {
        super(abstractC0171c, i8);
    }

    @Override // j$.util.stream.AbstractC0171c
    final F0 A1(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7, IntFunction intFunction) {
        return AbstractC0254w0.P0(abstractC0254w0, spliterator, z7, intFunction);
    }

    @Override // j$.util.stream.AbstractC0171c
    final void B1(Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2) {
        while (!interfaceC0193g2.g() && spliterator.tryAdvance(interfaceC0193g2)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final int C1() {
        return 1;
    }

    public void G(Consumer consumer) {
        consumer.getClass();
        y1(new S(consumer, true));
    }

    @Override // j$.util.stream.Stream
    public final Object H(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        supplier.getClass();
        biConsumer.getClass();
        biConsumer2.getClass();
        return y1(new C0255w1(1, biConsumer2, biConsumer, supplier, 3));
    }

    @Override // j$.util.stream.Stream
    public final IntStream J(ToIntFunction toIntFunction) {
        toIntFunction.getClass();
        return new C0257x(this, U2.f50500p | U2.f50498n, toIntFunction, 6);
    }

    @Override // j$.util.stream.Stream
    public final Stream K(Function function) {
        function.getClass();
        return new U1(this, U2.f50500p | U2.f50498n, function, 0);
    }

    @Override // j$.util.stream.Stream
    public final Stream M(Function function) {
        function.getClass();
        return new U1(this, U2.f50500p | U2.f50498n | U2.f50504t, function, 1);
    }

    @Override // j$.util.stream.AbstractC0171c
    final Spliterator M1(AbstractC0254w0 abstractC0254w0, C0161a c0161a, boolean z7) {
        return new z3(abstractC0254w0, c0161a, z7);
    }

    @Override // j$.util.stream.Stream
    public final Optional N(InterfaceC0120d interfaceC0120d) {
        interfaceC0120d.getClass();
        return (Optional) y1(new A1(1, interfaceC0120d, 1));
    }

    @Override // j$.util.stream.Stream
    public final boolean anyMatch(Predicate predicate) {
        return ((Boolean) y1(AbstractC0254w0.r1(predicate, EnumC0242t0.ANY))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final boolean b0(Predicate predicate) {
        return ((Boolean) y1(AbstractC0254w0.r1(predicate, EnumC0242t0.ALL))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final IntStream c(Function function) {
        function.getClass();
        return new C0257x(this, U2.f50500p | U2.f50498n | U2.f50504t, function, 7);
    }

    @Override // j$.util.stream.Stream
    public final InterfaceC0219n0 c0(Function function) {
        function.getClass();
        return new C0261y(this, U2.f50500p | U2.f50498n | U2.f50504t, function, 6);
    }

    @Override // j$.util.stream.Stream
    public final long count() {
        return ((AbstractC0207k0) i0(new L0(5))).sum();
    }

    @Override // j$.util.stream.Stream
    public final Stream distinct() {
        return new r(this, U2.f50497m | U2.f50504t);
    }

    @Override // j$.util.stream.Stream
    public final Optional findAny() {
        return (Optional) y1(new H(false, 1, Optional.a(), new L0(25), new C0166b(12)));
    }

    @Override // j$.util.stream.Stream
    public final Optional findFirst() {
        return (Optional) y1(new H(true, 1, Optional.a(), new L0(25), new C0166b(12)));
    }

    public void forEach(Consumer consumer) {
        consumer.getClass();
        y1(new S(consumer, false));
    }

    @Override // j$.util.stream.Stream
    public final boolean h0(Predicate predicate) {
        return ((Boolean) y1(AbstractC0254w0.r1(predicate, EnumC0242t0.NONE))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final InterfaceC0219n0 i0(ToLongFunction toLongFunction) {
        toLongFunction.getClass();
        return new C0261y(this, U2.f50500p | U2.f50498n, toLongFunction, 7);
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final Iterator iterator() {
        return Spliterators.i(spliterator());
    }

    @Override // j$.util.stream.Stream
    public final G k0(ToDoubleFunction toDoubleFunction) {
        toDoubleFunction.getClass();
        return new C0249v(this, U2.f50500p | U2.f50498n, toDoubleFunction, 6);
    }

    @Override // j$.util.stream.Stream
    public final Object l(Object obj, BiFunction biFunction, InterfaceC0120d interfaceC0120d) {
        biFunction.getClass();
        interfaceC0120d.getClass();
        return y1(new C0255w1(1, interfaceC0120d, biFunction, obj, 2));
    }

    @Override // j$.util.stream.Stream
    public final Stream limit(long j8) {
        if (j8 >= 0) {
            return AbstractC0254w0.s1(this, 0L, j8);
        }
        throw new IllegalArgumentException(Long.toString(j8));
    }

    @Override // j$.util.stream.Stream
    public final Optional max(Comparator comparator) {
        comparator.getClass();
        return N(new C0114a(0, comparator));
    }

    @Override // j$.util.stream.Stream
    public final Optional min(Comparator comparator) {
        comparator.getClass();
        return N(new C0114a(1, comparator));
    }

    @Override // j$.util.stream.Stream
    public final G n(Function function) {
        function.getClass();
        return new C0249v(this, U2.f50500p | U2.f50498n | U2.f50504t, function, 7);
    }

    @Override // j$.util.stream.Stream
    public final Object n0(Object obj, InterfaceC0120d interfaceC0120d) {
        interfaceC0120d.getClass();
        return y1(new C0255w1(1, interfaceC0120d, interfaceC0120d, obj, 2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0254w0
    public final A0 q1(long j8, IntFunction intFunction) {
        return AbstractC0254w0.O0(j8, intFunction);
    }

    @Override // j$.util.stream.Stream
    public final Stream skip(long j8) {
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 >= 0) {
            return i8 == 0 ? this : AbstractC0254w0.s1(this, j8, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j8));
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted() {
        return new B2(this);
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted(Comparator comparator) {
        return new B2(this, comparator);
    }

    @Override // j$.util.stream.Stream
    public final Stream t(Predicate predicate) {
        predicate.getClass();
        return new C0253w(this, U2.f50504t, predicate, 4);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray() {
        return toArray(new L0(4));
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray(IntFunction intFunction) {
        return AbstractC0254w0.b1(z1(intFunction), intFunction).p(intFunction);
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final InterfaceC0198i unordered() {
        return !E1() ? this : new T1(this, U2.f50502r);
    }

    @Override // j$.util.stream.Stream
    public final Stream v(Consumer consumer) {
        consumer.getClass();
        return new C0253w(this, 0, consumer, 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // j$.util.stream.Stream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object w(j$.util.stream.InterfaceC0214m r8) {
        /*
            r7 = this;
            boolean r0 = r7.isParallel()
            if (r0 == 0) goto L3d
            r0 = r8
            j$.util.stream.k r0 = (j$.util.stream.C0206k) r0
            java.util.Set r1 = r0.b()
            j$.util.stream.j r2 = j$.util.stream.EnumC0202j.CONCURRENT
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L3d
            boolean r1 = r7.E1()
            if (r1 == 0) goto L27
            java.util.Set r1 = r0.b()
            j$.util.stream.j r2 = j$.util.stream.EnumC0202j.UNORDERED
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L3d
        L27:
            j$.util.function.Supplier r1 = r0.f()
            java.lang.Object r1 = r1.get()
            j$.util.function.BiConsumer r0 = r0.a()
            j$.util.stream.o r2 = new j$.util.stream.o
            r3 = 5
            r2.<init>(r3, r0, r1)
            r7.forEach(r2)
            goto L5b
        L3d:
            r8.getClass()
            r0 = r8
            j$.util.stream.k r0 = (j$.util.stream.C0206k) r0
            j$.util.function.Supplier r5 = r0.f()
            j$.util.function.BiConsumer r4 = r0.a()
            j$.util.function.d r3 = r0.c()
            j$.util.stream.F1 r0 = new j$.util.stream.F1
            r2 = 1
            r1 = r0
            r6 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r7.y1(r0)
        L5b:
            j$.util.stream.k r8 = (j$.util.stream.C0206k) r8
            java.util.Set r0 = r8.b()
            j$.util.stream.j r2 = j$.util.stream.EnumC0202j.IDENTITY_FINISH
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L6a
            goto L72
        L6a:
            j$.util.function.Function r8 = r8.e()
            java.lang.Object r1 = r8.apply(r1)
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Y1.w(j$.util.stream.m):java.lang.Object");
    }
}
