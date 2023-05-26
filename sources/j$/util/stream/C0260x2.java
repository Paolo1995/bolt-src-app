package j$.util.stream;

import java.util.Arrays;

/* renamed from: j$.util.stream.x2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0260x2 extends AbstractC0244t2 {

    /* renamed from: c  reason: collision with root package name */
    private N2 f50716c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0260x2(InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
    }

    @Override // j$.util.stream.InterfaceC0189f2, j$.util.stream.InterfaceC0193g2
    public final void accept(long j8) {
        this.f50716c.accept(j8);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50716c = j8 > 0 ? new N2((int) j8) : new N2();
    }

    @Override // j$.util.stream.AbstractC0169b2, j$.util.stream.InterfaceC0193g2
    public final void end() {
        long[] jArr = (long[]) this.f50716c.b();
        Arrays.sort(jArr);
        this.f50544a.e(jArr.length);
        int i8 = 0;
        if (this.f50679b) {
            int length = jArr.length;
            while (i8 < length) {
                long j8 = jArr[i8];
                if (this.f50544a.g()) {
                    break;
                }
                this.f50544a.accept(j8);
                i8++;
            }
        } else {
            int length2 = jArr.length;
            while (i8 < length2) {
                this.f50544a.accept(jArr[i8]);
                i8++;
            }
        }
        this.f50544a.end();
    }
}
