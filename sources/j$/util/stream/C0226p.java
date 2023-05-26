package j$.util.stream;

/* renamed from: j$.util.stream.p  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0226p extends AbstractC0174c2 {

    /* renamed from: b  reason: collision with root package name */
    boolean f50635b;

    /* renamed from: c  reason: collision with root package name */
    Object f50636c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0226p(InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        if (obj == null) {
            if (this.f50635b) {
                return;
            }
            this.f50635b = true;
            InterfaceC0193g2 interfaceC0193g2 = this.f50557a;
            this.f50636c = null;
            interfaceC0193g2.accept((InterfaceC0193g2) null);
            return;
        }
        Object obj2 = this.f50636c;
        if (obj2 == null || !obj.equals(obj2)) {
            InterfaceC0193g2 interfaceC0193g22 = this.f50557a;
            this.f50636c = obj;
            interfaceC0193g22.accept((InterfaceC0193g2) obj);
        }
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50635b = false;
        this.f50636c = null;
        this.f50557a.e(-1L);
    }

    @Override // j$.util.stream.AbstractC0174c2, j$.util.stream.InterfaceC0193g2
    public final void end() {
        this.f50635b = false;
        this.f50636c = null;
        this.f50557a.end();
    }
}
