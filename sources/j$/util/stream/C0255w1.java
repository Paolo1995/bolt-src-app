package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.InterfaceC0120d;
import j$.util.function.Supplier;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.w1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0255w1 extends AbstractC0254w0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f50705h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Object f50706i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Object f50707j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Object f50708k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0255w1(int i8, Object obj, Object obj2, Object obj3, int i9) {
        super(i8);
        this.f50705h = i9;
        this.f50706i = obj;
        this.f50708k = obj2;
        this.f50707j = obj3;
    }

    @Override // j$.util.stream.AbstractC0254w0
    public final P1 t1() {
        switch (this.f50705h) {
            case 0:
                return new C0259x1((Supplier) this.f50707j, (j$.util.function.C0) this.f50708k, (InterfaceC0120d) this.f50706i);
            case 1:
                return new C1((Supplier) this.f50707j, (j$.util.function.w0) this.f50708k, (InterfaceC0120d) this.f50706i);
            case 2:
                return new D1(this.f50707j, (BiFunction) this.f50708k, (InterfaceC0120d) this.f50706i);
            case 3:
                return new H1((Supplier) this.f50707j, (BiConsumer) this.f50708k, (BiConsumer) this.f50706i);
            default:
                return new L1((Supplier) this.f50707j, (j$.util.function.z0) this.f50708k, (InterfaceC0120d) this.f50706i);
        }
    }
}
