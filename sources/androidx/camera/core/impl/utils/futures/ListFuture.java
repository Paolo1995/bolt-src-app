package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ListFuture<V> implements ListenableFuture<List<V>> {

    /* renamed from: f  reason: collision with root package name */
    List<? extends ListenableFuture<? extends V>> f3875f;

    /* renamed from: g  reason: collision with root package name */
    List<V> f3876g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f3877h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f3878i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ListenableFuture<List<V>> f3879j = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver<List<V>>() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.1
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
        public Object a(@NonNull CallbackToFutureAdapter.Completer<List<V>> completer) {
            boolean z7;
            if (ListFuture.this.f3880k == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.j(z7, "The result can only set once!");
            ListFuture.this.f3880k = completer;
            return "ListFuture[" + this + "]";
        }
    });

    /* renamed from: k  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<List<V>> f3880k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListFuture(@NonNull List<? extends ListenableFuture<? extends V>> list, boolean z7, @NonNull Executor executor) {
        this.f3875f = (List) Preconditions.g(list);
        this.f3876g = new ArrayList(list.size());
        this.f3877h = z7;
        this.f3878i = new AtomicInteger(list.size());
        d(executor);
    }

    private void a() throws InterruptedException {
        List<? extends ListenableFuture<? extends V>> list = this.f3875f;
        if (list != null && !isDone()) {
            for (ListenableFuture<? extends V> listenableFuture : list) {
                while (!listenableFuture.isDone()) {
                    try {
                        listenableFuture.get();
                    } catch (Error e8) {
                        throw e8;
                    } catch (InterruptedException e9) {
                        throw e9;
                    } catch (Throwable unused) {
                        if (this.f3877h) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void d(@NonNull Executor executor) {
        f(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.2
            @Override // java.lang.Runnable
            public void run() {
                ListFuture listFuture = ListFuture.this;
                listFuture.f3876g = null;
                listFuture.f3875f = null;
            }
        }, CameraXExecutors.a());
        if (this.f3875f.isEmpty()) {
            this.f3880k.c(new ArrayList(this.f3876g));
            return;
        }
        for (int i8 = 0; i8 < this.f3875f.size(); i8++) {
            this.f3876g.add(null);
        }
        List<? extends ListenableFuture<? extends V>> list = this.f3875f;
        for (final int i9 = 0; i9 < list.size(); i9++) {
            final ListenableFuture<? extends V> listenableFuture = list.get(i9);
            listenableFuture.f(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.3
                @Override // java.lang.Runnable
                public void run() {
                    ListFuture.this.e(i9, listenableFuture);
                }
            }, executor);
        }
    }

    @Override // java.util.concurrent.Future
    /* renamed from: b */
    public List<V> get() throws InterruptedException, ExecutionException {
        a();
        return this.f3879j.get();
    }

    @Override // java.util.concurrent.Future
    /* renamed from: c */
    public List<V> get(long j8, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f3879j.get(j8, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z7) {
        List<? extends ListenableFuture<? extends V>> list = this.f3875f;
        if (list != null) {
            for (ListenableFuture<? extends V> listenableFuture : list) {
                listenableFuture.cancel(z7);
            }
        }
        return this.f3879j.cancel(z7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void e(int i8, @NonNull Future<? extends V> future) {
        CallbackToFutureAdapter.Completer<List<V>> completer;
        ArrayList arrayList;
        int decrementAndGet;
        List<V> list = this.f3876g;
        if (!isDone() && list != 0) {
            boolean z7 = true;
            try {
                try {
                    try {
                        try {
                            Preconditions.j(future.isDone(), "Tried to set value from future which is not done");
                            list.set(i8, Futures.e(future));
                            decrementAndGet = this.f3878i.decrementAndGet();
                            if (decrementAndGet < 0) {
                                z7 = false;
                            }
                            Preconditions.j(z7, "Less than 0 remaining futures");
                        } catch (Error e8) {
                            this.f3880k.f(e8);
                            int decrementAndGet2 = this.f3878i.decrementAndGet();
                            if (decrementAndGet2 < 0) {
                                z7 = false;
                            }
                            Preconditions.j(z7, "Less than 0 remaining futures");
                            if (decrementAndGet2 == 0) {
                                List<V> list2 = this.f3876g;
                                if (list2 != null) {
                                    completer = this.f3880k;
                                    arrayList = new ArrayList(list2);
                                }
                            } else {
                                return;
                            }
                        } catch (CancellationException unused) {
                            if (this.f3877h) {
                                cancel(false);
                            }
                            int decrementAndGet3 = this.f3878i.decrementAndGet();
                            if (decrementAndGet3 < 0) {
                                z7 = false;
                            }
                            Preconditions.j(z7, "Less than 0 remaining futures");
                            if (decrementAndGet3 == 0) {
                                List<V> list3 = this.f3876g;
                                if (list3 != null) {
                                    completer = this.f3880k;
                                    arrayList = new ArrayList(list3);
                                }
                            } else {
                                return;
                            }
                        }
                    } catch (RuntimeException e9) {
                        if (this.f3877h) {
                            this.f3880k.f(e9);
                        }
                        int decrementAndGet4 = this.f3878i.decrementAndGet();
                        if (decrementAndGet4 < 0) {
                            z7 = false;
                        }
                        Preconditions.j(z7, "Less than 0 remaining futures");
                        if (decrementAndGet4 == 0) {
                            List<V> list4 = this.f3876g;
                            if (list4 != null) {
                                completer = this.f3880k;
                                arrayList = new ArrayList(list4);
                            }
                        } else {
                            return;
                        }
                    }
                } catch (ExecutionException e10) {
                    if (this.f3877h) {
                        this.f3880k.f(e10.getCause());
                    }
                    int decrementAndGet5 = this.f3878i.decrementAndGet();
                    if (decrementAndGet5 < 0) {
                        z7 = false;
                    }
                    Preconditions.j(z7, "Less than 0 remaining futures");
                    if (decrementAndGet5 == 0) {
                        List<V> list5 = this.f3876g;
                        if (list5 != null) {
                            completer = this.f3880k;
                            arrayList = new ArrayList(list5);
                        }
                    } else {
                        return;
                    }
                }
                if (decrementAndGet == 0) {
                    List<V> list6 = this.f3876g;
                    if (list6 != null) {
                        completer = this.f3880k;
                        arrayList = new ArrayList(list6);
                        completer.c(arrayList);
                        return;
                    }
                    Preconditions.i(isDone());
                    return;
                }
                return;
            } catch (Throwable th) {
                int decrementAndGet6 = this.f3878i.decrementAndGet();
                if (decrementAndGet6 < 0) {
                    z7 = false;
                }
                Preconditions.j(z7, "Less than 0 remaining futures");
                if (decrementAndGet6 == 0) {
                    List<V> list7 = this.f3876g;
                    if (list7 != null) {
                        this.f3880k.c(new ArrayList(list7));
                    } else {
                        Preconditions.i(isDone());
                    }
                }
                throw th;
            }
        }
        Preconditions.j(this.f3877h, "Future was done before all dependencies completed");
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void f(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.f3879j.f(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f3879j.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f3879j.isDone();
    }
}
