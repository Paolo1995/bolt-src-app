package j$.util.stream;

import j$.util.function.C0117b0;
import j$.util.function.InterfaceC0123e0;

/* renamed from: j$.util.stream.f0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0187f0 implements InterfaceC0123e0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50578a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0193g2 f50579b;

    public /* synthetic */ C0187f0(int i8, InterfaceC0193g2 interfaceC0193g2) {
        this.f50578a = i8;
        this.f50579b = interfaceC0193g2;
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final void accept(long j8) {
        switch (this.f50578a) {
            case 0:
                this.f50579b.accept(j8);
                return;
            default:
                ((C0191g0) this.f50579b).f50544a.accept(j8);
                return;
        }
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        switch (this.f50578a) {
            case 0:
                interfaceC0123e0.getClass();
                return new C0117b0(this, interfaceC0123e0);
            default:
                interfaceC0123e0.getClass();
                return new C0117b0(this, interfaceC0123e0);
        }
    }
}
