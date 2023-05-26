package j$.util.stream;

import j$.util.function.C0130i;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0128h;
import j$.util.function.InterfaceC0135l;

/* renamed from: j$.util.stream.z1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0267z1 implements P1, InterfaceC0179d2 {

    /* renamed from: a  reason: collision with root package name */
    private double f50728a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ double f50729b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ InterfaceC0128h f50730c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0267z1(double d8, InterfaceC0128h interfaceC0128h) {
        this.f50729b = d8;
        this.f50730c = interfaceC0128h;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        this.f50728a = this.f50730c.applyAsDouble(this.f50728a, d8);
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
        this.f50728a = this.f50729b;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        return Double.valueOf(this.f50728a);
    }

    @Override // j$.util.stream.P1
    public final void j(P1 p12) {
        accept(((C0267z1) p12).f50728a);
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
