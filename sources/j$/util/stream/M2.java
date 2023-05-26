package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;

/* loaded from: classes2.dex */
final class M2 extends O2 implements j$.util.J {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ N2 f50447g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M2(N2 n22, int i8, int i9, int i10, int i11) {
        super(n22, i8, i9, i10, i11);
        this.f50447g = n22;
    }

    @Override // j$.util.stream.O2
    final void e(int i8, Object obj, Object obj2) {
        ((InterfaceC0123e0) obj2).accept(((long[]) obj)[i8]);
    }

    @Override // j$.util.stream.O2
    final j$.util.M f(Object obj, int i8, int i9) {
        return Spliterators.l((long[]) obj, i8, i9 + i8);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.g(this, consumer);
    }

    @Override // j$.util.stream.O2
    final j$.util.M g(int i8, int i9, int i10, int i11) {
        return new M2(this.f50447g, i8, i9, i10, i11);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.k(this, consumer);
    }
}
