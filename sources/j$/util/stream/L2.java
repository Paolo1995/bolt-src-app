package j$.util.stream;

import j$.util.Spliterators;
import j$.util.function.Consumer;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class L2 extends P2 implements j$.util.function.J {
    /* JADX INFO: Access modifiers changed from: package-private */
    public L2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public L2(int i8) {
        super(i8);
    }

    @Override // j$.util.function.J
    public void accept(int i8) {
        w();
        int i9 = this.f50567b;
        this.f50567b = i9 + 1;
        ((int[]) this.f50463e)[i9] = i8;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof j$.util.function.J) {
            d((j$.util.function.J) consumer);
        } else if (E3.f50390a) {
            E3.a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
            throw null;
        } else {
            spliterator().forEachRemaining(consumer);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return Spliterators.g(spliterator());
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }

    @Override // j$.util.stream.P2
    public final Object newArray(int i8) {
        return new int[i8];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.P2
    public final void r(Object obj, int i8, int i9, Object obj2) {
        int[] iArr = (int[]) obj;
        j$.util.function.J j8 = (j$.util.function.J) obj2;
        while (i8 < i9) {
            j8.accept(iArr[i8]);
            i8++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.P2
    public final int s(Object obj) {
        return ((int[]) obj).length;
    }

    public final String toString() {
        int[] iArr = (int[]) b();
        return iArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f50568c), Arrays.toString(iArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f50568c), Arrays.toString(Arrays.copyOf(iArr, 200)));
    }

    @Override // j$.util.stream.P2
    protected final Object[] v() {
        return new int[8];
    }

    @Override // j$.util.stream.P2, java.lang.Iterable
    /* renamed from: x */
    public j$.util.G spliterator() {
        return new K2(this, 0, this.f50568c, 0, this.f50567b);
    }
}
