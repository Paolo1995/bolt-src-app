package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.a2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0164a2 implements InterfaceC0184e2 {

    /* renamed from: a  reason: collision with root package name */
    protected final InterfaceC0193g2 f50539a;

    public AbstractC0164a2(InterfaceC0193g2 interfaceC0193g2) {
        interfaceC0193g2.getClass();
        this.f50539a = interfaceC0193g2;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
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
    public void end() {
        this.f50539a.end();
    }

    @Override // j$.util.stream.InterfaceC0184e2
    public final /* synthetic */ void f(Integer num) {
        AbstractC0254w0.r0(this, num);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public boolean g() {
        return this.f50539a.g();
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }
}
