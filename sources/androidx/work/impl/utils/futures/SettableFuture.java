package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public final class SettableFuture<V> extends AbstractFuture<V> {
    private SettableFuture() {
    }

    public static <V> SettableFuture<V> t() {
        return new SettableFuture<>();
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean p(V v7) {
        return super.p(v7);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean q(Throwable th) {
        return super.q(th);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean r(ListenableFuture<? extends V> listenableFuture) {
        return super.r(listenableFuture);
    }
}
