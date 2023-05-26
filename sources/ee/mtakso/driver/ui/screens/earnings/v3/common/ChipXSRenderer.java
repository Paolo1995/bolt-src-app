package ee.mtakso.driver.ui.screens.earnings.v3.common;

import android.widget.TextView;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChipXSRenderer.kt */
/* loaded from: classes3.dex */
public final class ChipXSRenderer {
    public final void a(TextView textView, ChipModel chipModel) {
        int c8;
        int c9;
        Intrinsics.f(textView, "textView");
        if (chipModel == null) {
            ViewExtKt.d(textView, false, 0, 2, null);
            return;
        }
        ViewExtKt.d(textView, false, 0, 3, null);
        TextViewExtKt.h(textView, chipModel.c());
        TextViewExtKt.i(textView, chipModel.d());
        ViewExtKt.b(textView, chipModel.a());
        if (chipModel.b() == null) {
            c8 = Dimens.c(8);
        } else {
            c8 = Dimens.c(4);
        }
        if (chipModel.c() == null) {
            c9 = Dimens.c(4);
        } else {
            c9 = Dimens.c(8);
        }
        textView.setPaddingRelative(c8, textView.getPaddingTop(), c9, textView.getPaddingBottom());
        Image b8 = chipModel.b();
        if (b8 != null) {
            ImageKt.d(b8, textView, Dimens.c(16), Dimens.c(16));
        }
    }
}
