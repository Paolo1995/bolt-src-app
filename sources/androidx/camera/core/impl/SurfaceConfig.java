package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.internal.utils.SizeUtil;

/* loaded from: classes.dex */
public abstract class SurfaceConfig {

    /* loaded from: classes.dex */
    public enum ConfigSize {
        VGA(0),
        PREVIEW(1),
        RECORD(2),
        MAXIMUM(3),
        NOT_SUPPORT(4);
        

        /* renamed from: f  reason: collision with root package name */
        final int f3702f;

        ConfigSize(int i8) {
            this.f3702f = i8;
        }

        int a() {
            return this.f3702f;
        }
    }

    /* loaded from: classes.dex */
    public enum ConfigType {
        PRIV,
        YUV,
        JPEG,
        RAW
    }

    @NonNull
    public static SurfaceConfig a(@NonNull ConfigType configType, @NonNull ConfigSize configSize) {
        return new AutoValue_SurfaceConfig(configType, configSize);
    }

    @NonNull
    public static ConfigType d(int i8) {
        if (i8 == 35) {
            return ConfigType.YUV;
        }
        if (i8 == 256) {
            return ConfigType.JPEG;
        }
        if (i8 == 32) {
            return ConfigType.RAW;
        }
        return ConfigType.PRIV;
    }

    @NonNull
    public static SurfaceConfig f(int i8, @NonNull Size size, @NonNull SurfaceSizeDefinition surfaceSizeDefinition) {
        ConfigSize configSize;
        ConfigType d8 = d(i8);
        ConfigSize configSize2 = ConfigSize.VGA;
        int a8 = SizeUtil.a(size);
        if (a8 <= SizeUtil.a(surfaceSizeDefinition.b())) {
            configSize = ConfigSize.VGA;
        } else if (a8 <= SizeUtil.a(surfaceSizeDefinition.c())) {
            configSize = ConfigSize.PREVIEW;
        } else if (a8 <= SizeUtil.a(surfaceSizeDefinition.d())) {
            configSize = ConfigSize.RECORD;
        } else {
            configSize = ConfigSize.MAXIMUM;
        }
        return a(d8, configSize);
    }

    @NonNull
    public abstract ConfigSize b();

    @NonNull
    public abstract ConfigType c();

    public final boolean e(@NonNull SurfaceConfig surfaceConfig) {
        ConfigType c8 = surfaceConfig.c();
        if (surfaceConfig.b().a() <= b().a() && c8 == c()) {
            return true;
        }
        return false;
    }
}
