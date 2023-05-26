package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class R1 extends AbstractC0186f {

    /* renamed from: h  reason: collision with root package name */
    private final AbstractC0254w0 f50469h;

    R1(R1 r12, Spliterator spliterator) {
        super(r12, spliterator);
        this.f50469h = r12.f50469h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public R1(AbstractC0254w0 abstractC0254w0, AbstractC0254w0 abstractC0254w02, Spliterator spliterator) {
        super(abstractC0254w02, spliterator);
        this.f50469h = abstractC0254w0;
    }

    @Override // j$.util.stream.AbstractC0186f
    protected final Object a() {
        AbstractC0254w0 abstractC0254w0 = this.f50572a;
        P1 t12 = this.f50469h.t1();
        abstractC0254w0.v1(this.f50573b, t12);
        return t12;
    }

    @Override // j$.util.stream.AbstractC0186f
    protected final AbstractC0186f d(Spliterator spliterator) {
        return new R1(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0186f, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        AbstractC0186f abstractC0186f = this.f50575d;
        if (!(abstractC0186f == null)) {
            P1 p12 = (P1) ((R1) abstractC0186f).b();
            p12.j((P1) ((R1) this.f50576e).b());
            e(p12);
        }
        super.onCompletion(countedCompleter);
    }
}
