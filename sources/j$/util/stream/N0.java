package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class N0 extends Q0 implements B0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public N0(B0 b02, B0 b03) {
        super(b02, b03);
    }

    @Override // j$.util.stream.F0
    /* renamed from: e */
    public final /* synthetic */ void i(Double[] dArr, int i8) {
        AbstractC0254w0.y0(this, dArr, i8);
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ void forEach(Consumer consumer) {
        AbstractC0254w0.B0(this, consumer);
    }

    @Override // j$.util.stream.E0
    public final Object newArray(int i8) {
        return new double[i8];
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ F0 q(long j8, long j9, IntFunction intFunction) {
        return AbstractC0254w0.E0(this, j8, j9);
    }

    @Override // j$.util.stream.F0
    public final j$.util.M spliterator() {
        return new C0183e1(this);
    }

    @Override // j$.util.stream.F0
    public final Spliterator spliterator() {
        return new C0183e1(this);
    }
}
