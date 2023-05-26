package j$.util;

import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;

/* loaded from: classes2.dex */
public interface D extends M {
    void c(InterfaceC0135l interfaceC0135l);

    @Override // j$.util.Spliterator
    void forEachRemaining(Consumer consumer);

    boolean n(InterfaceC0135l interfaceC0135l);

    @Override // j$.util.Spliterator
    boolean tryAdvance(Consumer consumer);

    @Override // j$.util.M, j$.util.Spliterator
    D trySplit();
}
