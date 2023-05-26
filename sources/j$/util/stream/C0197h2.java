package j$.util.stream;

/* renamed from: j$.util.stream.h2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0197h2 extends AbstractC0174c2 {

    /* renamed from: b  reason: collision with root package name */
    long f50586b;

    /* renamed from: c  reason: collision with root package name */
    long f50587c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0201i2 f50588d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0197h2(C0201i2 c0201i2, InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
        this.f50588d = c0201i2;
        this.f50586b = c0201i2.f50591t;
        long j8 = c0201i2.f50592u;
        this.f50587c = j8 < 0 ? Long.MAX_VALUE : j8;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        long j8 = this.f50586b;
        if (j8 != 0) {
            this.f50586b = j8 - 1;
            return;
        }
        long j9 = this.f50587c;
        if (j9 > 0) {
            this.f50587c = j9 - 1;
            this.f50557a.accept((InterfaceC0193g2) obj);
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50557a.e(AbstractC0254w0.K0(j8, this.f50588d.f50591t, this.f50587c));
    }

    @Override // j$.util.stream.AbstractC0174c2, j$.util.stream.InterfaceC0193g2
    public final boolean g() {
        return this.f50587c == 0 || this.f50557a.g();
    }
}
