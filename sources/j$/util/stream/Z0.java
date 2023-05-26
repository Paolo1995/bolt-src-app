package j$.util.stream;

import j$.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Z0 implements F0 {
    @Override // j$.util.stream.F0
    public F0 a(int i8) {
        throw new IndexOutOfBoundsException();
    }

    public final void c(int i8, Object obj) {
    }

    @Override // j$.util.stream.F0
    public final long count() {
        return 0L;
    }

    public final void d(Object obj) {
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ int n() {
        return 0;
    }

    @Override // j$.util.stream.F0
    public final Object[] p(IntFunction intFunction) {
        return (Object[]) intFunction.apply(0);
    }

    @Override // j$.util.stream.F0
    public /* synthetic */ F0 q(long j8, long j9, IntFunction intFunction) {
        return AbstractC0254w0.H0(this, j8, j9, intFunction);
    }
}
