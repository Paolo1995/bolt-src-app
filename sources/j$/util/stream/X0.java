package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

/* loaded from: classes2.dex */
final class X0 extends Z0 implements D0 {
    @Override // j$.util.stream.Z0, j$.util.stream.F0
    public final E0 a(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.Z0, j$.util.stream.F0
    public final /* bridge */ /* synthetic */ F0 a(int i8) {
        a(i8);
        throw null;
    }

    @Override // j$.util.stream.E0
    public final Object b() {
        long[] jArr;
        jArr = AbstractC0254w0.f50703f;
        return jArr;
    }

    @Override // j$.util.stream.F0
    /* renamed from: e */
    public final /* synthetic */ void i(Long[] lArr, int i8) {
        AbstractC0254w0.A0(this, lArr, i8);
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ void forEach(Consumer consumer) {
        AbstractC0254w0.D0(this, consumer);
    }

    @Override // j$.util.stream.Z0, j$.util.stream.F0
    public final /* synthetic */ F0 q(long j8, long j9, IntFunction intFunction) {
        return AbstractC0254w0.G0(this, j8, j9);
    }

    @Override // j$.util.stream.F0
    public final j$.util.M spliterator() {
        return Spliterators.d();
    }

    @Override // j$.util.stream.F0
    public final Spliterator spliterator() {
        return Spliterators.d();
    }
}
