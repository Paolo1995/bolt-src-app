package j$.util;

import j$.util.function.C0117b0;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class Q implements InterfaceC0274y, InterfaceC0123e0, Iterator {

    /* renamed from: a  reason: collision with root package name */
    boolean f50158a = false;

    /* renamed from: b  reason: collision with root package name */
    long f50159b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ J f50160c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(J j8) {
        this.f50160c = j8;
    }

    @Override // j$.util.InterfaceC0275z
    /* renamed from: a */
    public final void forEachRemaining(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        while (hasNext()) {
            interfaceC0123e0.accept(nextLong());
        }
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final void accept(long j8) {
        this.f50158a = true;
        this.f50159b = j8;
    }

    @Override // j$.util.InterfaceC0274y, j$.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof InterfaceC0123e0) {
            forEachRemaining((InterfaceC0123e0) consumer);
            return;
        }
        consumer.getClass();
        if (d0.f50257a) {
            d0.a(Q.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
            throw null;
        } else {
            forEachRemaining(new C0271v(consumer));
        }
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final boolean hasNext() {
        if (!this.f50158a) {
            this.f50160c.d(this);
        }
        return this.f50158a;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final Long next() {
        if (d0.f50257a) {
            d0.a(Q.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
            throw null;
        }
        return Long.valueOf(nextLong());
    }

    @Override // j$.util.InterfaceC0274y
    public final long nextLong() {
        if (this.f50158a || hasNext()) {
            this.f50158a = false;
            return this.f50159b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
