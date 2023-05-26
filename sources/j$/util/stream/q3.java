package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q3 extends r3 implements Spliterator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q3(Spliterator spliterator, long j8, long j9) {
        super(spliterator, j8, j9, 0L, Math.min(spliterator.estimateSize(), j9));
    }

    private q3(Spliterator spliterator, long j8, long j9, long j10, long j11) {
        super(spliterator, j8, j9, j10, j11);
    }

    @Override // j$.util.stream.r3
    protected final Spliterator e(Spliterator spliterator, long j8, long j9, long j10, long j11) {
        return new q3(spliterator, j8, j9, j10, j11);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        long j8 = this.f50663a;
        long j9 = this.f50667e;
        if (j8 >= j9) {
            return;
        }
        long j10 = this.f50666d;
        if (j10 >= j9) {
            return;
        }
        if (j10 >= j8 && this.f50665c.estimateSize() + j10 <= this.f50664b) {
            this.f50665c.forEachRemaining(consumer);
            this.f50666d = this.f50667e;
            return;
        }
        while (this.f50663a > this.f50666d) {
            this.f50665c.tryAdvance(new L0(10));
            this.f50666d++;
        }
        while (this.f50666d < this.f50667e) {
            this.f50665c.tryAdvance(consumer);
            this.f50666d++;
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
        long j8;
        consumer.getClass();
        if (this.f50663a >= this.f50667e) {
            return false;
        }
        while (true) {
            long j9 = this.f50663a;
            j8 = this.f50666d;
            if (j9 <= j8) {
                break;
            }
            this.f50665c.tryAdvance(new L0(11));
            this.f50666d++;
        }
        if (j8 >= this.f50667e) {
            return false;
        }
        this.f50666d = j8 + 1;
        return this.f50665c.tryAdvance(consumer);
    }
}
