package j$.util.stream;

/* renamed from: j$.util.stream.p0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0227p0 extends AbstractC0238s0 implements InterfaceC0184e2 {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ EnumC0242t0 f50637c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ j$.util.function.N f50638d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0227p0(j$.util.function.N n8, EnumC0242t0 enumC0242t0) {
        super(enumC0242t0);
        this.f50637c = enumC0242t0;
        this.f50638d = n8;
    }

    @Override // j$.util.stream.AbstractC0238s0, j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        boolean z7;
        boolean z8;
        if (this.f50670a) {
            return;
        }
        boolean e8 = ((j$.util.function.L) this.f50638d).e(i8);
        z7 = this.f50637c.f50677a;
        if (e8 == z7) {
            this.f50670a = true;
            z8 = this.f50637c.f50678b;
            this.f50671b = z8;
        }
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
