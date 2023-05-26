package j$.util;

import j$.util.Spliterator;
import j$.util.function.C0122e;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class N implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ java.util.Spliterator f50149a;

    private /* synthetic */ N(java.util.Spliterator spliterator) {
        this.f50149a = spliterator;
    }

    public static /* synthetic */ Spliterator e(java.util.Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        return spliterator instanceof Spliterator.Wrapper ? Spliterator.this : new N(spliterator);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f50149a.characteristics();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f50149a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f50149a.forEachRemaining(C0122e.a(consumer));
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ java.util.Comparator getComparator() {
        return this.f50149a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f50149a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i8) {
        return this.f50149a.hasCharacteristics(i8);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f50149a.tryAdvance(C0122e.a(consumer));
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return e(this.f50149a.trySplit());
    }
}
