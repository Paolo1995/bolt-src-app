package j$.util.stream;

/* loaded from: classes2.dex */
public final /* synthetic */ class W implements j$.util.function.J {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50525a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0193g2 f50526b;

    public /* synthetic */ W(int i8, InterfaceC0193g2 interfaceC0193g2) {
        this.f50525a = i8;
        this.f50526b = interfaceC0193g2;
    }

    @Override // j$.util.function.J
    public final void accept(int i8) {
        switch (this.f50525a) {
            case 0:
                this.f50526b.accept(i8);
                return;
            default:
                ((Y) this.f50526b).f50539a.accept(i8);
                return;
        }
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        switch (this.f50525a) {
            case 0:
                j8.getClass();
                return new j$.util.function.G(this, j8);
            default:
                j8.getClass();
                return new j$.util.function.G(this, j8);
        }
    }
}
