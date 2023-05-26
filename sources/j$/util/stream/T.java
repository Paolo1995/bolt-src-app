package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
abstract class T implements B3, C3 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f50478a;

    /* JADX INFO: Access modifiers changed from: protected */
    public T(boolean z7) {
        this.f50478a = z7;
    }

    @Override // j$.util.stream.B3
    public final int O() {
        if (this.f50478a) {
            return 0;
        }
        return U2.f50502r;
    }

    public /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
    }

    public /* synthetic */ void accept(int i8) {
        AbstractC0254w0.v0();
        throw null;
    }

    public /* synthetic */ void accept(long j8) {
        AbstractC0254w0.w0();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void e(long j8) {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.function.Supplier
    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // j$.util.stream.B3
    public final Object m0(AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        abstractC0254w0.v1(spliterator, this);
        return null;
    }

    @Override // j$.util.stream.B3
    public final Object y(AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        (this.f50478a ? new U(abstractC0254w0, spliterator, this) : new V(abstractC0254w0, spliterator, abstractC0254w0.w1(this))).invoke();
        return null;
    }
}
