package j$.util.stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class P extends T implements InterfaceC0184e2 {

    /* renamed from: b  reason: collision with root package name */
    final j$.util.function.J f50462b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(j$.util.function.J j8, boolean z7) {
        super(z7);
        this.f50462b = j8;
    }

    @Override // j$.util.stream.T, j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        this.f50462b.accept(i8);
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        f((Integer) obj);
    }

    @Override // j$.util.stream.InterfaceC0184e2
    public final /* synthetic */ void f(Integer num) {
        AbstractC0254w0.r0(this, num);
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }
}
