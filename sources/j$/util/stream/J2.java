package j$.util.stream;

import j$.util.Spliterators;
import j$.util.function.C0130i;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class J2 extends P2 implements InterfaceC0135l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public J2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public J2(int i8) {
        super(i8);
    }

    @Override // j$.util.function.InterfaceC0135l
    public void accept(double d8) {
        w();
        int i8 = this.f50567b;
        this.f50567b = i8 + 1;
        ((double[]) this.f50463e)[i8] = d8;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof InterfaceC0135l) {
            d((InterfaceC0135l) consumer);
        } else if (E3.f50390a) {
            E3.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
            throw null;
        } else {
            spliterator().forEachRemaining(consumer);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return Spliterators.f(spliterator());
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0130i(this, interfaceC0135l);
    }

    @Override // j$.util.stream.P2
    public final Object newArray(int i8) {
        return new double[i8];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.P2
    public final void r(Object obj, int i8, int i9, Object obj2) {
        double[] dArr = (double[]) obj;
        InterfaceC0135l interfaceC0135l = (InterfaceC0135l) obj2;
        while (i8 < i9) {
            interfaceC0135l.accept(dArr[i8]);
            i8++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.P2
    public final int s(Object obj) {
        return ((double[]) obj).length;
    }

    public final String toString() {
        double[] dArr = (double[]) b();
        return dArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f50568c), Arrays.toString(dArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f50568c), Arrays.toString(Arrays.copyOf(dArr, 200)));
    }

    @Override // j$.util.stream.P2
    protected final Object[] v() {
        return new double[8];
    }

    @Override // j$.util.stream.P2, java.lang.Iterable
    /* renamed from: x */
    public j$.util.D spliterator() {
        return new I2(this, 0, this.f50568c, 0, this.f50567b);
    }
}
