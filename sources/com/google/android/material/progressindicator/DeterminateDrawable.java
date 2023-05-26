package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* loaded from: classes.dex */
public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {

    /* renamed from: z  reason: collision with root package name */
    private static final FloatPropertyCompat<DeterminateDrawable> f13810z = new FloatPropertyCompat<DeterminateDrawable>("indicatorLevel") { // from class: com.google.android.material.progressindicator.DeterminateDrawable.1
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: c */
        public float a(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.y() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: d */
        public void b(DeterminateDrawable determinateDrawable, float f8) {
            determinateDrawable.A(f8 / 10000.0f);
        }
    };

    /* renamed from: u  reason: collision with root package name */
    private DrawingDelegate<S> f13811u;

    /* renamed from: v  reason: collision with root package name */
    private final SpringForce f13812v;

    /* renamed from: w  reason: collision with root package name */
    private final SpringAnimation f13813w;

    /* renamed from: x  reason: collision with root package name */
    private float f13814x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f13815y;

    DeterminateDrawable(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec, @NonNull DrawingDelegate<S> drawingDelegate) {
        super(context, baseProgressIndicatorSpec);
        this.f13815y = false;
        z(drawingDelegate);
        SpringForce springForce = new SpringForce();
        this.f13812v = springForce;
        springForce.d(1.0f);
        springForce.f(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this, f13810z);
        this.f13813w = springAnimation;
        springAnimation.p(springForce);
        n(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(float f8) {
        this.f13814x = f8;
        invalidateSelf();
    }

    @NonNull
    public static DeterminateDrawable<CircularProgressIndicatorSpec> v(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, circularProgressIndicatorSpec, new CircularDrawingDelegate(circularProgressIndicatorSpec));
    }

    @NonNull
    public static DeterminateDrawable<LinearProgressIndicatorSpec> w(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, linearProgressIndicatorSpec, new LinearDrawingDelegate(linearProgressIndicatorSpec));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float y() {
        return this.f13814x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(float f8) {
        setLevel((int) (f8 * 10000.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f13811u.g(canvas, getBounds(), h());
            this.f13811u.c(canvas, this.f13829r);
            this.f13811u.b(canvas, this.f13829r, 0.0f, y(), MaterialColors.a(this.f13818g.f13783c[0], getAlpha()));
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f13811u.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f13811u.e();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f13813w.q();
        A(getLevel() / 10000.0f);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ void m(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        super.m(animatable2Compat$AnimationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i8) {
        if (this.f13815y) {
            this.f13813w.q();
            A(i8 / 10000.0f);
            return true;
        }
        this.f13813w.h(y() * 10000.0f);
        this.f13813w.l(i8);
        return true;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean q(boolean z7, boolean z8, boolean z9) {
        return super.q(z7, z8, z9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public boolean r(boolean z7, boolean z8, boolean z9) {
        boolean r7 = super.r(z7, z8, z9);
        float a8 = this.f13819h.a(this.f13817f.getContentResolver());
        if (a8 == 0.0f) {
            this.f13815y = true;
        } else {
            this.f13815y = false;
            this.f13812v.f(50.0f / a8);
        }
        return r7;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean s(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        return super.s(animatable2Compat$AnimationCallback);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i8) {
        super.setAlpha(i8);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z7, boolean z8) {
        return super.setVisible(z7, z8);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public DrawingDelegate<S> x() {
        return this.f13811u;
    }

    void z(@NonNull DrawingDelegate<S> drawingDelegate) {
        this.f13811u = drawingDelegate;
        drawingDelegate.f(this);
    }
}
