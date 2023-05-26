package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class FutureChain<V> implements ListenableFuture<V> {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ListenableFuture<V> f3862f;

    /* renamed from: g  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<V> f3863g;

    FutureChain(@NonNull ListenableFuture<V> listenableFuture) {
        this.f3862f = (ListenableFuture) Preconditions.g(listenableFuture);
    }

    @NonNull
    public static <V> FutureChain<V> a(@NonNull ListenableFuture<V> listenableFuture) {
        if (listenableFuture instanceof FutureChain) {
            return (FutureChain) listenableFuture;
        }
        return new FutureChain<>(listenableFuture);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(V v7) {
        CallbackToFutureAdapter.Completer<V> completer = this.f3863g;
        if (completer != null) {
            return completer.c(v7);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(@NonNull Throwable th) {
        CallbackToFutureAdapter.Completer<V> completer = this.f3863g;
        if (completer != null) {
            return completer.f(th);
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z7) {
        return this.f3862f.cancel(z7);
    }

    @NonNull
    public final <T> FutureChain<T> d(@NonNull Function<? super V, T> function, @NonNull Executor executor) {
        return (FutureChain) Futures.o(this, function, executor);
    }

    @NonNull
    public final <T> FutureChain<T> e(@NonNull AsyncFunction<? super V, T> asyncFunction, @NonNull Executor executor) {
        return (FutureChain) Futures.p(this, asyncFunction, executor);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void f(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.f3862f.f(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return this.f3862f.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f3862f.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f3862f.isDone();
    }

    @Override // java.util.concurrent.Future
    public V get(long j8, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f3862f.get(j8, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FutureChain() {
        this.f3862f = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver<V>() { // from class: androidx.camera.core.impl.utils.futures.FutureChain.1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public Object a(@NonNull CallbackToFutureAdapter.Completer<V> completer) {
                boolean z7;
                if (FutureChain.this.f3863g == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Preconditions.j(z7, "The result can only set once!");
                FutureChain.this.f3863g = completer;
                return "FutureChain[" + FutureChain.this + "]";
            }
        });
    }
}
