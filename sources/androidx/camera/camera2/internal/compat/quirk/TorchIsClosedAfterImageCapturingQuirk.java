package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class TorchIsClosedAfterImageCapturingQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f2879a = Arrays.asList("mi a1", "mi a2", "mi a2 lite", "redmi 4x", "redmi 5a", "redmi 6 pro");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return f2879a.contains(Build.MODEL.toLowerCase(Locale.US));
    }
}
