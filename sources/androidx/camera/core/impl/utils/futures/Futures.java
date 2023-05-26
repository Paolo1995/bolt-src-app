package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public final class Futures {

    /* renamed from: a  reason: collision with root package name */
    private static final Function<?, ?> f3865a = new Function<Object, Object>() { // from class: androidx.camera.core.impl.utils.futures.Futures.2
        @Override // androidx.arch.core.util.Function
        public Object apply(Object obj) {
            return obj;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class CallbackListener<V> implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Future<V> f3870f;

        /* renamed from: g  reason: collision with root package name */
        final FutureCallback<? super V> f3871g;

        CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.f3870f = future;
            this.f3871g = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f3871g.onSuccess(Futures.d(this.f3870f));
            } catch (Error e8) {
                e = e8;
                this.f3871g.onFailure(e);
            } catch (RuntimeException e9) {
                e = e9;
                this.f3871g.onFailure(e);
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    this.f3871g.onFailure(e10);
                } else {
                    this.f3871g.onFailure(cause);
                }
            }
        }

        public String toString() {
            return CallbackListener.class.getSimpleName() + "," + this.f3871g;
        }
    }

    private Futures() {
    }

    public static <V> void b(@NonNull ListenableFuture<V> listenableFuture, @NonNull FutureCallback<? super V> futureCallback, @NonNull Executor executor) {
        Preconditions.g(futureCallback);
        listenableFuture.f(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    @NonNull
    public static <V> ListenableFuture<List<V>> c(@NonNull Collection<? extends ListenableFuture<? extends V>> collection) {
        return new ListFuture(new ArrayList(collection), true, CameraXExecutors.a());
    }

    public static <V> V d(@NonNull Future<V> future) throws ExecutionException {
        boolean isDone = future.isDone();
        Preconditions.j(isDone, "Future was expected to be done, " + future);
        return (V) e(future);
    }

    public static <V> V e(@NonNull Future<V> future) throws ExecutionException {
        V v7;
        boolean z7 = false;
        while (true) {
            try {
                v7 = future.get();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        return v7;
    }

    @NonNull
    public static <V> ListenableFuture<V> f(@NonNull Throwable th) {
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    @NonNull
    public static <V> ScheduledFuture<V> g(@NonNull Throwable th) {
        return new ImmediateFuture.ImmediateFailedScheduledFuture(th);
    }

    @NonNull
    public static <V> ListenableFuture<V> h(V v7) {
        if (v7 == null) {
            return ImmediateFuture.a();
        }
        return new ImmediateFuture.ImmediateSuccessfulFuture(v7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object i(ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer) throws Exception {
        m(false, listenableFuture, f3865a, completer, CameraXExecutors.a());
        return "nonCancellationPropagating[" + listenableFuture + "]";
    }

    @NonNull
    public static <V> ListenableFuture<V> j(@NonNull final ListenableFuture<V> listenableFuture) {
        Preconditions.g(listenableFuture);
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.utils.futures.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object i8;
                i8 = Futures.i(ListenableFuture.this, completer);
                return i8;
            }
        });
    }

    public static <V> void k(@NonNull ListenableFuture<V> listenableFuture, @NonNull CallbackToFutureAdapter.Completer<V> completer) {
        l(listenableFuture, f3865a, completer, CameraXExecutors.a());
    }

    public static <I, O> void l(@NonNull ListenableFuture<I> listenableFuture, @NonNull Function<? super I, ? extends O> function, @NonNull CallbackToFutureAdapter.Completer<O> completer, @NonNull Executor executor) {
        m(true, listenableFuture, function, completer, executor);
    }

    private static <I, O> void m(boolean z7, @NonNull final ListenableFuture<I> listenableFuture, @NonNull final Function<? super I, ? extends O> function, @NonNull final CallbackToFutureAdapter.Completer<O> completer, @NonNull Executor executor) {
        Preconditions.g(listenableFuture);
        Preconditions.g(function);
        Preconditions.g(completer);
        Preconditions.g(executor);
        b(listenableFuture, new FutureCallback<I>() { // from class: androidx.camera.core.impl.utils.futures.Futures.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                CallbackToFutureAdapter.Completer.this.f(th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(I i8) {
                try {
                    CallbackToFutureAdapter.Completer.this.c(function.apply(i8));
                } catch (Throwable th) {
                    CallbackToFutureAdapter.Completer.this.f(th);
                }
            }
        }, executor);
        if (z7) {
            completer.a(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.Futures.4
                @Override // java.lang.Runnable
                public void run() {
                    ListenableFuture.this.cancel(true);
                }
            }, CameraXExecutors.a());
        }
    }

    @NonNull
    public static <V> ListenableFuture<List<V>> n(@NonNull Collection<? extends ListenableFuture<? extends V>> collection) {
        return new ListFuture(new ArrayList(collection), false, CameraXExecutors.a());
    }

    @NonNull
    public static <I, O> ListenableFuture<O> o(@NonNull ListenableFuture<I> listenableFuture, @NonNull final Function<? super I, ? extends O> function, @NonNull Executor executor) {
        Preconditions.g(function);
        return p(listenableFuture, new AsyncFunction<I, O>() { // from class: androidx.camera.core.impl.utils.futures.Futures.1
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            @NonNull
            public ListenableFuture<O> apply(I i8) {
                return Futures.h(Function.this.apply(i8));
            }
        }, executor);
    }

    @NonNull
    public static <I, O> ListenableFuture<O> p(@NonNull ListenableFuture<I> listenableFuture, @NonNull AsyncFunction<? super I, ? extends O> asyncFunction, @NonNull Executor executor) {
        ChainingListenableFuture chainingListenableFuture = new ChainingListenableFuture(asyncFunction, listenableFuture);
        listenableFuture.f(chainingListenableFuture, executor);
        return chainingListenableFuture;
    }
}
