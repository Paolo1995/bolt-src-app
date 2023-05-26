package ee.mtakso.driver.uicore.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/* compiled from: Dimens.kt */
/* loaded from: classes5.dex */
public final class Dimens {
    public static final float a(float f8) {
        return TypedValue.applyDimension(2, f8, Resources.getSystem().getDisplayMetrics());
    }

    public static final int b(int i8) {
        return (int) TypedValue.applyDimension(2, i8, Resources.getSystem().getDisplayMetrics());
    }

    public static final float c(float f8) {
        return TypedValue.applyDimension(1, f8, Resources.getSystem().getDisplayMetrics());
    }

    public static final int d(int i8) {
        return (int) TypedValue.applyDimension(1, i8, Resources.getSystem().getDisplayMetrics());
    }
}
