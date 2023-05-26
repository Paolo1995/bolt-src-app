package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0120d;

/* loaded from: classes2.dex */
final class D1 extends Q1 implements P1 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f50379b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ BiFunction f50380c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ InterfaceC0120d f50381d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D1(Object obj, BiFunction biFunction, InterfaceC0120d interfaceC0120d) {
        this.f50379b = obj;
        this.f50380c = biFunction;
        this.f50381d = interfaceC0120d;
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
    public final /* synthetic */ void accept(long j8) {
        AbstractC0254w0.w0();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.f50466a = this.f50380c.apply(this.f50466a, obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50466a = this.f50379b;
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
        this.f50466a = this.f50381d.apply(this.f50466a, ((D1) p12).f50466a);
    }
}
