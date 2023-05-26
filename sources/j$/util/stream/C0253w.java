package j$.util.stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.w  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0253w extends X1 {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f50696t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ Object f50697u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0253w(AbstractC0171c abstractC0171c, int i8, Object obj, int i9) {
        super(abstractC0171c, i8);
        this.f50696t = i9;
        this.f50697u = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2) {
        switch (this.f50696t) {
            case 0:
                return new C0245u(this, interfaceC0193g2, 1);
            case 1:
                return new Y(this, interfaceC0193g2, 4);
            case 2:
                return new C0191g0(this, interfaceC0193g2, 2);
            case 3:
                return new S1(this, interfaceC0193g2, 0);
            default:
                return new S1(this, interfaceC0193g2, 1);
        }
    }
}
