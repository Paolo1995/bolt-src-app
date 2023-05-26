package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;

/* loaded from: classes2.dex */
final class S1 extends AbstractC0174c2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f50474b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AbstractC0171c f50475c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ S1(AbstractC0171c abstractC0171c, InterfaceC0193g2 interfaceC0193g2, int i8) {
        super(interfaceC0193g2);
        this.f50474b = i8;
        this.f50475c = abstractC0171c;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f50474b) {
            case 0:
                ((Consumer) ((C0253w) this.f50475c).f50697u).accept(obj);
                this.f50557a.accept((InterfaceC0193g2) obj);
                return;
            case 1:
                if (((Predicate) ((C0253w) this.f50475c).f50697u).test(obj)) {
                    this.f50557a.accept((InterfaceC0193g2) obj);
                    return;
                }
                return;
            case 2:
                this.f50557a.accept((InterfaceC0193g2) ((U1) this.f50475c).f50489u.apply(obj));
                return;
            case 3:
                this.f50557a.accept(((ToIntFunction) ((C0257x) this.f50475c).f50712u).applyAsInt(obj));
                return;
            case 4:
                this.f50557a.accept(((ToLongFunction) ((C0261y) this.f50475c).f50722u).applyAsLong(obj));
                return;
            case 5:
                this.f50557a.accept(((ToDoubleFunction) ((C0249v) this.f50475c).f50691u).applyAsDouble(obj));
                return;
            default:
                Stream stream = (Stream) ((U1) this.f50475c).f50489u.apply(obj);
                if (stream != null) {
                    try {
                        ((Stream) stream.sequential()).forEach(this.f50557a);
                    } catch (Throwable th) {
                        try {
                            stream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (stream != null) {
                    stream.close();
                    return;
                }
                return;
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        switch (this.f50474b) {
            case 1:
                this.f50557a.e(-1L);
                return;
            case 6:
                this.f50557a.e(-1L);
                return;
            default:
                this.f50557a.e(j8);
                return;
        }
    }
}
