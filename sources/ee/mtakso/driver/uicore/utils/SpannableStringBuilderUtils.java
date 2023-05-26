package ee.mtakso.driver.uicore.utils;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpannableStringBuilderExt.kt */
/* loaded from: classes5.dex */
public final class SpannableStringBuilderUtils {
    public static final SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder, CharSequence text, Object... whats) {
        Intrinsics.f(spannableStringBuilder, "<this>");
        Intrinsics.f(text, "text");
        Intrinsics.f(whats, "whats");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(text);
        for (Object obj : whats) {
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }

    public static final SpannableString b(SpannableString spannableString, Object... whats) {
        Intrinsics.f(spannableString, "<this>");
        Intrinsics.f(whats, "whats");
        for (Object obj : whats) {
            spannableString.setSpan(obj, 0, spannableString.length(), 33);
        }
        return spannableString;
    }
}
