package j$.util.stream;

import j$.util.Spliterator;
import java.util.Iterator;

/* renamed from: j$.util.stream.i  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0198i extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    boolean isParallel();

    Iterator iterator();

    InterfaceC0198i onClose(Runnable runnable);

    InterfaceC0198i parallel();

    InterfaceC0198i sequential();

    Spliterator spliterator();

    InterfaceC0198i unordered();
}
