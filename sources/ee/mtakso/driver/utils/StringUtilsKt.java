package ee.mtakso.driver.utils;

import android.os.Build;
import android.text.Html;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

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

    public static final CharSequence b(CharSequence charSequence, int i8, int i9) {
        Intrinsics.f(charSequence, "<this>");
        if (charSequence.length() >= i9) {
            return charSequence.subSequence(i8, i9);
        }
        return charSequence;
    }
}
