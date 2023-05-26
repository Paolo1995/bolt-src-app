package j$.util.stream;

import j$.util.function.C0117b0;
import j$.util.function.InterfaceC0123e0;

/* loaded from: classes2.dex */
final class Y2 extends Z2 implements InterfaceC0123e0 {

    /* renamed from: c  reason: collision with root package name */
    final long[] f50533c = new long[128];

    @Override // j$.util.stream.Z2
    public final void a(Object obj, long j8) {
        InterfaceC0123e0 interfaceC0123e0 = (InterfaceC0123e0) obj;
        for (int i8 = 0; i8 < j8; i8++) {
            interfaceC0123e0.accept(this.f50533c[i8]);
        }
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final void accept(long j8) {
        long[] jArr = this.f50533c;
        int i8 = this.f50536b;
        this.f50536b = i8 + 1;
        jArr[i8] = j8;
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }
}
