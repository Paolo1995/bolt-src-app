package j$.util;

import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Stream;

/* renamed from: j$.util.a  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0106a {
    void forEach(Consumer consumer);

    boolean removeIf(Predicate predicate);

    Spliterator spliterator();

    Stream stream();
}
