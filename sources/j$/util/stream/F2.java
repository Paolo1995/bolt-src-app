package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class F2 extends AbstractC0244t2 {

    /* renamed from: c  reason: collision with root package name */
    private long[] f50396c;

    /* renamed from: d  reason: collision with root package name */
    private int f50397d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F2(InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
    }

    @Override // j$.util.stream.InterfaceC0189f2, j$.util.stream.InterfaceC0193g2
    public final void accept(long j8) {
        long[] jArr = this.f50396c;
        int i8 = this.f50397d;
        this.f50397d = i8 + 1;
        jArr[i8] = j8;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50396c = new long[(int) j8];
    }

    @Override // j$.util.stream.AbstractC0169b2, j$.util.stream.InterfaceC0193g2
    public final void end() {
        int i8 = 0;
        Arrays.sort(this.f50396c, 0, this.f50397d);
        this.f50544a.e(this.f50397d);
        if (this.f50679b) {
            while (i8 < this.f50397d && !this.f50544a.g()) {
                this.f50544a.accept(this.f50396c[i8]);
                i8++;
            }
        } else {
            while (i8 < this.f50397d) {
                this.f50544a.accept(this.f50396c[i8]);
                i8++;
            }
        }
        this.f50544a.end();
        this.f50396c = null;
    }
}
