package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;

/* loaded from: classes2.dex */
final class I2 extends O2 implements j$.util.D {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ J2 f50424g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I2(J2 j22, int i8, int i9, int i10, int i11) {
        super(j22, i8, i9, i10, i11);
        this.f50424g = j22;
    }

    @Override // j$.util.stream.O2
    final void e(int i8, Object obj, Object obj2) {
        ((InterfaceC0135l) obj2).accept(((double[]) obj)[i8]);
    }

    @Override // j$.util.stream.O2
    final j$.util.M f(Object obj, int i8, int i9) {
        return Spliterators.j((double[]) obj, i8, i9 + i8);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.e(this, consumer);
    }

    @Override // j$.util.stream.O2
    final j$.util.M g(int i8, int i9, int i10, int i11) {
        return new I2(this.f50424g, i8, i9, i10, i11);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.h(this, consumer);
    }
}
