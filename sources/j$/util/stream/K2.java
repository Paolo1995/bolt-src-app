package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Spliterators;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class K2 extends O2 implements j$.util.G {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ L2 f50435g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K2(L2 l22, int i8, int i9, int i10, int i11) {
        super(l22, i8, i9, i10, i11);
        this.f50435g = l22;
    }

    @Override // j$.util.stream.O2
    final void e(int i8, Object obj, Object obj2) {
        ((j$.util.function.J) obj2).accept(((int[]) obj)[i8]);
    }

    @Override // j$.util.stream.O2
    final j$.util.M f(Object obj, int i8, int i9) {
        return Spliterators.k((int[]) obj, i8, i9 + i8);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.f(this, consumer);
    }

    @Override // j$.util.stream.O2
    final j$.util.M g(int i8, int i9, int i10, int i11) {
        return new K2(this.f50435g, i8, i9, i10, i11);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.j(this, consumer);
    }
}
