package ee.mtakso.driver.uikit.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/* compiled from: Dimens.kt */
/* loaded from: classes5.dex */
public final class Dimens {
    public static final int a(int i8) {
        return (int) TypedValue.applyDimension(2, i8, Resources.getSystem().getDisplayMetrics());
    }

    public static final float b(float f8) {
        return TypedValue.applyDimension(1, f8, Resources.getSystem().getDisplayMetrics());
    }

    public static final int c(int i8) {
        return (int) TypedValue.applyDimension(1, i8, Resources.getSystem().getDisplayMetrics());
    }
}
