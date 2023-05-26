package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.SupportedRepeatingSurfaceSize;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MeteringRepeatingSession {

    /* renamed from: a  reason: collision with root package name */
    private DeferrableSurface f2627a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final SessionConfig f2628b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final MeteringRepeatingConfig f2629c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final SupportedRepeatingSurfaceSize f2630d = new SupportedRepeatingSurfaceSize();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MeteringRepeatingConfig implements UseCaseConfig<UseCase> {
        @NonNull
        private final Config A;

        MeteringRepeatingConfig() {
            MutableOptionsBundle L = MutableOptionsBundle.L();
            L.o(UseCaseConfig.f3718p, new Camera2SessionOptionUnpacker());
            this.A = L;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ Range B(Range range) {
            return androidx.camera.core.impl.x.g(this, range);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ CameraSelector D(CameraSelector cameraSelector) {
            return androidx.camera.core.impl.x.a(this, cameraSelector);
        }

        @Override // androidx.camera.core.internal.UseCaseEventConfig
        public /* synthetic */ UseCase.EventCallback E(UseCase.EventCallback eventCallback) {
            return f.e.a(this, eventCallback);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ SessionConfig.OptionUnpacker F(SessionConfig.OptionUnpacker optionUnpacker) {
            return androidx.camera.core.impl.x.e(this, optionUnpacker);
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

        @Override // androidx.camera.core.impl.ImageInputConfig
        public /* synthetic */ int getInputFormat() {
            return androidx.camera.core.impl.n.a(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ SessionConfig j(SessionConfig sessionConfig) {
            return androidx.camera.core.impl.x.d(this, sessionConfig);
        }

        @Override // androidx.camera.core.impl.Config
        public /* synthetic */ void l(String str, Config.OptionMatcher optionMatcher) {
            androidx.camera.core.impl.t.b(this, str, optionMatcher);
        }

        @Override // androidx.camera.core.impl.Config
        public /* synthetic */ Object m(Config.Option option, Config.OptionPriority optionPriority) {
            return androidx.camera.core.impl.t.h(this, option, optionPriority);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ CaptureConfig.OptionUnpacker n(CaptureConfig.OptionUnpacker optionUnpacker) {
            return androidx.camera.core.impl.x.b(this, optionUnpacker);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ CaptureConfig p(CaptureConfig captureConfig) {
            return androidx.camera.core.impl.x.c(this, captureConfig);
        }

        @Override // androidx.camera.core.internal.TargetConfig
        public /* synthetic */ String r(String str) {
            return f.c.a(this, str);
        }

        @Override // androidx.camera.core.impl.Config
        public /* synthetic */ Set t(Config.Option option) {
            return androidx.camera.core.impl.t.d(this, option);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ int v(int i8) {
            return androidx.camera.core.impl.x.f(this, i8);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ boolean z(boolean z7) {
            return androidx.camera.core.impl.x.h(this, z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MeteringRepeatingSession(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull DisplayInfoManager displayInfoManager) {
        MeteringRepeatingConfig meteringRepeatingConfig = new MeteringRepeatingConfig();
        this.f2629c = meteringRepeatingConfig;
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        Size d8 = d(cameraCharacteristicsCompat, displayInfoManager);
        Logger.a("MeteringRepeating", "MeteringSession SurfaceTexture size: " + d8);
        surfaceTexture.setDefaultBufferSize(d8.getWidth(), d8.getHeight());
        final Surface surface = new Surface(surfaceTexture);
        SessionConfig.Builder o8 = SessionConfig.Builder.o(meteringRepeatingConfig);
        o8.s(1);
        ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        this.f2627a = immediateSurface;
        Futures.b(immediateSurface.i(), new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.MeteringRepeatingSession.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(Void r12) {
                surface.release();
                surfaceTexture.release();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
            }
        }, CameraXExecutors.a());
        o8.k(this.f2627a);
        this.f2628b = o8.m();
    }

    @NonNull
    private Size d(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull DisplayInfoManager displayInfoManager) {
        Size[] outputSizes;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristicsCompat.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            Logger.c("MeteringRepeating", "Can not retrieve SCALER_STREAM_CONFIGURATION_MAP.");
            return new Size(0, 0);
        }
        if (Build.VERSION.SDK_INT < 23) {
            outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        } else {
            outputSizes = streamConfigurationMap.getOutputSizes(34);
        }
        if (outputSizes == null) {
            Logger.c("MeteringRepeating", "Can not get output size list.");
            return new Size(0, 0);
        }
        Size[] a8 = this.f2630d.a(outputSizes);
        List asList = Arrays.asList(a8);
        Collections.sort(asList, new Comparator() { // from class: androidx.camera.camera2.internal.v0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int g8;
                g8 = MeteringRepeatingSession.g((Size) obj, (Size) obj2);
                return g8;
            }
        });
        Size d8 = displayInfoManager.d();
        long min = Math.min(d8.getWidth() * d8.getHeight(), 307200L);
        Size size = null;
        int length = a8.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                break;
            }
            Size size2 = a8[i8];
            int i9 = ((size2.getWidth() * size2.getHeight()) > min ? 1 : ((size2.getWidth() * size2.getHeight()) == min ? 0 : -1));
            if (i9 == 0) {
                return size2;
            }
            if (i9 > 0) {
                if (size != null) {
                    return size;
                }
            } else {
                i8++;
                size = size2;
            }
        }
        return (Size) asList.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(Size size, Size size2) {
        return Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Logger.a("MeteringRepeating", "MeteringRepeating clear!");
        DeferrableSurface deferrableSurface = this.f2627a;
        if (deferrableSurface != null) {
            deferrableSurface.c();
        }
        this.f2627a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String c() {
        return "MeteringRepeating";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public SessionConfig e() {
        return this.f2628b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public UseCaseConfig<?> f() {
        return this.f2629c;
    }
}
