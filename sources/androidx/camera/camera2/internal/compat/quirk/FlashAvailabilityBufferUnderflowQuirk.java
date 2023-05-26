package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class FlashAvailabilityBufferUnderflowQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<Pair<String, String>> f2868a = new HashSet(Arrays.asList(new Pair("sprd", "lemp")));

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        Set<Pair<String, String>> set = f2868a;
        String str = Build.MANUFACTURER;
        Locale locale = Locale.US;
        return set.contains(new Pair(str.toLowerCase(locale), Build.MODEL.toLowerCase(locale)));
    }
}
