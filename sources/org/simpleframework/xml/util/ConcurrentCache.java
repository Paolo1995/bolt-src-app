package org.simpleframework.xml.util;

import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class ConcurrentCache<T> extends ConcurrentHashMap<Object, T> implements Cache<T> {
    @Override // org.simpleframework.xml.util.Cache
    public void cache(Object obj, T t7) {
        put(obj, t7);
    }

    @Override // j$.util.concurrent.ConcurrentHashMap, org.simpleframework.xml.util.Cache
    public boolean contains(Object obj) {
        return containsKey(obj);
    }

    @Override // org.simpleframework.xml.util.Cache
    public T fetch(Object obj) {
        return get(obj);
    }

    @Override // org.simpleframework.xml.util.Cache
    public T take(Object obj) {
        return remove(obj);
    }
}
