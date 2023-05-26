package j$.util.stream;

import j$.util.function.C0117b0;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0120d;
import j$.util.function.InterfaceC0123e0;
import j$.util.function.Supplier;

/* renamed from: j$.util.stream.x1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0259x1 extends Q1 implements P1, InterfaceC0189f2 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Supplier f50713b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j$.util.function.C0 f50714c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ InterfaceC0120d f50715d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0259x1(Supplier supplier, j$.util.function.C0 c02, InterfaceC0120d interfaceC0120d) {
        this.f50713b = supplier;
        this.f50714c = c02;
        this.f50715d = interfaceC0120d;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(int i8) {
        AbstractC0254w0.v0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void accept(long j8) {
        this.f50714c.accept(this.f50466a, j8);
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        k((Long) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50466a = this.f50713b.get();
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }

    @Override // j$.util.stream.P1
    public final void j(P1 p12) {
        this.f50466a = this.f50715d.apply(this.f50466a, ((C0259x1) p12).f50466a);
    }

    @Override // j$.util.stream.InterfaceC0189f2
    public final /* synthetic */ void k(Long l8) {
        AbstractC0254w0.t0(this, l8);
    }
}
