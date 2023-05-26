package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

/* loaded from: classes.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final InstanceFactory<Object> f12155b = new InstanceFactory<>(null);

    /* renamed from: a  reason: collision with root package name */
    private final T f12156a;

    private InstanceFactory(T t7) {
        this.f12156a = t7;
    }

    public static <T> Factory<T> a(T t7) {
        return new InstanceFactory(Preconditions.c(t7, "instance cannot be null"));
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.f12156a;
    }
}
