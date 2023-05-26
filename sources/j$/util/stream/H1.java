package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.Supplier;

/* loaded from: classes2.dex */
final class H1 extends Q1 implements P1 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Supplier f50411b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ BiConsumer f50412c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ BiConsumer f50413d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H1(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.f50411b = supplier;
        this.f50412c = biConsumer;
        this.f50413d = biConsumer2;
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
        this.f50412c.accept(this.f50466a, obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50466a = this.f50411b.get();
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
        this.f50413d.accept(this.f50466a, ((H1) p12).f50466a);
    }
}
