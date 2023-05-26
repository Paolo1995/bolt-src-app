package j$.util;

import j$.util.function.C0121d0;
import j$.util.function.C0122e;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;
import java.util.PrimitiveIterator;

/* renamed from: j$.util.w  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0272w implements InterfaceC0274y, Iterator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PrimitiveIterator.OfLong f50733a;

    private /* synthetic */ C0272w(PrimitiveIterator.OfLong ofLong) {
        this.f50733a = ofLong;
    }

    public static /* synthetic */ InterfaceC0274y d(PrimitiveIterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof C0273x ? ((C0273x) ofLong).f50734a : new C0272w(ofLong);
    }

    @Override // j$.util.InterfaceC0274y
    public final /* synthetic */ void a(InterfaceC0123e0 interfaceC0123e0) {
        this.f50733a.forEachRemaining(C0121d0.a(interfaceC0123e0));
    }

    @Override // j$.util.InterfaceC0274y, j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f50733a.forEachRemaining(C0122e.a(consumer));
    }

    @Override // j$.util.InterfaceC0275z
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f50733a.forEachRemaining((PrimitiveIterator.OfLong) obj);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f50733a.hasNext();
    }

    @Override // j$.util.InterfaceC0274y, java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ Long next() {
        return this.f50733a.next();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f50733a.next();
    }

    @Override // j$.util.InterfaceC0274y
    public final /* synthetic */ long nextLong() {
        return this.f50733a.nextLong();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final /* synthetic */ void remove() {
        this.f50733a.remove();
    }
}
