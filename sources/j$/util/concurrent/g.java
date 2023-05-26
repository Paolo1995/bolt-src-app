package j$.util.concurrent;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g extends q implements Spliterator {

    /* renamed from: i  reason: collision with root package name */
    final ConcurrentHashMap f50213i;

    /* renamed from: j  reason: collision with root package name */
    long f50214j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(m[] mVarArr, int i8, int i9, int i10, long j8, ConcurrentHashMap concurrentHashMap) {
        super(mVarArr, i8, i9, i10);
        this.f50213i = concurrentHashMap;
        this.f50214j = j8;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 4353;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f50214j;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        while (true) {
            m e8 = e();
            if (e8 == null) {
                return;
            }
            consumer.accept(new l(e8.f50223b, e8.f50224c, this.f50213i));
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

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        m e8 = e();
        if (e8 == null) {
            return false;
        }
        consumer.accept(new l(e8.f50223b, e8.f50224c, this.f50213i));
        return true;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        int i8 = this.f50235f;
        int i9 = this.f50236g;
        int i10 = (i8 + i9) >>> 1;
        if (i10 <= i8) {
            return null;
        }
        m[] mVarArr = this.f50230a;
        int i11 = this.f50237h;
        this.f50236g = i10;
        long j8 = this.f50214j >>> 1;
        this.f50214j = j8;
        return new g(mVarArr, i11, i10, i9, j8, this.f50213i);
    }
}
