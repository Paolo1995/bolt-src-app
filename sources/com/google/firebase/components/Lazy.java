package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes.dex */
public class Lazy<T> implements Provider<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f15494c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f15495a = f15494c;

    /* renamed from: b  reason: collision with root package name */
    private volatile Provider<T> f15496b;

    public Lazy(Provider<T> provider) {
        this.f15496b = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t7 = (T) this.f15495a;
        Object obj = f15494c;
        if (t7 == obj) {
            synchronized (this) {
                t7 = this.f15495a;
                if (t7 == obj) {
                    t7 = this.f15496b.get();
                    this.f15495a = t7;
                    this.f15496b = null;
                }
            }
        }
        return t7;
    }
}
