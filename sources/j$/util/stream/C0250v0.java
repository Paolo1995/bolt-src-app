package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: j$.util.stream.v0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0250v0 extends AbstractC0176d {

    /* renamed from: j  reason: collision with root package name */
    private final C0246u0 f50692j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0250v0(C0246u0 c0246u0, AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        super(abstractC0254w0, spliterator);
        this.f50692j = c0246u0;
    }

    C0250v0(C0250v0 c0250v0, Spliterator spliterator) {
        super(c0250v0, spliterator);
        this.f50692j = c0250v0.f50692j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0186f
    public final Object a() {
        boolean z7;
        Boolean valueOf;
        AbstractC0254w0 abstractC0254w0 = this.f50572a;
        AbstractC0238s0 abstractC0238s0 = (AbstractC0238s0) this.f50692j.f50684b.get();
        abstractC0254w0.v1(this.f50573b, abstractC0238s0);
        boolean z8 = abstractC0238s0.f50671b;
        z7 = this.f50692j.f50683a.f50678b;
        if (z8 == z7 && (valueOf = Boolean.valueOf(z8)) != null) {
            AtomicReference atomicReference = this.f50562h;
            while (!atomicReference.compareAndSet(null, valueOf) && atomicReference.get() == null) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0186f
    public final AbstractC0186f d(Spliterator spliterator) {
        return new C0250v0(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0176d
    protected final Object i() {
        boolean z7;
        z7 = this.f50692j.f50683a.f50678b;
        return Boolean.valueOf(!z7);
    }
}
