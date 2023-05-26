package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class CTCarouselViewPager extends ViewPager {
    public CTCarouselViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i8, int i9) {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            childAt.measure(i8, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i10) {
                i10 = measuredHeight;
            }
        }
        if (i10 != 0) {
            i9 = View.MeasureSpec.makeMeasureSpec(i10, Pow2.MAX_POW2);
        }
        super.onMeasure(i8, i9);
    }
}
