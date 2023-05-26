package j$.util;

import j$.util.function.C0121d0;
import j$.util.function.C0122e;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;
import java.util.Spliterator;

/* loaded from: classes2.dex */
public final /* synthetic */ class H implements J {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Spliterator.OfLong f50145a;

    private /* synthetic */ H(Spliterator.OfLong ofLong) {
        this.f50145a = ofLong;
    }

    public static /* synthetic */ J e(Spliterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof I ? ((I) ofLong).f50146a : new H(ofLong);
    }

    @Override // j$.util.J
    public final /* synthetic */ void a(InterfaceC0123e0 interfaceC0123e0) {
        this.f50145a.forEachRemaining(C0121d0.a(interfaceC0123e0));
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f50145a.characteristics();
    }

    @Override // j$.util.J
    public final /* synthetic */ boolean d(InterfaceC0123e0 interfaceC0123e0) {
        return this.f50145a.tryAdvance(C0121d0.a(interfaceC0123e0));
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f50145a.estimateSize();
    }

    @Override // j$.util.J, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f50145a.forEachRemaining(C0122e.a(consumer));
    }

    @Override // j$.util.M
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f50145a.forEachRemaining((Spliterator.OfLong) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ java.util.Comparator getComparator() {
        return this.f50145a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f50145a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i8) {
        return this.f50145a.hasCharacteristics(i8);
    }

    @Override // j$.util.J, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f50145a.tryAdvance(C0122e.a(consumer));
    }

    @Override // j$.util.M
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f50145a.tryAdvance((Spliterator.OfLong) obj);
    }

    @Override // j$.util.J, j$.util.M, j$.util.Spliterator
    public final /* synthetic */ J trySplit() {
        return e(this.f50145a.trySplit());
    }

    @Override // j$.util.M, j$.util.Spliterator
    public final /* synthetic */ M trySplit() {
        return K.e(this.f50145a.trySplit());
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return N.e(this.f50145a.trySplit());
    }
}
