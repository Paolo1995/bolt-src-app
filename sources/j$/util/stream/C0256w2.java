package j$.util.stream;

import java.util.Arrays;

/* renamed from: j$.util.stream.w2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0256w2 extends AbstractC0240s2 {

    /* renamed from: c  reason: collision with root package name */
    private L2 f50709c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0256w2(InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
    }

    @Override // j$.util.stream.InterfaceC0184e2, j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        this.f50709c.accept(i8);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50709c = j8 > 0 ? new L2((int) j8) : new L2();
    }

    @Override // j$.util.stream.AbstractC0164a2, j$.util.stream.InterfaceC0193g2
    public final void end() {
        int[] iArr = (int[]) this.f50709c.b();
        Arrays.sort(iArr);
        this.f50539a.e(iArr.length);
        int i8 = 0;
        if (this.f50672b) {
            int length = iArr.length;
            while (i8 < length) {
                int i9 = iArr[i8];
                if (this.f50539a.g()) {
                    break;
                }
                this.f50539a.accept(i9);
                i8++;
            }
        } else {
            int length2 = iArr.length;
            while (i8 < length2) {
                this.f50539a.accept(iArr[i8]);
                i8++;
            }
        }
        this.f50539a.end();
    }
}
