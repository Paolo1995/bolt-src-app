package j$.util.stream;

import j$.util.Comparator;
import j$.util.Spliterator;
import j$.util.function.IntFunction;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class B2 extends W1 {

    /* renamed from: t  reason: collision with root package name */
    private final boolean f50372t;

    /* renamed from: u  reason: collision with root package name */
    private final Comparator f50373u;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B2(AbstractC0171c abstractC0171c) {
        super(abstractC0171c, U2.f50501q | U2.f50499o);
        this.f50372t = true;
        this.f50373u = Comparator.CC.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public B2(AbstractC0171c abstractC0171c, java.util.Comparator comparator) {
        super(abstractC0171c, U2.f50501q | U2.f50500p);
        this.f50372t = false;
        comparator.getClass();
        this.f50373u = comparator;
    }

    @Override // j$.util.stream.AbstractC0171c
    public final F0 G1(Spliterator spliterator, IntFunction intFunction, AbstractC0171c abstractC0171c) {
        if (U2.SORTED.h(abstractC0171c.f1()) && this.f50372t) {
            return abstractC0171c.x1(spliterator, false, intFunction);
        }
        Object[] p8 = abstractC0171c.x1(spliterator, true, intFunction).p(intFunction);
        Arrays.sort(p8, this.f50373u);
        return new I0(p8);
    }

    @Override // j$.util.stream.AbstractC0171c
    public final InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2) {
        interfaceC0193g2.getClass();
        return (U2.SORTED.h(i8) && this.f50372t) ? interfaceC0193g2 : U2.SIZED.h(i8) ? new G2(interfaceC0193g2, this.f50373u) : new C2(interfaceC0193g2, this.f50373u);
    }
}
