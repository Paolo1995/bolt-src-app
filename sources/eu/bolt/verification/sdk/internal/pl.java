package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.text.SpannableString;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: classes5.dex */
public final class pl {
    public static final void a(TextView textView, mk style) {
        int b8;
        int d8;
        int d9;
        Intrinsics.f(textView, "<this>");
        Intrinsics.f(style, "style");
        Integer c8 = style.c();
        if (c8 != null) {
            b8 = c8.intValue();
        } else {
            Context context = textView.getContext();
            Intrinsics.e(context, "context");
            b8 = f2.b(context, style.a());
        }
        Context context2 = textView.getContext();
        Intrinsics.e(context2, "context");
        int n8 = f2.n(context2, style.d());
        Context context3 = textView.getContext();
        Intrinsics.e(context3, "context");
        d8 = RangesKt___RangesKt.d(textView.getPaddingLeft(), n8);
        int paddingTop = textView.getPaddingTop();
        d9 = RangesKt___RangesKt.d(textView.getPaddingRight(), n8);
        textView.setPadding(d8, paddingTop, d9, textView.getPaddingBottom());
        textView.setShadowLayer(n8, 0.0f, 0.0f, 0);
        SpannableString spannableString = new SpannableString(style.e());
        spannableString.setSpan(new pg(b8, n8, f2.n(context3, style.b()), new rb(textView)), 0, style.e().length(), 18);
        textView.setText(spannableString);
    }
}
