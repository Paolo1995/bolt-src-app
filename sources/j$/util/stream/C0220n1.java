package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0130i;
import j$.util.function.InterfaceC0135l;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.n1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0220n1 extends AbstractC0235r1 implements InterfaceC0179d2 {

    /* renamed from: h  reason: collision with root package name */
    private final double[] f50621h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0220n1(Spliterator spliterator, AbstractC0254w0 abstractC0254w0, double[] dArr) {
        super(dArr.length, spliterator, abstractC0254w0);
        this.f50621h = dArr;
    }

    C0220n1(C0220n1 c0220n1, Spliterator spliterator, long j8, long j9) {
        super(c0220n1, spliterator, j8, j9, c0220n1.f50621h.length);
        this.f50621h = c0220n1.f50621h;
    }

    @Override // j$.util.stream.AbstractC0235r1
    final AbstractC0235r1 a(Spliterator spliterator, long j8, long j9) {
        return new C0220n1(this, spliterator, j8, j9);
    }

    @Override // j$.util.stream.AbstractC0235r1, j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        int i8 = this.f50660f;
        if (i8 >= this.f50661g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f50660f));
        }
        double[] dArr = this.f50621h;
        this.f50660f = i8 + 1;
        dArr[i8] = d8;
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Double) obj);
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0130i(this, interfaceC0135l);
    }

    @Override // j$.util.stream.InterfaceC0179d2
    public final /* synthetic */ void o(Double d8) {
        AbstractC0254w0.p0(this, d8);
    }
}
