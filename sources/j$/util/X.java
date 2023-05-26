package j$.util;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;

/* loaded from: classes2.dex */
final class X extends AbstractC0156n implements J {
    @Override // j$.util.J
    public final void a(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
    }

    @Override // j$.util.J
    public final boolean d(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return false;
    }

    @Override // j$.util.J, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.g(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ java.util.Comparator getComparator() {
        return Spliterator.CC.$default$getComparator(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return Spliterator.CC.a(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i8) {
        return Spliterator.CC.$default$hasCharacteristics(this, i8);
    }

    @Override // j$.util.J, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.k(this, consumer);
    }

    @Override // j$.util.AbstractC0156n, j$.util.D, j$.util.M, j$.util.Spliterator
    public final /* bridge */ /* synthetic */ J trySplit() {
        return null;
    }

    @Override // j$.util.AbstractC0156n, j$.util.D, j$.util.M, j$.util.Spliterator
    public final /* bridge */ /* synthetic */ M trySplit() {
        return null;
    }
}
