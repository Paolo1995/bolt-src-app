package j$.util.stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class C extends D {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C(AbstractC0171c abstractC0171c, int i8) {
        super(abstractC0171c, i8);
    }

    @Override // j$.util.stream.AbstractC0171c
    final boolean I1() {
        return false;
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
