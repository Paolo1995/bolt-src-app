package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LazySet<T> implements Provider<Set<T>> {

    /* renamed from: b  reason: collision with root package name */
    private volatile Set<T> f15498b = null;

    /* renamed from: a  reason: collision with root package name */
    private volatile Set<Provider<T>> f15497a = Collections.newSetFromMap(new ConcurrentHashMap());

    LazySet(Collection<Provider<T>> collection) {
        this.f15497a.addAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LazySet<?> b(Collection<Provider<?>> collection) {
        return new LazySet<>((Set) collection);
    }

    private synchronized void d() {
        for (Provider<T> provider : this.f15497a) {
            this.f15498b.add(provider.get());
        }
        this.f15497a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Provider<T> provider) {
        if (this.f15498b == null) {
            this.f15497a.add(provider);
        } else {
            this.f15498b.add(provider.get());
        }
    }

    @Override // com.google.firebase.inject.Provider
    /* renamed from: c */
    public Set<T> get() {
        if (this.f15498b == null) {
            synchronized (this) {
                if (this.f15498b == null) {
                    this.f15498b = Collections.newSetFromMap(new ConcurrentHashMap());
                    d();
                }
            }
        }
        return Collections.unmodifiableSet(this.f15498b);
    }
}
