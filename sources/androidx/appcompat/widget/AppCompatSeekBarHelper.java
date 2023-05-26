package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f1885d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1886e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f1887f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f1888g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1889h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1890i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.f1887f = null;
        this.f1888g = null;
        this.f1889h = false;
        this.f1890i = false;
        this.f1885d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1886e;
        if (drawable != null) {
            if (this.f1889h || this.f1890i) {
                Drawable r7 = DrawableCompat.r(drawable.mutate());
                this.f1886e = r7;
                if (this.f1889h) {
                    DrawableCompat.o(r7, this.f1887f);
                }
                if (this.f1890i) {
                    DrawableCompat.p(this.f1886e, this.f1888g);
                }
                if (this.f1886e.isStateful()) {
                    this.f1886e.setState(this.f1885d.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public void c(AttributeSet attributeSet, int i8) {
        super.c(attributeSet, i8);
        Context context = this.f1885d.getContext();
        int[] iArr = R$styleable.T;
        TintTypedArray v7 = TintTypedArray.v(context, attributeSet, iArr, i8, 0);
        SeekBar seekBar = this.f1885d;
        ViewCompat.q0(seekBar, seekBar.getContext(), iArr, attributeSet, v7.r(), i8, 0);
        Drawable h8 = v7.h(R$styleable.U);
        if (h8 != null) {
            this.f1885d.setThumb(h8);
        }
        j(v7.g(R$styleable.V));
        int i9 = R$styleable.X;
        if (v7.s(i9)) {
            this.f1888g = DrawableUtils.e(v7.k(i9, -1), this.f1888g);
            this.f1890i = true;
        }
        int i10 = R$styleable.W;
        if (v7.s(i10)) {
            this.f1887f = v7.c(i10);
            this.f1889h = true;
        }
        v7.w();
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        int i8;
        if (this.f1886e != null) {
            int max = this.f1885d.getMax();
            int i9 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1886e.getIntrinsicWidth();
                int intrinsicHeight = this.f1886e.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i8 = intrinsicWidth / 2;
                } else {
                    i8 = 1;
                }
                if (intrinsicHeight >= 0) {
                    i9 = intrinsicHeight / 2;
                }
                this.f1886e.setBounds(-i8, -i9, i8, i9);
                float width = ((this.f1885d.getWidth() - this.f1885d.getPaddingLeft()) - this.f1885d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f1885d.getPaddingLeft(), this.f1885d.getHeight() / 2);
                for (int i10 = 0; i10 <= max; i10++) {
                    this.f1886e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f1886e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1885d.getDrawableState())) {
            this.f1885d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f1886e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f1886e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1886e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1885d);
            DrawableCompat.m(drawable, ViewCompat.E(this.f1885d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1885d.getDrawableState());
            }
            f();
        }
        this.f1885d.invalidate();
    }
}
