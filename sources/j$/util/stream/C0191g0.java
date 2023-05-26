package j$.util.stream;

import j$.util.function.C0131i0;
import j$.util.function.InterfaceC0123e0;
import j$.util.function.InterfaceC0129h0;
import j$.util.function.LongUnaryOperator;

/* renamed from: j$.util.stream.g0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0191g0 extends AbstractC0169b2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f50583b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AbstractC0171c f50584c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0191g0(AbstractC0171c abstractC0171c, InterfaceC0193g2 interfaceC0193g2, int i8) {
        super(interfaceC0193g2);
        this.f50583b = i8;
        this.f50584c = abstractC0171c;
    }

    @Override // j$.util.stream.InterfaceC0189f2, j$.util.stream.InterfaceC0193g2
    public final void accept(long j8) {
        switch (this.f50583b) {
            case 0:
                this.f50544a.accept(j8);
                return;
            case 1:
                this.f50544a.accept(((LongUnaryOperator) ((C0261y) this.f50584c).f50722u).applyAsLong(j8));
                return;
            case 2:
                this.f50544a.accept((InterfaceC0193g2) ((InterfaceC0129h0) ((C0253w) this.f50584c).f50697u).apply(j8));
                return;
            case 3:
                this.f50544a.accept(((j$.util.function.o0) ((j$.util.function.q0) ((C0257x) this.f50584c).f50712u)).a(j8));
                return;
            case 4:
                this.f50544a.accept(((j$.util.function.l0) ((j$.util.function.n0) ((C0249v) this.f50584c).f50691u)).a(j8));
                return;
            case 5:
                InterfaceC0219n0 interfaceC0219n0 = (InterfaceC0219n0) ((InterfaceC0129h0) ((C0261y) this.f50584c).f50722u).apply(j8);
                if (interfaceC0219n0 != null) {
                    try {
                        interfaceC0219n0.sequential().F(new C0187f0(1, this));
                    } catch (Throwable th) {
                        try {
                            interfaceC0219n0.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (interfaceC0219n0 != null) {
                    interfaceC0219n0.close();
                    return;
                }
                return;
            case 6:
                if (((C0131i0) ((j$.util.function.k0) ((C0261y) this.f50584c).f50722u)).e(j8)) {
                    this.f50544a.accept(j8);
                    return;
                }
                return;
            default:
                ((InterfaceC0123e0) ((C0261y) this.f50584c).f50722u).accept(j8);
                this.f50544a.accept(j8);
                return;
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        switch (this.f50583b) {
            case 5:
                this.f50544a.e(-1L);
                return;
            case 6:
                this.f50544a.e(-1L);
                return;
            default:
                this.f50544a.e(j8);
                return;
        }
    }
}
