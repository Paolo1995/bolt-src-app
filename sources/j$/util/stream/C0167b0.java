package j$.util.stream;

import j$.util.Spliterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.b0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0167b0 extends AbstractC0182e0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0167b0(Spliterator spliterator, int i8) {
        super(spliterator, i8);
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

    @Override // j$.util.stream.AbstractC0182e0, j$.util.stream.IntStream
    public final void R(j$.util.function.J j8) {
        j$.util.G P1;
        if (isParallel()) {
            super.R(j8);
            return;
        }
        P1 = AbstractC0182e0.P1(L1());
        P1.b(j8);
    }

    @Override // j$.util.stream.AbstractC0182e0, j$.util.stream.IntStream
    public final void Z(j$.util.function.J j8) {
        j$.util.G P1;
        if (isParallel()) {
            super.Z(j8);
            return;
        }
        P1 = AbstractC0182e0.P1(L1());
        P1.b(j8);
    }

    @Override // j$.util.stream.AbstractC0171c, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* bridge */ /* synthetic */ IntStream parallel() {
        parallel();
        return this;
    }

    @Override // j$.util.stream.AbstractC0171c, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* bridge */ /* synthetic */ IntStream sequential() {
        sequential();
        return this;
    }
}
