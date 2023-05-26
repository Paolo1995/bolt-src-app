package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Spliterator;
import j$.util.function.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m3 extends p3 implements j$.util.G {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m3(j$.util.G g8, long j8, long j9) {
        super(g8, j8, j9);
    }

    m3(j$.util.G g8, long j8, long j9, long j10, long j11) {
        super(g8, j8, j9, j10, j11);
    }

    @Override // j$.util.stream.r3
    protected final Spliterator e(Spliterator spliterator, long j8, long j9, long j10, long j11) {
        return new m3((j$.util.G) spliterator, j8, j9, j10, j11);
    }

    @Override // j$.util.stream.p3
    protected final Object f() {
        return new l3(0);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.f(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.j(this, consumer);
    }
}
