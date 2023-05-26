package j$.util.stream;

/* renamed from: j$.util.stream.n2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0221n2 extends Z1 {

    /* renamed from: b  reason: collision with root package name */
    long f50622b;

    /* renamed from: c  reason: collision with root package name */
    long f50623c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0225o2 f50624d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0221n2(C0225o2 c0225o2, InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
        this.f50624d = c0225o2;
        this.f50622b = c0225o2.f50633t;
        long j8 = c0225o2.f50634u;
        this.f50623c = j8 < 0 ? Long.MAX_VALUE : j8;
    }

    @Override // j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        long j8 = this.f50622b;
        if (j8 != 0) {
            this.f50622b = j8 - 1;
            return;
        }
        long j9 = this.f50623c;
        if (j9 > 0) {
            this.f50623c = j9 - 1;
            this.f50535a.accept(d8);
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50535a.e(AbstractC0254w0.K0(j8, this.f50624d.f50633t, this.f50623c));
    }

    @Override // j$.util.stream.Z1, j$.util.stream.InterfaceC0193g2
    public final boolean g() {
        return this.f50623c == 0 || this.f50535a.g();
    }
}
