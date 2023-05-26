package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ImageAnalysis extends UseCase {

    /* renamed from: q  reason: collision with root package name */
    public static final Defaults f3102q = new Defaults();

    /* renamed from: r  reason: collision with root package name */
    private static final Boolean f3103r = null;

    /* renamed from: m  reason: collision with root package name */
    final ImageAnalysisAbstractAnalyzer f3104m;

    /* renamed from: n  reason: collision with root package name */
    private final Object f3105n;

    /* renamed from: o  reason: collision with root package name */
    private Analyzer f3106o;

    /* renamed from: p  reason: collision with root package name */
    private DeferrableSurface f3107p;

    /* loaded from: classes.dex */
    public interface Analyzer {
        Size a();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface BackpressureStrategy {
    }

    /* loaded from: classes.dex */
    public static final class Builder implements UseCaseConfig.Builder<ImageAnalysis, ImageAnalysisConfig, Builder> {

        /* renamed from: a  reason: collision with root package name */
        private final MutableOptionsBundle f3108a;

        public Builder() {
            this(MutableOptionsBundle.L());
        }

        @NonNull
        static Builder c(@NonNull Config config) {
            return new Builder(MutableOptionsBundle.M(config));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public MutableConfig a() {
            return this.f3108a;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        /* renamed from: d */
        public ImageAnalysisConfig b() {
            return new ImageAnalysisConfig(OptionsBundle.J(this.f3108a));
        }

        @NonNull
        public Builder e(@NonNull Size size) {
            a().o(ImageOutputConfig.f3657k, size);
            return this;
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
        public Builder h(@NonNull Class<ImageAnalysis> cls) {
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
            this.f3108a = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.e(TargetConfig.f3911x, null);
            if (cls != null && !cls.equals(ImageAnalysis.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            h(ImageAnalysis.class);
        }
    }

    /* loaded from: classes.dex */
    public static final class Defaults {

        /* renamed from: a  reason: collision with root package name */
        private static final Size f3109a;

        /* renamed from: b  reason: collision with root package name */
        private static final ImageAnalysisConfig f3110b;

        static {
            Size size = new Size(640, 480);
            f3109a = size;
            f3110b = new Builder().e(size).f(1).g(0).b();
        }

        @NonNull
        public ImageAnalysisConfig a() {
            return f3110b;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OutputImageFormat {
    }

    private boolean T(@NonNull CameraInternal cameraInternal) {
        if (!U() || k(cameraInternal) % 180 == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(SafeCloseImageReaderProxy safeCloseImageReaderProxy, SafeCloseImageReaderProxy safeCloseImageReaderProxy2) {
        safeCloseImageReaderProxy.l();
        if (safeCloseImageReaderProxy2 != null) {
            safeCloseImageReaderProxy2.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(String str, ImageAnalysisConfig imageAnalysisConfig, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        N();
        this.f3104m.d();
        if (q(str)) {
            J(O(str, imageAnalysisConfig, size).m());
            u();
        }
    }

    private void X() {
        CameraInternal d8 = d();
        if (d8 != null) {
            this.f3104m.i(k(d8));
        }
    }

    @Override // androidx.camera.core.UseCase
    public void B() {
        N();
        this.f3104m.e();
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.UseCaseConfig] */
    @Override // androidx.camera.core.UseCase
    @NonNull
    protected UseCaseConfig<?> C(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        Size size;
        Boolean R = R();
        boolean a8 = cameraInfoInternal.d().a(OnePixelShiftQuirk.class);
        ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.f3104m;
        if (R != null) {
            a8 = R.booleanValue();
        }
        imageAnalysisAbstractAnalyzer.g(a8);
        synchronized (this.f3105n) {
            Analyzer analyzer = this.f3106o;
            if (analyzer != null) {
                size = analyzer.a();
            } else {
                size = null;
            }
        }
        if (size != null) {
            ?? b8 = builder.b();
            Config.Option<Size> option = ImageOutputConfig.f3656j;
            if (!b8.b(option)) {
                builder.a().o(option, size);
            }
        }
        return builder.b();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    protected Size F(@NonNull Size size) {
        J(O(f(), (ImageAnalysisConfig) g(), size).m());
        return size;
    }

    @Override // androidx.camera.core.UseCase
    public void H(@NonNull Matrix matrix) {
        super.H(matrix);
        this.f3104m.j(matrix);
    }

    @Override // androidx.camera.core.UseCase
    public void I(@NonNull Rect rect) {
        super.I(rect);
        this.f3104m.k(rect);
    }

    void N() {
        Threads.a();
        DeferrableSurface deferrableSurface = this.f3107p;
        if (deferrableSurface != null) {
            deferrableSurface.c();
            this.f3107p = null;
        }
    }

    SessionConfig.Builder O(@NonNull final String str, @NonNull final ImageAnalysisConfig imageAnalysisConfig, @NonNull final Size size) {
        int i8;
        final SafeCloseImageReaderProxy safeCloseImageReaderProxy;
        boolean z7;
        int width;
        int height;
        int i9;
        boolean z8;
        final SafeCloseImageReaderProxy safeCloseImageReaderProxy2;
        Threads.a();
        Executor executor = (Executor) Preconditions.g(imageAnalysisConfig.H(CameraXExecutors.b()));
        boolean z9 = true;
        if (P() == 1) {
            i8 = Q();
        } else {
            i8 = 4;
        }
        if (imageAnalysisConfig.K() != null) {
            safeCloseImageReaderProxy = new SafeCloseImageReaderProxy(imageAnalysisConfig.K().a(size.getWidth(), size.getHeight(), i(), i8, 0L));
        } else {
            safeCloseImageReaderProxy = new SafeCloseImageReaderProxy(ImageReaderProxys.a(size.getWidth(), size.getHeight(), i(), i8));
        }
        if (d() != null) {
            z7 = T(d());
        } else {
            z7 = false;
        }
        if (z7) {
            width = size.getHeight();
        } else {
            width = size.getWidth();
        }
        if (z7) {
            height = size.getWidth();
        } else {
            height = size.getHeight();
        }
        if (S() == 2) {
            i9 = 1;
        } else {
            i9 = 35;
        }
        if (i() == 35 && S() == 2) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (i() != 35 || ((d() == null || k(d()) == 0) && !Boolean.TRUE.equals(R()))) {
            z9 = false;
        }
        if (!z8 && !z9) {
            safeCloseImageReaderProxy2 = null;
        } else {
            safeCloseImageReaderProxy2 = new SafeCloseImageReaderProxy(ImageReaderProxys.a(width, height, i9, safeCloseImageReaderProxy.e()));
        }
        if (safeCloseImageReaderProxy2 != null) {
            this.f3104m.h(safeCloseImageReaderProxy2);
        }
        X();
        safeCloseImageReaderProxy.f(this.f3104m, executor);
        SessionConfig.Builder o8 = SessionConfig.Builder.o(imageAnalysisConfig);
        DeferrableSurface deferrableSurface = this.f3107p;
        if (deferrableSurface != null) {
            deferrableSurface.c();
        }
        ImmediateSurface immediateSurface = new ImmediateSurface(safeCloseImageReaderProxy.getSurface(), size, i());
        this.f3107p = immediateSurface;
        immediateSurface.i().f(new Runnable() { // from class: androidx.camera.core.m
            @Override // java.lang.Runnable
            public final void run() {
                ImageAnalysis.V(SafeCloseImageReaderProxy.this, safeCloseImageReaderProxy2);
            }
        }, CameraXExecutors.d());
        o8.k(this.f3107p);
        o8.f(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.n
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                ImageAnalysis.this.W(str, imageAnalysisConfig, size, sessionConfig, sessionError);
            }
        });
        return o8;
    }

    public int P() {
        return ((ImageAnalysisConfig) g()).I(0);
    }

    public int Q() {
        return ((ImageAnalysisConfig) g()).J(6);
    }

    public Boolean R() {
        return ((ImageAnalysisConfig) g()).L(f3103r);
    }

    public int S() {
        return ((ImageAnalysisConfig) g()).M(1);
    }

    public boolean U() {
        return ((ImageAnalysisConfig) g()).N(Boolean.FALSE).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> h(boolean z7, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config a8 = useCaseConfigFactory.a(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS, 1);
        if (z7) {
            a8 = androidx.camera.core.impl.g.b(a8, f3102q.a());
        }
        if (a8 == null) {
            return null;
        }
        return o(a8).b();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public UseCaseConfig.Builder<?, ?, ?> o(@NonNull Config config) {
        return Builder.c(config);
    }

    @NonNull
    public String toString() {
        return "ImageAnalysis:" + j();
    }

    @Override // androidx.camera.core.UseCase
    public void y() {
        this.f3104m.c();
    }
}
