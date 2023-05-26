package j$.util;

import j$.util.function.C0122e;
import j$.util.function.Consumer;
import java.util.PrimitiveIterator;

/* renamed from: j$.util.s */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0160s implements InterfaceC0270u, Iterator {

    /* renamed from: a */
    final /* synthetic */ PrimitiveIterator.OfInt f50364a;

    private /* synthetic */ C0160s(PrimitiveIterator.OfInt ofInt) {
        this.f50364a = ofInt;
    }

    public static /* synthetic */ InterfaceC0270u d(PrimitiveIterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof C0269t ? ((C0269t) ofInt).f50731a : new C0160s(ofInt);
    }

    @Override // j$.util.InterfaceC0270u
    public final /* synthetic */ void b(j$.util.function.J j8) {
        this.f50364a.forEachRemaining(j$.util.function.I.a(j8));
    }

    @Override // j$.util.InterfaceC0270u, j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f50364a.forEachRemaining(C0122e.a(consumer));
    }

    @Override // j$.util.InterfaceC0275z
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f50364a.forEachRemaining((PrimitiveIterator.OfInt) obj);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f50364a.hasNext();
    }

    @Override // j$.util.InterfaceC0270u, java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ Integer next() {
        return this.f50364a.next();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f50364a.next();
    }

    @Override // j$.util.InterfaceC0270u
    public final /* synthetic */ int nextInt() {
        return this.f50364a.nextInt();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ void remove() {
        this.f50364a.remove();
    }
}
