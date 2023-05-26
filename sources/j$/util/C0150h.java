package j$.util;

import j$.util.function.C0117b0;
import j$.util.function.InterfaceC0123e0;

/* renamed from: j$.util.h  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0150h implements InterfaceC0123e0, j$.util.function.J {
    private long count;
    private long sum;
    private long min = Long.MAX_VALUE;
    private long max = Long.MIN_VALUE;

    public final void a(C0150h c0150h) {
        this.count += c0150h.count;
        this.sum += c0150h.sum;
        this.min = Math.min(this.min, c0150h.min);
        this.max = Math.max(this.max, c0150h.max);
    }

    @Override // j$.util.function.J
    public final void accept(int i8) {
        accept(i8);
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final void accept(long j8) {
        this.count++;
        this.sum += j8;
        this.min = Math.min(this.min, j8);
        this.max = Math.max(this.max, j8);
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }

    public final String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = C0150h.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Long.valueOf(this.sum);
        objArr[3] = Long.valueOf(this.min);
        long j8 = this.count;
        objArr[4] = Double.valueOf(j8 > 0 ? this.sum / j8 : 0.0d);
        objArr[5] = Long.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
