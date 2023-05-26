package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.internal.compat.quirk.DeviceQuirks;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import androidx.camera.view.transform.OutputTransform;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class PreviewView extends FrameLayout {

    /* renamed from: u  reason: collision with root package name */
    private static final ImplementationMode f4100u = ImplementationMode.PERFORMANCE;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    ImplementationMode f4101f;

    /* renamed from: g  reason: collision with root package name */
    PreviewViewImplementation f4102g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    final PreviewTransformation f4103h;

    /* renamed from: i  reason: collision with root package name */
    boolean f4104i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    final MutableLiveData<StreamState> f4105j;

    /* renamed from: k  reason: collision with root package name */
    final AtomicReference<PreviewStreamStateObserver> f4106k;

    /* renamed from: l  reason: collision with root package name */
    OnFrameUpdateListener f4107l;

    /* renamed from: m  reason: collision with root package name */
    Executor f4108m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    PreviewViewMeteringPointFactory f4109n;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    private final ScaleGestureDetector f4110o;

    /* renamed from: p  reason: collision with root package name */
    CameraInfoInternal f4111p;

    /* renamed from: q  reason: collision with root package name */
    private MotionEvent f4112q;
    @NonNull

    /* renamed from: r  reason: collision with root package name */
    private final DisplayRotationListener f4113r;

    /* renamed from: s  reason: collision with root package name */
    private final View.OnLayoutChangeListener f4114s;

    /* renamed from: t  reason: collision with root package name */
    final Preview.SurfaceProvider f4115t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.view.PreviewView$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Preview.SurfaceProvider {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(SurfaceRequest surfaceRequest) {
            PreviewView.this.f4115t.a(surfaceRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(CameraInternal cameraInternal, SurfaceRequest surfaceRequest, SurfaceRequest.TransformationInfo transformationInfo) {
            boolean z7;
            PreviewView previewView;
            PreviewViewImplementation previewViewImplementation;
            Logger.a("PreviewView", "Preview transformation info updated. " + transformationInfo);
            Integer c8 = cameraInternal.j().c();
            if (c8 == null) {
                Logger.k("PreviewView", "The lens facing is null, probably an external.");
            } else if (c8.intValue() != 0) {
                z7 = false;
                PreviewView.this.f4103h.p(transformationInfo, surfaceRequest.l(), z7);
                if (transformationInfo.c() == -1 && ((previewViewImplementation = (previewView = PreviewView.this).f4102g) == null || !(previewViewImplementation instanceof SurfaceViewImplementation))) {
                    previewView.f4104i = false;
                } else {
                    PreviewView.this.f4104i = true;
                }
                PreviewView.this.i();
                PreviewView.this.e();
            }
            z7 = true;
            PreviewView.this.f4103h.p(transformationInfo, surfaceRequest.l(), z7);
            if (transformationInfo.c() == -1) {
            }
            PreviewView.this.f4104i = true;
            PreviewView.this.i();
            PreviewView.this.e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(PreviewStreamStateObserver previewStreamStateObserver, CameraInternal cameraInternal) {
            if (e.a(PreviewView.this.f4106k, previewStreamStateObserver, null)) {
                previewStreamStateObserver.l(StreamState.IDLE);
            }
            previewStreamStateObserver.f();
            cameraInternal.m().b(previewStreamStateObserver);
        }

        @Override // androidx.camera.core.Preview.SurfaceProvider
        public void a(@NonNull final SurfaceRequest surfaceRequest) {
            PreviewViewImplementation surfaceViewImplementation;
            Executor executor;
            if (!Threads.b()) {
                ContextCompat.getMainExecutor(PreviewView.this.getContext()).execute(new Runnable() { // from class: androidx.camera.view.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        PreviewView.AnonymousClass1.this.e(surfaceRequest);
                    }
                });
                return;
            }
            Logger.a("PreviewView", "Surface requested by Preview.");
            final CameraInternal j8 = surfaceRequest.j();
            PreviewView.this.f4111p = j8.j();
            surfaceRequest.w(ContextCompat.getMainExecutor(PreviewView.this.getContext()), new SurfaceRequest.TransformationInfoListener() { // from class: androidx.camera.view.g
                @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
                public final void a(SurfaceRequest.TransformationInfo transformationInfo) {
                    PreviewView.AnonymousClass1.this.f(j8, surfaceRequest, transformationInfo);
                }
            });
            PreviewView previewView = PreviewView.this;
            if (PreviewView.f(surfaceRequest, previewView.f4101f)) {
                PreviewView previewView2 = PreviewView.this;
                surfaceViewImplementation = new TextureViewImplementation(previewView2, previewView2.f4103h);
            } else {
                PreviewView previewView3 = PreviewView.this;
                surfaceViewImplementation = new SurfaceViewImplementation(previewView3, previewView3.f4103h);
            }
            previewView.f4102g = surfaceViewImplementation;
            CameraInfoInternal j9 = j8.j();
            PreviewView previewView4 = PreviewView.this;
            final PreviewStreamStateObserver previewStreamStateObserver = new PreviewStreamStateObserver(j9, previewView4.f4105j, previewView4.f4102g);
            PreviewView.this.f4106k.set(previewStreamStateObserver);
            j8.m().a(ContextCompat.getMainExecutor(PreviewView.this.getContext()), previewStreamStateObserver);
            PreviewView.this.f4102g.g(surfaceRequest, new PreviewViewImplementation.OnSurfaceNotInUseListener() { // from class: androidx.camera.view.h
                @Override // androidx.camera.view.PreviewViewImplementation.OnSurfaceNotInUseListener
                public final void a() {
                    PreviewView.AnonymousClass1.this.g(previewStreamStateObserver, j8);
                }
            });
            PreviewView previewView5 = PreviewView.this;
            OnFrameUpdateListener onFrameUpdateListener = previewView5.f4107l;
            if (onFrameUpdateListener != null && (executor = previewView5.f4108m) != null) {
                previewView5.f4102g.i(executor, onFrameUpdateListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.view.PreviewView$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4117a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f4118b;

        static {
            int[] iArr = new int[ImplementationMode.values().length];
            f4118b = iArr;
            try {
                iArr[ImplementationMode.COMPATIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4118b[ImplementationMode.PERFORMANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ScaleType.values().length];
            f4117a = iArr2;
            try {
                iArr2[ScaleType.FILL_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4117a[ScaleType.FILL_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4117a[ScaleType.FILL_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4117a[ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4117a[ScaleType.FIT_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4117a[ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DisplayRotationListener implements DisplayManager.DisplayListener {
        DisplayRotationListener() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i8) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i8) {
            Display display = PreviewView.this.getDisplay();
            if (display != null && display.getDisplayId() == i8) {
                PreviewView.this.i();
                PreviewView.this.e();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i8) {
        }
    }

    /* loaded from: classes.dex */
    public enum ImplementationMode {
        PERFORMANCE(0),
        COMPATIBLE(1);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f4123f;

        ImplementationMode(int i8) {
            this.f4123f = i8;
        }

        static ImplementationMode a(int i8) {
            ImplementationMode[] values;
            for (ImplementationMode implementationMode : values()) {
                if (implementationMode.f4123f == i8) {
                    return implementationMode;
                }
            }
            throw new IllegalArgumentException("Unknown implementation mode id " + i8);
        }

        int c() {
            return this.f4123f;
        }
    }

    /* loaded from: classes.dex */
    public interface OnFrameUpdateListener {
        void a(long j8);
    }

    /* loaded from: classes.dex */
    class PinchToZoomOnScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        PinchToZoomOnScaleGestureListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            PreviewView.this.getClass();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public enum ScaleType {
        FILL_START(0),
        FILL_CENTER(1),
        FILL_END(2),
        FIT_START(3),
        FIT_CENTER(4),
        FIT_END(5);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f4132f;

        ScaleType(int i8) {
            this.f4132f = i8;
        }

        static ScaleType a(int i8) {
            ScaleType[] values;
            for (ScaleType scaleType : values()) {
                if (scaleType.f4132f == i8) {
                    return scaleType;
                }
            }
            throw new IllegalArgumentException("Unknown scale type id " + i8);
        }

        int c() {
            return this.f4132f;
        }
    }

    /* loaded from: classes.dex */
    public enum StreamState {
        IDLE,
        STREAMING
    }

    public PreviewView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(boolean z7) {
        Threads.a();
        getDisplay();
        getViewPort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        boolean z7;
        if (i10 - i8 == i14 - i12 && i11 - i9 == i15 - i13) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            e();
            b(true);
        }
    }

    static boolean f(@NonNull SurfaceRequest surfaceRequest, @NonNull ImplementationMode implementationMode) {
        boolean z7;
        int i8;
        boolean equals = surfaceRequest.j().j().f().equals("androidx.camera.camera2.legacy");
        if (DeviceQuirks.a(SurfaceViewStretchedQuirk.class) == null && DeviceQuirks.a(SurfaceViewNotCroppedByParentQuirk.class) == null) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (surfaceRequest.m() || Build.VERSION.SDK_INT <= 24 || equals || z7 || (i8 = AnonymousClass2.f4118b[implementationMode.ordinal()]) == 1) {
            return true;
        }
        if (i8 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid implementation mode: " + implementationMode);
    }

    private void g() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager == null) {
            return;
        }
        displayManager.registerDisplayListener(this.f4113r, new Handler(Looper.getMainLooper()));
    }

    private DisplayManager getDisplayManager() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return (DisplayManager) context.getApplicationContext().getSystemService("display");
    }

    private int getViewPortScaleType() {
        switch (AnonymousClass2.f4117a[getScaleType().ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 0;
            case 4:
            case 5:
            case 6:
                return 3;
            default:
                throw new IllegalStateException("Unexpected scale type: " + getScaleType());
        }
    }

    private void h() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager == null) {
            return;
        }
        displayManager.unregisterDisplayListener(this.f4113r);
    }

    @SuppressLint({"WrongConstant"})
    public ViewPort c(int i8) {
        Threads.a();
        if (getWidth() != 0 && getHeight() != 0) {
            return new ViewPort.Builder(new Rational(getWidth(), getHeight()), i8).c(getViewPortScaleType()).b(getLayoutDirection()).a();
        }
        return null;
    }

    void e() {
        Threads.a();
        PreviewViewImplementation previewViewImplementation = this.f4102g;
        if (previewViewImplementation != null) {
            previewViewImplementation.h();
        }
        this.f4109n.a(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    public Bitmap getBitmap() {
        Threads.a();
        PreviewViewImplementation previewViewImplementation = this.f4102g;
        if (previewViewImplementation == null) {
            return null;
        }
        return previewViewImplementation.a();
    }

    public CameraController getController() {
        Threads.a();
        return null;
    }

    @NonNull
    public ImplementationMode getImplementationMode() {
        Threads.a();
        return this.f4101f;
    }

    @NonNull
    public MeteringPointFactory getMeteringPointFactory() {
        Threads.a();
        return this.f4109n;
    }

    public OutputTransform getOutputTransform() {
        Matrix matrix;
        Threads.a();
        try {
            matrix = this.f4103h.h(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            matrix = null;
        }
        Rect g8 = this.f4103h.g();
        if (matrix != null && g8 != null) {
            matrix.preConcat(TransformUtils.a(g8));
            if (this.f4102g instanceof TextureViewImplementation) {
                matrix.postConcat(getMatrix());
            } else {
                Logger.k("PreviewView", "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
            }
            return new OutputTransform(matrix, new Size(g8.width(), g8.height()));
        }
        Logger.a("PreviewView", "Transform info is not ready");
        return null;
    }

    @NonNull
    public LiveData<StreamState> getPreviewStreamState() {
        return this.f4105j;
    }

    @NonNull
    public ScaleType getScaleType() {
        Threads.a();
        return this.f4103h.f();
    }

    @NonNull
    public Preview.SurfaceProvider getSurfaceProvider() {
        Threads.a();
        return this.f4115t;
    }

    public ViewPort getViewPort() {
        Threads.a();
        if (getDisplay() == null) {
            return null;
        }
        return c(getDisplay().getRotation());
    }

    void i() {
        Display display;
        CameraInfoInternal cameraInfoInternal;
        if (this.f4104i && (display = getDisplay()) != null && (cameraInfoInternal = this.f4111p) != null) {
            this.f4103h.m(cameraInfoInternal.g(display.getRotation()), display.getRotation());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
        g();
        addOnLayoutChangeListener(this.f4114s);
        PreviewViewImplementation previewViewImplementation = this.f4102g;
        if (previewViewImplementation != null) {
            previewViewImplementation.d();
        }
        b(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.f4114s);
        PreviewViewImplementation previewViewImplementation = this.f4102g;
        if (previewViewImplementation != null) {
            previewViewImplementation.e();
        }
        h();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        this.f4112q = null;
        return super.performClick();
    }

    public void setController(CameraController cameraController) {
        Threads.a();
        b(false);
    }

    public void setImplementationMode(@NonNull ImplementationMode implementationMode) {
        Threads.a();
        this.f4101f = implementationMode;
        if (implementationMode == ImplementationMode.PERFORMANCE && this.f4107l != null) {
            throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
        }
    }

    public void setScaleType(@NonNull ScaleType scaleType) {
        Threads.a();
        this.f4103h.o(scaleType);
        e();
        b(false);
    }

    public PreviewView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public PreviewView(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        ImplementationMode implementationMode = f4100u;
        this.f4101f = implementationMode;
        PreviewTransformation previewTransformation = new PreviewTransformation();
        this.f4103h = previewTransformation;
        this.f4104i = true;
        this.f4105j = new MutableLiveData<>(StreamState.IDLE);
        this.f4106k = new AtomicReference<>();
        this.f4109n = new PreviewViewMeteringPointFactory(previewTransformation);
        this.f4113r = new DisplayRotationListener();
        this.f4114s = new View.OnLayoutChangeListener() { // from class: androidx.camera.view.d
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                PreviewView.this.d(view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.f4115t = new AnonymousClass1();
        Threads.a();
        Resources.Theme theme = context.getTheme();
        int[] iArr = R$styleable.f4143a;
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i8, i9);
        ViewCompat.q0(this, context, iArr, attributeSet, obtainStyledAttributes, i8, i9);
        try {
            setScaleType(ScaleType.a(obtainStyledAttributes.getInteger(R$styleable.f4145c, previewTransformation.f().c())));
            setImplementationMode(ImplementationMode.a(obtainStyledAttributes.getInteger(R$styleable.f4144b, implementationMode.c())));
            obtainStyledAttributes.recycle();
            this.f4110o = new ScaleGestureDetector(context, new PinchToZoomOnScaleGestureListener());
            if (getBackground() == null) {
                setBackgroundColor(ContextCompat.getColor(getContext(), 17170444));
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
