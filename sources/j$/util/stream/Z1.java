package j$.util.stream;

import j$.util.function.C0130i;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;

/* loaded from: classes2.dex */
public abstract class Z1 implements InterfaceC0179d2 {

    /* renamed from: a  reason: collision with root package name */
    protected final InterfaceC0193g2 f50535a;

    public Z1(InterfaceC0193g2 interfaceC0193g2) {
        interfaceC0193g2.getClass();
        this.f50535a = interfaceC0193g2;
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
    public void end() {
        this.f50535a.end();
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public boolean g() {
        return this.f50535a.g();
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
