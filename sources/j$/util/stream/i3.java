package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i3 extends V2 implements j$.util.J {
    i3(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7) {
        super(abstractC0254w0, spliterator, z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i3(AbstractC0254w0 abstractC0254w0, C0161a c0161a, boolean z7) {
        super(abstractC0254w0, c0161a, z7);
    }

    @Override // j$.util.M
    /* renamed from: a */
    public final void forEachRemaining(InterfaceC0123e0 interfaceC0123e0) {
        if (this.f50523h != null || this.f50524i) {
            do {
            } while (tryAdvance(interfaceC0123e0));
            return;
        }
        interfaceC0123e0.getClass();
        g();
        this.f50517b.v1(this.f50519d, new h3(interfaceC0123e0, 1));
        this.f50524i = true;
    }

    @Override // j$.util.M
    /* renamed from: d */
    public final boolean tryAdvance(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        boolean e8 = e();
        if (e8) {
            N2 n22 = (N2) this.f50523h;
            long j8 = this.f50522g;
            int t7 = n22.t(j8);
            interfaceC0123e0.accept((n22.f50568c == 0 && t7 == 0) ? ((long[]) n22.f50463e)[(int) j8] : ((long[][]) n22.f50464f)[t7][(int) (j8 - n22.f50569d[t7])]);
        }
        return e8;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.g(this, consumer);
    }

    @Override // j$.util.stream.V2
    final void h() {
        N2 n22 = new N2();
        this.f50523h = n22;
        this.f50520e = this.f50517b.w1(new h3(n22, 0));
        this.f50521f = new C0161a(6, this);
    }

    @Override // j$.util.stream.V2
    final V2 j(Spliterator spliterator) {
        return new i3(this.f50517b, spliterator, this.f50516a);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.k(this, consumer);
    }

    @Override // j$.util.stream.V2, j$.util.Spliterator
    public final j$.util.J trySplit() {
        return (j$.util.J) super.trySplit();
    }
}
