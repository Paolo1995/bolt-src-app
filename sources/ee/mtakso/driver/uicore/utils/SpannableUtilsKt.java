package ee.mtakso.driver.uicore.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import androidx.core.content.res.ResourcesCompat;
import ee.mtakso.driver.uicore.R$font;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: SpannableUtils.kt */
/* loaded from: classes5.dex */
public final class SpannableUtilsKt {
    public static final SpannableString a(String text, int i8) {
        Intrinsics.f(text, "text");
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new StyleSpan(1), 0, text.length(), 17);
        spannableString.setSpan(new ForegroundColorSpan(i8), 0, text.length(), 17);
        return spannableString;
    }

    public static final SpannableString b(String text, int i8) {
        Intrinsics.f(text, "text");
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ForegroundColorSpan(i8), 0, text.length(), 17);
        return spannableString;
    }

    public static final ImageSpan c(Context context, int i8) {
        Intrinsics.f(context, "context");
        return new CenteredImageSpan(context, i8);
    }

    public static final SpannableString d(Context context, String fullString, String... placeholders) {
        int b02;
        Intrinsics.f(context, "context");
        Intrinsics.f(fullString, "fullString");
        Intrinsics.f(placeholders, "placeholders");
        SpannableString spannableString = new SpannableString(fullString);
        int i8 = 0;
        for (String str : placeholders) {
            if (str != null) {
                b02 = StringsKt__StringsKt.b0(fullString, str, i8, false, 4, null);
                if (b02 < 0) {
                    Kalev.e(new IndexOutOfBoundsException(), "Couldn't make " + str + " bold in " + fullString + " ");
                } else {
                    i8 = b02 + str.length();
                    Typeface typeface = Typeface.create(ResourcesCompat.h(context, R$font.f34588a), 1);
                    Intrinsics.e(typeface, "typeface");
                    spannableString.setSpan(new CustomTypefaceSpan(typeface), b02, i8, 17);
                }
            }
        }
        return spannableString;
    }

    public static final <T> void e(SpannableString spannedString, Class<T> spanToFind, Function0<? extends Object> spanToReplaceFunc) {
        Intrinsics.f(spannedString, "spannedString");
        Intrinsics.f(spanToFind, "spanToFind");
        Intrinsics.f(spanToReplaceFunc, "spanToReplaceFunc");
        Object[] foundSpans = spannedString.getSpans(0, spannedString.length(), spanToFind);
        Intrinsics.e(foundSpans, "foundSpans");
        for (Object obj : foundSpans) {
            int spanStart = spannedString.getSpanStart(obj);
            int spanEnd = spannedString.getSpanEnd(obj);
            int spanFlags = spannedString.getSpanFlags(obj);
            spannedString.removeSpan(obj);
            spannedString.setSpan(spanToReplaceFunc.invoke(), spanStart, spanEnd, spanFlags);
        }
    }
}
