package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.SettableSurface;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public class SettableSurface extends DeferrableSurface {

    /* renamed from: m  reason: collision with root package name */
    private final ListenableFuture<Surface> f3973m;

    /* renamed from: n  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Surface> f3974n;

    /* renamed from: o  reason: collision with root package name */
    private final Matrix f3975o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f3976p;

    /* renamed from: q  reason: collision with root package name */
    private final Rect f3977q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f3978r;

    /* renamed from: s  reason: collision with root package name */
    private final int f3979s;

    /* renamed from: t  reason: collision with root package name */
    private int f3980t;

    /* renamed from: u  reason: collision with root package name */
    private SurfaceOutputImpl f3981u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f3982v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f3983w;

    /* renamed from: x  reason: collision with root package name */
    private SurfaceRequest f3984x;

    public SettableSurface(int i8, @NonNull final Size size, int i9, @NonNull Matrix matrix, boolean z7, @NonNull Rect rect, int i10, boolean z8) {
        super(size, i9);
        this.f3982v = false;
        this.f3983w = false;
        this.f3979s = i8;
        this.f3975o = matrix;
        this.f3976p = z7;
        this.f3977q = rect;
        this.f3980t = i10;
        this.f3978r = z8;
        this.f3973m = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: i.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object F;
                F = SettableSurface.this.F(size, completer);
                return F;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        SurfaceOutputImpl surfaceOutputImpl = this.f3981u;
        if (surfaceOutputImpl != null) {
            surfaceOutputImpl.h();
            this.f3981u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ListenableFuture E(SurfaceOutput.GlTransformOptions glTransformOptions, Size size, Rect rect, int i8, boolean z7, Surface surface) throws Exception {
        Preconditions.g(surface);
        try {
            j();
            SurfaceOutputImpl surfaceOutputImpl = new SurfaceOutputImpl(surface, C(), x(), B(), glTransformOptions, size, rect, i8, z7);
            surfaceOutputImpl.e().f(new Runnable() { // from class: i.e
                @Override // java.lang.Runnable
                public final void run() {
                    SettableSurface.this.d();
                }
            }, CameraXExecutors.a());
            this.f3981u = surfaceOutputImpl;
            return Futures.h(surfaceOutputImpl);
        } catch (DeferrableSurface.SurfaceClosedException e8) {
            return Futures.f(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object F(Size size, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.f3974n = completer;
        return "SettableFuture size: " + size + " hashCode: " + hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(DeferrableSurface deferrableSurface) {
        deferrableSurface.d();
        deferrableSurface.c();
    }

    private void H() {
        SurfaceRequest surfaceRequest = this.f3984x;
        if (surfaceRequest != null) {
            surfaceRequest.x(SurfaceRequest.TransformationInfo.d(this.f3977q, this.f3980t, -1));
        }
    }

    @NonNull
    public Matrix A() {
        return this.f3975o;
    }

    @NonNull
    public Size B() {
        return f();
    }

    public int C() {
        return this.f3979s;
    }

    public void I(@NonNull final DeferrableSurface deferrableSurface) throws DeferrableSurface.SurfaceClosedException {
        Threads.a();
        J(deferrableSurface.h());
        deferrableSurface.j();
        i().f(new Runnable() { // from class: i.c
            @Override // java.lang.Runnable
            public final void run() {
                SettableSurface.G(DeferrableSurface.this);
            }
        }, CameraXExecutors.a());
    }

    public void J(@NonNull ListenableFuture<Surface> listenableFuture) {
        Threads.a();
        Preconditions.j(!this.f3982v, "Provider can only be linked once.");
        this.f3982v = true;
        Futures.k(listenableFuture, this.f3974n);
    }

    public void K(int i8) {
        Threads.a();
        if (this.f3980t == i8) {
            return;
        }
        this.f3980t = i8;
        H();
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    public final void c() {
        super.c();
        CameraXExecutors.d().execute(new Runnable() { // from class: i.b
            @Override // java.lang.Runnable
            public final void run() {
                SettableSurface.this.D();
            }
        });
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    @NonNull
    protected ListenableFuture<Surface> n() {
        return this.f3973m;
    }

    @NonNull
    public ListenableFuture<SurfaceOutput> t(@NonNull final SurfaceOutput.GlTransformOptions glTransformOptions, @NonNull final Size size, @NonNull final Rect rect, final int i8, final boolean z7) {
        Threads.a();
        Preconditions.j(!this.f3983w, "Consumer can only be linked once.");
        this.f3983w = true;
        return Futures.p(h(), new AsyncFunction() { // from class: i.d
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                ListenableFuture E;
                E = SettableSurface.this.E(glTransformOptions, size, rect, i8, z7, (Surface) obj);
                return E;
            }
        }, CameraXExecutors.d());
    }

    @NonNull
    public SurfaceRequest u(@NonNull CameraInternal cameraInternal) {
        return v(cameraInternal, null);
    }

    @NonNull
    public SurfaceRequest v(@NonNull CameraInternal cameraInternal, Range<Integer> range) {
        Threads.a();
        SurfaceRequest surfaceRequest = new SurfaceRequest(B(), cameraInternal, true, range);
        try {
            I(surfaceRequest.k());
            this.f3984x = surfaceRequest;
            H();
            return surfaceRequest;
        } catch (DeferrableSurface.SurfaceClosedException e8) {
            throw new AssertionError("Surface is somehow already closed", e8);
        }
    }

    @NonNull
    public Rect w() {
        return this.f3977q;
    }

    public int x() {
        return g();
    }

    public boolean y() {
        return this.f3978r;
    }

    public int z() {
        return this.f3980t;
    }
}
