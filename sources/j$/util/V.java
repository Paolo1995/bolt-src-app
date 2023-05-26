package j$.util;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;

/* loaded from: classes2.dex */
final class V extends AbstractC0156n implements D {
    @Override // j$.util.D
    public final void c(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
    }

    @Override // j$.util.D, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.e(this, consumer);
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

    @Override // j$.util.D
    public final boolean n(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return false;
    }

    @Override // j$.util.D, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.h(this, consumer);
    }

    @Override // j$.util.AbstractC0156n, j$.util.D, j$.util.M, j$.util.Spliterator
    public final /* bridge */ /* synthetic */ D trySplit() {
        return null;
    }

    @Override // j$.util.AbstractC0156n, j$.util.D, j$.util.M, j$.util.Spliterator
    public final /* bridge */ /* synthetic */ M trySplit() {
        return null;
    }
}
