package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class PreviewPixelHDRnetQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f2878a = Arrays.asList("sunfish", "bramble", "redfin", "barbet");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        if ("Google".equals(Build.MANUFACTURER) && f2878a.contains(Build.DEVICE.toLowerCase(Locale.getDefault()))) {
            return true;
        }
        return false;
    }
}
