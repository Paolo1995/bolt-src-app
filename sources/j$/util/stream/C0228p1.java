package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0117b0;
import j$.util.function.InterfaceC0123e0;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.p1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0228p1 extends AbstractC0235r1 implements InterfaceC0189f2 {

    /* renamed from: h  reason: collision with root package name */
    private final long[] f50639h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0228p1(Spliterator spliterator, AbstractC0254w0 abstractC0254w0, long[] jArr) {
        super(jArr.length, spliterator, abstractC0254w0);
        this.f50639h = jArr;
    }

    C0228p1(C0228p1 c0228p1, Spliterator spliterator, long j8, long j9) {
        super(c0228p1, spliterator, j8, j9, c0228p1.f50639h.length);
        this.f50639h = c0228p1.f50639h;
    }

    @Override // j$.util.stream.AbstractC0235r1
    final AbstractC0235r1 a(Spliterator spliterator, long j8, long j9) {
        return new C0228p1(this, spliterator, j8, j9);
    }

    @Override // j$.util.stream.AbstractC0235r1, j$.util.stream.InterfaceC0193g2
    public final void accept(long j8) {
        int i8 = this.f50660f;
        if (i8 >= this.f50661g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f50660f));
        }
        long[] jArr = this.f50639h;
        this.f50660f = i8 + 1;
        jArr[i8] = j8;
    }

    @Override // j$.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        k((Long) obj);
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }

    @Override // j$.util.stream.InterfaceC0189f2
    public final /* synthetic */ void k(Long l8) {
        AbstractC0254w0.t0(this, l8);
    }
}
