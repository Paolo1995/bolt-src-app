package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class DeferrableSurfaces {
    private DeferrableSurfaces() {
    }

    public static void e(@NonNull List<DeferrableSurface> list) {
        for (DeferrableSurface deferrableSurface : list) {
            deferrableSurface.d();
        }
    }

    public static void f(@NonNull List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        if (!list.isEmpty()) {
            int i8 = 0;
            do {
                try {
                    list.get(i8).j();
                    i8++;
                } catch (DeferrableSurface.SurfaceClosedException e8) {
                    for (int i9 = i8 - 1; i9 >= 0; i9--) {
                        list.get(i9).d();
                    }
                    throw e8;
                }
            } while (i8 < list.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, long j8) {
        if (!listenableFuture.isDone()) {
            completer.f(new TimeoutException("Cannot complete surfaceList within " + j8));
            listenableFuture.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Executor executor, final ListenableFuture listenableFuture, final CallbackToFutureAdapter.Completer completer, final long j8) {
        executor.execute(new Runnable() { // from class: androidx.camera.core.impl.m
            @Override // java.lang.Runnable
            public final void run() {
                DeferrableSurfaces.g(ListenableFuture.this, completer, j8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object j(List list, ScheduledExecutorService scheduledExecutorService, final Executor executor, final long j8, final boolean z7, final CallbackToFutureAdapter.Completer completer) throws Exception {
        final ListenableFuture n8 = Futures.n(list);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable() { // from class: androidx.camera.core.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                DeferrableSurfaces.h(executor, n8, completer, j8);
            }
        }, j8, TimeUnit.MILLISECONDS);
        completer.a(new Runnable() { // from class: androidx.camera.core.impl.l
            @Override // java.lang.Runnable
            public final void run() {
                ListenableFuture.this.cancel(true);
            }
        }, executor);
        Futures.b(n8, new FutureCallback<List<Surface>>() { // from class: androidx.camera.core.impl.DeferrableSurfaces.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(List<Surface> list2) {
                ArrayList arrayList = new ArrayList(list2);
                if (z7) {
                    arrayList.removeAll(Collections.singleton(null));
                }
                completer.c(arrayList);
                schedule.cancel(true);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                completer.c(Collections.unmodifiableList(Collections.emptyList()));
                schedule.cancel(true);
            }
        }, executor);
        return "surfaceList";
    }

    @NonNull
    public static ListenableFuture<List<Surface>> k(@NonNull Collection<DeferrableSurface> collection, final boolean z7, final long j8, @NonNull final Executor executor, @NonNull final ScheduledExecutorService scheduledExecutorService) {
        final ArrayList arrayList = new ArrayList();
        for (DeferrableSurface deferrableSurface : collection) {
            arrayList.add(Futures.j(deferrableSurface.h()));
        }
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.j
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object j9;
                j9 = DeferrableSurfaces.j(arrayList, scheduledExecutorService, executor, j8, z7, completer);
                return j9;
            }
        });
    }
}
