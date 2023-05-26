package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class O0 extends Q0 implements C0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public O0(C0 c02, C0 c03) {
        super(c02, c03);
    }

    @Override // j$.util.stream.F0
    /* renamed from: e */
    public final /* synthetic */ void i(Integer[] numArr, int i8) {
        AbstractC0254w0.z0(this, numArr, i8);
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ void forEach(Consumer consumer) {
        AbstractC0254w0.C0(this, consumer);
    }

    @Override // j$.util.stream.E0
    public final Object newArray(int i8) {
        return new int[i8];
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ F0 q(long j8, long j9, IntFunction intFunction) {
        return AbstractC0254w0.F0(this, j8, j9);
    }

    @Override // j$.util.stream.F0
    public final j$.util.M spliterator() {
        return new C0188f1(this);
    }

    @Override // j$.util.stream.F0
    public final Spliterator spliterator() {
        return new C0188f1(this);
    }
}
