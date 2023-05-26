package eu.bolt.verification.sdk.internal;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a6 {
    public static final Drawable a(Drawable drawable, int i8) {
        Intrinsics.f(drawable, "<this>");
        return b(drawable, ColorStateList.valueOf(i8));
    }

    public static final Drawable b(Drawable drawable, ColorStateList colorStateList) {
        Intrinsics.f(drawable, "<this>");
        if (colorStateList != null) {
            Drawable r7 = DrawableCompat.r(drawable.mutate());
            Intrinsics.e(r7, "wrap(mutate())");
            DrawableCompat.o(r7, colorStateList);
            return r7;
        }
        return drawable;
    }
}
