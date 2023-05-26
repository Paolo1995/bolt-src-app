package j$.util.stream;

/* renamed from: j$.util.stream.i0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0199i0 extends AbstractC0207k0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0199i0(AbstractC0171c abstractC0171c, int i8) {
        super(abstractC0171c, i8);
    }

    @Override // j$.util.stream.AbstractC0171c
    final boolean I1() {
        return true;
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
}
