package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* loaded from: classes.dex */
public class SurfaceViewNotCroppedByParentQuirk implements Quirk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        if ("XIAOMI".equalsIgnoreCase(Build.MANUFACTURER) && "M2101K7AG".equalsIgnoreCase(Build.MODEL)) {
            return true;
        }
        return false;
    }
}
