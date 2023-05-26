package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* loaded from: classes.dex */
public class RippleDrawableCompat extends Drawable implements Shapeable, TintAwareDrawable {

    /* renamed from: f  reason: collision with root package name */
    private RippleDrawableCompatState f13899f;

    @Override // android.graphics.drawable.Drawable
    @NonNull
    /* renamed from: a */
    public RippleDrawableCompat mutate() {
        this.f13899f = new RippleDrawableCompatState(this.f13899f);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RippleDrawableCompatState rippleDrawableCompatState = this.f13899f;
        if (rippleDrawableCompatState.f13901b) {
            rippleDrawableCompatState.f13900a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f13899f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f13899f.f13900a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f13899f.f13900a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f13899f.f13900a.setState(iArr)) {
            onStateChange = true;
        }
        boolean f8 = RippleUtils.f(iArr);
        RippleDrawableCompatState rippleDrawableCompatState = this.f13899f;
        if (rippleDrawableCompatState.f13901b != f8) {
            rippleDrawableCompatState.f13901b = f8;
            return true;
        }
        return onStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f13899f.f13900a.setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13899f.f13900a.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f13899f.f13900a.setShapeAppearanceModel(shapeAppearanceModel);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i8) {
        this.f13899f.f13900a.setTint(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f13899f.f13900a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f13899f.f13900a.setTintMode(mode);
    }

    public RippleDrawableCompat(ShapeAppearanceModel shapeAppearanceModel) {
        this(new RippleDrawableCompatState(new MaterialShapeDrawable(shapeAppearanceModel)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class RippleDrawableCompatState extends Drawable.ConstantState {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        MaterialShapeDrawable f13900a;

        /* renamed from: b  reason: collision with root package name */
        boolean f13901b;

        public RippleDrawableCompatState(MaterialShapeDrawable materialShapeDrawable) {
            this.f13900a = materialShapeDrawable;
            this.f13901b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        /* renamed from: a */
        public RippleDrawableCompat newDrawable() {
            return new RippleDrawableCompat(new RippleDrawableCompatState(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public RippleDrawableCompatState(@NonNull RippleDrawableCompatState rippleDrawableCompatState) {
            this.f13900a = (MaterialShapeDrawable) rippleDrawableCompatState.f13900a.getConstantState().newDrawable();
            this.f13901b = rippleDrawableCompatState.f13901b;
        }
    }

    private RippleDrawableCompat(RippleDrawableCompatState rippleDrawableCompatState) {
        this.f13899f = rippleDrawableCompatState;
    }
}
