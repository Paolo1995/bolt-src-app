package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.TextureViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class TextureViewImplementation extends PreviewViewImplementation {

    /* renamed from: e  reason: collision with root package name */
    TextureView f4154e;

    /* renamed from: f  reason: collision with root package name */
    SurfaceTexture f4155f;

    /* renamed from: g  reason: collision with root package name */
    ListenableFuture<SurfaceRequest.Result> f4156g;

    /* renamed from: h  reason: collision with root package name */
    SurfaceRequest f4157h;

    /* renamed from: i  reason: collision with root package name */
    boolean f4158i;

    /* renamed from: j  reason: collision with root package name */
    SurfaceTexture f4159j;

    /* renamed from: k  reason: collision with root package name */
    AtomicReference<CallbackToFutureAdapter.Completer<Void>> f4160k;

    /* renamed from: l  reason: collision with root package name */
    PreviewViewImplementation.OnSurfaceNotInUseListener f4161l;

    /* renamed from: m  reason: collision with root package name */
    PreviewView.OnFrameUpdateListener f4162m;

    /* renamed from: n  reason: collision with root package name */
    Executor f4163n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.view.TextureViewImplementation$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(PreviewView.OnFrameUpdateListener onFrameUpdateListener, SurfaceTexture surfaceTexture) {
            onFrameUpdateListener.a(surfaceTexture.getTimestamp());
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int i8, int i9) {
            Logger.a("TextureViewImpl", "SurfaceTexture available. Size: " + i8 + "x" + i9);
            TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
            textureViewImplementation.f4155f = surfaceTexture;
            if (textureViewImplementation.f4156g != null) {
                Preconditions.g(textureViewImplementation.f4157h);
                Logger.a("TextureViewImpl", "Surface invalidated " + TextureViewImplementation.this.f4157h);
                TextureViewImplementation.this.f4157h.k().c();
                return;
            }
            textureViewImplementation.v();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NonNull final SurfaceTexture surfaceTexture) {
            TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
            textureViewImplementation.f4155f = null;
            ListenableFuture<SurfaceRequest.Result> listenableFuture = textureViewImplementation.f4156g;
            if (listenableFuture != null) {
                Futures.b(listenableFuture, new FutureCallback<SurfaceRequest.Result>() { // from class: androidx.camera.view.TextureViewImplementation.1.1
                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    /* renamed from: a */
                    public void onSuccess(SurfaceRequest.Result result) {
                        boolean z7;
                        if (result.a() != 3) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        Preconditions.j(z7, "Unexpected result from SurfaceRequest. Surface was provided twice.");
                        Logger.a("TextureViewImpl", "SurfaceTexture about to manually be destroyed");
                        surfaceTexture.release();
                        TextureViewImplementation textureViewImplementation2 = TextureViewImplementation.this;
                        if (textureViewImplementation2.f4159j != null) {
                            textureViewImplementation2.f4159j = null;
                        }
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(@NonNull Throwable th) {
                        throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th);
                    }
                }, ContextCompat.getMainExecutor(TextureViewImplementation.this.f4154e.getContext()));
                TextureViewImplementation.this.f4159j = surfaceTexture;
                return false;
            }
            Logger.a("TextureViewImpl", "SurfaceTexture about to be destroyed");
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i8, int i9) {
            Logger.a("TextureViewImpl", "SurfaceTexture size changed: " + i8 + "x" + i9);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NonNull final SurfaceTexture surfaceTexture) {
            CallbackToFutureAdapter.Completer<Void> andSet = TextureViewImplementation.this.f4160k.getAndSet(null);
            if (andSet != null) {
                andSet.c(null);
            }
            TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
            final PreviewView.OnFrameUpdateListener onFrameUpdateListener = textureViewImplementation.f4162m;
            Executor executor = textureViewImplementation.f4163n;
            if (onFrameUpdateListener != null && executor != null) {
                executor.execute(new Runnable() { // from class: androidx.camera.view.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        TextureViewImplementation.AnonymousClass1.b(PreviewView.OnFrameUpdateListener.this, surfaceTexture);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextureViewImplementation(@NonNull FrameLayout frameLayout, @NonNull PreviewTransformation previewTransformation) {
        super(frameLayout, previewTransformation);
        this.f4158i = false;
        this.f4160k = new AtomicReference<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(SurfaceRequest surfaceRequest) {
        SurfaceRequest surfaceRequest2 = this.f4157h;
        if (surfaceRequest2 != null && surfaceRequest2 == surfaceRequest) {
            this.f4157h = null;
            this.f4156g = null;
        }
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(Surface surface, final CallbackToFutureAdapter.Completer completer) throws Exception {
        Logger.a("TextureViewImpl", "Surface set on Preview.");
        SurfaceRequest surfaceRequest = this.f4157h;
        Executor a8 = CameraXExecutors.a();
        Objects.requireNonNull(completer);
        surfaceRequest.v(surface, a8, new Consumer() { // from class: androidx.camera.view.p
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                CallbackToFutureAdapter.Completer.this.c((SurfaceRequest.Result) obj);
            }
        });
        return "provideSurface[request=" + this.f4157h + " surface=" + surface + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(Surface surface, ListenableFuture listenableFuture, SurfaceRequest surfaceRequest) {
        Logger.a("TextureViewImpl", "Safe to release surface.");
        t();
        surface.release();
        if (this.f4156g == listenableFuture) {
            this.f4156g = null;
        }
        if (this.f4157h == surfaceRequest) {
            this.f4157h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.f4160k.set(completer);
        return "textureViewImpl_waitForNextFrame";
    }

    private void t() {
        PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener = this.f4161l;
        if (onSurfaceNotInUseListener != null) {
            onSurfaceNotInUseListener.a();
            this.f4161l = null;
        }
    }

    private void u() {
        if (this.f4158i && this.f4159j != null) {
            SurfaceTexture surfaceTexture = this.f4154e.getSurfaceTexture();
            SurfaceTexture surfaceTexture2 = this.f4159j;
            if (surfaceTexture != surfaceTexture2) {
                this.f4154e.setSurfaceTexture(surfaceTexture2);
                this.f4159j = null;
                this.f4158i = false;
            }
        }
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    View b() {
        return this.f4154e;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    Bitmap c() {
        TextureView textureView = this.f4154e;
        if (textureView != null && textureView.isAvailable()) {
            return this.f4154e.getBitmap();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void d() {
        u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void e() {
        this.f4158i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void g(@NonNull final SurfaceRequest surfaceRequest, PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
        this.f4136a = surfaceRequest.l();
        this.f4161l = onSurfaceNotInUseListener;
        o();
        SurfaceRequest surfaceRequest2 = this.f4157h;
        if (surfaceRequest2 != null) {
            surfaceRequest2.y();
        }
        this.f4157h = surfaceRequest;
        surfaceRequest.i(ContextCompat.getMainExecutor(this.f4154e.getContext()), new Runnable() { // from class: androidx.camera.view.m
            @Override // java.lang.Runnable
            public final void run() {
                TextureViewImplementation.this.p(surfaceRequest);
            }
        });
        v();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void i(@NonNull Executor executor, @NonNull PreviewView.OnFrameUpdateListener onFrameUpdateListener) {
        this.f4162m = onFrameUpdateListener;
        this.f4163n = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    @NonNull
    public ListenableFuture<Void> j() {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.view.q
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object s7;
                s7 = TextureViewImplementation.this.s(completer);
                return s7;
            }
        });
    }

    public void o() {
        Preconditions.g(this.f4137b);
        Preconditions.g(this.f4136a);
        TextureView textureView = new TextureView(this.f4137b.getContext());
        this.f4154e = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.f4136a.getWidth(), this.f4136a.getHeight()));
        this.f4154e.setSurfaceTextureListener(new AnonymousClass1());
        this.f4137b.removeAllViews();
        this.f4137b.addView(this.f4154e);
    }

    void v() {
        SurfaceTexture surfaceTexture;
        Size size = this.f4136a;
        if (size != null && (surfaceTexture = this.f4155f) != null && this.f4157h != null) {
            surfaceTexture.setDefaultBufferSize(size.getWidth(), this.f4136a.getHeight());
            final Surface surface = new Surface(this.f4155f);
            final SurfaceRequest surfaceRequest = this.f4157h;
            final ListenableFuture<SurfaceRequest.Result> a8 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.view.n
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object a(CallbackToFutureAdapter.Completer completer) {
                    Object q8;
                    q8 = TextureViewImplementation.this.q(surface, completer);
                    return q8;
                }
            });
            this.f4156g = a8;
            a8.f(new Runnable() { // from class: androidx.camera.view.o
                @Override // java.lang.Runnable
                public final void run() {
                    TextureViewImplementation.this.r(surface, a8, surfaceRequest);
                }
            }, ContextCompat.getMainExecutor(this.f4154e.getContext()));
            f();
        }
    }
}
