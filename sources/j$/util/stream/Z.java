package j$.util.stream;

/* loaded from: classes2.dex */
final class Z extends AbstractC0203j0 {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f50534t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Z(AbstractC0171c abstractC0171c, int i8, int i9) {
        super(abstractC0171c, i8);
        this.f50534t = i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2) {
        switch (this.f50534t) {
            case 0:
                return new Y(this, interfaceC0193g2, 0);
            default:
                return interfaceC0193g2;
        }
    }
}
