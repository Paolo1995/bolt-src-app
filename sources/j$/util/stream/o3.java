package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Spliterator;
import j$.util.function.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o3 extends p3 implements j$.util.J {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o3(j$.util.J j8, long j9, long j10) {
        super(j8, j9, j10);
    }

    o3(j$.util.J j8, long j9, long j10, long j11, long j12) {
        super(j8, j9, j10, j11, j12);
    }

    @Override // j$.util.stream.r3
    protected final Spliterator e(Spliterator spliterator, long j8, long j9, long j10, long j11) {
        return new o3((j$.util.J) spliterator, j8, j9, j10, j11);
    }

    @Override // j$.util.stream.p3
    protected final Object f() {
        return new n3(0);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.g(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.k(this, consumer);
    }
}
