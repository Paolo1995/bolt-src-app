package j$.util;

import j$.util.Spliterator;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class W extends AbstractC0156n implements G {
    @Override // j$.util.G
    public final void b(j$.util.function.J j8) {
        j8.getClass();
    }

    @Override // j$.util.G, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.f(this, consumer);
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

    @Override // j$.util.G
    public final boolean i(j$.util.function.J j8) {
        j8.getClass();
        return false;
    }

    @Override // j$.util.G, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.j(this, consumer);
    }

    @Override // j$.util.AbstractC0156n, j$.util.D, j$.util.M, j$.util.Spliterator
    public final /* bridge */ /* synthetic */ G trySplit() {
        return null;
    }

    @Override // j$.util.AbstractC0156n, j$.util.D, j$.util.M, j$.util.Spliterator
    public final /* bridge */ /* synthetic */ M trySplit() {
        return null;
    }
}
