package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInfoProcessor;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.processing.SettableSurface;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class Preview extends UseCase {

    /* renamed from: t  reason: collision with root package name */
    public static final Defaults f3221t = new Defaults();

    /* renamed from: u  reason: collision with root package name */
    private static final Executor f3222u = CameraXExecutors.d();

    /* renamed from: m  reason: collision with root package name */
    private SurfaceProvider f3223m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    private Executor f3224n;

    /* renamed from: o  reason: collision with root package name */
    private DeferrableSurface f3225o;

    /* renamed from: p  reason: collision with root package name */
    SurfaceRequest f3226p;

    /* renamed from: q  reason: collision with root package name */
    private Size f3227q;

    /* renamed from: r  reason: collision with root package name */
    private SurfaceProcessorInternal f3228r;

    /* renamed from: s  reason: collision with root package name */
    private SurfaceProcessorNode f3229s;

    /* loaded from: classes.dex */
    public static final class Builder implements UseCaseConfig.Builder<Preview, PreviewConfig, Builder> {

        /* renamed from: a  reason: collision with root package name */
        private final MutableOptionsBundle f3232a;

        public Builder() {
            this(MutableOptionsBundle.L());
        }

        @NonNull
        static Builder d(@NonNull Config config) {
            return new Builder(MutableOptionsBundle.M(config));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public MutableConfig a() {
            return this.f3232a;
        }

        @NonNull
        public Preview c() {
            if (a().e(ImageOutputConfig.f3653g, null) != null && a().e(ImageOutputConfig.f3656j, null) != null) {
                throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
            }
            return new Preview(b());
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        /* renamed from: e */
        public PreviewConfig b() {
            return new PreviewConfig(OptionsBundle.J(this.f3232a));
        }

        @NonNull
        public Builder f(int i8) {
            a().o(UseCaseConfig.f3720r, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder g(int i8) {
            a().o(ImageOutputConfig.f3653g, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder h(@NonNull Class<Preview> cls) {
            a().o(TargetConfig.f3911x, cls);
            if (a().e(TargetConfig.f3910w, null) == null) {
                i(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        @NonNull
        public Builder i(@NonNull String str) {
            a().o(TargetConfig.f3910w, str);
            return this;
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.f3232a = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.e(TargetConfig.f3911x, null);
            if (cls != null && !cls.equals(Preview.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            h(Preview.class);
        }
    }

    /* loaded from: classes.dex */
    public static final class Defaults {

        /* renamed from: a  reason: collision with root package name */
        private static final PreviewConfig f3233a = new Builder().f(2).g(0).b();

        @NonNull
        public PreviewConfig a() {
            return f3233a;
        }
    }

    /* loaded from: classes.dex */
    public interface SurfaceProvider {
        void a(@NonNull SurfaceRequest surfaceRequest);
    }

    Preview(@NonNull PreviewConfig previewConfig) {
        super(previewConfig);
        this.f3224n = f3222u;
    }

    private void N(@NonNull SessionConfig.Builder builder, @NonNull final String str, @NonNull final PreviewConfig previewConfig, @NonNull final Size size) {
        if (this.f3223m != null) {
            builder.k(this.f3225o);
        }
        builder.f(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.m0
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                Preview.this.S(str, previewConfig, size, sessionConfig, sessionError);
            }
        });
    }

    private void O() {
        DeferrableSurface deferrableSurface = this.f3225o;
        if (deferrableSurface != null) {
            deferrableSurface.c();
            this.f3225o = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.f3229s;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.f();
            this.f3229s = null;
        }
        this.f3226p = null;
    }

    @NonNull
    private SessionConfig.Builder Q(@NonNull String str, @NonNull PreviewConfig previewConfig, @NonNull Size size) {
        Threads.a();
        Preconditions.g(this.f3228r);
        CameraInternal d8 = d();
        Preconditions.g(d8);
        O();
        this.f3229s = new SurfaceProcessorNode(d8, SurfaceOutput.GlTransformOptions.USE_SURFACE_TEXTURE_TRANSFORM, this.f3228r);
        Matrix matrix = new Matrix();
        Rect R = R(size);
        Objects.requireNonNull(R);
        SettableSurface settableSurface = new SettableSurface(1, size, 34, matrix, true, R, k(d8), false);
        SurfaceEdge a8 = SurfaceEdge.a(Collections.singletonList(settableSurface));
        this.f3225o = settableSurface;
        this.f3226p = this.f3229s.i(a8).b().get(0).u(d8);
        if (this.f3223m != null) {
            U();
        }
        SessionConfig.Builder o8 = SessionConfig.Builder.o(previewConfig);
        N(o8, str, previewConfig, size);
        return o8;
    }

    private Rect R(Size size) {
        if (p() != null) {
            return p();
        }
        if (size != null) {
            return new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(String str, PreviewConfig previewConfig, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (q(str)) {
            J(P(str, previewConfig, size).m());
            u();
        }
    }

    private void U() {
        final SurfaceProvider surfaceProvider = (SurfaceProvider) Preconditions.g(this.f3223m);
        final SurfaceRequest surfaceRequest = (SurfaceRequest) Preconditions.g(this.f3226p);
        this.f3224n.execute(new Runnable() { // from class: androidx.camera.core.l0
            @Override // java.lang.Runnable
            public final void run() {
                Preview.SurfaceProvider.this.a(surfaceRequest);
            }
        });
        V();
    }

    private void V() {
        CameraInternal d8 = d();
        SurfaceProvider surfaceProvider = this.f3223m;
        Rect R = R(this.f3227q);
        SurfaceRequest surfaceRequest = this.f3226p;
        if (d8 != null && surfaceProvider != null && R != null && surfaceRequest != null) {
            surfaceRequest.x(SurfaceRequest.TransformationInfo.d(R, k(d8), b()));
        }
    }

    private void Z(@NonNull String str, @NonNull PreviewConfig previewConfig, @NonNull Size size) {
        J(P(str, previewConfig, size).m());
    }

    @Override // androidx.camera.core.UseCase
    public void B() {
        O();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    @NonNull
    protected UseCaseConfig<?> C(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        if (builder.a().e(PreviewConfig.C, null) != null) {
            builder.a().o(ImageInputConfig.f3652f, 35);
        } else {
            builder.a().o(ImageInputConfig.f3652f, 34);
        }
        return builder.b();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    protected Size F(@NonNull Size size) {
        this.f3227q = size;
        Z(f(), (PreviewConfig) g(), this.f3227q);
        return size;
    }

    @Override // androidx.camera.core.UseCase
    public void I(@NonNull Rect rect) {
        super.I(rect);
        V();
    }

    SessionConfig.Builder P(@NonNull String str, @NonNull PreviewConfig previewConfig, @NonNull Size size) {
        if (this.f3228r != null) {
            return Q(str, previewConfig, size);
        }
        Threads.a();
        SessionConfig.Builder o8 = SessionConfig.Builder.o(previewConfig);
        CaptureProcessor H = previewConfig.H(null);
        O();
        SurfaceRequest surfaceRequest = new SurfaceRequest(size, d(), previewConfig.J(false));
        this.f3226p = surfaceRequest;
        if (this.f3223m != null) {
            U();
        }
        if (H != null) {
            CaptureStage.DefaultCaptureStage defaultCaptureStage = new CaptureStage.DefaultCaptureStage();
            final HandlerThread handlerThread = new HandlerThread("CameraX-preview_processing");
            handlerThread.start();
            String num = Integer.toString(defaultCaptureStage.hashCode());
            ProcessingSurface processingSurface = new ProcessingSurface(size.getWidth(), size.getHeight(), previewConfig.getInputFormat(), new Handler(handlerThread.getLooper()), defaultCaptureStage, H, surfaceRequest.k(), num);
            o8.d(processingSurface.s());
            processingSurface.i().f(new Runnable() { // from class: androidx.camera.core.k0
                @Override // java.lang.Runnable
                public final void run() {
                    handlerThread.quitSafely();
                }
            }, CameraXExecutors.a());
            this.f3225o = processingSurface;
            o8.l(num, Integer.valueOf(defaultCaptureStage.getId()));
        } else {
            final ImageInfoProcessor I = previewConfig.I(null);
            if (I != null) {
                o8.d(new CameraCaptureCallback() { // from class: androidx.camera.core.Preview.1
                    @Override // androidx.camera.core.impl.CameraCaptureCallback
                    public void b(@NonNull CameraCaptureResult cameraCaptureResult) {
                        super.b(cameraCaptureResult);
                        if (I.a(new CameraCaptureResultImageInfo(cameraCaptureResult))) {
                            Preview.this.w();
                        }
                    }
                });
            }
            this.f3225o = surfaceRequest.k();
        }
        N(o8, str, previewConfig, size);
        return o8;
    }

    public void W(SurfaceProcessorInternal surfaceProcessorInternal) {
        this.f3228r = surfaceProcessorInternal;
    }

    public void X(SurfaceProvider surfaceProvider) {
        Y(f3222u, surfaceProvider);
    }

    public void Y(@NonNull Executor executor, SurfaceProvider surfaceProvider) {
        Threads.a();
        if (surfaceProvider == null) {
            this.f3223m = null;
            t();
            return;
        }
        this.f3223m = surfaceProvider;
        this.f3224n = executor;
        s();
        if (c() != null) {
            Z(f(), (PreviewConfig) g(), c());
            u();
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> h(boolean z7, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config a8 = useCaseConfigFactory.a(UseCaseConfigFactory.CaptureType.PREVIEW, 1);
        if (z7) {
            a8 = androidx.camera.core.impl.g.b(a8, f3221t.a());
        }
        if (a8 == null) {
            return null;
        }
        return o(a8).b();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public UseCaseConfig.Builder<?, ?, ?> o(@NonNull Config config) {
        return Builder.d(config);
    }

    @NonNull
    public String toString() {
        return "Preview:" + j();
    }
}
