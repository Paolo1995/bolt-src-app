package androidx.camera.core.processing;

import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SurfaceOutputImpl implements SurfaceOutput {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Surface f3986b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3987c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3988d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Size f3989e;

    /* renamed from: f  reason: collision with root package name */
    private final SurfaceOutput.GlTransformOptions f3990f;

    /* renamed from: g  reason: collision with root package name */
    private final Size f3991g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f3992h;

    /* renamed from: i  reason: collision with root package name */
    private final int f3993i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f3994j;

    /* renamed from: l  reason: collision with root package name */
    private Consumer<SurfaceOutput.Event> f3996l;

    /* renamed from: m  reason: collision with root package name */
    private Executor f3997m;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    private final ListenableFuture<Void> f4000p;

    /* renamed from: q  reason: collision with root package name */
    private CallbackToFutureAdapter.Completer<Void> f4001q;

    /* renamed from: a  reason: collision with root package name */
    private final Object f3985a = new Object();
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final float[] f3995k = new float[16];

    /* renamed from: n  reason: collision with root package name */
    private boolean f3998n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f3999o = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SurfaceOutputImpl(@NonNull Surface surface, int i8, int i9, @NonNull Size size, @NonNull SurfaceOutput.GlTransformOptions glTransformOptions, @NonNull Size size2, @NonNull Rect rect, int i10, boolean z7) {
        this.f3986b = surface;
        this.f3987c = i8;
        this.f3988d = i9;
        this.f3989e = size;
        this.f3990f = glTransformOptions;
        this.f3991g = size2;
        this.f3992h = new Rect(rect);
        this.f3994j = z7;
        if (glTransformOptions == SurfaceOutput.GlTransformOptions.APPLY_CROP_ROTATE_AND_MIRRORING) {
            this.f3993i = i10;
            d();
        } else {
            this.f3993i = 0;
        }
        this.f4000p = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object f8;
                f8 = SurfaceOutputImpl.this.f(completer);
                return f8;
            }
        });
    }

    private void d() {
        Matrix.setIdentityM(this.f3995k, 0);
        Matrix.translateM(this.f3995k, 0, 0.0f, 1.0f, 0.0f);
        Matrix.scaleM(this.f3995k, 0, 1.0f, -1.0f, 1.0f);
        MatrixExt.c(this.f3995k, this.f3993i, 0.5f, 0.5f);
        if (this.f3994j) {
            Matrix.translateM(this.f3995k, 0, 1.0f, 0.0f, 0.0f);
            Matrix.scaleM(this.f3995k, 0, -1.0f, 1.0f, 1.0f);
        }
        Size j8 = TransformUtils.j(this.f3991g, this.f3993i);
        android.graphics.Matrix d8 = TransformUtils.d(TransformUtils.m(this.f3991g), TransformUtils.m(j8), this.f3993i, this.f3994j);
        RectF rectF = new RectF(this.f3992h);
        d8.mapRect(rectF);
        float width = rectF.left / j8.getWidth();
        float height = ((j8.getHeight() - rectF.height()) - rectF.top) / j8.getHeight();
        float height2 = rectF.height() / j8.getHeight();
        Matrix.translateM(this.f3995k, 0, width, height, 0.0f);
        Matrix.scaleM(this.f3995k, 0, rectF.width() / j8.getWidth(), height2, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object f(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.f4001q = completer;
        return "SurfaceOutputImpl close future complete";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(AtomicReference atomicReference) {
        ((Consumer) atomicReference.get()).accept(SurfaceOutput.Event.c(0, this));
    }

    @Override // androidx.camera.core.SurfaceOutput
    public int c() {
        return this.f3993i;
    }

    @NonNull
    public ListenableFuture<Void> e() {
        return this.f4000p;
    }

    public void h() {
        Executor executor;
        Consumer<SurfaceOutput.Event> consumer;
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (this.f3985a) {
            if (this.f3997m != null && (consumer = this.f3996l) != null) {
                if (!this.f3999o) {
                    atomicReference.set(consumer);
                    executor = this.f3997m;
                    this.f3998n = false;
                }
                executor = null;
            }
            this.f3998n = true;
            executor = null;
        }
        if (executor != null) {
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.core.processing.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        SurfaceOutputImpl.this.g(atomicReference);
                    }
                });
            } catch (RejectedExecutionException e8) {
                Logger.b("SurfaceOutputImpl", "Processor executor closed. Close request not posted.", e8);
            }
        }
    }
}
