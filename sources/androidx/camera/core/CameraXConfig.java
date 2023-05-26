package androidx.camera.core;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class CameraXConfig implements TargetConfig<CameraX> {
    static final Config.Option<CameraFactory.Provider> B = Config.Option.a("camerax.core.appConfig.cameraFactoryProvider", CameraFactory.Provider.class);
    static final Config.Option<CameraDeviceSurfaceManager.Provider> C = Config.Option.a("camerax.core.appConfig.deviceSurfaceManagerProvider", CameraDeviceSurfaceManager.Provider.class);
    static final Config.Option<UseCaseConfigFactory.Provider> D = Config.Option.a("camerax.core.appConfig.useCaseConfigFactoryProvider", UseCaseConfigFactory.Provider.class);
    static final Config.Option<Executor> E = Config.Option.a("camerax.core.appConfig.cameraExecutor", Executor.class);
    static final Config.Option<Handler> F = Config.Option.a("camerax.core.appConfig.schedulerHandler", Handler.class);
    static final Config.Option<Integer> G = Config.Option.a("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE);
    static final Config.Option<CameraSelector> H = Config.Option.a("camerax.core.appConfig.availableCamerasLimiter", CameraSelector.class);
    private final OptionsBundle A;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final MutableOptionsBundle f3085a;

        public Builder() {
            this(MutableOptionsBundle.L());
        }

        @NonNull
        private MutableConfig b() {
            return this.f3085a;
        }

        @NonNull
        public CameraXConfig a() {
            return new CameraXConfig(OptionsBundle.J(this.f3085a));
        }

        @NonNull
        public Builder c(@NonNull CameraFactory.Provider provider) {
            b().o(CameraXConfig.B, provider);
            return this;
        }

        @NonNull
        public Builder d(@NonNull CameraDeviceSurfaceManager.Provider provider) {
            b().o(CameraXConfig.C, provider);
            return this;
        }

        @NonNull
        public Builder e(@NonNull Class<CameraX> cls) {
            b().o(TargetConfig.f3911x, cls);
            if (b().e(TargetConfig.f3910w, null) == null) {
                f(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        @NonNull
        public Builder f(@NonNull String str) {
            b().o(TargetConfig.f3910w, str);
            return this;
        }

        @NonNull
        public Builder g(@NonNull UseCaseConfigFactory.Provider provider) {
            b().o(CameraXConfig.D, provider);
            return this;
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.f3085a = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.e(TargetConfig.f3911x, null);
            if (cls != null && !cls.equals(CameraX.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            e(CameraX.class);
        }
    }

    /* loaded from: classes.dex */
    public interface Provider {
        @NonNull
        CameraXConfig getCameraXConfig();
    }

    CameraXConfig(OptionsBundle optionsBundle) {
        this.A = optionsBundle;
    }

    public CameraSelector H(CameraSelector cameraSelector) {
        return (CameraSelector) this.A.e(H, cameraSelector);
    }

    public Executor I(Executor executor) {
        return (Executor) this.A.e(E, executor);
    }

    public CameraFactory.Provider J(CameraFactory.Provider provider) {
        return (CameraFactory.Provider) this.A.e(B, provider);
    }

    public CameraDeviceSurfaceManager.Provider K(CameraDeviceSurfaceManager.Provider provider) {
        return (CameraDeviceSurfaceManager.Provider) this.A.e(C, provider);
    }

    public Handler L(Handler handler) {
        return (Handler) this.A.e(F, handler);
    }

    public UseCaseConfigFactory.Provider M(UseCaseConfigFactory.Provider provider) {
        return (UseCaseConfigFactory.Provider) this.A.e(D, provider);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Object a(Config.Option option) {
        return androidx.camera.core.impl.t.f(this, option);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ boolean b(Config.Option option) {
        return androidx.camera.core.impl.t.a(this, option);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Set c() {
        return androidx.camera.core.impl.t.e(this);
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    @NonNull
    public Config d() {
        return this.A;
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Object e(Config.Option option, Object obj) {
        return androidx.camera.core.impl.t.g(this, option, obj);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Config.OptionPriority f(Config.Option option) {
        return androidx.camera.core.impl.t.c(this, option);
    }

    @Override // androidx.camera.core.impl.Config
    public /* synthetic */ void l(String str, Config.OptionMatcher optionMatcher) {
        androidx.camera.core.impl.t.b(this, str, optionMatcher);
    }

    @Override // androidx.camera.core.impl.Config
    public /* synthetic */ Object m(Config.Option option, Config.OptionPriority optionPriority) {
        return androidx.camera.core.impl.t.h(this, option, optionPriority);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public /* synthetic */ String r(String str) {
        return f.c.a(this, str);
    }

    @Override // androidx.camera.core.impl.Config
    public /* synthetic */ Set t(Config.Option option) {
        return androidx.camera.core.impl.t.d(this, option);
    }
}
