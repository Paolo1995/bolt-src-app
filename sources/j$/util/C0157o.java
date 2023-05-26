package j$.util;

import j$.util.function.C0122e;
import j$.util.function.C0134k;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;
import java.util.PrimitiveIterator;

/* renamed from: j$.util.o  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0157o implements InterfaceC0159q, Iterator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PrimitiveIterator.OfDouble f50361a;

    private /* synthetic */ C0157o(PrimitiveIterator.OfDouble ofDouble) {
        this.f50361a = ofDouble;
    }

    public static /* synthetic */ InterfaceC0159q d(PrimitiveIterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof C0158p ? ((C0158p) ofDouble).f50362a : new C0157o(ofDouble);
    }

    @Override // j$.util.InterfaceC0159q
    public final /* synthetic */ void c(InterfaceC0135l interfaceC0135l) {
        this.f50361a.forEachRemaining(C0134k.a(interfaceC0135l));
    }

    @Override // j$.util.InterfaceC0159q, j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f50361a.forEachRemaining(C0122e.a(consumer));
    }

    @Override // j$.util.InterfaceC0275z
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f50361a.forEachRemaining((PrimitiveIterator.OfDouble) obj);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f50361a.hasNext();
    }

    @Override // j$.util.InterfaceC0159q, java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ Double next() {
        return this.f50361a.next();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f50361a.next();
    }

    @Override // j$.util.InterfaceC0159q
    public final /* synthetic */ double nextDouble() {
        return this.f50361a.nextDouble();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ void remove() {
        this.f50361a.remove();
    }
}
