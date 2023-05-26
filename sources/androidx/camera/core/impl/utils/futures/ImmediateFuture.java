package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
abstract class ImmediateFuture<V> implements ListenableFuture<V> {

    /* loaded from: classes.dex */
    static class ImmediateFailedFuture<V> extends ImmediateFuture<V> {
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private final Throwable f3872f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ImmediateFailedFuture(@NonNull Throwable th) {
            this.f3872f = th;
        }

        @Override // androidx.camera.core.impl.utils.futures.ImmediateFuture, java.util.concurrent.Future
        public V get() throws ExecutionException {
            throw new ExecutionException(this.f3872f);
        }

        @NonNull
        public String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + this.f3872f + "]]";
        }
    }

    /* loaded from: classes.dex */
    static final class ImmediateFailedScheduledFuture<V> extends ImmediateFailedFuture<V> implements ScheduledFuture<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ImmediateFailedScheduledFuture(@NonNull Throwable th) {
            super(th);
        }

        @Override // java.lang.Comparable
        /* renamed from: c */
        public int compareTo(@NonNull Delayed delayed) {
            return -1;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(@NonNull TimeUnit timeUnit) {
            return 0L;
        }
    }

    /* loaded from: classes.dex */
    static final class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {

        /* renamed from: g  reason: collision with root package name */
        static final ImmediateFuture<Object> f3873g = new ImmediateSuccessfulFuture(null);

        /* renamed from: f  reason: collision with root package name */
        private final V f3874f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ImmediateSuccessfulFuture(V v7) {
            this.f3874f = v7;
        }

        @Override // androidx.camera.core.impl.utils.futures.ImmediateFuture, java.util.concurrent.Future
        public V get() {
            return this.f3874f;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.f3874f + "]]";
        }
    }

    ImmediateFuture() {
    }

    public static <V> ListenableFuture<V> a() {
        return ImmediateSuccessfulFuture.f3873g;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z7) {
        return false;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void f(@NonNull Runnable runnable, @NonNull Executor executor) {
        Preconditions.g(runnable);
        Preconditions.g(executor);
        try {
            executor.execute(runnable);
        } catch (RuntimeException e8) {
            Logger.d("ImmediateFuture", "Experienced RuntimeException while attempting to notify " + runnable + " on Executor " + executor, e8);
        }
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long j8, @NonNull TimeUnit timeUnit) throws ExecutionException {
        Preconditions.g(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
