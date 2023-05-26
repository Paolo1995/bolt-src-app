package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: CategoryAndPriceDelegate.kt */
/* loaded from: classes3.dex */
public final class CategoryAndPriceDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f32375a;

    /* renamed from: b  reason: collision with root package name */
    private String f32376b;

    public CategoryAndPriceDelegate(TextView textView) {
        Intrinsics.f(textView, "textView");
        this.f32375a = textView;
    }

    private final CharSequence b(CharSequence charSequence, int i8) {
        boolean z7 = false;
        if (i8 >= 0 && i8 < charSequence.length()) {
            z7 = true;
        }
        if (!z7) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int i9 = i8 + 1;
        spannableStringBuilder.setSpan(new StyleSpan(1), i8, i9, 17);
        Context context = this.f32375a.getContext();
        Intrinsics.e(context, "textView.context");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextUtilsKt.b(context, R.attr.colorBorderNeutralSecondary)), i8, i9, 17);
        return spannableStringBuilder;
    }

    public final void a(String str) {
        boolean z7;
        int d02;
        if (Intrinsics.a(str, this.f32376b)) {
            return;
        }
        TextView textView = this.f32375a;
        if (str != null && str.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        CharSequence charSequence = null;
        ViewExtKt.e(textView, true ^ z7, 0, 2, null);
        TextView textView2 = this.f32375a;
        if (str != null) {
            d02 = StringsKt__StringsKt.d0(str, new char[]{183, 8226}, 0, false, 6, null);
            charSequence = b(str, d02);
        }
        textView2.setText(charSequence);
        this.f32376b = str;
    }
}
