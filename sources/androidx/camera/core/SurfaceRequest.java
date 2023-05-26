package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SurfaceRequest {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3302a;

    /* renamed from: b  reason: collision with root package name */
    private final Size f3303b;

    /* renamed from: c  reason: collision with root package name */
    private final Range<Integer> f3304c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3305d;

    /* renamed from: e  reason: collision with root package name */
    private final CameraInternal f3306e;

    /* renamed from: f  reason: collision with root package name */
    final ListenableFuture<Surface> f3307f;

    /* renamed from: g  reason: collision with root package name */
    private final CallbackToFutureAdapter.Completer<Surface> f3308g;

    /* renamed from: h  reason: collision with root package name */
    private final ListenableFuture<Void> f3309h;

    /* renamed from: i  reason: collision with root package name */
    private final CallbackToFutureAdapter.Completer<Void> f3310i;

    /* renamed from: j  reason: collision with root package name */
    private final DeferrableSurface f3311j;

    /* renamed from: k  reason: collision with root package name */
    private TransformationInfo f3312k;

    /* renamed from: l  reason: collision with root package name */
    private TransformationInfoListener f3313l;

    /* renamed from: m  reason: collision with root package name */
    private Executor f3314m;

    /* loaded from: classes.dex */
    private static final class RequestCancelledException extends RuntimeException {
        RequestCancelledException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Result {
        @NonNull
        static Result c(int i8, @NonNull Surface surface) {
            return new AutoValue_SurfaceRequest_Result(i8, surface);
        }

        public abstract int a();

        @NonNull
        public abstract Surface b();
    }

    /* loaded from: classes.dex */
    public static abstract class TransformationInfo {
        @NonNull
        public static TransformationInfo d(@NonNull Rect rect, int i8, int i9) {
            return new AutoValue_SurfaceRequest_TransformationInfo(rect, i8, i9);
        }

        @NonNull
        public abstract Rect a();

        public abstract int b();

        public abstract int c();
    }

    /* loaded from: classes.dex */
    public interface TransformationInfoListener {
        void a(@NonNull TransformationInfo transformationInfo);
    }

    public SurfaceRequest(@NonNull Size size, @NonNull CameraInternal cameraInternal, boolean z7) {
        this(size, cameraInternal, z7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object n(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-cancellation";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object o(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-status";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object p(AtomicReference atomicReference, String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return str + "-Surface";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.f3307f.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(Consumer consumer, Surface surface) {
        consumer.accept(Result.c(3, surface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(Consumer consumer, Surface surface) {
        consumer.accept(Result.c(4, surface));
    }

    @SuppressLint({"PairedRegistration"})
    public void i(@NonNull Executor executor, @NonNull Runnable runnable) {
        this.f3310i.a(runnable, executor);
    }

    @NonNull
    public CameraInternal j() {
        return this.f3306e;
    }

    @NonNull
    public DeferrableSurface k() {
        return this.f3311j;
    }

    @NonNull
    public Size l() {
        return this.f3303b;
    }

    public boolean m() {
        return this.f3305d;
    }

    public void v(@NonNull final Surface surface, @NonNull Executor executor, @NonNull final Consumer<Result> consumer) {
        if (!this.f3308g.c(surface) && !this.f3307f.isCancelled()) {
            Preconditions.i(this.f3307f.isDone());
            try {
                this.f3307f.get();
                executor.execute(new Runnable() { // from class: androidx.camera.core.d1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SurfaceRequest.r(Consumer.this, surface);
                    }
                });
                return;
            } catch (InterruptedException | ExecutionException unused) {
                executor.execute(new Runnable() { // from class: androidx.camera.core.e1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SurfaceRequest.s(Consumer.this, surface);
                    }
                });
                return;
            }
        }
        Futures.b(this.f3309h, new FutureCallback<Void>() { // from class: androidx.camera.core.SurfaceRequest.4
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(Void r32) {
                consumer.accept(Result.c(0, surface));
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                Preconditions.j(th instanceof RequestCancelledException, "Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th);
                consumer.accept(Result.c(1, surface));
            }
        }, executor);
    }

    public void w(@NonNull Executor executor, @NonNull final TransformationInfoListener transformationInfoListener) {
        final TransformationInfo transformationInfo;
        synchronized (this.f3302a) {
            this.f3313l = transformationInfoListener;
            this.f3314m = executor;
            transformationInfo = this.f3312k;
        }
        if (transformationInfo != null) {
            executor.execute(new Runnable() { // from class: androidx.camera.core.c1
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceRequest.TransformationInfoListener.this.a(transformationInfo);
                }
            });
        }
    }

    public void x(@NonNull final TransformationInfo transformationInfo) {
        final TransformationInfoListener transformationInfoListener;
        Executor executor;
        synchronized (this.f3302a) {
            this.f3312k = transformationInfo;
            transformationInfoListener = this.f3313l;
            executor = this.f3314m;
        }
        if (transformationInfoListener != null && executor != null) {
            executor.execute(new Runnable() { // from class: androidx.camera.core.b1
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceRequest.TransformationInfoListener.this.a(transformationInfo);
                }
            });
        }
    }

    public boolean y() {
        return this.f3308g.f(new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }

    public SurfaceRequest(@NonNull Size size, @NonNull CameraInternal cameraInternal, boolean z7, Range<Integer> range) {
        this.f3302a = new Object();
        this.f3303b = size;
        this.f3306e = cameraInternal;
        this.f3305d = z7;
        this.f3304c = range;
        final String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        final AtomicReference atomicReference = new AtomicReference(null);
        final ListenableFuture a8 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.x0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object n8;
                n8 = SurfaceRequest.n(atomicReference, str, completer);
                return n8;
            }
        });
        final CallbackToFutureAdapter.Completer<Void> completer = (CallbackToFutureAdapter.Completer) Preconditions.g((CallbackToFutureAdapter.Completer) atomicReference.get());
        this.f3310i = completer;
        final AtomicReference atomicReference2 = new AtomicReference(null);
        ListenableFuture<Void> a9 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.y0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer2) {
                Object o8;
                o8 = SurfaceRequest.o(atomicReference2, str, completer2);
                return o8;
            }
        });
        this.f3309h = a9;
        Futures.b(a9, new FutureCallback<Void>() { // from class: androidx.camera.core.SurfaceRequest.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(Void r22) {
                Preconditions.i(completer.c(null));
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                if (th instanceof RequestCancelledException) {
                    Preconditions.i(a8.cancel(false));
                } else {
                    Preconditions.i(completer.c(null));
                }
            }
        }, CameraXExecutors.a());
        final CallbackToFutureAdapter.Completer completer2 = (CallbackToFutureAdapter.Completer) Preconditions.g((CallbackToFutureAdapter.Completer) atomicReference2.get());
        final AtomicReference atomicReference3 = new AtomicReference(null);
        ListenableFuture<Surface> a10 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.z0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer3) {
                Object p8;
                p8 = SurfaceRequest.p(atomicReference3, str, completer3);
                return p8;
            }
        });
        this.f3307f = a10;
        this.f3308g = (CallbackToFutureAdapter.Completer) Preconditions.g((CallbackToFutureAdapter.Completer) atomicReference3.get());
        DeferrableSurface deferrableSurface = new DeferrableSurface(size, 34) { // from class: androidx.camera.core.SurfaceRequest.2
            @Override // androidx.camera.core.impl.DeferrableSurface
            @NonNull
            protected ListenableFuture<Surface> n() {
                return SurfaceRequest.this.f3307f;
            }
        };
        this.f3311j = deferrableSurface;
        final ListenableFuture<Void> i8 = deferrableSurface.i();
        Futures.b(a10, new FutureCallback<Surface>() { // from class: androidx.camera.core.SurfaceRequest.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(Surface surface) {
                Futures.k(i8, completer2);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                if (th instanceof CancellationException) {
                    CallbackToFutureAdapter.Completer completer3 = completer2;
                    Preconditions.i(completer3.f(new RequestCancelledException(str + " cancelled.", th)));
                    return;
                }
                completer2.c(null);
            }
        }, CameraXExecutors.a());
        i8.f(new Runnable() { // from class: androidx.camera.core.a1
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceRequest.this.q();
            }
        }, CameraXExecutors.a());
    }
}
