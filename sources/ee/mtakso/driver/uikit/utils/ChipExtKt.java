package ee.mtakso.driver.uikit.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import com.google.android.material.chip.Chip;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChipExt.kt */
/* loaded from: classes5.dex */
public final class ChipExtKt {
    public static final void a(Chip chip, Color color) {
        ColorStateList colorStateList;
        Intrinsics.f(chip, "<this>");
        if (color != null) {
            Context context = chip.getContext();
            Intrinsics.e(context, "context");
            colorStateList = ColorKt.b(color, context);
        } else {
            colorStateList = null;
        }
        chip.setChipBackgroundColor(colorStateList);
    }
}
