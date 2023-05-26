package j$.util;

import j$.util.function.Consumer;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class P implements InterfaceC0270u, j$.util.function.J, Iterator {

    /* renamed from: a  reason: collision with root package name */
    boolean f50155a = false;

    /* renamed from: b  reason: collision with root package name */
    int f50156b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ G f50157c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(G g8) {
        this.f50157c = g8;
    }

    @Override // j$.util.function.J
    public final void accept(int i8) {
        this.f50155a = true;
        this.f50156b = i8;
    }

    @Override // j$.util.InterfaceC0275z
    /* renamed from: b */
    public final void forEachRemaining(j$.util.function.J j8) {
        j8.getClass();
        while (hasNext()) {
            j8.accept(nextInt());
        }
    }

    @Override // j$.util.InterfaceC0270u, j$.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof j$.util.function.J) {
            forEachRemaining((j$.util.function.J) consumer);
            return;
        }
        consumer.getClass();
        if (d0.f50257a) {
            d0.a(P.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
            throw null;
        } else {
            forEachRemaining(new r(consumer));
        }
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final boolean hasNext() {
        if (!this.f50155a) {
            this.f50157c.i(this);
        }
        return this.f50155a;
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final Integer next() {
        if (d0.f50257a) {
            d0.a(P.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
            throw null;
        }
        return Integer.valueOf(nextInt());
    }

    @Override // j$.util.InterfaceC0270u
    public final int nextInt() {
        if (this.f50155a || hasNext()) {
            this.f50155a = false;
            return this.f50156b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
