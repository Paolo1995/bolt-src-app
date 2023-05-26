package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AutoValue_SessionConfig_OutputConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.internal.compat.workaround.SurfaceSorter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class SessionConfig {

    /* renamed from: a  reason: collision with root package name */
    private final List<OutputConfig> f3671a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CameraDevice.StateCallback> f3672b;

    /* renamed from: c  reason: collision with root package name */
    private final List<CameraCaptureSession.StateCallback> f3673c;

    /* renamed from: d  reason: collision with root package name */
    private final List<CameraCaptureCallback> f3674d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ErrorListener> f3675e;

    /* renamed from: f  reason: collision with root package name */
    private final CaptureConfig f3676f;

    /* renamed from: g  reason: collision with root package name */
    private InputConfiguration f3677g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BaseBuilder {

        /* renamed from: a  reason: collision with root package name */
        final Set<OutputConfig> f3678a = new LinkedHashSet();

        /* renamed from: b  reason: collision with root package name */
        final CaptureConfig.Builder f3679b = new CaptureConfig.Builder();

        /* renamed from: c  reason: collision with root package name */
        final List<CameraDevice.StateCallback> f3680c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        final List<CameraCaptureSession.StateCallback> f3681d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        final List<ErrorListener> f3682e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        final List<CameraCaptureCallback> f3683f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        InputConfiguration f3684g;

        BaseBuilder() {
        }
    }

    /* loaded from: classes.dex */
    public static class Builder extends BaseBuilder {
        @NonNull
        public static Builder o(@NonNull UseCaseConfig<?> useCaseConfig) {
            OptionUnpacker F = useCaseConfig.F(null);
            if (F != null) {
                Builder builder = new Builder();
                F.a(useCaseConfig, builder);
                return builder;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + useCaseConfig.r(useCaseConfig.toString()));
        }

        @NonNull
        public Builder a(@NonNull Collection<CameraDevice.StateCallback> collection) {
            for (CameraDevice.StateCallback stateCallback : collection) {
                e(stateCallback);
            }
            return this;
        }

        @NonNull
        public Builder b(@NonNull Collection<CameraCaptureCallback> collection) {
            this.f3679b.a(collection);
            return this;
        }

        @NonNull
        public Builder c(@NonNull List<CameraCaptureSession.StateCallback> list) {
            for (CameraCaptureSession.StateCallback stateCallback : list) {
                j(stateCallback);
            }
            return this;
        }

        @NonNull
        public Builder d(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.f3679b.c(cameraCaptureCallback);
            if (!this.f3683f.contains(cameraCaptureCallback)) {
                this.f3683f.add(cameraCaptureCallback);
            }
            return this;
        }

        @NonNull
        public Builder e(@NonNull CameraDevice.StateCallback stateCallback) {
            if (this.f3680c.contains(stateCallback)) {
                return this;
            }
            this.f3680c.add(stateCallback);
            return this;
        }

        @NonNull
        public Builder f(@NonNull ErrorListener errorListener) {
            this.f3682e.add(errorListener);
            return this;
        }

        @NonNull
        public Builder g(@NonNull Config config) {
            this.f3679b.e(config);
            return this;
        }

        @NonNull
        public Builder h(@NonNull DeferrableSurface deferrableSurface) {
            this.f3678a.add(OutputConfig.a(deferrableSurface).a());
            return this;
        }

        @NonNull
        public Builder i(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.f3679b.c(cameraCaptureCallback);
            return this;
        }

        @NonNull
        public Builder j(@NonNull CameraCaptureSession.StateCallback stateCallback) {
            if (this.f3681d.contains(stateCallback)) {
                return this;
            }
            this.f3681d.add(stateCallback);
            return this;
        }

        @NonNull
        public Builder k(@NonNull DeferrableSurface deferrableSurface) {
            this.f3678a.add(OutputConfig.a(deferrableSurface).a());
            this.f3679b.f(deferrableSurface);
            return this;
        }

        @NonNull
        public Builder l(@NonNull String str, @NonNull Object obj) {
            this.f3679b.g(str, obj);
            return this;
        }

        @NonNull
        public SessionConfig m() {
            return new SessionConfig(new ArrayList(this.f3678a), this.f3680c, this.f3681d, this.f3683f, this.f3682e, this.f3679b.h(), this.f3684g);
        }

        @NonNull
        public Builder n() {
            this.f3678a.clear();
            this.f3679b.i();
            return this;
        }

        @NonNull
        public List<CameraCaptureCallback> p() {
            return Collections.unmodifiableList(this.f3683f);
        }

        @NonNull
        public Builder q(@NonNull Config config) {
            this.f3679b.o(config);
            return this;
        }

        @NonNull
        public Builder r(InputConfiguration inputConfiguration) {
            this.f3684g = inputConfiguration;
            return this;
        }

        @NonNull
        public Builder s(int i8) {
            this.f3679b.p(i8);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface ErrorListener {
        void a(@NonNull SessionConfig sessionConfig, @NonNull SessionError sessionError);
    }

    /* loaded from: classes.dex */
    public interface OptionUnpacker {
        void a(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull Builder builder);
    }

    /* loaded from: classes.dex */
    public static abstract class OutputConfig {

        /* loaded from: classes.dex */
        public static abstract class Builder {
            @NonNull
            public abstract OutputConfig a();

            @NonNull
            public abstract Builder b(String str);

            @NonNull
            public abstract Builder c(@NonNull List<DeferrableSurface> list);

            @NonNull
            public abstract Builder d(int i8);
        }

        @NonNull
        public static Builder a(@NonNull DeferrableSurface deferrableSurface) {
            return new AutoValue_SessionConfig_OutputConfig.Builder().e(deferrableSurface).c(Collections.emptyList()).b(null).d(-1);
        }

        public abstract String b();

        @NonNull
        public abstract List<DeferrableSurface> c();

        @NonNull
        public abstract DeferrableSurface d();

        public abstract int e();
    }

    /* loaded from: classes.dex */
    public enum SessionError {
        SESSION_ERROR_SURFACE_NEEDS_RESET,
        SESSION_ERROR_UNKNOWN
    }

    /* loaded from: classes.dex */
    public static final class ValidatingBuilder extends BaseBuilder {

        /* renamed from: k  reason: collision with root package name */
        private static final List<Integer> f3688k = Arrays.asList(1, 5, 3);

        /* renamed from: h  reason: collision with root package name */
        private final SurfaceSorter f3689h = new SurfaceSorter();

        /* renamed from: i  reason: collision with root package name */
        private boolean f3690i = true;

        /* renamed from: j  reason: collision with root package name */
        private boolean f3691j = false;

        private List<DeferrableSurface> e() {
            ArrayList arrayList = new ArrayList();
            for (OutputConfig outputConfig : this.f3678a) {
                arrayList.add(outputConfig.d());
                for (DeferrableSurface deferrableSurface : outputConfig.c()) {
                    arrayList.add(deferrableSurface);
                }
            }
            return arrayList;
        }

        private int g(int i8, int i9) {
            List<Integer> list = f3688k;
            if (list.indexOf(Integer.valueOf(i8)) < list.indexOf(Integer.valueOf(i9))) {
                return i9;
            }
            return i8;
        }

        public void a(@NonNull SessionConfig sessionConfig) {
            CaptureConfig h8 = sessionConfig.h();
            if (h8.g() != -1) {
                this.f3691j = true;
                this.f3679b.p(g(h8.g(), this.f3679b.m()));
            }
            this.f3679b.b(sessionConfig.h().f());
            this.f3680c.addAll(sessionConfig.b());
            this.f3681d.addAll(sessionConfig.i());
            this.f3679b.a(sessionConfig.g());
            this.f3683f.addAll(sessionConfig.j());
            this.f3682e.addAll(sessionConfig.c());
            if (sessionConfig.e() != null) {
                this.f3684g = sessionConfig.e();
            }
            this.f3678a.addAll(sessionConfig.f());
            this.f3679b.l().addAll(h8.e());
            if (!e().containsAll(this.f3679b.l())) {
                Logger.a("ValidatingBuilder", "Invalid configuration due to capture request surfaces are not a subset of surfaces");
                this.f3690i = false;
            }
            this.f3679b.e(h8.d());
        }

        public <T> void b(@NonNull Config.Option<T> option, @NonNull T t7) {
            this.f3679b.d(option, t7);
        }

        @NonNull
        public SessionConfig c() {
            if (this.f3690i) {
                ArrayList arrayList = new ArrayList(this.f3678a);
                this.f3689h.d(arrayList);
                return new SessionConfig(arrayList, this.f3680c, this.f3681d, this.f3683f, this.f3682e, this.f3679b.h(), this.f3684g);
            }
            throw new IllegalArgumentException("Unsupported session configuration combination");
        }

        public void d() {
            this.f3678a.clear();
            this.f3679b.i();
        }

        public boolean f() {
            if (this.f3691j && this.f3690i) {
                return true;
            }
            return false;
        }
    }

    SessionConfig(List<OutputConfig> list, List<CameraDevice.StateCallback> list2, List<CameraCaptureSession.StateCallback> list3, List<CameraCaptureCallback> list4, List<ErrorListener> list5, CaptureConfig captureConfig, InputConfiguration inputConfiguration) {
        this.f3671a = list;
        this.f3672b = Collections.unmodifiableList(list2);
        this.f3673c = Collections.unmodifiableList(list3);
        this.f3674d = Collections.unmodifiableList(list4);
        this.f3675e = Collections.unmodifiableList(list5);
        this.f3676f = captureConfig;
        this.f3677g = inputConfiguration;
    }

    @NonNull
    public static SessionConfig a() {
        return new SessionConfig(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new ArrayList(0), new CaptureConfig.Builder().h(), null);
    }

    @NonNull
    public List<CameraDevice.StateCallback> b() {
        return this.f3672b;
    }

    @NonNull
    public List<ErrorListener> c() {
        return this.f3675e;
    }

    @NonNull
    public Config d() {
        return this.f3676f.d();
    }

    public InputConfiguration e() {
        return this.f3677g;
    }

    @NonNull
    public List<OutputConfig> f() {
        return this.f3671a;
    }

    @NonNull
    public List<CameraCaptureCallback> g() {
        return this.f3676f.b();
    }

    @NonNull
    public CaptureConfig h() {
        return this.f3676f;
    }

    @NonNull
    public List<CameraCaptureSession.StateCallback> i() {
        return this.f3673c;
    }

    @NonNull
    public List<CameraCaptureCallback> j() {
        return this.f3674d;
    }

    @NonNull
    public List<DeferrableSurface> k() {
        ArrayList arrayList = new ArrayList();
        for (OutputConfig outputConfig : this.f3671a) {
            arrayList.add(outputConfig.d());
            for (DeferrableSurface deferrableSurface : outputConfig.c()) {
                arrayList.add(deferrableSurface);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int l() {
        return this.f3676f.g();
    }
}
