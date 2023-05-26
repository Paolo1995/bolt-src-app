package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class CallbackToFutureAdapter {

    /* loaded from: classes.dex */
    public static final class Completer<T> {

        /* renamed from: a  reason: collision with root package name */
        Object f4313a;

        /* renamed from: b  reason: collision with root package name */
        SafeFuture<T> f4314b;

        /* renamed from: c  reason: collision with root package name */
        private ResolvableFuture<Void> f4315c = ResolvableFuture.s();

        /* renamed from: d  reason: collision with root package name */
        private boolean f4316d;

        Completer() {
        }

        private void e() {
            this.f4313a = null;
            this.f4314b = null;
            this.f4315c = null;
        }

        public void a(@NonNull Runnable runnable, @NonNull Executor executor) {
            ResolvableFuture<Void> resolvableFuture = this.f4315c;
            if (resolvableFuture != null) {
                resolvableFuture.f(runnable, executor);
            }
        }

        void b() {
            this.f4313a = null;
            this.f4314b = null;
            this.f4315c.p(null);
        }

        public boolean c(T t7) {
            boolean z7 = true;
            this.f4316d = true;
            SafeFuture<T> safeFuture = this.f4314b;
            z7 = (safeFuture == null || !safeFuture.b(t7)) ? false : false;
            if (z7) {
                e();
            }
            return z7;
        }

        public boolean d() {
            boolean z7 = true;
            this.f4316d = true;
            SafeFuture<T> safeFuture = this.f4314b;
            z7 = (safeFuture == null || !safeFuture.a(true)) ? false : false;
            if (z7) {
                e();
            }
            return z7;
        }

        public boolean f(@NonNull Throwable th) {
            boolean z7 = true;
            this.f4316d = true;
            SafeFuture<T> safeFuture = this.f4314b;
            z7 = (safeFuture == null || !safeFuture.c(th)) ? false : false;
            if (z7) {
                e();
            }
            return z7;
        }

        protected void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            SafeFuture<T> safeFuture = this.f4314b;
            if (safeFuture != null && !safeFuture.isDone()) {
                safeFuture.c(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f4313a));
            }
            if (!this.f4316d && (resolvableFuture = this.f4315c) != null) {
                resolvableFuture.p(null);
            }
        }
    }

    /* loaded from: classes.dex */
    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface Resolver<T> {
        Object a(@NonNull Completer<T> completer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SafeFuture<T> implements ListenableFuture<T> {

        /* renamed from: f  reason: collision with root package name */
        final WeakReference<Completer<T>> f4317f;

        /* renamed from: g  reason: collision with root package name */
        private final AbstractResolvableFuture<T> f4318g = new AbstractResolvableFuture<T>() { // from class: androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture.1
            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            protected String m() {
                Completer<T> completer = SafeFuture.this.f4317f.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.f4313a + "]";
            }
        };

        SafeFuture(Completer<T> completer) {
            this.f4317f = new WeakReference<>(completer);
        }

        boolean a(boolean z7) {
            return this.f4318g.cancel(z7);
        }

        boolean b(T t7) {
            return this.f4318g.p(t7);
        }

        boolean c(Throwable th) {
            return this.f4318g.q(th);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z7) {
            Completer<T> completer = this.f4317f.get();
            boolean cancel = this.f4318g.cancel(z7);
            if (cancel && completer != null) {
                completer.b();
            }
            return cancel;
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void f(@NonNull Runnable runnable, @NonNull Executor executor) {
            this.f4318g.f(runnable, executor);
        }

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            return this.f4318g.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f4318g.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f4318g.isDone();
        }

        public String toString() {
            return this.f4318g.toString();
        }

        @Override // java.util.concurrent.Future
        public T get(long j8, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.f4318g.get(j8, timeUnit);
        }
    }

    private CallbackToFutureAdapter() {
    }

    @NonNull
    public static <T> ListenableFuture<T> a(@NonNull Resolver<T> resolver) {
        Completer<T> completer = new Completer<>();
        SafeFuture<T> safeFuture = new SafeFuture<>(completer);
        completer.f4314b = safeFuture;
        completer.f4313a = resolver.getClass();
        try {
            Object a8 = resolver.a(completer);
            if (a8 != null) {
                completer.f4313a = a8;
            }
        } catch (Exception e8) {
            safeFuture.c(e8);
        }
        return safeFuture;
    }
}
