package j$.util.stream;

import j$.util.function.C0117b0;
import j$.util.function.InterfaceC0123e0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Q extends T implements InterfaceC0189f2 {

    /* renamed from: b  reason: collision with root package name */
    final InterfaceC0123e0 f50465b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(InterfaceC0123e0 interfaceC0123e0, boolean z7) {
        super(z7);
        this.f50465b = interfaceC0123e0;
    }

    @Override // j$.util.stream.T, j$.util.stream.InterfaceC0193g2
    public final void accept(long j8) {
        this.f50465b.accept(j8);
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
