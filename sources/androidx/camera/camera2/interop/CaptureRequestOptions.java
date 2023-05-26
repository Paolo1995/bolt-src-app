package androidx.camera.camera2.interop;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.t;
import java.util.Set;

/* loaded from: classes.dex */
public class CaptureRequestOptions implements ReadableConfig {
    private final Config A;

    /* loaded from: classes.dex */
    public static final class Builder implements ExtendableBuilder<CaptureRequestOptions> {

        /* renamed from: a  reason: collision with root package name */
        private final MutableOptionsBundle f3021a = MutableOptionsBundle.L();

        @NonNull
        public static Builder e(@NonNull final Config config) {
            final Builder builder = new Builder();
            config.l("camera2.captureRequest.option.", new Config.OptionMatcher() { // from class: e.g
                @Override // androidx.camera.core.impl.Config.OptionMatcher
                public final boolean a(Config.Option option) {
                    boolean f8;
                    f8 = CaptureRequestOptions.Builder.f(CaptureRequestOptions.Builder.this, config, option);
                    return f8;
                }
            });
            return builder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean f(Builder builder, Config config, Config.Option option) {
            builder.a().k(option, config.f(option), config.a(option));
            return true;
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public MutableConfig a() {
            return this.f3021a;
        }

        @NonNull
        public CaptureRequestOptions d() {
            return new CaptureRequestOptions(OptionsBundle.J(this.f3021a));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public <ValueT> Builder g(@NonNull CaptureRequest.Key<ValueT> key, @NonNull ValueT valuet) {
            this.f3021a.o(Camera2ImplConfig.H(key), valuet);
            return this;
        }
    }

    public CaptureRequestOptions(@NonNull Config config) {
        this.A = config;
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
        return this.A;
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Object e(Config.Option option, Object obj) {
        return t.g(this, option, obj);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public /* synthetic */ Config.OptionPriority f(Config.Option option) {
        return t.c(this, option);
    }

    @Override // androidx.camera.core.impl.Config
    public /* synthetic */ void l(String str, Config.OptionMatcher optionMatcher) {
        t.b(this, str, optionMatcher);
    }

    @Override // androidx.camera.core.impl.Config
    public /* synthetic */ Object m(Config.Option option, Config.OptionPriority optionPriority) {
        return t.h(this, option, optionPriority);
    }

    @Override // androidx.camera.core.impl.Config
    public /* synthetic */ Set t(Config.Option option) {
        return t.d(this, option);
    }
}
