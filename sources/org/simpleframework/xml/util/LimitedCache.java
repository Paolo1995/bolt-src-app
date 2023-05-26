package org.simpleframework.xml.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class LimitedCache<T> extends LinkedHashMap<Object, T> implements Cache<T> {
    private final int capacity;

    public LimitedCache() {
        this(50000);
    }

    @Override // org.simpleframework.xml.util.Cache
    public void cache(Object obj, T t7) {
        put(obj, t7);
    }

    @Override // org.simpleframework.xml.util.Cache
    public boolean contains(Object obj) {
        return containsKey(obj);
    }

    @Override // org.simpleframework.xml.util.Cache
    public T fetch(Object obj) {
        return get(obj);
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<Object, T> entry) {
        if (size() > this.capacity) {
            return true;
        }
        return false;
    }

    @Override // org.simpleframework.xml.util.Cache
    public T take(Object obj) {
        return remove(obj);
    }

    public LimitedCache(int i8) {
        this.capacity = i8;
    }
}
