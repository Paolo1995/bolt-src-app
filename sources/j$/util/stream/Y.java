package j$.util.stream;

import j$.util.function.IntFunction;

/* loaded from: classes2.dex */
final class Y extends AbstractC0164a2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f50530b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AbstractC0171c f50531c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Y(AbstractC0171c abstractC0171c, InterfaceC0193g2 interfaceC0193g2, int i8) {
        super(interfaceC0193g2);
        this.f50530b = i8;
        this.f50531c = abstractC0171c;
    }

    @Override // j$.util.stream.InterfaceC0184e2, j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        switch (this.f50530b) {
            case 0:
                this.f50539a.accept(i8);
                return;
            case 1:
                ((j$.util.function.J) ((C0257x) this.f50531c).f50712u).accept(i8);
                this.f50539a.accept(i8);
                return;
            case 2:
                this.f50539a.accept(i8);
                return;
            case 3:
                this.f50539a.accept(((j$.util.function.V) ((j$.util.function.X) ((C0257x) this.f50531c).f50712u)).b(i8));
                return;
            case 4:
                this.f50539a.accept((InterfaceC0193g2) ((IntFunction) ((C0253w) this.f50531c).f50697u).apply(i8));
                return;
            case 5:
                this.f50539a.accept(((j$.util.function.U) ((C0261y) this.f50531c).f50722u).applyAsLong(i8));
                return;
            case 6:
                this.f50539a.accept(((j$.util.function.O) ((j$.util.function.Q) ((C0249v) this.f50531c).f50691u)).a(i8));
                return;
            case 7:
                IntStream intStream = (IntStream) ((IntFunction) ((C0257x) this.f50531c).f50712u).apply(i8);
                if (intStream != null) {
                    try {
                        intStream.sequential().Z(new W(1, this));
                    } catch (Throwable th) {
                        try {
                            intStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (intStream != null) {
                    intStream.close();
                    return;
                }
                return;
            default:
                if (((j$.util.function.L) ((j$.util.function.N) ((C0257x) this.f50531c).f50712u)).e(i8)) {
                    this.f50539a.accept(i8);
                    return;
                }
                return;
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        switch (this.f50530b) {
            case 7:
                this.f50539a.e(-1L);
                return;
            case 8:
                this.f50539a.e(-1L);
                return;
            default:
                this.f50539a.e(j8);
                return;
        }
    }
}
