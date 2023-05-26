package j$.util.stream;

import j$.util.Spliterator;
import java.util.Comparator;

/* loaded from: classes2.dex */
abstract class p3 extends r3 implements j$.util.M {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p3(j$.util.M m8, long j8, long j9) {
        super(m8, j8, j9, 0L, Math.min(m8.estimateSize(), j9));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p3(j$.util.M m8, long j8, long j9, long j10, long j11) {
        super(m8, j8, j9, j10, j11);
    }

    protected abstract Object f();

    @Override // j$.util.M
    /* renamed from: forEachRemaining */
    public final void c(Object obj) {
        obj.getClass();
        long j8 = this.f50663a;
        long j9 = this.f50667e;
        if (j8 >= j9) {
            return;
        }
        long j10 = this.f50666d;
        if (j10 >= j9) {
            return;
        }
        if (j10 >= j8 && ((j$.util.M) this.f50665c).estimateSize() + j10 <= this.f50664b) {
            ((j$.util.M) this.f50665c).forEachRemaining(obj);
            this.f50666d = this.f50667e;
            return;
        }
        while (this.f50663a > this.f50666d) {
            ((j$.util.M) this.f50665c).tryAdvance(f());
            this.f50666d++;
        }
        while (this.f50666d < this.f50667e) {
            ((j$.util.M) this.f50665c).tryAdvance(obj);
            this.f50666d++;
        }
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return Spliterator.CC.$default$getComparator(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return Spliterator.CC.a(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i8) {
        return Spliterator.CC.$default$hasCharacteristics(this, i8);
    }

    @Override // j$.util.M
    /* renamed from: tryAdvance */
    public final boolean n(Object obj) {
        long j8;
        obj.getClass();
        if (this.f50663a >= this.f50667e) {
            return false;
        }
        while (true) {
            long j9 = this.f50663a;
            j8 = this.f50666d;
            if (j9 <= j8) {
                break;
            }
            ((j$.util.M) this.f50665c).tryAdvance(f());
            this.f50666d++;
        }
        if (j8 >= this.f50667e) {
            return false;
        }
        this.f50666d = j8 + 1;
        return ((j$.util.M) this.f50665c).tryAdvance(obj);
    }
}
