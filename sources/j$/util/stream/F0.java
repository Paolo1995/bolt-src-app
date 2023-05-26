package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public interface F0 {
    F0 a(int i8);

    long count();

    void forEach(Consumer consumer);

    void i(Object[] objArr, int i8);

    int n();

    Object[] p(IntFunction intFunction);

    F0 q(long j8, long j9, IntFunction intFunction);

    Spliterator spliterator();
}
