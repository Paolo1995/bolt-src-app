package dagger.internal;

import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SingleCheck<T> implements Provider<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private SingleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p8) {
        if (!(p8 instanceof SingleCheck) && !(p8 instanceof DoubleCheck)) {
            return new SingleCheck((Provider) Preconditions.checkNotNull(p8));
        }
        return p8;
    }

    @Override // javax.inject.Provider
    public T get() {
        T t7 = (T) this.instance;
        if (t7 == UNINITIALIZED) {
            Provider<T> provider = this.provider;
            if (provider == null) {
                return (T) this.instance;
            }
            T t8 = provider.get();
            this.instance = t8;
            this.provider = null;
            return t8;
        }
        return t7;
    }
}
