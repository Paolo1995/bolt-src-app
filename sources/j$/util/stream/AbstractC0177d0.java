package j$.util.stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.d0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0177d0 extends AbstractC0182e0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0177d0(AbstractC0171c abstractC0171c, int i8) {
        super(abstractC0171c, i8);
    }

    @Override // j$.util.stream.AbstractC0171c
    final boolean I1() {
        return false;
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
