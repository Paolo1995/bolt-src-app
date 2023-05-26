package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private DoubleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public static <P extends Provider<T>, T> Lazy<T> lazy(P p8) {
        if (p8 instanceof Lazy) {
            return (Lazy) p8;
        }
        return new DoubleCheck((Provider) Preconditions.checkNotNull(p8));
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p8) {
        Preconditions.checkNotNull(p8);
        if (p8 instanceof DoubleCheck) {
            return p8;
        }
        return new DoubleCheck(p8);
    }

    private static Object reentrantCheck(Object obj, Object obj2) {
        boolean z7;
        if (obj != UNINITIALIZED) {
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
        T t7 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t7 == obj) {
            synchronized (this) {
                t7 = this.instance;
                if (t7 == obj) {
                    t7 = this.provider.get();
                    this.instance = reentrantCheck(this.instance, t7);
                    this.provider = null;
                }
            }
        }
        return t7;
    }
}
