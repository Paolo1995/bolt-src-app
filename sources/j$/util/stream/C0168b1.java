package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.b1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0168b1 implements C0 {

    /* renamed from: a  reason: collision with root package name */
    final int[] f50542a;

    /* renamed from: b  reason: collision with root package name */
    int f50543b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0168b1(long j8) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50542a = new int[(int) j8];
        this.f50543b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0168b1(int[] iArr) {
        this.f50542a = iArr;
        this.f50543b = iArr.length;
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
        int[] iArr = this.f50542a;
        int length = iArr.length;
        int i8 = this.f50543b;
        return length == i8 ? iArr : Arrays.copyOf(iArr, i8);
    }

    @Override // j$.util.stream.E0
    public final void c(int i8, Object obj) {
        System.arraycopy(this.f50542a, 0, (int[]) obj, i8, this.f50543b);
    }

    @Override // j$.util.stream.F0
    public final long count() {
        return this.f50543b;
    }

    @Override // j$.util.stream.E0
    public final void d(Object obj) {
        j$.util.function.J j8 = (j$.util.function.J) obj;
        for (int i8 = 0; i8 < this.f50543b; i8++) {
            j8.accept(this.f50542a[i8]);
        }
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ void forEach(Consumer consumer) {
        AbstractC0254w0.C0(this, consumer);
    }

    @Override // j$.util.stream.F0
    /* renamed from: h */
    public final /* synthetic */ void i(Integer[] numArr, int i8) {
        AbstractC0254w0.z0(this, numArr, i8);
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
        return AbstractC0254w0.F0(this, j8, j9);
    }

    @Override // j$.util.stream.E0, j$.util.stream.F0
    public final j$.util.M spliterator() {
        return Spliterators.k(this.f50542a, 0, this.f50543b);
    }

    @Override // j$.util.stream.F0
    public final Spliterator spliterator() {
        return Spliterators.k(this.f50542a, 0, this.f50543b);
    }

    public String toString() {
        return String.format("IntArrayNode[%d][%s]", Integer.valueOf(this.f50542a.length - this.f50543b), Arrays.toString(this.f50542a));
    }
}
