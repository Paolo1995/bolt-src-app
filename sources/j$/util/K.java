package j$.util;

import j$.util.function.C0122e;
import j$.util.function.Consumer;
import java.util.Spliterator;

/* loaded from: classes2.dex */
public final /* synthetic */ class K implements M {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Spliterator.OfPrimitive f50147a;

    private /* synthetic */ K(Spliterator.OfPrimitive ofPrimitive) {
        this.f50147a = ofPrimitive;
    }

    public static /* synthetic */ M e(Spliterator.OfPrimitive ofPrimitive) {
        if (ofPrimitive == null) {
            return null;
        }
        return ofPrimitive instanceof L ? ((L) ofPrimitive).f50148a : new K(ofPrimitive);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f50147a.characteristics();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f50147a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f50147a.forEachRemaining(C0122e.a(consumer));
    }

    @Override // j$.util.M
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f50147a.forEachRemaining((Spliterator.OfPrimitive) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ java.util.Comparator getComparator() {
        return this.f50147a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f50147a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i8) {
        return this.f50147a.hasCharacteristics(i8);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f50147a.tryAdvance(C0122e.a(consumer));
    }

    @Override // j$.util.M
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f50147a.tryAdvance((Spliterator.OfPrimitive) obj);
    }

    @Override // j$.util.M, j$.util.Spliterator
    public final /* synthetic */ M trySplit() {
        return e(this.f50147a.trySplit());
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return N.e(this.f50147a.trySplit());
    }
}
