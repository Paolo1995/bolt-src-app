package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Spliterator;
import j$.util.function.C0117b0;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;

/* loaded from: classes2.dex */
final class u3 extends v3 implements j$.util.J, InterfaceC0123e0 {

    /* renamed from: e  reason: collision with root package name */
    long f50689e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u3(j$.util.J j8, long j9, long j10) {
        super(j8, j9, j10);
    }

    u3(j$.util.J j8, u3 u3Var) {
        super(j8, u3Var);
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final void accept(long j8) {
        this.f50689e = j8;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.g(this, consumer);
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }

    @Override // j$.util.stream.x3
    protected final Spliterator q(Spliterator spliterator) {
        return new u3((j$.util.J) spliterator, this);
    }

    @Override // j$.util.stream.v3
    protected final void s(Object obj) {
        ((InterfaceC0123e0) obj).accept(this.f50689e);
    }

    @Override // j$.util.stream.v3
    protected final Z2 t() {
        return new Y2();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.k(this, consumer);
    }
}
