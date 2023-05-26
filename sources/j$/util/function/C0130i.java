package j$.util.function;

/* renamed from: j$.util.function.i  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0130i implements InterfaceC0135l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0135l f50322a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0135l f50323b;

    public /* synthetic */ C0130i(InterfaceC0135l interfaceC0135l, InterfaceC0135l interfaceC0135l2) {
        this.f50322a = interfaceC0135l;
        this.f50323b = interfaceC0135l2;
    }

    @Override // j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        j$.time.a.b(this.f50322a, this.f50323b, d8);
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0130i(this, interfaceC0135l);
    }
}
