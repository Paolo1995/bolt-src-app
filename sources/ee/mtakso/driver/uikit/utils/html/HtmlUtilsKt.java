package ee.mtakso.driver.uikit.utils.html;

import android.os.Build;
import android.text.Html;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: HtmlUtils.kt */
/* loaded from: classes5.dex */
public final class HtmlUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.text.Spanned] */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.text.Spanned] */
    public static final CharSequence a(String str, Html.ImageGetter imageGetter) {
        String F;
        ?? fromHtml;
        Intrinsics.f(imageGetter, "imageGetter");
        if (str == null) {
            return null;
        }
        try {
            F = StringsKt__StringsJVMKt.F(str, "\n", "<br>", false, 4, null);
            if (Build.VERSION.SDK_INT >= 24) {
                fromHtml = Html.fromHtml(F, 0, imageGetter, null);
                str = fromHtml;
            } else {
                str = Html.fromHtml(F, imageGetter, null);
            }
        } catch (Exception e8) {
            Kalev.e(e8, "Error converting to html " + str);
        }
        return str;
    }
}
