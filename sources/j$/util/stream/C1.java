package j$.util.stream;

import j$.util.function.C0130i;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0120d;
import j$.util.function.InterfaceC0135l;
import j$.util.function.Supplier;

/* loaded from: classes2.dex */
final class C1 extends Q1 implements P1, InterfaceC0179d2 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Supplier f50374b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j$.util.function.w0 f50375c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ InterfaceC0120d f50376d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1(Supplier supplier, j$.util.function.w0 w0Var, InterfaceC0120d interfaceC0120d) {
        this.f50374b = supplier;
        this.f50375c = w0Var;
        this.f50376d = interfaceC0120d;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        this.f50375c.accept(this.f50466a, d8);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(int i8) {
        AbstractC0254w0.v0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(long j8) {
        AbstractC0254w0.w0();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Double) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50466a = this.f50374b.get();
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.stream.P1
    public final void j(P1 p12) {
        this.f50466a = this.f50376d.apply(this.f50466a, ((C1) p12).f50466a);
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0130i(this, interfaceC0135l);
    }

    @Override // j$.util.stream.InterfaceC0179d2
    public final /* synthetic */ void o(Double d8) {
        AbstractC0254w0.p0(this, d8);
    }
}
