package ee.mtakso.driver.utils;

import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowExt.kt */
/* loaded from: classes5.dex */
public final class StatusBarUtils {
    public static final void a(Window window, int i8, boolean z7) {
        Intrinsics.f(window, "<this>");
        int color = ContextCompat.getColor(window.getContext(), i8);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(color);
        new WindowInsetsControllerCompat(window, window.getDecorView()).d(z7);
    }
}
