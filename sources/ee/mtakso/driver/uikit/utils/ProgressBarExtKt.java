package ee.mtakso.driver.uikit.utils;

import android.content.res.ColorStateList;
import android.widget.ProgressBar;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressBarExt.kt */
/* loaded from: classes5.dex */
public final class ProgressBarExtKt {
    public static final void a(ProgressBar progressBar, int i8) {
        Intrinsics.f(progressBar, "<this>");
        progressBar.setProgressTintList(ColorStateList.valueOf(i8));
    }
}
