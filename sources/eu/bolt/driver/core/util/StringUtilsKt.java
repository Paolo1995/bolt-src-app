package eu.bolt.driver.core.util;

import android.os.Build;
import android.text.Html;
import eu.bolt.kalev.Kalev;

/* compiled from: StringUtils.kt */
/* loaded from: classes5.dex */
public final class StringUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.text.Spanned] */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.text.Spanned] */
    public static final CharSequence a(String str) {
        ?? fromHtml;
        if (str == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                fromHtml = Html.fromHtml(str, 0);
                str = fromHtml;
            } else {
                str = Html.fromHtml(str);
            }
            return str;
        } catch (Exception e8) {
            Kalev.e(e8, "Error converting to html " + str);
            return str;
        }
    }
}
