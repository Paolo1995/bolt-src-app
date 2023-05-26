package j$.util.stream;

import j$.util.function.C0117b0;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;

/* renamed from: j$.util.stream.b2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0169b2 implements InterfaceC0189f2 {

    /* renamed from: a  reason: collision with root package name */
    protected final InterfaceC0193g2 f50544a;

    public AbstractC0169b2(InterfaceC0193g2 interfaceC0193g2) {
        interfaceC0193g2.getClass();
        this.f50544a = interfaceC0193g2;
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

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        k((Long) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public void end() {
        this.f50544a.end();
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public boolean g() {
        return this.f50544a.g();
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }

    @Override // j$.util.stream.InterfaceC0189f2
    public final /* synthetic */ void k(Long l8) {
        AbstractC0254w0.t0(this, l8);
    }
}
