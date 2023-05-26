package j$.util.stream;

import j$.util.function.C0117b0;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0115a0;
import j$.util.function.InterfaceC0123e0;

/* loaded from: classes2.dex */
final class N1 implements P1, InterfaceC0189f2 {

    /* renamed from: a  reason: collision with root package name */
    private long f50449a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f50450b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ InterfaceC0115a0 f50451c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N1(long j8, InterfaceC0115a0 interfaceC0115a0) {
        this.f50450b = j8;
        this.f50451c = interfaceC0115a0;
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
        this.f50449a = this.f50451c.applyAsLong(this.f50449a, j8);
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
        this.f50449a = this.f50450b;
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
        return Long.valueOf(this.f50449a);
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }

    @Override // j$.util.stream.P1
    public final void j(P1 p12) {
        accept(((N1) p12).f50449a);
    }

    @Override // j$.util.stream.InterfaceC0189f2
    public final /* synthetic */ void k(Long l8) {
        AbstractC0254w0.t0(this, l8);
    }
}
