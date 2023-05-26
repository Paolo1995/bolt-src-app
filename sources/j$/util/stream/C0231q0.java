package j$.util.stream;

import j$.util.function.C0117b0;
import j$.util.function.C0131i0;
import j$.util.function.InterfaceC0123e0;

/* renamed from: j$.util.stream.q0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0231q0 extends AbstractC0238s0 implements InterfaceC0189f2 {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ EnumC0242t0 f50644c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ j$.util.function.k0 f50645d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0231q0(j$.util.function.k0 k0Var, EnumC0242t0 enumC0242t0) {
        super(enumC0242t0);
        this.f50644c = enumC0242t0;
        this.f50645d = k0Var;
    }

    @Override // j$.util.stream.AbstractC0238s0, j$.util.stream.InterfaceC0193g2
    public final void accept(long j8) {
        boolean z7;
        boolean z8;
        if (this.f50670a) {
            return;
        }
        boolean e8 = ((C0131i0) this.f50645d).e(j8);
        z7 = this.f50644c.f50677a;
        if (e8 == z7) {
            this.f50670a = true;
            z8 = this.f50644c.f50678b;
            this.f50671b = z8;
        }
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        k((Long) obj);
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }

    @Override // j$.util.stream.InterfaceC0189f2
    public final /* synthetic */ void k(Long l8) {
        AbstractC0254w0.t0(this, l8);
    }
}
