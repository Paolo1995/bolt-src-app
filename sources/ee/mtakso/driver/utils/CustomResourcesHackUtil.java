package ee.mtakso.driver.utils;

import android.app.Activity;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomResourcesHackUtil.kt */
/* loaded from: classes5.dex */
public final class CustomResourcesHackUtil {
    public static final void a(Activity activity) {
        Intrinsics.f(activity, "activity");
        try {
            new WebView(activity);
        } catch (Exception unused) {
        }
    }
}
