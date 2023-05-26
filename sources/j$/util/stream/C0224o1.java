package j$.util.stream;

import j$.util.Spliterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.o1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0224o1 extends AbstractC0235r1 implements InterfaceC0184e2 {

    /* renamed from: h  reason: collision with root package name */
    private final int[] f50631h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0224o1(Spliterator spliterator, AbstractC0254w0 abstractC0254w0, int[] iArr) {
        super(iArr.length, spliterator, abstractC0254w0);
        this.f50631h = iArr;
    }

    C0224o1(C0224o1 c0224o1, Spliterator spliterator, long j8, long j9) {
        super(c0224o1, spliterator, j8, j9, c0224o1.f50631h.length);
        this.f50631h = c0224o1.f50631h;
    }

    @Override // j$.util.stream.AbstractC0235r1
    final AbstractC0235r1 a(Spliterator spliterator, long j8, long j9) {
        return new C0224o1(this, spliterator, j8, j9);
    }

    @Override // j$.util.stream.AbstractC0235r1, j$.util.stream.InterfaceC0193g2
    public final void accept(int i8) {
        int i9 = this.f50660f;
        if (i9 >= this.f50661g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f50660f));
        }
        int[] iArr = this.f50631h;
        this.f50660f = i9 + 1;
        iArr[i9] = i8;
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        f((Integer) obj);
    }

    @Override // j$.util.stream.InterfaceC0184e2
    public final /* synthetic */ void f(Integer num) {
        AbstractC0254w0.r0(this, num);
    }

    @Override // j$.util.function.J
    public final j$.util.function.J m(j$.util.function.J j8) {
        j8.getClass();
        return new j$.util.function.G(this, j8);
    }
}
