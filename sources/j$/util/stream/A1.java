package j$.util.stream;

import j$.util.function.InterfaceC0115a0;
import j$.util.function.InterfaceC0120d;
import j$.util.function.InterfaceC0128h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class A1 extends AbstractC0254w0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f50365h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Object f50366i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A1(int i8, Object obj, int i9) {
        super(i8);
        this.f50365h = i9;
        this.f50366i = obj;
    }

    @Override // j$.util.stream.AbstractC0254w0
    public final P1 t1() {
        switch (this.f50365h) {
            case 0:
                return new B1((InterfaceC0128h) this.f50366i);
            case 1:
                return new E1((InterfaceC0120d) this.f50366i);
            case 2:
                return new K1((j$.util.function.F) this.f50366i);
            default:
                return new O1((InterfaceC0115a0) this.f50366i);
        }
    }
}
