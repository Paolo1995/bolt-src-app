package j$.util;

import j$.util.function.C0130i;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class S implements InterfaceC0159q, InterfaceC0135l, Iterator {

    /* renamed from: a  reason: collision with root package name */
    boolean f50161a = false;

    /* renamed from: b  reason: collision with root package name */
    double f50162b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ D f50163c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(D d8) {
        this.f50163c = d8;
    }

    @Override // j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        this.f50161a = true;
        this.f50162b = d8;
    }

    @Override // j$.util.InterfaceC0275z
    /* renamed from: c */
    public final void forEachRemaining(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        while (hasNext()) {
            interfaceC0135l.accept(nextDouble());
        }
    }

    @Override // j$.util.InterfaceC0159q, j$.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof InterfaceC0135l) {
            forEachRemaining((InterfaceC0135l) consumer);
            return;
        }
        consumer.getClass();
        if (d0.f50257a) {
            d0.a(S.class, "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
            throw null;
        } else {
            forEachRemaining(new C0155m(consumer));
        }
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final boolean hasNext() {
        if (!this.f50161a) {
            this.f50163c.n(this);
        }
        return this.f50161a;
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0130i(this, interfaceC0135l);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final Double next() {
        if (d0.f50257a) {
            d0.a(S.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
            throw null;
        }
        return Double.valueOf(nextDouble());
    }

    @Override // j$.util.InterfaceC0159q
    public final double nextDouble() {
        if (this.f50161a || hasNext()) {
            this.f50161a = false;
            return this.f50162b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
