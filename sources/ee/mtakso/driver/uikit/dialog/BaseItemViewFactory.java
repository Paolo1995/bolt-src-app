package ee.mtakso.driver.uikit.dialog;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseItemViewFactory.kt */
/* loaded from: classes5.dex */
public class BaseItemViewFactory {
    public static /* synthetic */ View b(BaseItemViewFactory baseItemViewFactory, ViewGroup viewGroup, int i8, Rect rect, int i9, int i10, LayoutInflater layoutInflater, int i11, Object obj) {
        int i12;
        int i13;
        if (obj == null) {
            if ((i11 & 2) != 0) {
                rect = null;
            }
            Rect rect2 = rect;
            if ((i11 & 4) != 0) {
                i12 = -1;
            } else {
                i12 = i9;
            }
            if ((i11 & 8) != 0) {
                i13 = -2;
            } else {
                i13 = i10;
            }
            if ((i11 & 16) != 0) {
                layoutInflater = LayoutInflater.from(viewGroup.getContext());
                Intrinsics.e(layoutInflater, "from(context)");
            }
            return baseItemViewFactory.a(viewGroup, i8, rect2, i12, i13, layoutInflater);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: inflateChild");
    }

    protected final <T extends View> T a(ViewGroup viewGroup, int i8, Rect rect, int i9, int i10, LayoutInflater inflater) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.f(viewGroup, "<this>");
        Intrinsics.f(inflater, "inflater");
        T t7 = (T) inflater.inflate(i8, viewGroup, false);
        Intrinsics.d(t7, "null cannot be cast to non-null type T of ee.mtakso.driver.uikit.dialog.BaseItemViewFactory.inflateChild");
        if (rect != null) {
            ViewGroup.LayoutParams layoutParams = t7.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else if (layoutParams == null) {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i9, i10);
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            marginLayoutParams.leftMargin = rect.left;
            marginLayoutParams.topMargin = rect.top;
            marginLayoutParams.rightMargin = rect.right;
            marginLayoutParams.bottomMargin = rect.bottom;
            t7.setLayoutParams(marginLayoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = t7.getLayoutParams();
        layoutParams2.width = i9;
        layoutParams2.height = i10;
        t7.setLayoutParams(layoutParams2);
        viewGroup.addView(t7);
        return t7;
    }
}
