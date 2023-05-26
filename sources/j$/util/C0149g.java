package j$.util;

import com.google.android.gms.common.api.Api;

/* renamed from: j$.util.g  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0149g implements j$.util.function.J {
    private long count;
    private long sum;
    private int min = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    private int max = Integer.MIN_VALUE;

    public final void a(C0149g c0149g) {
        this.count += c0149g.count;
        this.sum += c0149g.sum;
        this.min = Math.min(this.min, c0149g.min);
        this.max = Math.max(this.max, c0149g.max);
    }

    @Override // j$.util.function.J
    public final void accept(int i8) {
        this.count++;
        this.sum += i8;
        this.min = Math.min(this.min, i8);
        this.max = Math.max(this.max, i8);
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }

    public final String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = C0149g.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Long.valueOf(this.sum);
        objArr[3] = Integer.valueOf(this.min);
        long j8 = this.count;
        objArr[4] = Double.valueOf(j8 > 0 ? this.sum / j8 : 0.0d);
        objArr[5] = Integer.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
