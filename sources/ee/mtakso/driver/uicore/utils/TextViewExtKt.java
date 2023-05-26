package ee.mtakso.driver.uicore.utils;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import ee.mtakso.driver.uikit.utils.LocaleExtKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextViewExt.kt */
/* loaded from: classes5.dex */
public final class TextViewExtKt {
    public static final void a(TextView textView, Drawable drawable) {
        Intrinsics.f(textView, "<this>");
        if (LocaleExtKt.a()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }
}
