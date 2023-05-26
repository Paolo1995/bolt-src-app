package ee.mtakso.driver.uikit.utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpannableUtils.kt */
/* loaded from: classes5.dex */
public final class SpannableUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final SpannableUtils f36056a = new SpannableUtils();

    private SpannableUtils() {
    }

    public final Spannable a(CharSequence text) {
        Intrinsics.f(text, "text");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, text.length(), 17);
        return spannableStringBuilder;
    }
}
