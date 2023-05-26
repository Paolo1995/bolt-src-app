package androidx.camera.core.impl;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.UseCaseEventConfig;

/* loaded from: classes.dex */
public interface UseCaseConfig<T extends UseCase> extends TargetConfig<T>, UseCaseEventConfig, ImageInputConfig {

    /* renamed from: n  reason: collision with root package name */
    public static final Config.Option<SessionConfig> f3716n = Config.Option.a("camerax.core.useCase.defaultSessionConfig", SessionConfig.class);

    /* renamed from: o  reason: collision with root package name */
    public static final Config.Option<CaptureConfig> f3717o = Config.Option.a("camerax.core.useCase.defaultCaptureConfig", CaptureConfig.class);

    /* renamed from: p  reason: collision with root package name */
    public static final Config.Option<SessionConfig.OptionUnpacker> f3718p = Config.Option.a("camerax.core.useCase.sessionConfigUnpacker", SessionConfig.OptionUnpacker.class);

    /* renamed from: q  reason: collision with root package name */
    public static final Config.Option<CaptureConfig.OptionUnpacker> f3719q = Config.Option.a("camerax.core.useCase.captureConfigUnpacker", CaptureConfig.OptionUnpacker.class);

    /* renamed from: r  reason: collision with root package name */
    public static final Config.Option<Integer> f3720r = Config.Option.a("camerax.core.useCase.surfaceOccupancyPriority", Integer.TYPE);

    /* renamed from: s  reason: collision with root package name */
    public static final Config.Option<CameraSelector> f3721s = Config.Option.a("camerax.core.useCase.cameraSelector", CameraSelector.class);

    /* renamed from: t  reason: collision with root package name */
    public static final Config.Option<Range<Integer>> f3722t = Config.Option.a("camerax.core.useCase.targetFrameRate", CameraSelector.class);

    /* renamed from: u  reason: collision with root package name */
    public static final Config.Option<Boolean> f3723u = Config.Option.a("camerax.core.useCase.zslDisabled", Boolean.TYPE);

    /* loaded from: classes.dex */
    public interface Builder<T extends UseCase, C extends UseCaseConfig<T>, B> extends ExtendableBuilder<T> {
        @NonNull
        C b();
    }

    Range<Integer> B(Range<Integer> range);

    CameraSelector D(CameraSelector cameraSelector);

    SessionConfig.OptionUnpacker F(SessionConfig.OptionUnpacker optionUnpacker);

    SessionConfig j(SessionConfig sessionConfig);

    CaptureConfig.OptionUnpacker n(CaptureConfig.OptionUnpacker optionUnpacker);

    CaptureConfig p(CaptureConfig captureConfig);

    int v(int i8);

    boolean z(boolean z7);
}
