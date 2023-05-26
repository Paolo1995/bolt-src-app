package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {

    /* renamed from: t  reason: collision with root package name */
    static final int f13762t = R$style.Widget_MaterialComponents_ProgressIndicator;

    /* renamed from: f  reason: collision with root package name */
    S f13763f;

    /* renamed from: g  reason: collision with root package name */
    private int f13764g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13765h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13766i;

    /* renamed from: j  reason: collision with root package name */
    private final int f13767j;

    /* renamed from: k  reason: collision with root package name */
    private final int f13768k;

    /* renamed from: l  reason: collision with root package name */
    private long f13769l;

    /* renamed from: m  reason: collision with root package name */
    AnimatorDurationScaleProvider f13770m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13771n;

    /* renamed from: o  reason: collision with root package name */
    private int f13772o;

    /* renamed from: p  reason: collision with root package name */
    private final Runnable f13773p;

    /* renamed from: q  reason: collision with root package name */
    private final Runnable f13774q;

    /* renamed from: r  reason: collision with root package name */
    private final Animatable2Compat$AnimationCallback f13775r;

    /* renamed from: s  reason: collision with root package name */
    private final Animatable2Compat$AnimationCallback f13776s;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseProgressIndicator(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        super(MaterialThemeOverlay.c(context, attributeSet, i8, f13762t), attributeSet, i8);
        this.f13769l = -1L;
        this.f13771n = false;
        this.f13772o = 4;
        this.f13773p = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.1
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.l();
            }
        };
        this.f13774q = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.2
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.k();
                BaseProgressIndicator.this.f13769l = -1L;
            }
        };
        this.f13775r = new Animatable2Compat$AnimationCallback() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.3
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback
            public void b(Drawable drawable) {
                BaseProgressIndicator.this.setIndeterminate(false);
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.p(baseProgressIndicator.f13764g, BaseProgressIndicator.this.f13765h);
            }
        };
        this.f13776s = new Animatable2Compat$AnimationCallback() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.4
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback
            public void b(Drawable drawable) {
                super.b(drawable);
                if (!BaseProgressIndicator.this.f13771n) {
                    BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                    baseProgressIndicator.setVisibility(baseProgressIndicator.f13772o);
                }
            }
        };
        Context context2 = getContext();
        this.f13763f = i(context2, attributeSet);
        TypedArray i10 = ThemeEnforcement.i(context2, attributeSet, R$styleable.S, i8, i9, new int[0]);
        this.f13767j = i10.getInt(R$styleable.X, -1);
        this.f13768k = Math.min(i10.getInt(R$styleable.V, -1), 1000);
        i10.recycle();
        this.f13770m = new AnimatorDurationScaleProvider();
        this.f13766i = true;
    }

    private DrawingDelegate<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().w();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).q(false, false, true);
        if (n()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f13768k > 0) {
            this.f13769l = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean n() {
        if ((getProgressDrawable() != null && getProgressDrawable().isVisible()) || (getIndeterminateDrawable() != null && getIndeterminateDrawable().isVisible())) {
            return false;
        }
        return true;
    }

    private void o() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().v().d(this.f13775r);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().m(this.f13776s);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().m(this.f13776s);
        }
    }

    private void r() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().s(this.f13776s);
            getIndeterminateDrawable().v().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().s(this.f13776s);
        }
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        if (isIndeterminate()) {
            return getIndeterminateDrawable();
        }
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f13763f.f13786f;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.f13763f.f13783c;
    }

    public int getShowAnimationBehavior() {
        return this.f13763f.f13785e;
    }

    public int getTrackColor() {
        return this.f13763f.f13784d;
    }

    public int getTrackCornerRadius() {
        return this.f13763f.f13782b;
    }

    public int getTrackThickness() {
        return this.f13763f.f13781a;
    }

    protected void h(boolean z7) {
        if (!this.f13766i) {
            return;
        }
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).q(s(), false, z7);
    }

    abstract S i(@NonNull Context context, @NonNull AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public void j() {
        boolean z7;
        if (getVisibility() != 0) {
            removeCallbacks(this.f13773p);
            return;
        }
        removeCallbacks(this.f13774q);
        long uptimeMillis = SystemClock.uptimeMillis() - this.f13769l;
        int i8 = this.f13768k;
        if (uptimeMillis >= i8) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.f13774q.run();
        } else {
            postDelayed(this.f13774q, i8 - uptimeMillis);
        }
    }

    boolean m() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() != 0) {
                    return false;
                }
                return true;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
        if (s()) {
            l();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f13774q);
        removeCallbacks(this.f13773p);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).i();
        r();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i8, int i9) {
        int e8;
        int d8;
        DrawingDelegate<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate == null) {
            return;
        }
        if (currentDrawingDelegate.e() < 0) {
            e8 = View.getDefaultSize(getSuggestedMinimumWidth(), i8);
        } else {
            e8 = currentDrawingDelegate.e() + getPaddingLeft() + getPaddingRight();
        }
        if (currentDrawingDelegate.d() < 0) {
            d8 = View.getDefaultSize(getSuggestedMinimumHeight(), i9);
        } else {
            d8 = currentDrawingDelegate.d() + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(e8, d8);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i8) {
        boolean z7;
        super.onVisibilityChanged(view, i8);
        if (i8 == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        h(z7);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i8) {
        super.onWindowVisibilityChanged(i8);
        h(false);
    }

    public void p(int i8, boolean z7) {
        if (isIndeterminate()) {
            if (getProgressDrawable() != null) {
                this.f13764g = i8;
                this.f13765h = z7;
                this.f13771n = true;
                if (getIndeterminateDrawable().isVisible() && this.f13770m.a(getContext().getContentResolver()) != 0.0f) {
                    getIndeterminateDrawable().v().f();
                    return;
                } else {
                    this.f13775r.b(getIndeterminateDrawable());
                    return;
                }
            }
            return;
        }
        super.setProgress(i8);
        if (getProgressDrawable() != null && !z7) {
            getProgressDrawable().jumpToCurrentState();
        }
    }

    public void q() {
        if (this.f13767j > 0) {
            removeCallbacks(this.f13773p);
            postDelayed(this.f13773p, this.f13767j);
            return;
        }
        this.f13773p.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        if (ViewCompat.V(this) && getWindowVisibility() == 0 && m()) {
            return true;
        }
        return false;
    }

    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider animatorDurationScaleProvider) {
        this.f13770m = animatorDurationScaleProvider;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f13819h = animatorDurationScaleProvider;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f13819h = animatorDurationScaleProvider;
        }
    }

    public void setHideAnimationBehavior(int i8) {
        this.f13763f.f13786f = i8;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z7) {
        if (z7 == isIndeterminate()) {
            return;
        }
        DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
        if (drawableWithAnimatedVisibilityChange != null) {
            drawableWithAnimatedVisibilityChange.i();
        }
        super.setIndeterminate(z7);
        DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
        if (drawableWithAnimatedVisibilityChange2 != null) {
            drawableWithAnimatedVisibilityChange2.q(s(), false, false);
        }
        if ((drawableWithAnimatedVisibilityChange2 instanceof IndeterminateDrawable) && s()) {
            ((IndeterminateDrawable) drawableWithAnimatedVisibilityChange2).v().g();
        }
        this.f13771n = false;
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (drawable instanceof IndeterminateDrawable) {
            ((DrawableWithAnimatedVisibilityChange) drawable).i();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.b(getContext(), R$attr.f12486p, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.f13763f.f13783c = iArr;
            getIndeterminateDrawable().v().c();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i8) {
        if (isIndeterminate()) {
            return;
        }
        p(i8, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else if (drawable instanceof DeterminateDrawable) {
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.i();
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.B(getProgress() / getMax());
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i8) {
        this.f13763f.f13785e = i8;
        invalidate();
    }

    public void setTrackColor(int i8) {
        S s7 = this.f13763f;
        if (s7.f13784d != i8) {
            s7.f13784d = i8;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i8) {
        S s7 = this.f13763f;
        if (s7.f13782b != i8) {
            s7.f13782b = Math.min(i8, s7.f13781a / 2);
        }
    }

    public void setTrackThickness(int i8) {
        S s7 = this.f13763f;
        if (s7.f13781a != i8) {
            s7.f13781a = i8;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i8) {
        if (i8 != 0 && i8 != 4 && i8 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f13772o = i8;
    }

    @Override // android.widget.ProgressBar
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
