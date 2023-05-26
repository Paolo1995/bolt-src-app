package j$.util.concurrent;

import j$.util.AbstractC0156n;
import j$.util.G;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.J;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class A implements G {

    /* renamed from: a  reason: collision with root package name */
    long f50195a;

    /* renamed from: b  reason: collision with root package name */
    final long f50196b;

    /* renamed from: c  reason: collision with root package name */
    final int f50197c;

    /* renamed from: d  reason: collision with root package name */
    final int f50198d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(long j8, long j9, int i8, int i9) {
        this.f50195a = j8;
        this.f50196b = j9;
        this.f50197c = i8;
        this.f50198d = i9;
    }

    @Override // j$.util.M
    /* renamed from: b */
    public final void forEachRemaining(J j8) {
        j8.getClass();
        long j9 = this.f50195a;
        long j10 = this.f50196b;
        if (j9 < j10) {
            this.f50195a = j10;
            int i8 = this.f50197c;
            int i9 = this.f50198d;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                j8.accept(current.d(i8, i9));
                j9++;
            } while (j9 < j10);
        }
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // j$.util.Spliterator
    /* renamed from: e */
    public final A trySplit() {
        long j8 = this.f50195a;
        long j9 = (this.f50196b + j8) >>> 1;
        if (j9 <= j8) {
            return null;
        }
        this.f50195a = j9;
        return new A(j8, j9, this.f50197c, this.f50198d);
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f50196b - this.f50195a;
    }

    @Override // j$.util.G, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.f(this, consumer);
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
    /* renamed from: i */
    public final boolean tryAdvance(J j8) {
        j8.getClass();
        long j9 = this.f50195a;
        if (j9 < this.f50196b) {
            j8.accept(ThreadLocalRandom.current().d(this.f50197c, this.f50198d));
            this.f50195a = j9 + 1;
            return true;
        }
        return false;
    }

    @Override // j$.util.G, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.j(this, consumer);
    }
}
