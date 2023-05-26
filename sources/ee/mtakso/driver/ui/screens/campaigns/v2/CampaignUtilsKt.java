package ee.mtakso.driver.ui.screens.campaigns.v2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignUtils.kt */
/* loaded from: classes3.dex */
public final class CampaignUtilsKt {
    private static final Drawable a(Context context, int i8, int i9, int i10, int i11) {
        Drawable drawable = ContextCompat.getDrawable(context, i8);
        if (drawable != null) {
            drawable.setBounds(0, 0, i9, i10);
            DrawableCompat.n(drawable, ContextUtilsKt.b(context, i11));
        }
        return drawable;
    }

    public static final CharSequence b(Context context, int i8, CharSequence charSequence, CharSequence charSequence2) {
        boolean z7;
        boolean z8;
        boolean z9;
        Drawable a8;
        Intrinsics.f(context, "context");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean z10 = true;
        if (charSequence != null && charSequence.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            Drawable a9 = a(context, R.drawable.ic_campaign_vehicle_fill, Dimens.c(22), i8, R.attr.accentNeutral);
            if (a9 != null) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) " ");
                spannableStringBuilder.setSpan(new ImageSpan(a9, 0), length, length + 1, 17);
            }
            spannableStringBuilder.append(charSequence);
        }
        if (charSequence != null && charSequence.length() != 0) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (!z8) {
            if (charSequence2 != null && charSequence2.length() != 0) {
                z9 = false;
            } else {
                z9 = true;
            }
            if (!z9 && (a8 = a(context, R.drawable.ic_campaign_cat_loc_divider, Dimens.c(14), i8, R.attr.dynamicNeutral03)) != null) {
                int length2 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) " ");
                spannableStringBuilder.setSpan(new ImageSpan(a8, 0), length2, length2 + 1, 17);
            }
        }
        if (charSequence2 != null && charSequence2.length() != 0) {
            z10 = false;
        }
        if (!z10) {
            Drawable a10 = a(context, R.drawable.ic_campaign_pin_fill, Dimens.c(22), i8, R.attr.accentNeutral);
            if (a10 != null) {
                int length3 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) " ");
                spannableStringBuilder.setSpan(new ImageSpan(a10, 0), length3, length3 + 1, 17);
            }
            spannableStringBuilder.append(charSequence2);
        }
        return spannableStringBuilder;
    }
}
