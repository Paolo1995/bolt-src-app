package j$.util.stream;

import j$.util.C0152j;
import j$.util.function.C0130i;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0128h;
import j$.util.function.InterfaceC0135l;

/* loaded from: classes2.dex */
final class B1 implements P1, InterfaceC0179d2 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f50369a;

    /* renamed from: b  reason: collision with root package name */
    private double f50370b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ InterfaceC0128h f50371c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B1(InterfaceC0128h interfaceC0128h) {
        this.f50371c = interfaceC0128h;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        if (this.f50369a) {
            this.f50369a = false;
        } else {
            d8 = this.f50371c.applyAsDouble(this.f50370b, d8);
        }
        this.f50370b = d8;
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
        this.f50369a = true;
        this.f50370b = 0.0d;
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
        return this.f50369a ? C0152j.a() : C0152j.d(this.f50370b);
    }

    @Override // j$.util.stream.P1
    public final void j(P1 p12) {
        B1 b12 = (B1) p12;
        if (b12.f50369a) {
            return;
        }
        accept(b12.f50370b);
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
