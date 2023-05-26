package com.sinch.android.rtc.internal.client.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.api.Api;
import org.jctools.util.Pow2;

/* loaded from: classes3.dex */
class RendererViewContainer extends ViewGroup {
    private int heightPercent;
    private int widthPercent;
    private int xPercent;
    private int yPercent;

    public RendererViewContainer(Context context) {
        super(context);
        this.xPercent = 0;
        this.yPercent = 0;
        this.widthPercent = 100;
        this.heightPercent = 100;
    }

    public RendererViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xPercent = 0;
        this.yPercent = 0;
        this.widthPercent = 100;
        this.heightPercent = 100;
    }

    public RendererViewContainer(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.xPercent = 0;
        this.yPercent = 0;
        this.widthPercent = 100;
        this.heightPercent = 100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        int i12 = i10 - i8;
        int i13 = i11 - i9;
        int i14 = (this.widthPercent * i12) / 100;
        int i15 = (this.heightPercent * i13) / 100;
        int i16 = i8 + ((i12 * this.xPercent) / 100);
        int i17 = i9 + ((i13 * this.yPercent) / 100);
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i19 = ((i14 - measuredWidth) / 2) + i16;
                int i20 = ((i15 - measuredHeight) / 2) + i17;
                childAt.layout(i19, i20, measuredWidth + i19, measuredHeight + i20);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        int defaultSize = View.getDefaultSize(Api.BaseClientBuilder.API_PRIORITY_OTHER, i8);
        int defaultSize2 = View.getDefaultSize(Api.BaseClientBuilder.API_PRIORITY_OTHER, i9);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(defaultSize, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(defaultSize2, Pow2.MAX_POW2));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((defaultSize * this.widthPercent) / 100, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((defaultSize2 * this.heightPercent) / 100, Integer.MIN_VALUE);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
            }
        }
    }

    public void setPosition(int i8, int i9, int i10, int i11) {
        this.xPercent = i8;
        this.yPercent = i9;
        this.widthPercent = i10;
        this.heightPercent = i11;
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        super.setVisibility(i8);
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            getChildAt(i9).setVisibility(i8);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
