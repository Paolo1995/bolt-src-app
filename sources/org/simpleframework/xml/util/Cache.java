package org.simpleframework.xml.util;

/* loaded from: classes5.dex */
public interface Cache<T> {
    void cache(Object obj, T t7);

    boolean contains(Object obj);

    T fetch(Object obj);

    boolean isEmpty();

    T take(Object obj);
}
