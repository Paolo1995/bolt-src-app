package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class P0 extends Q0 implements D0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public P0(D0 d02, D0 d03) {
        super(d02, d03);
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

    @Override // j$.util.stream.E0
    public final Object newArray(int i8) {
        return new long[i8];
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ F0 q(long j8, long j9, IntFunction intFunction) {
        return AbstractC0254w0.G0(this, j8, j9);
    }

    @Override // j$.util.stream.F0
    public final j$.util.M spliterator() {
        return new C0192g1(this);
    }

    @Override // j$.util.stream.F0
    public final Spliterator spliterator() {
        return new C0192g1(this);
    }
}
