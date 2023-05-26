package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GlideExperiments {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, Object> f9768a;

    /* loaded from: classes.dex */
    static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, Object> f9769a = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        public GlideExperiments b() {
            return new GlideExperiments(this);
        }
    }

    GlideExperiments(Builder builder) {
        this.f9768a = Collections.unmodifiableMap(new HashMap(builder.f9769a));
    }

    public boolean a(Class<Object> cls) {
        return this.f9768a.containsKey(cls);
    }
}
