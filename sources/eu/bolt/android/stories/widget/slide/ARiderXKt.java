package eu.bolt.android.stories.widget.slide;

import android.content.Context;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import eu.bolt.android.stories.widget.helper.LineInfoProviderImpl;
import eu.bolt.android.stories.widget.helper.RoundedBackgroundSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: ARiderX.kt */
/* loaded from: classes5.dex */
public final class ARiderXKt {
    public static final int a(Context context, int i8) {
        Intrinsics.f(context, "<this>");
        return ContextCompat.getColor(context, i8);
    }

    public static final int b(Context context, int i8) {
        Intrinsics.f(context, "<this>");
        return context.getResources().getDimensionPixelSize(i8);
    }

    public static final int c(Context context, float f8) {
        Intrinsics.f(context, "<this>");
        return (int) TypedValue.applyDimension(1, f8, context.getResources().getDisplayMetrics());
    }

    public static final float d(Context context, float f8) {
        Intrinsics.f(context, "<this>");
        return TypedValue.applyDimension(1, f8, context.getResources().getDisplayMetrics());
    }

    public static final <T extends View> T e(ViewGroup viewGroup, int i8) {
        Intrinsics.f(viewGroup, "<this>");
        T t7 = (T) LayoutInflater.from(viewGroup.getContext()).inflate(i8, viewGroup, false);
        Intrinsics.d(t7, "null cannot be cast to non-null type T of eu.bolt.android.stories.widget.slide.ARiderXKt.inflateWithoutAttach");
        return t7;
    }

    public static final void f(TextView textView, StoryTextStyle style) {
        int a8;
        int d8;
        int d9;
        Intrinsics.f(textView, "<this>");
        Intrinsics.f(style, "style");
        Integer c8 = style.c();
        if (c8 != null) {
            a8 = c8.intValue();
        } else {
            Context context = textView.getContext();
            Intrinsics.e(context, "context");
            a8 = a(context, style.a());
        }
        Context context2 = textView.getContext();
        Intrinsics.e(context2, "context");
        int b8 = b(context2, style.d());
        Context context3 = textView.getContext();
        Intrinsics.e(context3, "context");
        d8 = RangesKt___RangesKt.d(textView.getPaddingLeft(), b8);
        int paddingTop = textView.getPaddingTop();
        d9 = RangesKt___RangesKt.d(textView.getPaddingRight(), b8);
        textView.setPadding(d8, paddingTop, d9, textView.getPaddingBottom());
        textView.setShadowLayer(b8, 0.0f, 0.0f, 0);
        SpannableString spannableString = new SpannableString(style.e());
        spannableString.setSpan(new RoundedBackgroundSpan(a8, b8, b(context3, style.b()), new LineInfoProviderImpl(textView)), 0, style.e().length(), 18);
        textView.setText(spannableString);
    }

    public static final void g(View view, boolean z7) {
        int i8;
        Intrinsics.f(view, "<this>");
        if (z7) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        view.setVisibility(i8);
    }
}
