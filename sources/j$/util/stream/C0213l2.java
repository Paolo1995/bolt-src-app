package j$.util.stream;

/* renamed from: j$.util.stream.l2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0213l2 extends AbstractC0169b2 {

    /* renamed from: b  reason: collision with root package name */
    long f50612b;

    /* renamed from: c  reason: collision with root package name */
    long f50613c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0217m2 f50614d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0213l2(C0217m2 c0217m2, InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
        this.f50614d = c0217m2;
        this.f50612b = c0217m2.f50618t;
        long j8 = c0217m2.f50619u;
        this.f50613c = j8 < 0 ? Long.MAX_VALUE : j8;
    }

    @Override // j$.util.stream.InterfaceC0189f2, j$.util.stream.InterfaceC0193g2
    public final void accept(long j8) {
        long j9 = this.f50612b;
        if (j9 != 0) {
            this.f50612b = j9 - 1;
            return;
        }
        long j10 = this.f50613c;
        if (j10 > 0) {
            this.f50613c = j10 - 1;
            this.f50544a.accept(j8);
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50544a.e(AbstractC0254w0.K0(j8, this.f50614d.f50618t, this.f50613c));
    }

    @Override // j$.util.stream.AbstractC0169b2, j$.util.stream.InterfaceC0193g2
    public final boolean g() {
        return this.f50613c == 0 || this.f50544a.g();
    }
}
