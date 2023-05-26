package j$.util.stream;

import j$.util.C0153k;

/* loaded from: classes2.dex */
final class J extends M implements InterfaceC0184e2 {
    @Override // j$.util.stream.M, j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        o(Integer.valueOf(i8));
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        if (this.f50440a) {
            return C0153k.d(((Integer) this.f50441b).intValue());
        }
        return null;
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }
}
