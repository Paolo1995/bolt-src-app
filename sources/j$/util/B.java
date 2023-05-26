package j$.util;

import j$.util.function.C0122e;
import j$.util.function.C0134k;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;
import java.util.Spliterator;

/* loaded from: classes2.dex */
public final /* synthetic */ class B implements D {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Spliterator.OfDouble f50135a;

    private /* synthetic */ B(Spliterator.OfDouble ofDouble) {
        this.f50135a = ofDouble;
    }

    public static /* synthetic */ D e(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof C ? ((C) ofDouble).f50136a : new B(ofDouble);
    }

    @Override // j$.util.D
    public final /* synthetic */ void c(InterfaceC0135l interfaceC0135l) {
        this.f50135a.forEachRemaining(C0134k.a(interfaceC0135l));
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f50135a.characteristics();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f50135a.estimateSize();
    }

    @Override // j$.util.D, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f50135a.forEachRemaining(C0122e.a(consumer));
    }

    @Override // j$.util.M
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f50135a.forEachRemaining((Spliterator.OfDouble) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ java.util.Comparator getComparator() {
        return this.f50135a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f50135a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i8) {
        return this.f50135a.hasCharacteristics(i8);
    }

    @Override // j$.util.D
    public final /* synthetic */ boolean n(InterfaceC0135l interfaceC0135l) {
        return this.f50135a.tryAdvance(C0134k.a(interfaceC0135l));
    }

    @Override // j$.util.D, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f50135a.tryAdvance(C0122e.a(consumer));
    }

    @Override // j$.util.M
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f50135a.tryAdvance((Spliterator.OfDouble) obj);
    }

    @Override // j$.util.D, j$.util.M, j$.util.Spliterator
    public final /* synthetic */ D trySplit() {
        return e(this.f50135a.trySplit());
    }

    @Override // j$.util.M, j$.util.Spliterator
    public final /* synthetic */ M trySplit() {
        return K.e(this.f50135a.trySplit());
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return N.e(this.f50135a.trySplit());
    }
}
