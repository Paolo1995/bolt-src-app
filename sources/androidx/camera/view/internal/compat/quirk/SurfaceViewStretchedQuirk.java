package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* loaded from: classes.dex */
public class SurfaceViewStretchedQuirk implements Quirk {
    private static boolean a() {
        if ("LENOVO".equalsIgnoreCase(Build.MANUFACTURER) && "Q706F".equalsIgnoreCase(Build.DEVICE)) {
            return true;
        }
        return false;
    }

    private static boolean b() {
        if ("OPPO".equalsIgnoreCase(Build.MANUFACTURER) && "OP4E75L1".equalsIgnoreCase(Build.DEVICE)) {
            return true;
        }
        return false;
    }

    private static boolean c() {
        if ("SAMSUNG".equalsIgnoreCase(Build.MANUFACTURER)) {
            String str = Build.DEVICE;
            if ("F2Q".equalsIgnoreCase(str) || "Q2Q".equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        if (Build.VERSION.SDK_INT < 33 && (c() || b() || a())) {
            return true;
        }
        return false;
    }
}
