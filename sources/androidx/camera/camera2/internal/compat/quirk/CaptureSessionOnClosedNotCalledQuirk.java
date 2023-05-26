package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* loaded from: classes.dex */
public class CaptureSessionOnClosedNotCalledQuirk implements Quirk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return false;
    }
}
