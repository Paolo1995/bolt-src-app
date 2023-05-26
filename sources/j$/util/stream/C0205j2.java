package j$.util.stream;

/* renamed from: j$.util.stream.j2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0205j2 extends AbstractC0164a2 {

    /* renamed from: b  reason: collision with root package name */
    long f50599b;

    /* renamed from: c  reason: collision with root package name */
    long f50600c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0209k2 f50601d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0205j2(C0209k2 c0209k2, InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
        this.f50601d = c0209k2;
        this.f50599b = c0209k2.f50608t;
        long j8 = c0209k2.f50609u;
        this.f50600c = j8 < 0 ? Long.MAX_VALUE : j8;
    }

    @Override // j$.util.stream.InterfaceC0184e2, j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        long j8 = this.f50599b;
        if (j8 != 0) {
            this.f50599b = j8 - 1;
            return;
        }
        long j9 = this.f50600c;
        if (j9 > 0) {
            this.f50600c = j9 - 1;
            this.f50539a.accept(i8);
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50539a.e(AbstractC0254w0.K0(j8, this.f50601d.f50608t, this.f50600c));
    }

    @Override // j$.util.stream.AbstractC0164a2, j$.util.stream.InterfaceC0193g2
    public final boolean g() {
        return this.f50600c == 0 || this.f50539a.g();
    }
}
