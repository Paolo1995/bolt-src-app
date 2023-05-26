package j$.util.function;

/* renamed from: j$.util.function.b0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0117b0 implements InterfaceC0123e0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0123e0 f50312a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0123e0 f50313b;

    public /* synthetic */ C0117b0(InterfaceC0123e0 interfaceC0123e0, InterfaceC0123e0 interfaceC0123e02) {
        this.f50312a = interfaceC0123e0;
        this.f50313b = interfaceC0123e02;
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final void accept(long j8) {
        InterfaceC0123e0 interfaceC0123e0 = this.f50312a;
        InterfaceC0123e0 interfaceC0123e02 = this.f50313b;
        interfaceC0123e0.accept(j8);
        interfaceC0123e02.accept(j8);
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }
}
