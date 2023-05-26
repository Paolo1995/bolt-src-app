package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.function.Consumer;

/* renamed from: j$.util.stream.e1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0183e1 extends AbstractC0196h1 implements j$.util.D {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0183e1(B0 b02) {
        super(b02);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.e(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.h(this, consumer);
    }
}
