package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.e3  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0185e3 extends V2 implements j$.util.D {
    C0185e3(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7) {
        super(abstractC0254w0, spliterator, z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0185e3(AbstractC0254w0 abstractC0254w0, C0161a c0161a, boolean z7) {
        super(abstractC0254w0, c0161a, z7);
    }

    @Override // j$.util.M
    /* renamed from: c */
    public final void forEachRemaining(InterfaceC0135l interfaceC0135l) {
        if (this.f50523h != null || this.f50524i) {
            do {
            } while (tryAdvance(interfaceC0135l));
            return;
        }
        interfaceC0135l.getClass();
        g();
        this.f50517b.v1(this.f50519d, new C0180d3(interfaceC0135l, 1));
        this.f50524i = true;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.e(this, consumer);
    }

    @Override // j$.util.stream.V2
    final void h() {
        J2 j22 = new J2();
        this.f50523h = j22;
        this.f50520e = this.f50517b.w1(new C0180d3(j22, 0));
        this.f50521f = new C0161a(4, this);
    }

    @Override // j$.util.stream.V2
    final V2 j(Spliterator spliterator) {
        return new C0185e3(this.f50517b, spliterator, this.f50516a);
    }

    @Override // j$.util.M
    /* renamed from: n */
    public final boolean tryAdvance(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        boolean e8 = e();
        if (e8) {
            J2 j22 = (J2) this.f50523h;
            long j8 = this.f50522g;
            int t7 = j22.t(j8);
            interfaceC0135l.accept((j22.f50568c == 0 && t7 == 0) ? ((double[]) j22.f50463e)[(int) j8] : ((double[][]) j22.f50464f)[t7][(int) (j8 - j22.f50569d[t7])]);
        }
        return e8;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.h(this, consumer);
    }

    @Override // j$.util.stream.V2, j$.util.Spliterator
    public final j$.util.D trySplit() {
        return (j$.util.D) super.trySplit();
    }
}
