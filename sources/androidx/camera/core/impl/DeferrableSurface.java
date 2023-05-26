package androidx.camera.core.impl;

import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class DeferrableSurface {

    /* renamed from: i  reason: collision with root package name */
    public static final Size f3634i = new Size(0, 0);

    /* renamed from: j  reason: collision with root package name */
    private static final boolean f3635j = Logger.f("DeferrableSurface");

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicInteger f3636k = new AtomicInteger(0);

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicInteger f3637l = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    private final Object f3638a;

    /* renamed from: b  reason: collision with root package name */
    private int f3639b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3640c;

    /* renamed from: d  reason: collision with root package name */
    private CallbackToFutureAdapter.Completer<Void> f3641d;

    /* renamed from: e  reason: collision with root package name */
    private final ListenableFuture<Void> f3642e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Size f3643f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3644g;

    /* renamed from: h  reason: collision with root package name */
    Class<?> f3645h;

    /* loaded from: classes.dex */
    public static final class SurfaceClosedException extends Exception {

        /* renamed from: f  reason: collision with root package name */
        DeferrableSurface f3646f;

        public SurfaceClosedException(@NonNull String str, @NonNull DeferrableSurface deferrableSurface) {
            super(str);
            this.f3646f = deferrableSurface;
        }

        @NonNull
        public DeferrableSurface a() {
            return this.f3646f;
        }
    }

    /* loaded from: classes.dex */
    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(@NonNull String str) {
            super(str);
        }
    }

    public DeferrableSurface() {
        this(f3634i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object k(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.f3638a) {
            this.f3641d = completer;
        }
        return "DeferrableSurface-termination(" + this + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(String str) {
        try {
            this.f3642e.get();
            m("Surface terminated", f3637l.decrementAndGet(), f3636k.get());
        } catch (Exception e8) {
            Logger.c("DeferrableSurface", "Unexpected surface termination for " + this + "\nStack Trace:\n" + str);
            synchronized (this.f3638a) {
                throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", this, Boolean.valueOf(this.f3640c), Integer.valueOf(this.f3639b)), e8);
            }
        }
    }

    private void m(@NonNull String str, int i8, int i9) {
        if (!f3635j && Logger.f("DeferrableSurface")) {
            Logger.a("DeferrableSurface", "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        Logger.a("DeferrableSurface", str + "[total_surfaces=" + i8 + ", used_surfaces=" + i9 + "](" + this + "}");
    }

    public void c() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.f3638a) {
            if (!this.f3640c) {
                this.f3640c = true;
                if (this.f3639b == 0) {
                    completer = this.f3641d;
                    this.f3641d = null;
                } else {
                    completer = null;
                }
                if (Logger.f("DeferrableSurface")) {
                    Logger.a("DeferrableSurface", "surface closed,  useCount=" + this.f3639b + " closed=true " + this);
                }
            } else {
                completer = null;
            }
        }
        if (completer != null) {
            completer.c(null);
        }
    }

    public void d() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.f3638a) {
            int i8 = this.f3639b;
            if (i8 != 0) {
                int i9 = i8 - 1;
                this.f3639b = i9;
                if (i9 == 0 && this.f3640c) {
                    completer = this.f3641d;
                    this.f3641d = null;
                } else {
                    completer = null;
                }
                if (Logger.f("DeferrableSurface")) {
                    Logger.a("DeferrableSurface", "use count-1,  useCount=" + this.f3639b + " closed=" + this.f3640c + " " + this);
                    if (this.f3639b == 0) {
                        m("Surface no longer in use", f3637l.get(), f3636k.decrementAndGet());
                    }
                }
            } else {
                throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
            }
        }
        if (completer != null) {
            completer.c(null);
        }
    }

    public Class<?> e() {
        return this.f3645h;
    }

    @NonNull
    public Size f() {
        return this.f3643f;
    }

    public int g() {
        return this.f3644g;
    }

    @NonNull
    public final ListenableFuture<Surface> h() {
        synchronized (this.f3638a) {
            if (this.f3640c) {
                return Futures.f(new SurfaceClosedException("DeferrableSurface already closed.", this));
            }
            return n();
        }
    }

    @NonNull
    public ListenableFuture<Void> i() {
        return Futures.j(this.f3642e);
    }

    public void j() throws SurfaceClosedException {
        synchronized (this.f3638a) {
            int i8 = this.f3639b;
            if (i8 == 0 && this.f3640c) {
                throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
            }
            this.f3639b = i8 + 1;
            if (Logger.f("DeferrableSurface")) {
                if (this.f3639b == 1) {
                    m("New surface in use", f3637l.get(), f3636k.incrementAndGet());
                }
                Logger.a("DeferrableSurface", "use count+1, useCount=" + this.f3639b + " " + this);
            }
        }
    }

    @NonNull
    protected abstract ListenableFuture<Surface> n();

    public void o(@NonNull Class<?> cls) {
        this.f3645h = cls;
    }

    public DeferrableSurface(@NonNull Size size, int i8) {
        this.f3638a = new Object();
        this.f3639b = 0;
        this.f3640c = false;
        this.f3643f = size;
        this.f3644g = i8;
        ListenableFuture<Void> a8 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.h
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object k8;
                k8 = DeferrableSurface.this.k(completer);
                return k8;
            }
        });
        this.f3642e = a8;
        if (Logger.f("DeferrableSurface")) {
            m("Surface created", f3637l.incrementAndGet(), f3636k.get());
            final String stackTraceString = Log.getStackTraceString(new Exception());
            a8.f(new Runnable() { // from class: androidx.camera.core.impl.i
                @Override // java.lang.Runnable
                public final void run() {
                    DeferrableSurface.this.l(stackTraceString);
                }
            }, CameraXExecutors.a());
        }
    }
}
