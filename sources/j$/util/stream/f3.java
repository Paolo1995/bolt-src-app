package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class f3 implements InterfaceC0184e2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50580a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j$.util.function.J f50581b;

    public /* synthetic */ f3(j$.util.function.J j8, int i8) {
        this.f50580a = i8;
        this.f50581b = j8;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        switch (this.f50580a) {
            case 0:
                AbstractC0254w0.o0();
                throw null;
            default:
                AbstractC0254w0.o0();
                throw null;
        }
    }

    @Override // j$.util.stream.InterfaceC0184e2, j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        switch (this.f50580a) {
            case 0:
                ((L2) this.f50581b).accept(i8);
                return;
            default:
                this.f50581b.accept(i8);
                return;
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(long j8) {
        switch (this.f50580a) {
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
        switch (this.f50580a) {
            case 0:
                f((Integer) obj);
                return;
            default:
                f((Integer) obj);
                return;
        }
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f50580a) {
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

    @Override // j$.util.stream.InterfaceC0184e2
    public final /* synthetic */ void f(Integer num) {
        switch (this.f50580a) {
            case 0:
                AbstractC0254w0.r0(this, num);
                return;
            default:
                AbstractC0254w0.r0(this, num);
                return;
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        switch (this.f50580a) {
            case 0:
                j8.getClass();
                return new j$.util.function.G(this, j8);
            default:
                j8.getClass();
                return new j$.util.function.G(this, j8);
        }
    }
}
