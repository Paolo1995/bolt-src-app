package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* renamed from: u  reason: collision with root package name */
    private Drawable f13600u;

    /* renamed from: v  reason: collision with root package name */
    private final Rect f13601v;

    /* renamed from: w  reason: collision with root package name */
    private final Rect f13602w;

    /* renamed from: x  reason: collision with root package name */
    private int f13603x;

    /* renamed from: y  reason: collision with root package name */
    protected boolean f13604y;

    /* renamed from: z  reason: collision with root package name */
    boolean f13605z;

    public ForegroundLinearLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f13600u;
        if (drawable != null) {
            if (this.f13605z) {
                this.f13605z = false;
                Rect rect = this.f13601v;
                Rect rect2 = this.f13602w;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f13604y) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f13603x, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f8, float f9) {
        super.drawableHotspotChanged(f8, f9);
        Drawable drawable = this.f13600u;
        if (drawable != null) {
            drawable.setHotspot(f8, f9);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f13600u;
        if (drawable != null && drawable.isStateful()) {
            this.f13600u.setState(getDrawableState());
        }
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f13600u;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f13603x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f13600u;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        this.f13605z = z7 | this.f13605z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        this.f13605z = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f13600u;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f13600u);
            }
            this.f13600u = drawable;
            this.f13605z = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f13603x == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i8) {
        if (this.f13603x != i8) {
            if ((8388615 & i8) == 0) {
                i8 |= 8388611;
            }
            if ((i8 & 112) == 0) {
                i8 |= 48;
            }
            this.f13603x = i8;
            if (i8 == 119 && this.f13600u != null) {
                this.f13600u.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f13600u) {
            return false;
        }
        return true;
    }

    public ForegroundLinearLayout(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f13601v = new Rect();
        this.f13602w = new Rect();
        this.f13603x = 119;
        this.f13604y = true;
        this.f13605z = false;
        TypedArray i9 = ThemeEnforcement.i(context, attributeSet, R$styleable.U2, i8, 0, new int[0]);
        this.f13603x = i9.getInt(R$styleable.W2, this.f13603x);
        Drawable drawable = i9.getDrawable(R$styleable.V2);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f13604y = i9.getBoolean(R$styleable.X2, true);
        i9.recycle();
    }
}
