package j$.util.concurrent;

import j$.util.AbstractC0156n;
import j$.util.J;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class B implements J {

    /* renamed from: a  reason: collision with root package name */
    long f50199a;

    /* renamed from: b  reason: collision with root package name */
    final long f50200b;

    /* renamed from: c  reason: collision with root package name */
    final long f50201c;

    /* renamed from: d  reason: collision with root package name */
    final long f50202d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(long j8, long j9, long j10, long j11) {
        this.f50199a = j8;
        this.f50200b = j9;
        this.f50201c = j10;
        this.f50202d = j11;
    }

    @Override // j$.util.M
    /* renamed from: a */
    public final void forEachRemaining(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        long j8 = this.f50199a;
        long j9 = this.f50200b;
        if (j8 < j9) {
            this.f50199a = j9;
            long j10 = this.f50201c;
            long j11 = this.f50202d;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                interfaceC0123e0.accept(current.e(j10, j11));
                j8++;
            } while (j8 < j9);
        }
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // j$.util.M
    /* renamed from: d */
    public final boolean tryAdvance(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        long j8 = this.f50199a;
        if (j8 < this.f50200b) {
            interfaceC0123e0.accept(ThreadLocalRandom.current().e(this.f50201c, this.f50202d));
            this.f50199a = j8 + 1;
            return true;
        }
        return false;
    }

    @Override // j$.util.Spliterator
    /* renamed from: e */
    public final B trySplit() {
        long j8 = this.f50199a;
        long j9 = (this.f50200b + j8) >>> 1;
        if (j9 <= j8) {
            return null;
        }
        this.f50199a = j9;
        return new B(j8, j9, this.f50201c, this.f50202d);
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f50200b - this.f50199a;
    }

    @Override // j$.util.J, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0156n.g(this, consumer);
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

    @Override // j$.util.J, j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0156n.k(this, consumer);
    }
}
