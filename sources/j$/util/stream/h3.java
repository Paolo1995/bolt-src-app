package j$.util.stream;

import j$.util.function.C0117b0;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;

/* loaded from: classes2.dex */
public final /* synthetic */ class h3 implements InterfaceC0189f2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50589a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0123e0 f50590b;

    public /* synthetic */ h3(InterfaceC0123e0 interfaceC0123e0, int i8) {
        this.f50589a = i8;
        this.f50590b = interfaceC0123e0;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        switch (this.f50589a) {
            case 0:
                AbstractC0254w0.o0();
                throw null;
            default:
                AbstractC0254w0.o0();
                throw null;
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(int i8) {
        switch (this.f50589a) {
            case 0:
                AbstractC0254w0.v0();
                throw null;
            default:
                AbstractC0254w0.v0();
                throw null;
        }
    }

    @Override // j$.util.stream.InterfaceC0189f2, j$.util.stream.InterfaceC0193g2
    public final void accept(long j8) {
        switch (this.f50589a) {
            case 0:
                ((N2) this.f50590b).accept(j8);
                return;
            default:
                this.f50590b.accept(j8);
                return;
        }
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f50589a) {
            case 0:
                k((Long) obj);
                return;
            default:
                k((Long) obj);
                return;
        }
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f50589a) {
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

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        switch (this.f50589a) {
            case 0:
                interfaceC0123e0.getClass();
                return new C0117b0(this, interfaceC0123e0);
            default:
                interfaceC0123e0.getClass();
                return new C0117b0(this, interfaceC0123e0);
        }
    }

    @Override // j$.util.stream.InterfaceC0189f2
    public final /* synthetic */ void k(Long l8) {
        switch (this.f50589a) {
            case 0:
                AbstractC0254w0.t0(this, l8);
                return;
            default:
                AbstractC0254w0.t0(this, l8);
                return;
        }
    }
}
