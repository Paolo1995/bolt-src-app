package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;
import java.util.Arrays;

/* renamed from: j$.util.stream.z2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0268z2 extends AbstractC0172c0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0268z2(AbstractC0171c abstractC0171c) {
        super(abstractC0171c, U2.f50501q | U2.f50499o);
    }

    @Override // j$.util.stream.AbstractC0171c
    public final F0 G1(Spliterator spliterator, IntFunction intFunction, AbstractC0171c abstractC0171c) {
        if (U2.SORTED.h(abstractC0171c.f1())) {
            return abstractC0171c.x1(spliterator, false, intFunction);
        }
        int[] iArr = (int[]) ((C0) abstractC0171c.x1(spliterator, true, intFunction)).b();
        Arrays.sort(iArr);
        return new C0168b1(iArr);
    }

    @Override // j$.util.stream.AbstractC0171c
    public final InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2) {
        interfaceC0193g2.getClass();
        return U2.SORTED.h(i8) ? interfaceC0193g2 : U2.SIZED.h(i8) ? new E2(interfaceC0193g2) : new C0256w2(interfaceC0193g2);
    }
}
