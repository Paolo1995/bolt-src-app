package j$.util.concurrent.atomic;

import j$.util.function.LongUnaryOperator;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class DesugarAtomicLong {
    public static long updateAndGet(AtomicLong atomicLong, LongUnaryOperator longUnaryOperator) {
        long j8;
        long applyAsLong;
        do {
            j8 = atomicLong.get();
            applyAsLong = longUnaryOperator.applyAsLong(j8);
        } while (!atomicLong.compareAndSet(j8, applyAsLong));
        return applyAsLong;
    }
}
