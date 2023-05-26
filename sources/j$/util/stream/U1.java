package j$.util.stream;

import j$.util.function.Function;

/* loaded from: classes2.dex */
final class U1 extends X1 {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f50488t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ Function f50489u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ U1(AbstractC0171c abstractC0171c, int i8, Function function, int i9) {
        super(abstractC0171c, i8);
        this.f50488t = i9;
        this.f50489u = function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2) {
        switch (this.f50488t) {
            case 0:
                return new S1(this, interfaceC0193g2, 2);
            default:
                return new S1(this, interfaceC0193g2, 6);
        }
    }
}
