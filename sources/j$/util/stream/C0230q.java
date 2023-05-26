package j$.util.stream;

import j$.util.function.Function;
import j$.util.function.InterfaceC0123e0;
import j$.util.function.InterfaceC0135l;
import java.util.HashSet;
import java.util.Set;

/* renamed from: j$.util.stream.q  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0230q extends AbstractC0174c2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f50641b = 0;

    /* renamed from: c  reason: collision with root package name */
    Object f50642c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AbstractC0171c f50643d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0230q(r rVar, InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
        this.f50643d = rVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0230q(C0249v c0249v, InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
        this.f50643d = c0249v;
        this.f50642c = new C0241t(0, interfaceC0193g2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0230q(C0257x c0257x, InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
        this.f50643d = c0257x;
        this.f50642c = new W(0, interfaceC0193g2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0230q(C0261y c0261y, InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
        this.f50643d = c0261y;
        this.f50642c = new C0187f0(0, interfaceC0193g2);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f50641b) {
            case 0:
                if (((Set) this.f50642c).contains(obj)) {
                    return;
                }
                ((Set) this.f50642c).add(obj);
                this.f50557a.accept((InterfaceC0193g2) obj);
                return;
            case 1:
                InterfaceC0219n0 interfaceC0219n0 = (InterfaceC0219n0) ((Function) ((C0261y) this.f50643d).f50722u).apply(obj);
                if (interfaceC0219n0 != null) {
                    try {
                        interfaceC0219n0.sequential().F((InterfaceC0123e0) this.f50642c);
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
            case 2:
                IntStream intStream = (IntStream) ((Function) ((C0257x) this.f50643d).f50712u).apply(obj);
                if (intStream != null) {
                    try {
                        intStream.sequential().Z((j$.util.function.J) this.f50642c);
                    } catch (Throwable th3) {
                        try {
                            intStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                }
                if (intStream != null) {
                    intStream.close();
                    return;
                }
                return;
            default:
                G g8 = (G) ((Function) ((C0249v) this.f50643d).f50691u).apply(obj);
                if (g8 != null) {
                    try {
                        g8.sequential().I((InterfaceC0135l) this.f50642c);
                    } catch (Throwable th5) {
                        try {
                            g8.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
                if (g8 != null) {
                    g8.close();
                    return;
                }
                return;
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        switch (this.f50641b) {
            case 0:
                this.f50642c = new HashSet();
                this.f50557a.e(-1L);
                return;
            case 1:
                this.f50557a.e(-1L);
                return;
            case 2:
                this.f50557a.e(-1L);
                return;
            default:
                this.f50557a.e(-1L);
                return;
        }
    }

    @Override // j$.util.stream.AbstractC0174c2, j$.util.stream.InterfaceC0193g2
    public final void end() {
        switch (this.f50641b) {
            case 0:
                this.f50642c = null;
                this.f50557a.end();
                return;
            default:
                super.end();
                return;
        }
    }
}
