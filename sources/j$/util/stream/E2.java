package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class E2 extends AbstractC0240s2 {

    /* renamed from: c  reason: collision with root package name */
    private int[] f50388c;

    /* renamed from: d  reason: collision with root package name */
    private int f50389d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E2(InterfaceC0193g2 interfaceC0193g2) {
        super(interfaceC0193g2);
    }

    @Override // j$.util.stream.InterfaceC0184e2, j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        int[] iArr = this.f50388c;
        int i9 = this.f50389d;
        this.f50389d = i9 + 1;
        iArr[i9] = i8;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50388c = new int[(int) j8];
    }

    @Override // j$.util.stream.AbstractC0164a2, j$.util.stream.InterfaceC0193g2
    public final void end() {
        int i8 = 0;
        Arrays.sort(this.f50388c, 0, this.f50389d);
        this.f50539a.e(this.f50389d);
        if (this.f50672b) {
            while (i8 < this.f50389d && !this.f50539a.g()) {
                this.f50539a.accept(this.f50388c[i8]);
                i8++;
            }
        } else {
            while (i8 < this.f50389d) {
                this.f50539a.accept(this.f50388c[i8]);
                i8++;
            }
        }
        this.f50539a.end();
        this.f50388c = null;
    }
}
