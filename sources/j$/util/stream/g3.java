package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Spliterator;
import j$.util.function.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g3 extends V2 implements j$.util.G {
    g3(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7) {
        super(abstractC0254w0, spliterator, z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g3(AbstractC0254w0 abstractC0254w0, C0161a c0161a, boolean z7) {
        super(abstractC0254w0, c0161a, z7);
    }

    @Override // j$.util.M
    /* renamed from: b */
    public final void forEachRemaining(j$.util.function.J j8) {
        if (this.f50523h != null || this.f50524i) {
            do {
            } while (tryAdvance(j8));
            return;
        }
        j8.getClass();
        g();
        this.f50517b.v1(this.f50519d, new f3(j8, 1));
        this.f50524i = true;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.f(this, consumer);
    }

    @Override // j$.util.stream.V2
    final void h() {
        L2 l22 = new L2();
        this.f50523h = l22;
        this.f50520e = this.f50517b.w1(new f3(l22, 0));
        this.f50521f = new C0161a(5, this);
    }

    @Override // j$.util.M
    /* renamed from: i */
    public final boolean tryAdvance(j$.util.function.J j8) {
        j8.getClass();
        boolean e8 = e();
        if (e8) {
            L2 l22 = (L2) this.f50523h;
            long j9 = this.f50522g;
            int t7 = l22.t(j9);
            j8.accept((l22.f50568c == 0 && t7 == 0) ? ((int[]) l22.f50463e)[(int) j9] : ((int[][]) l22.f50464f)[t7][(int) (j9 - l22.f50569d[t7])]);
        }
        return e8;
    }

    @Override // j$.util.stream.V2
    final V2 j(Spliterator spliterator) {
        return new g3(this.f50517b, spliterator, this.f50516a);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.j(this, consumer);
    }

    @Override // j$.util.stream.V2, j$.util.Spliterator
    public final j$.util.G trySplit() {
        return (j$.util.G) super.trySplit();
    }
}
