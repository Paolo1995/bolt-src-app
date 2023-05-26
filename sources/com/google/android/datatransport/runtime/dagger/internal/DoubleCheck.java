package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f12152c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Provider<T> f12153a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f12154b = f12152c;

    private DoubleCheck(Provider<T> provider) {
        this.f12153a = provider;
    }

    public static <P extends Provider<T>, T> Lazy<T> a(P p8) {
        if (p8 instanceof Lazy) {
            return (Lazy) p8;
        }
        return new DoubleCheck((Provider) Preconditions.b(p8));
    }

    public static <P extends Provider<T>, T> Provider<T> b(P p8) {
        Preconditions.b(p8);
        if (p8 instanceof DoubleCheck) {
            return p8;
        }
        return new DoubleCheck(p8);
    }

    public static Object c(Object obj, Object obj2) {
        boolean z7;
        if (obj != f12152c && !(obj instanceof MemoizedSentinel)) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 && obj != obj2) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
        }
        return obj2;
    }

    @Override // javax.inject.Provider
    public T get() {
        T t7 = (T) this.f12154b;
        Object obj = f12152c;
        if (t7 == obj) {
            synchronized (this) {
                t7 = this.f12154b;
                if (t7 == obj) {
                    t7 = this.f12153a.get();
                    this.f12154b = c(this.f12154b, t7);
                    this.f12153a = null;
                }
            }
        }
        return t7;
    }
}
