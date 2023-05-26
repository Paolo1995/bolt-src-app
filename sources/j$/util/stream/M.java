package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
abstract class M implements C3 {

    /* renamed from: a  reason: collision with root package name */
    boolean f50440a;

    /* renamed from: b  reason: collision with root package name */
    Object f50441b;

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public /* synthetic */ void accept(int i8) {
        AbstractC0254w0.v0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public /* synthetic */ void accept(long j8) {
        AbstractC0254w0.w0();
        throw null;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: accept */
    public final void o(Object obj) {
        if (this.f50440a) {
            return;
        }
        this.f50440a = true;
        this.f50441b = obj;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void e(long j8) {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final boolean g() {
        return this.f50440a;
    }
}
