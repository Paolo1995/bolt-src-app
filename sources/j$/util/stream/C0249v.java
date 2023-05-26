package j$.util.stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.v  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0249v extends C {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f50690t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ Object f50691u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0249v(AbstractC0171c abstractC0171c, int i8, Object obj, int i9) {
        super(abstractC0171c, i8);
        this.f50690t = i9;
        this.f50691u = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2) {
        switch (this.f50690t) {
            case 0:
                return new C0245u(this, interfaceC0193g2, 0);
            case 1:
                return new C0245u(this, interfaceC0193g2, 4);
            case 2:
                return new C0245u(this, interfaceC0193g2, 5);
            case 3:
                return new C0245u(this, interfaceC0193g2, 6);
            case 4:
                return new Y(this, interfaceC0193g2, 6);
            case 5:
                return new C0191g0(this, interfaceC0193g2, 4);
            case 6:
                return new S1(this, interfaceC0193g2, 5);
            default:
                return new C0230q(this, interfaceC0193g2);
        }
    }
}
