package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* loaded from: classes.dex */
abstract class AbstractComponentContainer implements ComponentContainer {
    @Override // com.google.firebase.components.ComponentContainer
    public <T> Set<T> b(Class<T> cls) {
        return a(cls).get();
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> T get(Class<T> cls) {
        Provider<T> c8 = c(cls);
        if (c8 == null) {
            return null;
        }
        return c8.get();
    }
}
