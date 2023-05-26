package j$.util;

import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;

/* loaded from: classes2.dex */
public interface J extends M {
    void a(InterfaceC0123e0 interfaceC0123e0);

    boolean d(InterfaceC0123e0 interfaceC0123e0);

    @Override // j$.util.Spliterator
    void forEachRemaining(Consumer consumer);

    @Override // j$.util.Spliterator
    boolean tryAdvance(Consumer consumer);

    @Override // j$.util.M, j$.util.Spliterator
    J trySplit();
}
