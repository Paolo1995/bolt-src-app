package ee.mtakso.driver.ui.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.View;
import ee.mtakso.driver.uicore.utils.Dimens;

/* loaded from: classes3.dex */
public class LceAnimator {
    @TargetApi(11)
    public static void a(final View view, final View view2, View view3, boolean z7) {
        if (view2.getVisibility() == 0) {
            view3.setVisibility(8);
            view.setVisibility(8);
            return;
        }
        view3.setVisibility(8);
        AnimatorSet animatorSet = new AnimatorSet();
        if (!z7) {
            animatorSet.playTogether(ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f));
            animatorSet.setDuration(500L);
        } else {
            animatorSet.playTogether(ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(view2, "translationY", Dimens.d(40), 0.0f), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(view, "translationY", 0.0f, -Dimens.d(40)));
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ee.mtakso.driver.ui.helper.LceAnimator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(8);
                view.setAlpha(1.0f);
                view.setY(0.0f);
                view2.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view2.setVisibility(0);
                view2.setAlpha(0.0f);
            }
        });
        animatorSet.start();
    }

    public static void b(View view, View view2, View view3) {
        view2.setVisibility(8);
        view3.setVisibility(8);
        view.setVisibility(0);
    }
}
