package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.c2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0174c2 implements InterfaceC0193g2 {

    /* renamed from: a  reason: collision with root package name */
    protected final InterfaceC0193g2 f50557a;

    public AbstractC0174c2(InterfaceC0193g2 interfaceC0193g2) {
        interfaceC0193g2.getClass();
        this.f50557a = interfaceC0193g2;
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
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public void end() {
        this.f50557a.end();
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public boolean g() {
        return this.f50557a.g();
    }
}
