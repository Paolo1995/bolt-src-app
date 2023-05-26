package j$.util.stream;

import j$.util.function.C0130i;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;

/* renamed from: j$.util.stream.d3  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0180d3 implements InterfaceC0179d2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50564a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0135l f50565b;

    public /* synthetic */ C0180d3(InterfaceC0135l interfaceC0135l, int i8) {
        this.f50564a = i8;
        this.f50565b = interfaceC0135l;
    }

    @Override // j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        switch (this.f50564a) {
            case 0:
                ((J2) this.f50565b).accept(d8);
                return;
            default:
                this.f50565b.accept(d8);
                return;
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(int i8) {
        switch (this.f50564a) {
            case 0:
                AbstractC0254w0.v0();
                throw null;
            default:
                AbstractC0254w0.v0();
                throw null;
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(long j8) {
        switch (this.f50564a) {
            case 0:
                AbstractC0254w0.w0();
                throw null;
            default:
                AbstractC0254w0.w0();
                throw null;
        }
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f50564a) {
            case 0:
                o((Double) obj);
                return;
            default:
                o((Double) obj);
                return;
        }
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f50564a) {
            case 0:
                return Consumer.CC.$default$andThen(this, consumer);
            default:
                return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void e(long j8) {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        switch (this.f50564a) {
            case 0:
                interfaceC0135l.getClass();
                return new C0130i(this, interfaceC0135l);
            default:
                interfaceC0135l.getClass();
                return new C0130i(this, interfaceC0135l);
        }
    }

    @Override // j$.util.stream.InterfaceC0179d2
    public final /* synthetic */ void o(Double d8) {
        switch (this.f50564a) {
            case 0:
                AbstractC0254w0.p0(this, d8);
                return;
            default:
                AbstractC0254w0.p0(this, d8);
                return;
        }
    }
}
