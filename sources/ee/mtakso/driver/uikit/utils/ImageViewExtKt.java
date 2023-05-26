package ee.mtakso.driver.uikit.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.widget.ImageView;
import androidx.core.widget.ImageViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageViewExt.kt */
/* loaded from: classes5.dex */
public final class ImageViewExtKt {
    public static final void a(ImageView imageView, Color color) {
        Intrinsics.f(imageView, "<this>");
        if (color != null) {
            Context context = imageView.getContext();
            Intrinsics.e(context, "context");
            ImageViewCompat.c(imageView, ColorStateList.valueOf(ColorKt.a(color, context)));
        }
    }
}
