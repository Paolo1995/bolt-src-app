package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class R0 extends H0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public R0(F0 f02, F0 f03) {
        super(f02, f03);
    }

    @Override // j$.util.stream.F0
    public final void forEach(Consumer consumer) {
        this.f50408a.forEach(consumer);
        this.f50409b.forEach(consumer);
    }

    @Override // j$.util.stream.F0
    public final void i(Object[] objArr, int i8) {
        objArr.getClass();
        this.f50408a.i(objArr, i8);
        this.f50409b.i(objArr, i8 + ((int) this.f50408a.count()));
    }

    @Override // j$.util.stream.F0
    public final Object[] p(IntFunction intFunction) {
        long count = count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) count);
            i(objArr, 0);
            return objArr;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // j$.util.stream.F0
    public final F0 q(long j8, long j9, IntFunction intFunction) {
        if (j8 == 0 && j9 == count()) {
            return this;
        }
        long count = this.f50408a.count();
        return j8 >= count ? this.f50409b.q(j8 - count, j9 - count, intFunction) : j9 <= count ? this.f50408a.q(j8, j9, intFunction) : AbstractC0254w0.T0(1, this.f50408a.q(j8, count, intFunction), this.f50409b.q(0L, j9 - count, intFunction));
    }

    @Override // j$.util.stream.F0
    public final Spliterator spliterator() {
        return new C0200i1(this);
    }

    public final String toString() {
        return count() < 32 ? String.format("ConcNode[%s.%s]", this.f50408a, this.f50409b) : String.format("ConcNode[size=%d]", Long.valueOf(count()));
    }
}
