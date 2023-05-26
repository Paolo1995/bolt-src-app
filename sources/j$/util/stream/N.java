package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class N extends AbstractC0176d {

    /* renamed from: j  reason: collision with root package name */
    private final H f50448j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(H h8, AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        super(abstractC0254w0, spliterator);
        this.f50448j = h8;
    }

    N(N n8, Spliterator spliterator) {
        super(n8, spliterator);
        this.f50448j = n8.f50448j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0186f
    public final Object a() {
        boolean z7;
        AbstractC0254w0 abstractC0254w0 = this.f50572a;
        C3 c32 = (C3) this.f50448j.f50407d.get();
        abstractC0254w0.v1(this.f50573b, c32);
        Object obj = c32.get();
        if (!this.f50448j.f50404a) {
            if (obj != null) {
                AtomicReference atomicReference = this.f50562h;
                while (!atomicReference.compareAndSet(null, obj) && atomicReference.get() == null) {
                }
            }
            return null;
        } else if (obj != null) {
            N n8 = this;
            while (true) {
                if (n8 != null) {
                    AbstractC0186f c8 = n8.c();
                    if (c8 != null && c8.f50575d != n8) {
                        z7 = false;
                        break;
                    }
                    n8 = c8;
                } else {
                    z7 = true;
                    break;
                }
            }
            if (z7) {
                AtomicReference atomicReference2 = this.f50562h;
                while (!atomicReference2.compareAndSet(null, obj) && atomicReference2.get() == null) {
                }
            } else {
                h();
            }
            return obj;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0186f
    public final AbstractC0186f d(Spliterator spliterator) {
        return new N(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0176d
    protected final Object i() {
        return this.f50448j.f50405b;
    }

    @Override // j$.util.stream.AbstractC0186f, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        boolean z7;
        if (this.f50448j.f50404a) {
            N n8 = (N) this.f50575d;
            N n9 = null;
            while (true) {
                if (n8 == n9) {
                    break;
                }
                Object b8 = n8.b();
                if (b8 == null || !this.f50448j.f50406c.test(b8)) {
                    n9 = n8;
                    n8 = (N) this.f50576e;
                } else {
                    e(b8);
                    N n10 = this;
                    while (true) {
                        if (n10 != null) {
                            AbstractC0186f c8 = n10.c();
                            if (c8 != null && c8.f50575d != n10) {
                                z7 = false;
                                break;
                            }
                            n10 = c8;
                        } else {
                            z7 = true;
                            break;
                        }
                    }
                    if (z7) {
                        AtomicReference atomicReference = this.f50562h;
                        while (!atomicReference.compareAndSet(null, b8) && atomicReference.get() == null) {
                        }
                    } else {
                        h();
                    }
                }
            }
        }
        super.onCompletion(countedCompleter);
    }
}
