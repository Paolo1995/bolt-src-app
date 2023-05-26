package j$.util;

import j$.util.function.C0122e;
import j$.util.function.Consumer;
import java.util.Spliterator;

/* loaded from: classes2.dex */
public final /* synthetic */ class E implements G {

    /* renamed from: a */
    final /* synthetic */ Spliterator.OfInt f50143a;

    private /* synthetic */ E(Spliterator.OfInt ofInt) {
        this.f50143a = ofInt;
    }

    public static /* synthetic */ G e(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof F ? ((F) ofInt).f50144a : new E(ofInt);
    }

    @Override // j$.util.G
    public final /* synthetic */ void b(j$.util.function.J j8) {
        this.f50143a.forEachRemaining(j$.util.function.I.a(j8));
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f50143a.characteristics();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f50143a.estimateSize();
    }

    @Override // j$.util.G, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f50143a.forEachRemaining(C0122e.a(consumer));
    }

    @Override // j$.util.M
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f50143a.forEachRemaining((Spliterator.OfInt) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ java.util.Comparator getComparator() {
        return this.f50143a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f50143a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i8) {
        return this.f50143a.hasCharacteristics(i8);
    }

    @Override // j$.util.G
    public final /* synthetic */ boolean i(j$.util.function.J j8) {
        return this.f50143a.tryAdvance(j$.util.function.I.a(j8));
    }

    @Override // j$.util.G, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f50143a.tryAdvance(C0122e.a(consumer));
    }

    @Override // j$.util.M
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f50143a.tryAdvance((Spliterator.OfInt) obj);
    }

    @Override // j$.util.G, j$.util.M, j$.util.Spliterator
    public final /* synthetic */ G trySplit() {
        return e(this.f50143a.trySplit());
    }

    @Override // j$.util.M, j$.util.Spliterator
    public final /* synthetic */ M trySplit() {
        return K.e(this.f50143a.trySplit());
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return N.e(this.f50143a.trySplit());
    }
}
