package androidx.concurrent.futures;

/* loaded from: classes.dex */
public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    private ResolvableFuture() {
    }

    public static <V> ResolvableFuture<V> s() {
        return new ResolvableFuture<>();
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean p(V v7) {
        return super.p(v7);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean q(Throwable th) {
        return super.q(th);
    }
}
