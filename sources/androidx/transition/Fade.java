package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class Fade extends Visibility {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FadeAnimatorListener extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f7809a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f7810b = false;

        FadeAnimatorListener(View view) {
            this.f7809a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewUtils.g(this.f7809a, 1.0f);
            if (this.f7810b) {
                this.f7809a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewCompat.S(this.f7809a) && this.f7809a.getLayerType() == 0) {
                this.f7810b = true;
                this.f7809a.setLayerType(2, null);
            }
        }
    }

    public Fade(int i8) {
        q0(i8);
    }

    private Animator r0(final View view, float f8, float f9) {
        if (f8 == f9) {
            return null;
        }
        ViewUtils.g(view, f8);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ViewUtils.f7886b, f9);
        ofFloat.addListener(new FadeAnimatorListener(view));
        a(new TransitionListenerAdapter() { // from class: androidx.transition.Fade.1
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void d(@NonNull Transition transition) {
                ViewUtils.g(view, 1.0f);
                ViewUtils.a(view);
                transition.X(this);
            }
        });
        return ofFloat;
    }

    private static float s0(TransitionValues transitionValues, float f8) {
        Float f9;
        if (transitionValues != null && (f9 = (Float) transitionValues.f7875a.get("android:fade:transitionAlpha")) != null) {
            return f9.floatValue();
        }
        return f8;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void k(@NonNull TransitionValues transitionValues) {
        super.k(transitionValues);
        transitionValues.f7875a.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.c(transitionValues.f7876b)));
    }

    @Override // androidx.transition.Visibility
    public Animator m0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f8 = 0.0f;
        float s02 = s0(transitionValues, 0.0f);
        if (s02 != 1.0f) {
            f8 = s02;
        }
        return r0(view, f8, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator o0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.e(view);
        return r0(view, s0(transitionValues, 1.0f), 0.0f);
    }

    public Fade() {
    }
}
