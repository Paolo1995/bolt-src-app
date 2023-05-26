package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: j$.util.stream.d  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0176d extends AbstractC0186f {

    /* renamed from: h  reason: collision with root package name */
    protected final AtomicReference f50562h;

    /* renamed from: i  reason: collision with root package name */
    protected volatile boolean f50563i;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0176d(AbstractC0176d abstractC0176d, Spliterator spliterator) {
        super(abstractC0176d, spliterator);
        this.f50562h = abstractC0176d.f50562h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0176d(AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        super(abstractC0254w0, spliterator);
        this.f50562h = new AtomicReference(null);
    }

    @Override // j$.util.stream.AbstractC0186f
    public final Object b() {
        if (c() == null) {
            Object obj = this.f50562h.get();
            return obj == null ? i() : obj;
        }
        return super.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
        r8 = r7.a();
     */
    @Override // j$.util.stream.AbstractC0186f, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void compute() {
        /*
            r10 = this;
            j$.util.Spliterator r0 = r10.f50573b
            long r1 = r0.estimateSize()
            long r3 = r10.f50574c
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto Lf
            goto L15
        Lf:
            long r3 = j$.util.stream.AbstractC0186f.f(r1)
            r10.f50574c = r3
        L15:
            java.util.concurrent.atomic.AtomicReference r5 = r10.f50562h
            r6 = 0
            r7 = r10
        L19:
            java.lang.Object r8 = r5.get()
            if (r8 != 0) goto L6f
            boolean r8 = r7.f50563i
            if (r8 != 0) goto L34
            j$.util.stream.f r9 = r7.c()
        L27:
            j$.util.stream.d r9 = (j$.util.stream.AbstractC0176d) r9
            if (r8 != 0) goto L34
            if (r9 == 0) goto L34
            boolean r8 = r9.f50563i
            j$.util.stream.f r9 = r9.c()
            goto L27
        L34:
            if (r8 == 0) goto L3b
            java.lang.Object r8 = r7.i()
            goto L6f
        L3b:
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 <= 0) goto L6b
            j$.util.Spliterator r1 = r0.trySplit()
            if (r1 != 0) goto L46
            goto L6b
        L46:
            j$.util.stream.f r2 = r7.d(r1)
            j$.util.stream.d r2 = (j$.util.stream.AbstractC0176d) r2
            r7.f50575d = r2
            j$.util.stream.f r8 = r7.d(r0)
            j$.util.stream.d r8 = (j$.util.stream.AbstractC0176d) r8
            r7.f50576e = r8
            r9 = 1
            r7.setPendingCount(r9)
            if (r6 == 0) goto L60
            r0 = r1
            r7 = r2
            r2 = r8
            goto L61
        L60:
            r7 = r8
        L61:
            r6 = r6 ^ 1
            r2.fork()
            long r1 = r0.estimateSize()
            goto L19
        L6b:
            java.lang.Object r8 = r7.a()
        L6f:
            r7.e(r8)
            r7.tryComplete()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.AbstractC0176d.compute():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0186f
    public final void e(Object obj) {
        if (!(c() == null)) {
            super.e(obj);
        } else if (obj != null) {
            AtomicReference atomicReference = this.f50562h;
            while (!atomicReference.compareAndSet(null, obj) && atomicReference.get() == null) {
            }
        }
    }

    protected void g() {
        this.f50563i = true;
    }

    @Override // j$.util.stream.AbstractC0186f, java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public final Object getRawResult() {
        return b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        AbstractC0176d abstractC0176d = this;
        for (AbstractC0176d abstractC0176d2 = (AbstractC0176d) c(); abstractC0176d2 != null; abstractC0176d2 = (AbstractC0176d) abstractC0176d2.c()) {
            if (abstractC0176d2.f50575d == abstractC0176d) {
                AbstractC0176d abstractC0176d3 = (AbstractC0176d) abstractC0176d2.f50576e;
                if (!abstractC0176d3.f50563i) {
                    abstractC0176d3.g();
                }
            }
            abstractC0176d = abstractC0176d2;
        }
    }

    protected abstract Object i();
}
