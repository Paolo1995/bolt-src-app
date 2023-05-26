package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ImageCaptureFlashNotFireQuirk implements UseTorchAsFlashQuirk {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f2871a = Arrays.asList("itel w6004");

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f2872b = Arrays.asList("sm-j700f", "sm-j710f");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        boolean z7;
        List<String> list = f2872b;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        if (list.contains(str.toLowerCase(locale)) && ((Integer) cameraCharacteristicsCompat.a(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        boolean contains = f2871a.contains(str.toLowerCase(locale));
        if (z7 || contains) {
            return true;
        }
        return false;
    }
}
