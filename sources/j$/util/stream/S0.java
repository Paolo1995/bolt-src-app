package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0135l;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class S0 implements B0 {

    /* renamed from: a  reason: collision with root package name */
    final double[] f50472a;

    /* renamed from: b  reason: collision with root package name */
    int f50473b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S0(long j8) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50472a = new double[(int) j8];
        this.f50473b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public S0(double[] dArr) {
        this.f50472a = dArr;
        this.f50473b = dArr.length;
    }

    @Override // j$.util.stream.E0, j$.util.stream.F0
    public final E0 a(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.F0
    public final /* bridge */ /* synthetic */ F0 a(int i8) {
        a(i8);
        throw null;
    }

    @Override // j$.util.stream.E0
    public final Object b() {
        double[] dArr = this.f50472a;
        int length = dArr.length;
        int i8 = this.f50473b;
        return length == i8 ? dArr : Arrays.copyOf(dArr, i8);
    }

    @Override // j$.util.stream.E0
    public final void c(int i8, Object obj) {
        System.arraycopy(this.f50472a, 0, (double[]) obj, i8, this.f50473b);
    }

    @Override // j$.util.stream.F0
    public final long count() {
        return this.f50473b;
    }

    @Override // j$.util.stream.E0
    public final void d(Object obj) {
        InterfaceC0135l interfaceC0135l = (InterfaceC0135l) obj;
        for (int i8 = 0; i8 < this.f50473b; i8++) {
            interfaceC0135l.accept(this.f50472a[i8]);
        }
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ void forEach(Consumer consumer) {
        AbstractC0254w0.B0(this, consumer);
    }

    @Override // j$.util.stream.F0
    /* renamed from: h */
    public final /* synthetic */ void i(Double[] dArr, int i8) {
        AbstractC0254w0.y0(this, dArr, i8);
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ int n() {
        return 0;
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ Object[] p(IntFunction intFunction) {
        return AbstractC0254w0.x0(this, intFunction);
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ F0 q(long j8, long j9, IntFunction intFunction) {
        return AbstractC0254w0.E0(this, j8, j9);
    }

    @Override // j$.util.stream.E0, j$.util.stream.F0
    public final j$.util.M spliterator() {
        return Spliterators.j(this.f50472a, 0, this.f50473b);
    }

    @Override // j$.util.stream.F0
    public final Spliterator spliterator() {
        return Spliterators.j(this.f50472a, 0, this.f50473b);
    }

    public String toString() {
        return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(this.f50472a.length - this.f50473b), Arrays.toString(this.f50472a));
    }
}
