package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: h0  reason: collision with root package name */
    private static final int f12834h0 = R$style.Widget_MaterialComponents_Toolbar;

    /* renamed from: i0  reason: collision with root package name */
    private static final ImageView.ScaleType[] f12835i0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: c0  reason: collision with root package name */
    private Integer f12836c0;

    /* renamed from: d0  reason: collision with root package name */
    private boolean f12837d0;

    /* renamed from: e0  reason: collision with root package name */
    private boolean f12838e0;

    /* renamed from: f0  reason: collision with root package name */
    private ImageView.ScaleType f12839f0;

    /* renamed from: g0  reason: collision with root package name */
    private Boolean f12840g0;

    public MaterialToolbar(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f12485n0);
    }

    private Pair<Integer, Integer> S(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i8 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i8 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i8 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void T(Context context) {
        int i8;
        Drawable background = getBackground();
        if (background != null && !(background instanceof ColorDrawable)) {
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        if (background != null) {
            i8 = ((ColorDrawable) background).getColor();
        } else {
            i8 = 0;
        }
        materialShapeDrawable.c0(ColorStateList.valueOf(i8));
        materialShapeDrawable.R(context);
        materialShapeDrawable.b0(ViewCompat.y(this));
        ViewCompat.w0(this, materialShapeDrawable);
    }

    private void U(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i8 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i9 = measuredWidth2 + i8;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i8, 0), Math.max(i9 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i8 += max;
            i9 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i9 - i8, Pow2.MAX_POW2), view.getMeasuredHeightAndState());
        }
        view.layout(i8, view.getTop(), i9, view.getBottom());
    }

    private void V() {
        if (!this.f12837d0 && !this.f12838e0) {
            return;
        }
        TextView f8 = ToolbarUtils.f(this);
        TextView d8 = ToolbarUtils.d(this);
        if (f8 == null && d8 == null) {
            return;
        }
        Pair<Integer, Integer> S = S(f8, d8);
        if (this.f12837d0 && f8 != null) {
            U(f8, S);
        }
        if (this.f12838e0 && d8 != null) {
            U(d8, S);
        }
    }

    private Drawable W(Drawable drawable) {
        if (drawable != null && this.f12836c0 != null) {
            Drawable r7 = DrawableCompat.r(drawable.mutate());
            DrawableCompat.n(r7, this.f12836c0.intValue());
            return r7;
        }
        return drawable;
    }

    private void X() {
        ImageView b8 = ToolbarUtils.b(this);
        if (b8 != null) {
            Boolean bool = this.f12840g0;
            if (bool != null) {
                b8.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f12839f0;
            if (scaleType != null) {
                b8.setScaleType(scaleType);
            }
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f12839f0;
    }

    public Integer getNavigationIconTint() {
        return this.f12836c0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        V();
        X();
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        MaterialShapeUtils.d(this, f8);
    }

    public void setLogoAdjustViewBounds(boolean z7) {
        Boolean bool = this.f12840g0;
        if (bool == null || bool.booleanValue() != z7) {
            this.f12840g0 = Boolean.valueOf(z7);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.f12839f0 != scaleType) {
            this.f12839f0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(W(drawable));
    }

    public void setNavigationIconTint(int i8) {
        this.f12836c0 = Integer.valueOf(i8);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z7) {
        if (this.f12838e0 != z7) {
            this.f12838e0 = z7;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z7) {
        if (this.f12837d0 != z7) {
            this.f12837d0 = z7;
            requestLayout();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialToolbar(@androidx.annotation.NonNull android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.appbar.MaterialToolbar.f12834h0
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.f12564h5
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.i(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R$styleable.f12591k5
            boolean r0 = r9.hasValue(r10)
            r1 = -1
            if (r0 == 0) goto L29
            int r10 = r9.getColor(r10, r1)
            r7.setNavigationIconTint(r10)
        L29:
            int r10 = com.google.android.material.R$styleable.f12609m5
            boolean r10 = r9.getBoolean(r10, r6)
            r7.f12837d0 = r10
            int r10 = com.google.android.material.R$styleable.f12600l5
            boolean r10 = r9.getBoolean(r10, r6)
            r7.f12838e0 = r10
            int r10 = com.google.android.material.R$styleable.f12582j5
            int r10 = r9.getInt(r10, r1)
            if (r10 < 0) goto L4a
            android.widget.ImageView$ScaleType[] r0 = com.google.android.material.appbar.MaterialToolbar.f12835i0
            int r1 = r0.length
            if (r10 >= r1) goto L4a
            r10 = r0[r10]
            r7.f12839f0 = r10
        L4a:
            int r10 = com.google.android.material.R$styleable.f12573i5
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L5c
            boolean r10 = r9.getBoolean(r10, r6)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r7.f12840g0 = r10
        L5c:
            r9.recycle()
            r7.T(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.MaterialToolbar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
