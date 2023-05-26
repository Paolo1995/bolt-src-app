package ee.mtakso.driver.uicore.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlphaAnimatorHelper.kt */
/* loaded from: classes5.dex */
public final class AlphaAnimatorHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final AlphaAnimatorHelper f35720a = new AlphaAnimatorHelper();

    private AlphaAnimatorHelper() {
    }

    public static /* synthetic */ void b(AlphaAnimatorHelper alphaAnimatorHelper, View view, View view2, int i8, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            i8 = 750;
        }
        alphaAnimatorHelper.a(view, view2, i8);
    }

    public final void a(final View fadeInView, final View fadeOutView, int i8) {
        Intrinsics.f(fadeInView, "fadeInView");
        Intrinsics.f(fadeOutView, "fadeOutView");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(fadeInView, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(fadeOutView, "alpha", 1.0f, 0.0f);
        animatorSet.setDuration(i8);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: ee.mtakso.driver.uicore.utils.AlphaAnimatorHelper$crossFade$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.f(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.f(animation, "animation");
                fadeInView.setAlpha(1.0f);
                ViewExtKt.e(fadeOutView, false, 0, 2, null);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.f(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.f(animation, "animation");
                fadeInView.setAlpha(0.0f);
                ViewExtKt.e(fadeInView, false, 0, 3, null);
            }
        });
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }

    public final Animator c(View... views) {
        Intrinsics.f(views, "views");
        AnimatorSet animatorSet = new AnimatorSet();
        int length = views.length;
        Animator[] animatorArr = new Animator[length];
        for (int i8 = 0; i8 < length; i8++) {
            View view = views[i8];
            view.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            Intrinsics.e(ofFloat, "ofFloat(view, \"alpha\", 0f, 1f)");
            animatorArr[i8] = ofFloat;
        }
        animatorSet.setDuration(250L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether((Animator[]) Arrays.copyOf(animatorArr, length));
        animatorSet.start();
        return animatorSet;
    }

    public final Animator d(View... views) {
        Intrinsics.f(views, "views");
        AnimatorSet animatorSet = new AnimatorSet();
        int length = views.length;
        Animator[] animatorArr = new Animator[length];
        for (int i8 = 0; i8 < length; i8++) {
            final View view = views[i8];
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: ee.mtakso.driver.uicore.utils.AlphaAnimatorHelper$fadeOut$animators$1$1$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.f(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.f(animation, "animation");
                    view.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.f(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.f(animation, "animation");
                }
            });
            Unit unit = Unit.f50853a;
            Intrinsics.e(ofFloat, "ofFloat(views[it], \"alph…         })\n            }");
            animatorArr[i8] = ofFloat;
        }
        animatorSet.setDuration(250L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether((Animator[]) Arrays.copyOf(animatorArr, length));
        animatorSet.start();
        return animatorSet;
    }
}
