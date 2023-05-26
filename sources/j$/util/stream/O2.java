package j$.util.stream;

import j$.util.Spliterator;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class O2 implements j$.util.M {

    /* renamed from: a  reason: collision with root package name */
    int f50456a;

    /* renamed from: b  reason: collision with root package name */
    final int f50457b;

    /* renamed from: c  reason: collision with root package name */
    int f50458c;

    /* renamed from: d  reason: collision with root package name */
    final int f50459d;

    /* renamed from: e  reason: collision with root package name */
    Object f50460e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ P2 f50461f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O2(P2 p22, int i8, int i9, int i10, int i11) {
        this.f50461f = p22;
        this.f50456a = i8;
        this.f50457b = i9;
        this.f50458c = i10;
        this.f50459d = i11;
        Object[] objArr = p22.f50464f;
        this.f50460e = objArr == null ? p22.f50463e : objArr[i8];
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 16464;
    }

    abstract void e(int i8, Object obj, Object obj2);

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        int i8 = this.f50456a;
        int i9 = this.f50457b;
        if (i8 == i9) {
            return this.f50459d - this.f50458c;
        }
        long[] jArr = this.f50461f.f50569d;
        return ((jArr[i9] + this.f50459d) - jArr[i8]) - this.f50458c;
    }

    abstract j$.util.M f(Object obj, int i8, int i9);

    @Override // j$.util.M
    /* renamed from: forEachRemaining */
    public final void c(Object obj) {
        int i8;
        obj.getClass();
        int i9 = this.f50456a;
        int i10 = this.f50457b;
        if (i9 < i10 || (i9 == i10 && this.f50458c < this.f50459d)) {
            int i11 = this.f50458c;
            while (true) {
                i8 = this.f50457b;
                if (i9 >= i8) {
                    break;
                }
                P2 p22 = this.f50461f;
                Object obj2 = p22.f50464f[i9];
                p22.r(obj2, i11, p22.s(obj2), obj);
                i11 = 0;
                i9++;
            }
            this.f50461f.r(this.f50456a == i8 ? this.f50460e : this.f50461f.f50464f[i8], i11, this.f50459d, obj);
            this.f50456a = this.f50457b;
            this.f50458c = this.f50459d;
        }
    }

    abstract j$.util.M g(int i8, int i9, int i10, int i11);

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
        obj.getClass();
        int i8 = this.f50456a;
        int i9 = this.f50457b;
        if (i8 < i9 || (i8 == i9 && this.f50458c < this.f50459d)) {
            Object obj2 = this.f50460e;
            int i10 = this.f50458c;
            this.f50458c = i10 + 1;
            e(i10, obj2, obj);
            if (this.f50458c == this.f50461f.s(this.f50460e)) {
                this.f50458c = 0;
                int i11 = this.f50456a + 1;
                this.f50456a = i11;
                Object[] objArr = this.f50461f.f50464f;
                if (objArr != null && i11 <= this.f50457b) {
                    this.f50460e = objArr[i11];
                }
            }
            return true;
        }
        return false;
    }

    @Override // j$.util.M, j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.D trySplit() {
        return (j$.util.D) trySplit();
    }

    @Override // j$.util.M, j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.G trySplit() {
        return (j$.util.G) trySplit();
    }

    @Override // j$.util.M, j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.J trySplit() {
        return (j$.util.J) trySplit();
    }

    @Override // j$.util.Spliterator
    public final j$.util.M trySplit() {
        int i8 = this.f50456a;
        int i9 = this.f50457b;
        if (i8 < i9) {
            int i10 = this.f50458c;
            P2 p22 = this.f50461f;
            j$.util.M g8 = g(i8, i9 - 1, i10, p22.s(p22.f50464f[i9 - 1]));
            int i11 = this.f50457b;
            this.f50456a = i11;
            this.f50458c = 0;
            this.f50460e = this.f50461f.f50464f[i11];
            return g8;
        } else if (i8 == i9) {
            int i12 = this.f50459d;
            int i13 = this.f50458c;
            int i14 = (i12 - i13) / 2;
            if (i14 == 0) {
                return null;
            }
            j$.util.M f8 = f(this.f50460e, i13, i14);
            this.f50458c += i14;
            return f8;
        } else {
            return null;
        }
    }
}
