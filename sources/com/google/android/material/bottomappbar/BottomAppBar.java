package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {

    /* renamed from: c0  reason: collision with root package name */
    private Integer f12936c0;

    /* renamed from: d0  reason: collision with root package name */
    private final MaterialShapeDrawable f12937d0;

    /* renamed from: e0  reason: collision with root package name */
    private Animator f12938e0;

    /* renamed from: f0  reason: collision with root package name */
    private Animator f12939f0;

    /* renamed from: g0  reason: collision with root package name */
    private int f12940g0;

    /* renamed from: h0  reason: collision with root package name */
    private int f12941h0;

    /* renamed from: i0  reason: collision with root package name */
    private int f12942i0;

    /* renamed from: j0  reason: collision with root package name */
    private final int f12943j0;

    /* renamed from: k0  reason: collision with root package name */
    private int f12944k0;

    /* renamed from: l0  reason: collision with root package name */
    private int f12945l0;

    /* renamed from: m0  reason: collision with root package name */
    private final boolean f12946m0;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f12947n0;

    /* renamed from: o0  reason: collision with root package name */
    private int f12948o0;

    /* renamed from: p0  reason: collision with root package name */
    private ArrayList<AnimationListener> f12949p0;

    /* renamed from: q0  reason: collision with root package name */
    private int f12950q0;

    /* renamed from: r0  reason: collision with root package name */
    private boolean f12951r0;

    /* renamed from: s0  reason: collision with root package name */
    private boolean f12952s0;

    /* renamed from: t0  reason: collision with root package name */
    private Behavior f12953t0;

    /* renamed from: u0  reason: collision with root package name */
    private int f12954u0;

    /* renamed from: v0  reason: collision with root package name */
    private int f12955v0;

    /* renamed from: w0  reason: collision with root package name */
    private int f12956w0;
    @NonNull

    /* renamed from: x0  reason: collision with root package name */
    AnimatorListenerAdapter f12957x0;
    @NonNull

    /* renamed from: y0  reason: collision with root package name */
    TransformationCallback<FloatingActionButton> f12958y0;

    /* renamed from: z0  reason: collision with root package name */
    private static final int f12935z0 = R$style.Widget_MaterialComponents_BottomAppBar;
    private static final int A0 = R$attr.motionDurationLong2;
    private static final int B0 = R$attr.motionEasingEmphasizedInterpolator;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface AnimationListener {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: h  reason: collision with root package name */
        int f12979h;

        /* renamed from: i  reason: collision with root package name */
        boolean f12980i;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f12979h);
            parcel.writeInt(this.f12980i ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f12979h = parcel.readInt();
            this.f12980i = parcel.readInt() != 0;
        }
    }

    private void A0(int i8, boolean z7) {
        if (!ViewCompat.W(this)) {
            this.f12951r0 = false;
            D0(this.f12950q0);
            return;
        }
        Animator animator = this.f12939f0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!y0()) {
            i8 = 0;
            z7 = false;
        }
        r0(i8, z7, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f12939f0 = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                BottomAppBar.this.s0();
                BottomAppBar.this.f12951r0 = false;
                BottomAppBar.this.f12939f0 = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                BottomAppBar.this.t0();
            }
        });
        this.f12939f0.start();
    }

    private void B0(int i8) {
        if (this.f12940g0 != i8 && ViewCompat.W(this)) {
            Animator animator = this.f12938e0;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.f12941h0 == 1) {
                q0(i8, arrayList);
            } else {
                p0(i8, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setInterpolator(MotionUtils.g(getContext(), B0, AnimationUtils.f12720a));
            this.f12938e0 = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    BottomAppBar.this.s0();
                    BottomAppBar.this.f12938e0 = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    BottomAppBar.this.t0();
                }
            });
            this.f12938e0.start();
        }
    }

    private Drawable C0(Drawable drawable) {
        if (drawable != null && this.f12936c0 != null) {
            Drawable r7 = DrawableCompat.r(drawable.mutate());
            DrawableCompat.n(r7, this.f12936c0.intValue());
            return r7;
        }
        return drawable;
    }

    private void E0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.f12939f0 == null) {
            actionMenuView.setAlpha(1.0f);
            if (!y0()) {
                I0(actionMenuView, 0, false);
            } else {
                I0(actionMenuView, this.f12940g0, this.f12952s0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        float f8;
        getTopEdgeTreatment().n(getFabTranslationX());
        MaterialShapeDrawable materialShapeDrawable = this.f12937d0;
        if (this.f12952s0 && y0() && this.f12942i0 == 1) {
            f8 = 1.0f;
        } else {
            f8 = 0.0f;
        }
        materialShapeDrawable.d0(f8);
        View v02 = v0();
        if (v02 != null) {
            v02.setTranslationY(getFabTranslationY());
            v02.setTranslationX(getFabTranslationX());
        }
    }

    private void I0(@NonNull ActionMenuView actionMenuView, int i8, boolean z7) {
        J0(actionMenuView, i8, z7, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(@NonNull final ActionMenuView actionMenuView, final int i8, final boolean z7, boolean z8) {
        Runnable runnable = new Runnable() { // from class: com.google.android.material.bottomappbar.BottomAppBar.8
            @Override // java.lang.Runnable
            public void run() {
                ActionMenuView actionMenuView2 = actionMenuView;
                actionMenuView2.setTranslationX(BottomAppBar.this.w0(actionMenuView2, i8, z7));
            }
        };
        if (z8) {
            actionMenuView.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K0(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        layoutParams.f5457d = 17;
        int i8 = bottomAppBar.f12942i0;
        if (i8 == 1) {
            layoutParams.f5457d = 17 | 48;
        }
        if (i8 == 0) {
            layoutParams.f5457d |= 80;
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f12954u0;
    }

    private int getFabAlignmentAnimationDuration() {
        return MotionUtils.f(getContext(), A0, 300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return x0(this.f12940g0);
    }

    private float getFabTranslationY() {
        if (this.f12942i0 == 1) {
            return -getTopEdgeTreatment().c();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f12956w0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f12955v0;
    }

    @NonNull
    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.f12937d0.F().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.f12957x0);
        floatingActionButton.f(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.f12957x0.onAnimationStart(animator);
                FloatingActionButton u02 = BottomAppBar.this.u0();
                if (u02 != null) {
                    u02.setTranslationX(BottomAppBar.this.getFabTranslationX());
                }
            }
        });
        floatingActionButton.g(this.f12958y0);
    }

    private void o0() {
        Animator animator = this.f12939f0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f12938e0;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void q0(int i8, @NonNull List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(u0(), "translationX", x0(i8));
        ofFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(ofFloat);
    }

    private void r0(final int i8, final boolean z7, @NonNull List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        ofFloat.setDuration(0.8f * fabAlignmentAnimationDuration);
        if (Math.abs(actionMenuView.getTranslationX() - w0(actionMenuView, i8, z7)) > 1.0f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.setDuration(fabAlignmentAnimationDuration * 0.2f);
            ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.7

                /* renamed from: a  reason: collision with root package name */
                public boolean f12964a;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.f12964a = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    boolean z8;
                    if (!this.f12964a) {
                        if (BottomAppBar.this.f12950q0 != 0) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        BottomAppBar bottomAppBar = BottomAppBar.this;
                        bottomAppBar.D0(bottomAppBar.f12950q0);
                        BottomAppBar.this.J0(actionMenuView, i8, z7, z8);
                    }
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        } else if (actionMenuView.getAlpha() < 1.0f) {
            list.add(ofFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        ArrayList<AnimationListener> arrayList;
        int i8 = this.f12948o0 - 1;
        this.f12948o0 = i8;
        if (i8 == 0 && (arrayList = this.f12949p0) != null) {
            Iterator<AnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        ArrayList<AnimationListener> arrayList;
        int i8 = this.f12948o0;
        this.f12948o0 = i8 + 1;
        if (i8 == 0 && (arrayList = this.f12949p0) != null) {
            Iterator<AnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton u0() {
        View v02 = v0();
        if (v02 instanceof FloatingActionButton) {
            return (FloatingActionButton) v02;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View v0() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.t(r4)
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L2c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L18
        L2c:
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.v0():android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float x0(int i8) {
        int i9;
        int i10;
        boolean f8 = ViewUtils.f(this);
        int i11 = 1;
        if (i8 == 1) {
            View v02 = v0();
            if (f8) {
                i9 = this.f12956w0;
            } else {
                i9 = this.f12955v0;
            }
            if (this.f12944k0 != -1 && v02 != null) {
                i10 = (v02.getMeasuredWidth() / 2) + this.f12944k0;
            } else {
                i10 = this.f12943j0;
            }
            int measuredWidth = (getMeasuredWidth() / 2) - (i9 + i10);
            if (f8) {
                i11 = -1;
            }
            return measuredWidth * i11;
        }
        return 0.0f;
    }

    private boolean y0() {
        FloatingActionButton u02 = u0();
        if (u02 != null && u02.o()) {
            return true;
        }
        return false;
    }

    public void D0(int i8) {
        if (i8 != 0) {
            this.f12950q0 = 0;
            getMenu().clear();
            x(i8);
        }
    }

    public void G0(int i8, int i9) {
        this.f12950q0 = i9;
        this.f12951r0 = true;
        A0(i8, this.f12952s0);
        B0(i8);
        this.f12940g0 = i8;
    }

    boolean H0(int i8) {
        float f8 = i8;
        if (f8 != getTopEdgeTreatment().h()) {
            getTopEdgeTreatment().m(f8);
            this.f12937d0.invalidateSelf();
            return true;
        }
        return false;
    }

    public ColorStateList getBackgroundTint() {
        return this.f12937d0.J();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.f12940g0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f12944k0;
    }

    public int getFabAnchorMode() {
        return this.f12942i0;
    }

    public int getFabAnimationMode() {
        return this.f12941h0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().e();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f();
    }

    public boolean getHideOnScroll() {
        return this.f12947n0;
    }

    public int getMenuAlignmentMode() {
        return this.f12945l0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.f(this, this.f12937d0);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        if (z7) {
            o0();
            F0();
            final View v02 = v0();
            if (v02 != null && ViewCompat.W(v02)) {
                v02.post(new Runnable() { // from class: com.google.android.material.bottomappbar.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        v02.requestLayout();
                    }
                });
            }
        }
        E0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f12940g0 = savedState.f12979h;
        this.f12952s0 = savedState.f12980i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12979h = this.f12940g0;
        savedState.f12980i = this.f12952s0;
        return savedState;
    }

    protected void p0(final int i8, List<Animator> list) {
        FloatingActionButton u02 = u0();
        if (u02 != null && !u02.n()) {
            t0();
            u02.l(new FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5
                @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                public void a(@NonNull FloatingActionButton floatingActionButton) {
                    floatingActionButton.setTranslationX(BottomAppBar.this.x0(i8));
                    floatingActionButton.r(new FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5.1
                        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                        public void b(FloatingActionButton floatingActionButton2) {
                            BottomAppBar.this.s0();
                        }
                    });
                }
            });
        }
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        DrawableCompat.o(this.f12937d0, colorStateList);
    }

    public void setCradleVerticalOffset(float f8) {
        if (f8 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().i(f8);
            this.f12937d0.invalidateSelf();
            F0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        this.f12937d0.b0(f8);
        getBehavior().I(this, this.f12937d0.E() - this.f12937d0.D());
    }

    public void setFabAlignmentMode(int i8) {
        G0(i8, 0);
    }

    public void setFabAlignmentModeEndMargin(int i8) {
        if (this.f12944k0 != i8) {
            this.f12944k0 = i8;
            F0();
        }
    }

    public void setFabAnchorMode(int i8) {
        this.f12942i0 = i8;
        F0();
        View v02 = v0();
        if (v02 != null) {
            K0(this, v02);
            v02.requestLayout();
            this.f12937d0.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i8) {
        this.f12941h0 = i8;
    }

    void setFabCornerSize(float f8) {
        if (f8 != getTopEdgeTreatment().d()) {
            getTopEdgeTreatment().j(f8);
            this.f12937d0.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f8) {
        if (f8 != getFabCradleMargin()) {
            getTopEdgeTreatment().k(f8);
            this.f12937d0.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f8) {
        if (f8 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().l(f8);
            this.f12937d0.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z7) {
        this.f12947n0 = z7;
    }

    public void setMenuAlignmentMode(int i8) {
        if (this.f12945l0 != i8) {
            this.f12945l0 = i8;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                I0(actionMenuView, this.f12940g0, y0());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(C0(drawable));
    }

    public void setNavigationIconTint(int i8) {
        this.f12936c0 = Integer.valueOf(i8);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    protected int w0(@NonNull ActionMenuView actionMenuView, int i8, boolean z7) {
        int i9;
        int left;
        int i10;
        boolean z8;
        int i11 = 0;
        if (this.f12945l0 != 1 && (i8 != 1 || !z7)) {
            return 0;
        }
        boolean f8 = ViewUtils.f(this);
        if (f8) {
            i9 = getMeasuredWidth();
        } else {
            i9 = 0;
        }
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f1086a & 8388615) == 8388611) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (f8) {
                    i9 = Math.min(i9, childAt.getLeft());
                } else {
                    i9 = Math.max(i9, childAt.getRight());
                }
            }
        }
        if (f8) {
            left = actionMenuView.getRight();
        } else {
            left = actionMenuView.getLeft();
        }
        if (f8) {
            i10 = this.f12955v0;
        } else {
            i10 = -this.f12956w0;
        }
        if (getNavigationIcon() == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.m3_bottomappbar_horizontal_padding);
            if (f8) {
                i11 = dimensionPixelOffset;
            } else {
                i11 = -dimensionPixelOffset;
            }
        }
        return i9 - ((left + i10) + i11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.f12953t0 == null) {
            this.f12953t0 = new Behavior();
        }
        return this.f12953t0;
    }

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        @NonNull

        /* renamed from: m  reason: collision with root package name */
        private final Rect f12974m;

        /* renamed from: n  reason: collision with root package name */
        private WeakReference<BottomAppBar> f12975n;

        /* renamed from: o  reason: collision with root package name */
        private int f12976o;

        /* renamed from: p  reason: collision with root package name */
        private final View.OnLayoutChangeListener f12977p;

        public Behavior() {
            this.f12977p = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                    BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f12975n.get();
                    if (bottomAppBar != null && ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                        int height = view.getHeight();
                        if (view instanceof FloatingActionButton) {
                            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                            floatingActionButton.j(Behavior.this.f12974m);
                            int height2 = Behavior.this.f12974m.height();
                            bottomAppBar.H0(height2);
                            bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f12974m)));
                            height = height2;
                        }
                        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                        if (Behavior.this.f12976o == 0) {
                            int measuredHeight = (view.getMeasuredHeight() - height) / 2;
                            if (bottomAppBar.f12942i0 == 1) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - measuredHeight);
                            } else if (bottomAppBar.f12942i0 == 0) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ((bottomAppBar.getMeasuredHeight() + bottomAppBar.getBottomInset()) - view.getMeasuredHeight()) / 2;
                            }
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                            if (ViewUtils.f(view)) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.f12943j0;
                                return;
                            } else {
                                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.f12943j0;
                                return;
                            }
                        }
                        return;
                    }
                    view.removeOnLayoutChangeListener(this);
                }
            };
            this.f12974m = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: R */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i8) {
            this.f12975n = new WeakReference<>(bottomAppBar);
            View v02 = bottomAppBar.v0();
            if (v02 != null && !ViewCompat.W(v02)) {
                BottomAppBar.K0(bottomAppBar, v02);
                this.f12976o = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) v02.getLayoutParams())).bottomMargin;
                if (v02 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) v02;
                    if (bottomAppBar.f12942i0 == 0 && bottomAppBar.f12946m0) {
                        ViewCompat.A0(floatingActionButton, 0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R$animator.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R$animator.mtrl_fab_hide_motion_spec);
                    }
                    bottomAppBar.n0(floatingActionButton);
                }
                v02.addOnLayoutChangeListener(this.f12977p);
                bottomAppBar.F0();
            }
            coordinatorLayout.J(bottomAppBar, i8);
            return super.l(coordinatorLayout, bottomAppBar, i8);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: S */
        public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i8, int i9) {
            if (bottomAppBar.getHideOnScroll() && super.A(coordinatorLayout, bottomAppBar, view, view2, i8, i9)) {
                return true;
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12977p = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                    BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f12975n.get();
                    if (bottomAppBar != null && ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                        int height = view.getHeight();
                        if (view instanceof FloatingActionButton) {
                            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                            floatingActionButton.j(Behavior.this.f12974m);
                            int height2 = Behavior.this.f12974m.height();
                            bottomAppBar.H0(height2);
                            bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f12974m)));
                            height = height2;
                        }
                        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                        if (Behavior.this.f12976o == 0) {
                            int measuredHeight = (view.getMeasuredHeight() - height) / 2;
                            if (bottomAppBar.f12942i0 == 1) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - measuredHeight);
                            } else if (bottomAppBar.f12942i0 == 0) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ((bottomAppBar.getMeasuredHeight() + bottomAppBar.getBottomInset()) - view.getMeasuredHeight()) / 2;
                            }
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                            if (ViewUtils.f(view)) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.f12943j0;
                                return;
                            } else {
                                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.f12943j0;
                                return;
                            }
                        }
                        return;
                    }
                    view.removeOnLayoutChangeListener(this);
                }
            };
            this.f12974m = new Rect();
        }
    }
}
