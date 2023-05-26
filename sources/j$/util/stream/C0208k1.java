package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0123e0;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.k1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0208k1 implements D0 {

    /* renamed from: a  reason: collision with root package name */
    final long[] f50605a;

    /* renamed from: b  reason: collision with root package name */
    int f50606b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0208k1(long j8) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50605a = new long[(int) j8];
        this.f50606b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0208k1(long[] jArr) {
        this.f50605a = jArr;
        this.f50606b = jArr.length;
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
        long[] jArr = this.f50605a;
        int length = jArr.length;
        int i8 = this.f50606b;
        return length == i8 ? jArr : Arrays.copyOf(jArr, i8);
    }

    @Override // j$.util.stream.E0
    public final void c(int i8, Object obj) {
        System.arraycopy(this.f50605a, 0, (long[]) obj, i8, this.f50606b);
    }

    @Override // j$.util.stream.F0
    public final long count() {
        return this.f50606b;
    }

    @Override // j$.util.stream.E0
    public final void d(Object obj) {
        InterfaceC0123e0 interfaceC0123e0 = (InterfaceC0123e0) obj;
        for (int i8 = 0; i8 < this.f50606b; i8++) {
            interfaceC0123e0.accept(this.f50605a[i8]);
        }
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ void forEach(Consumer consumer) {
        AbstractC0254w0.D0(this, consumer);
    }

    @Override // j$.util.stream.F0
    /* renamed from: l */
    public final /* synthetic */ void i(Long[] lArr, int i8) {
        AbstractC0254w0.A0(this, lArr, i8);
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
        return AbstractC0254w0.G0(this, j8, j9);
    }

    @Override // j$.util.stream.E0, j$.util.stream.F0
    public final j$.util.M spliterator() {
        return Spliterators.l(this.f50605a, 0, this.f50606b);
    }

    @Override // j$.util.stream.F0
    public final Spliterator spliterator() {
        return Spliterators.l(this.f50605a, 0, this.f50606b);
    }

    public String toString() {
        return String.format("LongArrayNode[%d][%s]", Integer.valueOf(this.f50605a.length - this.f50606b), Arrays.toString(this.f50605a));
    }
}
