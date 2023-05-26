package j$.util.concurrent.atomic;

import j$.util.function.UnaryOperator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class DesugarAtomicReference {
    public static <V> V updateAndGet(AtomicReference<V> atomicReference, UnaryOperator<V> unaryOperator) {
        V v7;
        boolean z7;
        do {
            V v8 = atomicReference.get();
            v7 = (V) unaryOperator.apply(v8);
            while (true) {
                if (!atomicReference.compareAndSet(v8, v7)) {
                    if (atomicReference.get() != v8) {
                        z7 = false;
                        continue;
                        break;
                    }
                } else {
                    z7 = true;
                    continue;
                    break;
                }
            }
        } while (!z7);
        return v7;
    }
}
