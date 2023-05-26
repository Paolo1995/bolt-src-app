package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class CaptureConfig {

    /* renamed from: h  reason: collision with root package name */
    public static final Config.Option<Integer> f3613h = Config.Option.a("camerax.core.captureConfig.rotation", Integer.TYPE);

    /* renamed from: i  reason: collision with root package name */
    public static final Config.Option<Integer> f3614i = Config.Option.a("camerax.core.captureConfig.jpegQuality", Integer.class);

    /* renamed from: a  reason: collision with root package name */
    final List<DeferrableSurface> f3615a;

    /* renamed from: b  reason: collision with root package name */
    final Config f3616b;

    /* renamed from: c  reason: collision with root package name */
    final int f3617c;

    /* renamed from: d  reason: collision with root package name */
    final List<CameraCaptureCallback> f3618d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3619e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TagBundle f3620f;

    /* renamed from: g  reason: collision with root package name */
    private final CameraCaptureResult f3621g;

    /* loaded from: classes.dex */
    public interface OptionUnpacker {
        void a(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull Builder builder);
    }

    CaptureConfig(List<DeferrableSurface> list, Config config, int i8, List<CameraCaptureCallback> list2, boolean z7, @NonNull TagBundle tagBundle, CameraCaptureResult cameraCaptureResult) {
        this.f3615a = list;
        this.f3616b = config;
        this.f3617c = i8;
        this.f3618d = Collections.unmodifiableList(list2);
        this.f3619e = z7;
        this.f3620f = tagBundle;
        this.f3621g = cameraCaptureResult;
    }

    @NonNull
    public static CaptureConfig a() {
        return new Builder().h();
    }

    @NonNull
    public List<CameraCaptureCallback> b() {
        return this.f3618d;
    }

    public CameraCaptureResult c() {
        return this.f3621g;
    }

    @NonNull
    public Config d() {
        return this.f3616b;
    }

    @NonNull
    public List<DeferrableSurface> e() {
        return Collections.unmodifiableList(this.f3615a);
    }

    @NonNull
    public TagBundle f() {
        return this.f3620f;
    }

    public int g() {
        return this.f3617c;
    }

    public boolean h() {
        return this.f3619e;
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Set<DeferrableSurface> f3622a;

        /* renamed from: b  reason: collision with root package name */
        private MutableConfig f3623b;

        /* renamed from: c  reason: collision with root package name */
        private int f3624c;

        /* renamed from: d  reason: collision with root package name */
        private List<CameraCaptureCallback> f3625d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3626e;

        /* renamed from: f  reason: collision with root package name */
        private MutableTagBundle f3627f;

        /* renamed from: g  reason: collision with root package name */
        private CameraCaptureResult f3628g;

        public Builder() {
            this.f3622a = new HashSet();
            this.f3623b = MutableOptionsBundle.L();
            this.f3624c = -1;
            this.f3625d = new ArrayList();
            this.f3626e = false;
            this.f3627f = MutableTagBundle.f();
        }

        @NonNull
        public static Builder j(@NonNull UseCaseConfig<?> useCaseConfig) {
            OptionUnpacker n8 = useCaseConfig.n(null);
            if (n8 != null) {
                Builder builder = new Builder();
                n8.a(useCaseConfig, builder);
                return builder;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + useCaseConfig.r(useCaseConfig.toString()));
        }

        @NonNull
        public static Builder k(@NonNull CaptureConfig captureConfig) {
            return new Builder(captureConfig);
        }

        public void a(@NonNull Collection<CameraCaptureCallback> collection) {
            for (CameraCaptureCallback cameraCaptureCallback : collection) {
                c(cameraCaptureCallback);
            }
        }

        public void b(@NonNull TagBundle tagBundle) {
            this.f3627f.e(tagBundle);
        }

        public void c(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            if (this.f3625d.contains(cameraCaptureCallback)) {
                return;
            }
            this.f3625d.add(cameraCaptureCallback);
        }

        public <T> void d(@NonNull Config.Option<T> option, @NonNull T t7) {
            this.f3623b.o(option, t7);
        }

        public void e(@NonNull Config config) {
            for (Config.Option<?> option : config.c()) {
                Object e8 = this.f3623b.e(option, null);
                Object a8 = config.a(option);
                if (e8 instanceof MultiValueSet) {
                    ((MultiValueSet) e8).a(((MultiValueSet) a8).c());
                } else {
                    if (a8 instanceof MultiValueSet) {
                        a8 = ((MultiValueSet) a8).clone();
                    }
                    this.f3623b.k(option, config.f(option), a8);
                }
            }
        }

        public void f(@NonNull DeferrableSurface deferrableSurface) {
            this.f3622a.add(deferrableSurface);
        }

        public void g(@NonNull String str, @NonNull Object obj) {
            this.f3627f.h(str, obj);
        }

        @NonNull
        public CaptureConfig h() {
            return new CaptureConfig(new ArrayList(this.f3622a), OptionsBundle.J(this.f3623b), this.f3624c, this.f3625d, this.f3626e, TagBundle.b(this.f3627f), this.f3628g);
        }

        public void i() {
            this.f3622a.clear();
        }

        @NonNull
        public Set<DeferrableSurface> l() {
            return this.f3622a;
        }

        public int m() {
            return this.f3624c;
        }

        public void n(@NonNull CameraCaptureResult cameraCaptureResult) {
            this.f3628g = cameraCaptureResult;
        }

        public void o(@NonNull Config config) {
            this.f3623b = MutableOptionsBundle.M(config);
        }

        public void p(int i8) {
            this.f3624c = i8;
        }

        public void q(boolean z7) {
            this.f3626e = z7;
        }

        private Builder(CaptureConfig captureConfig) {
            HashSet hashSet = new HashSet();
            this.f3622a = hashSet;
            this.f3623b = MutableOptionsBundle.L();
            this.f3624c = -1;
            this.f3625d = new ArrayList();
            this.f3626e = false;
            this.f3627f = MutableTagBundle.f();
            hashSet.addAll(captureConfig.f3615a);
            this.f3623b = MutableOptionsBundle.M(captureConfig.f3616b);
            this.f3624c = captureConfig.f3617c;
            this.f3625d.addAll(captureConfig.b());
            this.f3626e = captureConfig.h();
            this.f3627f = MutableTagBundle.g(captureConfig.f());
        }
    }
}
