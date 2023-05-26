package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0120d;
import j$.util.function.Supplier;

/* loaded from: classes2.dex */
final class G1 extends Q1 implements P1 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Supplier f50399b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ BiConsumer f50400c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ InterfaceC0120d f50401d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G1(Supplier supplier, BiConsumer biConsumer, InterfaceC0120d interfaceC0120d) {
        this.f50399b = supplier;
        this.f50400c = biConsumer;
        this.f50401d = interfaceC0120d;
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
        this.f50400c.accept(this.f50466a, obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50466a = this.f50399b.get();
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
        this.f50466a = this.f50401d.apply(this.f50466a, ((G1) p12).f50466a);
    }
}
