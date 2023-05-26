package j$.util;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;

/* loaded from: classes2.dex */
final class b0 implements J {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f50188a;

    /* renamed from: b  reason: collision with root package name */
    private int f50189b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50190c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50191d;

    public b0(long[] jArr, int i8, int i9, int i10) {
        this.f50188a = jArr;
        this.f50189b = i8;
        this.f50190c = i9;
        this.f50191d = i10 | 64 | 16384;
    }

    @Override // j$.util.M
    /* renamed from: a */
    public final void forEachRemaining(InterfaceC0123e0 interfaceC0123e0) {
        int i8;
        interfaceC0123e0.getClass();
        long[] jArr = this.f50188a;
        int length = jArr.length;
        int i9 = this.f50190c;
        if (length < i9 || (i8 = this.f50189b) < 0) {
            return;
        }
        this.f50189b = i9;
        if (i8 < i9) {
            do {
                interfaceC0123e0.accept(jArr[i8]);
                i8++;
            } while (i8 < i9);
        }
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f50191d;
    }

    @Override // j$.util.M
    /* renamed from: d */
    public final boolean tryAdvance(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        int i8 = this.f50189b;
        if (i8 < 0 || i8 >= this.f50190c) {
            return false;
        }
        long[] jArr = this.f50188a;
        this.f50189b = i8 + 1;
        interfaceC0123e0.accept(jArr[i8]);
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f50190c - this.f50189b;
    }

    @Override // j$.util.J, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.g(this, consumer);
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

    @Override // j$.util.J, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.k(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final J trySplit() {
        int i8 = this.f50189b;
        int i9 = (this.f50190c + i8) >>> 1;
        if (i8 >= i9) {
            return null;
        }
        long[] jArr = this.f50188a;
        this.f50189b = i9;
        return new b0(jArr, i8, i9, this.f50191d);
    }
}
