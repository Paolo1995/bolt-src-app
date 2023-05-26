package j$.util.stream;

import j$.util.Spliterators;
import j$.util.function.C0117b0;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class N2 extends P2 implements InterfaceC0123e0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public N2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public N2(int i8) {
        super(i8);
    }

    @Override // j$.util.function.InterfaceC0123e0
    public void accept(long j8) {
        w();
        int i8 = this.f50567b;
        this.f50567b = i8 + 1;
        ((long[]) this.f50463e)[i8] = j8;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof InterfaceC0123e0) {
            d((InterfaceC0123e0) consumer);
        } else if (E3.f50390a) {
            E3.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
            throw null;
        } else {
            spliterator().forEachRemaining(consumer);
        }
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return Spliterators.h(spliterator());
    }

    @Override // j$.util.stream.P2
    public final Object newArray(int i8) {
        return new long[i8];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.P2
    public final void r(Object obj, int i8, int i9, Object obj2) {
        long[] jArr = (long[]) obj;
        InterfaceC0123e0 interfaceC0123e0 = (InterfaceC0123e0) obj2;
        while (i8 < i9) {
            interfaceC0123e0.accept(jArr[i8]);
            i8++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.P2
    public final int s(Object obj) {
        return ((long[]) obj).length;
    }

    public final String toString() {
        long[] jArr = (long[]) b();
        return jArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f50568c), Arrays.toString(jArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f50568c), Arrays.toString(Arrays.copyOf(jArr, 200)));
    }

    @Override // j$.util.stream.P2
    protected final Object[] v() {
        return new long[8];
    }

    @Override // j$.util.stream.P2, java.lang.Iterable
    /* renamed from: x */
    public j$.util.J spliterator() {
        return new M2(this, 0, this.f50568c, 0, this.f50567b);
    }
}
