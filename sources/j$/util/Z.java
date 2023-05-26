package j$.util;

import j$.util.Spliterator;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class Z implements G {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f50177a;

    /* renamed from: b  reason: collision with root package name */
    private int f50178b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50179c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50180d;

    public Z(int[] iArr, int i8, int i9, int i10) {
        this.f50177a = iArr;
        this.f50178b = i8;
        this.f50179c = i9;
        this.f50180d = i10 | 64 | 16384;
    }

    @Override // j$.util.M
    /* renamed from: b */
    public final void forEachRemaining(j$.util.function.J j8) {
        int i8;
        j8.getClass();
        int[] iArr = this.f50177a;
        int length = iArr.length;
        int i9 = this.f50179c;
        if (length < i9 || (i8 = this.f50178b) < 0) {
            return;
        }
        this.f50178b = i9;
        if (i8 < i9) {
            do {
                j8.accept(iArr[i8]);
                i8++;
            } while (i8 < i9);
        }
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f50180d;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f50179c - this.f50178b;
    }

    @Override // j$.util.G, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.f(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final java.util.Comparator getComparator() {
        if (Spliterator.CC.$default$hasCharacteristics(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
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
    /* renamed from: i */
    public final boolean tryAdvance(j$.util.function.J j8) {
        j8.getClass();
        int i8 = this.f50178b;
        if (i8 < 0 || i8 >= this.f50179c) {
            return false;
        }
        int[] iArr = this.f50177a;
        this.f50178b = i8 + 1;
        j8.accept(iArr[i8]);
        return true;
    }

    @Override // j$.util.G, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.j(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final G trySplit() {
        int i8 = this.f50178b;
        int i9 = (this.f50179c + i8) >>> 1;
        if (i8 >= i9) {
            return null;
        }
        int[] iArr = this.f50177a;
        this.f50178b = i9;
        return new Z(iArr, i8, i9, this.f50180d);
    }
}
