package j$.util.stream;

import j$.util.C0152j;
import j$.util.function.C0130i;
import j$.util.function.InterfaceC0135l;

/* loaded from: classes2.dex */
final class I extends M implements InterfaceC0179d2 {
    @Override // j$.util.stream.M, j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        o(Double.valueOf(d8));
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        if (this.f50440a) {
            return C0152j.d(((Double) this.f50441b).doubleValue());
        }
        return null;
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0130i(this, interfaceC0135l);
    }
}
