package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class J1 implements P1, InterfaceC0184e2 {

    /* renamed from: a  reason: collision with root package name */
    private int f50428a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f50429b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j$.util.function.F f50430c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J1(int i8, j$.util.function.F f8) {
        this.f50429b = i8;
        this.f50430c = f8;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        this.f50428a = this.f50430c.applyAsInt(this.f50428a, i8);
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
        this.f50428a = this.f50429b;
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

    @Override // j$.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.f50428a);
    }

    @Override // j$.util.stream.P1
    public final void j(P1 p12) {
        accept(((J1) p12).f50428a);
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }
}
