package j$.util.stream;

import j$.util.function.InterfaceC0128h;

/* renamed from: j$.util.stream.y1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0263y1 extends AbstractC0254w0 {

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ InterfaceC0128h f50723h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ double f50724i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0263y1(int i8, InterfaceC0128h interfaceC0128h, double d8) {
        super(i8);
        this.f50723h = interfaceC0128h;
        this.f50724i = d8;
    }

    @Override // j$.util.stream.AbstractC0254w0
    public final P1 t1() {
        return new C0267z1(this.f50724i, this.f50723h);
    }
}
