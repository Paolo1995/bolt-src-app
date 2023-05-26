package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.s1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0239s1 extends Q2 implements F0, A0 {
    @Override // j$.util.stream.F0
    public final F0 a(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(int i8) {
        AbstractC0254w0.v0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(long j8) {
        AbstractC0254w0.w0();
        throw null;
    }

    @Override // j$.util.stream.Q2, j$.util.function.Consumer
    public final void accept(Object obj) {
        super.accept(obj);
    }

    @Override // j$.util.stream.A0
    public final F0 build() {
        return this;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        clear();
        r(j8);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void end() {
    }

    @Override // j$.util.stream.Q2, j$.util.stream.F0
    public final void forEach(Consumer consumer) {
        super.forEach(consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.stream.F0
    public final void i(Object[] objArr, int i8) {
        long j8 = i8;
        long count = count() + j8;
        if (count > objArr.length || count < j8) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.f50568c == 0) {
            System.arraycopy(this.f50467e, 0, objArr, i8, this.f50567b);
            return;
        }
        for (int i9 = 0; i9 < this.f50568c; i9++) {
            Object[] objArr2 = this.f50468f[i9];
            System.arraycopy(objArr2, 0, objArr, i8, objArr2.length);
            i8 += this.f50468f[i9].length;
        }
        int i10 = this.f50567b;
        if (i10 > 0) {
            System.arraycopy(this.f50467e, 0, objArr, i8, i10);
        }
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ int n() {
        return 0;
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
    public final /* synthetic */ F0 q(long j8, long j9, IntFunction intFunction) {
        return AbstractC0254w0.H0(this, j8, j9, intFunction);
    }

    @Override // j$.util.stream.Q2, java.lang.Iterable
    public final Spliterator spliterator() {
        return super.spliterator();
    }
}
