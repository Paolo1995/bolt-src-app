package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class D2 extends AbstractC0236r2 {

    /* renamed from: c  reason: collision with root package name */
    private double[] f50382c;

    /* renamed from: d  reason: collision with root package name */
    private int f50383d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D2(InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
    }

    @Override // j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        double[] dArr = this.f50382c;
        int i8 = this.f50383d;
        this.f50383d = i8 + 1;
        dArr[i8] = d8;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50382c = new double[(int) j8];
    }

    @Override // j$.util.stream.Z1, j$.util.stream.InterfaceC0193g2
    public final void end() {
        int i8 = 0;
        Arrays.sort(this.f50382c, 0, this.f50383d);
        this.f50535a.e(this.f50383d);
        if (this.f50662b) {
            while (i8 < this.f50383d && !this.f50535a.g()) {
                this.f50535a.accept(this.f50382c[i8]);
                i8++;
            }
        } else {
            while (i8 < this.f50383d) {
                this.f50535a.accept(this.f50382c[i8]);
                i8++;
            }
        }
        this.f50535a.end();
        this.f50382c = null;
    }
}
