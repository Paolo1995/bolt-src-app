package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.IntFunction;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r extends W1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r(AbstractC0171c abstractC0171c, int i8) {
        super(abstractC0171c, i8);
    }

    static J0 O1(AbstractC0171c abstractC0171c, Spliterator spliterator) {
        L0 l02 = new L0(15);
        return new J0((Collection) new C0255w1(1, new L0(17), new L0(16), l02, 3).y(abstractC0171c, spliterator));
    }

    @Override // j$.util.stream.AbstractC0171c
    final F0 G1(Spliterator spliterator, IntFunction intFunction, AbstractC0171c abstractC0171c) {
        if (U2.DISTINCT.h(abstractC0171c.f1())) {
            return abstractC0171c.x1(spliterator, false, intFunction);
        }
        if (U2.ORDERED.h(abstractC0171c.f1())) {
            return O1(abstractC0171c, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        new S(new C0222o(0, atomicBoolean, concurrentHashMap), false).y(abstractC0171c, spliterator);
        Collection keySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(keySet);
            hashSet.add(null);
            keySet = hashSet;
        }
        return new J0(keySet);
    }

    @Override // j$.util.stream.AbstractC0171c
    final Spliterator H1(AbstractC0171c abstractC0171c, Spliterator spliterator) {
        return U2.DISTINCT.h(abstractC0171c.f1()) ? abstractC0171c.N1(spliterator) : U2.ORDERED.h(abstractC0171c.f1()) ? O1(abstractC0171c, spliterator).spliterator() : new C0175c3(abstractC0171c.N1(spliterator));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractC0171c
    public final InterfaceC0193g2 J1(int i8, InterfaceC0193g2 interfaceC0193g2) {
        interfaceC0193g2.getClass();
        return U2.DISTINCT.h(i8) ? interfaceC0193g2 : U2.SORTED.h(i8) ? new C0226p(interfaceC0193g2) : new C0230q(this, interfaceC0193g2);
    }
}
