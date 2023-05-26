package j$.util.stream;

import j$.util.function.C0130i;
import j$.util.function.InterfaceC0135l;

/* loaded from: classes2.dex */
final class W2 extends Z2 implements InterfaceC0135l {

    /* renamed from: c  reason: collision with root package name */
    final double[] f50527c = new double[128];

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.Z2
    public final void a(Object obj, long j8) {
        InterfaceC0135l interfaceC0135l = (InterfaceC0135l) obj;
        for (int i8 = 0; i8 < j8; i8++) {
            interfaceC0135l.accept(this.f50527c[i8]);
        }
    }

    @Override // j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        double[] dArr = this.f50527c;
        int i8 = this.f50536b;
        this.f50536b = i8 + 1;
        dArr[i8] = d8;
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0130i(this, interfaceC0135l);
    }
}
