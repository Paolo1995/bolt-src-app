package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.IoConfig;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ImageCaptureConfig implements UseCaseConfig<ImageCapture>, ImageOutputConfig, IoConfig {
    public static final Config.Option<Integer> B;
    public static final Config.Option<Integer> C;
    public static final Config.Option<CaptureBundle> D;
    public static final Config.Option<CaptureProcessor> E;
    public static final Config.Option<Integer> F;
    public static final Config.Option<Integer> G;
    public static final Config.Option<ImageReaderProxyProvider> H;
    public static final Config.Option<Boolean> I;
    public static final Config.Option<Integer> J;
    public static final Config.Option<Integer> K;
    private final OptionsBundle A;

    static {
        Class cls = Integer.TYPE;
        B = Config.Option.a("camerax.core.imageCapture.captureMode", cls);
        C = Config.Option.a("camerax.core.imageCapture.flashMode", cls);
        D = Config.Option.a("camerax.core.imageCapture.captureBundle", CaptureBundle.class);
        E = Config.Option.a("camerax.core.imageCapture.captureProcessor", CaptureProcessor.class);
        F = Config.Option.a("camerax.core.imageCapture.bufferFormat", Integer.class);
        G = Config.Option.a("camerax.core.imageCapture.maxCaptureStages", Integer.class);
        H = Config.Option.a("camerax.core.imageCapture.imageReaderProxyProvider", ImageReaderProxyProvider.class);
        I = Config.Option.a("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE);
        J = Config.Option.a("camerax.core.imageCapture.flashType", cls);
        K = Config.Option.a("camerax.core.imageCapture.jpegCompressionQuality", cls);
    }

    public ImageCaptureConfig(@NonNull OptionsBundle optionsBundle) {
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

    public CaptureBundle H(CaptureBundle captureBundle) {
        return (CaptureBundle) e(D, captureBundle);
    }

    public int I() {
        return ((Integer) a(B)).intValue();
    }

    public CaptureProcessor J(CaptureProcessor captureProcessor) {
        return (CaptureProcessor) e(E, captureProcessor);
    }

    public int K(int i8) {
        return ((Integer) e(C, Integer.valueOf(i8))).intValue();
    }

    public int L(int i8) {
        return ((Integer) e(J, Integer.valueOf(i8))).intValue();
    }

    public ImageReaderProxyProvider M() {
        return (ImageReaderProxyProvider) e(H, null);
    }

    public Executor N(Executor executor) {
        return (Executor) e(IoConfig.f3909v, executor);
    }

    public int O() {
        return ((Integer) a(K)).intValue();
    }

    public int P(int i8) {
        return ((Integer) e(G, Integer.valueOf(i8))).intValue();
    }

    public boolean Q() {
        return b(B);
    }

    public boolean R() {
        return ((Boolean) e(I, Boolean.FALSE)).booleanValue();
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
        return ((Integer) a(ImageInputConfig.f3652f)).intValue();
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
