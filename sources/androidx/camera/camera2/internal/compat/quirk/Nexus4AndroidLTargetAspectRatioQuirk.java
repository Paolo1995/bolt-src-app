package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class Nexus4AndroidLTargetAspectRatioQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f2877a = Arrays.asList("NEXUS 4");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        if ("GOOGLE".equalsIgnoreCase(Build.BRAND) && Build.VERSION.SDK_INT < 23 && f2877a.contains(Build.MODEL.toUpperCase(Locale.US))) {
            return true;
        }
        return false;
    }

    public int a() {
        return 2;
    }
}
