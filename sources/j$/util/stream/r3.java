package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: classes2.dex */
abstract class r3 {

    /* renamed from: a  reason: collision with root package name */
    final long f50663a;

    /* renamed from: b  reason: collision with root package name */
    final long f50664b;

    /* renamed from: c  reason: collision with root package name */
    Spliterator f50665c;

    /* renamed from: d  reason: collision with root package name */
    long f50666d;

    /* renamed from: e  reason: collision with root package name */
    long f50667e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r3(Spliterator spliterator, long j8, long j9, long j10, long j11) {
        this.f50665c = spliterator;
        this.f50663a = j8;
        this.f50664b = j9;
        this.f50666d = j10;
        this.f50667e = j11;
    }

    public final int characteristics() {
        return this.f50665c.characteristics();
    }

    protected abstract Spliterator e(Spliterator spliterator, long j8, long j9, long j10, long j11);

    public final long estimateSize() {
        long j8 = this.f50663a;
        long j9 = this.f50667e;
        if (j8 < j9) {
            return j9 - Math.max(j8, this.f50666d);
        }
        return 0L;
    }

    public /* bridge */ /* synthetic */ j$.util.D trySplit() {
        return (j$.util.D) m8trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.G m5trySplit() {
        return (j$.util.G) m8trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.J m6trySplit() {
        return (j$.util.J) m8trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.M m7trySplit() {
        return (j$.util.M) m8trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final Spliterator m8trySplit() {
        long j8 = this.f50663a;
        long j9 = this.f50667e;
        if (j8 >= j9 || this.f50666d >= j9) {
            return null;
        }
        while (true) {
            Spliterator trySplit = this.f50665c.trySplit();
            if (trySplit == null) {
                return null;
            }
            long estimateSize = trySplit.estimateSize() + this.f50666d;
            long min = Math.min(estimateSize, this.f50664b);
            long j10 = this.f50663a;
            if (j10 >= min) {
                this.f50666d = min;
            } else {
                long j11 = this.f50664b;
                if (min < j11) {
                    long j12 = this.f50666d;
                    if (j12 < j10 || estimateSize > j11) {
                        this.f50666d = min;
                        return e(trySplit, j10, j11, j12, min);
                    }
                    this.f50666d = min;
                    return trySplit;
                }
                this.f50665c = trySplit;
                this.f50667e = min;
            }
        }
    }
}
