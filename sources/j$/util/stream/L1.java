package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.InterfaceC0120d;
import j$.util.function.Supplier;

/* loaded from: classes2.dex */
final class L1 extends Q1 implements P1, InterfaceC0184e2 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Supplier f50437b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j$.util.function.z0 f50438c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ InterfaceC0120d f50439d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L1(Supplier supplier, j$.util.function.z0 z0Var, InterfaceC0120d interfaceC0120d) {
        this.f50437b = supplier;
        this.f50438c = z0Var;
        this.f50439d = interfaceC0120d;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        this.f50438c.accept(this.f50466a, i8);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(long j8) {
        AbstractC0254w0.w0();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        f((Integer) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50466a = this.f50437b.get();
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.InterfaceC0184e2
    public final /* synthetic */ void f(Integer num) {
        AbstractC0254w0.r0(this, num);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.stream.P1
    public final void j(P1 p12) {
        this.f50466a = this.f50439d.apply(this.f50466a, ((L1) p12).f50466a);
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }
}
