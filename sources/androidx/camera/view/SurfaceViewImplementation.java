package androidx.camera.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SurfaceViewImplementation extends PreviewViewImplementation {

    /* renamed from: e  reason: collision with root package name */
    SurfaceView f4146e;

    /* renamed from: f  reason: collision with root package name */
    final SurfaceRequestCallback f4147f;

    /* renamed from: g  reason: collision with root package name */
    private PreviewViewImplementation.OnSurfaceNotInUseListener f4148g;

    /* loaded from: classes.dex */
    private static class Api24Impl {
        private Api24Impl() {
        }

        static void a(@NonNull SurfaceView surfaceView, @NonNull Bitmap bitmap, @NonNull PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener, @NonNull Handler handler) {
            PixelCopy.request(surfaceView, bitmap, onPixelCopyFinishedListener, handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SurfaceRequestCallback implements SurfaceHolder.Callback {

        /* renamed from: f  reason: collision with root package name */
        private Size f4149f;

        /* renamed from: g  reason: collision with root package name */
        private SurfaceRequest f4150g;

        /* renamed from: h  reason: collision with root package name */
        private Size f4151h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f4152i = false;

        SurfaceRequestCallback() {
        }

        private boolean b() {
            Size size;
            if (!this.f4152i && this.f4150g != null && (size = this.f4149f) != null && size.equals(this.f4151h)) {
                return true;
            }
            return false;
        }

        private void c() {
            if (this.f4150g != null) {
                Logger.a("SurfaceViewImpl", "Request canceled: " + this.f4150g);
                this.f4150g.y();
            }
        }

        private void d() {
            if (this.f4150g != null) {
                Logger.a("SurfaceViewImpl", "Surface invalidated " + this.f4150g);
                this.f4150g.k().c();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(SurfaceRequest.Result result) {
            Logger.a("SurfaceViewImpl", "Safe to release surface.");
            SurfaceViewImplementation.this.p();
        }

        private boolean g() {
            Surface surface = SurfaceViewImplementation.this.f4146e.getHolder().getSurface();
            if (b()) {
                Logger.a("SurfaceViewImpl", "Surface set on Preview.");
                this.f4150g.v(surface, ContextCompat.getMainExecutor(SurfaceViewImplementation.this.f4146e.getContext()), new Consumer() { // from class: androidx.camera.view.l
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        SurfaceViewImplementation.SurfaceRequestCallback.this.e((SurfaceRequest.Result) obj);
                    }
                });
                this.f4152i = true;
                SurfaceViewImplementation.this.f();
                return true;
            }
            return false;
        }

        void f(@NonNull SurfaceRequest surfaceRequest) {
            c();
            this.f4150g = surfaceRequest;
            Size l8 = surfaceRequest.l();
            this.f4149f = l8;
            this.f4152i = false;
            if (!g()) {
                Logger.a("SurfaceViewImpl", "Wait for new Surface creation.");
                SurfaceViewImplementation.this.f4146e.getHolder().setFixedSize(l8.getWidth(), l8.getHeight());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i8, int i9, int i10) {
            Logger.a("SurfaceViewImpl", "Surface changed. Size: " + i9 + "x" + i10);
            this.f4151h = new Size(i9, i10);
            g();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            Logger.a("SurfaceViewImpl", "Surface created.");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
            Logger.a("SurfaceViewImpl", "Surface destroyed.");
            if (this.f4152i) {
                d();
            } else {
                c();
            }
            this.f4152i = false;
            this.f4150g = null;
            this.f4151h = null;
            this.f4149f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SurfaceViewImplementation(@NonNull FrameLayout frameLayout, @NonNull PreviewTransformation previewTransformation) {
        super(frameLayout, previewTransformation);
        this.f4147f = new SurfaceRequestCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(int i8) {
        if (i8 == 0) {
            Logger.a("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
            return;
        }
        Logger.c("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(SurfaceRequest surfaceRequest) {
        this.f4147f.f(surfaceRequest);
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    View b() {
        return this.f4146e;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    Bitmap c() {
        SurfaceView surfaceView = this.f4146e;
        if (surfaceView != null && surfaceView.getHolder().getSurface() != null && this.f4146e.getHolder().getSurface().isValid()) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f4146e.getWidth(), this.f4146e.getHeight(), Bitmap.Config.ARGB_8888);
            Api24Impl.a(this.f4146e, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.camera.view.k
                public final void onPixelCopyFinished(int i8) {
                    SurfaceViewImplementation.n(i8);
                }
            }, this.f4146e.getHandler());
            return createBitmap;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void g(@NonNull final SurfaceRequest surfaceRequest, PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
        this.f4136a = surfaceRequest.l();
        this.f4148g = onSurfaceNotInUseListener;
        m();
        surfaceRequest.i(ContextCompat.getMainExecutor(this.f4146e.getContext()), new Runnable() { // from class: androidx.camera.view.i
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceViewImplementation.this.p();
            }
        });
        this.f4146e.post(new Runnable() { // from class: androidx.camera.view.j
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceViewImplementation.this.o(surfaceRequest);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void i(@NonNull Executor executor, @NonNull PreviewView.OnFrameUpdateListener onFrameUpdateListener) {
        throw new IllegalArgumentException("SurfaceView doesn't support frame update listener");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    @NonNull
    public ListenableFuture<Void> j() {
        return Futures.h(null);
    }

    void m() {
        Preconditions.g(this.f4137b);
        Preconditions.g(this.f4136a);
        SurfaceView surfaceView = new SurfaceView(this.f4137b.getContext());
        this.f4146e = surfaceView;
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(this.f4136a.getWidth(), this.f4136a.getHeight()));
        this.f4137b.removeAllViews();
        this.f4137b.addView(this.f4146e);
        this.f4146e.getHolder().addCallback(this.f4147f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener = this.f4148g;
        if (onSurfaceNotInUseListener != null) {
            onSurfaceNotInUseListener.a();
            this.f4148g = null;
        }
    }
}
