package androidx.camera.camera2.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.workaround.PreviewPixelHDRnet;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;

/* loaded from: classes.dex */
public final class Camera2UseCaseConfigFactory implements UseCaseConfigFactory {

    /* renamed from: b  reason: collision with root package name */
    final DisplayInfoManager f2532b;

    /* renamed from: androidx.camera.camera2.internal.Camera2UseCaseConfigFactory$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2533a;

        static {
            int[] iArr = new int[UseCaseConfigFactory.CaptureType.values().length];
            f2533a = iArr;
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2533a[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2533a[UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2533a[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Camera2UseCaseConfigFactory(@NonNull Context context) {
        this.f2532b = DisplayInfoManager.b(context);
    }

    @Override // androidx.camera.core.impl.UseCaseConfigFactory
    @NonNull
    public Config a(@NonNull UseCaseConfigFactory.CaptureType captureType, int i8) {
        int i9;
        CaptureConfig.OptionUnpacker optionUnpacker;
        MutableOptionsBundle L = MutableOptionsBundle.L();
        SessionConfig.Builder builder = new SessionConfig.Builder();
        int[] iArr = AnonymousClass1.f2533a;
        int i10 = iArr[captureType.ordinal()];
        int i11 = 5;
        if (i10 != 1) {
            if (i10 != 2 && i10 != 3) {
                if (i10 == 4) {
                    builder.s(3);
                }
            } else {
                builder.s(1);
            }
        } else {
            if (i8 == 2) {
                i9 = 5;
            } else {
                i9 = 1;
            }
            builder.s(i9);
        }
        UseCaseConfigFactory.CaptureType captureType2 = UseCaseConfigFactory.CaptureType.PREVIEW;
        if (captureType == captureType2) {
            PreviewPixelHDRnet.a(builder);
        }
        L.o(UseCaseConfig.f3716n, builder.m());
        L.o(UseCaseConfig.f3718p, Camera2SessionOptionUnpacker.f2531a);
        CaptureConfig.Builder builder2 = new CaptureConfig.Builder();
        int i12 = iArr[captureType.ordinal()];
        if (i12 != 1) {
            if (i12 != 2 && i12 != 3) {
                if (i12 == 4) {
                    builder2.p(3);
                }
            } else {
                builder2.p(1);
            }
        } else {
            if (i8 != 2) {
                i11 = 2;
            }
            builder2.p(i11);
        }
        L.o(UseCaseConfig.f3717o, builder2.h());
        Config.Option<CaptureConfig.OptionUnpacker> option = UseCaseConfig.f3719q;
        if (captureType == UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE) {
            optionUnpacker = ImageCaptureOptionUnpacker.f2625c;
        } else {
            optionUnpacker = Camera2CaptureOptionUnpacker.f2485a;
        }
        L.o(option, optionUnpacker);
        if (captureType == captureType2) {
            L.o(ImageOutputConfig.f3658l, this.f2532b.d());
        }
        L.o(ImageOutputConfig.f3654h, Integer.valueOf(this.f2532b.c().getRotation()));
        if (captureType == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE) {
            L.o(UseCaseConfig.f3723u, Boolean.TRUE);
        }
        return OptionsBundle.J(L);
    }
}
