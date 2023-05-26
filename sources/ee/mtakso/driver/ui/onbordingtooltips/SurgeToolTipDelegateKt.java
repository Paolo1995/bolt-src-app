package ee.mtakso.driver.ui.onbordingtooltips;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.utils.Utils;
import eu.bolt.kalev.Kalev;

/* compiled from: SurgeToolTipDelegate.kt */
/* loaded from: classes3.dex */
public final class SurgeToolTipDelegateKt {
    private static final void b(View view) {
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AlertDialog alertDialog, ViewGroup viewGroup, ViewGroup viewGroup2, int i8) {
        Integer num;
        int i9;
        WindowManager.LayoutParams layoutParams;
        int i10;
        int measuredHeight = viewGroup.getMeasuredHeight();
        int measuredHeight2 = viewGroup2.getMeasuredHeight();
        ConstraintLayout constraintLayout = (ConstraintLayout) alertDialog.findViewById(R.id.surgePopupContent);
        if (constraintLayout != null) {
            b(constraintLayout);
        }
        if (constraintLayout != null) {
            num = Integer.valueOf(constraintLayout.getMeasuredHeight());
        } else {
            num = null;
        }
        if (num != null) {
            int i11 = measuredHeight - measuredHeight2;
            if (i11 < 0) {
                i9 = 0;
            } else {
                i9 = i11;
            }
            Window window = alertDialog.getWindow();
            if (window != null) {
                layoutParams = window.getAttributes();
            } else {
                layoutParams = null;
            }
            if (i9 + i8 > num.intValue()) {
                ImageView imageView = (ImageView) alertDialog.findViewById(R.id.tooltipTopTriangle);
                if (imageView != null) {
                    ViewExtKt.e(imageView, false, 0, 2, null);
                }
                ImageView imageView2 = (ImageView) alertDialog.findViewById(R.id.tooltipBottomTriangle);
                if (imageView2 != null) {
                    ViewExtKt.e(imageView2, false, 0, 3, null);
                }
                if (layoutParams != null) {
                    layoutParams.y = i11 + i8;
                }
            } else {
                ImageView imageView3 = (ImageView) alertDialog.findViewById(R.id.tooltipBottomTriangle);
                if (imageView3 != null) {
                    ViewExtKt.e(imageView3, false, 0, 2, null);
                }
                ImageView imageView4 = (ImageView) alertDialog.findViewById(R.id.tooltipTopTriangle);
                if (imageView4 != null) {
                    ViewExtKt.e(imageView4, false, 0, 3, null);
                }
                if (layoutParams != null) {
                    layoutParams.y = (i11 + i8) - num.intValue();
                }
            }
            if (Utils.g(viewGroup2.getContext())) {
                i10 = 48;
            } else {
                i10 = 8388661;
            }
            Window window2 = alertDialog.getWindow();
            if (window2 != null) {
                window2.setGravity(i10);
            }
            Window window3 = alertDialog.getWindow();
            if (window3 != null) {
                window3.setAttributes(layoutParams);
                return;
            }
            return;
        }
        Kalev.d("Window height is null");
    }
}
