package j$.util;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
public interface G extends M {
    void b(j$.util.function.J j8);

    @Override // j$.util.Spliterator
    void forEachRemaining(Consumer consumer);

    boolean i(j$.util.function.J j8);

    @Override // j$.util.Spliterator
    boolean tryAdvance(Consumer consumer);

    @Override // j$.util.M, j$.util.Spliterator
    G trySplit();
}
