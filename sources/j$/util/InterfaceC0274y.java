package j$.util;

import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;

/* renamed from: j$.util.y  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0274y extends InterfaceC0275z {
    void a(InterfaceC0123e0 interfaceC0123e0);

    void forEachRemaining(Consumer consumer);

    @Override // java.util.Iterator, j$.util.Iterator
    Long next();

    long nextLong();
}
