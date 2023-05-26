package j$.util.stream;

import j$.util.C0154l;
import j$.util.function.C0117b0;
import j$.util.function.InterfaceC0123e0;

/* loaded from: classes2.dex */
final class K extends M implements InterfaceC0189f2 {
    @Override // j$.util.stream.M, j$.util.stream.InterfaceC0193g2
    public final void accept(long j8) {
        o(Long.valueOf(j8));
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        if (this.f50440a) {
            return C0154l.d(((Long) this.f50441b).longValue());
        }
        return null;
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }
}
