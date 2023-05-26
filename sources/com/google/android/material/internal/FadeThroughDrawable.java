package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class FadeThroughDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f13592a;

    /* renamed from: b  reason: collision with root package name */
    private final Drawable f13593b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f13594c;

    /* renamed from: d  reason: collision with root package name */
    private float f13595d;

    public void a(float f8) {
        if (this.f13595d != f8) {
            this.f13595d = f8;
            FadeThroughUtils.a(f8, this.f13594c);
            this.f13592a.setAlpha((int) (this.f13594c[0] * 255.0f));
            this.f13593b.setAlpha((int) (this.f13594c[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f13592a.draw(canvas);
        this.f13593b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f13592a.getIntrinsicHeight(), this.f13593b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f13592a.getIntrinsicWidth(), this.f13593b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.f13592a.getMinimumHeight(), this.f13593b.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.f13592a.getMinimumWidth(), this.f13593b.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.f13592a.isStateful() && !this.f13593b.isStateful()) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        if (this.f13595d <= 0.5f) {
            this.f13592a.setAlpha(i8);
            this.f13593b.setAlpha(0);
        } else {
            this.f13592a.setAlpha(0);
            this.f13593b.setAlpha(i8);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i8, int i9, int i10, int i11) {
        super.setBounds(i8, i9, i10, i11);
        this.f13592a.setBounds(i8, i9, i10, i11);
        this.f13593b.setBounds(i8, i9, i10, i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13592a.setColorFilter(colorFilter);
        this.f13593b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        boolean state = this.f13592a.setState(iArr);
        boolean state2 = this.f13593b.setState(iArr);
        if (!state && !state2) {
            return false;
        }
        return true;
    }
}
