package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: f  reason: collision with root package name */
    Drawable f13640f;

    /* renamed from: g  reason: collision with root package name */
    Rect f13641g;

    /* renamed from: h  reason: collision with root package name */
    private Rect f13642h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13643i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13644j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13645k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13646l;

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f13641g != null && this.f13640f != null) {
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (this.f13643i) {
                this.f13642h.set(0, 0, width, this.f13641g.top);
                this.f13640f.setBounds(this.f13642h);
                this.f13640f.draw(canvas);
            }
            if (this.f13644j) {
                this.f13642h.set(0, height - this.f13641g.bottom, width, height);
                this.f13640f.setBounds(this.f13642h);
                this.f13640f.draw(canvas);
            }
            if (this.f13645k) {
                Rect rect = this.f13642h;
                Rect rect2 = this.f13641g;
                rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
                this.f13640f.setBounds(this.f13642h);
                this.f13640f.draw(canvas);
            }
            if (this.f13646l) {
                Rect rect3 = this.f13642h;
                Rect rect4 = this.f13641g;
                rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
                this.f13640f.setBounds(this.f13642h);
                this.f13640f.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f13640f;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f13640f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z7) {
        this.f13644j = z7;
    }

    public void setDrawLeftInsetForeground(boolean z7) {
        this.f13645k = z7;
    }

    public void setDrawRightInsetForeground(boolean z7) {
        this.f13646l = z7;
    }

    public void setDrawTopInsetForeground(boolean z7) {
        this.f13643i = z7;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f13640f = drawable;
    }
}
