package j$.util;

import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a0 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    private final Collection f50181a;

    /* renamed from: b  reason: collision with root package name */
    private java.util.Iterator f50182b = null;

    /* renamed from: c  reason: collision with root package name */
    private final int f50183c;

    /* renamed from: d  reason: collision with root package name */
    private long f50184d;

    /* renamed from: e  reason: collision with root package name */
    private int f50185e;

    public a0(int i8, Collection collection) {
        this.f50181a = collection;
        this.f50183c = (i8 & 4096) == 0 ? i8 | 64 | 16384 : i8;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f50183c;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        if (this.f50182b == null) {
            this.f50182b = this.f50181a.iterator();
            long size = this.f50181a.size();
            this.f50184d = size;
            return size;
        }
        return this.f50184d;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        java.util.Iterator it = this.f50182b;
        if (it == null) {
            it = this.f50181a.iterator();
            this.f50182b = it;
            this.f50184d = this.f50181a.size();
        }
        if (it instanceof Iterator) {
            ((Iterator) it).forEachRemaining(consumer);
        } else {
            Iterator.CC.$default$forEachRemaining(it, consumer);
        }
    }

    @Override // j$.util.Spliterator
    public java.util.Comparator getComparator() {
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
        if (this.f50182b == null) {
            this.f50182b = this.f50181a.iterator();
            this.f50184d = this.f50181a.size();
        }
        if (this.f50182b.hasNext()) {
            consumer.accept(this.f50182b.next());
            return true;
        }
        return false;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        long j8;
        java.util.Iterator it = this.f50182b;
        if (it == null) {
            it = this.f50181a.iterator();
            this.f50182b = it;
            j8 = this.f50181a.size();
            this.f50184d = j8;
        } else {
            j8 = this.f50184d;
        }
        if (j8 <= 1 || !it.hasNext()) {
            return null;
        }
        int i8 = this.f50185e + Spliterator.IMMUTABLE;
        if (i8 > j8) {
            i8 = (int) j8;
        }
        if (i8 > 33554432) {
            i8 = 33554432;
        }
        Object[] objArr = new Object[i8];
        int i9 = 0;
        do {
            objArr[i9] = it.next();
            i9++;
            if (i9 >= i8) {
                break;
            }
        } while (it.hasNext());
        this.f50185e = i9;
        long j9 = this.f50184d;
        if (j9 != Long.MAX_VALUE) {
            this.f50184d = j9 - i9;
        }
        return new T(objArr, 0, i9, this.f50183c);
    }
}
