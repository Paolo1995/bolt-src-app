package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class V1 extends Y1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public V1(Spliterator spliterator, int i8, boolean z7) {
        super(spliterator, i8, z7);
    }

    @Override // j$.util.stream.Y1, j$.util.stream.Stream
    public final void G(Consumer consumer) {
        if (isParallel()) {
            super.G(consumer);
        } else {
            L1().forEachRemaining(consumer);
        }
    }

    @Override // j$.util.stream.AbstractC0171c
    final boolean I1() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2) {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.stream.Y1, j$.util.stream.Stream
    public final void forEach(Consumer consumer) {
        if (isParallel()) {
            super.forEach(consumer);
        } else {
            L1().forEachRemaining(consumer);
        }
    }
}
