package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.InterfaceC0123e0;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.h0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0195h0 extends AbstractC0207k0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0195h0(Spliterator spliterator, int i8) {
        super(spliterator, i8);
    }

    @Override // j$.util.stream.AbstractC0207k0, j$.util.stream.InterfaceC0219n0
    public final void F(InterfaceC0123e0 interfaceC0123e0) {
        j$.util.J P1;
        if (isParallel()) {
            super.F(interfaceC0123e0);
            return;
        }
        P1 = AbstractC0207k0.P1(L1());
        P1.a(interfaceC0123e0);
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

    @Override // j$.util.stream.AbstractC0171c, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* bridge */ /* synthetic */ InterfaceC0219n0 parallel() {
        parallel();
        return this;
    }

    @Override // j$.util.stream.AbstractC0171c, j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* bridge */ /* synthetic */ InterfaceC0219n0 sequential() {
        sequential();
        return this;
    }

    @Override // j$.util.stream.AbstractC0207k0, j$.util.stream.InterfaceC0219n0
    public final void z(InterfaceC0123e0 interfaceC0123e0) {
        j$.util.J P1;
        if (isParallel()) {
            super.z(interfaceC0123e0);
            return;
        }
        P1 = AbstractC0207k0.P1(L1());
        P1.a(interfaceC0123e0);
    }
}
