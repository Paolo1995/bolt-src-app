package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class y3 implements InterfaceC0193g2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50725a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f50726b;

    public /* synthetic */ y3(Consumer consumer, int i8) {
        this.f50725a = i8;
        this.f50726b = consumer;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        switch (this.f50725a) {
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
        switch (this.f50725a) {
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
        switch (this.f50725a) {
            case 0:
                AbstractC0254w0.w0();
                throw null;
            default:
                AbstractC0254w0.w0();
                throw null;
        }
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f50725a) {
            case 0:
                ((Q2) this.f50726b).accept(obj);
                return;
            default:
                this.f50726b.accept(obj);
                return;
        }
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f50725a) {
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
}
