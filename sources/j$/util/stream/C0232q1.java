package j$.util.stream;

import j$.util.Spliterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.q1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0232q1 extends AbstractC0235r1 {

    /* renamed from: h  reason: collision with root package name */
    private final Object[] f50646h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0232q1(Spliterator spliterator, AbstractC0254w0 abstractC0254w0, Object[] objArr) {
        super(objArr.length, spliterator, abstractC0254w0);
        this.f50646h = objArr;
    }

    C0232q1(C0232q1 c0232q1, Spliterator spliterator, long j8, long j9) {
        super(c0232q1, spliterator, j8, j9, c0232q1.f50646h.length);
        this.f50646h = c0232q1.f50646h;
    }

    @Override // j$.util.stream.AbstractC0235r1
    final AbstractC0235r1 a(Spliterator spliterator, long j8, long j9) {
        return new C0232q1(this, spliterator, j8, j9);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        int i8 = this.f50660f;
        if (i8 >= this.f50661g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f50660f));
        }
        Object[] objArr = this.f50646h;
        this.f50660f = i8 + 1;
        objArr[i8] = obj;
    }
}
