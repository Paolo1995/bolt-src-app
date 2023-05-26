package j$.util.stream;

import j$.util.function.C0130i;
import j$.util.function.InterfaceC0135l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class O extends T implements InterfaceC0179d2 {

    /* renamed from: b  reason: collision with root package name */
    final InterfaceC0135l f50452b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(InterfaceC0135l interfaceC0135l, boolean z7) {
        super(z7);
        this.f50452b = interfaceC0135l;
    }

    @Override // j$.util.stream.T, j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        this.f50452b.accept(d8);
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
