package j$.util.concurrent;

import j$.util.AbstractC0156n;
import j$.util.D;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class z implements D {

    /* renamed from: a  reason: collision with root package name */
    long f50252a;

    /* renamed from: b  reason: collision with root package name */
    final long f50253b;

    /* renamed from: c  reason: collision with root package name */
    final double f50254c;

    /* renamed from: d  reason: collision with root package name */
    final double f50255d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(long j8, long j9, double d8, double d9) {
        this.f50252a = j8;
        this.f50253b = j9;
        this.f50254c = d8;
        this.f50255d = d9;
    }

    @Override // j$.util.M
    /* renamed from: c */
    public final void forEachRemaining(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        long j8 = this.f50252a;
        long j9 = this.f50253b;
        if (j8 < j9) {
            this.f50252a = j9;
            double d8 = this.f50254c;
            double d9 = this.f50255d;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                interfaceC0135l.accept(current.c(d8, d9));
                j8++;
            } while (j8 < j9);
        }
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // j$.util.Spliterator
    /* renamed from: e */
    public final z trySplit() {
        long j8 = this.f50252a;
        long j9 = (this.f50253b + j8) >>> 1;
        if (j9 <= j8) {
            return null;
        }
        this.f50252a = j9;
        return new z(j8, j9, this.f50254c, this.f50255d);
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f50253b - this.f50252a;
    }

    @Override // j$.util.D, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.e(this, consumer);
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

    @Override // j$.util.M
    /* renamed from: n */
    public final boolean tryAdvance(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        long j8 = this.f50252a;
        if (j8 < this.f50253b) {
            interfaceC0135l.accept(ThreadLocalRandom.current().c(this.f50254c, this.f50255d));
            this.f50252a = j8 + 1;
            return true;
        }
        return false;
    }

    @Override // j$.util.D, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.h(this, consumer);
    }
}
