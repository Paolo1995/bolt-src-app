package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Spliterator;
import j$.util.function.C0130i;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;

/* loaded from: classes2.dex */
final class s3 extends v3 implements j$.util.D, InterfaceC0135l {

    /* renamed from: e  reason: collision with root package name */
    double f50673e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s3(j$.util.D d8, long j8, long j9) {
        super(d8, j8, j9);
    }

    s3(j$.util.D d8, s3 s3Var) {
        super(d8, s3Var);
    }

    @Override // j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        this.f50673e = d8;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.e(this, consumer);
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0130i(this, interfaceC0135l);
    }

    @Override // j$.util.stream.x3
    protected final Spliterator q(Spliterator spliterator) {
        return new s3((j$.util.D) spliterator, this);
    }

    @Override // j$.util.stream.v3
    protected final void s(Object obj) {
        ((InterfaceC0135l) obj).accept(this.f50673e);
    }

    @Override // j$.util.stream.v3
    protected final Z2 t() {
        return new W2();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.h(this, consumer);
    }
}
