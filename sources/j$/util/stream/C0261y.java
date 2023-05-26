package j$.util.stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.y  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0261y extends AbstractC0203j0 {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f50721t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ Object f50722u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0261y(AbstractC0171c abstractC0171c, int i8, Object obj, int i9) {
        super(abstractC0171c, i8);
        this.f50721t = i9;
        this.f50722u = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2) {
        switch (this.f50721t) {
            case 0:
                return new C0245u(this, interfaceC0193g2, 3);
            case 1:
                return new Y(this, interfaceC0193g2, 5);
            case 2:
                return new C0191g0(this, interfaceC0193g2, 1);
            case 3:
                return new C0191g0(this, interfaceC0193g2, 5);
            case 4:
                return new C0191g0(this, interfaceC0193g2, 6);
            case 5:
                return new C0191g0(this, interfaceC0193g2, 7);
            case 6:
                return new C0230q(this, interfaceC0193g2);
            default:
                return new S1(this, interfaceC0193g2, 4);
        }
    }
}
