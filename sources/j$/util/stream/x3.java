package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
abstract class x3 {

    /* renamed from: a  reason: collision with root package name */
    protected final Spliterator f50717a;

    /* renamed from: b  reason: collision with root package name */
    protected final boolean f50718b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50719c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f50720d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x3(Spliterator spliterator, long j8, long j9) {
        this.f50717a = spliterator;
        int i8 = (j9 > 0L ? 1 : (j9 == 0L ? 0 : -1));
        this.f50718b = i8 < 0;
        this.f50719c = i8 >= 0 ? j9 : 0L;
        this.f50720d = new AtomicLong(i8 >= 0 ? j8 + j9 : j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x3(Spliterator spliterator, x3 x3Var) {
        this.f50717a = spliterator;
        this.f50718b = x3Var.f50718b;
        this.f50720d = x3Var.f50720d;
        this.f50719c = x3Var.f50719c;
    }

    public final int characteristics() {
        return this.f50717a.characteristics() & (-16465);
    }

    public final long estimateSize() {
        return this.f50717a.estimateSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long p(long j8) {
        long j9;
        long min;
        do {
            j9 = this.f50720d.get();
            if (j9 != 0) {
                min = Math.min(j9, j8);
                if (min <= 0) {
                    break;
                }
            } else if (this.f50718b) {
                return j8;
            } else {
                return 0L;
            }
        } while (!this.f50720d.compareAndSet(j9, j9 - min));
        if (this.f50718b) {
            return Math.max(j8 - min, 0L);
        }
        long j10 = this.f50719c;
        return j9 > j10 ? Math.max(min - (j9 - j10), 0L) : min;
    }

    protected abstract Spliterator q(Spliterator spliterator);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int r() {
        if (this.f50720d.get() > 0) {
            return 2;
        }
        return this.f50718b ? 3 : 1;
    }

    public /* bridge */ /* synthetic */ j$.util.D trySplit() {
        return (j$.util.D) m12trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.G m9trySplit() {
        return (j$.util.G) m12trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.J m10trySplit() {
        return (j$.util.J) m12trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.M m11trySplit() {
        return (j$.util.M) m12trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final Spliterator m12trySplit() {
        Spliterator trySplit;
        if (this.f50720d.get() == 0 || (trySplit = this.f50717a.trySplit()) == null) {
            return null;
        }
        return q(trySplit);
    }
}
