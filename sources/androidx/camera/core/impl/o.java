package androidx.camera.core.impl;

import android.util.Size;
import java.util.List;

/* compiled from: ImageOutputConfig.java */
/* loaded from: classes.dex */
public final /* synthetic */ class o {
    public static int a(ImageOutputConfig imageOutputConfig, int i8) {
        return ((Integer) imageOutputConfig.e(ImageOutputConfig.f3655i, Integer.valueOf(i8))).intValue();
    }

    public static Size b(ImageOutputConfig imageOutputConfig, Size size) {
        return (Size) imageOutputConfig.e(ImageOutputConfig.f3657k, size);
    }

    public static Size c(ImageOutputConfig imageOutputConfig, Size size) {
        return (Size) imageOutputConfig.e(ImageOutputConfig.f3658l, size);
    }

    public static List d(ImageOutputConfig imageOutputConfig, List list) {
        return (List) imageOutputConfig.e(ImageOutputConfig.f3659m, list);
    }

    public static int e(ImageOutputConfig imageOutputConfig) {
        return ((Integer) imageOutputConfig.a(ImageOutputConfig.f3653g)).intValue();
    }

    public static Size f(ImageOutputConfig imageOutputConfig, Size size) {
        return (Size) imageOutputConfig.e(ImageOutputConfig.f3656j, size);
    }

    public static int g(ImageOutputConfig imageOutputConfig, int i8) {
        return ((Integer) imageOutputConfig.e(ImageOutputConfig.f3654h, Integer.valueOf(i8))).intValue();
    }

    public static boolean h(ImageOutputConfig imageOutputConfig) {
        return imageOutputConfig.b(ImageOutputConfig.f3653g);
    }
}
