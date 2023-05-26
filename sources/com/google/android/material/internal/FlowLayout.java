package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: f  reason: collision with root package name */
    private int f13596f;

    /* renamed from: g  reason: collision with root package name */
    private int f13597g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13598h;

    /* renamed from: i  reason: collision with root package name */
    private int f13599i;

    public FlowLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int a(int i8, int i9, int i10) {
        if (i9 != Integer.MIN_VALUE) {
            if (i9 != 1073741824) {
                return i10;
            }
            return i8;
        }
        return Math.min(i10, i8);
    }

    private void d(@NonNull Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.P2, 0, 0);
        this.f13596f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.R2, 0);
        this.f13597g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Q2, 0);
        obtainStyledAttributes.recycle();
    }

    public int b(@NonNull View view) {
        Object tag = view.getTag(R$id.row_index_key);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    public boolean c() {
        return this.f13598h;
    }

    protected int getItemSpacing() {
        return this.f13597g;
    }

    protected int getLineSpacing() {
        return this.f13596f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRowCount() {
        return this.f13599i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        boolean z8;
        int paddingLeft;
        int paddingRight;
        int i12;
        int i13;
        if (getChildCount() == 0) {
            this.f13599i = 0;
            return;
        }
        this.f13599i = 1;
        if (ViewCompat.E(this) == 1) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (z8) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int i14 = (i10 - i8) - paddingRight;
        int i15 = paddingLeft;
        int i16 = paddingTop;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R$id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i13 = MarginLayoutParamsCompat.b(marginLayoutParams);
                    i12 = MarginLayoutParamsCompat.a(marginLayoutParams);
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                int measuredWidth = i15 + i13 + childAt.getMeasuredWidth();
                if (!this.f13598h && measuredWidth > i14) {
                    i16 = this.f13596f + paddingTop;
                    this.f13599i++;
                    i15 = paddingLeft;
                }
                childAt.setTag(R$id.row_index_key, Integer.valueOf(this.f13599i - 1));
                int i18 = i15 + i13;
                int measuredWidth2 = childAt.getMeasuredWidth() + i18;
                int measuredHeight = childAt.getMeasuredHeight() + i16;
                if (z8) {
                    childAt.layout(i14 - measuredWidth2, i16, (i14 - i15) - i13, measuredHeight);
                } else {
                    childAt.layout(i18, i16, measuredWidth2, measuredHeight);
                }
                i15 += i13 + i12 + childAt.getMeasuredWidth() + this.f13597g;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int size = View.MeasureSpec.getSize(i8);
        int mode = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i9);
        int mode2 = View.MeasureSpec.getMode(i9);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            i10 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        } else {
            i10 = size;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i10 - getPaddingRight();
        int i14 = paddingTop;
        int i15 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i8, i9);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i11 = marginLayoutParams.leftMargin + 0;
                    i12 = marginLayoutParams.rightMargin + 0;
                } else {
                    i11 = 0;
                    i12 = 0;
                }
                int i17 = paddingLeft;
                if (paddingLeft + i11 + childAt.getMeasuredWidth() > paddingRight && !c()) {
                    i13 = getPaddingLeft();
                    i14 = this.f13596f + paddingTop;
                } else {
                    i13 = i17;
                }
                int measuredWidth = i13 + i11 + childAt.getMeasuredWidth();
                int measuredHeight = i14 + childAt.getMeasuredHeight();
                if (measuredWidth > i15) {
                    i15 = measuredWidth;
                }
                paddingLeft = i13 + i11 + i12 + childAt.getMeasuredWidth() + this.f13597g;
                if (i16 == getChildCount() - 1) {
                    i15 += i12;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i15 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemSpacing(int i8) {
        this.f13597g = i8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLineSpacing(int i8) {
        this.f13596f = i8;
    }

    public void setSingleLine(boolean z7) {
        this.f13598h = z7;
    }

    public FlowLayout(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f13598h = false;
        d(context, attributeSet);
    }
}
