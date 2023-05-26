package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {

    /* renamed from: t  reason: collision with root package name */
    private static final int[] f13122t = {16842911};

    /* renamed from: u  reason: collision with root package name */
    private static final int[] f13123u = {16842912};

    /* renamed from: v  reason: collision with root package name */
    private static final int[] f13124v = {R$attr.state_dragged};

    /* renamed from: w  reason: collision with root package name */
    private static final int f13125w = R$style.Widget_MaterialComponents_CardView;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    private final MaterialCardViewHelper f13126o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f13127p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f13128q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f13129r;

    /* renamed from: s  reason: collision with root package name */
    private OnCheckedChangeListener f13130s;

    /* loaded from: classes.dex */
    public interface OnCheckedChangeListener {
        void a(MaterialCardView materialCardView, boolean z7);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialCardViewStyle);
    }

    private void f() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f13126o.k();
        }
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f13126o.l().getBounds());
        return rectF;
    }

    public boolean g() {
        MaterialCardViewHelper materialCardViewHelper = this.f13126o;
        if (materialCardViewHelper != null && materialCardViewHelper.F()) {
            return true;
        }
        return false;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f13126o.m();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f13126o.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f13126o.o();
    }

    public int getCheckedIconGravity() {
        return this.f13126o.p();
    }

    public int getCheckedIconMargin() {
        return this.f13126o.q();
    }

    public int getCheckedIconSize() {
        return this.f13126o.r();
    }

    public ColorStateList getCheckedIconTint() {
        return this.f13126o.s();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f13126o.C().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f13126o.C().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f13126o.C().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f13126o.C().top;
    }

    public float getProgress() {
        return this.f13126o.w();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f13126o.u();
    }

    public ColorStateList getRippleColor() {
        return this.f13126o.x();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f13126o.y();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f13126o.z();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f13126o.A();
    }

    public int getStrokeWidth() {
        return this.f13126o.B();
    }

    public boolean h() {
        return this.f13129r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i8, int i9, int i10, int i11) {
        super.d(i8, i9, i10, i11);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f13128q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.f(this, this.f13126o.l());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i8) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i8 + 3);
        if (g()) {
            View.mergeDrawableStates(onCreateDrawableState, f13122t);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f13123u);
        }
        if (h()) {
            View.mergeDrawableStates(onCreateDrawableState, f13124v);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(g());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        this.f13126o.K(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f13127p) {
            if (!this.f13126o.E()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f13126o.L(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i8) {
        this.f13126o.M(ColorStateList.valueOf(i8));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f8) {
        super.setCardElevation(f8);
        this.f13126o.h0();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.f13126o.N(colorStateList);
    }

    public void setCheckable(boolean z7) {
        this.f13126o.O(z7);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z7) {
        if (this.f13128q != z7) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f13126o.R(drawable);
    }

    public void setCheckedIconGravity(int i8) {
        if (this.f13126o.p() != i8) {
            this.f13126o.S(i8);
        }
    }

    public void setCheckedIconMargin(int i8) {
        this.f13126o.T(i8);
    }

    public void setCheckedIconMarginResource(int i8) {
        if (i8 != -1) {
            this.f13126o.T(getResources().getDimensionPixelSize(i8));
        }
    }

    public void setCheckedIconResource(int i8) {
        this.f13126o.R(AppCompatResources.b(getContext(), i8));
    }

    public void setCheckedIconSize(int i8) {
        this.f13126o.U(i8);
    }

    public void setCheckedIconSizeResource(int i8) {
        if (i8 != 0) {
            this.f13126o.U(getResources().getDimensionPixelSize(i8));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.f13126o.V(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z7) {
        super.setClickable(z7);
        MaterialCardViewHelper materialCardViewHelper = this.f13126o;
        if (materialCardViewHelper != null) {
            materialCardViewHelper.f0();
        }
    }

    public void setDragged(boolean z7) {
        if (this.f13129r != z7) {
            this.f13129r = z7;
            refreshDrawableState();
            f();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f8) {
        super.setMaxCardElevation(f8);
        this.f13126o.j0();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f13130s = onCheckedChangeListener;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z7) {
        super.setPreventCornerOverlap(z7);
        this.f13126o.j0();
        this.f13126o.g0();
    }

    public void setProgress(float f8) {
        this.f13126o.X(f8);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f8) {
        super.setRadius(f8);
        this.f13126o.W(f8);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f13126o.Y(colorStateList);
    }

    public void setRippleColorResource(int i8) {
        this.f13126o.Y(AppCompatResources.a(getContext(), i8));
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.u(getBoundsAsRectF()));
        this.f13126o.Z(shapeAppearanceModel);
    }

    public void setStrokeColor(int i8) {
        setStrokeColor(ColorStateList.valueOf(i8));
    }

    public void setStrokeWidth(int i8) {
        this.f13126o.b0(i8);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z7) {
        super.setUseCompatPadding(z7);
        this.f13126o.j0();
        this.f13126o.g0();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (g() && isEnabled()) {
            this.f13128q = !this.f13128q;
            refreshDrawableState();
            f();
            this.f13126o.Q(this.f13128q, true);
            OnCheckedChangeListener onCheckedChangeListener = this.f13130s;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.a(this, this.f13128q);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r6 = com.google.android.material.card.MaterialCardView.f13125w
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r8, r9, r10, r6)
            r7.<init>(r8, r9, r10)
            r8 = 0
            r7.f13128q = r8
            r7.f13129r = r8
            r0 = 1
            r7.f13127p = r0
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.f12669t4
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            r4 = r6
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.i(r0, r1, r2, r3, r4, r5)
            com.google.android.material.card.MaterialCardViewHelper r0 = new com.google.android.material.card.MaterialCardViewHelper
            r0.<init>(r7, r9, r10, r6)
            r7.f13126o = r0
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r0.M(r9)
            int r9 = super.getContentPaddingLeft()
            int r10 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r2 = super.getContentPaddingBottom()
            r0.c0(r9, r10, r1, r2)
            r0.J(r8)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f13126o.M(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f13126o.a0(colorStateList);
        invalidate();
    }
}
