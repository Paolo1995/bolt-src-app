package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.function.Consumer;

/* renamed from: j$.util.stream.g1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0192g1 extends AbstractC0196h1 implements j$.util.J {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0192g1(D0 d02) {
        super(d02);
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
