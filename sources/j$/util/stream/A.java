package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.InterfaceC0135l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class A extends D {
    /* JADX INFO: Access modifiers changed from: package-private */
    public A(Spliterator spliterator, int i8) {
        super(spliterator, i8);
    }

    @Override // j$.util.stream.D, j$.util.stream.G
    public final void I(InterfaceC0135l interfaceC0135l) {
        j$.util.D P1;
        if (isParallel()) {
            super.I(interfaceC0135l);
            return;
        }
        P1 = D.P1(L1());
        P1.c(interfaceC0135l);
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

    @Override // j$.util.stream.D, j$.util.stream.G
    public final void l0(InterfaceC0135l interfaceC0135l) {
        j$.util.D P1;
        if (isParallel()) {
            super.l0(interfaceC0135l);
            return;
        }
        P1 = D.P1(L1());
        P1.c(interfaceC0135l);
    }

    @Override // j$.util.stream.AbstractC0171c, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* bridge */ /* synthetic */ G parallel() {
        parallel();
        return this;
    }

    @Override // j$.util.stream.AbstractC0171c, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* bridge */ /* synthetic */ G sequential() {
        sequential();
        return this;
    }
}
