package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* loaded from: classes.dex */
public interface ComponentContainer {
    <T> Provider<Set<T>> a(Class<T> cls);

    <T> Set<T> b(Class<T> cls);

    <T> Provider<T> c(Class<T> cls);

    <T> Deferred<T> d(Class<T> cls);

    <T> T get(Class<T> cls);
}
