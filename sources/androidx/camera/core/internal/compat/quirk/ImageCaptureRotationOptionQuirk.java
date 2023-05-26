package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirk;

/* loaded from: classes.dex */
public final class ImageCaptureRotationOptionQuirk implements Quirk {
    private static boolean a() {
        if ("HONOR".equalsIgnoreCase(Build.BRAND) && "STK-LX1".equalsIgnoreCase(Build.MODEL)) {
            return true;
        }
        return false;
    }

    private static boolean b() {
        if ("HUAWEI".equalsIgnoreCase(Build.BRAND) && "SNE-LX1".equalsIgnoreCase(Build.MODEL)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        if (!b() && !a()) {
            return false;
        }
        return true;
    }

    public boolean c(@NonNull Config.Option<?> option) {
        if (option != CaptureConfig.f3613h) {
            return true;
        }
        return false;
    }
}
