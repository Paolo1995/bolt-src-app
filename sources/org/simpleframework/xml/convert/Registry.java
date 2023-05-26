package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: classes5.dex */
public class Registry {
    private final Cache<Converter> cache = new ConcurrentCache();
    private final RegistryBinder binder = new RegistryBinder();

    private Converter create(Class cls) throws Exception {
        Converter lookup = this.binder.lookup(cls);
        if (lookup != null) {
            this.cache.cache(cls, lookup);
        }
        return lookup;
    }

    public Registry bind(Class cls, Class cls2) throws Exception {
        if (cls != null) {
            this.binder.bind(cls, cls2);
        }
        return this;
    }

    public Converter lookup(Class cls) throws Exception {
        Converter fetch = this.cache.fetch(cls);
        if (fetch == null) {
            return create(cls);
        }
        return fetch;
    }

    public Registry bind(Class cls, Converter converter) throws Exception {
        if (cls != null) {
            this.cache.cache(cls, converter);
        }
        return this;
    }
}
