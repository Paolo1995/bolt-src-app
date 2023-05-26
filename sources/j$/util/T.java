package j$.util;

import j$.util.Spliterator;
import j$.util.function.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class T implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f50169a;

    /* renamed from: b  reason: collision with root package name */
    private int f50170b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50171c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50172d;

    public T(Object[] objArr, int i8, int i9, int i10) {
        this.f50169a = objArr;
        this.f50170b = i8;
        this.f50171c = i9;
        this.f50172d = i10 | 64 | 16384;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f50172d;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f50171c - this.f50170b;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        int i8;
        consumer.getClass();
        Object[] objArr = this.f50169a;
        int length = objArr.length;
        int i9 = this.f50171c;
        if (length < i9 || (i8 = this.f50170b) < 0) {
            return;
        }
        this.f50170b = i9;
        if (i8 < i9) {
            do {
                consumer.accept(objArr[i8]);
                i8++;
            } while (i8 < i9);
        }
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

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int i8 = this.f50170b;
        if (i8 < 0 || i8 >= this.f50171c) {
            return false;
        }
        Object[] objArr = this.f50169a;
        this.f50170b = i8 + 1;
        consumer.accept(objArr[i8]);
        return true;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        int i8 = this.f50170b;
        int i9 = (this.f50171c + i8) >>> 1;
        if (i8 >= i9) {
            return null;
        }
        Object[] objArr = this.f50169a;
        this.f50170b = i9;
        return new T(objArr, i8, i9, this.f50172d);
    }
}
