package j$.util.stream;

import java.util.Arrays;

/* renamed from: j$.util.stream.v2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0252v2 extends AbstractC0236r2 {

    /* renamed from: c  reason: collision with root package name */
    private J2 f50695c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0252v2(InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
    }

    @Override // j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        this.f50695c.accept(d8);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50695c = j8 > 0 ? new J2((int) j8) : new J2();
    }

    @Override // j$.util.stream.Z1, j$.util.stream.InterfaceC0193g2
    public final void end() {
        double[] dArr = (double[]) this.f50695c.b();
        Arrays.sort(dArr);
        this.f50535a.e(dArr.length);
        int i8 = 0;
        if (this.f50662b) {
            int length = dArr.length;
            while (i8 < length) {
                double d8 = dArr[i8];
                if (this.f50535a.g()) {
                    break;
                }
                this.f50535a.accept(d8);
                i8++;
            }
        } else {
            int length2 = dArr.length;
            while (i8 < length2) {
                this.f50535a.accept(dArr[i8]);
                i8++;
            }
        }
        this.f50535a.end();
    }
}
