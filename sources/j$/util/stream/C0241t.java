package j$.util.stream;

import j$.util.function.C0130i;
import j$.util.function.InterfaceC0135l;

/* renamed from: j$.util.stream.t  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0241t implements InterfaceC0135l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50674a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0193g2 f50675b;

    public /* synthetic */ C0241t(int i8, InterfaceC0193g2 interfaceC0193g2) {
        this.f50674a = i8;
        this.f50675b = interfaceC0193g2;
    }

    @Override // j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        switch (this.f50674a) {
            case 0:
                this.f50675b.accept(d8);
                return;
            default:
                ((C0245u) this.f50675b).f50535a.accept(d8);
                return;
        }
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        switch (this.f50674a) {
            case 0:
                interfaceC0135l.getClass();
                return new C0130i(this, interfaceC0135l);
            default:
                interfaceC0135l.getClass();
                return new C0130i(this, interfaceC0135l);
        }
    }
}
