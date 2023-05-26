package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.core.util.Preconditions;
import java.util.Collections;

/* loaded from: classes.dex */
public class SurfaceProcessorNode {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceOutput.GlTransformOptions f4002a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final SurfaceProcessorInternal f4003b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final CameraInternal f4004c;

    /* renamed from: d  reason: collision with root package name */
    private SurfaceEdge f4005d;

    /* renamed from: e  reason: collision with root package name */
    private SurfaceEdge f4006e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.core.processing.SurfaceProcessorNode$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4011a;

        static {
            int[] iArr = new int[SurfaceOutput.GlTransformOptions.values().length];
            f4011a = iArr;
            try {
                iArr[SurfaceOutput.GlTransformOptions.APPLY_CROP_ROTATE_AND_MIRRORING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4011a[SurfaceOutput.GlTransformOptions.USE_SURFACE_TEXTURE_TRANSFORM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SurfaceProcessorNode(@NonNull CameraInternal cameraInternal, @NonNull SurfaceOutput.GlTransformOptions glTransformOptions, @NonNull SurfaceProcessorInternal surfaceProcessorInternal) {
        this.f4004c = cameraInternal;
        this.f4002a = glTransformOptions;
        this.f4003b = surfaceProcessorInternal;
    }

    @NonNull
    private SettableSurface c(@NonNull SettableSurface settableSurface) {
        Size h8;
        int i8 = AnonymousClass2.f4011a[this.f4002a.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return new SettableSurface(settableSurface.C(), settableSurface.B(), settableSurface.x(), settableSurface.A(), false, settableSurface.w(), settableSurface.z(), settableSurface.y());
            }
            throw new AssertionError("Unknown GlTransformOptions: " + this.f4002a);
        }
        Size B = settableSurface.B();
        Rect w7 = settableSurface.w();
        int z7 = settableSurface.z();
        boolean y7 = settableSurface.y();
        if (TransformUtils.f(z7)) {
            h8 = new Size(w7.height(), w7.width());
        } else {
            h8 = TransformUtils.h(w7);
        }
        Size size = h8;
        Matrix matrix = new Matrix(settableSurface.A());
        matrix.postConcat(TransformUtils.d(TransformUtils.m(B), new RectF(w7), z7, y7));
        return new SettableSurface(settableSurface.C(), size, settableSurface.x(), matrix, false, TransformUtils.k(size), 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        SurfaceEdge surfaceEdge = this.f4005d;
        if (surfaceEdge != null) {
            for (SettableSurface settableSurface : surfaceEdge.b()) {
                settableSurface.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(SurfaceOutput surfaceOutput, SettableSurface settableSurface, SettableSurface settableSurface2, SurfaceRequest.TransformationInfo transformationInfo) {
        int b8 = transformationInfo.b() - surfaceOutput.c();
        if (settableSurface.y()) {
            b8 = -b8;
        }
        settableSurface2.K(TransformUtils.p(b8));
    }

    private void g(@NonNull final SettableSurface settableSurface, @NonNull final SettableSurface settableSurface2) {
        final SurfaceRequest u7 = settableSurface.u(this.f4004c);
        Futures.b(settableSurface2.t(this.f4002a, settableSurface.B(), settableSurface.w(), settableSurface.z(), settableSurface.y()), new FutureCallback<SurfaceOutput>() { // from class: androidx.camera.core.processing.SurfaceProcessorNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(SurfaceOutput surfaceOutput) {
                Preconditions.g(surfaceOutput);
                SurfaceProcessorNode.this.f4003b.b(surfaceOutput);
                SurfaceProcessorNode.this.f4003b.a(u7);
                SurfaceProcessorNode.this.h(settableSurface, u7, settableSurface2, surfaceOutput);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                u7.y();
            }
        }, CameraXExecutors.d());
    }

    public void f() {
        this.f4003b.release();
        CameraXExecutors.d().execute(new Runnable() { // from class: i.g
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceProcessorNode.this.d();
            }
        });
    }

    void h(@NonNull final SettableSurface settableSurface, @NonNull SurfaceRequest surfaceRequest, @NonNull final SettableSurface settableSurface2, @NonNull final SurfaceOutput surfaceOutput) {
        surfaceRequest.w(CameraXExecutors.d(), new SurfaceRequest.TransformationInfoListener() { // from class: i.f
            @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
            public final void a(SurfaceRequest.TransformationInfo transformationInfo) {
                SurfaceProcessorNode.e(SurfaceOutput.this, settableSurface, settableSurface2, transformationInfo);
            }
        });
    }

    @NonNull
    public SurfaceEdge i(@NonNull SurfaceEdge surfaceEdge) {
        Threads.a();
        boolean z7 = true;
        if (surfaceEdge.b().size() != 1) {
            z7 = false;
        }
        Preconditions.b(z7, "Multiple input stream not supported yet.");
        this.f4006e = surfaceEdge;
        SettableSurface settableSurface = surfaceEdge.b().get(0);
        SettableSurface c8 = c(settableSurface);
        g(settableSurface, c8);
        SurfaceEdge a8 = SurfaceEdge.a(Collections.singletonList(c8));
        this.f4005d = a8;
        return a8;
    }
}
