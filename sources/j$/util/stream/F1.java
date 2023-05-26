package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.InterfaceC0120d;
import j$.util.function.Supplier;

/* loaded from: classes2.dex */
final class F1 extends AbstractC0254w0 {

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ InterfaceC0120d f50392h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ BiConsumer f50393i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Supplier f50394j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ InterfaceC0214m f50395k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F1(int i8, InterfaceC0120d interfaceC0120d, BiConsumer biConsumer, Supplier supplier, InterfaceC0214m interfaceC0214m) {
        super(i8);
        this.f50392h = interfaceC0120d;
        this.f50393i = biConsumer;
        this.f50394j = supplier;
        this.f50395k = interfaceC0214m;
    }

    @Override // j$.util.stream.AbstractC0254w0, j$.util.stream.B3
    public final int O() {
        if (((C0206k) this.f50395k).b().contains(EnumC0202j.UNORDERED)) {
            return U2.f50502r;
        }
        return 0;
    }

    @Override // j$.util.stream.AbstractC0254w0
    public final P1 t1() {
        return new G1(this.f50394j, this.f50393i, this.f50392h);
    }
}
