package j$.util;

import j$.util.function.C0130i;
import j$.util.function.InterfaceC0135l;

/* renamed from: j$.util.f  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0113f implements InterfaceC0135l {

    /* renamed from: a  reason: collision with root package name */
    private double f50263a;

    /* renamed from: b  reason: collision with root package name */
    private double f50264b;
    private long count;
    private double sum;
    private double min = Double.POSITIVE_INFINITY;
    private double max = Double.NEGATIVE_INFINITY;

    public final void a(C0113f c0113f) {
        this.count += c0113f.count;
        this.f50264b += c0113f.f50264b;
        double d8 = c0113f.sum - this.f50263a;
        double d9 = this.sum;
        double d10 = d9 + d8;
        double d11 = (d10 - d9) - d8;
        this.f50263a = d11;
        double d12 = c0113f.f50263a - d11;
        double d13 = d10 + d12;
        this.f50263a = (d13 - d10) - d12;
        this.sum = d13;
        this.min = Math.min(this.min, c0113f.min);
        this.max = Math.max(this.max, c0113f.max);
    }

    @Override // j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        this.count++;
        this.f50264b += d8;
        double d9 = d8 - this.f50263a;
        double d10 = this.sum;
        double d11 = d10 + d9;
        this.f50263a = (d11 - d10) - d9;
        this.sum = d11;
        this.min = Math.min(this.min, d8);
        this.max = Math.max(this.max, d8);
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0130i(this, interfaceC0135l);
    }

    public final String toString() {
        double d8;
        Object[] objArr = new Object[6];
        objArr[0] = C0113f.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        double d9 = this.sum + this.f50263a;
        if (Double.isNaN(d9) && Double.isInfinite(this.f50264b)) {
            d9 = this.f50264b;
        }
        objArr[2] = Double.valueOf(d9);
        objArr[3] = Double.valueOf(this.min);
        if (this.count > 0) {
            double d10 = this.sum + this.f50263a;
            if (Double.isNaN(d10) && Double.isInfinite(this.f50264b)) {
                d10 = this.f50264b;
            }
            d8 = d10 / this.count;
        } else {
            d8 = 0.0d;
        }
        objArr[4] = Double.valueOf(d8);
        objArr[5] = Double.valueOf(this.max);
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", objArr);
    }
}
