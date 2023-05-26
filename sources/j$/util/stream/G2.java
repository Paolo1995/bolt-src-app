package j$.util.stream;

import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class G2 extends AbstractC0248u2 {

    /* renamed from: d  reason: collision with root package name */
    private Object[] f50402d;

    /* renamed from: e  reason: collision with root package name */
    private int f50403e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G2(InterfaceC0193g2 interfaceC0193g2, Comparator comparator) {
        super(interfaceC0193g2, comparator);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        Object[] objArr = this.f50402d;
        int i8 = this.f50403e;
        this.f50403e = i8 + 1;
        objArr[i8] = obj;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50402d = new Object[(int) j8];
    }

    @Override // j$.util.stream.AbstractC0174c2, j$.util.stream.InterfaceC0193g2
    public final void end() {
        int i8 = 0;
        Arrays.sort(this.f50402d, 0, this.f50403e, this.f50687b);
        this.f50557a.e(this.f50403e);
        if (this.f50688c) {
            while (i8 < this.f50403e && !this.f50557a.g()) {
                this.f50557a.accept((InterfaceC0193g2) this.f50402d[i8]);
                i8++;
            }
        } else {
            while (i8 < this.f50403e) {
                this.f50557a.accept((InterfaceC0193g2) this.f50402d[i8]);
                i8++;
            }
        }
        this.f50557a.end();
        this.f50402d = null;
    }
}
