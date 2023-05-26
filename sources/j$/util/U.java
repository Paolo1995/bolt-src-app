package j$.util;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;

/* loaded from: classes2.dex */
final class U implements D {

    /* renamed from: a  reason: collision with root package name */
    private final double[] f50173a;

    /* renamed from: b  reason: collision with root package name */
    private int f50174b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50175c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50176d;

    public U(double[] dArr, int i8, int i9, int i10) {
        this.f50173a = dArr;
        this.f50174b = i8;
        this.f50175c = i9;
        this.f50176d = i10 | 64 | 16384;
    }

    @Override // j$.util.M
    /* renamed from: c */
    public final void forEachRemaining(InterfaceC0135l interfaceC0135l) {
        int i8;
        interfaceC0135l.getClass();
        double[] dArr = this.f50173a;
        int length = dArr.length;
        int i9 = this.f50175c;
        if (length < i9 || (i8 = this.f50174b) < 0) {
            return;
        }
        this.f50174b = i9;
        if (i8 < i9) {
            do {
                interfaceC0135l.accept(dArr[i8]);
                i8++;
            } while (i8 < i9);
        }
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f50176d;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f50175c - this.f50174b;
    }

    @Override // j$.util.D, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.e(this, consumer);
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
    /* renamed from: n */
    public final boolean tryAdvance(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        int i8 = this.f50174b;
        if (i8 < 0 || i8 >= this.f50175c) {
            return false;
        }
        double[] dArr = this.f50173a;
        this.f50174b = i8 + 1;
        interfaceC0135l.accept(dArr[i8]);
        return true;
    }

    @Override // j$.util.D, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.h(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final D trySplit() {
        int i8 = this.f50174b;
        int i9 = (this.f50175c + i8) >>> 1;
        if (i8 >= i9) {
            return null;
        }
        double[] dArr = this.f50173a;
        this.f50174b = i9;
        return new U(dArr, i8, i9, this.f50176d);
    }
}
