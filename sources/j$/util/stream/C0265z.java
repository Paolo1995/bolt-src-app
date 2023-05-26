package j$.util.stream;

/* renamed from: j$.util.stream.z  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0265z extends C {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f50727t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0265z(AbstractC0171c abstractC0171c, int i8, int i9) {
        super(abstractC0171c, i8);
        this.f50727t = i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2) {
        switch (this.f50727t) {
            case 0:
                return interfaceC0193g2;
            case 1:
                return new Y(this, interfaceC0193g2, 2);
            default:
                return new C0191g0(this, interfaceC0193g2, 0);
        }
    }
}
