package com.google.android.material.circularreveal;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.google.android.material.circularreveal.CircularRevealWidget;

/* loaded from: classes.dex */
public class CircularRevealFrameLayout extends FrameLayout implements CircularRevealWidget {
    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void a() {
        throw null;
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void b() {
        throw null;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        throw null;
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public int getCircularRevealScrimColor() {
        throw null;
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        throw null;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        throw null;
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealScrimColor(int i8) {
        throw null;
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setRevealInfo(CircularRevealWidget.RevealInfo revealInfo) {
        throw null;
    }
}
