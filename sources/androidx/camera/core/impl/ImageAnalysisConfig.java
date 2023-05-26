package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.ThreadConfig;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ImageAnalysisConfig implements UseCaseConfig<ImageAnalysis>, ImageOutputConfig, ThreadConfig {
    public static final Config.Option<Integer> B = Config.Option.a("camerax.core.imageAnalysis.backpressureStrategy", ImageAnalysis.BackpressureStrategy.class);
    public static final Config.Option<Integer> C = Config.Option.a("camerax.core.imageAnalysis.imageQueueDepth", Integer.TYPE);
    public static final Config.Option<ImageReaderProxyProvider> D = Config.Option.a("camerax.core.imageAnalysis.imageReaderProxyProvider", ImageReaderProxyProvider.class);
    public static final Config.Option<Integer> E = Config.Option.a("camerax.core.imageAnalysis.outputImageFormat", ImageAnalysis.OutputImageFormat.class);
    public static final Config.Option<Boolean> F = Config.Option.a("camerax.core.imageAnalysis.onePixelShiftEnabled", Boolean.class);
    public static final Config.Option<Boolean> G = Config.Option.a("camerax.core.imageAnalysis.outputImageRotationEnabled", Boolean.class);
    private final OptionsBundle A;

    public ImageAnalysisConfig(@NonNull OptionsBundle optionsBundle) {
        this.A = optionsBundle;
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ Size A(Size size) {
        return o.f(this, size);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ Range B(Range range) {
        return x.g(this, range);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ CameraSelector D(CameraSelector cameraSelector) {
        return x.a(this, cameraSelector);
    }

    @Override // androidx.camera.core.internal.UseCaseEventConfig
    public /* synthetic */ UseCase.EventCallback E(UseCase.EventCallback eventCallback) {
        return f.e.a(this, eventCallback);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ SessionConfig.OptionUnpacker F(SessionConfig.OptionUnpacker optionUnpacker) {
        return x.e(this, optionUnpacker);
    }

    public /* synthetic */ Executor H(Executor executor) {
        return f.d.a(this, executor);
    }

    public int I(int i8) {
        return ((Integer) e(B, Integer.valueOf(i8))).intValue();
    }

    public int J(int i8) {
        return ((Integer) e(C, Integer.valueOf(i8))).intValue();
    }

    public ImageReaderProxyProvider K() {
        return (ImageReaderProxyProvider) e(D, null);
    }

    public Boolean L(Boolean bool) {
        return (Boolean) e(F, bool);
    }

    public int M(int i8) {
        return ((Integer) e(E, Integer.valueOf(i8))).intValue();
    }

    public Boolean N(Boolean bool) {
        return (Boolean) e(G, bool);
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

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ Size g(Size size) {
        return o.c(this, size);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public int getInputFormat() {
        return 35;
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ List i(List list) {
        return o.d(this, list);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ SessionConfig j(SessionConfig sessionConfig) {
        return x.d(this, sessionConfig);
    }

    @Override // androidx.camera.core.impl.Config
    public /* synthetic */ void l(String str, Config.OptionMatcher optionMatcher) {
        t.b(this, str, optionMatcher);
    }

    @Override // androidx.camera.core.impl.Config
    public /* synthetic */ Object m(Config.Option option, Config.OptionPriority optionPriority) {
        return t.h(this, option, optionPriority);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ CaptureConfig.OptionUnpacker n(CaptureConfig.OptionUnpacker optionUnpacker) {
        return x.b(this, optionUnpacker);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ CaptureConfig p(CaptureConfig captureConfig) {
        return x.c(this, captureConfig);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ int q(int i8) {
        return o.a(this, i8);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public /* synthetic */ String r(String str) {
        return f.c.a(this, str);
    }

    @Override // androidx.camera.core.impl.Config
    public /* synthetic */ Set t(Config.Option option) {
        return t.d(this, option);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ boolean u() {
        return o.h(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ int v(int i8) {
        return x.f(this, i8);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ int w() {
        return o.e(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ int x(int i8) {
        return o.g(this, i8);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public /* synthetic */ Size y(Size size) {
        return o.b(this, size);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public /* synthetic */ boolean z(boolean z7) {
        return x.h(this, z7);
    }
}
