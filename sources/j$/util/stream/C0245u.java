package j$.util.stream;

import j$.util.function.C0139p;
import j$.util.function.C0141s;
import j$.util.function.C0147y;
import j$.util.function.InterfaceC0135l;
import j$.util.function.InterfaceC0138o;
import j$.util.function.InterfaceC0143u;
import j$.util.function.InterfaceC0146x;

/* renamed from: j$.util.stream.u  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0245u extends Z1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f50681b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AbstractC0171c f50682c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0245u(AbstractC0171c abstractC0171c, InterfaceC0193g2 interfaceC0193g2, int i8) {
        super(interfaceC0193g2);
        this.f50681b = i8;
        this.f50682c = abstractC0171c;
    }

    @Override // j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        switch (this.f50681b) {
            case 0:
                this.f50535a.accept(((C0147y) ((j$.util.function.A) ((C0249v) this.f50682c).f50691u)).b(d8));
                return;
            case 1:
                this.f50535a.accept((InterfaceC0193g2) ((InterfaceC0138o) ((C0253w) this.f50682c).f50697u).apply(d8));
                return;
            case 2:
                this.f50535a.accept(((C0141s) ((InterfaceC0143u) ((C0257x) this.f50682c).f50712u)).a(d8));
                return;
            case 3:
                this.f50535a.accept(((InterfaceC0146x) ((C0261y) this.f50682c).f50722u).applyAsLong(d8));
                return;
            case 4:
                G g8 = (G) ((InterfaceC0138o) ((C0249v) this.f50682c).f50691u).apply(d8);
                if (g8 != null) {
                    try {
                        g8.sequential().I(new C0241t(1, this));
                    } catch (Throwable th) {
                        try {
                            g8.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (g8 != null) {
                    g8.close();
                    return;
                }
                return;
            case 5:
                if (((C0139p) ((j$.util.function.r) ((C0249v) this.f50682c).f50691u)).e(d8)) {
                    this.f50535a.accept(d8);
                    return;
                }
                return;
            default:
                ((InterfaceC0135l) ((C0249v) this.f50682c).f50691u).accept(d8);
                this.f50535a.accept(d8);
                return;
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        switch (this.f50681b) {
            case 4:
                this.f50535a.e(-1L);
                return;
            case 5:
                this.f50535a.e(-1L);
                return;
            default:
                this.f50535a.e(j8);
                return;
        }
    }
}
