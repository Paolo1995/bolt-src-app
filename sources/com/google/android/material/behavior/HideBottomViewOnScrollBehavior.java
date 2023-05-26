package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: j  reason: collision with root package name */
    private static final int f12904j = R$attr.motionDurationLong2;

    /* renamed from: k  reason: collision with root package name */
    private static final int f12905k = R$attr.motionDurationMedium4;

    /* renamed from: l  reason: collision with root package name */
    private static final int f12906l = R$attr.motionEasingEmphasizedInterpolator;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashSet<OnScrollStateChangedListener> f12907a;

    /* renamed from: b  reason: collision with root package name */
    private int f12908b;

    /* renamed from: c  reason: collision with root package name */
    private int f12909c;

    /* renamed from: d  reason: collision with root package name */
    private TimeInterpolator f12910d;

    /* renamed from: e  reason: collision with root package name */
    private TimeInterpolator f12911e;

    /* renamed from: f  reason: collision with root package name */
    private int f12912f;

    /* renamed from: g  reason: collision with root package name */
    private int f12913g;

    /* renamed from: h  reason: collision with root package name */
    private int f12914h;

    /* renamed from: i  reason: collision with root package name */
    private ViewPropertyAnimator f12915i;

    /* loaded from: classes.dex */
    public interface OnScrollStateChangedListener {
        void a(@NonNull View view, int i8);
    }

    public HideBottomViewOnScrollBehavior() {
        this.f12907a = new LinkedHashSet<>();
        this.f12912f = 0;
        this.f12913g = 2;
        this.f12914h = 0;
    }

    private void F(@NonNull V v7, int i8, long j8, TimeInterpolator timeInterpolator) {
        this.f12915i = v7.animate().translationY(i8).setInterpolator(timeInterpolator).setDuration(j8).setListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.f12915i = null;
            }
        });
    }

    private void N(@NonNull V v7, int i8) {
        this.f12913g = i8;
        Iterator<OnScrollStateChangedListener> it = this.f12907a.iterator();
        while (it.hasNext()) {
            it.next().a(v7, this.f12913g);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, @NonNull View view2, int i8, int i9) {
        return i8 == 2;
    }

    public boolean G() {
        if (this.f12913g == 1) {
            return true;
        }
        return false;
    }

    public boolean H() {
        if (this.f12913g == 2) {
            return true;
        }
        return false;
    }

    public void I(@NonNull V v7, int i8) {
        this.f12914h = i8;
        if (this.f12913g == 1) {
            v7.setTranslationY(this.f12912f + i8);
        }
    }

    public void J(@NonNull V v7) {
        K(v7, true);
    }

    public void K(@NonNull V v7, boolean z7) {
        if (G()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f12915i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v7.clearAnimation();
        }
        N(v7, 1);
        int i8 = this.f12912f + this.f12914h;
        if (z7) {
            F(v7, i8, this.f12909c, this.f12911e);
        } else {
            v7.setTranslationY(i8);
        }
    }

    public void L(@NonNull V v7) {
        M(v7, true);
    }

    public void M(@NonNull V v7, boolean z7) {
        if (H()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f12915i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v7.clearAnimation();
        }
        N(v7, 2);
        if (z7) {
            F(v7, 0, this.f12908b, this.f12910d);
        } else {
            v7.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, int i8) {
        this.f12912f = v7.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v7.getLayoutParams()).bottomMargin;
        this.f12908b = MotionUtils.f(v7.getContext(), f12904j, 225);
        this.f12909c = MotionUtils.f(v7.getContext(), f12905k, 175);
        Context context = v7.getContext();
        int i9 = f12906l;
        this.f12910d = MotionUtils.g(context, i9, AnimationUtils.f12723d);
        this.f12911e = MotionUtils.g(v7.getContext(), i9, AnimationUtils.f12722c);
        return super.l(coordinatorLayout, v7, i8);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void t(CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8, int i9, int i10, int i11, int i12, @NonNull int[] iArr) {
        if (i9 > 0) {
            J(v7);
        } else if (i9 < 0) {
            L(v7);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12907a = new LinkedHashSet<>();
        this.f12912f = 0;
        this.f12913g = 2;
        this.f12914h = 0;
    }
}
