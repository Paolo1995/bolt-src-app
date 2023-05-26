package j$.util.stream;

import j$.util.function.InterfaceC0115a0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class M1 extends AbstractC0254w0 {

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ InterfaceC0115a0 f50445h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ long f50446i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M1(int i8, InterfaceC0115a0 interfaceC0115a0, long j8) {
        super(i8);
        this.f50445h = interfaceC0115a0;
        this.f50446i = j8;
    }

    @Override // j$.util.stream.AbstractC0254w0
    public final P1 t1() {
        return new N1(this.f50446i, this.f50445h);
    }
}
