package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class I0 implements F0 {

    /* renamed from: a  reason: collision with root package name */
    final Object[] f50420a;

    /* renamed from: b  reason: collision with root package name */
    int f50421b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I0(long j8, IntFunction intFunction) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50420a = (Object[]) intFunction.apply((int) j8);
        this.f50421b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public I0(Object[] objArr) {
        this.f50420a = objArr;
        this.f50421b = objArr.length;
    }

    @Override // j$.util.stream.F0
    public final F0 a(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.F0
    public final long count() {
        return this.f50421b;
    }

    @Override // j$.util.stream.F0
    public final void forEach(Consumer consumer) {
        for (int i8 = 0; i8 < this.f50421b; i8++) {
            consumer.accept(this.f50420a[i8]);
        }
    }

    @Override // j$.util.stream.F0
    public final void i(Object[] objArr, int i8) {
        System.arraycopy(this.f50420a, 0, objArr, i8, this.f50421b);
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ int n() {
        return 0;
    }

    @Override // j$.util.stream.F0
    public final Object[] p(IntFunction intFunction) {
        Object[] objArr = this.f50420a;
        if (objArr.length == this.f50421b) {
            return objArr;
        }
        throw new IllegalStateException();
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ F0 q(long j8, long j9, IntFunction intFunction) {
        return AbstractC0254w0.H0(this, j8, j9, intFunction);
    }

    @Override // j$.util.stream.F0
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this.f50420a, 0, this.f50421b, 1040);
    }

    public String toString() {
        return String.format("ArrayNode[%d][%s]", Integer.valueOf(this.f50420a.length - this.f50421b), Arrays.toString(this.f50420a));
    }
}
