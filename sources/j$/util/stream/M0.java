package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.InterfaceC0120d;
import j$.util.function.InterfaceC0129h0;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class M0 extends AbstractC0186f {

    /* renamed from: h  reason: collision with root package name */
    protected final AbstractC0254w0 f50442h;

    /* renamed from: i  reason: collision with root package name */
    protected final InterfaceC0129h0 f50443i;

    /* renamed from: j  reason: collision with root package name */
    protected final InterfaceC0120d f50444j;

    M0(M0 m02, Spliterator spliterator) {
        super(m02, spliterator);
        this.f50442h = m02.f50442h;
        this.f50443i = m02.f50443i;
        this.f50444j = m02.f50444j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public M0(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, InterfaceC0129h0 interfaceC0129h0, InterfaceC0120d interfaceC0120d) {
        super(abstractC0254w0, spliterator);
        this.f50442h = abstractC0254w0;
        this.f50443i = interfaceC0129h0;
        this.f50444j = interfaceC0120d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0186f
    public final Object a() {
        A0 a02 = (A0) this.f50443i.apply(this.f50442h.Z0(this.f50573b));
        this.f50442h.v1(this.f50573b, a02);
        return a02.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0186f
    public final AbstractC0186f d(Spliterator spliterator) {
        return new M0(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0186f, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        AbstractC0186f abstractC0186f = this.f50575d;
        if (!(abstractC0186f == null)) {
            e((F0) this.f50444j.apply((F0) ((M0) abstractC0186f).b(), (F0) ((M0) this.f50576e).b()));
        }
        super.onCompletion(countedCompleter);
    }
}
