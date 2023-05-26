package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import java.util.Set;

/* loaded from: classes.dex */
public class CameraConfigs {

    /* renamed from: a  reason: collision with root package name */
    private static final CameraConfig f3590a = new EmptyCameraConfig();

    /* loaded from: classes.dex */
    static final class EmptyCameraConfig implements CameraConfig {
        private final Identifier A = Identifier.a(new Object());

        EmptyCameraConfig() {
        }

        @Override // androidx.camera.core.impl.CameraConfig
        @NonNull
        public Identifier C() {
            return this.A;
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public /* synthetic */ SessionProcessor G(SessionProcessor sessionProcessor) {
            return b.a(this, sessionProcessor);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Object a(Config.Option option) {
            return t.f(this, option);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ boolean b(Config.Option option) {
            return t.a(this, option);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Set c() {
            return t.e(this);
        }

        @Override // androidx.camera.core.impl.ReadableConfig
        @NonNull
        public Config d() {
            return OptionsBundle.I();
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Object e(Config.Option option, Object obj) {
            return t.g(this, option, obj);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Config.OptionPriority f(Config.Option option) {
            return t.c(this, option);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public /* synthetic */ UseCaseConfigFactory h() {
            return b.c(this);
        }

        @Override // androidx.camera.core.impl.Config
        public /* synthetic */ void l(String str, Config.OptionMatcher optionMatcher) {
            t.b(this, str, optionMatcher);
        }

        @Override // androidx.camera.core.impl.Config
        public /* synthetic */ Object m(Config.Option option, Config.OptionPriority optionPriority) {
            return t.h(this, option, optionPriority);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public /* synthetic */ int s() {
            return b.b(this);
        }

        @Override // androidx.camera.core.impl.Config
        public /* synthetic */ Set t(Config.Option option) {
            return t.d(this, option);
        }
    }

    private CameraConfigs() {
    }

    @NonNull
    public static CameraConfig a() {
        return f3590a;
    }
}
