package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Preconditions;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class LiveDataObservable<T> implements Observable<T> {

    /* renamed from: a  reason: collision with root package name */
    final MutableLiveData<Result<T>> f3662a = new MutableLiveData<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> f3663b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class LiveDataObserverAdapter<T> implements Observer<Result<T>> {

        /* renamed from: a  reason: collision with root package name */
        final AtomicBoolean f3664a = new AtomicBoolean(true);

        /* renamed from: b  reason: collision with root package name */
        final Observable.Observer<? super T> f3665b;

        /* renamed from: c  reason: collision with root package name */
        final Executor f3666c;

        LiveDataObserverAdapter(@NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
            this.f3666c = executor;
            this.f3665b = observer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Result result) {
            if (!this.f3664a.get()) {
                return;
            }
            if (result.a()) {
                this.f3665b.a((Object) result.d());
                return;
            }
            Preconditions.g(result.c());
            this.f3665b.onError(result.c());
        }

        void b() {
            this.f3664a.set(false);
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: d */
        public void onChanged(@NonNull final Result<T> result) {
            this.f3666c.execute(new Runnable() { // from class: androidx.camera.core.impl.r
                @Override // java.lang.Runnable
                public final void run() {
                    LiveDataObservable.LiveDataObserverAdapter.this.c(result);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static final class Result<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f3667a;

        /* renamed from: b  reason: collision with root package name */
        private final Throwable f3668b;

        private Result(T t7, Throwable th) {
            this.f3667a = t7;
            this.f3668b = th;
        }

        static <T> Result<T> b(T t7) {
            return new Result<>(t7, null);
        }

        public boolean a() {
            if (this.f3668b == null) {
                return true;
            }
            return false;
        }

        public Throwable c() {
            return this.f3668b;
        }

        public T d() {
            if (a()) {
                return this.f3667a;
            }
            throw new IllegalStateException("Result contains an error. Does not contain a value.");
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[Result: <");
            if (a()) {
                str = "Value: " + this.f3667a;
            } else {
                str = "Error: " + this.f3668b;
            }
            sb.append(str);
            sb.append(">]");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObserverAdapter liveDataObserverAdapter2) {
        if (liveDataObserverAdapter != null) {
            this.f3662a.n(liveDataObserverAdapter);
        }
        this.f3662a.j(liveDataObserverAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(LiveDataObserverAdapter liveDataObserverAdapter) {
        this.f3662a.n(liveDataObserverAdapter);
    }

    @Override // androidx.camera.core.impl.Observable
    public void a(@NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
        synchronized (this.f3663b) {
            final LiveDataObserverAdapter<T> liveDataObserverAdapter = this.f3663b.get(observer);
            if (liveDataObserverAdapter != null) {
                liveDataObserverAdapter.b();
            }
            final LiveDataObserverAdapter<T> liveDataObserverAdapter2 = new LiveDataObserverAdapter<>(executor, observer);
            this.f3663b.put(observer, liveDataObserverAdapter2);
            CameraXExecutors.d().execute(new Runnable() { // from class: androidx.camera.core.impl.p
                @Override // java.lang.Runnable
                public final void run() {
                    LiveDataObservable.this.e(liveDataObserverAdapter, liveDataObserverAdapter2);
                }
            });
        }
    }

    @Override // androidx.camera.core.impl.Observable
    public void b(@NonNull Observable.Observer<? super T> observer) {
        synchronized (this.f3663b) {
            final LiveDataObserverAdapter<T> remove = this.f3663b.remove(observer);
            if (remove != null) {
                remove.b();
                CameraXExecutors.d().execute(new Runnable() { // from class: androidx.camera.core.impl.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveDataObservable.this.f(remove);
                    }
                });
            }
        }
    }

    public void g(T t7) {
        this.f3662a.m(Result.b(t7));
    }
}
