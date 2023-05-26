package j$.util.stream;

import j$.util.function.C0130i;
import j$.util.function.C0139p;
import j$.util.function.InterfaceC0135l;

/* renamed from: j$.util.stream.r0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0234r0 extends AbstractC0238s0 implements InterfaceC0179d2 {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ EnumC0242t0 f50653c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ j$.util.function.r f50654d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0234r0(j$.util.function.r rVar, EnumC0242t0 enumC0242t0) {
        super(enumC0242t0);
        this.f50653c = enumC0242t0;
        this.f50654d = rVar;
    }

    @Override // j$.util.stream.AbstractC0238s0, j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        boolean z7;
        boolean z8;
        if (this.f50670a) {
            return;
        }
        boolean e8 = ((C0139p) this.f50654d).e(d8);
        z7 = this.f50653c.f50677a;
        if (e8 == z7) {
            this.f50670a = true;
            z8 = this.f50653c.f50678b;
            this.f50671b = z8;
        }
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Double) obj);
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0130i(this, interfaceC0135l);
    }

    @Override // j$.util.stream.InterfaceC0179d2
    public final /* synthetic */ void o(Double d8) {
        AbstractC0254w0.p0(this, d8);
    }
}
