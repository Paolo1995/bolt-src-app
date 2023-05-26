package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Spliterator;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class t3 extends v3 implements j$.util.G, j$.util.function.J {

    /* renamed from: e  reason: collision with root package name */
    int f50680e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t3(j$.util.G g8, long j8, long j9) {
        super(g8, j8, j9);
    }

    t3(j$.util.G g8, t3 t3Var) {
        super(g8, t3Var);
    }

    @Override // j$.util.function.J
    public final void accept(int i8) {
        this.f50680e = i8;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.f(this, consumer);
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }

    @Override // j$.util.stream.x3
    protected final Spliterator q(Spliterator spliterator) {
        return new t3((j$.util.G) spliterator, this);
    }

    @Override // j$.util.stream.v3
    protected final void s(Object obj) {
        ((j$.util.function.J) obj).accept(this.f50680e);
    }

    @Override // j$.util.stream.v3
    protected final Z2 t() {
        return new X2();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.j(this, consumer);
    }
}
