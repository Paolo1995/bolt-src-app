package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import androidx.core.util.Preconditions;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class UseCase {

    /* renamed from: d  reason: collision with root package name */
    private UseCaseConfig<?> f3329d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private UseCaseConfig<?> f3330e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private UseCaseConfig<?> f3331f;

    /* renamed from: g  reason: collision with root package name */
    private Size f3332g;

    /* renamed from: h  reason: collision with root package name */
    private UseCaseConfig<?> f3333h;

    /* renamed from: i  reason: collision with root package name */
    private Rect f3334i;

    /* renamed from: k  reason: collision with root package name */
    private CameraInternal f3336k;

    /* renamed from: a  reason: collision with root package name */
    private final Set<StateChangeCallback> f3326a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final Object f3327b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private State f3328c = State.INACTIVE;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private Matrix f3335j = new Matrix();
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private SessionConfig f3337l = SessionConfig.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.core.UseCase$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3338a;

        static {
            int[] iArr = new int[State.values().length];
            f3338a = iArr;
            try {
                iArr[State.INACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3338a[State.ACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface EventCallback {
        void a(@NonNull CameraInfo cameraInfo);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum State {
        ACTIVE,
        INACTIVE
    }

    /* loaded from: classes.dex */
    public interface StateChangeCallback {
        void a(@NonNull UseCase useCase);

        void c(@NonNull UseCase useCase);

        void k(@NonNull UseCase useCase);

        void n(@NonNull UseCase useCase);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UseCase(@NonNull UseCaseConfig<?> useCaseConfig) {
        this.f3330e = useCaseConfig;
        this.f3331f = useCaseConfig;
    }

    private void G(@NonNull StateChangeCallback stateChangeCallback) {
        this.f3326a.remove(stateChangeCallback);
    }

    private void a(@NonNull StateChangeCallback stateChangeCallback) {
        this.f3326a.add(stateChangeCallback);
    }

    public void A(@NonNull CameraInternal cameraInternal) {
        boolean z7;
        B();
        EventCallback E = this.f3331f.E(null);
        if (E != null) {
            E.b();
        }
        synchronized (this.f3327b) {
            if (cameraInternal == this.f3336k) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.a(z7);
            G(this.f3336k);
            this.f3336k = null;
        }
        this.f3332g = null;
        this.f3334i = null;
        this.f3331f = this.f3330e;
        this.f3329d = null;
        this.f3333h = null;
    }

    public void B() {
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @NonNull
    protected UseCaseConfig<?> C(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        return builder.b();
    }

    public void D() {
        z();
    }

    public void E() {
    }

    @NonNull
    protected abstract Size F(@NonNull Size size);

    public void H(@NonNull Matrix matrix) {
        this.f3335j = new Matrix(matrix);
    }

    public void I(@NonNull Rect rect) {
        this.f3334i = rect;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(@NonNull SessionConfig sessionConfig) {
        this.f3337l = sessionConfig;
        for (DeferrableSurface deferrableSurface : sessionConfig.k()) {
            if (deferrableSurface.e() == null) {
                deferrableSurface.o(getClass());
            }
        }
    }

    public void K(@NonNull Size size) {
        this.f3332g = F(size);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return ((ImageOutputConfig) this.f3331f).q(-1);
    }

    public Size c() {
        return this.f3332g;
    }

    public CameraInternal d() {
        CameraInternal cameraInternal;
        synchronized (this.f3327b) {
            cameraInternal = this.f3336k;
        }
        return cameraInternal;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public CameraControlInternal e() {
        synchronized (this.f3327b) {
            CameraInternal cameraInternal = this.f3336k;
            if (cameraInternal == null) {
                return CameraControlInternal.f3591a;
            }
            return cameraInternal.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public String f() {
        CameraInternal d8 = d();
        return ((CameraInternal) Preconditions.h(d8, "No camera attached to use case: " + this)).j().a();
    }

    @NonNull
    public UseCaseConfig<?> g() {
        return this.f3331f;
    }

    public abstract UseCaseConfig<?> h(boolean z7, @NonNull UseCaseConfigFactory useCaseConfigFactory);

    public int i() {
        return this.f3331f.getInputFormat();
    }

    @NonNull
    public String j() {
        UseCaseConfig<?> useCaseConfig = this.f3331f;
        String r7 = useCaseConfig.r("<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(r7);
        return r7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int k(@NonNull CameraInternal cameraInternal) {
        return cameraInternal.j().g(n());
    }

    @NonNull
    public Matrix l() {
        return this.f3335j;
    }

    @NonNull
    public SessionConfig m() {
        return this.f3337l;
    }

    @SuppressLint({"WrongConstant"})
    protected int n() {
        return ((ImageOutputConfig) this.f3331f).x(0);
    }

    @NonNull
    public abstract UseCaseConfig.Builder<?, ?, ?> o(@NonNull Config config);

    public Rect p() {
        return this.f3334i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(@NonNull String str) {
        if (d() == null) {
            return false;
        }
        return Objects.equals(str, f());
    }

    @NonNull
    public UseCaseConfig<?> r(@NonNull CameraInfoInternal cameraInfoInternal, UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
        MutableOptionsBundle L;
        if (useCaseConfig2 != null) {
            L = MutableOptionsBundle.M(useCaseConfig2);
            L.N(TargetConfig.f3910w);
        } else {
            L = MutableOptionsBundle.L();
        }
        for (Config.Option<?> option : this.f3330e.c()) {
            L.k(option, this.f3330e.f(option), this.f3330e.a(option));
        }
        if (useCaseConfig != null) {
            for (Config.Option<?> option2 : useCaseConfig.c()) {
                if (!option2.c().equals(TargetConfig.f3910w.c())) {
                    L.k(option2, useCaseConfig.f(option2), useCaseConfig.a(option2));
                }
            }
        }
        if (L.b(ImageOutputConfig.f3656j)) {
            Config.Option<Integer> option3 = ImageOutputConfig.f3653g;
            if (L.b(option3)) {
                L.N(option3);
            }
        }
        return C(cameraInfoInternal, o(L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s() {
        this.f3328c = State.ACTIVE;
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t() {
        this.f3328c = State.INACTIVE;
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u() {
        for (StateChangeCallback stateChangeCallback : this.f3326a) {
            stateChangeCallback.k(this);
        }
    }

    public final void v() {
        int i8 = AnonymousClass1.f3338a[this.f3328c.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                for (StateChangeCallback stateChangeCallback : this.f3326a) {
                    stateChangeCallback.a(this);
                }
                return;
            }
            return;
        }
        for (StateChangeCallback stateChangeCallback2 : this.f3326a) {
            stateChangeCallback2.n(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w() {
        for (StateChangeCallback stateChangeCallback : this.f3326a) {
            stateChangeCallback.c(this);
        }
    }

    @SuppressLint({"WrongConstant"})
    public void x(@NonNull CameraInternal cameraInternal, UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
        synchronized (this.f3327b) {
            this.f3336k = cameraInternal;
            a(cameraInternal);
        }
        this.f3329d = useCaseConfig;
        this.f3333h = useCaseConfig2;
        UseCaseConfig<?> r7 = r(cameraInternal.j(), this.f3329d, this.f3333h);
        this.f3331f = r7;
        EventCallback E = r7.E(null);
        if (E != null) {
            E.a(cameraInternal.j());
        }
        y();
    }

    public void y() {
    }

    protected void z() {
    }
}
