package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.s0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0238s0 implements InterfaceC0193g2 {

    /* renamed from: a  reason: collision with root package name */
    boolean f50670a;

    /* renamed from: b  reason: collision with root package name */
    boolean f50671b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0238s0(EnumC0242t0 enumC0242t0) {
        boolean z7;
        z7 = enumC0242t0.f50678b;
        this.f50671b = !z7;
    }

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
        return this.f50670a;
    }
}
